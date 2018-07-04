package br.edu.ifpb.memoriam.bean;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import br.edu.ifpb.memoriam.dao.OperadoraDAO;
import br.edu.ifpb.memoriam.entity.Operadora;

@ManagedBean
@ApplicationScoped
public class UtilBean {
	
	private List<Operadora> operadoras;

	@PostConstruct
	private void init() {
		OperadoraDAO daoOperadora = new OperadoraDAO();
		operadoras = daoOperadora.findAll();
	}

	public List<Operadora> getOperadoras() {
		return operadoras;
	}

	public void setOperadoras(List<Operadora> operadoras) {
		this.operadoras = operadoras;
	}

}
