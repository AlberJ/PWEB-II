package br.edu.ifpb.pweb.turmas.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import br.edu.ifpb.pweb.turmas.model.Aluno;

public class AlunoDAO extends GenericDAOJPAImpl<Aluno, Long> {

	public AlunoDAO(EntityManager em) {
		super(em);
	}

	public AlunoDAO() {
		this(PersistenceUtil.getCurrentEntityManager());
	}

	@SuppressWarnings("unchecked")
	public List<Aluno> findAll() throws DAOException {
		System.out.println("entrou no findall alunos");
		List<Aluno> alunos = null;
		try {
			Query q = this.getEntityManager().createQuery("from Aluno a");
			alunos = (List<Aluno>) q.getResultList();
		} catch (HibernateException e) {
			throw new DAOException("Erro ao tentar pegar Alunos", e);
		}
		for (Aluno aluno : alunos) {
			System.out.println(aluno.getNome());
		}
		return alunos;
	}
}
