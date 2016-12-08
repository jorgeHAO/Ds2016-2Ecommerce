package br.edu.iftm.model.service;

import java.util.List;

import br.edu.iftm.model.domain.CategoriaAluno;

public interface ICategoriaAlunoService {

	void salvar(CategoriaAluno categoriaAluno);

	void atualizar(CategoriaAluno categoriaAluno);

	void excluir(Integer codigo);

	List<CategoriaAluno> buscarTodos();

	public CategoriaAluno buscarPorId(Integer codigo);

}