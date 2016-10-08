package br.edu.iftm.model.service;

import java.util.List;

import br.edu.iftm.model.domain.Categoria;

public interface ICategoriaService {

	void salvar(Categoria categoria);

	void atualizar(Categoria categoria);

	void excluir(Integer codigo);
	
	List<Categoria> buscarTodos();
	
	public Categoria buscarPorId(Integer codigo);

}