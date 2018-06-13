package br.edu.ifpb.memoriam.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.memoriam.controlador.ContatoController;
import br.edu.ifpb.memoriam.controlador.Resultado;
import br.edu.ifpb.memoriam.dao.PersistenceUtil;
import br.edu.ifpb.memoriam.entidade.Contato;
import br.edu.ifpb.memoriam.entidade.Usuario;

public class CadastraContatoComando implements IComando {

	@Override
	public Resultado execute(HttpServletRequest request, HttpServletResponse response) {
		final String paginaSucesso = "controller.do?op=conctts";
		final String paginaErro = "contato/cadastro.jsp";

		ContatoController contatoCtrl = new ContatoController(PersistenceUtil.getCurrentEntityManager());

		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		Resultado resultado = contatoCtrl.cadastre(usuario, request.getParameterMap());
		if (!resultado.isErro()) {
			resultado.setProximaPagina(paginaSucesso);
			resultado.setRedirect(true);
		} else {
			request.setAttribute("contato", (Contato) resultado.getEntidade());
			request.setAttribute("_msg", resultado.getMensagens());
			resultado.setProximaPagina(paginaErro);
		}
		return resultado;
	}
}
