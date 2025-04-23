package dao;

import java.util.List;

import entity.ChoNgoi;
import entity.Toa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class ToaDao {
	 private EntityManager em;

	    public ToaDao(EntityManagerFactory emf) {
	        em = emf.createEntityManager();
	    }
//	    lấy toa bằng mã
	    public Toa getToaByMa(String ma) {
	    	return em.find(Toa.class, ma);
	    }
//	    lấy toàn bộ danh sách toa
	    public List<Toa> getAllToa(){
	    	return em.createNamedQuery("Toa.findAll", Toa.class).getResultList();
	    }
//	    lấy toa bằng mã tàu
	    public List<Toa> getAllToaByMaChuyen(String maTau){
	    	String jpql = "SELECT t"
	    			+ " FROM Toa t"
	    			+ " WHERE t.maToa IN("
	    			+ " SELECT cn.toa.maToa FROM Tau tau"
	    			+ " JOIN tau.lisChoNgois cn "
	    			+ " WHERE tau.maTau = :maTau GROUP BY cn.toa.maToa)"
	    			+ " ORDER BY t.viTri";
	    	List<Toa> result = em.createQuery(jpql, Toa.class)
	    			.setParameter("maTau", maTau)
	    			.getResultList();
	    	return result;
	    }
	    
	    public Toa layToaCoChoNgoiTrong(int id1, int id2,String maChuyen, boolean trangThai){
	    	String jpql ="SELECT TOP 1 t FROM Toa t WHERE t.maToa IN (" 
	    			+"SELECT c.toa.maToa FROM ChoNgoi c " +
	                  "WHERE c.maChoNgoi NOT IN (" +
	                  "    SELECT v.choNgoi.maChoNgoi " +
	                  "    FROM Ve v " +
	                  "    JOIN v.lisChiTietVes ctv " +
	                  "    WHERE v.chuyen.maChuyen = :maChuyen AND ve.trangThai = :trangThai " +
	                  "    GROUP BY v.choNgoi.maChoNgoi " +
	                  "    HAVING " +
	                  "    MAX(CASE WHEN ctv.chieu = true THEN ctv.ga.id END) = :id1Param " +
	                  "    OR " +
	                  "    (MAX(CASE WHEN ctv.chieu = true THEN ctv.ga.id END)" + (id1 < id2 ? " < ":" > ") + ":id1Param " + 
	                  "    AND MAX(CASE WHEN ctv.chieu = false THEN ctv.ga.id END)"+ (id1 < id2 ? " > ": " < ")+":id1Param) " +
	                  "    OR " +
	                  "    (MAX(CASE WHEN ctv.chieu = true THEN ctv.ga.id END)"+ (id1 < id2 ? " < " : " > ")+":id2Param " +
	                  "    AND MAX(CASE WHEN ctv.chieu = false THEN ctv.ga.id END)"+ (id1 < id2 ? " > " : " < ")+":id2Param) " +
	                  "    OR " +
	                  "    (MAX(CASE WHEN ctv.chieu = true THEN ctv.ga.id END)"+ (id1 < id2 ? " > " : " < ")+":id1Param " +
	                  "    AND MAX(CASE WHEN ctv.chieu = false THEN ctv.ga.id END)"+ (id1 < id2 ? " < ": " > ") +":id2Param)" +
	                  "))"+" ORDER BY t.viTri";
	    	try {
	    	Toa results = em.createQuery(jpql, Toa.class)
	            .setParameter("maChuyen", maChuyen)
	            .setParameter("trangThai", trangThai)
	            .setParameter("id1Param", id1)
	            .setParameter("id2Param", id2)
	            .getSingleResult();
	    	return results;
	    	}
	    	catch (Exception e) {
				return null;
			}
	    }
}
