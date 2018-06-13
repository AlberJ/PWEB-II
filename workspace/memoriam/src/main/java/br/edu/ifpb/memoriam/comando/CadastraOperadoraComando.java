package br.edu.ifpb.memoriam.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.memoriam.controlador.OperadoraController;
import br.edu.ifpb.memoriam.controlador.Resultado;
import br.edu.ifpb.memoriam.dao.PersistenceUtil;
import br.edu.ifpb.memoriam.entidade.Operadora;

public class CadastraOperadoraComando implements IComando {
	
	@Override
	public Resultado execute(HttpServletRequest request, HttpServletResponse response) {
		String paginaSucesso = "controller.do?op=conopers";
		String paginaErro = "operadora/cadastro.jsp";
		OperadoraController operadoraCtrl = new OperadoraController(PersistenceUtil.getCurrentEntityManager());
		
		Resultado resultado = operadoraCtrl.cadastre(request.getParameterMap());
		if (!resultado.isErro()) {
			resultado.setProximaPagina(paginaSucesso);
			resultado.setRedirect(true);
		} else {
			request.setAttribute("operadora", (Operadora) resultado.getEntidade());
			request.setAttribute("_msg", resultado.getMensagens());
			resultado.setProximaPagina(paginaErro);
		}
		return resultado;

	}

}
