package com.example.hadhospitalservice.repository;

import com.example.hadhospitalservice.bean.Admin;
import com.example.hadhospitalservice.bean.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByLogin(Login login);
    Admin findByEmail(String email);
}
