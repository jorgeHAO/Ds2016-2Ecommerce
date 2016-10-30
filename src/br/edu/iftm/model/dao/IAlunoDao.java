package br.edu.iftm.model.dao;

import java.util.List;

import br.edu.iftm.model.domain.Aluno;

public interface IAlunoDao {

	Aluno salvar(Aluno aluno);

	void atualizar(Aluno aluno);

	void excluir(Integer id);

	List<Aluno> buscar(Aluno aluno);

	Aluno buscarPorId(Integer id);

}