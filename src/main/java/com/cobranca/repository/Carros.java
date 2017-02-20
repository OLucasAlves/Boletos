package com.cobranca.repository;

import java.io.Serializable;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.cobranca.model.Carro;

public class Carros implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Carro guardar(Carro carro){
		return this.manager.merge(carro);
	}
	
	public Carro porId(Long id){
		return this.manager.find(Carro.class,id);
	}

}
