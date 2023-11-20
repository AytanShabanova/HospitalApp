package com.example.hospitalmanagementsystem.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "turns")
@Data
public class Examination {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    Integer id;
    String barCode;
    LocalDateTime localDateTime;
    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    Doctor doctor;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    Patient patient;

}
