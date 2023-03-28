package com.example.hadhospitalservice.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Doctor extends Person {
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false, unique = true)
    String npciID;

    public Doctor() {
        super();
    }

    public Doctor(Integer id, String name, String phoneNo, String address, Character gender, String password, String npciID, String email) {
        super(id, name, phoneNo, address, gender, password);
        this.email = email;
        this.npciID = npciID;
    }

    public String getNpciID() {
        return npciID;
    }

    public void setNpciID(String npciID) {
        this.npciID = npciID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
