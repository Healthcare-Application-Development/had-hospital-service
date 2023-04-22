package com.example.hadhospitalservice.interfaces;

import com.example.hadhospitalservice.bean.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PatientHealthRecordInterface {

    ResponseEntity<List<PatientHealthRecord>> getPatientHealthRecordByAbhaIdAndRecordType(RequestPatientHealthRecord requestPatientHealthRecord);
    ResponseEntity<PatientHealthRecord> addPatientHealthRecord(PatientHealthRecord patientHealthRecord);
    ResponseEntity<List<PatientHealthRecord>> getPatientHealthRecordByAbhaId(String abhaId);
    Response getAllPatientHealthRecord();
}
