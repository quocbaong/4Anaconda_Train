package dao;

import entity.Tuyen;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class TuyenDao {
    private EntityManager em;

    public TuyenDao(EntityManagerFactory emf) {
        em = emf.createEntityManager();
    }

    // Lấy tuyến bằng mã
    public List<Tuyen> layTuyenBangMa(String ma) {
        return em.createQuery("SELECT t FROM Tuyen t WHERE t.maTuyen LIKE :ma", Tuyen.class)
                .setParameter("ma", "%" + ma + "%")
                .getResultList();
    }

    // Lấy toàn bộ danh sách tuyến
    public List<Tuyen> getAllTuyen() {
        return em.createNamedQuery("Tuyen.findAll", Tuyen.class).getResultList();
    }

    // Lấy danh sách mã tuyến chưa có ga (dựa trên id ga)
    public List<String> layTuyenChuaGa(int id1, int id2) {
        return em.createQuery(
                        "SELECT t.maTuyen FROM Tuyen t JOIN t.listGas ctt WHERE ctt.id = :id1 OR ctt.id = :id2 GROUP BY t.maTuyen",
                        String.class)
                .setParameter("id1", id1)
                .setParameter("id2", id2)
                .getResultList();
    }

    // Thêm tuyến
    public boolean addTuyen(Tuyen tuyen) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(tuyen);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật tuyến
    public boolean updateTuyen(Tuyen tuyen) {
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(tuyen);
            tx.commit();
            return true;
        } catch (Exception e) {
            tx.rollback();
            e.printStackTrace();
            return false;
        }
    }

    // Lấy danh sách tuyến bằng mã (theo từ khóa gần đúng)
    public List<Tuyen> getAllTuyenByMa(String maTuyen) {
        return em.createNamedQuery("Tuyen.findAllByMa", Tuyen.class)
                .setParameter("ma", "%" + maTuyen + "%")
                .getResultList();
    }

    // Lấy danh sách tuyến theo trạng thái và loại user
    public List<Tuyen> getTuyenByTrangThaiForUser(boolean trangThai) {
        TypedQuery<Tuyen> query = em.createNamedQuery("Tuyen.findByTrangThaiForUser", Tuyen.class)
                .setParameter("trangThai", trangThai)
                .setParameter("loai", "User");
        return query.getResultList();
    }

    // Ghi dữ liệu danh sách tuyến ra file Excel
    public void writeToExcel(String filePath) {
        String[] rowHead = { "Mã tuyến", "Tên tuyến", "Điểm đi", "Điểm đến", "Thời gian khởi hành", "Thời gian đến dự kiến", "Giá vé cơ bản", "Trạng thái" };

        List<Tuyen> tuyenList = getAllTuyen();

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadSheet = workbook.createSheet("Tuyến");

        // Tạo tiêu đề bảng
        Row titleRow = spreadSheet.createRow(0);
        Cell titleCell = titleRow.createCell(0);
        titleCell.setCellValue("DANH SÁCH TUYẾN");
        spreadSheet.addMergedRegion(new CellRangeAddress(0, 0, 0, rowHead.length - 1));

        XSSFCellStyle titleStyle = workbook.createCellStyle();
        XSSFFont titleFont = workbook.createFont();
        titleFont.setFontHeightInPoints((short) 20);
        titleFont.setColor(IndexedColors.RED.getIndex());
        titleFont.setBold(true);
        titleStyle.setFont(titleFont);
        titleStyle.setAlignment(HorizontalAlignment.CENTER);

        titleCell.setCellStyle(titleStyle);

        // Tạo hàng header
        Row headerRow = spreadSheet.createRow(1);
        XSSFCellStyle headerStyle = workbook.createCellStyle();
        XSSFFont headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerStyle.setFont(headerFont);

        // Tạo header
        for (int i = 0; i < rowHead.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(rowHead[i]);
            cell.setCellStyle(headerStyle);
        }

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // Tạo dữ liệu
        for (int i = 0; i < tuyenList.size(); i++) {
            Row dataRow = spreadSheet.createRow(i + 2);

            Tuyen tuyen = tuyenList.get(i);
            dataRow.createCell(0).setCellValue(tuyen.getMaTuyen());
            dataRow.createCell(1).setCellValue(tuyen.getTenTuyen());
            dataRow.createCell(2).setCellValue(tuyen.getDiemDi());
            dataRow.createCell(3).setCellValue(tuyen.getDiemDen());
            dataRow.createCell(4).setCellValue(tuyen.getThoiGianKhoiHanh());
            dataRow.createCell(5).setCellValue(tuyen.getThoiGianDenDuKien());
            dataRow.createCell(6).setCellValue(tuyen.getGiaVeCoBan());
            dataRow.createCell(7).setCellValue(tuyen.isTrangThai() ? "Đang hoạt động" : "Tạm ngừng");
        }

        // Ghi dữ liệu ra file Excel
        try (FileOutputStream outputStream = new FileOutputStream(new File(filePath))) {
            workbook.write(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                workbook.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Ghi dữ liệu ra file Excel thành công: " + filePath);
    }
}
