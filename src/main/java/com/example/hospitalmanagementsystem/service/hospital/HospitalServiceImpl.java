package com.example.hospitalmanagementsystem.service.hospital;

import com.example.hospitalmanagementsystem.models.dto.HospitalDto;
import com.example.hospitalmanagementsystem.models.entities.Doctor;
import com.example.hospitalmanagementsystem.models.entities.Hospital;
import com.example.hospitalmanagementsystem.repo.HospitalRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepo hospitalRepo;
    private final ObjectMapper objectMapper;
    @Override
    public void changeHospitalName(Integer id,String name) {
      Hospital hospital=  hospitalRepo.findHospitalById(id).orElseThrow();
      hospital.setHospitalName(name);
      hospitalRepo.save(hospital);
    }

    @Override
    public List<Hospital> getAllHospitals() {
     return hospitalRepo.findAll();
    }

    @Override
    public void deleteHospital(Hospital hospital) {
        hospitalRepo.delete(hospital);

    }

    @Override
    public boolean checkEmail(String email) {
        return  hospitalRepo.existsHospitalByEmail(email);
    }

    @Override
    public Hospital findHospitalByEmail(String email) {
        return hospitalRepo.findHospitalByHospitalName(email).orElseThrow(() -> new NoSuchElementException("HOSPITAL DO NOT FOUND"));
    }

    @Override
    public  Hospital saveHospital(HospitalDto hospitalDto) {
        Hospital hospital=  objectMapper.convertValue(hospitalDto, Hospital.class);

        return  hospitalRepo.save(hospital);
    }
}
