package br.edu.iftm.model.dao;

import java.util.List;

import br.edu.iftm.model.domain.Parcela;

/**
 * @author alan.franco
 *
 */
public interface IParcelaDao {

	Parcela salvar(Parcela parcela);

	void atualizar(Parcela parcela);

	void excluir(Integer id);

	List<Parcela> buscar(Parcela parcela);

	Parcela buscarPorId(Integer id);

}