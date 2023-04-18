package com.example.hadhospitalservice.controller;

import com.example.hadhospitalservice.bean.Patient;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.interfaces.PatientInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/patient")
public class PatientController {
    final PatientInterface patientInterface;

    public PatientController(PatientInterface patientInterface) {
        this.patientInterface = patientInterface;
    }

    @PostMapping("/add")
    public ResponseEntity<Response> addPatient(@RequestBody Patient patient) {
        return patientInterface.addPatient(patient);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Response> getAllPatients() {
        return patientInterface.getAllPatients();
    }

    @PostMapping("/getByEmail/{abhaID}")
    public ResponseEntity<Response> getByAbhaID(@PathVariable("abhaID") String abhaID) {
        return patientInterface.getPatientByABHAID(abhaID);
    }
}
