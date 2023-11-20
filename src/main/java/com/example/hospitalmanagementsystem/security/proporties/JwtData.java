package com.example.hospitalmanagementsystem.security.proporties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class JwtData {
    String publicKey;
    String privateKey;
    Integer accessTokenValidityTime;

}
