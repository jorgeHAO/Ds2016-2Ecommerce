package br.edu.iftm.model.dao;

import java.util.List;

import br.edu.iftm.model.domain.TipoPagamento;

/**
 * @author alan.franco
 *
 */
public interface ITipoPagamentoDao {

	TipoPagamento salvar(TipoPagamento tipoPagamento);

	void atualizar(TipoPagamento tipoPagamento);

	void excluir(Integer id);

	List<TipoPagamento> buscar(TipoPagamento tipoPagamento);

	TipoPagamento buscarPorId(Integer id);

}