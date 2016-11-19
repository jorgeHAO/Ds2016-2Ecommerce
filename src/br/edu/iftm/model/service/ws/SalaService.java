package br.edu.iftm.model.service.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.edu.iftm.model.dao.SalaDao;
import br.edu.iftm.model.domain.Sala;
import br.edu.iftm.model.service.ISalaService;

@WebService(serviceName="ws/sala")
public class SalaService implements ISalaService {
		
	@Inject
	private SalaDao salaDao;
	
	@Override
	@WebMethod
	public Sala salvar(@WebParam(name="sala") Sala sala) {
		return salaDao.salvar(sala);
	}
	
	@Override
	@WebMethod
	public void atualizar(@WebParam(name="sala") Sala sala) {
		salaDao.atualizar(sala);
	}
	
	@Override
	@WebMethod
	public void excluir(@WebParam(name="idsala") Integer codigo) {
		salaDao.excluir(codigo);
	}
	
	@Override
	@WebMethod
	public List<Sala> buscarTodos() {
		return salaDao.buscar(new Sala());
	}

	@Override
	@WebMethod
	public Sala buscarPorId(@WebParam(name="idSala") Integer codigo) {
		return salaDao.buscarPorId(codigo);
	}

}