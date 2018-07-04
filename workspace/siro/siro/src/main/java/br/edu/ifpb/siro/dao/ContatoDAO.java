package br.edu.ifpb.siro.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpb.siro.entity.Envolvido;

public class ContatoDAO extends GenericDAO<Envolvido, Integer> {
	
	public ContatoDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public ContatoDAO(EntityManager em) {
		super(em);
	}
	
	@SuppressWarnings("unchecked")
	public List<Envolvido> findAllFromUser(Envolvido usuario) {
		Query q = this.getEntityManager().createQuery("from Contato c where c.usuario = :user");
		q.setParameter("user", usuario);
		return q.getResultList();
	}

	
}
