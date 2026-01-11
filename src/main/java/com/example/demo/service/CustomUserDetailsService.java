package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.security.CustomUserDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsuarioService usuarioService;

    public CustomUserDetailsService( UsuarioService usuarioService ) {
        this.usuarioService = usuarioService;
    }

    @Override
    public UserDetails loadUserByUsername(String email ) throws UsernameNotFoundException {
        Usuario usuario = usuarioService.findByEmail( email );

        if ( usuario == null ) {
            throw new UsernameNotFoundException( "Usuario no encontrado." );
        }

        return new CustomUserDetails( usuario );
    }
}
