package com.example.hadhospitalservice.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Admin extends Person {
    @Column(nullable = false, unique = true)
    private String email;
    public Admin(Integer id, String name, String phoneNo, String address, Character gender, String password, String email) {
        super(id, name, phoneNo, address, gender, password);
        this.email = email;
    }

    public Admin() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
