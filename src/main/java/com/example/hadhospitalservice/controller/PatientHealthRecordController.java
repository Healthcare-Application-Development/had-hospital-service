package com.example.hadhospitalservice.controller;

import com.example.hadhospitalservice.bean.PatientHealthRecord;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.interfaces.PatientHealthRecordInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/patientHealthRecord")
public class PatientHealthRecordController {
    final PatientHealthRecordInterface patientHealthRecordInterface;

    public PatientHealthRecordController(PatientHealthRecordInterface patientHealthRecordInterface) {
        this.patientHealthRecordInterface = patientHealthRecordInterface;
    }


    @PostMapping("/add")
    public ResponseEntity<PatientHealthRecord> addPatientHealthRecord(@RequestBody PatientHealthRecord patientHealthRecord) {
        return patientHealthRecordInterface.addPatientHealthRecord(patientHealthRecord);
    }

    @GetMapping("/getAll")
    public Response getAllPatientHealthRecord() {
        return patientHealthRecordInterface.getAllPatientHealthRecord();
    }


    @PostMapping("/getPatientHealthRecordByAbhaId/{Id}")
    public ResponseEntity<PatientHealthRecord> getPatientHealthRecordByAbhaID(@PathVariable("Id") String abhaId) {
        return patientHealthRecordInterface.getPatientHealthRecordByAbhaId(abhaId);
    }


    @PostMapping("/getPatientHealthRecord")
    public ResponseEntity<List<PatientHealthRecord>> getPatientHealthRecordByAbhaIdAndRecordType(@RequestBody PatientHealthRecord patientHealthRecord)  {
        return patientHealthRecordInterface.getPatientHealthRecordByAbhaIdAndRecordType(patientHealthRecord.getAbhaId(), patientHealthRecord.getRecordType());
    }

}
