package datafaker;

import entity.KhuyenMai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

import java.time.Instant;
import java.util.Date;
import java.util.Random;

public class KhuyenMai_Data {
    public static void main(String[] args) {
        // Tạo đối tượng EntityManager và Transaction
        EntityManager em = Persistence.createEntityManagerFactory("SourceMSSQL")
                .createEntityManager();
        EntityTransaction tr = em.getTransaction();

        // Tạo các đối tượng hỗ trợ dữ liệu giả
        Faker faker = new Faker();
        Random random = new Random();

        try {
            for (int i = 1; i <= 10; i++) {
                KhuyenMai khuyenMai = new KhuyenMai(maKM, tenKM, chietKhau, startTime, endTime, moTa, soLuongVe, trangThai);
                String maKhuyenMai = "KM" + i;
                String tenKhuyenMai = faker.commerce().promotionCode();
                String loaiKhuyenMai = random.nextBoolean() ? "Giảm giá" : "Quà tặng";

                Date startDate = faker.date().between(
                        Date.from(Instant.parse("2020-01-01T00:00:00Z")),
                        Date.from(Instant.parse("2023-12-31T23:59:59Z"))
                );
                Date endDate = faker.date().future(30, java.util.concurrent.TimeUnit.DAYS, startDate);

                int soLuongVe = random.nextInt(50) + 1;
                boolean trangThai = random.nextBoolean();
                double chietKhau = random.nextDouble() * 50;

                khuyenMai.setMaKhuyenMai(maKhuyenMai);
                khuyenMai.setTenKhuyenMai(tenKhuyenMai);
                khuyenMai.setLoaiKhuyenMai(loaiKhuyenMai);
                khuyenMai.setThoiGianBatDau(startDate);
                khuyenMai.setThoiGianKetThuc(endDate);
                khuyenMai.setSoLuongVe(soLuongVe);
                khuyenMai.setTrangThai(trangThai);
                khuyenMai.setChietKhau(chietKhau);

                tr.begin();
                em.persist(khuyenMai);
                tr.commit();

                System.out.println("Đã thêm khuyến mãi: " + khuyenMai);
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
