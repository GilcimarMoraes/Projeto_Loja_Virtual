package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.security.AuthService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping( "/auth" )
@Tag( name = "Auth" )
public class AuthController {

    private final AuthService authService;

    public AuthController( AuthService authService ) {
        this.authService = authService;
    }

    @PostMapping( "/login" )
    public JwtResponse login(@RequestBody LoginRequest request ) {
        return authService.login( request );
    }

    @PostMapping( "/register" )
    public ResponseEntity<Void> register(@RequestBody RegisterRequest request ) {
        authService.register( request );
        return ResponseEntity.status( HttpStatus.CREATED ).build();
    }

}

