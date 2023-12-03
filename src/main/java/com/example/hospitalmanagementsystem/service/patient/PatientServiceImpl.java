package com.example.hospitalmanagementsystem.service.patient;

import com.example.hospitalmanagementsystem.models.entities.Patient;
import org.springframework.stereotype.Service;

@Service
public class PatientServiceImpl implements PatientService{
    @Override
    public Patient savePatient(Patient user) {
        return null;
    }

    @Override
    public Patient findPatientByEmail(String email) {
        return null;
    }

    @Override
    public boolean checkEmail(String email) {
        return false;
    }
}
