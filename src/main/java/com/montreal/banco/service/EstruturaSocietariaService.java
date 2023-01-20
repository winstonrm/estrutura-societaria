package com.montreal.banco.service;

import com.montreal.banco.model.Acionista;
import com.montreal.banco.model.Empresa;

public interface EstruturaSocietariaService {
	public void adicionarEmpresa(Empresa empresa);

	public void adicionarAcionista(Acionista acionista);
	
	public void adicionarEmpresaPrincipal(Empresa empresa);
	
	public Double comprometimentoFinanceiro();
	
}
