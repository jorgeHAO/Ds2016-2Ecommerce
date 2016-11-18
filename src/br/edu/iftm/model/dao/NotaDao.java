package br.edu.iftm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.edu.iftm.model.domain.Nota;

public class NotaDao implements INotaDao {
	
	@PersistenceContext(unitName="DS2016-2EcommercePU")
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#salvar(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@Transactional
	public Nota salvar(Nota nota) {
		entityManager.persist(nota);
		return nota;
	}
	
	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#atualizar(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@Transactional
	public void atualizar(Nota nota) {
		Nota merge = entityManager.merge(nota);
		entityManager.persist(merge);
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#excluir(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@Transactional
	public void excluir(Integer id) {
		Nota merge = entityManager.merge(new Nota(id));
		entityManager.remove(merge);
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#buscar(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Nota> buscar(Nota nota) {
		Query query = entityManager.createQuery("from Nota");
		return query.getResultList();
	}

	public Nota buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from nota where id_nota = :codigo");
		query.setParameter("codigo",id);
		return (Nota)query.getSingleResult();
	}

}
