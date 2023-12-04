package com.example.hospitalmanagementsystem.service.security.patient;

import com.example.hospitalmanagementsystem.models.entities.Patient;
import com.example.hospitalmanagementsystem.security.proporties.SecurityProperties;
import com.example.hospitalmanagementsystem.service.base.TokenGenerator;
import com.example.hospitalmanagementsystem.service.base.TokenReader;
import com.example.hospitalmanagementsystem.utils.PublicPrivateKeyUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Slf4j
@RequiredArgsConstructor
public class AccessTokenManagerPatient implements TokenGenerator<Patient>,
        TokenReader<Claims> {

    private final SecurityProperties securityProperties;

    @Override
    public String generate(Patient obj) {

        Claims claims = Jwts.claims();
        claims.put("email", obj.getEmail());
        claims.put("role", obj.getRole());

        Date now = new Date();
        Date exp = new Date(now.getTime() + securityProperties.getJwt().getAccessTokenValidityTime());

        return Jwts.builder()
                .setSubject(String.valueOf(obj.getId()))
                .setIssuedAt(now)
                .setExpiration(exp)
                .addClaims(claims)
                .signWith(PublicPrivateKeyUtils.getPrivateKey(), SignatureAlgorithm.RS256)
                .compact();
    }


    @Override
    public Claims read(String token) {
        Claims claims = null;
        try {
            claims = Jwts.parserBuilder()
                    .setSigningKey(PublicPrivateKeyUtils.getPublicKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception ex) {
            throw new RuntimeException("test");
        }

        return claims;
    }

    public String getEmail(String token) {
        Claims claims = read(token);
        return claims.get("email", String.class);
    }


}
