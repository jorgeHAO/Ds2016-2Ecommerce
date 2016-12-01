package br.edu.iftm.model.dao.entityManager;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.edu.iftm.model.dao.IPagamentoDao;
import br.edu.iftm.model.domain.Pagamento;

/**
 * @author alan.franco
 *
 */
public class PagamentoDao implements IPagamentoDao {
	
	public PagamentoDao() {
		super();
	}

	@PersistenceContext(unitName = "DS2016-2EcommercePU")
	private EntityManager entityManager;

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.IPagamentoDao#salvar(br.edu.iftm.model.domain.Pagamento)
	 */
	@Override
	@Transactional
	public Pagamento salvar(Pagamento pagamento) {
		entityManager.persist(pagamento);
		return pagamento;
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.IPagamentoDao#atualizar(br.edu.iftm.model.domain.Pagamento)
	 */
	@Override
	@Transactional
	public void atualizar(Pagamento pagamento) {
		Pagamento merge = entityManager.merge(pagamento);
		entityManager.persist(merge);
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.IPagamentoDao#excluir(java.lang.Integer)
	 */
	@Override
	@Transactional
	public void excluir(Integer id) {
		Pagamento merge = entityManager.merge(new Pagamento(id));
		entityManager.remove(merge);
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.IPagamentoDao#buscar(br.edu.iftm.model.domain.Pagamento)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Pagamento> buscar(Pagamento pagamento) {
		Query query = entityManager.createQuery("from Pagamento");
		return (List<Pagamento>) query.getResultList();
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.IPagamentoDao#buscarPorId(java.lang.Integer)
	 */
	@Override
	public Pagamento buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from Pagamento where idPagamento = :codigo");
		query.setParameter("codigo", id);
		return (Pagamento) query.getSingleResult();
	}

}
