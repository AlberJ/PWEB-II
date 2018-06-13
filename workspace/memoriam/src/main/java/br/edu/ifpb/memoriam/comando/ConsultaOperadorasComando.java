package br.edu.ifpb.memoriam.comando;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.memoriam.controlador.OperadoraController;
import br.edu.ifpb.memoriam.controlador.Resultado;
import br.edu.ifpb.memoriam.dao.PersistenceUtil;
import br.edu.ifpb.memoriam.entidade.Operadora;

public class ConsultaOperadorasComando implements IComando {

	@Override
	public Resultado execute(HttpServletRequest request, HttpServletResponse response) {
		OperadoraController operadoraCtrl = new OperadoraController(PersistenceUtil.getCurrentEntityManager());
		List<Operadora> operadoras = operadoraCtrl.consulte();
		request.setAttribute("operadoras", operadoras);
		Resultado resultado = new Resultado();
		resultado.setProximaPagina("operadora/listagem.jsp");
		return resultado;
	}

}
