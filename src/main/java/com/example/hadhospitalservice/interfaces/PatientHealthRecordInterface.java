package com.example.hadhospitalservice.interfaces;

import com.example.hadhospitalservice.bean.Doctor;
import com.example.hadhospitalservice.bean.PatientHealthRecord;
import com.example.hadhospitalservice.bean.Response;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientHealthRecordInterface {

    ResponseEntity<List<PatientHealthRecord>> getPatientHealthRecordByAbhaIdAndRecordType(String abhaId, String recordType);
    ResponseEntity<PatientHealthRecord> addPatientHealthRecord(PatientHealthRecord patientHealthRecord);
    ResponseEntity<PatientHealthRecord> getPatientHealthRecordByAbhaId(String abhaId);
    Response getAllPatientHealthRecord();
}
