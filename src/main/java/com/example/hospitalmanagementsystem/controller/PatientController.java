package com.example.hospitalmanagementsystem.controller;
import com.example.hospitalmanagementsystem.models.dto.PatientDto;
import com.example.hospitalmanagementsystem.models.dto.ResponseDto;
import com.example.hospitalmanagementsystem.response.PatientResponse;
import com.example.hospitalmanagementsystem.service.patient.PatientServiceImpl;
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
    @PostMapping(name = "/savePatient")
    public ResponseEntity<Void>savePatient(@RequestBody PatientDto patientDto){
        patientService.PatientSave(patientDto);
       return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.success().getData());

    }@GetMapping("/allPatients")
    public List<PatientDto> getAllPatient() {
        return patientService.findAllPartient();
    }

    @GetMapping("/findByNamePatient")
    public ResponseDto<PatientResponse> findByName(@RequestParam(value = "patientName") String patientName) {
        return ResponseDto.success(patientService.findPatientByName(patientName));
    }


}
