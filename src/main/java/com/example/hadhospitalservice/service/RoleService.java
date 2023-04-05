package com.example.hadhospitalservice.service;

import com.example.hadhospitalservice.bean.Role;
import com.example.hadhospitalservice.interfaces.RoleInterface;
import com.example.hadhospitalservice.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements RoleInterface {
    final RoleRepository roleRepository;

    RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }
    @Override
    public void addRoles() {
        Role admin = new Role();
        admin.setId(1);
        admin.setName("ADMIN");

        Role receptionist = new Role();
        receptionist.setId(2);
        receptionist.setName("RECEPTIONIST");

        roleRepository.save(admin);
        roleRepository.save(receptionist);
    }
}
