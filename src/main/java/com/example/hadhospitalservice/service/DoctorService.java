package com.example.hadhospitalservice.service;

import com.example.hadhospitalservice.bean.Doctor;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.interfaces.DoctorInterface;
import com.example.hadhospitalservice.repository.DoctorRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService implements DoctorInterface {
    @Value("${bcrypt.hash}")
    private String hash;
    final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    @Override
    public Response addDoctor(Doctor doctor) {
        String hashedPassword = BCrypt.hashpw(doctor.getPassword(),hash);
        doctor.setPassword(hashedPassword);
        Doctor savedDoctor = doctorRepository.save(doctor);
        savedDoctor.setPassword(null);
        return new Response(savedDoctor, 200);
    }

    @Override
    public Response getAllDoctors() {
        List<Doctor> doctorList = doctorRepository.findAll();
        for (int i = 0; i < doctorList.size(); i++) {
            doctorList.get(i).setPassword(null);
        }
        return new Response(doctorList, 200);
    }

    @Override
    public Response login(Doctor doctor) {
        String hashedPassword = BCrypt.hashpw(doctor.getPassword(), hash);
        Doctor retrievedDoctor = doctorRepository.findByEmailAndPassword(doctor.getEmail(), hashedPassword);
        if (retrievedDoctor == null) {
            return new Response(null, 400);
        }
        retrievedDoctor.setPassword(null);
        return new Response(retrievedDoctor, 200);
    }

    @Override
    public Response getDoctorByNPCIID(String npciID) {
        Doctor doctor = doctorRepository.findByNpciID(npciID);
        if (doctor == null) {
            return new Response(null, 400);
        }
        doctor.setPassword(null);
        return new Response(doctor, 200);
    }
}
