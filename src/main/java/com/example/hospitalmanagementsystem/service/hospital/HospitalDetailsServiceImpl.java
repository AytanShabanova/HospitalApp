package com.example.hospitalmanagementsystem.service.hospital;

import com.example.hospitalmanagementsystem.models.entities.Hospital;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HospitalDetailsServiceImpl implements UserDetailsService {
    private final HospitalService hospitalService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Hospital hospital=hospitalService.findHospitalByName(username);
        return null;
    }
}
