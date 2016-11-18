package br.edu.iftm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.edu.iftm.model.domain.TipoPagamento;

/**
 * @author alan.franco
 *
 */
public class TipoPagamentoDao {
	
	public TipoPagamentoDao() {
		super();
	}

	@PersistenceContext(unitName = "DS2016-2EcommercePU")
	private EntityManager entityManager;

	@Transactional
	public TipoPagamento salvar(TipoPagamento tipoPagamento) {
		entityManager.persist(tipoPagamento);
		return tipoPagamento;
	}

	@Transactional
	public void atualizar(TipoPagamento tipoPagamento) {
		TipoPagamento merge = entityManager.merge(tipoPagamento);
		entityManager.persist(merge);
	}

	@Transactional
	public void excluir(Integer id) {
		TipoPagamento merge = entityManager.merge(new TipoPagamento(id));
		entityManager.remove(merge);
	}

	@SuppressWarnings("unchecked")
	public List<TipoPagamento> buscar(TipoPagamento tipoPagamento) {
		Query query = entityManager.createQuery("from TipoPagamento");
		return (List<TipoPagamento>) query.getResultList();
	}

	public TipoPagamento buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from tipoPagamento where id_tipoPagamento = :codigo");
		query.setParameter("codigo", id);
		return (TipoPagamento) query.getSingleResult();
	}

}
