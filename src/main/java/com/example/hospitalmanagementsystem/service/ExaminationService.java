package com.example.hospitalmanagementsystem.service;

import com.example.hospitalmanagementsystem.models.dto.ExaminationDto;
import com.example.hospitalmanagementsystem.models.entities.Examination;
import com.example.hospitalmanagementsystem.repo.ExaminationRepo;
import com.example.hospitalmanagementsystem.service.doctor.DoctorServiceImpl;
import com.example.hospitalmanagementsystem.service.hospital.HospitalServiceImpl;
import com.example.hospitalmanagementsystem.service.patient.PatientServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ExaminationService {
    private final ExaminationRepo examinationRepo;
    private final ObjectMapper objectMapper;
    private final DoctorServiceImpl doctorServiceImpl;
    private final PatientServiceImpl patientService;
    private final HospitalServiceImpl hospitalServiceImpl;
    public Examination turnSave(ExaminationDto examinationDto){
        Examination examination =objectMapper.convertValue(examinationDto, Examination.class);
        examination.setDoctor(doctorServiceImpl.findDoctorByName(examinationDto.getDoctorName()));
        examination.setPatient(patientService.findPatientByName(examinationDto.getPatientName()));

      return   examinationRepo.save(examination);

    }
    public Examination findTurnbyBarCode(String barCode){
      return   examinationRepo.findTurnByBarCode(barCode).orElseThrow(() -> new NoSuchElementException("dont find barcode"));

    }
    public void deleteTurnByBarcode(String barCode){
     examinationRepo.delete(findTurnbyBarCode(barCode));
    }
    public List<ExaminationDto>getAllExamination(){
      return   examinationRepo.findAll().stream().map(this::convertExaminationDto).toList();
    }
    private ExaminationDto convertExaminationDto(Examination examination){
     return ExaminationDto.builder()
                .doctorName(examination.getDoctor().getName())

                .patientName(examination.getPatient().getName())
             .localDateTime(examination.getLocalDateTime()).build();
    }

}
