package com.example.hospitalmanagementsystem.controller;
import com.example.hospitalmanagementsystem.models.dto.ResponseDto;
import com.example.hospitalmanagementsystem.models.entities.Doctor;

import com.example.hospitalmanagementsystem.response.DoctorResponse;
import com.example.hospitalmanagementsystem.service.doctor.DoctorServiceImpl;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RequestMapping("/doctor")
@RestController
@RequiredArgsConstructor
public class DoctorController {
    private final DoctorServiceImpl doctorServiceImpl;
//    @PostMapping(name = "/saveDoctor")
//    public ResponseEntity<Void> saveDoctor(@RequestBody DoctorDto doctorDto){
//   doctorServiceImpl.saveDoctor(doctorDto);
//   return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.success().getData());
//    }
    @GetMapping(name = "/allDoctors")
    public List<Doctor>allDoctor(){
       return doctorServiceImpl.getAll();
    }
    @GetMapping("/findByNameDoctor")
    public ResponseDto<DoctorResponse> getDoctorByName(@RequestParam(value = "doctorName") String doctorName){
     return ResponseDto.success(doctorServiceImpl.findDoctorByName(doctorName));

    }
//    @PutMapping("/changePassword/{doctorEmail}")
//    public void changePassword(@RequestBody ChangePasswordPayload changePasswordPayload,
//                               @PathVariable(name = "studentId") Integer doctorId) {
//        doctorServiceImpl.changePassword(changePasswordPayload, doctorId);
//    }





}

