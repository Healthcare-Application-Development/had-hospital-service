package com.example.hadhospitalservice.repository;

import com.example.hadhospitalservice.bean.PatientHealthRecord;
import com.example.hadhospitalservice.bean.PatientHealthRecordDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PatientHealthRecordDetailsRepository extends JpaRepository<PatientHealthRecordDetails, Integer> {

}
