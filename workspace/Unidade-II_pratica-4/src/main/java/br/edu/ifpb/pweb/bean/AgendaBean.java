package br.edu.ifpb.pweb.bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.ifpb.pweb.model.Contato;

@ManagedBean(name = "agenda")
@SessionScoped
public class AgendaBean {
	
	private List<Contato> contatos = new ArrayList<Contato>();
	
	public void salvar(Contato contato) {
		this.contatos.add(contato);
	}

	public String excluir(Contato contato) {
		this.contatos.remove(contato);
		return "index";
	}
	
	public void home() throws IOException {
		FacesContext.getCurrentInstance().getExternalContext().redirect("index");

	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

}
