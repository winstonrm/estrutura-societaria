package com.montreal.banco;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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

		final Logger LOGGER = LoggerFactory.getLogger(PraticoMontrealApplication.class);

		SpringApplication.run(PraticoMontrealApplication.class, args);

		PessoaService pessoaService = new PessoaServiceImpl();
		EmpresaService empresaService = new EmpresaServiceImpl();
		EstruturaSocietariaService estruturaSocietaria = new EstruturaSocietariaServiceImpl();
		try {
			String cpfAcionistaPf = "82418781097";
			String cnpjAcionistaPj = "36147793000113";

			// Estrutura societária para cada empresa.
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
			// Adicionando valores de imóveis à empresa
			empresaService.adicionarValorImovel(empresa1, 300.0);

			empresaService.adicionarEmpresa(empresa1, empresa1);
			empresaService.adicionarEmpresa(empresa1, empresa2);

			empresaService.adicionarAcionista(empresa1, acionistaPj);
			empresaService.adicionarAcionista(empresa1, acionistaPf);

			estrutSocietEmp1.adicionarEmpresa(empresa1);

			// Empresa 2
			empresaService.adicionarValorImovel(empresa2, 400.0);

			empresaService.adicionarAcionista(empresa2, acionistaPf);
			empresaService.adicionarAcionista(empresa2, acionistaPj);
			estrutSocietEmp2.adicionarEmpresa(empresa2);

			// Calculando o comprometimento financeiro total

			LOGGER.info("Estrutura societária da Empresa 1: Comprometimento financeiro total: "
					+ estrutSocietEmp1.comprometimentoFinanceiro(empresa1));

			// Calculando o comprometimento financeiro total
			LOGGER.info("Estrutura societária da Empresa 2: Comprometimento financeiro total: "
					+ estrutSocietEmp2.comprometimentoFinanceiro(empresa2));

		} catch (IllegalArgumentException e) {
			LOGGER.info(e.getMessage());
		}
	}
}
