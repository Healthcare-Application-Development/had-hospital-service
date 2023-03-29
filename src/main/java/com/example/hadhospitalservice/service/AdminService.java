package com.example.hadhospitalservice.service;

import com.example.hadhospitalservice.bean.Admin;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.interfaces.AdminInterface;
import com.example.hadhospitalservice.repository.AdminRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AdminService implements AdminInterface {
    @Value("${bcrypt.hash}")
    private String hash;
    final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    @Override
    public ResponseEntity<Response> addAdmin(Admin admin) {
        String hashedPassword = BCrypt.hashpw(admin.getPassword(), hash);
        admin.setPassword(hashedPassword);
        try {
            Admin savedAdmin = adminRepository.save(admin);
            savedAdmin.setPassword(null);
            return new ResponseEntity<>(new Response(savedAdmin, 200), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<Response> login(Admin admin) {
        String hashedPassword = BCrypt.hashpw(admin.getPassword(), hash);
        Admin retrievedAdmin = adminRepository.findByEmailAndPassword(admin.getEmail(), hashedPassword);
        if (retrievedAdmin == null) {
            return new ResponseEntity<>(new Response(null, 404), HttpStatus.NOT_FOUND);
        }
        retrievedAdmin.setPassword(null);
        return new ResponseEntity<>(new Response(retrievedAdmin, 200), HttpStatus.OK);
    }
}
