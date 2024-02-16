package com.example.hospitalmanagementsystem.service.hospital;

import com.example.hospitalmanagementsystem.models.dto.HospitalDto;
import com.example.hospitalmanagementsystem.models.entities.Hospital;

import java.util.List;

public interface HospitalService {
    void changeHospitalName(Integer id,String name);
    List<Hospital> getAllHospitals();
    void deleteHospital(Hospital hospital);
    boolean checkEmail(String email);
    Hospital findHospitalByEmail(String email);
    Hospital saveHospital(HospitalDto hospitalDto);

}
