package com.example.demo.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table( name = "produto" )
@SequenceGenerator( name = "seq_produto", sequenceName = "seq_produto", allocationSize = 1, initialValue = 1 )
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seq_produto" )
	private Long id;
	
	@Column( nullable = false )
	private String unidade;
	
	@Column( nullable = false )
	private String nome;
	
	@Column( nullable = false )
	private Boolean ativo = Boolean.TRUE;
	
	@Column( columnDefinition = "text", length = 2000, nullable = false )
	private String descricao;
	
	//@ManyToOne
	//@JoinColumn( name = "nota_item_produto_id", nullable = false, foreignKey = @ForeignKey( value = ConstraintMode.CONSTRAINT, name = "nota_item_produto_fk" ) )
	//private NotaItemProduto notaItemProduto;
	
	@Column( nullable = false )
	private Double peso;
	
	@Column( nullable = false )
	private Double largura;
	
	@Column( nullable = false )
	private Double altura;
	
	@Column( nullable = false )
	private Double profundidade;
	
	@Column( nullable = false )
	private BigDecimal valorVenda = BigDecimal.ZERO;
	
	@Column( nullable = false )
	private Integer quantidadeEstoque = 0;
	
	private int quantidadeAlertaEstoque = 0;
	
	private String linkYoutube;
	
	private Boolean alertaQuantidadeEstoque = Boolean.FALSE;
	
	private int quantidadeClick = 0;
	
	

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}

	public Boolean getAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	//public NotaItemProduto getNotaItemProduto() {
		//return notaItemProduto;
	//}

	//public void setNotaItemProduto(NotaItemProduto notaItemProduto) {
	//	this.notaItemProduto = notaItemProduto;
	//}

	public Double getPeso() {
		return peso;
	}

	public void setPeso(Double peso) {
		this.peso = peso;
	}

	public Double getLargura() {
		return largura;
	}

	public void setLargura(Double largura) {
		this.largura = largura;
	}

	public Double getAltura() {
		return altura;
	}

	public void setAltura(Double altura) {
		this.altura = altura;
	}

	public Double getProfundidade() {
		return profundidade;
	}

	public void setProfundidade(Double profundidade) {
		this.profundidade = profundidade;
	}

	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public int getQuantidadeAlertaEstoque() {
		return quantidadeAlertaEstoque;
	}

	public void setQuantidadeAlertaEstoque(int quantidadeAlertaEstoque) {
		this.quantidadeAlertaEstoque = quantidadeAlertaEstoque;
	}

	public String getLinkYoutube() {
		return linkYoutube;
	}

	public void setLinkYoutube(String linkYoutube) {
		this.linkYoutube = linkYoutube;
	}

	public Boolean getAlertaQuantidadeEstoque() {
		return alertaQuantidadeEstoque;
	}

	public void setAlertaQuantidadeEstoque(Boolean alertaQuantidadeEstoque) {
		this.alertaQuantidadeEstoque = alertaQuantidadeEstoque;
	}

	public int getQuantidadeClick() {
		return quantidadeClick;
	}

	public void setQuantidadeClick(int quantidadeClick) {
		this.quantidadeClick = quantidadeClick;
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
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}

	
}
