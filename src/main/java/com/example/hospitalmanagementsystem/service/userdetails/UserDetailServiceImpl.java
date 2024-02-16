package com.example.hospitalmanagementsystem.service.userdetails;

import com.example.hospitalmanagementsystem.models.entities.Doctor;
import com.example.hospitalmanagementsystem.models.entities.Hospital;
import com.example.hospitalmanagementsystem.models.entities.Patient;
import com.example.hospitalmanagementsystem.models.security.UserDetailSecurity;
import com.example.hospitalmanagementsystem.service.doctor.DoctorService;
import com.example.hospitalmanagementsystem.service.hospital.HospitalService;
import com.example.hospitalmanagementsystem.service.patient.PatientService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class UserDetailServiceImpl implements UserDetailsService {
    DoctorService doctorService;
    PatientService patientService;
    HospitalService hospitalService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        if(doctorService.checkEmail(username)){
            Doctor doctor=doctorService.findDoctorByEmail(username);
            List<SimpleGrantedAuthority>authorities=new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(doctor.getRole()));
            return UserDetailSecurity.builder().email(doctor.getEmail()).password(doctor.getPassword())
                    .authorities(authorities).build();
        } else if (patientService.checkEmail(username)) {
            Patient patient=patientService.findPatientByEmail(username);
            List<SimpleGrantedAuthority>authorities=new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(patient.getRole()));
            return UserDetailSecurity.builder().email(patient.getEmail()).password(patient.getPassword())
                    .authorities(authorities).build();

     } else if (hospitalService.checkEmail(username)) {
           Hospital hospital=hospitalService.findHospitalByEmail(username);
           List<SimpleGrantedAuthority>authorities=new ArrayList<>();
            authorities.add(new SimpleGrantedAuthority(hospital.getRole()));
            return UserDetailSecurity.builder().email(hospital.getEmail()).password(hospital.getPassword())
                    .authorities(authorities).build();
        }
        return null;
    }
}
