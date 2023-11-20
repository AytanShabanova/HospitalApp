package com.example.hospitalmanagementsystem.service;



import com.example.hospitalmanagementsystem.security.proporties.SecurityProperties;

import com.example.hospitalmanagementsystem.utils.PublicPrivateKeyUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;

@RequiredArgsConstructor
@Service
public class TestService {
    private final SecurityProperties securityProperties;
//    public String testJwt(){
//        Claims claims = Jwts.claims();
//
//
//        Date now = new Date();
//        Date exp = new Date(now.getTime() + securityProperties.getJwtData().getAccessTokenValidityTime());
//
//        return Jwts.builder()
//                .setSubject(String.valueOf(1))
//                .setIssuedAt(now)
//                .setExpiration(exp)
//                .addClaims(claims)
//                .signWith(PublicPrivateKeyUtils.getPrivateKey(), SignatureAlgorithm.RS256)
//                .compact();
//    }
}
