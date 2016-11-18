package br.edu.iftm.model.dao;

import java.util.List;

import br.edu.iftm.model.domain.Nota;

public interface INotaDao {

	Nota salvar(Nota nota);

	void atualizar(Nota nota);

	void excluir(Integer id);

	List<Nota> buscar(Nota nota);

	Nota buscarPorId(Integer id);

}