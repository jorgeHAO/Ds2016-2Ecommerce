package br.edu.iftm.model.dao;

import java.util.List;

import br.edu.iftm.model.domain.Sala;

public interface ISalaDao {

	Sala salvar(Sala sala);

	void atualizar(Sala sala);

	void excluir(Integer id);

	List<Sala> buscar(Sala sala);

	Sala buscarPorId(Integer id);

}