package com.example.hospitalmanagementsystem.service.patient;

import com.example.hospitalmanagementsystem.models.dto.PatientDto;
import com.example.hospitalmanagementsystem.models.entities.Patient;
import com.example.hospitalmanagementsystem.repo.PatientRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService{
    private final PatientRepo patientRepo;
    private final ObjectMapper objectMapper;
    @Override
    public Patient savePatient(PatientDto patientDto) {
       Patient patient= objectMapper.convertValue(patientDto, Patient.class);

      return patientRepo.save(patient);    }

    @Override
    public Patient findPatientByEmail(String email) {
       return patientRepo.findPatientByEmail(email).orElseThrow(() -> new NoSuchElementException("patient tapilmadi"));

    }



//    @Override
//    public boolean checkEmail(String email) {
//
//
//    }
}
