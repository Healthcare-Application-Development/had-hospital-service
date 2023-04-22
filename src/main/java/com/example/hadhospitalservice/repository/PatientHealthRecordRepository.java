package com.example.hadhospitalservice.repository;

import com.example.hadhospitalservice.bean.PatientHealthRecord;
import com.example.hadhospitalservice.bean.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientHealthRecordRepository extends JpaRepository<PatientHealthRecord, Integer> {
    List<PatientHealthRecord> getPatientHealthRecordByAbhaId(String abhaId);
    List<PatientHealthRecord> getPatientHealthRecordByAbhaIdAndRecordType(String abhaId, String recordType);
}
