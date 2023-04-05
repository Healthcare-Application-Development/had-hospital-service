package com.example.hadhospitalservice.repository;

import com.example.hadhospitalservice.bean.Login;
import com.example.hadhospitalservice.bean.Receptionist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReceptionistRepository extends JpaRepository<Receptionist, Integer> {
    Receptionist findByLogin(Login login);
    Receptionist findByEmail(String email);
}
