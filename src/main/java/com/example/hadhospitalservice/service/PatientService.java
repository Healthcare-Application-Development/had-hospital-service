package com.example.hadhospitalservice.service;

import com.example.hadhospitalservice.bean.Patient;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.interfaces.PatientInterface;
import com.example.hadhospitalservice.repository.PatientRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Response> addPatient(Patient patient) {
        try {
            Patient savedPatient = patientRepository.save(patient);
            return new ResponseEntity<>(new Response(savedPatient, 200), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public ResponseEntity<Response> getAllPatients() {
        List<Patient> patientList = patientRepository.findAll();
        for (int i = 0; i < patientList.size(); i++) {
            patientList.get(i).getLogin().setPassword(null);
        }
        return new ResponseEntity<>(new Response(patientList, 200), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Response> getPatientByABHAID(String abhaID) {
        Patient patient = patientRepository.findByAbhaID(abhaID);
        if (patient == null) {
            return new ResponseEntity<>(new Response(null, 404), HttpStatus.NOT_FOUND);
        }
        patient.getLogin().setPassword(null);
        return new ResponseEntity<>(new Response(patient, 200), HttpStatus.OK);
    }
}
