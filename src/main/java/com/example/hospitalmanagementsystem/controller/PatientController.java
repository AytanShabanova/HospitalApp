package com.example.hospitalmanagementsystem.controller;
import com.example.hospitalmanagementsystem.models.dto.PatientDto;
import com.example.hospitalmanagementsystem.models.dto.ResponseDto;
import com.example.hospitalmanagementsystem.models.entities.Patient;
import com.example.hospitalmanagementsystem.response.PatientResponse;
import com.example.hospitalmanagementsystem.service.patient.PatientServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/patient")
public class PatientController {
    private final PatientServiceImpl patientService;
    private final ObjectMapper objectMapper;
    @PostMapping(name = "/savePatient")
    public ResponseEntity<Void>savePatient(@RequestBody PatientDto patientDto) {
        patientService.savePatient(patientDto);
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.success().getData());
    }
//    @GetMapping("/allPatients")
//    public List<PatientDto> getAllPatient() {
//        return patientService.();
//    }
    @GetMapping("/email")
    public ResponseEntity<PatientResponse>findPatientByEmail(@RequestParam String email){
     Patient patient=patientService.findPatientByEmail(email);
    PatientResponse patientResponse=  objectMapper.convertValue(patient,PatientResponse.class);
      return ResponseEntity.ok(patientResponse);

    }




}
