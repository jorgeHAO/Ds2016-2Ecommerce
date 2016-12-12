package br.edu.iftm.model.dao;

import java.util.List;

import br.edu.iftm.model.domain.Categoria;

public interface ICategoriaDao {

	Categoria salvar(Categoria categoria);

	Categoria atualizar(Categoria categoria);

	void excluir(Integer id);

	List<Categoria> buscar(Categoria categoria);

	Categoria buscarPorId(Integer id);

}