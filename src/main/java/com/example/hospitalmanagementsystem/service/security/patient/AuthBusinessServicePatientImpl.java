package com.example.hospitalmanagementsystem.service.security.patient;

import com.example.hospitalmanagementsystem.models.dto.PatientDto;
import com.example.hospitalmanagementsystem.models.entities.Patient;
import com.example.hospitalmanagementsystem.models.payload.LoginPayload;
import com.example.hospitalmanagementsystem.models.payload.RegisterPayload;
import com.example.hospitalmanagementsystem.models.response.LoginResponse;
import com.example.hospitalmanagementsystem.models.response.RegisterResponse;
import com.example.hospitalmanagementsystem.service.patient.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


@Service("authBusinessServicePatient")
@RequiredArgsConstructor
@Slf4j
public class AuthBusinessServicePatientImpl implements AuthBusinessServicePatient {

    private final AuthenticationManager authenticationManager;
    private final AccessTokenManagerPatient accessTokenManagerPatient;
    private final PatientService patientService;

    private final UserDetailsService userDetailsService;
    private final ObjectMapper objectMapper;
    private final PasswordEncoder passwordEncoder;


    @Override
    public LoginResponse login(LoginPayload payload) {
        LoginResponse loginResponse = prepareLoginResponse(payload.getEmail());
     //   authenticate(payload);

        return loginResponse;
    }


    @Override
    public void setAuthentication(String email) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(userDetails, userDetails.getAuthorities(), userDetails.getAuthorities())
        );
    }

    @Override
    public RegisterResponse register(RegisterPayload registerPayload) {

        return convertRegisterResponse(registerPayload);
    }

    // private util methods

    private void authenticate(LoginPayload request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

        } catch (AuthenticationException e) {
            throw new  RuntimeException("authentication error");
        }
    }

    private LoginResponse prepareLoginResponse(String email) {
        Patient patient = patientService.findPatientByEmail(email);
        return LoginResponse.builder()
                .accessToken(accessTokenManagerPatient.generate(patient))
                .email(patient.getEmail())
                .build();
    }

    private RegisterResponse convertRegisterResponse(RegisterPayload registerPayload) {
        Patient patient = objectMapper.convertValue(registerPayload, Patient.class);
        String password=passwordEncoder.encode(patient.getPassword());

        patient.setPassword(password);
        patient.setRole("ROLE_USER");
        //burada buna ehdiyac var idimi yoxsa basqacure etmek olardimi
      PatientDto patientDto=  objectMapper.convertValue(patient, PatientDto.class);
        Patient patientEntity = patientService.savePatient(patientDto);
        return objectMapper.convertValue(patientEntity, RegisterResponse.class);
    }
}
