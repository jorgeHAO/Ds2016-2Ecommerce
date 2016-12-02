package br.edu.iftm.model.service;

import java.util.List;

import br.edu.iftm.model.domain.Parcela;

/**
 * @author alan.franco
 *
 */
public interface IParcelaService {

	Parcela salvar(Parcela parcela);

	void atualizar(Parcela parcela);

	void excluir(Integer codigo);

	Parcela buscarPorId(Integer codigo);

	List<Parcela> buscarTodos();

}