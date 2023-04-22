package com.example.hadhospitalservice.service;

import com.example.hadhospitalservice.bean.*;
import com.example.hadhospitalservice.interfaces.PatientHealthRecordInterface;
import com.example.hadhospitalservice.repository.PatientHealthRecordDetailsRepository;
import com.example.hadhospitalservice.repository.PatientHealthRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PatientHealthRecordService implements PatientHealthRecordInterface {

    @Autowired
    private Environment env;

//    @Autowired
    final PatientHealthRecordRepository patientHealthRecordRepository;
    final PatientHealthRecordDetailsRepository patientHealthRecordDetailsRepository;
    public PatientHealthRecordService(PatientHealthRecordRepository patientHealthRecordRepository, PatientHealthRecordDetailsRepository patientHealthRecordDetailsRepository) {
        this.patientHealthRecordRepository = patientHealthRecordRepository;
        this.patientHealthRecordDetailsRepository = patientHealthRecordDetailsRepository;
    }
    @Override
    public ResponseEntity<List<PatientHealthRecord>> getPatientHealthRecordByAbhaIdAndRecordType(RequestPatientHealthRecord requestPatientHealthRecord) {

        List<PatientHealthRecord> patientHealthRecord = patientHealthRecordRepository.getPatientHealthRecordByAbhaIdAndRecordType(requestPatientHealthRecord.getAbhaId(),requestPatientHealthRecord.getRecordType());
        if (patientHealthRecord == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            PatientHealthRecordDetails patientHealthRecordDetails= new PatientHealthRecordDetails();
            patientHealthRecordDetails.setAbhaId(requestPatientHealthRecord.getAbhaId());
            patientHealthRecordDetails.setArtifactId(requestPatientHealthRecord.getArtifactId());
            patientHealthRecordDetails.setConsentId(requestPatientHealthRecord.getConsentId());
            patientHealthRecordDetails.setRequestTimestamp(new Date());
            String hospitalName = env.getProperty("hospitalName");
            patientHealthRecordDetails.setHospitalName(hospitalName);
            Set<String> setOfRecords = new HashSet<>();

            for (int i = 0; i < patientHealthRecord.size(); i++) {
                patientHealthRecord.get(i).setHospitalName(hospitalName);
                setOfRecords.add(patientHealthRecord.get(i).getRecordType());
            }
            String setOfRecordsAsString = String.join(",", setOfRecords);
            patientHealthRecordDetails.setListOfRecordType(setOfRecordsAsString);
            PatientHealthRecordDetails patientRecordInput = patientHealthRecordDetailsRepository.save(patientHealthRecordDetails);

            return new ResponseEntity<List<PatientHealthRecord>>(patientHealthRecord, HttpStatus.OK);

        }
    }

    @Override
    public ResponseEntity<PatientHealthRecord> addPatientHealthRecord(PatientHealthRecord patientHealthRecord) {
        PatientHealthRecord patientRecordInput = patientHealthRecordRepository.save(patientHealthRecord);
        return new ResponseEntity<PatientHealthRecord>(patientRecordInput, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PatientHealthRecord>> getPatientHealthRecordByAbhaId(Integer abhaId) {

        List<PatientHealthRecord> patientHealthRecord = patientHealthRecordRepository.getPatientHealthRecordByAbhaId(abhaId);
        if (patientHealthRecord == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {

            for (int i = 0; i < patientHealthRecord.size(); i++) {
                String hospitalName = env.getProperty("hospitalName");
                patientHealthRecord.get(i).setHospitalName(hospitalName);
            }
            return new ResponseEntity<List<PatientHealthRecord>>(patientHealthRecord, HttpStatus.OK);
        }
    }

    @Override
    public Response getAllPatientHealthRecord() {
        List<PatientHealthRecord> patientHealthRecord = patientHealthRecordRepository.findAll();
        return new Response(patientHealthRecord, 200);
    }

}

