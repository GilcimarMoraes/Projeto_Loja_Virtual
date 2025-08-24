package com.example.demo.model;

import java.io.Serializable;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table( name = "vd_cp_loja_virt" )
@SequenceGenerator( name = "seq_vd_cp_loja_virt", sequenceName = "seq_vd_cp_loja_virt", initialValue = 1, allocationSize = 1 )
public class VendaCompraLojaVirtual implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seq_vd_cp_loja_virt")
	private Long id;
	
	@ManyToOne( targetEntity = Pessoa.class )
	@JoinColumn( name = "pessoa_id", nullable = false, foreignKey = @ForeignKey( value = ConstraintMode.CONSTRAINT, name = "pessoa_fk" ) )
	private Pessoa pessoa;

}
