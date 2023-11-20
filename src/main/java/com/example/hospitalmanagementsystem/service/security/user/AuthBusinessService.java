package com.example.hospitalmanagementsystem.service.security.user;

import jakarta.servlet.http.HttpServletRequest;


public interface AuthBusinessService {

//    LoginResponse login(LoginPayload payload);
//
//    LoginResponse refresh(RefreshTokenPayload payload);

    void logout(HttpServletRequest httpServletRequest);

    void setAuthentication(String email);
//    RegisterResponse register(RegisterPayload registerPayload);


}
