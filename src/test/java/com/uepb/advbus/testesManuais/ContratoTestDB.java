package com.uepb.advbus.testesManuais;

import java.util.Date;

import com.uepb.advbus.model.Aluno;
import com.uepb.advbus.model.Contrato;
import com.uepb.advbus.model.InstituicaoEnsino;
import com.uepb.advbus.model.PlanoPagamento;
import com.uepb.advbus.model.Usuario;
import com.uepb.advbus.repositories.AlunoRepository;
import com.uepb.advbus.repositories.ContratoRepository;
import com.uepb.advbus.repositories.InstituicaoEnsinoRepository;
import com.uepb.advbus.repositories.RepositoryBase;
import com.uepb.advbus.repositories.UsuarioRepository;

public class ContratoTestDB {

	public static void main(String[] args) {
		//persistContrato();
		findContrato(1L);
	}
	
	private static RepositoryBase<Contrato> contratoRepository = new ContratoRepository();
	private static RepositoryBase<Aluno> alunoRepository = new AlunoRepository();
	private static RepositoryBase<InstituicaoEnsino> instituicaoRepository = new InstituicaoEnsinoRepository();
	private static RepositoryBase<Usuario> usuarioRepository = new UsuarioRepository();
	
	public static void persistContrato() {
		alunoRepository.beginTransaction();
		
		Aluno aluno = alunoRepository.getById(1L);
		InstituicaoEnsino instituicao = instituicaoRepository.getById(1L);
		Usuario usuario = usuarioRepository.getById(1L);
		
		Contrato contrato = new Contrato(PlanoPagamento.PARCIAL, aluno,instituicao, new Date(), new Date(), usuario); 
		
		contratoRepository.beginTransaction();
		contratoRepository.add(contrato);
		contratoRepository.commit();
		contratoRepository.close();
		
	}
	
	public static void findContrato(Long id) {
		contratoRepository.beginTransaction();
		Contrato contrato = contratoRepository.getById(id);
		System.out.println(contrato.getId() + " - " + contrato.getAluno().getNome() +" - " 
				+ contrato.getPlanoPagamento() + " - " + contrato.getInstituicaoEnsino().getAcronimo() + " - "
				+ contrato.isAtivado() + " - "
				+ contrato.getUsuario().getUsuario());
		alunoRepository.close();
	}
}
