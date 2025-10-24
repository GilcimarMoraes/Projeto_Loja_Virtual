package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Acesso;
import com.example.demo.services.AcessoService;

@Controller
public class AcessoController {

	@Autowired
	private AcessoService acessoService;
	
	@PostMapping( "/salvarAcesso" )
	public Acesso salvarAcesso( Acesso acesso ) {
		
		return acessoService.save( acesso );
	
	}
}
