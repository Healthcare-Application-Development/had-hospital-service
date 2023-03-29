package com.example.hadhospitalservice.service;

import com.example.hadhospitalservice.bean.Receptionist;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.interfaces.ReceptionistInterface;
import com.example.hadhospitalservice.repository.ReceptionistRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionistService implements ReceptionistInterface {

    @Value("${bcrypt.hash}")
    private String hash;
    final ReceptionistRepository receptionistRepository;

    public ReceptionistService(ReceptionistRepository receptionistRepository) {
        this.receptionistRepository = receptionistRepository;
    }

    @Override
    public ResponseEntity<Response> addReceptionist(Receptionist receptionist) {
        String hashedPassword = BCrypt.hashpw(receptionist.getPassword(),hash);
        receptionist.setPassword(hashedPassword);
        try {
            Receptionist savedReceptionist = receptionistRepository.save(receptionist);
            savedReceptionist.setPassword(null);
            return new ResponseEntity<>(new Response(savedReceptionist, 200), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<Response> getAllReceptionists() {
        List<Receptionist> receptionistList = receptionistRepository.findAll();
        for (int i = 0; i < receptionistList.size(); i++) {
            receptionistList.get(i).setPassword(null);
        }
        return new ResponseEntity<>(new Response(receptionistList, 200), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> login(Receptionist receptionist) {
        String hashedPassword = BCrypt.hashpw(receptionist.getPassword(), hash);
        Receptionist retrievedReceptionist = receptionistRepository.findByEmailAndPassword(receptionist.getEmail(), hashedPassword);
        if (retrievedReceptionist == null) {
            return new ResponseEntity<>(new Response(null, 404), HttpStatus.NOT_FOUND);
        }
        retrievedReceptionist.setPassword(null);
        return new ResponseEntity<>(new Response(retrievedReceptionist, 200), HttpStatus.OK);
    }
}
