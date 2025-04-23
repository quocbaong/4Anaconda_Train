package dao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import entity.Ve;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

public class VeDao {
	private EntityManager em;

	public VeDao(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}

	// Thêm Vé
	public boolean themVe(Ve ve) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(ve);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean capNhatVe(Ve ve) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(ve);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

	// lấy danh sách vé
	public List<Ve> layDSVe() {
		return em.createNamedQuery("Ve.findAll", Ve.class).getResultList();
	}

	public List<Ve> layDSVeBangMaHD(String mahd) {
		return em.createNamedQuery("Ve.FindByMaHd", Ve.class).setParameter("mhd", mahd).getResultList();
	}

	public List<Ve> layDSVeBangMaVe(String mv) {
		return em.createNamedQuery("Ve.FindByMaVe", Ve.class).setParameter("mv", mv).getResultList();
	}

//	    lấy Vé bằng mã
	public Ve layVeBangMa(String ma) {
		return em.find(Ve.class, ma);
	}
	
	public List<Ve> layDSVeTamHetNgay() {
		LocalDate ngayHienTai = LocalDate.now();
		return em.createQuery("SELECT ve FROM Ve ve WHERE ve.trangThai = true AND ve.hoaDon.trangThai = false AND ve.hoaDon.ngayTao != :ngayHT", Ve.class).setParameter("ngayHT", ngayHienTai).getResultList();
	}

	public boolean capNhatTrangThaiVeTamHetNgay(Ve ve) {
		try {
			em.getTransaction().begin();
			em.createQuery(
					"UPDATE Ve ve SET ve.trangThai = false WHERE ve.maVe = :maVe")
					.setParameter("maVe", ve.getMaVe())
					.executeUpdate();
			em.getTransaction().commit();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			em.getTransaction().rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateDoiVe(String maVe, LocalDateTime localDateTime) {
		EntityTransaction transaction = null;
		try {
			transaction = em.getTransaction();
			transaction.begin();

			em.createNamedQuery("Ve.updateDoiTra").setParameter("newThoiGianLenTau", localDateTime)
					.setParameter("newTrangThai", false).setParameter("maVe", maVe).executeUpdate();

			transaction.commit();
			return true;
		} catch (Exception e) {
			if (transaction != null && transaction.isActive()) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return false;
	}

	public List<Ve> layVeThuocMa(String ma) {
		return em.createQuery("SELECT v FROM Ve v WHERE v.maVe like :maVe", Ve.class)
				.setParameter("maVe", "%" + ma + "%").getResultList();
	}

	public Object layTongVeTrongNgay(int nam, int thang, int ngay) {
		try {
			return em.createNamedQuery("Ve.TongVeNgayTheoThang").setParameter("nam", nam).setParameter("thang", thang)
					.setParameter("ngay", ngay).getSingleResult();
		} catch (NoResultException e) {
			// Xử lý nếu không có kết quả nào được trả về
			return 0;
		}
	}

	public long countDoiTuongByMonthYear(int month, int year, String doiTuong){
        long count = 0;

            // Sử dụng NamedQuery để lấy danh sách vé theo tháng và năm của ngayTao
            List<Ve> list = em.createNamedQuery("Ve.layVeTheoNgayTaoHoaDon").setParameter("month", month).setParameter("year", year).getResultList();
            // Đếm số lượng khách hàng có đối tượng là "Sinh viên"
            count = list.stream()
                          .filter(ve -> doiTuong.equals(ve.getKhachHang().getDoiTuong()))
                          .count();
        return count;
    }  
	
	public Object layTongVeHuyTrongThang(int nam, int thang, int ngay) {
		try {
			return em.createNamedQuery("Ve.TongVeHuyTrongThang").setParameter("nam", nam)
					.setParameter("thang", thang)
					.setParameter("ngay", ngay)
					.getSingleResult();
		} catch (NoResultException e) {
			// Xử lý nếu không có kết quả nào được trả về
			return 0;
		}
	}
}
