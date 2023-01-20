package com.montreal.banco.service;

import org.springframework.stereotype.Service;

import com.montreal.banco.model.Acionista;
import com.montreal.banco.model.PessoaFisica;
import com.montreal.banco.model.PessoaJuridica;
import com.montreal.banco.util.ValidateCpfCnpj;

@Service
public class PessoaServiceImpl implements PessoaService {
	
	public void adicionarValorImovel(Acionista acionista, Double valor) {
		acionista.setValorTotalImoveis(valor);
	}
	
	public Acionista criarAcionistaPf(String nome, String cpf) {
				
		if (ValidateCpfCnpj.isCPF(cpf)) {
			System.out.println(cpf + " é válido.");

			// Criando acionistas	
			PessoaFisica acionistaPf = new PessoaFisica(nome, cpf);
			
			return acionistaPf;
		}		
		return null;
				
	}
	
	public Acionista criarAcionistaPj(String nome, String cnpj) {
		
		if (ValidateCpfCnpj.isCNPJ(cnpj)) {
			System.out.println(cnpj + " é válido.");
			
			// Criando acionistas	
			PessoaJuridica acionistaPj = new PessoaJuridica(nome, cnpj);
			
			return acionistaPj;
		}		
		return null;
		
	}
}
