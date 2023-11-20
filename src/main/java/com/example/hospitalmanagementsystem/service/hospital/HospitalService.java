package com.example.hospitalmanagementsystem.service.hospital;

import com.example.hospitalmanagementsystem.models.entities.Hospital;

public interface HospitalService  {
    Hospital findHospitalByName(String name);
}
