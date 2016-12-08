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

import br.edu.iftm.model.dao.ICategoriaAlunoDao;
import br.edu.iftm.model.domain.CategoriaAluno;
import br.edu.iftm.model.service.ICategoriaAlunoService;

@Path("/categoriaAluno")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class CategoriaAlunoService implements ICategoriaAlunoService {

	@Inject
	private ICategoriaAlunoDao categoriaAlunoDao;

	@Override
	@POST
	public void salvar(CategoriaAluno categoria) {
		categoriaAlunoDao.salvar(categoria);
	}

	@Override
	@PUT
	public void atualizar(CategoriaAluno categoria) {
		categoriaAlunoDao.atualizar(categoria);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		categoriaAlunoDao.excluir(codigo);
	}

	@GET
	@Override
	@Path("/{codigo}")
	public CategoriaAluno buscarPorId(@PathParam("codigo") Integer codigo) {
		return categoriaAlunoDao.buscarPorId(codigo);
	}

	@Override
	@GET
	public List<CategoriaAluno> buscarTodos() {
		return categoriaAlunoDao.buscar(new CategoriaAluno());
	}
}