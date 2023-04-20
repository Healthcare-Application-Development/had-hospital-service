package com.example.hadhospitalservice.service;

import com.example.hadhospitalservice.bean.Doctor;
import com.example.hadhospitalservice.bean.Patient;
import com.example.hadhospitalservice.bean.PatientHealthRecord;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.encryption.AESUtils;
import com.example.hadhospitalservice.interfaces.PatientHealthRecordInterface;
import com.example.hadhospitalservice.repository.PatientHealthRecordRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PatientHealthRecordService implements PatientHealthRecordInterface {
    @Autowired
    AESUtils aesUtils;

    @Autowired
    private Environment env;

//    @Autowired
    final PatientHealthRecordRepository patientHealthRecordRepository;
    public PatientHealthRecordService(PatientHealthRecordRepository patientHealthRecordRepository) {
        this.patientHealthRecordRepository = patientHealthRecordRepository;
    }
    @Override
    public ResponseEntity<List<PatientHealthRecord>> getPatientHealthRecordByAbhaIdAndRecordType(String abhaId, String recordType) {
        List<PatientHealthRecord> patientHealthRecord = patientHealthRecordRepository.getPatientHealthRecordByAbhaIdAndRecordType(abhaId, recordType);
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
    public ResponseEntity<PatientHealthRecord> addPatientHealthRecord(PatientHealthRecord patientHealthRecord) {
        String hospitalName = env.getProperty("hospitalName");
        patientHealthRecord.setHospitalName(hospitalName);
        try {
            patientHealthRecord.setAbhaId(aesUtils.encrypt(patientHealthRecord.getAbhaId()));
            patientHealthRecord.setDescription(aesUtils.encrypt(patientHealthRecord.getDescription()));
            patientHealthRecord.setRecordType(aesUtils.encrypt(patientHealthRecord.getRecordType()));
            patientHealthRecord.setHospitalName(aesUtils.encrypt(patientHealthRecord.getHospitalName()));
        } catch (Exception e) {
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

