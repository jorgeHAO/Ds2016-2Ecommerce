package br.edu.iftm.model.dao.entityManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.edu.iftm.model.dao.IParcelaDao;
import br.edu.iftm.model.domain.Parcela;

/**
 * @author alan.franco
 *
 */
public class ParcelaDao implements IParcelaDao {

	public ParcelaDao() {
		super();
	}

	@PersistenceContext(unitName = "DS2016-2EcommercePU")
	private EntityManager entityManager;

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.dao.IParcelaDao#salvar(br.edu.iftm.model.domain.
	 * Parcela)
	 */
	@Override
	@Transactional
	public Parcela salvar(Parcela parcela) {
		entityManager.persist(parcela);
		return parcela;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * br.edu.iftm.model.dao.IParcelaDao#atualizar(br.edu.iftm.model.domain.
	 * Parcela)
	 */
	@Override
	@Transactional
	public void atualizar(Parcela parcela) {
		Parcela merge = entityManager.merge(parcela);
		entityManager.persist(merge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.dao.IParcelaDao#excluir(java.lang.Integer)
	 */
	@Override
	@Transactional
	public void excluir(Integer id) {
		Parcela merge = entityManager.merge(new Parcela(id));
		entityManager.remove(merge);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.dao.IParcelaDao#buscar(br.edu.iftm.model.domain.
	 * Parcela)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Parcela> buscar(Parcela parcela) {
		Query query = entityManager.createQuery("from Parcela");
		return (List<Parcela>) query.getResultList();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see br.edu.iftm.model.dao.IParcelaDao#buscarPorId(java.lang.Integer)
	 */
	@Override
	public Parcela buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from Parcela where idParcela = :codigo");
		query.setParameter("codigo", id);
		return (Parcela) query.getSingleResult();
	}

}
