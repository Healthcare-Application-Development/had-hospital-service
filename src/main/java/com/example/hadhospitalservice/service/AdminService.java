package com.example.hadhospitalservice.service;

import com.example.hadhospitalservice.bean.*;
import com.example.hadhospitalservice.interfaces.AdminInterface;
import com.example.hadhospitalservice.repository.AdminRepository;
import com.example.hadhospitalservice.repository.LoginRepository;
import com.example.hadhospitalservice.repository.RoleRepository;
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
    final LoginRepository loginRepository;
    final RoleRepository roleRepository;
    public AdminService(AdminRepository adminRepository, LoginRepository loginRepository, RoleRepository roleRepository) {
        this.adminRepository = adminRepository;
        this.loginRepository = loginRepository;
        this.roleRepository = roleRepository;
    }
    @Override
    public ResponseEntity<Response> addAdmin(Admin admin) {
        String hashedPassword = BCrypt.hashpw(admin.getLogin().getPassword(), hash);
        admin.getLogin().setPassword(hashedPassword);
        loginRepository.save(admin.getLogin());
        Admin availAdmin = adminRepository.findByEmail(admin.getEmail());

        if (availAdmin != null) {
            return new ResponseEntity<>(new Response("Admin already present", 400), HttpStatus.BAD_REQUEST);
        }
        try {
            Admin savedAdmin = adminRepository.save(admin);
            savedAdmin.getLogin().setPassword(null);
            return new ResponseEntity<>(new Response(savedAdmin, 200), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<Response> login(Admin admin) {
        String hashedPassword = BCrypt.hashpw(admin.getLogin().getPassword(), hash);
        Login login = admin.getLogin();
        login.setPassword(hashedPassword);
        Login accessedLogin = loginRepository.findByUsernameAndPassword(admin.getEmail(), hashedPassword);
        if (!"ADMIN".equals(admin.getLogin().getRole().getName())) {
            return new ResponseEntity<>(new Response(null, 404), HttpStatus.NOT_FOUND);
        }
        if (accessedLogin == null) {
            return new ResponseEntity<>(new Response(null, 404), HttpStatus.NOT_FOUND);
        }
        Admin retreivedAdmin = adminRepository.findByEmail(admin.getEmail());
        retreivedAdmin.getLogin().setPassword(null);
        return new ResponseEntity<>(new Response(retreivedAdmin, 200), HttpStatus.OK);
    }
}
