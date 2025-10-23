package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Acesso;
import com.example.demo.repository.AcessoRepository;

public class AcessoService {

	@Autowired
	private AcessoRepository acessoRepository;
	
	public Acesso save( Acesso acesso ) {
		return acessoRepository.save( acesso );
	}
}
