package com.example.demo.model;

import java.io.Serializable;
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

@Entity
@SequenceGenerator( name = "seq_item_venda_loja", sequenceName = "seq_item_venda_loja", allocationSize = 1, initialValue = 1 )
public class ItemVendaLoja implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy = GenerationType.SEQUENCE, generator = "seq_item_venda_loja")
	private Long id;
	
	@ManyToOne
	@JoinColumn( name = "produto_id", nullable = false, foreignKey = @ForeignKey( value = ConstraintMode.CONSTRAINT, name = "produto_fk" ) )
	private Produto produto;
	
	@ManyToOne
	@JoinColumn( name = "venda_compra_loja_virtual_id", nullable = false, foreignKey = @ForeignKey( value = ConstraintMode.CONSTRAINT, name = "venda_compra_loja_virtual_fk" ) )
	private VendaCompraLojaVirtual vendaCompraLojaVirtual;
	
	@Column( nullable = false )
	private Double quantidade;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public VendaCompraLojaVirtual getVendaCompraLojaVirtual() {
		return vendaCompraLojaVirtual;
	}

	public void setVendaCompraLojaVirtual(VendaCompraLojaVirtual vendaCompraLojaVirtual) {
		this.vendaCompraLojaVirtual = vendaCompraLojaVirtual;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
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
		ItemVendaLoja other = (ItemVendaLoja) obj;
		return Objects.equals(id, other.id);
	}
	
		

}
