package br.edu.ifpb.pweb2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/debug")
public class DebugServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Enumeration<String> nomes = request.getParameterNames();
		PrintWriter out = response.getWriter();

		while (nomes.hasMoreElements()) {
			String nome = (String) nomes.nextElement();
			out.println("<br/>" + nome + " = " + request.getParameter(nome));
		}
		out.println("<br><br>Método HTTP usado na requisição :" + request.getMethod());

		Enumeration<String> nomes_header = request.getHeaderNames();
		while (nomes_header.hasMoreElements()) {
			String nome_header = (String) nomes_header.nextElement();
			out.println("<br/>" + nome_header + " = " + request.getHeader(nome_header));
		}
	}
}
