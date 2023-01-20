package com.montreal.banco.model;

import java.lang.ref.WeakReference;
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

	public Double comprometimentoFinanceiro(Empresa empresa) {
		Double total = 0.0;

		Long isEmpresaSociaDeSiMesma = empresa.getEmpresas().stream().filter(emp -> empresa.equals(emp.get())).count();

		if (!(isEmpresaSociaDeSiMesma > 0)) {
			total = empresa.getValorTotalImoveis();
			acionistas = empresa.getAcionistas();
		}

		Set<String> listaIdentificacoes = new HashSet<>();

		for (WeakReference<Empresa> empWeak : empresa.getEmpresas()) {
			Empresa emp = empWeak.get();
			total += emp.getValorTotalImoveis();

			total = somaValorTotalImoveisAcionistas(total, listaIdentificacoes, emp.getAcionistas());
		}

		total = somaValorTotalImoveisAcionistas(total, listaIdentificacoes, acionistas);

		return total;

	}

//	public Double comprometimentoFinanceiro(EstruturaSocietaria estruturaSoc) {
//		Double total = 0.0;
//
//		Set<String> listaIdentificacoes = new HashSet<>();
//
//		Long isEmpresaSociaDeSiMesma = estruturaSoc.getEmpresas().stream().filter(emp -> estruturaSoc.equals(emp))
//				.count();
//
//		for (Empresa empresa : estruturaSoc.getEmpresas()) {
//			total += empresa.getValorTotalImoveis();
//			
//			if (!(isEmpresaSociaDeSiMesma > 0)) {
//				total = empresa.getValorTotalImoveis();
//				acionistas = estruturaSoc.getAcionistas();
//			}
//			
//		}
//		
//		for (WeakReference<Empresa> empWeak : empresa.getEmpresas()) {
//			Empresa emp = empWeak.get();
//			total += emp.getValorTotalImoveis();
//
//			total = somaValorTotalImoveisAcionistas(total, listaIdentificacoes, emp.getAcionistas());
//		}
//
//
//
//		total = somaValorTotalImoveisAcionistas(total, listaIdentificacoes, acionistas);
//
//		return total;
//
//	}

	public Double somaValorTotalImoveisAcionistas(Double total, Set<String> listaIdentificacoes,
			Set<Acionista> acionistas) {
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
