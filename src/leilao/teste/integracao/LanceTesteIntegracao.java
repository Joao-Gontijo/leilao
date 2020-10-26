package leilao.teste.integracao;

import static org.junit.Assert.assertEquals;

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
		em.persist(new Lance(150, new Participante("TesteLance3", "67890", new Date("2004/04/14"))));
		em.getTransaction().commit();
		em.close();
		
	}
}