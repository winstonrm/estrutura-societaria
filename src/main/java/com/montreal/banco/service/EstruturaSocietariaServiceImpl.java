package com.montreal.banco.service;

import java.lang.ref.WeakReference;

import com.montreal.banco.model.Empresa;
import com.montreal.banco.model.EstruturaSocietaria;

public class EstruturaSocietariaServiceImpl implements EstruturaSocietariaService {

	public EstruturaSocietaria criarEstrutura() {		
		EstruturaSocietaria estruturaSocietaria = new EstruturaSocietaria();

		return estruturaSocietaria;
	}
	
	public void adicionarEmpresa(Empresa empresa) {
		 empresa.getEmpresas().add(new WeakReference<Empresa>(empresa));
	}

}
