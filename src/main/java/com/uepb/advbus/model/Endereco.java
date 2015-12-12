package com.uepb.advbus.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	@Column(length = 64, nullable = false)
	private String logradouro;
	
	@Column(length = 12)
	private String numero;
	
	@Column(length = 64)
	private String bairro;
	
	@Column(length = 9)
	private String cep;
	
	@Column(length = 64, nullable = false)
	private String cidade;
	
	@Column(length = 64, nullable = false)
	private String estado;
	
	public Endereco() {
		
	}
	
	public Endereco(String logradouro, String numero, String bairro, String cep, String cidade, String estado) {
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.cep = cep;
		this.cidade = cidade;
		this.estado = estado;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
