package com.example.hadhospitalservice.controller;

import com.example.hadhospitalservice.bean.Admin;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.interfaces.AdminInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {
    final AdminInterface adminInterface;

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
}