package com.montreal.banco.model;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Empresa {
	private String nome;
	private Double valorTotalImoveis;
	private Set<Acionista> acionistas;

	public Empresa(String nome) {
		this.nome = nome;
		this.valorTotalImoveis = 0.0;
		this.acionistas = new HashSet<>();
	}

	public void adicionarAcionista(Acionista acionista) {
		acionistas.add(acionista);
	}

	public void adicionarValorImovel(Double valor) {
		valorTotalImoveis += valor;
	}

	public Double getValorTotalImoveis() {
		return valorTotalImoveis;
	}

	public Set<Acionista> getAcionistas() {
		return acionistas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setValorTotalImoveis(Double valorTotalImoveis) {
		this.valorTotalImoveis = valorTotalImoveis;
	}

	public void setAcionistas(Set<Acionista> acionistas) {
		this.acionistas = acionistas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(acionistas, nome, valorTotalImoveis);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		return Objects.equals(acionistas, other.acionistas) && Objects.equals(nome, other.nome)
				&& Objects.equals(valorTotalImoveis, other.valorTotalImoveis);
	}

	@Override
	public String toString() {
		return "Empresa [nome=" + nome + ", valorTotalImoveis=" + valorTotalImoveis + ", acionistas=" + acionistas
				+ "]";
	}

}