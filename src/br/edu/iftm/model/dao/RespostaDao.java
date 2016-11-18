package br.edu.iftm.model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import br.edu.iftm.model.domain.Resposta;

public class RespostaDao implements IRespostaDao {
	
	@PersistenceContext(unitName="DS2016-2EcommercePU")
	private EntityManager entityManager;
	
	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#salvar(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@Transactional
	public Resposta salvar(Resposta resposta) {
		entityManager.persist(resposta);
		return resposta;
	}
	
	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#atualizar(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@Transactional
	public void atualizar(Resposta resposta) {
		Resposta merge = entityManager.merge(resposta);
		entityManager.persist(merge);
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#excluir(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@Transactional
	public void excluir(Integer id) {
		Resposta merge = entityManager.merge(new Resposta(id));
		entityManager.remove(merge);
	}

	/* (non-Javadoc)
	 * @see br.edu.iftm.model.dao.ICategoriaDao#buscar(br.edu.iftm.model.domain.Categoria)
	 */
	@Override
	@SuppressWarnings("unchecked")
	public List<Resposta> buscar(Resposta resposta) {
		Query query = entityManager.createQuery("from Resposta");
		return query.getResultList();
	}

	public Resposta buscarPorId(Integer id) {
		Query query = entityManager.createQuery("from resposta where id_resposta = :codigo");
		query.setParameter("codigo",id);
		return (Resposta)query.getSingleResult();
	}

}
