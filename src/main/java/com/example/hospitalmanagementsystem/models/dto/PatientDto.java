package com.example.hospitalmanagementsystem.models.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PatientDto {
    String name;
    String surName;
    String email;
    String password;
    String doctorName;

}
