package com.uepb.advbus.testesManuais;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.uepb.advbus.model.Aluno;
import com.uepb.advbus.model.Comissao;
import com.uepb.advbus.model.Endereco;
import com.uepb.advbus.repositories.AlunoRepository;
import com.uepb.advbus.repositories.ComissaoRepository;
import com.uepb.advbus.repositories.RepositoryBase;

public class ComissaoTestDB {

	public static void main(String[] args) {
		//persistComissao();
		findComissao(1L);
		//findAll();
		//deleteComissao();
	}
	
	private static ComissaoRepository comissaoRepository = new ComissaoRepository();	
	private static RepositoryBase<Aluno> alunoRepository = new AlunoRepository();
	private static RepositoryBase<Usuario> usuarioRepository = new UsuarioRepository();
	
	private static void persistComissao() {	
		Usuario usuario = new Usuario();
		usuario.setUsuario("Snow");
		usuario.setSenha("abc");
		
		usuarioRepository.beginTransaction();
		usuarioRepository.add(usuario);
		usuarioRepository.commit();
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Karla");
		aluno1.setMatricula("354");
		aluno1.setCpf("091329804");
		aluno1.setEndereco(new Endereco("Rua y", "168", "Batalhão", "58884-000", "Catolé do Rocha","PB"));
		aluno1.setTelefone("88176911");
		aluno1.setEmail("karla@gmail.com");
		aluno1.setDataCadastro(new Date());
		aluno1.setUsuario(usuario);
		
		Aluno aluno2 = new Aluno();
		aluno2.setNome("Silvia");
		aluno2.setMatricula("453");
		aluno2.setCpf("091329804");
		aluno2.setEndereco(new Endereco("Rua y", "168", "Batalhão", "58884-000", "Catolé do Rocha","PB"));
		aluno2.setTelefone("88176911");
		aluno2.setEmail("karla@gmail.com");
		aluno2.setDataCadastro(new Date());
		aluno2.setUsuario(usuario);
		
		alunoRepository.beginTransaction();
		alunoRepository.add(aluno1);
		alunoRepository.add(aluno2);
		alunoRepository.commit();
		
		Set<Aluno> alunos = new HashSet<>();
		alunos.add(aluno1);
		alunos.add(aluno2);
		
		Comissao comissao = new Comissao("Teste", new Date(), new Date(), alunos, usuario);
		
		comissaoRepository.beginTransaction();
		comissaoRepository.add(comissao);
		comissaoRepository.commitAndClose();
	}
	
	private static void findComissao(Long id) {
		comissaoRepository.beginTransaction();
		Set<Aluno> todos = comissaoRepository.getAlunosDaComissao(id);
		Comissao comissao = comissaoRepository.getById(1l);
		for(Aluno alunos : todos) {
			System.out.println(alunos.getNome() + " - " +comissao.getUsuario().getUsuario());
		}
			
	}
	
}
