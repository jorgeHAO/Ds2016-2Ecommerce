package br.edu.iftm.model.dao;

import java.util.List;

import br.edu.iftm.model.domain.Resposta;

public interface IRespostaDao {

	Resposta salvar(Resposta resposta);

	void atualizar(Resposta resposta);

	void excluir(Integer id);

	List<Resposta> buscar(Resposta resposta);

	Resposta buscarPorId(Integer id);

}