package com.example.hadhospitalservice.interfaces;

import com.example.hadhospitalservice.bean.Patient;
import com.example.hadhospitalservice.bean.Response;

public interface PatientInterface {
    Response addPatient(Patient patient);
    Response getAllPatients();
    Response login(Patient patient);
    Response getPatientByABHAID(String abhaID);
}
