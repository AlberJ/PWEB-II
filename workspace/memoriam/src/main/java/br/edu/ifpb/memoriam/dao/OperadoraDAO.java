package br.edu.ifpb.memoriam.dao;

import javax.persistence.EntityManager;

import br.edu.ifpb.memoriam.entidade.Operadora;

public class OperadoraDAO extends GenericDAO<Operadora, Integer> {
	
	public OperadoraDAO(EntityManager em) {
		super(em);
	}
}
