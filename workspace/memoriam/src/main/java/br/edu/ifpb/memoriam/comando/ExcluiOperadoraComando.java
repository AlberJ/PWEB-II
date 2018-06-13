package br.edu.ifpb.memoriam.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.memoriam.controlador.OperadoraController;
import br.edu.ifpb.memoriam.controlador.Resultado;
import br.edu.ifpb.memoriam.dao.PersistenceUtil;

public class ExcluiOperadoraComando implements IComando {


	@Override
	public Resultado execute(HttpServletRequest request, HttpServletResponse response) {
		OperadoraController operadoraCtrl = new OperadoraController(PersistenceUtil.getCurrentEntityManager());
		Resultado resultado = operadoraCtrl.exclua(request.getParameterMap());
		if (resultado.isErro()) {
			request.setAttribute("_msg", resultado.getMensagens());
			resultado.setProximaPagina("operadora/listagem.jsp");
		} else {
			resultado.setProximaPagina("controller.do?op=conopers");
			resultado.setRedirect(true);
			
		}
		return resultado;

	}

}
