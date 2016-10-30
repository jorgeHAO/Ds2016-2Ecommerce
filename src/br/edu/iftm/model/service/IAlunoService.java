package br.edu.iftm.model.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import br.edu.iftm.model.domain.Aluno;

public interface IAlunoService {

	@ValidateOnExecution
	Aluno salvar(@Valid Aluno aluno);

	void atualizar(Aluno aluno);

	void excluir(Integer codigo);
	
	List<Aluno> buscarTodos();
	
	public Aluno buscarPorId(Integer codigo);

}