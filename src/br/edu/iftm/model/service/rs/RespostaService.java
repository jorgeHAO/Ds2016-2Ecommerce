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

import br.edu.iftm.model.dao.IRespostaDao;
import br.edu.iftm.model.domain.Resposta;
import br.edu.iftm.model.service.IRespostaService;

@Path("/resposta")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class RespostaService implements IRespostaService {

	@Inject
	private IRespostaDao respostaDao;

	@Override
	@POST
	public Resposta salvar(Resposta resposta) {

		return respostaDao.salvar(resposta);
	}

	@Override
	@PUT
	public void atualizar(Resposta resposta) {
		respostaDao.atualizar(resposta);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		respostaDao.excluir(codigo);
	}
	
	@GET
	@Override
	@Path("/{codigo}")
	public Resposta buscarPorId(@PathParam("codigo") Integer codigo) {
		return respostaDao.buscarPorId(codigo);
	}

	@Override
	@GET
	public List<Resposta> buscarTodos() {
		return respostaDao.buscar(new Resposta());
	}
}