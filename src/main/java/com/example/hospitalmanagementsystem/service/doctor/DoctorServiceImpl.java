package com.example.hospitalmanagementsystem.service.doctor;

import com.example.hospitalmanagementsystem.models.dto.DoctorDto;
import com.example.hospitalmanagementsystem.models.entities.Doctor;

import com.example.hospitalmanagementsystem.repo.DoctorRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService{
    private final DoctorRepo doctorRepo;
    private final ObjectMapper objectMapper;

    @Override
    public List<Doctor> getAll() {
       return doctorRepo.findAll();
    }



    @Override
    public Doctor saveDoctor(DoctorDto doctorDto) {
      Doctor doctor=  objectMapper.convertValue(doctorDto, Doctor.class);

      return  doctorRepo.save(doctor);
    }

    @Override
    public Doctor findDoctorByEmail(String email) {
        return  doctorRepo.findDoctorByEmail(email).orElseThrow(() -> new NoSuchElementException("doctor emaili tapilmadi"));
    }

    @Override
    public boolean checkEmail(String email) {
        return doctorRepo.existsByEmail(email);
    }

    @Override
    public Doctor findDoctorByName(String name) {
       return doctorRepo.findDoctorByName(name).orElseThrow(() -> new NoSuchElementException("doctor adi tapilmadi"));
    }
}
