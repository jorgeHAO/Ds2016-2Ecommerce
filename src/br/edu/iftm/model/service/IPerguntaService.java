package br.edu.iftm.model.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import br.edu.iftm.model.domain.Pergunta;

public interface IPerguntaService {

	@ValidateOnExecution
	Pergunta salvar(@Valid Pergunta pergunta);

	void atualizar(Pergunta pergunta);

	void excluir(Integer codigo);
	
	List<Pergunta> buscarTodos();
	
	public Pergunta buscarPorId(Integer codigo);

}