package dao;

import java.util.List;

import entity.Tau;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class TauDao {
	  private EntityManager em;

	    public TauDao(EntityManagerFactory emf) {
	        em = emf.createEntityManager();
	    }
//	    lấy Tàu bằng mã
	    public Tau getTauByMa(String ma) {
	    	return em.find(Tau.class, ma);
	    }
//	    lấy toàn bộ danh sách tàu
	    public List<Tau> getAllTau(){
	    	return em.createNamedQuery("Tau.findAll", Tau.class).getResultList();
	    }
	    
}
