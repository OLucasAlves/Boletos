package com.cobranca.util.boleto;

import java.io.File;

import java.io.Serializable;

import com.cobranca.model.Cedente;
import com.cobranca.model.Cobranca;

public interface EmissorBoleto extends Serializable {

	public byte[] gerarBoleto(Cedente cedenteSistema, Cobranca cobrancaSistema);
	public File gerarBoletoEmArquivo(String arquivo, Cedente cedenteSistema, Cobranca cobrancaSistema);
	
}
