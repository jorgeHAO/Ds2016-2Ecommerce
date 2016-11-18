package br.edu.iftm.model.dao;

import java.util.List;

import br.edu.iftm.model.domain.Simulado;

public interface ISimuladoDao {

	Simulado salvar(Simulado simulado);

	void atualizar(Simulado simulado);

	void excluir(Integer id);

	List<Simulado> buscar(Simulado simulado);

	Simulado buscarPorId(Integer id);

}