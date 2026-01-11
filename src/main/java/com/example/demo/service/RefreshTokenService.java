package com.example.demo.service;

import com.example.demo.model.RefreshToken;
import com.example.demo.repository.RefreshTokenRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class RefreshTokenService {

    private final RefreshTokenRepository refreshTokenRepository;

    public RefreshTokenService(RefreshTokenRepository refreshTokenRepository) {
        this.refreshTokenRepository = refreshTokenRepository;
    }

    @Value("${security.jwt.expiration-minutes}")

    private long refreshExpiration;

    public RefreshToken create(Long userId) {
        RefreshToken token = new RefreshToken();
        token.setUserId(userId);
        token.setToken(UUID.randomUUID().toString());
        token.setExpiryDate( LocalDateTime.now().plusMinutes(refreshExpiration));

        token.setRevoked(false);
        return refreshTokenRepository.save(token);
    }
}
