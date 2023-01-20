package com.montreal.banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.montreal.banco.model.Empresa;
import com.montreal.banco.model.EstruturaSocietaria;
import com.montreal.banco.model.PessoaFisica;
import com.montreal.banco.model.PessoaJuridica;

@SpringBootApplication
public class PraticoMontrealApplication {
	
	public static void main(String[] args) {
		//ApplicationContext applicationContext = SpringApplication.run(PraticoMontrealApplication.class, args);
		//EstruturaSocietariaService estruturaSocEmpresa = applicationContext.getBean(EstruturaSocietariaService.class);
		
		SpringApplication.run(PraticoMontrealApplication.class, args);
		
		EstruturaSocietaria estrutSocietEmp1 = new EstruturaSocietaria();
		EstruturaSocietaria estrutSocietEmp2 = new EstruturaSocietaria();

		// Criando acionistas
		PessoaFisica acionistaPf = new PessoaFisica("João Raimundo", "123.456.789-10");
		PessoaJuridica acionistaPj = new PessoaJuridica("Empresa Teste LTDA", "98.765.432/0001-01");

		// Adicionando valores de imóveis aos acionistas
		acionistaPf.adicionarValorImovel(100000.0);
		acionistaPj.adicionarValorImovel(200000.0);

		// Criando empresas
		Empresa empresa1 = new Empresa("Minha Empresa");
		Empresa empresa2 = new Empresa("Empresa Parceira");

		// Empresa 1
		// Adicionando valores de imóveis às empresas
		empresa1.adicionarValorImovel(300000.0);
				
		// Adicionando acionistas do tipo Empresa
		empresa1.adicionarEmpresa(empresa1);
		empresa1.adicionarEmpresa(empresa2);		
		// Adicionando acionistas às empresas
		empresa1.adicionarAcionista(acionistaPf);			
		// Adicionando a Empresa 1 a uma EstruturaSocietária
		estrutSocietEmp1.adicionarEmpresa(empresa1);
		
		
		// Empresa 2
		// Adicionando valores de imóveis às empresas		
		empresa2.adicionarValorImovel(400000.0);		
		// Adicionando acionistas às empresas
		empresa2.adicionarAcionista(acionistaPf);
		empresa2.adicionarAcionista(acionistaPj);
		// Adicionando a Empresa 2 a uma EstruturaSocietária
		estrutSocietEmp2.adicionarEmpresa(empresa2);
		

		// Calculando o comprometimento financeiro total	
		System.out.println("Estrutura societária da Empresa 1: Comprometimento financeiro total: " + estrutSocietEmp1.comprometimentoFinanceiro());

		// Calculando o comprometimento financeiro total
		System.out.println("Estrutura societária da Empresa 2: Comprometimento financeiro total: " + estrutSocietEmp2.comprometimentoFinanceiro());

	}
}
