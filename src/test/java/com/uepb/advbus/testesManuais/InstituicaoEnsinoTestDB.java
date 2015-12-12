package com.uepb.advbus.testesManuais;

import com.uepb.advbus.model.InstituicaoEnsino;
import com.uepb.advbus.repositories.InstituicaoEnsinoRepository;
import com.uepb.advbus.repositories.RepositoryBase;

public class InstituicaoEnsinoTestDB {

	public static void main(String[] args) {
		persistInstituicao();
		//findAluno(2L);
		//findAll();
		//deleteAluno();
	}
	private static RepositoryBase<InstituicaoEnsino> instituicaoRepository = new InstituicaoEnsinoRepository();
	
	private static void persistInstituicao() {
		InstituicaoEnsino instituicao = new InstituicaoEnsino("UNIVERSIDADE ESTADUAL DA PARAÍBA", "UEPB", null);
		
		instituicaoRepository.beginTransaction();
		instituicaoRepository.add(instituicao);
		instituicaoRepository.commitAndClose();
	}
	
	private static void findAluno(Long id) {
		
	}
	
	private static void findAll() {
		
	}
	
	private static void deleteAluno() {
		
	}
}
