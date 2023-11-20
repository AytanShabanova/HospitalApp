package com.example.hospitalmanagementsystem.service.doctor;

import com.example.hospitalmanagementsystem.models.entities.Doctor;

public interface DoctorService {
     Doctor findDoctorByEmail(String email);
     Doctor findDoctorByName(String name);
}
