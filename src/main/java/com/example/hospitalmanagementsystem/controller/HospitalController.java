//package com.example.hospitalmanagementsystem.controller;
//
//import com.example.hospitalmanagementsystem.models.dto.HospitalDto;
//import com.example.hospitalmanagementsystem.models.dto.ResponseDto;
//import com.example.hospitalmanagementsystem.response.HospitalResponse;
//import com.example.hospitalmanagementsystem.service.hospital.HospitalServiceImpl;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping( "/hospital")
//public class HospitalController {
//    private final HospitalServiceImpl hospitalServiceImpl;
//    @PostMapping(name = "/saveHospital")
//    public ResponseEntity<Void>saveHospital(@RequestBody HospitalDto hospitalDto){
//        hospitalServiceImpl.hospitalSave(hospitalDto);
//        return ResponseEntity.status(HttpStatus.OK).body(ResponseDto.success().getData());
//    }
//    @GetMapping("/allHospitals")
//    public List<HospitalDto> getAllHospital() {
//        return hospitalServiceImpl.getAllHospital();
//    }
//
//    @GetMapping("/findHospitalByName")
//    public ResponseDto<HospitalResponse> findHospitalByName(@RequestParam(value = "hospitalName") String hospitalName) {
//        return ResponseDto.success(hospitalServiceImpl.findHospitalByName(hospitalName));
//    }
//
//
//
//}
