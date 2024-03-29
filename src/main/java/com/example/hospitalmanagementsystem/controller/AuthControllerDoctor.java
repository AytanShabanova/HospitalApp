package com.example.hospitalmanagementsystem.controller;

import com.example.hospitalmanagementsystem.models.dto.ResponseDto;
import com.example.hospitalmanagementsystem.models.payload.DoctorRegisterPayload;
import com.example.hospitalmanagementsystem.models.payload.LoginPayload;
import com.example.hospitalmanagementsystem.models.payload.RegisterPayload;
import com.example.hospitalmanagementsystem.models.response.LoginResponse;
import com.example.hospitalmanagementsystem.models.response.RegisterResponse;
import com.example.hospitalmanagementsystem.service.security.doctor.AuthBusinessServiceDoctor;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v2/auth/doctor")
@RequiredArgsConstructor
@Validated
public class AuthControllerDoctor {
    private final AuthBusinessServiceDoctor authBusinessServiceDoctor;
    @PostMapping("/login")
    public ResponseDto<LoginResponse>login(@RequestBody LoginPayload loginPayload){
        return ResponseDto.success(authBusinessServiceDoctor.login(loginPayload));
    }
    @PostMapping("/register")
    public ResponseDto<RegisterResponse>register(@RequestBody @Valid DoctorRegisterPayload registerPayload){
        return ResponseDto.success(authBusinessServiceDoctor.register(registerPayload));
    }
}
