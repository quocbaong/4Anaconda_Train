package datafaker;

import entity.NhanVien;
import entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

import java.util.List;
import java.util.Random;

public class TaiKhoan_Data {
    public static void main(String[] args) {
        // Tạo đối tượng EntityManager và Transaction
        EntityManager em = Persistence.createEntityManagerFactory("SourceMSSQL")
                .createEntityManager();
        EntityTransaction tr = em.getTransaction();

        // Tạo đối tượng hỗ trợ dữ liệu giả
        Faker faker = new Faker();
        Random random = new Random();

        try {
            // Lấy danh sách các nhân viên đã có trong cơ sở dữ liệu
            List<NhanVien> nhanVienList = em.createQuery("SELECT nv FROM NhanVien nv", NhanVien.class)
                    .getResultList();

            // Kiểm tra nếu không có nhân viên nào
            if (nhanVienList.isEmpty()) {
                System.out.println("Không có nhân viên nào trong cơ sở dữ liệu để tạo tài khoản.");
                return;
            }

            for (int i = 0; i < nhanVienList.size(); i++) {
                NhanVien nhanVien = nhanVienList.get(i);

                // Kiểm tra nếu nhân viên đã có tài khoản
                TaiKhoan existingAccount = em.find(TaiKhoan.class, nhanVien.getMaNhanVien());
                if (existingAccount != null) {
                    System.out.println("Nhân viên " + nhanVien.getHoTen() + " đã có tài khoản. Bỏ qua.");
                    continue;
                }

                // Tạo tài khoản mới
                TaiKhoan taiKhoan = new TaiKhoan();
                taiKhoan.setTenTaiKhoan("user" + (i + 1));
                taiKhoan.setMatKhau(faker.internet().password());
                taiKhoan.setNhanVien(nhanVien);

                // Bắt đầu giao dịch
                tr.begin();
                em.persist(taiKhoan);
                tr.commit();

                System.out.println("Đã thêm tài khoản: " + taiKhoan);
            }
        } catch (Exception e) {
            if (tr.isActive()) {
                tr.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
