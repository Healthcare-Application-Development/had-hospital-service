package com.example.hadhospitalservice.repository;

import com.example.hadhospitalservice.bean.Doctor;
import com.example.hadhospitalservice.bean.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {
    Doctor findByNpciID(String npciID);
}
