package com.example.hadhospitalservice.interfaces;

import com.example.hadhospitalservice.bean.Doctor;
import com.example.hadhospitalservice.bean.PatientHealthRecord;
import com.example.hadhospitalservice.bean.Response;
import org.springframework.http.ResponseEntity;

public interface PatientHealthRecordInterface {

    ResponseEntity<PatientHealthRecord> addPatientHealthRecord(PatientHealthRecord patientHealthRecord);
    ResponseEntity<PatientHealthRecord> getPatientHealthRecordByAbhaID(Integer abhaID);

    Response getAllPatientHealthRecord();
}
