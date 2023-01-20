package com.montreal.banco.model;

import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import lombok.Data;

@Data
public class Empresa {
	
	private String nome;
	private Double valorTotalImoveis;
	// Solução encontrada para evitar Referencia Circular. Como o propósito seria somente guardar ela mesma, 
	//e não resgatar na memória no futuro, optei por utilizar o WeakReference
	private Set<WeakReference<Empresa>> empresas;
	private Set<Acionista> acionistasPFePJ;

	public Empresa(String nome) {
		this.nome = nome;
		this.valorTotalImoveis = 0.0;
		this.empresas = new HashSet<>();
		this.acionistasPFePJ = new HashSet<>();
	}

	public Set<WeakReference<Empresa>> getEmpresas() {
		return empresas;
	}
    
	public void adicionarEmpresa(Empresa empresa) {
		empresas.add(new WeakReference<Empresa>(empresa));
		
	}

	public void adicionarAcionista(Acionista acionista) {
		acionistasPFePJ.add(acionista);
	}

	public void adicionarValorImovel(Double valor) {
		valorTotalImoveis += valor;
	}

	public Double getValorTotalImoveis() {
		return valorTotalImoveis;
	}

	public Set<Acionista> getAcionistas() {
		return acionistasPFePJ;
	}

	public void setValorTotalImoveis(Double valorTotalImoveis) {
		this.valorTotalImoveis = valorTotalImoveis;
	}

	public void setAcionistas(Set<Acionista> acionistas) {
		this.acionistasPFePJ = acionistas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(acionistasPFePJ, empresas, nome, valorTotalImoveis);
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
		return Objects.equals(acionistasPFePJ, other.acionistasPFePJ) && Objects.equals(empresas, other.empresas)
				&& Objects.equals(nome, other.nome) && Objects.equals(valorTotalImoveis, other.valorTotalImoveis);
	}

	@Override
	public String toString() {
		return "Empresa [nome=" + nome + ", valorTotalImoveis=" + valorTotalImoveis + ", empresas=" + empresas
				+ ", acionistas=" + acionistasPFePJ + "]";
	}


}