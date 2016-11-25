package br.edu.iftm.model.service;

import java.util.List;

import br.edu.iftm.model.domain.TipoPagamento;

/**
 * @author alan.franco
 *
 */
public interface ITipoPagamentoService {

	TipoPagamento salvar(TipoPagamento tipoPagamento);

	void atualizar(TipoPagamento tipoPagamento);

	void excluir(Integer codigo);

	TipoPagamento buscarPorId(Integer codigo);

	List<TipoPagamento> buscarTodos();

}