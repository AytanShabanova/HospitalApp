package com.example.hospitalmanagementsystem.service.patient;

import com.example.hospitalmanagementsystem.models.entities.Patient;
import org.springframework.stereotype.Service;


public interface PatientService {
    Patient savePatient(Patient user);

    Patient findPatientByEmail(String email);

    boolean checkEmail(String email);
}
