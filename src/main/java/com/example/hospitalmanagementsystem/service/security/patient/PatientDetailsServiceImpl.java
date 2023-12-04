package com.example.hospitalmanagementsystem.service.security.patient;

import com.example.hospitalmanagementsystem.models.entities.Doctor;
import com.example.hospitalmanagementsystem.models.entities.Patient;
import com.example.hospitalmanagementsystem.models.security.DoctorSecurity;
import com.example.hospitalmanagementsystem.service.patient.PatientService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@RequiredArgsConstructor
public class PatientDetailsServiceImpl implements UserDetailsService {
    private final PatientService patientService;
    @Override
    public UserDetails loadUserByUsername(String patientName) throws UsernameNotFoundException {
        Patient patient = patientService.findPatientByEmail(patientName);
        List<SimpleGrantedAuthority> simpleGrantedAuthorities=new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority(patient.getRole()));
        return DoctorSecurity.builder().doctorName(patient.getName()).password(patient.getPassword()).authorities(simpleGrantedAuthorities).build();
    }
}
