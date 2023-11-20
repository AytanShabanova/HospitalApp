package com.example.hospitalmanagementsystem.response;

import com.example.hospitalmanagementsystem.models.entities.Hospital;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Time;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DoctorResponse {
    String doctorFinCode;
    String name;
    String surName;
    String email;
    String role;
    String specialty;
    Time workTime;
    Hospital hospital;
}
