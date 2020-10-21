package leilao.teste;

import java.util.Date;

import javax.persistence.EntityManager;

import org.junit.Test;

import leilao.entidade.Lance;
import leilao.entidade.Participante;
import leilao.jpa.util.JPAUtil;

public class LanceTesteIntegracao {
	
	@SuppressWarnings("deprecation")
	@Test 
	public void deveAdicionarLance() {
		new JPAUtil();
		EntityManager em = JPAUtil.getEntityManager();
		em.getTransaction().begin();
		em.persist(new Lance(80.0, new Participante("TesteLance1", "212342134", new Date("2000/07/17"))));
		em.getTransaction().commit();
		em.close();
	}
}