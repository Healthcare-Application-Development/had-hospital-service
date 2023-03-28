package com.example.hadhospitalservice.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Patient extends Person {
    public Patient() {
        super();
    }
    public Patient(Integer id, String name, String phoneNo,  String address, Character gender, String password, String email, String abhaID) {
        super(id, name, phoneNo, address, gender, password);
        this.email = email;
        this.abhaID = abhaID;
    }
    @Column(nullable = false)
    private String email;
    @Column(nullable = false, unique = true)
    String abhaID;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAbhaID() {
        return abhaID;
    }

    public void setAbhaID(String abhaID) {
        this.abhaID = abhaID;
    }
}
