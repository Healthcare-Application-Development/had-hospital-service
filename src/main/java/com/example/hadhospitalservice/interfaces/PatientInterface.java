package com.example.hadhospitalservice.interfaces;

import com.example.hadhospitalservice.bean.Patient;
import com.example.hadhospitalservice.bean.Response;
import org.springframework.http.ResponseEntity;

public interface PatientInterface {
    ResponseEntity<Response> addPatient(Patient patient);
    ResponseEntity<Response> getAllPatients();
    ResponseEntity<Response> getPatientByABHAID(String abhaID);
}
