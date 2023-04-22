package com.example.hadhospitalservice.service;

import com.example.hadhospitalservice.bean.*;
import com.example.hadhospitalservice.bean.Doctor;
import com.example.hadhospitalservice.bean.Patient;
import com.example.hadhospitalservice.bean.PatientHealthRecord;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.encryption.AESUtils;
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
    AESUtils aesUtils;

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
            List<PatientHealthRecord> patientHealthRecord = patientHealthRecordRepository.getPatientHealthRecordByAbhaIdAndRecordType(requestPatientHealthRecord.getAbhaId(), requestPatientHealthRecord.getRecordType());
            if (patientHealthRecord == null) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            } else {
                PatientHealthRecordDetails patientHealthRecordDetails = new PatientHealthRecordDetails();
                try {
                    patientHealthRecordDetails.setAbhaId(aesUtils.encrypt(requestPatientHealthRecord.getAbhaId()));
                }
                catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                    patientHealthRecordDetails.setArtifactId(requestPatientHealthRecord.getArtifactId());
                    patientHealthRecordDetails.setConsentId(requestPatientHealthRecord.getConsentId());
                    patientHealthRecordDetails.setRequestTimestamp(new Date());
                    String hospitalName = env.getProperty("hospitalName");
                    patientHealthRecordDetails.setHospitalName(hospitalName);
                    Set<String> setOfRecords = new HashSet<>();
                    for (int i = 0; i < patientHealthRecord.size(); i++) {
                        patientHealthRecord.get(i).setHospitalName(hospitalName);
                        setOfRecords.add(patientHealthRecord.get(i).getRecordType());
                        try {
                            patientHealthRecord.get(i).setHospitalName(aesUtils.encrypt(hospitalName));
                        }
                        catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                    String setOfRecordsAsString = String.join(",", setOfRecords);
                    try {
                        patientHealthRecordDetails.setListOfRecordType(aesUtils.encrypt(setOfRecordsAsString));
                    }
                    catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    patientHealthRecordDetailsRepository.save(patientHealthRecordDetails);
                }
        return new ResponseEntity<List<PatientHealthRecord>>(patientHealthRecord, HttpStatus.OK);
        }



    @Override
    public ResponseEntity<PatientHealthRecord> addPatientHealthRecord(PatientHealthRecord patientHealthRecord) {
        String hospitalName = env.getProperty("hospitalName");
        patientHealthRecord.setHospitalName(hospitalName);
        try {
            patientHealthRecord.setAbhaId(aesUtils.encrypt(patientHealthRecord.getAbhaId()));
            patientHealthRecord.setDescription(aesUtils.encrypt(patientHealthRecord.getDescription()));
            patientHealthRecord.setRecordType(aesUtils.encrypt(patientHealthRecord.getRecordType()));
            patientHealthRecord.setHospitalName(aesUtils.encrypt(patientHealthRecord.getHospitalName()));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        PatientHealthRecord patientRecordInput = patientHealthRecordRepository.save(patientHealthRecord);
        return new ResponseEntity<PatientHealthRecord>(patientRecordInput, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<PatientHealthRecord>> getPatientHealthRecordByAbhaId(String abhaId) {
        List<PatientHealthRecord> patientHealthRecord = patientHealthRecordRepository.getPatientHealthRecordByAbhaId(abhaId);
        if (patientHealthRecord == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {

            for (int i = 0; i < patientHealthRecord.size(); i++) {
                String hospitalName = env.getProperty("hospitalName");
                try {
                    patientHealthRecord.get(i).setHospitalName(aesUtils.encrypt(hospitalName));
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
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

