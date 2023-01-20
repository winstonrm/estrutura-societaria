package com.montreal.banco.service;

import com.montreal.banco.model.Acionista;
import com.montreal.banco.model.Empresa;

public interface EmpresaService {

	public Empresa criarEmpresa(String nome);
	
	public void adicionarEmpresa(Empresa empresa, Empresa empresaSocia);

	public void adicionarAcionista(Empresa empresa, Acionista acionista);

	public void adicionarValorImovel(Empresa empresa, Double valor);
}
