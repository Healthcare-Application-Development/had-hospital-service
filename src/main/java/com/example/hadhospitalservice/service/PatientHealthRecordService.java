package com.example.hadhospitalservice.service;

import com.example.hadhospitalservice.bean.Doctor;
import com.example.hadhospitalservice.bean.Patient;
import com.example.hadhospitalservice.bean.PatientHealthRecord;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.interfaces.PatientHealthRecordInterface;
import com.example.hadhospitalservice.repository.PatientHealthRecordRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PatientHealthRecordService implements PatientHealthRecordInterface {


    final PatientHealthRecordRepository patientHealthRecordRepository;

    public PatientHealthRecordService(PatientHealthRecordRepository patientHealthRecordRepository) {
        this.patientHealthRecordRepository = patientHealthRecordRepository;
    }



        @Override
    public ResponseEntity<PatientHealthRecord> addPatientHealthRecord(PatientHealthRecord patientHealthRecord) {
        PatientHealthRecord patientRecordInput = patientHealthRecordRepository.save(patientHealthRecord);
            return new ResponseEntity<PatientHealthRecord>(patientRecordInput, HttpStatus.OK);
    }


        @Override
    public ResponseEntity<PatientHealthRecord> getPatientHealthRecordByAbhaID(Integer abhaID) {
        PatientHealthRecord patientHealthRecord = patientHealthRecordRepository.findByAbhaID(abhaID);
        if (patientHealthRecord == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
            return new ResponseEntity<PatientHealthRecord>(patientHealthRecord, HttpStatus.OK);
    }

    @Override
    public Response getAllPatientHealthRecord() {
        List<PatientHealthRecord> patientHealthRecord = patientHealthRecordRepository.findAll();
        for (int i = 0; i < patientHealthRecord.size(); i++) {
            patientHealthRecord.get(i);
        }
        return new Response(patientHealthRecord, 200);
    }

}

