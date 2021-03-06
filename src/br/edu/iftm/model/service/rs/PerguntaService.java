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

import br.edu.iftm.model.dao.IPerguntaDao;
import br.edu.iftm.model.domain.Pergunta;
import br.edu.iftm.model.service.IPerguntaService;

@Path("/pergunta")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class PerguntaService implements IPerguntaService {

	@Inject
	private IPerguntaDao perguntaDao;

	@Override
	@POST
	public Pergunta salvar(Pergunta pergunta) {

		return perguntaDao.salvar(pergunta);
	}

	@Override
	@PUT
	public void atualizar(Pergunta pergunta) {
		perguntaDao.atualizar(pergunta);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		perguntaDao.excluir(codigo);
	}
	
	@GET
	@Override
	@Path("/{codigo}")
	public Pergunta buscarPorId(@PathParam("codigo") Integer codigo) {
		return perguntaDao.buscarPorId(codigo);
	}

	@Override
	@GET
	public List<Pergunta> buscarTodos() {
		return perguntaDao.buscar(new Pergunta());
	}
}