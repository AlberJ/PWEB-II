package br.edu.ifpb.memoriam.comando;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.memoriam.controlador.ContatoController;
import br.edu.ifpb.memoriam.controlador.Resultado;
import br.edu.ifpb.memoriam.dao.PersistenceUtil;
import br.edu.ifpb.memoriam.entidade.Contato;
import br.edu.ifpb.memoriam.entidade.Usuario;

public class ConsultaContatosComando implements IComando {

	@Override
	public Resultado execute(HttpServletRequest request, HttpServletResponse response) {
		ContatoController contatoCtrl = new ContatoController(PersistenceUtil.getCurrentEntityManager());
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		List<Contato> contatos = contatoCtrl.consulte(usuario);
		
		Resultado resultado = new Resultado();
		request.setAttribute("contatos", contatos);
		resultado.setProximaPagina("contato/listagem.jsp");
		return resultado;
	}

}
