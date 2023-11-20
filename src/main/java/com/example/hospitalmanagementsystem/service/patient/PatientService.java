package com.example.hospitalmanagementsystem.service.patient;

import com.example.hospitalmanagementsystem.models.entities.Patient;

public interface PatientService {
    Patient findPatientByName(String name);
}
