package leilao.controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//import java.util.List;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
//import com.google.gson.JsonElement;

import leilao.entidade.Participante;
import leilao.services.ParticipanteDAO;

@WebServlet(urlPatterns = "/participantes")
public class ParticipanteServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nome = req.getParameter("input-nome");
		String cpf = req.getParameter("input-cpf");
		String data = req.getParameter("input-dataNascimento");
		
		Date dataNascimento = null;
		try {
			dataNascimento = dataParaSalvar(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		Participante participante = new Participante(nome, cpf, dataNascimento);
		ParticipanteDAO dao = new ParticipanteDAO();
		dao.salva(participante);
		
		resp.sendRedirect("participante.html");
	}
	
	public Date dataParaSalvar(String dataNascimento) throws ParseException {
		String data = dataNascimento.replaceAll("-","/");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date dataConvertida = simpleDateFormat.parse(data);
		java.sql.Date dataParaArmazenar = new java.sql.Date(dataConvertida.getTime());
		return dataParaArmazenar;
	}
	
	public String dataParaMostrar(Date data) {
		SimpleDateFormat simpleDate = new SimpleDateFormat("dd/MM/yyyy");
		String dataParaInterface = simpleDate.format(data);
		return dataParaInterface;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ParticipanteDAO participanteDAO = new ParticipanteDAO();
		
		Gson gson = new Gson();
		
		String cpf = req.getParameter("cpf");
		
		if(cpf == null){
			resp.setContentType("application/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(gson.toJson(participanteDAO.lista()));
			
		} else {
			String operacao = req.getParameter("operacao");
			
			if(operacao != null && operacao.equals("excluir")){
				participanteDAO.exclui(new Participante(cpf));
				resp.sendRedirect("participante.html");
			} else {
				if(req.getParameter("origem")!=null && req.getParameter("origem").equals("cadastro-participante")) {
					String jsonParticipante = gson.toJson(participanteDAO.get(cpf));
					resp.setContentType("application/json");
					resp.getWriter().print(jsonParticipante.toString());
				}else {
					resp.sendRedirect("cadastro-participante.html?cpf="+req.getParameter("cpf"));
				}
			}
		}
	}
}