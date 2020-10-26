package leilao.teste.integracao;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Test;

import leilao.entidade.Participante;
import leilao.jpa.util.JPAUtil;

public class ParticipanteTesteIntegracao {

	@SuppressWarnings("deprecation")
	@Test
	public void deveAdicionarParticipanteNoBanco() {
		new JPAUtil();
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(new Participante("Fantasma2", "04034403", new Date("2000/07/17")));
		em.getTransaction().commit();
		em.close();
	}
}
