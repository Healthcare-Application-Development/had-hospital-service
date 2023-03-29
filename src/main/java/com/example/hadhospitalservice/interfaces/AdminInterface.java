package com.example.hadhospitalservice.interfaces;

import com.example.hadhospitalservice.bean.Admin;
import com.example.hadhospitalservice.bean.Response;
import org.springframework.http.ResponseEntity;

public interface AdminInterface {
    ResponseEntity<Response> addAdmin(Admin admin);
    ResponseEntity<Response> login(Admin admin);
}
