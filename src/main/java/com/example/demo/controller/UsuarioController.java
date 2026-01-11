package com.example.demo.controller;

import com.example.demo.model.Usuario;
import com.example.demo.repository.UsuarioRepository;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping( "/usuario" )
@Tag( name = "usuario" )
@CrossOrigin( origins = "*")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    public UsuarioController( UsuarioRepository usuarioRepository ) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    public ResponseEntity<Usuario> save( @RequestBody Usuario usuario ) {
        return ResponseEntity.status( HttpStatus.CREATED ).body( usuarioRepository.save( usuario ) );
    }

    @GetMapping
    public ResponseEntity<List<Usuario>> findAll() {
        return ResponseEntity.ok( usuarioRepository.findAll() );
    }

    @GetMapping("/buscar")
    public ResponseEntity<Usuario> findByEmail( @RequestParam String email ) {
        return ResponseEntity.ok( usuarioRepository.findByEmail( email ) );
    }
}
