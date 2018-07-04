package br.edu.ifpb.memoriam.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.edu.ifpb.memoriam.entity.Contato;
import br.edu.ifpb.memoriam.entity.Operadora;
import br.edu.ifpb.memoriam.entity.Usuario;
import br.edu.ifpb.memoriam.facade.ContatoController;
import br.edu.ifpb.memoriam.facade.LoginController;
import br.edu.ifpb.memoriam.facade.OperadoraController;
import br.edu.ifpb.memoriam.facade.Resultado;

@WebServlet("/controller.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ContatoController contatoCtrl = new ContatoController();
		OperadoraController operadoraCtrl = new OperadoraController();
		Resultado resultado = null;
		String paginaSucesso = "controller.do?op=conctt";
		String paginaErro = "controller.do?op=conctt";
		String proxPagina = null;

		this.getServletContext().removeAttribute("msgs");
		String operacao = request.getParameter("op");

		if (operacao == null) {

			this.getServletContext().setAttribute("msgs", "operação (op) não especificada na requisição!");
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}

		String id = request.getParameter("id");
		paginaSucesso = "contato/cadastro.jsp";
		paginaErro = "controller.do?op=conctt";

		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");

		switch (operacao) {

		case "conctt":
			List<Contato> contatos = contatoCtrl.consultarContato(usuario);
			request.setAttribute("contatos", contatos);
			proxPagina = "contato/consulta.jsp";
			break;

		case "conoper":
			List<Operadora> operadoras = operadoraCtrl.listarOperadoras();
			request.setAttribute("operadoras", operadoras);
			proxPagina = "operadora/consulta_op.jsp";
			break;


		}

		RequestDispatcher dispatcher = request.getRequestDispatcher(proxPagina);
		dispatcher.forward(request, response);
	}

	/* -------------------- DO POST -------------------- */

	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.getServletContext().removeAttribute("msgs");
		String operacao = request.getParameter("op");

		if (operacao == null) {
			this.getServletContext().setAttribute("msgs",
					new String[] { "Operação (op) não especificada na requisição" });
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}

		ContatoController contatoCtrl     = new ContatoController();
		OperadoraController operadoraCtrl = new OperadoraController();
		LoginController loginCtrl         = new LoginController();
		Resultado resultado = null;
		String paginaSucesso = "controller.do?op=consultarContato";
		String paginaErro = "controller.do?op=conctt";
		String proxPagina = null;
		
		
		HttpSession session = request.getSession();
        Usuario usuario = (Usuario) session.getAttribute("usuario");
        
		switch (operacao) {
		
		case "edtctt": /* editar contato */
			Contato contato = contatoCtrl.buscarContato(request.getParameterMap());
			request.setAttribute("contato", contato);
			proxPagina = "contato/edt_cadastro.jsp";
			break;
			
		case "edtope": /* editar operadora */
			Operadora operadora = operadoraCtrl.buscarOperadora(request.getParameterMap());
			request.setAttribute("operadora", operadora);
			proxPagina = "operadora/edt_operadora.jsp";
			break;

		
		
		    
		case "excope" : /* excluir operadora */
			resultado = operadoraCtrl.excluirOperadora(request.getParameterMap());
			proxPagina = "controller.do?op=conoper";
			break;

		case "delctt" : /* excluir contato */
			resultado = contatoCtrl.excluirContato(request.getParameterMap());
			proxPagina = paginaSucesso;
			break;

		case "cadctt" : /* cadastrar contato */
			resultado = contatoCtrl.cadastrarContato(request.getParameterMap());
			if (!resultado.isErro()) {
				proxPagina = paginaSucesso;
				request.setAttribute("msgs", resultado.getMensagens());
			} else {
				request.setAttribute("contato", (Contato) resultado.getEntidade());
				request.setAttribute("msgs", resultado.getMensagens());
				proxPagina = paginaErro;
			}
			break;

		case "cadope" : /* cadastrar operadora */
			resultado = operadoraCtrl.cadastrarOperadora(request.getParameterMap());
			if (!resultado.isErro()) {
				proxPagina = "controller.do?op=conoper";
				request.setAttribute("msgs", resultado.getMensagens());
			} else {
				request.setAttribute("operadora", (Operadora) resultado.getEntidade());
				request.setAttribute("msgs", resultado.getMensagens());
				proxPagina = "controller.do?op=conoper";
			}
			break;
			
		case "login":
			paginaSucesso = "controller.do?op=conctt";
			paginaErro = "controller.do?op=login";
			resultado = loginCtrl.isValido(request.getParameterMap());
			if (resultado.isErro()) {
				request.setAttribute("msgs", resultado.getMensagens());
				proxPagina = paginaErro;
			} else {
				session.setAttribute("usuario", (Usuario) resultado.getEntidade());
				proxPagina = paginaSucesso;
			}
			break;
	
		case "logout" :
			proxPagina = "login/login.jsp";
			session.invalidate();
			resultado.setErro(false);
			break;
		
		default:
			request.setAttribute("erro", "Operação não especificada no servlet");
			proxPagina = "../erro/erro.jsp";
		}

	if(resultado.isErro())

	{
		RequestDispatcher dispatcher = request.getRequestDispatcher(proxPagina);
		dispatcher.forward(request, response);
	}else
	{
		response.sendRedirect(proxPagina);
	}
  }
}
