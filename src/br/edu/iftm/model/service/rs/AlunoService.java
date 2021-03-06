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

import br.edu.iftm.model.dao.IAlunoDao;
import br.edu.iftm.model.domain.Aluno;
import br.edu.iftm.model.service.IAlunoService;

@Path("/aluno")
@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
public class AlunoService implements IAlunoService {

	@Inject
	private IAlunoDao alunoDao;

	@Override
	@POST
	public Aluno salvar(Aluno aluno) {

		if(aluno.getDtNascimentoStr() != null && !aluno.getDtNascimentoStr().isEmpty()){
			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
			try {
				aluno.setDtNascimento(sdf.parse(aluno.getDtNascimentoStr()));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return alunoDao.salvar(aluno);
	}

	@Override
	@PUT
	public void atualizar(Aluno aluno) {
		alunoDao.atualizar(aluno);
	}

	@Override
	@DELETE
	@Path("/{codigo}")
	public void excluir(@PathParam("codigo") Integer codigo) {
		alunoDao.excluir(codigo);
	}
	
	@GET
	@Override
	@Path("/{codigo}")
	public Aluno buscarPorId(@PathParam("codigo") Integer codigo) {
		return alunoDao.buscarPorId(codigo);
	}

	@Override
	@GET
	public List<Aluno> buscarTodos() {
		return alunoDao.buscar(new Aluno());
	}
}