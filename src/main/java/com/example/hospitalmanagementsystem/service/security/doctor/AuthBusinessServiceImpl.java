package com.example.hospitalmanagementsystem.service.security.doctor;

import com.example.hospitalmanagementsystem.models.dto.DoctorDto;
import com.example.hospitalmanagementsystem.models.entities.Doctor;
import com.example.hospitalmanagementsystem.models.entities.Patient;
import com.example.hospitalmanagementsystem.models.payload.LoginPayload;
import com.example.hospitalmanagementsystem.models.payload.RegisterPayload;
import com.example.hospitalmanagementsystem.models.response.LoginResponse;
import com.example.hospitalmanagementsystem.models.response.RegisterResponse;
import com.example.hospitalmanagementsystem.service.doctor.DoctorService;
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


@Service
@RequiredArgsConstructor
@Slf4j
public class AuthBusinessServiceImpl implements AuthBusinessService {

    private final AuthenticationManager authenticationManager;
    private final AccessTokenManagerDoctor accessTokenManagerDoctor;
    private final DoctorService doctorService;

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
        Doctor  doctor = doctorService.findDoctorByEmail(email);
        return LoginResponse.builder()
                .accessToken(accessTokenManagerDoctor.generate(doctor))
                .email(doctor.getEmail())
                .build();
    }
//burada doctoru doctordtoya cevirmisem ehdiyac var idimi?
    private RegisterResponse convertRegisterResponse(RegisterPayload registerPayload) {
        Doctor doctor = objectMapper.convertValue(registerPayload, Doctor.class);
        String password=passwordEncoder.encode(doctor.getPassword());


        doctor.setPassword(password);
        doctor.setRole("ROLE_USER");
       DoctorDto doctorDto= objectMapper.convertValue(doctor, DoctorDto.class);
        Doctor doctorEntity = doctorService.saveDoctor(doctorDto);
        return objectMapper.convertValue(doctorEntity, RegisterResponse.class);
    }
}
