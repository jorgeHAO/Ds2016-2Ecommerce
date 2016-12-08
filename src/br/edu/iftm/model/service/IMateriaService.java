package br.edu.iftm.model.service;

import java.util.List;

import br.edu.iftm.model.domain.Materia;

/**
 * @author wilmo.pimentel
 *
 */
public interface IMateriaService {

	Materia salvar(Materia materia);

	void atualizar(Materia materia);

	void excluir(Integer codigo);

	Materia buscarPorId(Integer codigo);

	List<Materia> buscarTodos();

}