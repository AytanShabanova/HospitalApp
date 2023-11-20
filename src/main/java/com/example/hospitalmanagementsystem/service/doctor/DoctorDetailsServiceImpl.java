package com.example.hospitalmanagementsystem.service.doctor;

import com.example.hospitalmanagementsystem.models.entities.Doctor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DoctorDetailsServiceImpl implements UserDetailsService {
    private final DoctorService doctorService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Doctor doctor=doctorService.findDoctorByName(username);
        return null;
    }
}
