package com.example.hadhospitalservice.service;

import com.example.hadhospitalservice.bean.Doctor;
import com.example.hadhospitalservice.bean.Login;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.interfaces.DoctorInterface;
import com.example.hadhospitalservice.repository.DoctorRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Response> addDoctor(Doctor doctor) {
        try {
            Doctor savedDoctor = doctorRepository.save(doctor);
            return new ResponseEntity<>(new Response(savedDoctor, 200), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<Response> getAllDoctors() {
        List<Doctor> doctorList = doctorRepository.findAll();
        for (int i = 0; i < doctorList.size(); i++) {
            doctorList.get(i).getLogin().setPassword(null);
        }
        return new ResponseEntity<>(new Response(doctorList, 200), HttpStatus.OK);
    }



    @Override
    public ResponseEntity<Response> getDoctorByNPCIID(String npciID) {
        Doctor doctor = doctorRepository.findByNpciID(npciID);
        if (doctor == null) {
            return new ResponseEntity<>(new Response(null, 404), HttpStatus.NOT_FOUND);
        }
        doctor.getLogin().setPassword(null);
        return new ResponseEntity<>(new Response(doctor, 200), HttpStatus.OK);
    }
}
