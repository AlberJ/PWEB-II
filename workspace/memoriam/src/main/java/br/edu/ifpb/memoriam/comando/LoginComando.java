package br.edu.ifpb.memoriam.comando;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.memoriam.controlador.LoginController;
import br.edu.ifpb.memoriam.controlador.Resultado;
import br.edu.ifpb.memoriam.dao.PersistenceUtil;
import br.edu.ifpb.memoriam.entidade.Usuario;

public class LoginComando implements IComando {

	@Override
	public Resultado execute(HttpServletRequest request, HttpServletResponse response) {
		String paginaSucesso = "controller.do?op=conctts";
		String paginaErro = "login/login.jsp";
		HttpSession session = request.getSession();

		LoginController loginCtrl = new LoginController(PersistenceUtil.getCurrentEntityManager());
		Resultado resultado = loginCtrl.isValido(request.getParameterMap());
		Usuario usuarioLogado = (Usuario) resultado.getEntidade();
		if (resultado.isErro()) {
			request.setAttribute("msgs", resultado.getMensagens());
			resultado.setProximaPagina(paginaErro);
		} else {
			session.setAttribute("usuario", usuarioLogado);
			resultado.setProximaPagina(paginaSucesso);

			// trata o lembrar
			String lembrar = request.getParameter("lembrar");
			if (lembrar != null) {
				Cookie c = new Cookie("loginCookie", usuarioLogado.getEmail());
				c.setMaxAge(-1);
				response.addCookie(c);
			} else {
				for (Cookie cookie : request.getCookies()) {
					if (cookie.getName().equals("loginCookie")) {
						cookie.setValue(null);
						cookie.setMaxAge(0);
						response.addCookie(cookie);
					}
				}
			}
		}
		return resultado;
	}
}
