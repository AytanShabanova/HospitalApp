package com.example.hospitalmanagementsystem.models.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Please enter a valid email address")
    @NotBlank(message = "Email field cannot be empty")
            @Email
    String email;
    String password;
    String role;
    String specialty;
    Time workTime;
    String hospitalName;


}
