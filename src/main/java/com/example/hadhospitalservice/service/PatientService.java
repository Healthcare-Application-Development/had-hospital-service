package com.example.hadhospitalservice.service;

import com.example.hadhospitalservice.bean.Patient;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.interfaces.PatientInterface;
import com.example.hadhospitalservice.repository.PatientRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService implements PatientInterface {

    @Value("${bcrypt.hash}")
    private String hash;
    final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    @Override
    public Response addPatient(Patient patient) {
        String hashedPassword = BCrypt.hashpw(patient.getPassword(), hash);
        patient.setPassword(hashedPassword);
        Patient savedPatient = patientRepository.save(patient);
        savedPatient.setPassword(null);
        return new Response(savedPatient, 200);
    }

    @Override
    public Response getAllPatients() {
        List<Patient> patientList = patientRepository.findAll();
        for (int i = 0; i < patientList.size(); i++) {
            patientList.get(i).setPassword(null);
        }
        return new Response(patientList, 200);
    }

    @Override
    public Response login(Patient patient) {
        String hashedPassword = BCrypt.hashpw(patient.getPassword(), hash);

        Patient retrievedPatient = patientRepository.findByAbhaIDAndPassword(patient.getAbhaID(), hashedPassword);
        if (retrievedPatient == null) {
            return new Response(null, 400);
        }
        retrievedPatient.setPassword(null);
        return new Response(retrievedPatient, 200);
    }

    @Override
    public Response getPatientByABHAID(String abhaID) {
        Patient patient = patientRepository.findByAbhaID(abhaID);
        if (patient == null) {
            return new Response(null, 400);
        }
        patient.setPassword(null);
        return new Response(patient, 200);
    }
}
