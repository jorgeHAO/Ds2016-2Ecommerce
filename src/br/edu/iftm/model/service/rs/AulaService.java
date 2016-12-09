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

import br.edu.iftm.model.dao.IAulaDao;
import br.edu.iftm.model.domain.Aula;
import br.edu.iftm.model.service.IAulaService;

/**
 * @author wilmo.pimentel
 *
 */
@Path("/aula")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class AulaService implements IAulaService {

	public AulaService() {
		super();
	}

	@Inject
	private IAulaDao aulaDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.service.rs.IAulaService#salvar(br.edu.iftm.model.
	 * domain.Aula)
	 */
	@Override
	@POST
	public Aula salvar(Aula aula) {
		if (aula.getIdAula() != null && aula.getIdAula() > 0) {
			aulaDao.atualizar(aula);
			return aula;
		}
		return aulaDao.salvar(aula);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.service.rs.IAulaService#atualizar(br.edu.iftm.
	 * model.domain.Aula)
	 */
	@Override
	@PUT
	public void atualizar(Aula aula) {
		aulaDao.atualizar(aula);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.service.rs.IAulaService#excluir(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		aulaDao.excluir(codigo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.service.rs.IAulaService#buscarPorId(java.lang.
	 * Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public Aula buscarPorId(@PathParam("codigo") Integer codigo) {
		return aulaDao.buscarPorId(codigo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.service.rs.IAulaService#buscarTodos()
	 */
	@Override
	@GET
	public List<Aula> buscarTodos() {
		return aulaDao.buscar(new Aula());
	}
}