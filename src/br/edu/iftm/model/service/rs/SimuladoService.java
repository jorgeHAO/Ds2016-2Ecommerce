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

import br.edu.iftm.model.dao.ISimuladoDao;
import br.edu.iftm.model.domain.Simulado;
import br.edu.iftm.model.service.ISimuladoService;

@Path("/simulado")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class SimuladoService implements ISimuladoService {

	@Inject
	private ISimuladoDao simuladoDao;

	@Override
	@POST
	public Simulado salvar(Simulado simulado) {

		if(simulado.getDtAplicacaoStr() != null && !simulado.getDtAplicacaoStr().isEmpty()){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			try {
				simulado.setDtAplicacao(sdf.parse(simulado.getDtAplicacaoStr()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		
		return simuladoDao.salvar(simulado);
	}

	@Override
	@PUT
	public void atualizar(Simulado simulado) {
		simuladoDao.atualizar(simulado);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		simuladoDao.excluir(codigo);
	}
	
	@GET
	@Override
	@Path("/{codigo}")
	public Simulado buscarPorId(@PathParam("codigo") Integer codigo) {
		return simuladoDao.buscarPorId(codigo);
	}

	@Override
	@GET
	public List<Simulado> buscarTodos() {
		return simuladoDao.buscar(new Simulado());
	}
}