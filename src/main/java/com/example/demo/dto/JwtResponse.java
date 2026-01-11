package com.example.demo.dto;

public record JwtResponse(
        String acessToken,
        String refreshToken
) {
}
