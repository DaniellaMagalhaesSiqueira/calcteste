package com.example.demo;

public enum DiasSemana {

	
	SE("SEGUNDA"), TE("TERÇA"), QA("QUARTA"), QI("QUINTA"),
	SX("SEXTA"), SA("SÁBADO"), DO("DOMINGO");
	
	private String nome;

	private DiasSemana(String nome){
		this.nome = nome;
	}
	
	@Override
	public String  toString() {
		return this.nome;
	}
	
}
