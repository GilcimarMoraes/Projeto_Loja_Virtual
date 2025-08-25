package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table( name = "notaFiscalCompra" )
@SequenceGenerator( name = "seq_notaFiscalCompra", sequenceName = "seq_notaFicalCompra", allocationSize = 1, initialValue = 1 )
public class NotaFiscalCompra implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seq_notaFiscalCompra" )
	private Long id;
}
