package com.example.hospitalmanagementsystem.repo;

import com.example.hospitalmanagementsystem.models.entities.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface HospitalRepo extends JpaRepository<Hospital,Integer> {
    Optional<Hospital>findHospitalByHospitalName(String name);
}
