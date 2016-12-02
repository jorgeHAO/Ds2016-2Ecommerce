package br.edu.iftm.model.dao;

import java.util.List;

import br.edu.iftm.model.domain.Pagamento;

/**
 * @author alan.franco
 *
 */
public interface IPagamentoDao {

	Pagamento salvar(Pagamento pagamento);

	void atualizar(Pagamento pagamento);

	void excluir(Integer id);

	List<Pagamento> buscar(Pagamento pagamento);

	Pagamento buscarPorId(Integer id);

}