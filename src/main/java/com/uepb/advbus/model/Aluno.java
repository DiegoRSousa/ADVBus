package com.uepb.advbus.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.OneToMany;

@Entity
public class Aluno extends Pessoa{

	private static final long serialVersionUID = 1L;

	@Column(length = 32, nullable = false)
	private String matricula;
	
	@Lob
	private byte[] foto;
	
	@Embedded
	private Endereco endereco;
	
	@OneToMany(mappedBy = "aluno")
	private List<Contrato> contratos;
	
	public Aluno() {}
	
	public Aluno(String nome, String cpf, String telefone, String email,
			String matricula, Endereco endereco) {
		super(nome, cpf, telefone, email ,new Date());
		this.matricula = matricula;
		this.endereco = endereco;
	}
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Contrato> getContratos() {
		return contratos;
	}

	public void setContratos(List<Contrato> contratos) {
		this.contratos = contratos;
	}
}
