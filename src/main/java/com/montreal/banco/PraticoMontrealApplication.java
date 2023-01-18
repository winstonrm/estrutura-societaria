package com.montreal.banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.montreal.banco.model.Empresa;
import com.montreal.banco.model.PessoaFisica;
import com.montreal.banco.model.PessoaJuridica;
import com.montreal.banco.service.EstruturaSocietariaService;

@SpringBootApplication
public class PraticoMontrealApplication {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(PraticoMontrealApplication.class, args);

		EstruturaSocietariaService estruturaSocietaria = applicationContext.getBean(EstruturaSocietariaService.class);

		// Criando acionistas
		PessoaFisica acionista1 = new PessoaFisica("João Raimundo", "123.456.789-10");
		PessoaJuridica acionista2 = new PessoaJuridica("Empresa Teste LTDA", "98.765.432/0001-01");

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
