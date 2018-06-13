package br.edu.ifpb.memoriam.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.edu.ifpb.memoriam.entidade.Contato;
import br.edu.ifpb.memoriam.entidade.Usuario;

public class ContatoDAO extends GenericDAO<Contato, Integer> {
	
	public ContatoDAO(EntityManager em) {
		super(em);
	}
	
	public List<Contato> findAllFromUser(Usuario usuario) {
		Query q = this.getEntityManager().createQuery("from Contato c where c.usuario = :user");
		q.setParameter("user", usuario);
		return q.getResultList();
	}
}