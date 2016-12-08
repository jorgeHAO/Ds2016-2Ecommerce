package br.edu.iftm.model.dao;

import java.util.List;

import br.edu.iftm.model.domain.Materia;

/**
 * @author wilmo.pimentel
 *
 */
public interface IMateriaDao {

	Materia salvar(Materia materia);

	void atualizar(Materia materia);

	void excluir(Integer id);

	List<Materia> buscar(Materia materia);

	Materia buscarPorId(Integer id);

}