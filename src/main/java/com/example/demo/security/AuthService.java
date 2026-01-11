package com.example.demo.security;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.model.RefreshToken;
import com.example.demo.model.Usuario;
import com.example.demo.repository.LoginHistoryRepository;
import com.example.demo.repository.UsuarioRepository;
import com.example.demo.service.JwtService;
import com.example.demo.service.LoginHistoryService;
import com.example.demo.service.RefreshTokenService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;
    private final RefreshTokenService refreshTokenService;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final LoginHistoryRepository loginHistoryRepository;
    private final LoginHistoryService loginHistoryService;

    public AuthService(AuthenticationManager authenticationManager, JwtService jwtService, RefreshTokenService refreshTokenService,
                       UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder, LoginHistoryRepository loginHistoryRepository, LoginHistoryService loginHistoryService) {
        this.authenticationManager = authenticationManager;
        this.jwtService = jwtService;
        this.refreshTokenService = refreshTokenService;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.loginHistoryRepository = loginHistoryRepository;
        this.loginHistoryService = loginHistoryService;
    }

    public JwtResponse login(LoginRequest request ) {
        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.email(), request.senha()));

        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();

        String accessToken = jwtService.generateToken( user );

        RefreshToken refreshToken =
                refreshTokenService.create(user.getId() );

        loginHistoryService.save( user, accessToken );

        return new JwtResponse(accessToken, refreshToken.getToken());
    }

    public void register( RegisterRequest request ) {

        if( usuarioRepository.findByEmail(request.email()) != null ) {
            throw new RuntimeException("Email já cadastrado.");
        }

        Usuario usuario = new Usuario();
        usuario.setEmail( request.email() );
        usuario.setSenha( passwordEncoder.encode( request.senha() ) );

        usuarioRepository.save( usuario );
    }

}

