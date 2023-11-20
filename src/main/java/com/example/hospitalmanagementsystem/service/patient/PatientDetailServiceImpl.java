package com.example.hospitalmanagementsystem.service.patient;

import com.example.hospitalmanagementsystem.models.entities.Patient;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientDetailServiceImpl implements UserDetailsService {
    private final PatientService patientService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Patient patient=patientService.findPatientByName(username);
        return null;
    }
}
