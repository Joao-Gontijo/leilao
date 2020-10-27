package leilao.controlador;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import leilao.entidade.Leilao;
import leilao.services.LeilaoDAO;
import leilao.util.Utilitario;

@WebServlet(urlPatterns = "/leilao")
public class LeilaoServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Utilitario util = new Utilitario();
		
		LeilaoDAO ldao = new LeilaoDAO();
		Leilao leilao = new Leilao();

		String descricao = req.getParameter("input-descricao");
		String valorInicial = req.getParameter("input-valor-inicial");
		String data = req.getParameter("input-data-criacao");
		String situacao = req.getParameter("situacao");

		String id = null;
		id = req.getParameter("id");

		
		System.out.println("ID: "+id);
		if(util.isNumeric(id)) {
			leilao.setId(Long.parseLong(id));
		}
		
		Date dataCriacao = null;
		try {
			dataCriacao = dataParaSalvar(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		leilao.setDescricao(descricao);
		leilao.setDataCriacao(dataCriacao);
		leilao.setValorInicial(Double.parseDouble(valorInicial));
		leilao.setSituacao(situacao);

		ldao.salvar(leilao);
		resp.sendRedirect("leilao.html");

	}

	public Date dataParaSalvar(String dataCriacao) throws ParseException {
		String data = dataCriacao.replaceAll("-", "/");
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		java.util.Date dataConvertida = simpleDateFormat.parse(data);
		java.sql.Date dataParaArmazenar = new java.sql.Date(dataConvertida.getTime());
		return dataParaArmazenar;
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		LeilaoDAO ldao = new LeilaoDAO();
		Gson gson = new Gson();

		String descricao = req.getParameter("descricao");
		if (descricao == null) {
			resp.setContentType("aplication/json");
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().write(gson.toJson(ldao.lista()));
		} else {
			String operacao = req.getParameter("operacao");
			if (operacao != null && operacao.equals("Excluir")) {
				Leilao leilao = new Leilao();
				List<Leilao> listaLeilao = ldao.lista();

				for (Leilao l : listaLeilao) {
					if (l.getDescricao().equals(descricao)) {
						leilao = l;
					}
				}
				ldao.deleta(leilao);
				resp.sendRedirect("leilao.html");
			} else {

				if (req.getParameter("origem") != null && req.getParameter("origem").equals("cadastro-leilao")) {
					Leilao leilao = new Leilao();
					List<Leilao> listaLeilao = ldao.lista();

					for (Leilao l : listaLeilao) {
						if (l.getDescricao().equals(descricao)) {
							leilao = l;
						}
					}
					String jsonLeilao = gson.toJson(leilao);
					resp.setContentType("aplication/json");
					resp.getWriter().print(jsonLeilao.toString());
				} else {
					resp.sendRedirect("cadastro-leilao.html?descricao=" + req.getParameter("descricao"));
				}
			}
		}
	}
}