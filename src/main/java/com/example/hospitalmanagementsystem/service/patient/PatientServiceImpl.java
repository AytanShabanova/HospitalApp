package com.example.hospitalmanagementsystem.service.patient;

import com.example.hospitalmanagementsystem.models.dto.PatientDto;
import com.example.hospitalmanagementsystem.models.entities.Patient;
import com.example.hospitalmanagementsystem.repo.PatientRepo;
import com.example.hospitalmanagementsystem.service.doctor.DoctorServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService{
    private final PatientRepo patientRepo;
    private final ObjectMapper objectMapper;
    private final DoctorServiceImpl doctorServiceImpl;


      public Patient PatientSave(PatientDto patientDto){
          Patient patient =objectMapper.convertValue(patientDto, Patient.class);
          patient.setDoctor(doctorServiceImpl.findDoctorByName(patientDto.getDoctorName()));
          return  patientRepo.save(patient);

      }
      @Override
      public Patient findPatientByName(String name){
          return patientRepo.findUserByName(name).orElseThrow(() -> new NoSuchElementException("User do not find"));
      }
      public List<PatientDto> findAllPartient(){
       return    patientRepo.findAll().stream().map(this::convertPatientDto).toList();
      }
    //private method
    private
    PatientDto convertPatientDto(Patient patient){
      return     PatientDto.builder()
                  .name(patient.getName())
                  .surName(patient.getSurName())
                  .email(patient.getEmail())
                  .password(patient.getPassword())
                  .doctorName(patient.getDoctor()
                          .getName()).build();

    }
}
