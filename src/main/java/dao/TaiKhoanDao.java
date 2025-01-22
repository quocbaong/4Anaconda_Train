package dao;

import java.util.List;

import entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

public class TaiKhoanDao {

    private EntityManager em;

    public TaiKhoanDao(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }

//    Them tai khoan
    public boolean addTaiKhoan(TaiKhoan taiKhoan) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(taiKhoan);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

////    UpDateTaiKhoan
//    public boolean updateTaiKhoan(TaiKhoan taiKhoan) {
//        EntityTransaction tx = em.getTransaction();
//        try {
//            tx.begin();
//            em.merge(taiKhoan);
//            tx.commit();
//            return true;
//        } catch (Exception e) {
//            tx.rollback();
//            e.printStackTrace();
//        }
//        return false;
//    }
    public boolean updateTaiKhoan(TaiKhoan taiKhoan) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(taiKhoan);  // Cập nhật thông tin tài khoản vào cơ sở dữ liệu
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    
    public TaiKhoan getTaiKhoanByUserName(String userName) {
        return em.find(TaiKhoan.class, userName);
    	
    }

    public List<TaiKhoan> getAllTaiKhoan() {
        return em.createNamedQuery("TaiKhoan.findAll", TaiKhoan.class).getResultList();
    }
}
