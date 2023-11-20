package com.example.hospitalmanagementsystem.service.hospital;

import com.example.hospitalmanagementsystem.models.dto.HospitalDto;
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
    private  final ObjectMapper objectMapper;
    public Hospital hospitalSave(HospitalDto hospitalDto){
        Hospital hospital=objectMapper.convertValue(hospitalDto,Hospital.class);
     return    hospitalRepo.save(hospital);

    }
    @Override
    public Hospital findHospitalByName(String name){
       return hospitalRepo.findHospitalByHospitalName(name).orElseThrow(() -> new NoSuchElementException("Hospital dont find"));
    }
    public void deleteHospital(Hospital hospital){
  hospitalRepo.delete(hospital);
    }
    public List<HospitalDto>getAllHospital(){
       return hospitalRepo.findAll().stream().map(this::convertHospitalDto).toList();
    }
    private HospitalDto convertHospitalDto(Hospital hospital){
      return   HospitalDto.builder().hospitalName(hospital.getHospitalName()).build();
    }

}
