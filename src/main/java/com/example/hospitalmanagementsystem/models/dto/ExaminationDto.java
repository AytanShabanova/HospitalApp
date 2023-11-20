package com.example.hospitalmanagementsystem.models.dto;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.sql.Time;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExaminationDto {
    String barCode;
    LocalDateTime localDateTime;
    String doctorName;
    String patientName;
    String hospitalName;
}
