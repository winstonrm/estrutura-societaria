package com.montreal.banco;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.montreal.banco.model.Acionista;
import com.montreal.banco.model.Empresa;
import com.montreal.banco.model.EstruturaSocietaria;
import com.montreal.banco.model.PessoaFisica;
import com.montreal.banco.model.PessoaJuridica;
import com.montreal.banco.service.EmpresaService;
import com.montreal.banco.service.EmpresaServiceImpl;
import com.montreal.banco.service.PessoaService;
import com.montreal.banco.service.PessoaServiceImpl;

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
	public void testComprometimentoFinanceiro() {
		PessoaService pessoaService = new PessoaServiceImpl();
		EmpresaService empresaService = new EmpresaServiceImpl();
		
		EstruturaSocietaria estruturaSocietaria = new EstruturaSocietaria();
		String cpfAcionistaPf = "82418781097";
		String cnpjAcionistaPj = "36147793000113";

		// Criando acionistas
		Acionista acionistaPf = pessoaService.criarAcionistaPf("João Raimundo", cpfAcionistaPf);
		Acionista acionistaPj = pessoaService.criarAcionistaPj("Empresa Teste LTDA", cnpjAcionistaPj);

		// Adicionando valores de imóveis aos acionistas
		pessoaService.adicionarValorImovel(acionistaPf, 100.0);
		pessoaService.adicionarValorImovel(acionistaPj, 200.0);

		// Criando empresas
		Empresa empresa1 = empresaService.criarEmpresa("Minha Empresa");

		// Empresa 1
		// Adicionando valores de imóveis às empresas			
		empresaService.adicionarValorImovel(empresa1, 300.0);

		// Adicionando acionistas do tipo Empresa
		empresaService.adicionarEmpresa(empresa1, empresa1);	
		// Adicionando acionistas às empresas
		empresaService.adicionarAcionista(empresa1, acionistaPj); 
		empresaService.adicionarAcionista(empresa1, acionistaPf); 

		// Adicionando a Empresa 1 a uma EstruturaSocietária
		estruturaSocietaria.adicionarEmpresa(empresa1);

		// Calculando o comprometimento financeiro total	
		Double result = estruturaSocietaria.comprometimentoFinanceiro(empresa1);

		assertEquals(3000.0, result, 3000.0);
	}

	@Test
	public void testComprometimentoFinanceiroComEstrutura() {

		PessoaService pessoaService = new PessoaServiceImpl();
		EmpresaService empresaService = new EmpresaServiceImpl();
		
		EstruturaSocietaria estruturaSocietaria = new EstruturaSocietaria();
		String cpfAcionistaPf = "82418781097";
		String cnpjAcionistaPj = "36147793000113";

		// Criando acionistas
		Acionista acionistaPf = pessoaService.criarAcionistaPf("João Raimundo", cpfAcionistaPf);
		Acionista acionistaPj = pessoaService.criarAcionistaPj("Empresa Teste LTDA", cnpjAcionistaPj);

		// Adicionando valores de imóveis aos acionistas
		pessoaService.adicionarValorImovel(acionistaPf, 100.0);
		pessoaService.adicionarValorImovel(acionistaPj, 200.0);

		// Criando empresas
		Empresa empresa1 = empresaService.criarEmpresa("Minha Empresa");

		// Empresa 1
		// Adicionando valores de imóveis às empresas			
		empresaService.adicionarValorImovel(empresa1, 300.0);

		// Adicionando acionistas do tipo Empresa
		empresaService.adicionarEmpresa(empresa1, empresa1);	
		// Adicionando acionistas às empresas
		empresaService.adicionarAcionista(empresa1, acionistaPj); 
		empresaService.adicionarAcionista(empresa1, acionistaPf); 

		// Adicionando a Empresa 1 a uma EstruturaSocietária
		estruturaSocietaria.adicionarEmpresa(empresa1);

		// Calculando o comprometimento financeiro total	
		Double result = estruturaSocietaria.comprometimentoFinanceiro(empresa1);

		assertEquals(6000.0, result, 6000.0);
	}

}
