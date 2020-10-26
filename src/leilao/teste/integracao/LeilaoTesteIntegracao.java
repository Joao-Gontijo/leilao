package leilao.teste.integracao;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Test;

import leilao.entidade.Lance;
import leilao.entidade.Leilao;
import leilao.entidade.Participante;
import leilao.jpa.util.JPAUtil;

public class LeilaoTesteIntegracao {

	@SuppressWarnings("deprecation")
	@Test
	public void deveAdicionarLeilao() {
		new JPAUtil();
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
//		em.persist(new Leilao(new Lance(80.0, new Participante("TesteLance1", "123", new Date("2000/07/17"))),
//				"Teste 1", new Date("2020/10/19")));
		em.getTransaction().commit();
		em.close();
	}
}
