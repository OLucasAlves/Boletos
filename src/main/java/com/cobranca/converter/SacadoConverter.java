package com.cobranca.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

import com.cobranca.model.Sacado;
import com.cobranca.repository.Sacados;

@FacesConverter(forClass = Sacado.class)
public class SacadoConverter implements Converter{
	
	@Inject
	private Sacados sacados;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Sacado retorno = null;
		
		if(value != null){
			retorno = this.sacados.porId(new Long(value));
		}
		
		return retorno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if(value != null){
			try{
				return ((Sacado) value).getCodigo().toString();
			}catch(Exception e){
				e.getMessage();
			}
			
		}
		return null;
	}
	
	

	
	
}
