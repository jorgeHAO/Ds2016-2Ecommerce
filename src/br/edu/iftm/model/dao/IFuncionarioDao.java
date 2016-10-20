package br.edu.iftm.model.dao;

import java.util.List;

import br.edu.iftm.model.domain.Funcionario;

public interface IFuncionarioDao {

	void salvar(Funcionario funcionario);

	void atualizar(Funcionario funcionario);

	void excluir(Integer id);

	List<Funcionario> buscar(Funcionario funcionario);

	Funcionario buscarPorId(Integer id);

}