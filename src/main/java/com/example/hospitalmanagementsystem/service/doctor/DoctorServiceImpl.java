package com.example.hospitalmanagementsystem.service.doctor;

import com.example.hospitalmanagementsystem.models.dto.DoctorDto;
import com.example.hospitalmanagementsystem.models.entities.Doctor;
import com.example.hospitalmanagementsystem.repo.DoctorRepo;
import com.example.hospitalmanagementsystem.service.hospital.HospitalServiceImpl;
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
    private final HospitalServiceImpl hospitalServiceImpl;
    public void saveDoctor(DoctorDto doctorDto){
      Doctor doctor=objectMapper.convertValue(doctorDto, Doctor.class);
      doctor.setHospital(hospitalServiceImpl.findHospitalByName(doctorDto.getHospitalName()));
      doctorRepo.save(doctor);
      
    }
    public List<DoctorDto> getAllDoctors(){
       return doctorRepo.findAll().stream().map(this::convertDoctorDto).toList();
    }
    public void deleteDoctor(Doctor doctor){
        doctorRepo.delete(doctor);
    }
    @Override
    public Doctor findDoctorByEmail(String email){
       return doctorRepo.findDoctorByEmail(email).orElseThrow(() -> new NoSuchElementException("Doctor do not find"));
    }
    @Override
    public Doctor findDoctorByName(String name){
       return doctorRepo.findDoctorByName(name).orElseThrow(() -> new NoSuchElementException("Doctor do not find"));
    }
    private DoctorDto convertDoctorDto(Doctor doctor){
      return   DoctorDto.builder()
                .name(doctor.getName())
                .surName(doctor.getSurName())
                .hospitalName(doctor.getHospital().getHospitalName())
                .email(doctor.getEmail())
                .role(doctor.getRole()).build();
    }

}
