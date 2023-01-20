package com.montreal.banco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.montreal.banco.model.Acionista;
import com.montreal.banco.model.Empresa;
import com.montreal.banco.model.EstruturaSocietaria;
import com.montreal.banco.service.EmpresaService;
import com.montreal.banco.service.EmpresaServiceImpl;
import com.montreal.banco.service.EstruturaSocietariaService;
import com.montreal.banco.service.EstruturaSocietariaServiceImpl;
import com.montreal.banco.service.PessoaService;
import com.montreal.banco.service.PessoaServiceImpl;

@SpringBootApplication
public class PraticoMontrealApplication {


	public static void main(String[] args) {

		SpringApplication.run(PraticoMontrealApplication.class, args);

		ApplicationContext applicationContext = SpringApplication.run(PraticoMontrealApplication.class, args);
		PessoaService pessoaService = applicationContext.getBean(PessoaServiceImpl.class);
		EmpresaService empresaService = applicationContext.getBean(EmpresaServiceImpl.class);
		EstruturaSocietariaService estruturaSocietaria = applicationContext.getBean(EstruturaSocietariaServiceImpl.class);

		try {
			String cpfAcionistaPf = "82418781097";
			String cnpjAcionistaPj = "36147793000113";
			
			//Estrutura societária para cada empresa.
//			EstruturaSocietaria estrutSocietEmp1 = new EstruturaSocietaria();
//			EstruturaSocietaria estrutSocietEmp2 = new EstruturaSocietaria();
			EstruturaSocietaria estrutSocietEmp1 = estruturaSocietaria.criarEstrutura();
			EstruturaSocietaria estrutSocietEmp2 = estruturaSocietaria.criarEstrutura();

			// Criando empresas
			Empresa empresa1 = empresaService.criarEmpresa("Minha Empresa");
			Empresa empresa2 = empresaService.criarEmpresa("Empresa Parceira");
			
			// Criando acionistas
			// Aplicação só irá continuar se a identificação do Acionista for validada
			Acionista acionistaPf = pessoaService.criarAcionistaPf("João Raimundo", cpfAcionistaPf);
			Acionista acionistaPj = pessoaService.criarAcionistaPj("Empresa Teste LTDA", cnpjAcionistaPj);

			// Adicionando valores de imóveis aos acionistas
			pessoaService.adicionarValorImovel(acionistaPf, 100.0);
			pessoaService.adicionarValorImovel(acionistaPj, 200.0);


			// Empresa 1
			// Adicionando valores de imóveis às empresas			
			empresaService.adicionarValorImovel(empresa1, 300.0);

			// Adicionando acionistas do tipo Empresa
			empresaService.adicionarEmpresa(empresa1, empresa1);	
			// Adicionando acionistas às empresas
			empresaService.adicionarAcionista(empresa1, acionistaPj); 
			empresaService.adicionarAcionista(empresa1, acionistaPf); 

			// Adicionando a Empresa 1 a uma EstruturaSocietária
			//estruturaSocietaria.adicionarEmpresa(empresa1);
			estrutSocietEmp1.adicionarEmpresa(empresa1);


			// Empresa 2
			// Adicionando valores de imóveis às empresas		
			empresaService.adicionarValorImovel(empresa2, 400.0);		
			// Adicionando acionistas do tipo Empresa
			
			empresaService.adicionarEmpresa(empresa2, empresa1);
			// Adicionando acionistas às empresas
			empresaService.adicionarAcionista(empresa2, acionistaPf);
			empresaService.adicionarAcionista(empresa2, acionistaPj);

			// Adicionando a Empresa 2 a uma EstruturaSocietária
			//estruturaSocietaria.adicionarEmpresa(empresa2);
			estrutSocietEmp2.adicionarEmpresa(empresa2);

			// Calculando o comprometimento financeiro total	
			System.out.println("Estrutura societária da Empresa 1: Comprometimento financeiro total: " + estrutSocietEmp1.comprometimentoFinanceiro());

			// Calculando o comprometimento financeiro total
			System.out.println("Estrutura societária da Empresa 2: Comprometimento financeiro total: " + estrutSocietEmp2.comprometimentoFinanceiro());

		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}
}
