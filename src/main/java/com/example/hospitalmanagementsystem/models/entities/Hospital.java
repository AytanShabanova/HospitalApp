package com.example.hospitalmanagementsystem.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "hospitals")
public class Hospital {
    @Id
    @GeneratedValue
    Integer id;
    String hospitalName;
    @OneToMany(mappedBy ="hospital")
   List<Doctor>doctors;


}
