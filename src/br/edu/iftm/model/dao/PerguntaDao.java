package br.edu.iftm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.edu.iftm.model.domain.Pergunta;

public class PerguntaDao implements IPerguntaDao {
	
	@PersistenceContext(unitName="DS2016-2EcommercePU")
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#salvar(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@Transactional
	public Pergunta salvar(Pergunta pergunta) {
		entityManager.persist(pergunta);
		return pergunta;
	}
	
	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#atualizar(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@Transactional
	public void atualizar(Pergunta pergunta) {
		Pergunta merge = entityManager.merge(pergunta);
		entityManager.persist(merge);
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#excluir(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@Transactional
	public void excluir(Integer id) {
		Pergunta merge = entityManager.merge(new Pergunta(id));
		entityManager.remove(merge);
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#buscar(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Pergunta> buscar(Pergunta pergunta) {
		Query query = entityManager.createQuery("from Pergunta");
		return query.getResultList();
	}

	public Pergunta buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from pergunta where id_pergunta = :codigo");
		query.setParameter("codigo",id);
		return (Pergunta)query.getSingleResult();
	}

}
