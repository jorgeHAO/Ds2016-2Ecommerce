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

import br.edu.iftm.model.dao.IPagamentoDao;
import br.edu.iftm.model.domain.Pagamento;
import br.edu.iftm.model.service.IPagamentoService;

/**
 * @author alan.franco
 *
 */
@Path("/pagamento")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class PagamentoService implements IPagamentoService {

	public PagamentoService() {
		super();
	}

	@Inject
	private IPagamentoDao pagamentoDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.iftm.model.service.rs.IPagamentoService#salvar(br.edu.iftm.model.
	 * domain.Pagamento)
	 */
	@Override
	@POST
	public Pagamento salvar(Pagamento pagamento) {
		if (pagamento.getIdPagamento() != null && pagamento.getIdPagamento() > 0) {
			pagamentoDao.atualizar(pagamento);
			return pagamento;
		}
		return pagamentoDao.salvar(pagamento);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.iftm.model.service.rs.IPagamentoService#atualizar(br.edu.iftm.
	 * model.domain.Pagamento)
	 */
	@Override
	@PUT
	public void atualizar(Pagamento pagamento) {
		pagamentoDao.atualizar(pagamento);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.iftm.model.service.rs.IPagamentoService#excluir(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		pagamentoDao.excluir(codigo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.iftm.model.service.rs.IPagamentoService#buscarPorId(java.lang.
	 * Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public Pagamento buscarPorId(@PathParam("codigo") Integer codigo) {
		return pagamentoDao.buscarPorId(codigo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.service.rs.IPagamentoService#buscarTodos()
	 */
	@Override
	@GET
	public List<Pagamento> buscarTodos() {
		return pagamentoDao.buscar(new Pagamento());
	}
}