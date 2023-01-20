package com.montreal.banco.service;

import com.montreal.banco.model.Acionista;

public interface PessoaService {
	
	public void adicionarValorImovel(Acionista acionista, Double valor);
	
	public Acionista criarAcionistaPf(String nome, String cpf);
	
	public Acionista criarAcionistaPj(String nome, String cnpj);
	
}
