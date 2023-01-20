package com.montreal.banco.service;

import com.montreal.banco.model.Empresa;
import com.montreal.banco.model.EstruturaSocietaria;

public interface EstruturaSocietariaService {

	public EstruturaSocietaria criarEstrutura();
	
	public void adicionarEmpresa(Empresa empresa);

	//public Double comprometimentoFinanceiro(EstruturaSocietaria estrutura);

	//public Double somaValorTotalImoveisAcionistas(Double total, Set<String> listaIdentificacoes, Set<Acionista> acionistas);
;
}
