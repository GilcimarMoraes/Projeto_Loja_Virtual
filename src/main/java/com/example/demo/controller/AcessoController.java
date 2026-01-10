package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.model.Acesso;
import com.example.demo.service.AcessoService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RestController
@RequestMapping( "acesso" )
public class AcessoController {

	@Autowired
	private AcessoService acessoService;

	@ResponseBody /*Poder dar um retorno da API*/
	@PostMapping( value = "/salvarAcesso" ) /*Mapeando a url para receber JSON*/
	public ResponseEntity<Acesso> salvarAcesso(@RequestBody Acesso acesso ) { /*Request recebe um JSON e devolve um objeto*/

		Acesso acessoSalvo = acessoService.save( acesso );

		return new ResponseEntity<Acesso>( acessoSalvo, HttpStatus.OK );
	
	}
}
