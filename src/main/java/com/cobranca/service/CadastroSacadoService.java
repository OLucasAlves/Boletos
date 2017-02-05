package com.cobranca.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.cobranca.model.Sacado;
import com.cobranca.repository.Sacados;
import com.cobranca.util.jpa.Transactional;

public class CadastroSacadoService implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Sacados sacados;
	
	@Transactional
	public void salvar(Sacado sacado){
		this.sacados.guardar(sacado);
	}
	
	
}
