package com.example.hadhospitalservice.controller;

import com.example.hadhospitalservice.bean.PatientHealthRecord;
import com.example.hadhospitalservice.bean.RequestPatientHealthRecord;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.interfaces.PatientHealthRecordInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/patientHealthRecord")
public class PatientHealthRecordController {

//    @Autowired
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


    @PostMapping("/getPatientHealthRecordByAbhaId/")
    public ResponseEntity<List<PatientHealthRecord>> getPatientHealthRecordByAbhaID(@RequestBody PatientHealthRecord patientHealthRecord) {
        return patientHealthRecordInterface.getPatientHealthRecordByAbhaId(patientHealthRecord.getAbhaId());
    }


    @PostMapping("/getPatientHealthRecord/")
    public ResponseEntity<List<PatientHealthRecord>> getPatientHealthRecordByAbhaIdAndRecordType(@RequestBody RequestPatientHealthRecord requestPatientHealthRecord)  {
        return patientHealthRecordInterface.getPatientHealthRecordByAbhaIdAndRecordType(requestPatientHealthRecord);
    }


}
