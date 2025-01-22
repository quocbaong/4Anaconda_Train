package datafaker;

import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

public class NhanVien_Data {
    public static void main(String[] args) {
        // Tạo đối tượng EntityManager và Transaction
        EntityManager em = Persistence.createEntityManagerFactory("theroyal")
                .createEntityManager();
        EntityTransaction tr = em.getTransaction();

        // Tạo các đối tượng hỗ trợ dữ liệu giả
        Faker faker = new Faker();
        Random random = new Random();

        try {
            for (int i = 1; i <= 10; i++) {
                NhanVien nhanVien = new NhanVien();
                String maNhanVien = "NV" + i;
                String hoTen = faker.name().fullName();
                String cccd = faker.number().digits(12);
                String sdt = faker.phoneNumber().phoneNumber();
                String email = faker.internet().emailAddress();
                boolean gioiTinh = random.nextBoolean();
                String diaChi = faker.address().fullAddress();
                String loaiNV = random.nextBoolean() ? "Quản lý" : "Nhân viên";
                boolean trangThai = random.nextBoolean();

                Date ngaySinhDate = faker.date().birthday(20, 50);
                Date ngayVaoLamDate = faker.date().past(2000, ngaySinhDate);

                LocalDate ngaySinh = Instant.ofEpochMilli(ngaySinhDate.getTime())
                        .atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate ngayVaoLam = Instant.ofEpochMilli(ngayVaoLamDate.getTime())
                        .atZone(ZoneId.systemDefault()).toLocalDate();

                nhanVien.setMaNhanVien(maNhanVien);
                nhanVien.setHoTen(hoTen);
                nhanVien.setCccd(cccd);
                nhanVien.setSdt(sdt);
                nhanVien.setEmail(email);
                nhanVien.setGioiTinh(gioiTinh);
                nhanVien.setDiaChi(diaChi);
                nhanVien.setLoaiNV(loaiNV);
                nhanVien.setTrangThai(trangThai);
                nhanVien.setNgaySinh(ngaySinh);
                nhanVien.setNgayVaoLam(ngayVaoLam);

                tr.begin();
                em.persist(nhanVien);
                tr.commit();

                System.out.println("Đã thêm nhân viên: " + nhanVien);
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
