package com.example.hadhospitalservice.controller;

import com.example.hadhospitalservice.bean.Doctor;
import com.example.hadhospitalservice.bean.Patient;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.interfaces.DoctorInterface;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctor")
public class DoctorController {
    final DoctorInterface doctorInterface;

    public DoctorController(DoctorInterface doctorInterface) {
        this.doctorInterface = doctorInterface;
    }

    @PostMapping("/add")
    public Response addDoctor(@RequestBody Doctor doctor) {
        return doctorInterface.addDoctor(doctor);
    }

    @GetMapping("/getAll")
    public Response getAllDoctors() {
        return doctorInterface.getAllDoctors();
    }

    @PostMapping("/login")
    public Response login(@RequestBody Doctor doctor) {
        return doctorInterface.login(doctor);
    }

    @PostMapping("/getByEmail/{npciID}")
    public Response getByNpciID(@PathVariable("abhaID") String npciID) {
        return doctorInterface.getDoctorByNPCIID(npciID);
    }
}
