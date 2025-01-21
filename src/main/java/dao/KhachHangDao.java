
package dao;

import entity.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
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

public class KhachHangDao {
    private EntityManager em;

    public KhachHangDao(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }

    // Update KhachHang
    public boolean updateKhachHang(KhachHang khachHang) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(khachHang);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    public boolean addKhachHang(KhachHang kh) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(kh);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
        }
        return false;
    }

    // Find KhachHang by Phone number
    public KhachHang getKhachHangByPhoneNumber(String sdt) {
        try {
            return em.createNamedQuery("KhachHang.findSdt", KhachHang.class).setParameter("sdt", sdt)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    //  Get list KhachHang
    public List<KhachHang> getAllKhachHang() {
        try {

            return em.createNamedQuery("KhachHang.findAll", KhachHang.class).getResultList();
        } catch (Exception e) {
            return null;
        }
    }
    public KhachHang getKhachHangByCCCD(String cccd) {
        try {
            return em.createNamedQuery("KhachHang.findCccd", KhachHang.class).setParameter("cccd", cccd)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public List<KhachHang> layKhachHangBanDoiTuong(String doiTuong){
        return em.createQuery("SELECT kh FROM KhachHang kh WHERE kh.doiTuong = :doiTuong", KhachHang.class).setParameter("doiTuong", doiTuong).getResultList();
    }

    public List<KhachHang> layKhachHangThuocMa(String ma){
        return em.createQuery("SELECT kh FROM KhachHang kh WHERE kh.cccd like :ma ORDER BY kh.cccd DESC", KhachHang.class).setParameter("ma","%"+ma+"%").getResultList();
    }

    public void writeToExcel(String filePath) {
        String[] rowHead = {"STT", "CCCD", "Họ và tên", "Số điện thoại", "Email", "Đối tượng"};

        List<KhachHang> khachHang = getAllKhachHang();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadSheet = workbook.createSheet("Khách hàng");

        Row titleRow = spreadSheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("DANH SÁCH KHÁCH HÀNG");
        spreadSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, rowHead.length - 1));

        // Creating a cell style with red color and font size 20
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
        //Creating header
        for (int i = 0; i < rowHead.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(rowHead[i]);
            cell.setCellStyle(headerStyle);
        }

        XSSFCellStyle sttStyle = workbook.createCellStyle();
        sttStyle.setAlignment(HorizontalAlignment.CENTER);
        //Creating data rows
        for (int i = 0; i < khachHang.size(); i++) {
            Row dataRow = spreadSheet.createRow(i+2);
            Cell sttCell = dataRow.createCell(0);
            sttCell.setCellValue(i + 1); // Setting STT value
            sttCell.setCellStyle(sttStyle);

            dataRow.createCell(1).setCellValue(khachHang.get(i).getCccd());
            dataRow.createCell(2).setCellValue(khachHang.get(i).getHoTen());
            dataRow.createCell(3).setCellValue(khachHang.get(i).getSdt());
            dataRow.createCell(4).setCellValue(khachHang.get(i).getEmail());
            dataRow.createCell(5).setCellValue(khachHang.get(i).getDoiTuong());
        }

        //Write the workbook in file
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

















