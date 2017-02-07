package com.cobranca.model;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "cobranca")
public class Cobranca implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/*@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "cobranca")
	@TableGenerator(name = "cobranca")*/
	private Long codigo;
	private BigDecimal valor;
	private Date dataVencimento;
	private Sacado sacado;
	private Status status;
	private String instrucao;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	
	@NotEmpty
	@Column(precision=10,scale=2,nullable=false)
	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
	
	@NotEmpty
	@Temporal(TemporalType.DATE)
	@Column(name = "data_vencimento")
	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	
	@NotEmpty
	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinColumn(name = "codigo_sacado")
	public Sacado getSacado() {
		return sacado;
	}

	public void setSacado(Sacado sacado) {
		this.sacado = sacado;
	}

	@Enumerated(EnumType.STRING)
	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	@NotEmpty
	@Column(name = "cobranca")
	public String getInstrucao() {
		return instrucao;
	}

	public void setInstrucao(String informacao) {
		this.instrucao = informacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cobranca other = (Cobranca) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
