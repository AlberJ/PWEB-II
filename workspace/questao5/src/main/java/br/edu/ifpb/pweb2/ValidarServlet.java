package br.edu.ifpb.pweb2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/validar")
public class ValidarServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String telefone = request.getParameter("telefone");
		String[] estudante = request.getParameterValues("estudante");
		String cartao = request.getParameter("cartao");
		String confirmacao = request.getParameter("confirmacao");
		String[] cursos = request.getParameterValues("cursos");

		if (cartao != confirmacao) {
			String mensagem = "Números de cartão não coincidem";

			request.setAttribute("mensagem", mensagem);

			request.setAttribute("nome", nome);
			request.setAttribute("email", email);
			request.setAttribute("telefone", telefone);
			request.getRequestDispatcher("index.jsp").forward(request, response);

		}

		System.out.println(nome + " " + email + " " + telefone + " " + estudante + " " + cartao + " " + confirmacao
				+ " " + cursos);

	}

}
