package com.example.hadhospitalservice.interfaces;


import com.example.hadhospitalservice.bean.Doctor;
import com.example.hadhospitalservice.bean.Response;
import org.springframework.http.ResponseEntity;

public interface DoctorInterface {
    ResponseEntity<Response> addDoctor(Doctor doctor);
    ResponseEntity<Response> getAllDoctors();
    ResponseEntity<Response> login(Doctor doctor);
    ResponseEntity<Response> getDoctorByNPCIID(String npciID);
}
