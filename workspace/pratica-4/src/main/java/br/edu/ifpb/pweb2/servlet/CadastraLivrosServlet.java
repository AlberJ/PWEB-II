package br.edu.ifpb.pweb2.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.ifpb.pweb2.entidade.Livro;

@WebServlet("/cadastra")
public class CadastraLivrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Cria a fábrica de EntityManagers e uma EntityManager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pratica4");
		EntityManager em = emf.createEntityManager();

		// Cria um livro a partir dos parâmetros do formulário
		String paramTitulo = request.getParameter("titulo");
		String paramAutor = request.getParameter("autor");
		String paramPublicado = request.getParameter("publicado");
		String paramPaginas = request.getParameter("paginas");

		SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yyyy");
		Date dataPublicado = null;

		try {
			dataPublicado = sdf.parse(paramPublicado);
		} catch (ParseException e) {
			response.sendError(404, "Parametro \'publicado\' não é uma data.");
			return;
			// cai fora do servlet!
		}
		Livro livro = new Livro(paramTitulo, paramAutor, dataPublicado, Integer.parseInt(paramPaginas));
		// Salva no banco de dados
		em.getTransaction().begin();
		em.persist(livro);
		em.getTransaction().commit();
		em.close();

		// Encaminha a requisição para o JSP que vai exibir a lista de livros

		request.getRequestDispatcher("livros.jsp").forward(request, response);
	}
}
