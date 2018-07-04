package br.edu.ifpb.memoriam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.edu.ifpb.memoriam.entity.Contato;
import br.edu.ifpb.memoriam.entity.Operadora;

public class OperadoraDAO extends GenericDAO<Operadora, Integer> {
	
	public OperadoraDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	public OperadoraDAO(EntityManager em) {
		super(em);
	}

	@SuppressWarnings("unchecked")
	public List<Contato> findByContatosOp(Operadora operadora) {
		Integer id_operadora = operadora.getId();
		Query q = this.getEntityManager().createQuery("select u from Contato u where u.id_operadora = :id_operadora");
		q.setParameter("id_operadora", id_operadora);
		List<Contato> contatos = null;
		try {
			contatos = (List<Contato>) q.getResultList();
		} catch (NoResultException e) {
		}
		return contatos;
	}
}
