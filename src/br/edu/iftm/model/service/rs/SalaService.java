package br.edu.iftm.model.service.rs;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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

import br.edu.iftm.model.dao.ISalaDao;
import br.edu.iftm.model.domain.Sala;
import br.edu.iftm.model.service.ISalaService;

@Path("/sala")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class SalaService implements ISalaService {

	@Inject
	private ISalaDao salaDao;

	@Override
	@POST
	public Sala salvar(Sala sala) {
		return salaDao.salvar(sala);
	}

	@Override
	@PUT
	public void atualizar(Sala sala) {
		salaDao.atualizar(sala);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		salaDao.excluir(codigo);
	}
	
	@GET
	@Override
	@Path("/{codigo}")
	public Sala buscarPorId(@PathParam("codigo") Integer codigo) {
		return salaDao.buscarPorId(codigo);
	}

	@Override
	@GET
	public List<Sala> buscarTodos() {
		return salaDao.buscar(new Sala());
	}
}