package leilao.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import leilao.entidade.Lance;
import leilao.jpa.util.JPAUtil;

public class LanceDAO {
	private JPAUtil jpaUtil;
	private EntityManager em;
	
	public LanceDAO() {
		jpaUtil = new JPAUtil();
		em = jpaUtil.getEntityManager();
	}
	
	public void salva(Lance lance) {
		
	}
	
	public void exclui(Lance lance) {
		
	}
	
	public List<Lance> lista(){
		TypedQuery<Lance> qry = em.createQuery("from Lance", Lance.class);
		return qry.getResultList();
	}
}
