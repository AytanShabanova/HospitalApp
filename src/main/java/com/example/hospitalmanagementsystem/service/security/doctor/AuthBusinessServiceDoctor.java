package com.example.hospitalmanagementsystem.service.security.doctor;


import com.example.hospitalmanagementsystem.models.payload.LoginPayload;
import com.example.hospitalmanagementsystem.models.payload.RegisterPayload;
import com.example.hospitalmanagementsystem.models.response.LoginResponse;
import com.example.hospitalmanagementsystem.models.response.RegisterResponse;

public interface AuthBusinessServiceDoctor {

    LoginResponse login(LoginPayload payload);



    void setAuthentication(String email);
    RegisterResponse register(RegisterPayload registerPayload);


}
