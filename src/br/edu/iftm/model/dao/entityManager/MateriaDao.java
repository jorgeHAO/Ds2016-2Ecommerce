package br.edu.iftm.model.dao.entityManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.edu.iftm.model.dao.IMateriaDao;
import br.edu.iftm.model.domain.Materia;

/**
 * @author wilmo.pimentel
 *
 */
public class MateriaDao implements IMateriaDao {

	public MateriaDao() {
		super();
	}

	@PersistenceContext(unitName = "DS2016-2EcommercePU")
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.dao.IMateriaDao#salvar(br.edu.iftm.model.domain.
	 * Materia)
	 */
	@Override
	@Transactional
	public Materia salvar(Materia materia) {
		entityManager.persist(materia);
		return materia;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.iftm.model.dao.IMateriaDao#atualizar(br.edu.iftm.model.domain.
	 * Materia)
	 */
	@Override
	@Transactional
	public void atualizar(Materia materia) {
		Materia merge = entityManager.merge(materia);
		entityManager.persist(merge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.dao.IMateriaDao#excluir(java.lang.Integer)
	 */
	@Override
	@Transactional
	public void excluir(Integer id) {
		Materia merge = entityManager.merge(new Materia(id));
		entityManager.remove(merge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.dao.IMateriaDao#buscar(br.edu.iftm.model.domain.
	 * Materia)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Materia> buscar(Materia materia) {
		Query query = entityManager.createQuery("from Materia");
		return (List<Materia>) query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.dao.IMateriaDao#buscarPorId(java.lang.Integer)
	 */
	@Override
	public Materia buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from Materia where idMateria = :codigo");
		query.setParameter("codigo", id);
		return (Materia) query.getSingleResult();
	}

}
