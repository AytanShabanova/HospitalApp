package com.example.hospitalmanagementsystem.models.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Please enter a valid email address")
    @NotBlank(message = "Email field cannot be empty")
    String email;
    String password;
    String role;
    @OneToMany(mappedBy ="hospital")
   List<Doctor>doctors;


}
