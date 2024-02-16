package com.example.hospitalmanagementsystem.repo;

import com.example.hospitalmanagementsystem.models.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoctorRepo extends JpaRepository<Doctor,Integer> {
    Optional<Doctor>findDoctorByEmail(String email);
    Optional<Doctor>findDoctorByName(String name);
    Boolean existsByEmail(String email);
    Doctor findDoctorById(Integer id);
}
