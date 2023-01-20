package com.montreal.banco.model;

import java.util.Set;

public class EmpresaSocia {
	private String nome;
	private Double valorTotalImoveis;
	private Set<Acionista> acionistas;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Double getValorTotalImoveis() {
		return valorTotalImoveis;
	}
	public void setValorTotalImoveis(Double valorTotalImoveis) {
		this.valorTotalImoveis = valorTotalImoveis;
	}
	public Set<Acionista> getAcionistas() {
		return acionistas;
	}
	public void setAcionistas(Set<Acionista> acionistas) {
		this.acionistas = acionistas;
	}
	
	
	
}
