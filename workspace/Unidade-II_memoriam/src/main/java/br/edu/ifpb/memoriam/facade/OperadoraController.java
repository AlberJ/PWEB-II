package br.edu.ifpb.memoriam.facade;

import java.util.List;

import javax.persistence.PersistenceException;

import br.edu.ifpb.memoriam.dao.OperadoraDAO;
import br.edu.ifpb.memoriam.entity.Operadora;

public class OperadoraController {

	public List<Operadora> consultar() {
		OperadoraDAO dao = new OperadoraDAO();
		List<Operadora> operadoras = dao.findAll();
		return operadoras;
	}

	public Operadora cadastrar(Operadora operadora) {
		OperadoraDAO dao = new OperadoraDAO();
		dao.beginTransaction();
		if (operadora.getId() == null) {
			dao.insert(operadora);
		} else {
			dao.update(operadora);
		}
		dao.commit();
		return operadora;
	}

	public boolean excluir(Operadora operadora) {
		boolean excluiu = false;
		OperadoraDAO dao = new OperadoraDAO();
		try {
			dao.beginTransaction();
			Operadora c = dao.find(operadora.getId());
			dao.delete(c);
			dao.commit();
		} catch (PersistenceException e) {
			dao.rollback();
		}
		return excluiu;
	}

}
