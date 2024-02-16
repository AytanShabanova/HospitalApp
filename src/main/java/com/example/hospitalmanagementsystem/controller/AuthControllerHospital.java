package com.example.hospitalmanagementsystem.controller;

import com.example.hospitalmanagementsystem.models.dto.ResponseDto;
import com.example.hospitalmanagementsystem.models.payload.HospitalRegisterPayLoad;
import com.example.hospitalmanagementsystem.models.payload.LoginPayload;
import com.example.hospitalmanagementsystem.models.payload.PatientRegisterPayload;
import com.example.hospitalmanagementsystem.models.response.LoginResponse;
import com.example.hospitalmanagementsystem.models.response.RegisterResponse;
import com.example.hospitalmanagementsystem.service.security.hospital.AuthBusinessServiceHospital;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v2/auth/hospital")
@RequiredArgsConstructor
public class AuthControllerHospital {
    private final AuthBusinessServiceHospital authBusinessServiceHospital;

    @PostMapping("/login")
    public ResponseDto<LoginResponse> login(@RequestBody LoginPayload loginPayload) {
        return ResponseDto.success(authBusinessServiceHospital.login(loginPayload));
    }

    @PostMapping("/register")
    public ResponseDto<RegisterResponse> register(@RequestBody @Valid HospitalRegisterPayLoad hospitalRegisterPayLoad) {
        return ResponseDto.success(authBusinessServiceHospital.register(hospitalRegisterPayLoad));

    }
}