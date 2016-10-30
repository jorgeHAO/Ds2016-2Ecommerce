package br.edu.iftm.model.service.rs;

import java.util.List;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import br.edu.iftm.model.dao.IFuncionarioDao;
import br.edu.iftm.model.domain.Funcionario;
import br.edu.iftm.model.service.IFuncionarioService;

@Path("/funcionario")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class FuncionarioService implements IFuncionarioService {

	@Inject
	private IFuncionarioDao funcionarioDao;

	@Override
	@POST
	public Funcionario salvar(Funcionario funcionario) {
		return funcionarioDao.salvar(funcionario);
	}

	@Override
	@PUT
	public void atualizar(Funcionario funcionario) {
		funcionarioDao.atualizar(funcionario);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		funcionarioDao.excluir(codigo);
	}
	
	@GET
	@Override
	@Path("/{codigo}")
	public Funcionario buscarPorId(@PathParam("codigo") Integer codigo) {
		return funcionarioDao.buscarPorId(codigo);
	}

	@Override
	@GET
	public List<Funcionario> buscarTodos() {
		return funcionarioDao.buscar(new Funcionario());
	}
}