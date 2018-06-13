package br.edu.ifpb.memoriam.controlador;

import java.util.Map;

import javax.persistence.EntityManager;

import br.edu.ifpb.memoriam.dao.UsuarioDAO;
import br.edu.ifpb.memoriam.entidade.Usuario;

public class LoginController {
	private EntityManager entityManager;
	
	public LoginController(EntityManager entityManager) {
		super();
		this.entityManager = entityManager;
	}

	public Resultado isValido(Map<String, String[]> parametros) {
		Resultado r = new Resultado();
		r.setErro(false);
		
		String login = parametros.get("login")[0];
		String passwd = parametros.get("senha")[0];
		
		UsuarioDAO udao = new UsuarioDAO(entityManager);
		Usuario user = udao.findByLogin(login);
		if (user != null) {
			if (user.getSenha().equals(passwd)) {
				r.setEntidade(user);
			} else {
				r.setErro(true);
				r.addMensagem("Usuário ou senha inválido(a).");
			}
		} else {
			r.setErro(true);
			r.addMensagem("Usuário ou senha inválido(a).");
		}
		return r;
	}
}
