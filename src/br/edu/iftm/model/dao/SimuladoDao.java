package br.edu.iftm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.edu.iftm.model.domain.Simulado;

public class SimuladoDao implements ISimuladoDao {
	
	@PersistenceContext(unitName="DS2016-2EcommercePU")
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#salvar(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@Transactional
	public Simulado salvar(Simulado simulado) {
		entityManager.persist(simulado);
		return simulado;
	}
	
	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#atualizar(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@Transactional
	public void atualizar(Simulado simulado) {
		Simulado merge = entityManager.merge(simulado);
		entityManager.persist(merge);
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#excluir(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@Transactional
	public void excluir(Integer id) {
		Simulado merge = entityManager.merge(new Simulado(id));
		entityManager.remove(merge);
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#buscar(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Simulado> buscar(Simulado simulado) {
		Query query = entityManager.createQuery("from Simulado");
		return query.getResultList();
	}

	public Simulado buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from simulado where id_simulado = :codigo");
		query.setParameter("codigo",id);
		return (Simulado)query.getSingleResult();
	}

}
