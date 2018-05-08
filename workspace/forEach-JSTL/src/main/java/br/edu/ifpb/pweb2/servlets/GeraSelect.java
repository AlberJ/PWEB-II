package br.edu.ifpb.pweb2.servlets;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/geraSelect")
public class GeraSelect extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();

		if (session.getAttribute("opcoes") != null) {
			ArrayList<String> itens = (ArrayList) session.getAttribute("opcoes");
			itens.add(request.getParameter("novo_item"));
			session.setAttribute("opcoes", itens);
		} else {
			ArrayList<String> itens = new ArrayList<String>();
			itens.add(request.getParameter("novo_item"));
			session.setAttribute("opcoes", itens);
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
