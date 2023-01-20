package com.montreal.banco.model;

import java.util.HashSet;
import java.util.Set;

public class EstruturaSocietaria {
	private Set<Empresa> empresas;
	private Set<Acionista> acionistas;

	public EstruturaSocietaria() {
		this.empresas = new HashSet<>();
		this.acionistas = new HashSet<>();
	}	

	public void adicionarEmpresa(Empresa empresa) {
		empresas.add(empresa);
	}

	public Set<Empresa> getEmpresas() {
		return empresas;
	}

	public void setEmpresas(Set<Empresa> empresas) {
		this.empresas = empresas;
	}

	public Set<Acionista> getAcionistas() {
		return acionistas;
	}

	public void setAcionistas(Set<Acionista> acionistas) {
		this.acionistas = acionistas;
	}

	public Double comprometimentoFinanceiro() {
		Double total = 0.0;
		Set<String> listaIdentificacoes = new HashSet<>();

		for (Empresa empresa : empresas) {
			total += empresa.getValorTotalImoveis();

			total = somaValorTotalImoveisAcionistas(total, listaIdentificacoes, empresa.getAcionistas());
		}

		total = somaValorTotalImoveisAcionistas(total, listaIdentificacoes, acionistas);

		return total;

	}

	public Double comprometimentoFinanceiro(EstruturaSocietaria estruturaSocietaria) {
		Double total = 0.0;
		Set<String> listaIdentificacoes = new HashSet<>();
		
		// Listando as empresas e somando os valores de imóveis
		for (Empresa empresa : estruturaSocietaria.getEmpresas()) {
			total += empresa.getValorTotalImoveis();

			total = somaValorTotalImoveisAcionistas(total, listaIdentificacoes, empresa.getAcionistas());
		}

		total = somaValorTotalImoveisAcionistas(total, listaIdentificacoes, acionistas);

		return total;
	}

	public Double somaValorTotalImoveisAcionistas(Double total, Set<String> listaIdentificacoes, Set<Acionista> acionistas) {
		for (Acionista acionista : acionistas) {
			String identificacao = acionista.getIdentificacao();
			
			// Verifica se já existe
			if (!listaIdentificacoes.contains(identificacao)) {
				listaIdentificacoes.add(identificacao);
				total += acionista.getValorTotalImoveis();
			}
		}
		return total;
	}

}
