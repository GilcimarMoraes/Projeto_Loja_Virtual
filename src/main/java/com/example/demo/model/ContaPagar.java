package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.example.demo.enums.StatusContaPagar;

import jakarta.persistence.Column;
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
@Table( name = "conta_pagar" )
@SequenceGenerator( name = "seq_conta_pagar", sequenceName = "seq_conta_pagar", initialValue = 1, allocationSize = 1)
public class ContaPagar implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seq_conta_pagar")
	private Long id;
	
	@Column( nullable = false )
	private String descricao;
	
	@Column( nullable = false )
	private BigDecimal valorTotal;
	
	private BigDecimal valorDesconto;
	
	@Column( nullable = false )
	@Temporal( TemporalType.DATE )
	private Date dataVencimento;
	
	@Temporal( TemporalType.DATE )
	private Date dataPagamento;
	
	@Column( nullable = false )
	@Enumerated(EnumType.STRING)
	private StatusContaPagar status;
	
	@ManyToOne( targetEntity = Pessoa.class)
	@JoinColumn( name = "pessoa_id", nullable = false, 
		foreignKey = @ForeignKey( value = ConstraintMode.CONSTRAINT, name = "pessoa_fk" ))
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn( name = "pessoa_fornecedor_id", nullable = false, 
		foreignKey = @ForeignKey( value = ConstraintMode.CONSTRAINT, name = "pessoa_fornecedor_fk"))
	private Pessoa pessoaFornecedor;
	
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
	
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal( BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	
	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}
	public void setValorDesconto( BigDecimal valorDesconto ) {
		this.valorDesconto = valorDesconto;
	}
	
	public Date getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento( Date dataVencimento ) {
		this.dataVencimento = dataVencimento;
	}
	
	public Date getDataPagamento() {
		return dataPagamento;
	}
	public void setDataPagamento( Date dataPagamento ) {
		this.dataPagamento = dataPagamento;
	}
	
	public StatusContaPagar getStatus() {
		return status;
	}
	public void setStatus( StatusContaPagar status ) {
		this.status = status;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}
	public void setPessoa( Pessoa pessoa ) {
		this.pessoa = pessoa;
	}
	public Pessoa getPessoaFornecedor() {
		return pessoaFornecedor;
	}
	public void setPessoaFornecedor(Pessoa pessoaFornecedor) {
		this.pessoaFornecedor = pessoaFornecedor;
	}
	
	
}
	