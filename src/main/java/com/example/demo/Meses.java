package com.example.demo;

public enum Meses {

	JA("Janeiro"), FE("Fevereiro"), MR("Março"), AB("Abril"), MA("Maio"), JN("Junho"), JL("Julho"), AG("Agosto"), SE("Setembro"), 
	OU("Outubro"), NO("Novembro"), DE("Dezembro");
	
	private String nome;
	
	private Meses(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
}
