package com.montreal.banco.model;

import lombok.Data;

@Data
public class PessoaJuridica extends Acionista {
    private String cnpj;

    public PessoaJuridica(String nome, String cnpj) {
        super(nome);
        this.cnpj = cnpj;
    }

    @Override
    public String getIdentificacao() {
        return cnpj;
    }
}