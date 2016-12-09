package br.edu.iftm.model.service;

import java.util.List;

import br.edu.iftm.model.domain.Aula;

/**
 * @author wilmo.pimentel
 *
 */
public interface IAulaService {

	Aula salvar(Aula aula);

	void atualizar(Aula aula);

	void excluir(Integer codigo);

	Aula buscarPorId(Integer codigo);

	List<Aula> buscarTodos();

}