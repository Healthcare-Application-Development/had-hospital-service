package com.example.hadhospitalservice.controller;

import com.example.hadhospitalservice.bean.Admin;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.interfaces.AdminInterface;
import com.example.hadhospitalservice.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {
    final AdminInterface adminInterface;
    @Autowired
    AdminRepository adminRepository;
    public AdminController(AdminInterface adminInterface) {
        this.adminInterface = adminInterface;
    }

    @PostMapping("/add")
    public ResponseEntity<Response> addAdmin(@RequestBody Admin admin) {
        return adminInterface.addAdmin(admin);
    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody Admin admin) {
        return adminInterface.login(admin);
    }

    @GetMapping("/getAll")
    public Response getAll() {
        return new Response(adminRepository.findAll(), 200);
    }
}
