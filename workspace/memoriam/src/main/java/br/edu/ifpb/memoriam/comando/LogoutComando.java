package br.edu.ifpb.memoriam.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.memoriam.controlador.Resultado;

public class LogoutComando implements IComando {

	@Override
	public Resultado execute(HttpServletRequest request, HttpServletResponse response) {
		request.getSession().invalidate();
		Resultado resultado = new Resultado();
		resultado.setErro(false);
		resultado.setProximaPagina("login/logon.jsp");
		resultado.setRedirect(true);
		return resultado;
	}
}
