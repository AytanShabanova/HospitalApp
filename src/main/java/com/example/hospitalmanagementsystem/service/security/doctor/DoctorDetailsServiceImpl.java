package com.example.hospitalmanagementsystem.service.security.doctor;

import com.example.hospitalmanagementsystem.models.entities.Doctor;
import com.example.hospitalmanagementsystem.models.security.DoctorSecurity;
import com.example.hospitalmanagementsystem.service.doctor.DoctorService;
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

public class DoctorDetailsServiceImpl implements UserDetailsService {
    private final DoctorService doctorService;
    @Override
    public UserDetails loadUserByUsername(String doctorName) throws UsernameNotFoundException {
        Doctor doctor = doctorService.findDoctorByEmail(doctorName);
        List<SimpleGrantedAuthority> simpleGrantedAuthorities=new ArrayList<>();
        simpleGrantedAuthorities.add(new SimpleGrantedAuthority(doctor.getRole()));
        return DoctorSecurity.builder().doctorName(doctor.getName()).password(doctor.getPassword()).authorities(simpleGrantedAuthorities).build();
    }
}
