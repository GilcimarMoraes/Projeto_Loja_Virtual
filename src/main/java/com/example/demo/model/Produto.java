package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table( name = "produto" )
@SequenceGenerator( name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1 )
public class Produto {
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seq_produto" )
	private Long id;
	
	private String nome;

}
