package br.edu.iftm.model.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.executable.ValidateOnExecution;
import br.edu.iftm.model.domain.Resposta;

public interface IRespostaService {

	@ValidateOnExecution
	Resposta salvar(@Valid Resposta resposta);

	void atualizar(Resposta resposta);

	void excluir(Integer codigo);
	
	List<Resposta> buscarTodos();
	
	public Resposta buscarPorId(Integer codigo);

}