package com.example.hospitalmanagementsystem.models.dto;

import com.example.hospitalmanagementsystem.models.entities.Doctor;
import com.example.hospitalmanagementsystem.models.entities.Examination;
import com.example.hospitalmanagementsystem.models.entities.Patient;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HospitalDto {
  String hospitalName;




}
