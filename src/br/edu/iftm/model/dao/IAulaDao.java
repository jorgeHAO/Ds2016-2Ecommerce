package br.edu.iftm.model.dao;

import java.util.List;

import br.edu.iftm.model.domain.Aula;

/**
 * @author wilmo.pimentel
 *
 */
public interface IAulaDao {

	Aula salvar(Aula aula);

	void atualizar(Aula aula);

	void excluir(Integer id);

	List<Aula> buscar(Aula aula);

	Aula buscarPorId(Integer id);

}