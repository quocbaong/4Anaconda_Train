package datafaker;

import entity.KhuyenMai;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Random;

public class KhuyenMai_Data {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("SourceMSSQL").createEntityManager();
        EntityTransaction tr = em.getTransaction();

        Faker faker = new Faker();
        Random random = new Random();

        try {
            for (int i = 1; i <= 10; i++) {
                String maKhuyenMai = "KM" + i;
                String tenKhuyenMai = faker.commerce().promotionCode();
                String loaiKhuyenMai = random.nextBoolean() ? "Giảm giá" : "Quà tặng";

                LocalDate startLocalDate = LocalDate.of(2020, 1, 1).plusDays(random.nextInt(1460)); // tối đa 4 năm
                Date startDate = Date.from(startLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

                LocalDate endLocalDate = startLocalDate.plusDays(random.nextInt(30) + 1);
                Date endDate = Date.from(endLocalDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

                int soLuongVe = random.nextInt(50) + 1;
                boolean trangThai = random.nextBoolean();
                double chietKhau = Math.round(random.nextDouble() * 50 * 10.0) / 10.0;

                KhuyenMai khuyenMai = new KhuyenMai(
                        maKhuyenMai,
                        tenKhuyenMai,
                        loaiKhuyenMai,
                        startDate,
                        endDate,
                        soLuongVe,
                        trangThai,
                        chietKhau
                );

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
