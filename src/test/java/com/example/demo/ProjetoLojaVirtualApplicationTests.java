package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.controller.AcessoController;
import com.example.demo.model.Acesso;
import com.example.demo.repository.AcessoRepository;
import com.example.demo.services.AcessoService;

@SpringBootTest( classes = ProjetoLojaVirtualApplication.class)
public class ProjetoLojaVirtualApplicationTests {

	@Autowired
	private AcessoController acessoController;
	
	//@Autowired
	//private AcessoService acessoService;
	
	//@Autowired
	//private AcessoRepository acessoRepository;
	
	@Test
	public void testCadastraAcesso() {
		
		Acesso acesso = new Acesso();
		
		acesso.setDescricao( "ROLE_SECRETARIO 2" );
		
		acessoController.salvarAcesso( acesso );
	}
}
