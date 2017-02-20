package com.cobranca.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.cobranca.model.Carro;
import com.cobranca.repository.Carros;
import com.cobranca.util.jpa.Transactional;

public class CadastroCarroService implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Carros carros;
	
	@Transactional
	public void salvar(Carro carro){
		this.carros.guardar(carro);
	}

}
