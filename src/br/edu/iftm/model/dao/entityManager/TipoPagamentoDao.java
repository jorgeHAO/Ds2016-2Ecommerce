package br.edu.iftm.model.dao.entityManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.edu.iftm.model.dao.ITipoPagamentoDao;
import br.edu.iftm.model.domain.TipoPagamento;

/**
 * @author alan.franco
 *
 */
public class TipoPagamentoDao implements ITipoPagamentoDao {
	
	public TipoPagamentoDao() {
		super();
	}

	@PersistenceContext(unitName = "DS2016-2EcommercePU")
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ITipoPagamentoDao#salvar(br.edu.iftm.model.domain.TipoPagamento)
	 */
	@Override
	@Transactional
	public TipoPagamento salvar(TipoPagamento tipoPagamento) {
		entityManager.persist(tipoPagamento);
		return tipoPagamento;
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ITipoPagamentoDao#atualizar(br.edu.iftm.model.domain.TipoPagamento)
	 */
	@Override
	@Transactional
	public void atualizar(TipoPagamento tipoPagamento) {
		TipoPagamento merge = entityManager.merge(tipoPagamento);
		entityManager.persist(merge);
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ITipoPagamentoDao#excluir(java.lang.Integer)
	 */
	@Override
	@Transactional
	public void excluir(Integer id) {
		TipoPagamento merge = entityManager.merge(new TipoPagamento(id));
		entityManager.remove(merge);
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ITipoPagamentoDao#buscar(br.edu.iftm.model.domain.TipoPagamento)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<TipoPagamento> buscar(TipoPagamento tipoPagamento) {
		Query query = entityManager.createQuery("from TipoPagamento");
		return (List<TipoPagamento>) query.getResultList();
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ITipoPagamentoDao#buscarPorId(java.lang.Integer)
	 */
	@Override
	public TipoPagamento buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from TipoPagamento where idTipoPagamento = :codigo");
		query.setParameter("codigo", id);
		return (TipoPagamento) query.getSingleResult();
	}

}
