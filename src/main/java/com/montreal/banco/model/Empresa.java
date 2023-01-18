package com.montreal.banco.model;

import java.util.HashSet;
import java.util.Set;

public class Empresa {
    private String nome;
    private Double valorTotalImoveis;
    private Set<Acionista> acionistas;

    public Empresa(String nome) {
        this.nome = nome;
        this.valorTotalImoveis = 0.0;
        this.acionistas = new HashSet<>();
    }

    public void adicionarAcionista(Acionista acionista) {
        acionistas.add(acionista);
    }

    public void adicionarValorImovel(Double valor) {
        valorTotalImoveis += valor;
    }

    public Double getValorTotalImoveis() {
        return valorTotalImoveis;
    }

    public Set<Acionista> getAcionistas() {
        return acionistas;
    }

    public String getNome() {
        return nome;
    }
}