package com.example.demo.service;

import com.example.demo.security.CustomUserDetails;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtService {

    private String secret = "DEFAULT_SECRET_KEY_1234567890";
    private long expirationMinutes = 60;

    @Value("${security.jwt.secret:DEFAULT_SECRET_KEY_1234567890}")
    public void setSecret(String secret) {
        this.secret = secret;
    }

    @Value("${security.jwt.expiration-minutes:60}")
    public void setExpirationMinutes(long expirationMinutes) {
        this.expirationMinutes = expirationMinutes;
    }

    public String generateToken( CustomUserDetails usuario ) {
        Map<String, Object> claims = new HashMap<>();
        claims.put( "id", usuario.getId() );
        claims.put( "email", usuario.getEmail() );

        return Jwts.builder()
                .setClaims( claims )
                .setSubject(usuario.getUsername() )
                .setIssuedAt( new Date())
                .setExpiration( Date.from(
                        Instant.now().plus( expirationMinutes, ChronoUnit.MINUTES )))
                .signWith( getKey(), SignatureAlgorithm.HS256 )
                .compact();
    }

    public Key getKey() {
        return  Keys.hmacShaKeyFor( secret.getBytes( StandardCharsets.UTF_8 ) );
    }
}
