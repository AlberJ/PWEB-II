package br.edu.ifpb.pweb.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "loginBean")
@RequestScoped
public class LoginBean {

	String login;
	String senha;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String autentique() {
		if (login.equals("admin") && senha.equals("admin")) {
			return "sucesso?faces-redirect=true";
		}
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Usu�rio  e/ou  senha  inv�lidos.",
				"Verifique  se  CAPSLOCK  est�  ativada."));
		return null;
	}
}
