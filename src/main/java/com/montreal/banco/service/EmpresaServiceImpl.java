package com.montreal.banco.service;

import java.lang.ref.WeakReference;

import org.springframework.stereotype.Service;

import com.montreal.banco.model.Acionista;
import com.montreal.banco.model.Empresa;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	public Empresa criarEmpresa(String nome) {		
		Empresa empresa = new Empresa(nome);

		return empresa;
	}

	public void adicionarEmpresa(Empresa empresa, Empresa empresaSocia) {
		empresa.getEmpresas().add(new WeakReference<Empresa>(empresaSocia));		
	}

	public void adicionarAcionista(Empresa empresa, Acionista acionista) {
		empresa.getAcionistas().add(acionista);
	}

	public void adicionarValorImovel(Empresa empresa, Double valor) {
		empresa.setValorTotalImoveis(empresa.getValorTotalImoveis() + valor);
	}


}
