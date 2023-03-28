package com.example.hadhospitalservice.bean;

import jakarta.persistence.*;

@Entity
public class Receptionist extends Person{
    @Column(unique = true, nullable = false)
    private String email;

    public Receptionist(Integer id, String name, String phoneNo, String address, Character gender, String password, String email) {
        super(id, name, phoneNo, address, gender, password);
        this.email = email;
    }

    public Receptionist() {
        super();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
