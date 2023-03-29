package com.example.hadhospitalservice.interfaces;

import com.example.hadhospitalservice.bean.Receptionist;
import com.example.hadhospitalservice.bean.Response;
import org.springframework.http.ResponseEntity;

public interface ReceptionistInterface {
    ResponseEntity<Response> addReceptionist(Receptionist receptionist);
    ResponseEntity<Response> getAllReceptionists();
    ResponseEntity<Response> login(Receptionist receptionist);
}
