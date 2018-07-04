package br.edu.ifpb.pweb2.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

@WebServlet("/cadastra")
public class CadastraLivrosServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Cria a fábrica de EntityManagers e uma EntityManager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("pratica5");
		EntityManager em = emf.createEntityManager();

		// Cria um livro a partir dos parâmetros do formulário
		String paramTitulo = request.getParameter("titulo");
		String paramAutor = request.getParameter("autor");
		String paramPublicado = request.getParameter("publicado");
		String paramPaginas = request.getParameter("paginas");

		Date dataVeio = null;

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			dataVeio = sdf.parse(paramPublicado);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Livro livro = new Livro(paramTitulo, paramAutor, dataVeio, Integer.parseInt(paramPaginas));
		em.getTransaction().begin();
		em.persist(livro);
		em.getTransaction().commit();

		Query query = (Query) em.createQuery("from Livro");
		List<Livro> livros = query.getResultList();

		em.close();
		request.setAttribute("livros", livros);
		request.getRequestDispatcher("livros.jsp").forward(request, response);
	}
}