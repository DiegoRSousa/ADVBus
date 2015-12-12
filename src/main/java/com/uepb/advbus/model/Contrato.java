package com.uepb.advbus.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Contrato implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "plano_pagamento", nullable = false, length = 8)
	@Enumerated(EnumType.STRING)
	private PlanoPagamento planoPagamento;
	
	@Column(name = "situacao_financeira", nullable = false, length = 8)
	@Enumerated(EnumType.STRING)
	private SituacaoFinanceira situacaoFinanceira;
	
	@ManyToOne(optional = false)
	private Aluno aluno;
	
	@ManyToOne(optional = false)
	private InstituicaoEnsino instituicaoEnsino;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_inicio", nullable = false)
	private Date dataInicio;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "data_fim", nullable = true)
	private Date dataFim;

	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro", nullable = false)
	private Date dataCadastro;
	
	@Column(length = 10, nullable = true)
	private boolean ativado;
	
	public Contrato() {}
	
	public Contrato(PlanoPagamento planoPagamento, Aluno aluno,InstituicaoEnsino instituicaoEnsino, Date dataInicio, Date dataFim) {
		this.planoPagamento = planoPagamento;
		this.situacaoFinanceira = SituacaoFinanceira.EM_DIA;
		this.aluno = aluno;
		this.instituicaoEnsino = instituicaoEnsino;
		this.dataInicio = dataInicio;
		this.dataFim = dataFim;
		this.dataCadastro = new Date();
		this.ativado = true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PlanoPagamento getPlanoPagamento() {
		return planoPagamento;
	}

	public void setPlanoPagamento(PlanoPagamento planoPagamento) {
		this.planoPagamento = planoPagamento;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	
	public InstituicaoEnsino getInstituicaoEnsino() {
		return instituicaoEnsino;
	}

	public void setInstituicaoEnsino(InstituicaoEnsino instituicaoEnsino) {
		this.instituicaoEnsino = instituicaoEnsino;
	}

	public SituacaoFinanceira getSituacaoFinanceira() {
		return situacaoFinanceira;
	}

	public void setSituacaoFinanceira(SituacaoFinanceira situacaoFinanceira) {
		this.situacaoFinanceira = situacaoFinanceira;
	}

	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public boolean isAtivado() {
		return ativado;
	}

	public void setAtivado(boolean ativado) {
		this.ativado = ativado;
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
			final Contrato other = (Contrato) obj;
			if (id == null) {
			if (other.id != null)
			return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
	}
}