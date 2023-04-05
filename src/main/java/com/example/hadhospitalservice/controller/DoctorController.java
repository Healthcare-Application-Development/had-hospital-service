package com.example.hadhospitalservice.controller;

import com.example.hadhospitalservice.bean.Doctor;
import com.example.hadhospitalservice.bean.Patient;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.interfaces.DoctorInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/doctor")
public class DoctorController {
    final DoctorInterface doctorInterface;

    public DoctorController(DoctorInterface doctorInterface) {
        this.doctorInterface = doctorInterface;
    }

    @PostMapping("/add")
    public ResponseEntity<Response> addDoctor(@RequestBody Doctor doctor) {
        return doctorInterface.addDoctor(doctor);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Response> getAllDoctors() {
        return doctorInterface.getAllDoctors();
    }


    @PostMapping("/getByEmail/{npciID}")
    public ResponseEntity<Response> getByNpciID(@PathVariable("abhaID") String npciID) {
        return doctorInterface.getDoctorByNPCIID(npciID);
    }
}
