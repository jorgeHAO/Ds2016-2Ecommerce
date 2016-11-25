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

import br.edu.iftm.model.dao.ITipoPagamentoDao;
import br.edu.iftm.model.domain.TipoPagamento;
import br.edu.iftm.model.service.ITipoPagamentoService;

/**
 * @author alan.franco
 *
 */
@Path("/tipoPagamento")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class TipoPagamentoService implements ITipoPagamentoService {

	public TipoPagamentoService() {
		super();
	}

	@Inject
	private ITipoPagamentoDao tipoPagamentoDao;

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.service.rs.ITipoPagamentoService#salvar(br.edu.iftm.model.domain.TipoPagamento)
	 */
	@Override
	@POST
	public TipoPagamento salvar(TipoPagamento tipoPagamento) {
		if (tipoPagamento.getIdTipoPagamento() != null && tipoPagamento.getIdTipoPagamento() > 0) {
			tipoPagamentoDao.atualizar(tipoPagamento);
			return tipoPagamento;
		}
		return tipoPagamentoDao.salvar(tipoPagamento);
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.service.rs.ITipoPagamentoService#atualizar(br.edu.iftm.model.domain.TipoPagamento)
	 */
	@Override
	@PUT
	public void atualizar(TipoPagamento tipoPagamento) {
		tipoPagamentoDao.atualizar(tipoPagamento);
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.service.rs.ITipoPagamentoService#excluir(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		tipoPagamentoDao.excluir(codigo);
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.service.rs.ITipoPagamentoService#buscarPorId(java.lang.Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public TipoPagamento buscarPorId(@PathParam("codigo") Integer codigo) {
		return tipoPagamentoDao.buscarPorId(codigo);
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.service.rs.ITipoPagamentoService#buscarTodos()
	 */
	@Override
	@GET
	public List<TipoPagamento> buscarTodos() {
		return tipoPagamentoDao.buscar(new TipoPagamento());
	}
}