package com.example.hospitalmanagementsystem.service.security.hospital;


import com.example.hospitalmanagementsystem.models.payload.HospitalRegisterPayLoad;
import com.example.hospitalmanagementsystem.models.payload.LoginPayload;
import com.example.hospitalmanagementsystem.models.response.LoginResponse;
import com.example.hospitalmanagementsystem.models.response.RegisterResponse;

public interface AuthBusinessServiceHospital {
    LoginResponse login(LoginPayload payload);



    void setAuthentication(String email);
    RegisterResponse register(HospitalRegisterPayLoad hospitalRegisterPayLoad);
}
