package br.edu.iftm.model.dao;

import java.util.List;

import br.edu.iftm.model.domain.Pergunta;

public interface IPerguntaDao {

	Pergunta salvar(Pergunta pergunta);

	void atualizar(Pergunta pergunta);

	void excluir(Integer id);

	List<Pergunta> buscar(Pergunta pergunta);

	Pergunta buscarPorId(Integer id);

}