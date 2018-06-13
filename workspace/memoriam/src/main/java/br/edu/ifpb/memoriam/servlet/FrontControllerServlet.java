package br.edu.ifpb.memoriam.servlet;

import java.io.IOException;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.memoriam.comando.IComando;
import br.edu.ifpb.memoriam.controlador.Resultado;

/**
 * Servlet que atende a todas as requisições dos diversos casos de uso da
 * aplicação. Possui um parâmetro obrigatório onde deve ser informada a operação
 * a ser executada.
 * 
 * Exemplo: para cadastrar um colegiado, a URL é
 * http://container:porta/memoriam/controller.do?op=cadctt
 */
@WebServlet("/controller.do")
public class FrontControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String NOME_PACOTE = "br.edu.ifpb.memoriam.comando.";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doRequest(request, response);
	}

	protected void doRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Limpa as mensagens entre páginas
		request.getServletContext().removeAttribute("_msg");

		// Descobre a classe de comando a ser executada.
		Properties comandos = (Properties) request.getServletContext().getAttribute("comandos");

		String operacao = request.getParameter("op");
		if (operacao == null) {
			this.getServletContext().setAttribute("msgs", "Operação (op) não especificada na requisição!");
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}

		Resultado resultado = null;
		String nomeClasseComando = comandos.getProperty(operacao);
		try {
			Class<?> clazzComando = Class.forName(NOME_PACOTE + nomeClasseComando);
			IComando comando = (IComando) clazzComando.newInstance();
			resultado = comando.execute(request, response);

		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			this.getServletContext().setAttribute("_msg", "Comando "+operacao+" inexistente!");
			response.sendRedirect(request.getHeader("Referer"));
			return;
		} catch(Exception e) {
			this.getServletContext().setAttribute("_msg","Erro inesperado!");
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}

		if (resultado.isErro()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher(resultado.getProximaPagina());
			dispatcher.forward(request, response);			
		} else {
			if (resultado.isRedirect()) {
				response.sendRedirect(resultado.getProximaPagina());
			} else {
				request.getRequestDispatcher(resultado.getProximaPagina()).forward(request, response);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doRequest(request, response);
	}
	
}
