package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table( name = "notaFiscalCompra" )
@SequenceGenerator( name = "seq_notaFiscalCompra", sequenceName = "seq_notaFicalCompra", allocationSize = 1, initialValue = 1 )
public class NotaFiscalCompra implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seq_notaFiscalCompra" )
	private Long id;
	
	@Column( nullable = false )
	private String numeroNota;
	
	@Column( nullable = false )
	private String serie;
	
	@Column( columnDefinition = "text" )
	private String descricao;
	
	@Column( nullable = false )
	private BigDecimal valorTotal;
	
	private BigDecimal valorDesconto;
	
	@Column( nullable = false )
	private BigDecimal valorIcms;
	
	@Column( nullable = false )
	@Temporal( TemporalType.DATE )
	private Date dataCompra;
	
	@ManyToOne
	@JoinColumn( name = "pessoa_id", nullable = false, foreignKey = @ForeignKey( value = ConstraintMode.CONSTRAINT, name = "produto_fk" ) )
	private Pessoa pessoa;
	
	@ManyToOne
	@JoinColumn( name = "conta_pagar_id", nullable = false, foreignKey = @ForeignKey( value = ConstraintMode.CONSTRAINT, name = "conta_pagar_fk" ) )
	private ContaPagar contaPagar;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumeroNota() {
		return numeroNota;
	}

	public void setNumeroNota(String numeroNota) {
		this.numeroNota = numeroNota;
	}

	public String getSerie() {
		return serie;
	}

	public void setSerie(String serie) {
		this.serie = serie;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}

	public BigDecimal getValorDesconto() {
		return valorDesconto;
	}

	public void setValorDesconto(BigDecimal valorDesconto) {
		this.valorDesconto = valorDesconto;
	}

	public BigDecimal getValorIcms() {
		return valorIcms;
	}

	public void setValorIcms(BigDecimal valorIcms) {
		this.valorIcms = valorIcms;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaFiscalCompra other = (NotaFiscalCompra) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
