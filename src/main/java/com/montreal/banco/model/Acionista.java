package com.montreal.banco.model;

import java.util.Objects;

public abstract class Acionista {
	private String nome;
	private Double valorTotalImoveis;

	public Acionista(String nome) {
		this.nome = nome;
		this.valorTotalImoveis = 0.0;
	}

	public void adicionarValorImovel(Double valor) {
		valorTotalImoveis += valor;
	}

	public Double getValorTotalImoveis() {
		return valorTotalImoveis;
	}

	public String getNome() {
		return nome;
	}

	public abstract String getIdentificacao();

	@Override
	public int hashCode() {
		return Objects.hash(nome, valorTotalImoveis);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Acionista other = (Acionista) obj;
		return Objects.equals(nome, other.nome) && Objects.equals(valorTotalImoveis, other.valorTotalImoveis);
	}


}
