package br.edu.iftm.model.dao.entityManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.edu.iftm.model.dao.ICategoriaAlunoDao;
import br.edu.iftm.model.domain.CategoriaAluno;

public class CategoriaAlunoDao implements ICategoriaAlunoDao {

	@PersistenceContext(unitName = "DS2016-2EcommercePU")
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.dao.ICategoriaDao#salvar(br.edu.iftm.model.domain.
	 * Categoria)
	 */
	@Override
	@Transactional
	public void salvar(CategoriaAluno categoriaAluno) {
		entityManager.persist(categoriaAluno);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.iftm.model.dao.ICategoriaDao#atualizar(br.edu.iftm.model.domain.
	 * Categoria)
	 */
	@Override
	@Transactional
	public void atualizar(CategoriaAluno categoriaAluno) {
		CategoriaAluno merge = entityManager.merge(categoriaAluno);
		entityManager.persist(merge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.iftm.model.dao.ICategoriaDao#excluir(br.edu.iftm.model.domain.
	 * Categoria)
	 */
	@Override
	@Transactional
	public void excluir(Integer id) {
		CategoriaAluno merge = entityManager.merge(new CategoriaAluno(id));
		entityManager.remove(merge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.dao.ICategoriaDao#buscar(br.edu.iftm.model.domain.
	 * Categoria)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<CategoriaAluno> buscar(CategoriaAluno categoriaAluno) {
		Query query = entityManager.createQuery("from CategoriaAluno");
		return query.getResultList();
	}

	public CategoriaAluno buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from CategoriaAluno where idCategoriaAluno = :codigo");
		query.setParameter("codigo", id);
		return (CategoriaAluno) query.getSingleResult();
	}

}
