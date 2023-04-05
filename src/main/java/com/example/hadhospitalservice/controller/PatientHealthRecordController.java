package com.example.hadhospitalservice.controller;

import com.example.hadhospitalservice.bean.PatientHealthRecord;
import com.example.hadhospitalservice.bean.Receptionist;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.interfaces.PatientHealthRecordInterface;
import com.example.hadhospitalservice.interfaces.PatientInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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


    @PostMapping("/getByAbhaID/{Id}")
    public ResponseEntity<PatientHealthRecord> getPatientHealthRecordByAbhaID(@PathVariable("Id") Integer abhaID) {
        return patientHealthRecordInterface.getPatientHealthRecordByAbhaID(abhaID);
    }


}
