package com.example.hadhospitalservice.controller;

import com.example.hadhospitalservice.bean.Role;
import com.example.hadhospitalservice.interfaces.RoleInterface;
import com.example.hadhospitalservice.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {
    final RoleInterface roleInterface;

    public RoleController(RoleInterface roleInterface) {
        this.roleInterface = roleInterface;
    }

    @GetMapping("/add")
    public void addRoles() {
        roleInterface.addRoles();
    }
}
