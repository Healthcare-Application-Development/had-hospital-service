package com.example.hadhospitalservice.interfaces;


import com.example.hadhospitalservice.bean.Doctor;
import com.example.hadhospitalservice.bean.Response;

public interface DoctorInterface {
    Response addDoctor(Doctor doctor);
    Response getAllDoctors();
    Response login(Doctor doctor);
    Response getDoctorByNPCIID(String npciID);
}
