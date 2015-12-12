package com.uepb.advbus.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Motorista extends Pessoa implements Favorecido{

	private static final long serialVersionUID = 1L;

	@Column(length = 24, nullable = false)
	private String cnh;
	
	public Motorista() {
		
	}
	
	public Motorista(String nome, String cpf, String telefone, String email, String cnh) {
		super(nome, cpf, telefone, email ,new Date());
		this.cnh = cnh;
	}
	
	public String getCnh() {
		return cnh;
	}
	
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
}
