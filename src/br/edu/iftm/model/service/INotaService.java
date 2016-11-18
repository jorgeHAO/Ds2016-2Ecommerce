package br.edu.iftm.model.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import br.edu.iftm.model.domain.Nota;

public interface INotaService {

	@ValidateOnExecution
	Nota salvar(@Valid Nota nota);

	void atualizar(Nota nota);

	void excluir(Integer codigo);
	
	List<Nota> buscarTodos();
	
	public Nota buscarPorId(Integer codigo);

}