package com.cobranca.controller;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.cobranca.model.Sacado;
import com.cobranca.repository.Sacados;
import com.cobranca.service.CadastroSacadoService;

@Named
@ViewScoped
public class NovoSacadoBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private CadastroSacadoService cadastro;
	
	@Inject
	private Sacados sacados;
	
	private Sacado sacado = new Sacado();
	
	public void salvar(){
		FacesContext context = FacesContext.getCurrentInstance();
		
		try{
			this.cadastro.salvar(this.sacado);
			
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
	
	
}
