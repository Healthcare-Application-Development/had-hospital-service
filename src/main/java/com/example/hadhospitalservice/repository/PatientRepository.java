package com.example.hadhospitalservice.repository;

import com.example.hadhospitalservice.bean.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
    Patient findByAbhaIDAndPassword(String emailID, String password);
    Patient findByAbhaID(String abhaID);
}
