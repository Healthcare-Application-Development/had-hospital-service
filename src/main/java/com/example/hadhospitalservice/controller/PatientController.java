package com.example.hadhospitalservice.controller;

import com.example.hadhospitalservice.bean.Patient;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.interfaces.PatientInterface;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/patient")
public class PatientController {
    final PatientInterface patientInterface;

    public PatientController(PatientInterface patientInterface) {
        this.patientInterface = patientInterface;
    }

    @PostMapping("/add")
    public Response addPatient(@RequestBody Patient patient) {
        return patientInterface.addPatient(patient);
    }

    @GetMapping("/getAll")
    public Response getAllPatients() {
        return patientInterface.getAllPatients();
    }

    @PostMapping("/login")
    public Response login(@RequestBody Patient patient) {
        return patientInterface.login(patient);
    }

    @PostMapping("/getByEmail/{abhaID}")
    public Response getByAbhaID(@PathVariable("abhaID") String abhaID) {
        return patientInterface.getPatientByABHAID(abhaID);
    }
}
