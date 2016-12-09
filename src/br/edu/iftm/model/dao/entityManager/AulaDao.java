package br.edu.iftm.model.dao.entityManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.edu.iftm.model.dao.IAulaDao;
import br.edu.iftm.model.domain.Aula;

/**
 * @author wilmo.pimentel
 *
 */
public class AulaDao implements IAulaDao {

	public AulaDao() {
		super();
	}

	@PersistenceContext(unitName = "DS2016-2EcommercePU")
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.dao.IAulaDao#salvar(br.edu.iftm.model.domain.
	 * Aula)
	 */
	@Override
	@Transactional
	public Aula salvar(Aula aula) {
		entityManager.persist(aula);
		return aula;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.dao.IAulaDao#atualizar(br.edu.iftm.model.domain.
	 * Aula)
	 */
	@Override
	@Transactional
	public void atualizar(Aula aula) {
		Aula merge = entityManager.merge(aula);
		entityManager.persist(merge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.dao.IAulaDao#excluir(java.lang.Integer)
	 */
	@Override
	@Transactional
	public void excluir(Integer id) {
		Aula merge = entityManager.merge(new Aula(id));
		entityManager.remove(merge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.dao.IAulaDao#buscar(br.edu.iftm.model.domain.
	 * Aula)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Aula> buscar(Aula aula) {
		Query query = entityManager.createQuery("from Aula");
		return (List<Aula>) query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.dao.IAulaDao#buscarPorId(java.lang.Integer)
	 */
	@Override
	public Aula buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from Aula where idAula = :codigo");
		query.setParameter("codigo", id);
		return (Aula) query.getSingleResult();
	}

}
