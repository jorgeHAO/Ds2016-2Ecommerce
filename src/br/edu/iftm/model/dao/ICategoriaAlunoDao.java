package br.edu.iftm.model.dao;

import java.util.List;

import br.edu.iftm.model.domain.CategoriaAluno;

public interface ICategoriaAlunoDao {

	void salvar(CategoriaAluno categoriaAluno);

	void atualizar(CategoriaAluno categoriaAluno);

	void excluir(Integer id);

	List<CategoriaAluno> buscar(CategoriaAluno categoriaAluno);

	CategoriaAluno buscarPorId(Integer id);

}