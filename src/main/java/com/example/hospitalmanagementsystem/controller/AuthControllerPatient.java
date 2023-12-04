package com.example.hospitalmanagementsystem.controller;

import com.example.hospitalmanagementsystem.models.dto.ResponseDto;
import com.example.hospitalmanagementsystem.models.payload.LoginPayload;
import com.example.hospitalmanagementsystem.models.payload.RegisterPayload;
import com.example.hospitalmanagementsystem.models.response.LoginResponse;

import com.example.hospitalmanagementsystem.models.response.RegisterResponse;
import com.example.hospitalmanagementsystem.service.security.patient.AuthBusinessServicePatient;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/auth")
@RequiredArgsConstructor
public class AuthControllerPatient {
    private final AuthBusinessServicePatient authBusinessServicePatient;
 @PostMapping("/login")
    public ResponseDto<LoginResponse>login(@RequestBody LoginPayload loginPayload){
return ResponseDto.success(authBusinessServicePatient.login(loginPayload));
 }
 @PostMapping("/register")
    public ResponseDto<RegisterResponse>register(@RequestBody RegisterPayload registerPayload){
     return ResponseDto.success(authBusinessServicePatient.register(registerPayload));





















 }
}
