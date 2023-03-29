package com.example.hadhospitalservice.controller;

import com.example.hadhospitalservice.bean.Receptionist;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.interfaces.ReceptionistInterface;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/receptionist")
@CrossOrigin(allowedHeaders = "*", origins = "*")
public class ReceptionistController {
    ReceptionistInterface receptionistInterface;
    public ReceptionistController(ReceptionistInterface receptionistInterface) {
        this.receptionistInterface = receptionistInterface;
    }

    @PostMapping("/add")
    public ResponseEntity<Response> addReceptionist(@RequestBody Receptionist receptionist) {
        return receptionistInterface.addReceptionist(receptionist);
    }

    @GetMapping("/getAll")
    public ResponseEntity<Response> getAllReceptionists() {
        return receptionistInterface.getAllReceptionists();
    }
    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody Receptionist receptionist) {
        return receptionistInterface.login(receptionist);
    }
}
