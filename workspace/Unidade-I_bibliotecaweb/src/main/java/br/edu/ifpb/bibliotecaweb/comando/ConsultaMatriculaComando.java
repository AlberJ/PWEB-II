package br.edu.ifpb.bibliotecaweb.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.bibliotecaweb.controlador.Resultado;
import br.edu.ifpb.bibliotecaweb.controlador.UsuarioController;
import br.edu.ifpb.bibliotecaweb.dao.PersistenceUtil;
import br.edu.ifpb.bibliotecaweb.entidade.Usuario;

public class ConsultaMatriculaComando implements IComando {

	@Override
	public Resultado execute(HttpServletRequest request, HttpServletResponse response) {
		UsuarioController usuarioCtrl = new UsuarioController(PersistenceUtil.getCurrentEntityManager());

		Usuario usuario = usuarioCtrl.busqueMatricula(request.getParameterMap());

		request.setAttribute("usuario", usuario);
		Resultado resultado = new Resultado();
		resultado.setProximaPagina("usuario/usuario.jsp");
		return resultado;
	}

}
