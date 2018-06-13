package br.edu.ifpb.memoriam.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.memoriam.controlador.OperadoraController;
import br.edu.ifpb.memoriam.controlador.Resultado;
import br.edu.ifpb.memoriam.dao.PersistenceUtil;
import br.edu.ifpb.memoriam.entidade.Operadora;

public class EditaOperadoraComando implements IComando {

	@Override
	public Resultado execute(HttpServletRequest request, HttpServletResponse response) {
		OperadoraController operadoraCtrl = new OperadoraController(PersistenceUtil.getCurrentEntityManager());
		Operadora operadora = operadoraCtrl.busque(request.getParameterMap());
		request.setAttribute("operadora", operadora);
		Resultado resultado = new Resultado();
		resultado.setProximaPagina("operadora/cadastro.jsp");
		return resultado;
	}

}
