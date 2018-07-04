package br.edu.ifpb.memoriam.facade;

import br.edu.ifpb.memoriam.dao.UsuarioDAO;
import br.edu.ifpb.memoriam.entity.Usuario;
import br.edu.ifpb.memoriam.util.PasswordUtil;

public class LoginController {

	public Usuario isValido(String usuario, String senha) {

		UsuarioDAO udao = new UsuarioDAO();
		Usuario user = udao.findByLogin(usuario);
		if (user == null || !PasswordUtil.encryptMD5(senha).equals(user.getSenha())) {
			user = null;
		}

		return user;
	}
}
