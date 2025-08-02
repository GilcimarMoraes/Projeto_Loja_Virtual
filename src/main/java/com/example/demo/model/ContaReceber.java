package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.example.demo.enums.StatusContaReceber;

import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table( name = "conta_receber" )
@SequenceGenerator( name = "seq_conta_receber", sequenceName = "seq_conta_receber", initialValue = 1, allocationSize = 1)
public class ContaReceber implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seq_conta_receber")
	private Long id;
	
	private String descricao;
	
	@Enumerated(EnumType.STRING)
	private StatusContaReceber status;
	
	@Temporal( TemporalType.DATE)
	private Date dataVencimento;
	
	@Temporal(TemporalType.DATE)
	private Date dataPagamento;
	
	private BigDecimal valorTotal;
	private BigDecimal valorDesconto;
	
	@ManyToOne(targetEntity = Pessoa.class)
	@JoinColumn( name = "pessoa_id", nullable = false, foreignKey = @ForeignKey(value = ConstraintMode.CONSTRAINT, name = "pessoa_fk"))
	private Pessoa pessoa;
	
	public Long getId() {
		return id;
	}
	public void setId( Long id ) {
		this.id = id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao( String descricao ) {
		this.descricao = descricao;
	}
	
	public StatusContaReceber getStatus() {
		return status;
	}
	
}
