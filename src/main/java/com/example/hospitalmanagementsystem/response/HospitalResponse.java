package com.example.hospitalmanagementsystem.response;
import lombok.*;
import lombok.experimental.FieldDefaults;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class HospitalResponse {
  String HospitalName;


}
