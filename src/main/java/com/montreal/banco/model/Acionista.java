package com.montreal.banco.model;

public abstract class Acionista {
    private String nome;
    private Double valorTotalImoveis;

    public Acionista(String nome) {
        this.nome = nome;
        this.valorTotalImoveis = 0.0;
    }

    public void adicionarValorImovel(Double valor) {
        valorTotalImoveis += valor;
    }

    public Double getValorTotalImoveis() {
        return valorTotalImoveis;
    }

    public String getNome() {
        return nome;
    }

    public abstract String getIdentificacao();
}
