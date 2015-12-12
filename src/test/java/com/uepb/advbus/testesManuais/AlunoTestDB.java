package com.uepb.advbus.testesManuais;

import java.util.Date;
import java.util.List;

import com.uepb.advbus.model.Aluno;
import com.uepb.advbus.model.Endereco;
import com.uepb.advbus.repositories.AlunoRepository;
import com.uepb.advbus.repositories.RepositoryBase;

public class AlunoTestDB {

	public static void main(String[] args) {
		persistAluno();
		//findAluno(1L);
		//findAll();
		//deleteAluno();
	}
	private static RepositoryBase<Aluno> alunoRepository = new AlunoRepository();
	
	private static void persistAluno() {
		
		
		Aluno aluno = new Aluno();
		aluno.setNome("Silvia");
		aluno.setMatricula("453");
		aluno.setCpf("091329804");
		aluno.setEndereco(new Endereco("Rua y", "168", "Batalhão", "58884-000", "Catolé do Rocha","PB"));
		aluno.setTelefone("88176911");
		aluno.setEmail("karla@gmail.com");
		aluno.setDataCadastro(new Date());
		
		System.out.println(aluno.getDataCadastro());
		
		alunoRepository.beginTransaction();
		alunoRepository.add(aluno);
		alunoRepository.commit();
		alunoRepository.close();
	}
	
	private static void findAluno(Long id) {
		alunoRepository.beginTransaction();
		Aluno aluno = alunoRepository.getById(id);
		System.out.println(aluno.getNome() + " - ");
		alunoRepository.close();
	}
	
	private static void findAll() {
		alunoRepository.beginTransaction();
		List<Aluno> alunos = alunoRepository.getAll();
		for(Aluno aluno : alunos) {
			System.out.println("ID: " + aluno.getId() + " Nome: " + aluno.getNome());
		}
	}
	
	private static void deleteAluno() {
		alunoRepository.beginTransaction();
		Aluno aluno = alunoRepository.getById(3L);
		alunoRepository.delete(aluno);
		alunoRepository.commit();
		alunoRepository.close();
	}
}
