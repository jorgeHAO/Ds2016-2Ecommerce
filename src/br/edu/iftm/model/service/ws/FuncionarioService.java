package br.edu.iftm.model.service.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.edu.iftm.model.dao.FuncionarioDao;
import br.edu.iftm.model.domain.Funcionario;
import br.edu.iftm.model.service.IFuncionarioService;

@WebService(serviceName="ws/funcionario")
public class FuncionarioService implements IFuncionarioService {

	@Inject
	private FuncionarioDao funcionarioDao;
	
	@Override
	@WebMethod
	public Funcionario salvar(@WebParam(name="funcionario") Funcionario funcionario) {
		return funcionarioDao.salvar(funcionario);
	}
	
	@Override
	@WebMethod
	public void atualizar(@WebParam(name="funcionario") Funcionario funcionario) {
		funcionarioDao.atualizar(funcionario);
	}
	
	@Override
	@WebMethod
	public void excluir(@WebParam(name="idFuncionario") Integer codigo) {
		funcionarioDao.excluir(codigo);
	}
	
	@Override
	@WebMethod
	public List<Funcionario> buscarTodos() {
		return funcionarioDao.buscar(new Funcionario());
	}

	@Override
	@WebMethod
	public Funcionario buscarPorId(@WebParam(name="idFuncionario") Integer codigo) {
		return funcionarioDao.buscarPorId(codigo);
	}

}