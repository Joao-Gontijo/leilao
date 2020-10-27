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
import leilao.entidade.Leilao;
import leilao.entidade.Participante;
import leilao.services.LanceDAO;
import leilao.services.LeilaoDAO;
import leilao.services.ParticipanteDAO;

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
		Participante participante = new Participante();
		ParticipanteDAO participanteDao = new ParticipanteDAO();
		
		Leilao leilao = new Leilao();
		LeilaoDAO leilaoDao = new LeilaoDAO();
		
		Lance lance = new Lance();
		LanceDAO lanceDao = new LanceDAO();
		
		String idLeilao = req.getParameter("cbx-leilao");
		String idParticipante = req.getParameter("cbx-nome");
		String valor = req.getParameter("input-valor");
		
		System.out.println(idParticipante);
		System.out.println(valor);
		System.out.println(idLeilao);
	
		leilao = leilaoDao.getLeilao(Long.parseLong(idLeilao));
		participante = participanteDao.get(idParticipante);
		
		
		
		leilaoDao.salvar(leilao);
		participanteDao.salva(participante);
		
		
		lance.setLeilao(leilao);
		lance.setParticipante(participante);
		lance.setValor(Double.parseDouble(valor));
		lanceDao.salva(lance);
		
		resp.sendRedirect("home");
		
	}
}
