package com.montreal.banco.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.montreal.banco.model.Acionista;
import com.montreal.banco.model.PessoaFisica;
import com.montreal.banco.model.PessoaJuridica;
import com.montreal.banco.util.ValidateCpfCnpj;

public class PessoaServiceImpl implements PessoaService {
	
	final Logger LOGGER = LoggerFactory.getLogger(PessoaServiceImpl.class);
	
	public void adicionarValorImovel(Acionista acionista, Double valor) {
		acionista.setValorTotalImoveis(valor);
	}
	
	public Acionista criarAcionistaPf(String nome, String cpf) {
				
		if (ValidateCpfCnpj.isCPF(cpf)) {
			LOGGER.info(cpf + " é válido.");

			// Criando acionistas	
			PessoaFisica acionistaPf = new PessoaFisica(nome, cpf);
			
			return acionistaPf;
		}		
		return null;
				
	}
	
	public Acionista criarAcionistaPj(String nome, String cnpj) {
		
		if (ValidateCpfCnpj.isCNPJ(cnpj)) {
			LOGGER.info(cnpj + " é válido.");
			
			// Criando acionistas	
			PessoaJuridica acionistaPj = new PessoaJuridica(nome, cnpj);
			
			return acionistaPj;
		}		
		return null;
		
	}
}
