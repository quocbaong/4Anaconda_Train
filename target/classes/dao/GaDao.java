package dao;

import java.util.List;

import entity.Ga;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class GaDao {
	private EntityManager em;

	public GaDao(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}

//  lấy toàn bộ danh sách Ga
	public List<Ga> getAllGa() {
		return em.createQuery("SELECT g FROM Ga g", Ga.class).getResultList();
	}

//  lấy Vé bằng tên
	public Ga getGaByTen(String ten) {
		try {
			return em.createQuery("SELECT g FROM Ga g WHERE g.tenGa = :tenGa",Ga.class).setParameter("tenGa", ten).getSingleResult();			
		}
		catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	}
	public Ga layGaDau() {
		return em.createQuery("SELECT g FROM Ga g WHERE g.id = :id",Ga.class).setParameter("id", 1).getSingleResult();
	}
	public Ga layGaCuoi() {
		return em.createQuery("SELECT g FROM Ga g WHERE g.id = :id",Ga.class).setParameter("id", 20).getSingleResult();
	}

	
	
}
