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

		EstruturaSocietariaService estruturaSocEmpresa = applicationContext.getBean(EstruturaSocietariaService.class);
		//EstruturaSocietariaService estruturaSocEmpresa2 = applicationContext.getBean(EstruturaSocietariaService.class);

		// Criando acionistas
		PessoaFisica acionistaPf = new PessoaFisica("João Raimundo", "123.456.789-10");
		PessoaJuridica acionistaPj = new PessoaJuridica("Empresa Teste LTDA", "98.765.432/0001-01");

		// Adicionando valores de imóveis aos acionistas
		acionistaPf.adicionarValorImovel(100000.0);
		acionistaPj.adicionarValorImovel(200000.0);

		// Criando empresas
		Empresa empresa1 = new Empresa("Minha Empresa");
		Empresa empresa2 = new Empresa("Empresa Parceira");

		
		// Adicionando valores de imóveis às empresas
		empresa1.adicionarValorImovel(300000.0);
		empresa2.adicionarValorImovel(900000.0);
		
		//EmpresaSocia empSocia = new empresa1.clone();
		
		empresa1.adicionarEmpresa(empresa1);
		empresa1.adicionarEmpresa(empresa2);

		// Adicionando acionistas às empresas
		empresa1.adicionarAcionista(acionistaPf);
		empresa2.adicionarAcionista(acionistaPj);

		// Adicionando acionistas à estrutura
		estruturaSocEmpresa.adicionarEmpresaPrincipal(empresa1);
		estruturaSocEmpresa.adicionarAcionista(acionistaPf);
		estruturaSocEmpresa.adicionarAcionista(acionistaPj);
		// Adicionando empresas à estrutura
		estruturaSocEmpresa.adicionarEmpresa(empresa1);
		
		
		estruturaSocEmpresa.adicionarEmpresaPrincipal(empresa2);
		estruturaSocEmpresa.adicionarAcionista(acionistaPf);
		estruturaSocEmpresa.adicionarEmpresa(empresa1);

		Double total = 0.0;
		// Calculando o comprometimento financeiro total
		total = estruturaSocEmpresa.comprometimentoFinanceiro();
		System.out.println("Estrutura 1: Comprometimento financeiro total: " + total);
	}
}
