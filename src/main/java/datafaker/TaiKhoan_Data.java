package datafaker;

import entity.NhanVien;
import entity.TaiKhoan;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

public class TaiKhoan_Data {
    public static void main(String[] args) {
        Random random = new Random();
        EntityManager em = Persistence.createEntityManagerFactory("theroyal")
                .createEntityManager();

        EntityTransaction tr = em.getTransaction();
        Faker faker = new Faker();
        for (int i = 1; i < 10; i++) {
            TaiKhoan taiKhoan = new TaiKhoan();
            String matk = "TK" + i ;
            String matkhau = faker.internet().password();
            String[] loai = {"Quan ly", "Nhan vien"} ;

            taiKhoan.setMaTK(matk);
            taiKhoan.setMatKhau(matkhau);
            taiKhoan.setLoaiTaiKhoan(loai[random.nextInt(loai.length)]);

            tr.begin();
            em.persist(taiKhoan);
            tr.commit();

        }

        for (int i = 1; i < 10; i++) {
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMaNV("NV" + i);
            nhanVien.setTenNV(faker.name().fullName());
            nhanVien.setGioiTinh(random.nextBoolean());
            nhanVien.setCCCD(faker.idNumber().valid());
            nhanVien.setNgaySinh(convertToLocalDate(faker.date().birthday(20, 60)));
            nhanVien.setSDT(faker.phoneNumber().cellPhone());
            nhanVien.setEmail(faker.internet().emailAddress());
            nhanVien.setNgayVaoLam(LocalDate.now().minusDays(random.nextInt(1000)));
            nhanVien.setChucVu(random.nextBoolean() ? "Nhân viên" : "Quản lý");
            nhanVien.setTrangThai(random.nextBoolean() ? "Đang làm" : "Đã nghỉ");

            // Link with TaiKhoan
            String taiKhoanId = "SD" + i;
            TaiKhoan taiKhoan = em.find(TaiKhoan.class, taiKhoanId);
            nhanVien.setTaiKhoan(taiKhoan);

            tr.begin();
            em.persist(nhanVien);
            tr.commit();
        }


    }
    private static LocalDate convertToLocalDate(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
