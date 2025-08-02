package com.example.demo.enums;

public enum StatusContaPagar {
	
	COBRANCA( "cobranca" ),
	VENCIDA( "Vencida" ),
	ABERTA( "Aberta" ),
	QUITADA( "Quitada" ),
	NEGOCIADA( "Renegociada" );
	
	private String descricao;
	
	private StatusContaPagar( String descricao ) {
		this.descricao = descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return this.descricao;
	}

}
