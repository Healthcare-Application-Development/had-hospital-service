package com.example.hadhospitalservice.repository;

import com.example.hadhospitalservice.bean.PatientHealthRecord;
import com.example.hadhospitalservice.bean.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientHealthRecordRepository extends JpaRepository<PatientHealthRecord, Integer> {
    PatientHealthRecord findByAbhaID(Integer abhaID);
}
