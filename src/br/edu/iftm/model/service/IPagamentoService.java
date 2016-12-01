package br.edu.iftm.model.service;

import java.util.List;

import br.edu.iftm.model.domain.Pagamento;

/**
 * @author alan.franco
 *
 */
public interface IPagamentoService {

	Pagamento salvar(Pagamento pagamento);

	void atualizar(Pagamento pagamento);

	void excluir(Integer codigo);

	Pagamento buscarPorId(Integer codigo);

	List<Pagamento> buscarTodos();

}