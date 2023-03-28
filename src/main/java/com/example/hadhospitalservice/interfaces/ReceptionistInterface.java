package com.example.hadhospitalservice.interfaces;

import com.example.hadhospitalservice.bean.Receptionist;
import com.example.hadhospitalservice.bean.Response;

public interface ReceptionistInterface {
    Response addReceptionist(Receptionist receptionist);
    Response getAllReceptionists();
    Response login(Receptionist receptionist);
}
