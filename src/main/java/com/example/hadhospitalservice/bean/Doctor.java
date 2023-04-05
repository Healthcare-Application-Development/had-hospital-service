package com.example.hadhospitalservice.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

@Entity
public class Doctor extends Person {
    @Column(nullable = false, unique = true)
    String npciID;

    public Doctor() {
        super();
    }

    public Doctor(Integer id, String name, String phoneNo, String address, Character gender, String npciID, String email, Login login) {
        super(id, name, phoneNo, address, gender, email, login);
        this.npciID = npciID;
    }

    public String getNpciID() {
        return npciID;
    }

    public void setNpciID(String npciID) {
        this.npciID = npciID;
    }

}
