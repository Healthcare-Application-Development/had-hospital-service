package com.example.hadhospitalservice.interfaces;

import com.example.hadhospitalservice.bean.Admin;
import com.example.hadhospitalservice.bean.Response;

public interface AdminInterface {
    Response addAdmin(Admin admin);
    Response login(Admin admin);
}
