package com.cobranca.service;

/*
 * Classe responsavel pelas excecoes personalizadas
 * */
public class PersonalizadaException extends Exception{

	
	private static final long serialVersionUID = 1L;
	
	public PersonalizadaException(String msg){
		super(msg);
	}
	
}
