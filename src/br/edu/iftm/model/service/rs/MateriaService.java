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

import br.edu.iftm.model.dao.IMateriaDao;
import br.edu.iftm.model.domain.Materia;
import br.edu.iftm.model.service.IMateriaService;

/**
 * @author alan.franco
 *
 */
@Path("/materia")
@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class MateriaService implements IMateriaService {

	public MateriaService() {
		super();
	}

	@Inject
	private IMateriaDao materiaDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.iftm.model.service.rs.IMateriaService#salvar(br.edu.iftm.model.
	 * domain.Materia)
	 */
	@Override
	@POST
	public Materia salvar(Materia materia) {
		if (materia.getIdMateria() != null && materia.getIdMateria() > 0) {
			materiaDao.atualizar(materia);
			return materia;
		}
		return materiaDao.salvar(materia);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.iftm.model.service.rs.IMateriaService#atualizar(br.edu.iftm.model.
	 * domain.Materia)
	 */
	@Override
	@PUT
	public void atualizar(Materia materia) {
		materiaDao.atualizar(materia);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.iftm.model.service.rs.IMateriaService#excluir(java.lang.Integer)
	 */
	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		materiaDao.excluir(codigo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.service.rs.IMateriaService#buscarPorId(java.lang.
	 * Integer)
	 */
	@Override
	@GET
	@Path("/{codigo}")
	public Materia buscarPorId(@PathParam("codigo") Integer codigo) {
		return materiaDao.buscarPorId(codigo);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.service.rs.IMateriaService#buscarTodos()
	 */
	@Override
	@GET
	public List<Materia> buscarTodos() {
		return materiaDao.buscar(new Materia());
	}
}