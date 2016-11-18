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

import br.edu.iftm.model.dao.INotaDao;
import br.edu.iftm.model.domain.Nota;
import br.edu.iftm.model.service.INotaService;

@Path("/aluno")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class NotaService implements INotaService {

	@Inject
	private INotaDao alunoDao;

	@Override
	@POST
	public Nota salvar(Nota aluno) {

		return alunoDao.salvar(aluno);
	}

	@Override
	@PUT
	public void atualizar(Nota aluno) {
		alunoDao.atualizar(aluno);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		alunoDao.excluir(codigo);
	}
	
	@GET
	@Override
	@Path("/{codigo}")
	public Nota buscarPorId(@PathParam("codigo") Integer codigo) {
		return alunoDao.buscarPorId(codigo);
	}

	@Override
	@GET
	public List<Nota> buscarTodos() {
		return alunoDao.buscar(new Nota());
	}
}