package br.edu.iftm.model.service.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.edu.iftm.model.dao.CategoriaDao;
import br.edu.iftm.model.domain.Categoria;
import br.edu.iftm.model.service.ICategoriaService;

@WebService(serviceName = "ws/categoria")
public class CategoriaService implements ICategoriaService {

	@Inject
	private CategoriaDao categoriaDao;

	@Override
	@WebMethod
	public Categoria salvar(@WebParam(name = "categoria") Categoria categoria) {
		return categoriaDao.salvar(categoria);
	}

	@Override
	@WebMethod
	public Categoria atualizar(@WebParam(name = "categoria") Categoria categoria) {
		return categoriaDao.atualizar(categoria);
	}

	@Override
	@WebMethod
	public void excluir(@WebParam(name = "idCategoria") Integer codigo) {
		categoriaDao.excluir(codigo);
	}

	@Override
	@WebMethod
	public List<Categoria> buscarTodos() {
		return categoriaDao.buscar(new Categoria());
	}

	@Override
	@WebMethod
	public Categoria buscarPorId(@WebParam(name = "idCategoria") Integer codigo) {
		return categoriaDao.buscarPorId(codigo);
	}

}