package br.edu.ifpb.pweb.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import br.edu.ifpb.pweb.model.Contato;

@ManagedBean(name = "contato")
@SessionScoped
public class ContatoBean {

	@ManagedProperty(value = "#{agenda}")
	private AgendaBean agenda;

	private Contato contato;
	private String nome;
	private String email;
	private String telefone;
	private String bt_editando;
	private String lb_editando;

	public String salvarContato() {
		contato = new Contato(nome, email, telefone);
		agenda.salvar(contato);
		nome = null;
		email = null;
		telefone = null;
		this.bt_editando = null;
		this.lb_editando = null;
		return "index";
	}

	public String editar(Contato c) {
		this.setNome(c.getNome());
		this.setTelefone(c.getTelefone());
		this.setEmail(c.getEmail());
		this.bt_editando = "Salvar Alterações";
		this.lb_editando = "Editando Contato";
		return "novo_contato";
	}

	public AgendaBean getAgenda() {
		return agenda;
	}

	public void setAgenda(AgendaBean agenda) {
		this.agenda = agenda;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getBt_editando() {
		return bt_editando;
	}

	public void setBt_editando(String bt_editando) {
		this.bt_editando = bt_editando;
	}

	public String getLb_editando() {
		return lb_editando;
	}

	public void setLb_editando(String lb_editando) {
		this.lb_editando = lb_editando;
	}

}
