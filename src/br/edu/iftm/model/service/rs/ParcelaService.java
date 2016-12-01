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

import br.edu.iftm.model.dao.IParcelaDao;
import br.edu.iftm.model.domain.Parcela;
import br.edu.iftm.model.service.IParcelaService;

/**
 * @author alan.franco
 *
 */
@Path("/parcela")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class ParcelaService implements IParcelaService {

	public ParcelaService() {
		super();
	}

	@Inject
	private IParcelaDao parcelaDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.iftm.model.service.rs.IParcelaService#salvar(br.edu.iftm.model.
	 * domain.Parcela)
	 */
	@Override
	@POST
	public Parcela salvar(Parcela parcela) {
		if (parcela.getIdParcela() != null && parcela.getIdParcela() > 0) {
			parcelaDao.atualizar(parcela);
			return parcela;
		}
		return parcelaDao.salvar(parcela);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.service.rs.IParcelaService#atualizar(br.edu.iftm.
	 * model.domain.Parcela)
	 */
	@Override
	@PUT
	public void atualizar(Parcela parcela) {
		parcelaDao.atualizar(parcela);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.iftm.model.service.rs.IParcelaService#excluir(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		parcelaDao.excluir(codigo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.service.rs.IParcelaService#buscarPorId(java.lang.
	 * Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public Parcela buscarPorId(@PathParam("codigo") Integer codigo) {
		return parcelaDao.buscarPorId(codigo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.service.rs.IParcelaService#buscarTodos()
	 */
	@Override
	@GET
	public List<Parcela> buscarTodos() {
		return parcelaDao.buscar(new Parcela());
	}
}