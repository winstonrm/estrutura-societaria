package com.montreal.banco.service;

import java.lang.ref.WeakReference;

import org.springframework.stereotype.Service;

import com.montreal.banco.model.Empresa;
import com.montreal.banco.model.EstruturaSocietaria;

@Service
public class EstruturaSocietariaServiceImpl implements EstruturaSocietariaService {

	public EstruturaSocietaria criarEstrutura() {		
		EstruturaSocietaria estruturaSocietaria = new EstruturaSocietaria();

		return estruturaSocietaria;
	}
	
	public void adicionarEmpresa(Empresa empresa) {
		 empresa.getEmpresas().add(new WeakReference<Empresa>(empresa));
	}
	
//	public Double comprometimentoFinanceiro(EstruturaSocietaria estrutura) {
//		Double total = 0.0;
//		Set<String> listaIdentificacoes = new HashSet<>();
//
//		for (Empresa empresa : estrutura.getEmpresas()) {
//			total += empresa.getValorTotalImoveis();
//
//			total = somaValorTotalImoveisAcionistas(total, listaIdentificacoes, empresa.getAcionistas());
//		}
//
//		total = somaValorTotalImoveisAcionistas(total, listaIdentificacoes, estrutura.getAcionistas());
//
//		return total;
//
//	}
//
//	public Double somaValorTotalImoveisAcionistas(Double total, Set<String> listaIdentificacoes, Set<Acionista> acionistas) {
//		for (Acionista acionista : acionistas) {
//			String identificacao = acionista.getIdentificacao();
//			
//			// Verifica se já existe
//			if (!listaIdentificacoes.contains(identificacao)) {
//				listaIdentificacoes.add(identificacao);
//				total += acionista.getValorTotalImoveis();
//			}
//		}
//		return total;
//	}


}
