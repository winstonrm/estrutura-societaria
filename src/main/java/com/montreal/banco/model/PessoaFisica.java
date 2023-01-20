package com.montreal.banco.model;

import lombok.Data;

@Data
public class PessoaFisica extends Acionista {
	private String cpf;

	public PessoaFisica(String nome, String cpf) {
		super(nome);
		this.cpf = cpf;
	}

	@Override
	public String getIdentificacao() {
		return cpf;
	}

}