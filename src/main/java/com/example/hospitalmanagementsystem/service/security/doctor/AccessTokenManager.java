package com.example.hospitalmanagementsystem.service.security.doctor;


import com.example.hospitalmanagementsystem.models.entities.Patient;
import com.example.hospitalmanagementsystem.security.proporties.SecurityProperties;
import com.example.hospitalmanagementsystem.service.base.TokenGenerator;
import com.example.hospitalmanagementsystem.service.base.TokenReader;
import com.example.hospitalmanagementsystem.service.getters.EmailGetter;
import com.example.hospitalmanagementsystem.utils.PublicPrivateKeyUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.example.hospitalmanagementsystem.constants.TokenConstants.EMAIL_KEY;


@Component
@Slf4j
@RequiredArgsConstructor
public class AccessTokenManager implements TokenGenerator<Patient>, TokenReader<Claims>, EmailGetter {

    private final SecurityProperties securityProperties;

    @Override
    public String generate(Patient obj) {

        Claims claims = Jwts.claims();
        claims.put("email", obj.getEmail());
        claims.put("role", obj.getRole());
        claims.put("name",obj.getName());
        claims.put("surname",obj.getSurName());
        Date now = new Date();
        Date exp = new Date(now.getTime() + securityProperties.getJwtData().getAccessTokenValidityTime());

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
             log.info(ex.getMessage());
        }

        return claims;
    }
    @Override
    public String getEmail(String token) {
        if (read(token) != null) {
            return read(token).get(EMAIL_KEY, String.class);
        } else {
            return null;
        }


    }
}
