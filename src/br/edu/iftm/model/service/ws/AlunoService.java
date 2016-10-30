package br.edu.iftm.model.service.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.edu.iftm.model.dao.AlunoDao;
import br.edu.iftm.model.domain.Aluno;
import br.edu.iftm.model.service.IAlunoService;

@WebService(serviceName="ws/aluno")
public class AlunoService implements IAlunoService {
		
	@Inject
	private AlunoDao alunoDao;
	
	@Override
	@WebMethod
	public Aluno salvar(@WebParam(name="aluno") Aluno aluno) {
		return alunoDao.salvar(aluno);
	}
	
	@Override
	@WebMethod
	public void atualizar(@WebParam(name="aluno") Aluno aluno) {
		alunoDao.atualizar(aluno);
	}
	
	@Override
	@WebMethod
	public void excluir(@WebParam(name="idaluno") Integer codigo) {
		alunoDao.excluir(codigo);
	}
	
	@Override
	@WebMethod
	public List<Aluno> buscarTodos() {
		return alunoDao.buscar(new Aluno());
	}

	@Override
	@WebMethod
	public Aluno buscarPorId(@WebParam(name="idAluno") Integer codigo) {
		return alunoDao.buscarPorId(codigo);
	}

}