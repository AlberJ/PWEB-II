package br.edu.ifpb.memoriam.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.memoriam.controlador.ContatoController;
import br.edu.ifpb.memoriam.controlador.Resultado;
import br.edu.ifpb.memoriam.dao.PersistenceUtil;

public class ExcluiContatoComando implements IComando {

	@Override
	public Resultado execute(HttpServletRequest request, HttpServletResponse response) {
		ContatoController contatoCtrl = new ContatoController(PersistenceUtil.getCurrentEntityManager());

		Resultado resultado = contatoCtrl.exclua(request.getParameterMap());
		if (resultado.isErro()) {
			request.setAttribute("_msg", resultado.getMensagens());
			resultado.setProximaPagina("contato/listagem.jsp");
		} else {
			resultado.setProximaPagina("controller.do?op=conctts");
			resultado.setRedirect(true);
		}
		return resultado;
	}

}
