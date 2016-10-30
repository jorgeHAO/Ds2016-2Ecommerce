package br.edu.iftm.model.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import br.edu.iftm.model.domain.Funcionario;

public interface IFuncionarioService {

	@ValidateOnExecution
	Funcionario salvar(@Valid Funcionario funcionario);

	void atualizar(Funcionario funcionario);

	void excluir(Integer codigo);
	
	List<Funcionario> buscarTodos();
	
	public Funcionario buscarPorId(Integer codigo);

}