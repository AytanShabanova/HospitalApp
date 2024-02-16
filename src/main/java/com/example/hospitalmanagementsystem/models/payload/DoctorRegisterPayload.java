package com.example.hospitalmanagementsystem.models.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class DoctorRegisterPayload {
    String name;
    String surName;
    @Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+\\\\.[a-zA-Z0-9-.]+$", message = "Please enter a valid email address")
    @NotBlank(message = "Email field cannot be empty")
            @Email
    String email;
    String password;
    String specialty;
}
