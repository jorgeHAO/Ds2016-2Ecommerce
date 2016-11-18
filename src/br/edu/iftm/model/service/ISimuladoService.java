package br.edu.iftm.model.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import br.edu.iftm.model.domain.Simulado;

public interface ISimuladoService {

	@ValidateOnExecution
	Simulado salvar(@Valid Simulado simulado);

	void atualizar(Simulado simulado);

	void excluir(Integer codigo);
	
	List<Simulado> buscarTodos();
	
	public Simulado buscarPorId(Integer codigo);

}