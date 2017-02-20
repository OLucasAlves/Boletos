package com.cobranca.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cobranca.model.Carro;
import com.cobranca.model.Cobranca;
import com.cobranca.model.Sacado;
import com.cobranca.repository.Carros;
import com.cobranca.repository.Sacados;
import com.cobranca.service.CadastroCarroService;
import com.cobranca.service.CadastroSacadoService;

@Named
@ViewScoped
public class NovoSacadoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroSacadoService cadastro;
	
	@Inject
	private CadastroCarroService cadastroCarro;
	
	@Inject
	private Sacados sacados;
	
	@Inject
	private Carros carros;
	
	private Sacado sacado = new Sacado();
	
	private Carro carro = new Carro();
	
	public void inicializar() {
		
		sacado = new Sacado();
		sacado.setCarro(carro);
	}
	
	public void salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		try{
			//this.cadastroCarro.salvar(this.carro);
			Carro carro = carros.porId(1L);
			this.cadastro.salvar(this.sacado);
			
			this.carro = new Carro();
			this.sacado = new Sacado();
			context.addMessage(null, new FacesMessage("Cliente cadastrado com sucesso!"));
		}catch(Exception e){
			FacesMessage mensagem = new FacesMessage(e.getMessage());
			mensagem.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null,mensagem);
		}
	}

	public Sacado getSacado() {
		return sacado;
	}

	public void setSacado(Sacado sacado) {
		this.sacado = sacado;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	
	
	
}
