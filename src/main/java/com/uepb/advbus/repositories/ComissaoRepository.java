package com.uepb.advbus.repositories;

import java.util.HashSet;
import java.util.Set;

import com.uepb.advbus.model.Aluno;
import com.uepb.advbus.model.Comissao;

public class ComissaoRepository extends RepositoryBase<Comissao> {

	public ComissaoRepository() {
		super(Comissao.class);
	}
	
	public Set<Aluno> getAlunosDaComissao(Long id) {
		Comissao comissao = getById(id);
		
		Set<Aluno> todos = new HashSet<>();
		for(Aluno alunos : comissao.getAlunos()) {
			todos.add(alunos);
		}
		return todos;
	}

}
