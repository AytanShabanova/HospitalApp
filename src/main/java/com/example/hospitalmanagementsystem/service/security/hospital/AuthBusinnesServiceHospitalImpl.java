package com.example.hospitalmanagementsystem.service.security.hospital;

import com.example.hospitalmanagementsystem.models.dto.DoctorDto;
import com.example.hospitalmanagementsystem.models.dto.HospitalDto;
import com.example.hospitalmanagementsystem.models.entities.Doctor;
import com.example.hospitalmanagementsystem.models.entities.Hospital;
import com.example.hospitalmanagementsystem.models.payload.DoctorRegisterPayload;
import com.example.hospitalmanagementsystem.models.payload.HospitalRegisterPayLoad;
import com.example.hospitalmanagementsystem.models.payload.LoginPayload;
import com.example.hospitalmanagementsystem.models.response.LoginResponse;
import com.example.hospitalmanagementsystem.models.response.RegisterResponse;
import com.example.hospitalmanagementsystem.service.hospital.HospitalService;
import com.example.hospitalmanagementsystem.service.patient.PatientService;
import com.example.hospitalmanagementsystem.service.security.patient.AccessTokenManagerPatient;
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

@Service("authBusinnesServiceHospital")

@RequiredArgsConstructor
@Slf4j
public class AuthBusinnesServiceHospitalImpl implements AuthBusinessServiceHospital {
    private final AuthenticationManager authenticationManager;
    private final AccessTokenManagerHospital accessTokenManagerHospital;
    private final HospitalService hospitalService;

    private final UserDetailsService userDetailsService;
    private final ObjectMapper objectMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public LoginResponse login(LoginPayload payload) {
        LoginResponse loginResponse = prepareLoginResponse(payload.getEmail());
        authenticate(payload);

        return loginResponse;
    }


    @Override
    public void setAuthentication(String email) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(email);

        SecurityContextHolder.getContext().setAuthentication(
                new UsernamePasswordAuthenticationToken(userDetails,
                        userDetails.getAuthorities(), userDetails.getAuthorities())
        );

    }

    @Override
    public RegisterResponse register(HospitalRegisterPayLoad hospitalRegisterPayLoad) {
        return convertRegisterResponse(hospitalRegisterPayLoad);
    }

    private LoginResponse prepareLoginResponse(String email) {
        Hospital hospital = hospitalService.findHospitalByEmail(email);
        return LoginResponse.builder()
                .accessToken(accessTokenManagerHospital.generate(hospital))
                .email(hospital.getEmail())
                .build();
    } private void authenticate(LoginPayload request) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
            );

        } catch (AuthenticationException e) {
            e.printStackTrace();
        }

    }
    private RegisterResponse convertRegisterResponse(HospitalRegisterPayLoad hospitalRegisterPayLoad) {
        Hospital hospital = objectMapper.convertValue(hospitalRegisterPayLoad, Hospital.class);
        String password=passwordEncoder.encode(hospital.getPassword());


        hospital.setPassword(password);
        hospital.setRole("HOSPITAL");
        HospitalDto hospitalDto= objectMapper.convertValue(hospital, HospitalDto.class);
        Hospital saveHospital = hospitalService.saveHospital(hospitalDto);
        return objectMapper.convertValue(saveHospital, RegisterResponse.class);
    }
}
