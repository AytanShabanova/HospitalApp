package com.example.hospitalmanagementsystem.repo;

import com.example.hospitalmanagementsystem.models.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PatientRepo extends JpaRepository<Patient,Integer> {
    Optional<Patient>findPatientByEmail(String email);
    Optional<Patient>findPatientByName(String name);
    Boolean existsByEmail(String email);
}
