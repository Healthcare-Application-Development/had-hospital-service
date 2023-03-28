package com.example.hadhospitalservice.repository;

import com.example.hadhospitalservice.bean.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer> {
    Admin findByEmailAndPassword(String emailID, String password);
}
