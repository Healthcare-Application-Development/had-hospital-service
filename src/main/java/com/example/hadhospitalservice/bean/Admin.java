package com.example.hadhospitalservice.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Admin extends Person {

    public Admin(Integer id, String name, String phoneNo, String address, Character gender, String email, Login login) {
        super(id, name, phoneNo, address, gender, email, login);
    }

    public Admin() {
        super();
    }

}
