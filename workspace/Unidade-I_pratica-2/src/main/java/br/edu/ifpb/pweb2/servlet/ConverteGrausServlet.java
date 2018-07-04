package br.edu.ifpb.pweb2.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/converte")
public class ConverteGrausServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	int temperatura_convertida;
	String escala_informada;
	String escala_desejada;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		int temperatura = Integer.parseInt(request.getParameter("temperatura"));
		String tipo = request.getParameter("tp");

		switch (tipo) {
		case "c": {
			temperatura_convertida = (temperatura - 32) * 5 / 9;
			escala_informada = "Celsius";
			escala_desejada = "Fahrenheit";
		}
		case "f": {
			temperatura_convertida = (int) (temperatura * 1.8 + 32);
			escala_informada = "Fahrenheit";
			escala_desejada = "Celsius";
		}

		default:
			break;
		}
		out.println("<br><br><h2>A temperatura informada foi " + temperatura + "° " + escala_informada
				+ ", que convertida para " + escala_desejada + " equivale a " + temperatura_convertida + "°</h2>");
	}
}
