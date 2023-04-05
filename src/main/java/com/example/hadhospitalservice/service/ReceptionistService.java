package com.example.hadhospitalservice.service;

import com.example.hadhospitalservice.bean.Login;
import com.example.hadhospitalservice.bean.Receptionist;
import com.example.hadhospitalservice.bean.Response;
import com.example.hadhospitalservice.interfaces.ReceptionistInterface;
import com.example.hadhospitalservice.repository.LoginRepository;
import com.example.hadhospitalservice.repository.ReceptionistRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptionistService implements ReceptionistInterface {

    final LoginRepository loginRepository;
    @Value("${bcrypt.hash}")
    private String hash;
    final ReceptionistRepository receptionistRepository;


    public ReceptionistService(ReceptionistRepository receptionistRepository, LoginRepository loginRepository) {
        this.receptionistRepository = receptionistRepository;
        this.loginRepository = loginRepository;
    }

    @Override
    public ResponseEntity<Response> addReceptionist(Receptionist receptionist) {
        String hashedPassword = BCrypt.hashpw(receptionist.getLogin().getPassword(),hash);
        receptionist.getLogin().setPassword(hashedPassword);
        loginRepository.save(receptionist.getLogin());
        Receptionist availReceptionist = receptionistRepository.findByEmail(receptionist.getEmail());

        if (availReceptionist != null) {
            return new ResponseEntity<>(new Response("Email already taken", 400), HttpStatus.BAD_REQUEST);
        }
        try {
            Receptionist savedReceptionist = receptionistRepository.save(receptionist);
            savedReceptionist.getLogin().setPassword(null);
            return new ResponseEntity<>(new Response(savedReceptionist, 200), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new Response(e.getMessage(), 400), HttpStatus.BAD_REQUEST);
        }

    }

    @Override
    public ResponseEntity<Response> getAllReceptionists() {
        List<Receptionist> receptionistList = receptionistRepository.findAll();
        for (int i = 0; i < receptionistList.size(); i++) {
            receptionistList.get(i).getLogin().setPassword(null);
        }
        return new ResponseEntity<>(new Response(receptionistList, 200), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> login(Receptionist receptionist) {
        String hashedPassword = BCrypt.hashpw(receptionist.getLogin().getPassword(), hash);
        Login login = receptionist.getLogin();
        login.setPassword(hashedPassword);
        Login accessedLogin = loginRepository.findByUsernameAndPassword(receptionist.getEmail(), hashedPassword);

        if (!"RECEPTIONIST".equals(receptionist.getLogin().getRole())) {
            return new ResponseEntity<>(new Response(null, 404), HttpStatus.NOT_FOUND);
        }
        if (accessedLogin == null) {
            return new ResponseEntity<>(new Response(null, 404), HttpStatus.NOT_FOUND);
        }
        Receptionist retrievedReceptionist = receptionistRepository.findByEmail(receptionist.getEmail());
        retrievedReceptionist.getLogin().setPassword(null);
        return new ResponseEntity<>(new Response(retrievedReceptionist, 200), HttpStatus.OK);
    }
}
