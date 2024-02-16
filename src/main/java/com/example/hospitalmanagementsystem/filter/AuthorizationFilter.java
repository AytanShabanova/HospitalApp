package com.example.hospitalmanagementsystem.filter;

import com.example.hospitalmanagementsystem.service.security.doctor.AccessTokenManagerDoctor;
import com.example.hospitalmanagementsystem.service.security.doctor.AuthBusinessServiceDoctor;
import com.example.hospitalmanagementsystem.service.security.hospital.AccessTokenManagerHospital;
import com.example.hospitalmanagementsystem.service.security.hospital.AuthBusinessServiceHospital;
import com.example.hospitalmanagementsystem.service.security.patient.AccessTokenManagerPatient;
import com.example.hospitalmanagementsystem.service.security.patient.AuthBusinessServicePatient;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class AuthorizationFilter extends OncePerRequestFilter {
    private final AccessTokenManagerDoctor accessTokenManagerDoctor;
    private final AccessTokenManagerPatient accessTokenManagerPatient;
    private final AuthBusinessServiceDoctor authBusinessServiceDoctor;
    private final AuthBusinessServicePatient authBusinessServicePatient;
    private final AccessTokenManagerHospital accessTokenManagerHospital;
    private final AuthBusinessServiceHospital authBusinessServiceHospital;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        System.out.println("token      :" + token);
        if (Objects.nonNull(token) && token.startsWith("Bearer")) {
            String decodeToken = token.substring(7);
            System.out.println("decodeToken     :" + decodeToken);
            if (null != accessTokenManagerDoctor.getEmail(decodeToken)) {
                authBusinessServiceDoctor.setAuthentication(
                        accessTokenManagerDoctor.getEmail(
                                decodeToken
                        )
                );
            } else if (null != accessTokenManagerPatient.getEmail(decodeToken)) {
                authBusinessServicePatient.setAuthentication(
                        accessTokenManagerPatient.getEmail(
                                decodeToken
                        )
                );
            } else if (null != accessTokenManagerHospital.getEmail(decodeToken)) {
                authBusinessServiceHospital.setAuthentication(
                        accessTokenManagerHospital.getEmail(
                                decodeToken
                        )
                );
            }

            }
        filterChain.doFilter(request, response);
        }
    }
