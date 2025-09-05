package com.example.demo.model;

import java.util.Date;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "pessoa_fisica")
public class PessoaFisica extends Pessoa {

	private static final long serialVersionUID = 1L;
	

	@Column(nullable = false)
	private String cpf;
	
	@Temporal(TemporalType.DATE)
	private Date dataNascimento;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf( String cpf ) {
		this.cpf = cpf;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento( Date dataNascimento ) {
		this.dataNascimento = dataNascimento;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(cpf);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PessoaFisica other = (PessoaFisica) obj;
		return Objects.equals(cpf, other.cpf);
	}

	
}
