package dao;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import entity.HoaDon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;

public class HoaDonDao {
	private EntityManager em;

	public HoaDonDao(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}

//  Thêm Hóa Đơn

	public boolean addHoaDon(HoaDon hoaDon) {
	    EntityTransaction tx = em.getTransaction();
	    try {
	        // Làm tròn phần nano giây của gioTao về 0
	        if (hoaDon.getGioTao() != null) {
	            LocalTime adjustedTime = hoaDon.getGioTao().withNano(0); // Đặt phần nano giây về 0
	            hoaDon.setGioTao(adjustedTime);
	        }
	        
	        tx.begin();
	        em.persist(hoaDon);
	        tx.commit();
	        return true;
	    } catch (Exception e) {
	        tx.rollback();
	        e.printStackTrace();
	    }
	    return false;
	}

	public boolean updateHoaDon(HoaDon hoaDon) {
	    EntityTransaction tx = em.getTransaction();
	    try {
	        // Làm tròn phần nano giây của gioTao về 0
	        if (hoaDon.getGioTao() != null) {
	            LocalTime adjustedTime = hoaDon.getGioTao().withNano(0); // Đặt phần nano giây về 0
	            hoaDon.setGioTao(adjustedTime);
	        }

	        tx.begin();
	        em.merge(hoaDon);
	        tx.commit();
	        return true;
	    } catch (Exception e) {
	        tx.rollback();
	        e.printStackTrace();
	    }
	    return false;
	}


//  lấy Hoa Don bằng mã
	public HoaDon getHoaDonByMa(String ma) {
		return em.find(HoaDon.class, ma);
	}
	public List<HoaDon> getHoaDonHopLeTheoThang(int nam, int thang) {
	    return em.createQuery(
	        "SELECT h FROM HoaDon h WHERE h.trangThai = true AND YEAR(h.ngayTao) = :nam AND MONTH(h.ngayTao) = :thang", HoaDon.class)
	        .setParameter("nam", nam)
	        .setParameter("thang", thang)
	        .getResultList();
	}

//lấy toàn bộ danh sách HoaDon
	public List<HoaDon> getAllHoaDon() {
		return em.createNamedQuery("HoaDon.findAll", HoaDon.class).getResultList();
	}
	
	public List<HoaDon> getAllHoaDonTrue(){
		return em.createQuery("SELECT hd FROM HoaDon hd WHERE hd.trangThai = true", HoaDon.class).getResultList();
	}
	

	public List<HoaDon> layHoaDonTam() {
		LocalDate ngayHienTai = LocalDate.now();
		return em.createQuery("SELECT hd FROM HoaDon hd join hd.listVes ve WHERE hd.trangThai = false AND hd.ngayTao = :ngayTao AND ve.trangThai = true",
				HoaDon.class).setParameter("ngayTao", ngayHienTai).getResultList();
	}
	
	public boolean capNhatHDTheoTrangThai(HoaDon hd, boolean trangThai) {
		try {
			em.getTransaction().begin();
			em.createQuery("UPDATE HoaDon hd SET hd.trangThai = :trangThai WHERE hd.maHoaDon = :ma")
			.setParameter("trangThai", trangThai)
			.setParameter("ma", hd.getMaHoaDon())
			.executeUpdate();
			em.getTransaction().commit();
			return true;
		}catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	public List<HoaDon> layHoaDonThuocMa(String ma) {
		return em.createQuery("SELECT hd FROM HoaDon hd WHERE hd.maHoaDon like :ma", HoaDon.class)
				.setParameter("ma", "%" + ma + "%").getResultList();
	}

	public List<HoaDon> layHoaDonTamBangSdt(String sdt) {
		LocalDate ngayHienTai = LocalDate.now();
		return em.createQuery("SELECT hd FROM HoaDon hd WHERE hd.trangThai = false AND hd.ngayTao = :ngayTao AND hd.khachHang.sdt = :sdt",
				HoaDon.class).setParameter("ngayTao", ngayHienTai).setParameter("sdt", sdt).getResultList();
	}
	
	public List<HoaDon> layHoaDonTamBangCccd(String cccd){
		LocalDate ngayHienTai = LocalDate.now();
		return em.createQuery("SELECT hd FROM HoaDon hd WHERE hd.trangThai = false AND hd.ngayTao = :ngayTao AND hd.khachHang.cccd = :cccd",
				HoaDon.class).setParameter("ngayTao", ngayHienTai).setParameter("cccd", cccd).getResultList();
	}
	
	public Object layTongHoaDonTrongThang(int nam, int thang, int ngay) {
	try {
		return em.createNamedQuery("HoaDon.TongHoaDonTrueNgayTheoThang").setParameter("nam", nam).setParameter("thang", thang)
				.setParameter("ngay", ngay).getSingleResult();
		} catch (NoResultException e) {
			return 0;
		}
	}

	public Object layTongHoaDonTraTrongThang(int nam, int thang, int ngay) {
		try {
			return em.createNamedQuery("HoaDon.TongHoaDonFalseNgayTheoThang").setParameter("nam", nam).setParameter("thang", thang)
				.setParameter("ngay", ngay).getSingleResult();
			} catch (NoResultException e) {
				return 0;
			}
		}
}
