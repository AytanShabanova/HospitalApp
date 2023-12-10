package com.example.hospitalmanagementsystem.service.doctor;

import com.example.hospitalmanagementsystem.models.dto.DoctorDto;
import com.example.hospitalmanagementsystem.models.entities.Doctor;
import com.example.hospitalmanagementsystem.models.entities.Patient;
import com.example.hospitalmanagementsystem.repo.DoctorRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DoctorService {
    List<Doctor> getAll();
   Doctor saveDoctor(DoctorDto doctor);

    Doctor findDoctorByEmail(String email);

    boolean checkEmail(String email);
    Doctor findDoctorByName(String name);
}
