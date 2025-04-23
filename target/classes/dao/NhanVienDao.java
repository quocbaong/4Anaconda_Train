package dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class NhanVienDao {

	private EntityManager em;
	private String partialSDT;
	private Object loai;

	public NhanVienDao(EntityManagerFactory emf) {
		em = emf.createEntityManager();
	}

//    Thêm nhân viên
	public boolean addNhanVien(NhanVien nhanVien) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.persist(nhanVien);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

//    cập nhật nhân viên
	public boolean updateNhanVien(NhanVien nhanVien) {
		EntityTransaction tx = em.getTransaction();
		try {
			tx.begin();
			em.merge(nhanVien);
			tx.commit();
			return true;
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();
		}
		return false;
	}

//    lấy nhân viên bằng mã
	public NhanVien getNhanVienByMa(String ma) {
		return em.find(NhanVien.class, ma);
	}

//    lấy nhân viên bằng số điện thoại
	public NhanVien getNhanVienBySDT(String sdt) {
		try {
			return em.createNamedQuery("NhanVien.findSdt", NhanVien.class).setParameter("sdt", sdt).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

//    Lấy nhân viên bằng căn cước công dân
	public NhanVien getNhanVienByCCCD(String cccd) {
		try {
			return em.createNamedQuery("NhanVien.findCccd", NhanVien.class).setParameter("cccd", cccd)
					.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}

//    lấy toàn bộ danh sách nhân viên
	public List<NhanVien> getAllNhanVien() {
	    try {
	        return em.createNamedQuery("NhanVien.findAll", NhanVien.class).setParameter("loai", "User").getResultList();
	    } catch (Exception e) {
	        return null;
	    }
	}

	public List<NhanVien> getAllNhanVienByMa(String maloai) {
		return em.createNamedQuery("NhanVien.findAllByMa", NhanVien.class).setParameter("ma", "%" + maloai + "%")
				.getResultList();
	}

	public List<NhanVien> getNhanVienByPartialMaAndLoai(String partialMa, String loai) {
		TypedQuery<NhanVien> query = em.createQuery(
				"SELECT nv FROM NhanVien nv WHERE nv.maNhanVien LIKE :partialMa AND nv.loaiNV = :loai", NhanVien.class);
		query.setParameter("partialMa", "%" + partialMa + "%");
		query.setParameter("loai", loai);
		return query.getResultList();
	}

	public List<NhanVien> getNhanVienBySDTForUser(String partialSDT, String loai) {
		TypedQuery<NhanVien> query = em.createNamedQuery("NhanVien.findBySDTForUser", NhanVien.class);
		query.setParameter("partialSDT", "%" + partialSDT + "%");
		query.setParameter("loai", loai);
		return query.getResultList();
	}

	// Lấy danh sách nhân viên bằng trạng thái loại user
	public List<NhanVien> getNhanVienByTrangThaiForUser(boolean trangThai) {
		TypedQuery<NhanVien> query = em.createNamedQuery("NhanVien.findByTrangThaiForUser", NhanVien.class)
				.setParameter("trangThai", trangThai).setParameter("loai", "User");
		return query.getResultList();
	}

	public void writeToExcel(String filePath) {
		String[] rowHead = { "STT", "Mã nhân viên", "CCCD", "Họ và tên", "Ngày sinh", "Giới tính", "Địa chỉ", "Email",
				"Số điện thoại", "Trạng thái" };

		List<NhanVien> nhanVien = getAllNhanVien();

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet spreadSheet = workbook.createSheet("Nhân viên");

		Row titleRow = spreadSheet.createRow(0);
		Cell titleCell = titleRow.createCell(0);
		titleCell.setCellValue("DANH SÁCH NHÂN VIÊN");
		spreadSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, rowHead.length - 1));

		XSSFCellStyle titleStyle = workbook.createCellStyle();
		XSSFFont titleFont = workbook.createFont();
		titleFont.setFontHeightInPoints((short) 20);
		titleFont.setColor(IndexedColors.RED.getIndex());
		titleFont.setBold(true);
		titleStyle.setFont(titleFont);
		titleStyle.setAlignment(HorizontalAlignment.CENTER);

		titleCell.setCellStyle(titleStyle);

		Row headerRow = spreadSheet.createRow(1);
		XSSFCellStyle headerStyle = workbook.createCellStyle();
		XSSFFont headerFont = workbook.createFont();
		headerFont.setBold(true);
		headerStyle.setFont(headerFont);

		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		// Creating header
		for (int i = 0; i < rowHead.length; i++) {
			Cell cell = headerRow.createCell(i);
			cell.setCellValue(rowHead[i]);
			cell.setCellStyle(headerStyle);
		}

		XSSFCellStyle sttStyle = workbook.createCellStyle();
		sttStyle.setAlignment(HorizontalAlignment.CENTER);
		// Creating data rows
		for (int i = 0; i < nhanVien.size(); i++) {
			Row dataRow = spreadSheet.createRow(i + 2);
			Cell sttCell = dataRow.createCell(0);
			sttCell.setCellValue(i + 1); // Setting STT value
			sttCell.setCellStyle(sttStyle);

			dataRow.createCell(1).setCellValue(nhanVien.get(i).getMaNhanVien());
			dataRow.createCell(2).setCellValue(nhanVien.get(i).getCccd());
			dataRow.createCell(3).setCellValue(nhanVien.get(i).getHoTen());
			dataRow.createCell(4).setCellValue(nhanVien.get(i).getNgaySinh().format(dateFormatter));
			dataRow.createCell(5).setCellValue(nhanVien.get(i).isGioiTinh() ? "Nam" : "Nữ");
			dataRow.createCell(6).setCellValue(nhanVien.get(i).getDiaChi());
			dataRow.createCell(7).setCellValue(nhanVien.get(i).getEmail());
			dataRow.createCell(8).setCellValue(nhanVien.get(i).getSdt());
			dataRow.createCell(9).setCellValue(nhanVien.get(i).getTrangThai() ? "Đang làm" : "Nghỉ");
		}

		// Write the workbook in file
		FileOutputStream outputStream;
		try {
			outputStream = new FileOutputStream(new File(filePath));

			workbook.write(outputStream);
			outputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Write to excel done...");
	}

}
