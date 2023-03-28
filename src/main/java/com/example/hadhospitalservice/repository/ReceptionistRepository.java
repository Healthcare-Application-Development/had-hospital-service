package com.example.hadhospitalservice.repository;

import com.example.hadhospitalservice.bean.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist, Integer> {
    Receptionist findByEmailAndPassword(String emailID, String password);
}
