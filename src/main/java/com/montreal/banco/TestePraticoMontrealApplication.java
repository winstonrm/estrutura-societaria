package com.montreal.banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.montreal.banco.dto.Empresa;
import com.montreal.banco.dto.EstruturaSocietaria;
import com.montreal.banco.dto.PessoaFisica;
import com.montreal.banco.dto.PessoaJuridica;

@SpringBootApplication
public class TestePraticoMontrealApplication {

	public static void main(String[] args) {
		SpringApplication.run(TestePraticoMontrealApplication.class, args);

		EstruturaSocietaria estruturaSocietaria = new EstruturaSocietaria();

		// Criando acionistas
		PessoaFisica acionista1 = new PessoaFisica("João Silva", "123.456.789-10");
		PessoaJuridica acionista2 = new PessoaJuridica("Empresa LTDA", "98.765.432/0001-01");

		// Adicionando valores de imóveis aos acionistas
		acionista1.adicionarValorImovel(100000.0);
		acionista2.adicionarValorImovel(200000.0);

		// Adicionando acionistas à estrutura
		estruturaSocietaria.adicionarAcionista(acionista1);
		estruturaSocietaria.adicionarAcionista(acionista2);

		// Criando empresas
		Empresa empresa1 = new Empresa("Minha Empresa");
		Empresa empresa2 = new Empresa("Empresa Parceira");

		// Adicionando valores de imóveis às empresas
		empresa1.adicionarValorImovel(300000.0);
		empresa2.adicionarValorImovel(400000.0);

		// Adicionando acionistas às empresas
		empresa1.adicionarAcionista(acionista1);
		empresa2.adicionarAcionista(acionista2);

		// Adicionando empresas à estrutura
		estruturaSocietaria.adicionarEmpresa(empresa1);
		estruturaSocietaria.adicionarEmpresa(empresa2);

		// Calculando o comprometimento financeiro total
		Double total = estruturaSocietaria.comprometimentoFinanceiro();
		System.out.println("Comprometimento financeiro total: " + total);
	}
}
