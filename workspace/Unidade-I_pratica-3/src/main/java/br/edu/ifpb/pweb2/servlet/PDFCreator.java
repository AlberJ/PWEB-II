package br.edu.ifpb.pweb2.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.itextpdf.text.Chapter;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

@WebServlet("/create")
public class PDFCreator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("application/pdf");

		String nome = request.getParameter("nome");
		String login = request.getParameter("login");
		String tipo = request.getParameter("tipo");
		String data = request.getParameter("data");
		String status = request.getParameter("status");
		String[] nivel = request.getParameterValues("nivel");

		String niveis = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dataVai = "";
		
		
		try {
			Date dataVeio = sdf.parse(data);
			sdf.applyPattern("dd/MM/yyyy");
			dataVai = sdf.format(dataVeio);
			
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		for (String string : nivel) {
			niveis = niveis + ", " + string;

		}

		if (status != "ativo")
			status = "inativo";

		try {
			Document document = new Document();

			PdfWriter.getInstance(document, response.getOutputStream());
			document.open();
			Font chapterFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLDITALIC);
			Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);

			Chunk chunk = new Chunk("Dados informados :", chapterFont);
			Chapter chapter = new Chapter(new Paragraph(chunk), 1);
			chapter.setNumberDepth(0);
			chapter.add(new Paragraph("Nome :" + nome, paragraphFont));
			chapter.add(new Paragraph("login :" + login, paragraphFont));
			chapter.add(new Paragraph("Tipo :" + tipo, paragraphFont));
			chapter.add(new Paragraph("Data :" + dataVai, paragraphFont));
			chapter.add(new Paragraph("Status :" + status, paragraphFont));
			chapter.add(new Paragraph("Nível :" + niveis, paragraphFont));

			document.add(chapter);
			document.close();
		} catch (DocumentException e) {
			response.sendError(404, "PDF não gerado.");
		}
	}
}
