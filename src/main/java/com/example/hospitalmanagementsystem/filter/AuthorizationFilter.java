package com.example.hospitalmanagementsystem.filter;

import com.example.hospitalmanagementsystem.service.security.doctor.AccessTokenManagerDoctor;
import com.example.hospitalmanagementsystem.service.security.doctor.AuthBusinessServiceSoctor;
import com.example.hospitalmanagementsystem.service.security.patient.AccessTokenManagerPatient;
import com.example.hospitalmanagementsystem.service.security.patient.AuthBusinessServicePatient;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
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
    private final AuthBusinessServiceSoctor authBusinessServiceSoctor;
    private final AuthBusinessServicePatient authBusinessServicePatient;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        System.out.println("token      :" + token);
        if (Objects.nonNull(token) && token.startsWith("Bearer")) {
            String decodeToken = token.substring(7);
            System.out.println("decodeToken     :" + decodeToken);
            if (null != accessTokenManagerDoctor.getEmail(decodeToken)) {
                authBusinessServiceSoctor.setAuthentication(
                        accessTokenManagerDoctor.getEmail(
                                decodeToken
                        )
                );
            } else if (null != accessTokenManagerPatient.getEmail(decodeToken) && tokenService.tokenExist(decodeToken)) {
                authBusinessServicePatient.setAuthentication(
                        accessTokenManagerPatient.getEmail(
                                decodeToken
                        )
                );
            }
        }
        filterChain.doFilter(request, response);
    }
}
