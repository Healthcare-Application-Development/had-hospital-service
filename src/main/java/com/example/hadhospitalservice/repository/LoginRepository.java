package com.example.hadhospitalservice.repository;

import com.example.hadhospitalservice.bean.Login;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Login, Integer> {
    Login findByUsername(String username);
    Login findByUsernameAndPassword(String username, String password);
}
