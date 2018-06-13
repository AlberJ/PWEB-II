package br.edu.ifpb.memoriam.comando;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.memoriam.controlador.ContatoController;
import br.edu.ifpb.memoriam.controlador.Resultado;
import br.edu.ifpb.memoriam.dao.PersistenceUtil;
import br.edu.ifpb.memoriam.entidade.Contato;

public class EditaContatoComando implements IComando {

	@Override
	public Resultado execute(HttpServletRequest request, HttpServletResponse response) {
		ContatoController contatoCtrl = new ContatoController(PersistenceUtil.getCurrentEntityManager());
		
		Contato contato = contatoCtrl.busque(request.getParameterMap());
		
		request.setAttribute("contato", contato);
		Resultado resultado = new Resultado();
		resultado.setProximaPagina("contato/cadastro.jsp");
		return resultado;
	}

}
