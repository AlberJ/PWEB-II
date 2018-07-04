package br.edu.ifpb.pweb2.servlet;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.pweb2.entidade.Livro;

@WebServlet("/consulta")
public class ListaLivrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)

			throws ServletException, IOException {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pratica5");
		EntityManager em = emf.createEntityManager();

		Query query = (Query) em.createQuery("from Livro");
		List<Livro> livros = query.getResultList();

		em.close();
		request.setAttribute("livros", livros);
		request.getRequestDispatcher("livros.jsp").forward(request, response);
	}
}
