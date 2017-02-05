package com.cobranca.controller;

import java.io.OutputStream;


import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpServletResponse;

import com.cobranca.model.Cedente;
import com.cobranca.model.Cobranca;
import com.cobranca.model.Sacado;
import com.cobranca.repository.Cedentes;
import com.cobranca.repository.Sacados;
import com.cobranca.service.NovaCobrancaService;
import com.cobranca.service.PersonalizadaException;
import com.cobranca.util.boleto.EmissorBoleto;

@Named
@ViewScoped
public class NovaCobrancaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cobranca cobranca;
	
	@Inject
	private Cedentes cedentes;
	
	@Inject
	private NovaCobrancaService novaCobrancaService;
	
	@Inject
	private EmissorBoleto emissorBoleto;
	
	private List<Sacado> todosSacados;
	
	@Inject
	private Sacados sacados;
	

	public void inicializar() {
		this.setTodosSacados(this.sacados.todosSa());
		//this.todasPessoas = this.pessoas.todasP();
		cobranca = new Cobranca();
		cobranca.setSacado(new Sacado());
	}
	
	public void emitir()  {
		
		FacesContext context = FacesContext.getCurrentInstance();
		
		try{
			Cedente cedente = cedentes.porCodigo(1L);
			cobranca = novaCobrancaService.salvar(cobranca);
			
			byte[] pdf = this.emissorBoleto.gerarBoleto(cedente, cobranca);
			enviarBoleto(pdf);
			
			inicializar();
		}catch(PersonalizadaException e){
			FacesMessage msg = new FacesMessage(e.getMessage());
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			context.addMessage(null, msg);
		}
		
		
	}

	private void enviarBoleto(byte[] pdf) {
		HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
		
		response.setContentType("application/pdf");
		response.setHeader("Content-Disposition", "attachment; filename=boleto" + cobranca.getCodigo() + ".pdf");
		
		try {
			OutputStream output = response.getOutputStream();
			output.write(pdf);
			response.flushBuffer();
		} catch (Exception e) {
			throw new RuntimeException("Erro gerando boleto", e);
		}
		
		FacesContext.getCurrentInstance().responseComplete();
	}

	public Cobranca getCobranca() {
		return cobranca;
	}

	public List<Sacado> getTodosSacados() {
		return todosSacados;
	}

	public void setTodosSacados(List<Sacado> todosSacados) {
		this.todosSacados = todosSacados;
	}
	
}
