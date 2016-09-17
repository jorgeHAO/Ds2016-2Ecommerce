package br.edu.iftm.model.service.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import br.edu.iftm.model.dao.CategoriaDao;
import br.edu.iftm.model.domain.Categoria;
import br.edu.iftm.model.service.ICategoriaService;

@WebService(serviceName="ws/categoria")
public class CategoriaService implements ICategoriaService {
		
	@Inject
	private CategoriaDao categoriaDao;
	
	@Override
	@WebMethod
	public void salvar(@WebParam(name="categoria") Categoria categoria) {
		categoriaDao.salvar(categoria);
	}
	
	@Override
	@WebMethod
	public void atualizar(@WebParam(name="categoria") Categoria categoria) {
		categoriaDao.atualizar(categoria);
	}
	
	@Override
	@WebMethod
	public void excluir(@WebParam(name="categoria") Categoria categoria) {
		categoriaDao.excluir(categoria);
	}
	
	@Override
	@WebMethod
	public List<Categoria> buscar(@WebParam(name="categoria") Categoria categoria) {
		return categoriaDao.buscar(categoria);
	}

}
