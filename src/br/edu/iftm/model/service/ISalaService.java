package br.edu.iftm.model.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import br.edu.iftm.model.domain.Sala;

public interface ISalaService {

	@ValidateOnExecution
	Sala salvar(@Valid Sala sala);

	void atualizar(Sala sala);

	void excluir(Integer codigo);
	
	List<Sala> buscarTodos();
	
	public Sala buscarPorId(Integer codigo);

}