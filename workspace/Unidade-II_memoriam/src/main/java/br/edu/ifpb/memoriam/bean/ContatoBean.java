package br.edu.ifpb.memoriam.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.persistence.PersistenceException;

import br.edu.ifpb.memoriam.entity.Contato;
import br.edu.ifpb.memoriam.facade.ContatoController;

@ManagedBean(name="contatoBean")
@ViewScoped
public class ContatoBean extends GenericBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private List<Contato> contatos;
	
	@ManagedProperty("#{loginBean}")
	private LoginBean loginBean;
	
	private Contato contato;
	
	@PostConstruct
	private void init() {
		Contato contato = (Contato) this.getFlash("contato");
		if (contato != null) {
			this.contato = contato;
		} else {
			ContatoController ctrl = new ContatoController();
			this.contatos = ctrl.consultar(loginBean.getUsuarioLogado());
			this.contato  = new Contato();
		}
		
	}
	
	public String editar(Contato contato) {
		this.setFlash("contato", contato);
		return "/contato/cadastro?faces-redirect=true";
	}
	
	public String salvar() {
		String proxView = null;
		try {
			ContatoController controller = new ContatoController();
			controller.cadastrar(this.contato, this.loginBean.getUsuarioLogado());
			this.addSuccessMessage("Contato salvo com sucesso");
			proxView = "/contato/consulta?faces-redirect=true";
			this.contato  = new Contato();
		} catch (PersistenceException e) {
			this.addErrorMessage("Erro ao tentar salvar o contato");
		}
		return proxView;
	}

	public List<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

}
