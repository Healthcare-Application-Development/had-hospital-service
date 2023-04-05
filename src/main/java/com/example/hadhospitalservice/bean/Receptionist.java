package com.example.hadhospitalservice.bean;

import jakarta.persistence.*;

@Entity
public class Receptionist extends Person{
    public Receptionist(Integer id, String name, String phoneNo, String address, Character gender, String email, Login login) {
        super(id, name, phoneNo, address, gender, email, login);
    }

    public Receptionist() {
        super();
    }

}
