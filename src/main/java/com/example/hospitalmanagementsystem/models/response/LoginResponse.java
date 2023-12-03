package com.example.hospitalmanagementsystem.models.response;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class LoginResponse {
    String accessToken;
    String email;
}
