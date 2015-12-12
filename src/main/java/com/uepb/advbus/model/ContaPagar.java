package com.uepb.advbus.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Any;
import org.hibernate.annotations.AnyMetaDef;
import org.hibernate.annotations.MetaValue;;

@Entity
public class ContaPagar implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(length = 64, nullable = true)
	private String referencia;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date competencia;
	
	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date vencimento;	
	
	@Column(precision = 10, scale = 2,nullable = false)
	private BigDecimal valor;
	
	@Column(precision = 10, scale = 2,nullable = false)
	private BigDecimal saldo;
	
	@Any(metaColumn = @Column(name = "favorecido"))
	@AnyMetaDef(idType = "long", metaType = "string", metaValues = {
		@MetaValue(value = "MOTORISTA", targetEntity = Motorista.class),
		@MetaValue(value = "POSTO_COMBUSTIVEL", targetEntity = PostoCombustivel.class)})
	@JoinColumn(name ="favorecido_id")
	private Favorecido favorecido;
	
	public ContaPagar() {
		
	}
	
	public ContaPagar(String referencia, Date competencia, Date vencimento, BigDecimal valor, BigDecimal saldo) {
		this.referencia = referencia;
		this.competencia = competencia;
		this.vencimento = vencimento;
		this.valor = valor;
		this.saldo = saldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public Date getCompetencia() {
		return competencia;
	}

	public void setCompetencia(Date competencia) {
		this.competencia = competencia;
	}

	public Date getVencimento() {
		return vencimento;
	}

	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getSaldo() {
		return saldo;
	}

	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		ContaPagar other = (ContaPagar) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
