package leilao.controlador;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import leilao.entidade.Lance;
import leilao.entidade.Participante;
import leilao.services.LanceDAO;

@WebServlet(urlPatterns = "/lances")
public class LanceServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		LanceDAO lanceDAO = new LanceDAO();
		
		Gson gson = new Gson();
		JsonElement json = gson.toJsonTree(lanceDAO.lista());
		
		resp.setContentType("application/json");
		resp.getWriter().print(json.toString());
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		Participante participante = new Participante();
//		
//		String cpf = req.getParameter("cbx-nome");
//		String valor = req.getParameter("input-valor");
//		
//		System.out.println(cpf);
//		System.out.println(valor);
//	
//		double valor2 = Double.parseDouble(valor);
//		Lance lance = new Lance();
//		lance.setValor(valor2);
//		lance.setParticipante(participante.setCpf(cpf));
//		LanceDAO dao = new LanceDAO();
//		
//		dao.salva(lance);
//		
//		resp.sendRedirect("home");
	}
}
