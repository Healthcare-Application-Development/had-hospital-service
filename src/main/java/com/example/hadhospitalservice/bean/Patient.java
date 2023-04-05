package com.example.hadhospitalservice.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Patient extends Person {
    public Patient() {
        super();
    }
    public Patient(Integer id, String name, String phoneNo,  String address, Character gender,  String email, String abhaID, Login login) {
        super(id, name, phoneNo, address, gender, email, login);
        this.abhaID = abhaID;
    }

    @Column(nullable = false, unique = true)
    String abhaID;

    public String getAbhaID() {
        return abhaID;
    }

    public void setAbhaID(String abhaID) {
        this.abhaID = abhaID;
    }
}
