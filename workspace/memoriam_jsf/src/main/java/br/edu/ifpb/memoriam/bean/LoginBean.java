package br.edu.ifpb.memoriam.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import br.edu.ifpb.memoriam.entity.Usuario;
import br.edu.ifpb.memoriam.facade.LoginController;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean extends GenericBean {
	private String usuario;
	
	private String senha;
	
	private Usuario usuarioLogado;
	
	public String autenticar() {
		String proxView = null;
		LoginController ctr = new LoginController();
		if ((usuarioLogado = ctr.isValido(usuario, senha)) != null) {
			this.setValueOf("#{sessionScope.loginUser}", String.class, usuarioLogado.getEmail());
			proxView = "/contato/consulta?faces-redirect=true";
		} else {
			FacesMessage msg = new FacesMessage("Login inválido.");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, msg);
		}
		
		return proxView;
	}
	
	public String logout() {
		this.invalidateSession();
		return "/login/login?faces-redirect=true";
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

}
