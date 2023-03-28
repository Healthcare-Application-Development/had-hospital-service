package com.example.hadhospitalservice.service;

import com.example.hadhospitalservice.bean.Admin;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.interfaces.AdminInterface;
import com.example.hadhospitalservice.repository.AdminRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
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
    public Response addAdmin(Admin admin) {
        String hashedPassword = BCrypt.hashpw(admin.getPassword(), hash);
        admin.setPassword(hashedPassword);
        Admin savedAdmin = adminRepository.save(admin);
        savedAdmin.setPassword(null);
        return new Response(savedAdmin, 200);
    }

    @Override
    public Response login(Admin admin) {
        String hashedPassword = BCrypt.hashpw(admin.getPassword(), hash);
        Admin retrievedAdmin = adminRepository.findByEmailAndPassword(admin.getEmail(), hashedPassword);
        if (retrievedAdmin == null) {
            return new Response(null, 400);
        }
        retrievedAdmin.setPassword(null);
        return new Response(retrievedAdmin, 200);
    }
}
