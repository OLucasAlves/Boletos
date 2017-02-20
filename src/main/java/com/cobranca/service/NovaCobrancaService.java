package com.cobranca.service;

import java.io.Serializable;
import java.util.Date;

import javax.inject.Inject;

import com.cobranca.model.Cobranca;
import com.cobranca.model.Status;
import com.cobranca.repository.Cobrancas;
import com.cobranca.util.jpa.Transactional;

public class NovaCobrancaService implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private Cobrancas cobrancas;
	
	@Transactional
	public Cobranca salvar(Cobranca cobranca) throws PersonalizadaException {
		
		if(cobranca.getDataVencimento().before(new Date()) ){
			throw new PersonalizadaException("Vencimento não pode ser uma data anterior");
		}
		cobranca.setStatus(Status.PENDENTE);
		cobranca = this.cobrancas.guardar(cobranca);
		
		return cobranca;
	}

}
