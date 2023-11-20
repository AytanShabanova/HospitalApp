package com.example.hospitalmanagementsystem.models.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;
import lombok.experimental.FieldDefaults;

import java.sql.Time;

@Data
@NonNull
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class DoctorDto {
    String doctorFinCode;
    String name;
    String surName;
    String email;
    String password;
    String role;
    String specialty;
    Time workTime;
    String hospitalName;


}
