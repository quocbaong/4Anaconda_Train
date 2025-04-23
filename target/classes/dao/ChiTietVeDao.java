package dao;

import entity.ChiTietVe;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class ChiTietVeDao {
	private EntityManager em;

    public ChiTietVeDao(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }
    
    public boolean addChiTietVe(ChiTietVe ctv) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(ctv);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}
}
