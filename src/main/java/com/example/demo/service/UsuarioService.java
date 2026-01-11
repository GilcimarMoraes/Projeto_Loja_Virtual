package com.example.demo.service;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    public final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario findByEmail( String email ) {
        return usuarioRepository.findByEmail( email );
    }

    public Usuario save( Usuario usuario) {
        return usuarioRepository.save(usuario);
    }
}
