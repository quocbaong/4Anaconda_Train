package datafaker;

import entity.NhanVien;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class NhanVien_Data {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("SourceMSSQL")
                .createEntityManager();
        EntityTransaction tr = em.getTransaction();

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

                LocalDate ngaySinh = getRandomDateBetween(
                        LocalDate.now().minusYears(50),
                        LocalDate.now().minusYears(20)
                );
                LocalDate ngayVaoLam = getRandomDateBetween(
                        ngaySinh.plusYears(18),
                        LocalDate.now()
                );

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

    // Chuyển đổi từ Date sang LocalDate
    public static LocalDate convertToLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    // Random ngày trong khoảng từ startDate đến endDate
    public static LocalDate getRandomDateBetween(LocalDate startDate, LocalDate endDate) {
        long start = startDate.toEpochDay();
        long end = endDate.toEpochDay();
        long randomDay = ThreadLocalRandom.current().nextLong(start, end + 1);
        return LocalDate.ofEpochDay(randomDay);
    }
}
