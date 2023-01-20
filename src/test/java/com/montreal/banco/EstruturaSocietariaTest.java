package com.montreal.banco;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.montreal.banco.model.Empresa;
import com.montreal.banco.model.EstruturaSocietaria;
import com.montreal.banco.model.PessoaFisica;
import com.montreal.banco.model.PessoaJuridica;

public class EstruturaSocietariaTest {

	@Test
	public void testAdicionarEmpresa() {
		EstruturaSocietaria estrutura = new EstruturaSocietaria();
		Empresa empresa = new Empresa("Minha Empresa");
		
		estrutura.adicionarEmpresa(empresa);

		assertEquals(1, estrutura.getEmpresas().size());
		assertTrue(estrutura.getEmpresas().contains(empresa));
	}

	@Test
	public void testAdicionarAcionista() {
		EstruturaSocietaria estrutura = new EstruturaSocietaria();
		PessoaFisica acionista = new PessoaFisica("João Raimundo", "123.456.789-10");

		estrutura.adicionarAcionista(acionista);

		assertEquals(1, estrutura.getAcionistas().size());
		assertTrue(estrutura.getAcionistas().contains(acionista));
	}

	@Test
	public void testComprometimentoFinanceiro() {
		EstruturaSocietaria estruturaSocietaria = new EstruturaSocietaria();
		//EstruturaSocietaria estruturaSocietaria2 = new EstruturaSocietaria();
		
		Empresa empresa1 = new Empresa("Minha Empresa");
		empresa1.adicionarValorImovel(1000.0);
		Empresa empresa2 = new Empresa("Empresa Parceira");
		empresa2.adicionarValorImovel(2000.0);
		estruturaSocietaria.adicionarEmpresa(empresa1);
		estruturaSocietaria.adicionarEmpresa(empresa2);

		PessoaFisica acionista1 = new PessoaFisica("João Raimundo", "123.456.789-10");
		acionista1.getIdentificacao();
		acionista1.adicionarValorImovel(1000.0);
		PessoaJuridica acionista2 = new PessoaJuridica("Empresa Teste LTDA", "98.765.432/0001-01");
		acionista2.getIdentificacao();
		acionista2.adicionarValorImovel(2000.0);

		estruturaSocietaria.adicionarAcionista(acionista1);
		estruturaSocietaria.adicionarAcionista(acionista2);

		Double result = estruturaSocietaria.comprometimentoFinanceiro();

		assertEquals(3000.0, result, 3000.0);
	}

	@Test
	public void testComprometimentoFinanceiroComEstrutura() {

		EstruturaSocietaria estruturaSocietaria = new EstruturaSocietaria();
		//EstruturaSocietaria estruturaSocietaria2 = new EstruturaSocietaria();
		Empresa empresa1 = new Empresa("Minha Empresa");
		empresa1.adicionarValorImovel(1000.0);
		Empresa empresa2 = new Empresa("Empresa Parceira");
		empresa2.adicionarValorImovel(2000.0);
		estruturaSocietaria.adicionarEmpresa(empresa1);
		estruturaSocietaria.adicionarEmpresa(empresa2);

		PessoaFisica acionista1 = new PessoaFisica("João Raimundo", "123.456.789-10");
		acionista1.getIdentificacao();
		acionista1.adicionarValorImovel(1000.0);
		PessoaJuridica acionista2 = new PessoaJuridica("Empresa Teste LTDA", "98.765.432/0001-01");
		acionista2.getIdentificacao();
		acionista2.adicionarValorImovel(2000.0);

		estruturaSocietaria.adicionarAcionista(acionista1);
		estruturaSocietaria.adicionarAcionista(acionista2);

		Double result = estruturaSocietaria.comprometimentoFinanceiro(estruturaSocietaria);

		assertEquals(6000.0, result, 6000.0);
	}

}