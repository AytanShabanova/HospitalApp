package com.example.hospitalmanagementsystem.service.patient;

import com.example.hospitalmanagementsystem.models.dto.PatientDto;
import com.example.hospitalmanagementsystem.models.entities.Patient;
import org.springframework.stereotype.Service;


public interface PatientService {
    Patient savePatient(PatientDto patientDto);

    Patient findPatientByEmail(String email);



//    boolean checkEmail(String email);
}
