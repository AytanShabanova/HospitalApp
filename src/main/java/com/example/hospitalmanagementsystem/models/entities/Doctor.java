package com.example.hospitalmanagementsystem.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "doctors")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;
    String doctorFinCode;
    String name;
    String surName;
    @Column(unique = true)
    @Email
    String email;
    String password;
    String role;
    String specialty;
    LocalDateTime workTime;
    @OneToMany(mappedBy = "doctor")
    List<Patient> patients;

    @OneToMany(mappedBy = "doctor")
    List<Examination> examinations;
    @ManyToOne
    @JoinColumn(name = "hospital_id", referencedColumnName = "id")
    Hospital hospital;
}
