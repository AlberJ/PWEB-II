package br.edu.ifpb.pweb.turmas.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import br.edu.ifpb.pweb.turmas.dao.TurmaDAO;
import br.edu.ifpb.pweb.turmas.model.Turma;

@ManagedBean(name = "turmasBean")

public class turmasBean {
	List<Turma> turmas;

	public void listar(ActionEvent e) {
		TurmaDAO dao = new TurmaDAO();
		turmas = dao.findAll();
	}
}
