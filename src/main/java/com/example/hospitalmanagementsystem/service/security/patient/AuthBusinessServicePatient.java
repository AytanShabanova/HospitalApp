package com.example.hospitalmanagementsystem.service.security.patient;


import com.example.hospitalmanagementsystem.models.payload.LoginPayload;
import com.example.hospitalmanagementsystem.models.payload.RegisterPayload;
import com.example.hospitalmanagementsystem.models.response.LoginResponse;
import com.example.hospitalmanagementsystem.models.response.RegisterResponse;

public interface AuthBusinessServicePatient {

    LoginResponse login(LoginPayload payload);



    void setAuthentication(String email);
    RegisterResponse register(RegisterPayload registerPayload);


}
