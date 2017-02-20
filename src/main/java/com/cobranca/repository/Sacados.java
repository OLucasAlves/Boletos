package com.cobranca.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cobranca.model.Cobranca;
import com.cobranca.model.Sacado;

public class Sacados implements Serializable{
	
	@Inject
	EntityManager manager;
	
	@Inject
	public Sacados (EntityManager manager){
		this.manager = manager;
	}
	
	public Sacado guardar(Sacado sacado){
		return this.manager.merge(sacado);
	}
	
	public List<Sacado> todosSa(){
		TypedQuery<Sacado> query = manager.createQuery("from Sacado",Sacado.class);
		return query.getResultList();
	}
	
	public Sacado porId(Long codigo){
		return manager.find(Sacado.class, codigo);
	}
}
