package br.edu.iftm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.edu.iftm.model.domain.Aluno;
import br.edu.iftm.model.domain.Categoria;

public class AlunoDao implements IAlunoDao {
	
	@PersistenceContext(unitName="DS2016-2EcommercePU")
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#salvar(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@Transactional
	public Aluno salvar(Aluno aluno) {
		entityManager.persist(aluno);
		return aluno;
	}
	
	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#atualizar(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@Transactional
	public void atualizar(Aluno aluno) {
		Aluno merge = entityManager.merge(aluno);
		entityManager.persist(merge);
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#excluir(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@Transactional
	public void excluir(Integer id) {
		Aluno merge = entityManager.merge(new Aluno(id));
		entityManager.remove(merge);
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#buscar(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Aluno> buscar(Aluno aluno) {
		Query query = entityManager.createQuery("from Aluno");
		return query.getResultList();
	}

	public Aluno buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from aluno where id_aluno = :codigo");
		query.setParameter("codigo",id);
		return (Aluno)query.getSingleResult();
	}

}
