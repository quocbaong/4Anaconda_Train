package datafaker;

import entity.Toa;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

import java.util.Random;

public class Toa_Data {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("SourceMSSQL").createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Faker faker = new Faker();
        Random random = new Random();

        try {
            transaction.begin();

            // Tạo 10 bản ghi giả cho thực thể Toa
            for (int i = 0; i < 10; i++) {
                Toa toa = new Toa();
                toa.setMaToa("TOA" + (i + 1)); // Mã toa giả định
                toa.setLoaiToa(faker.options().option("Hành khách", "Hàng hóa", "Ngủ", "Ghế mềm")); // Loại toa ngẫu nhiên
                toa.setViTri(random.nextInt(10) + 1); // Vị trí từ 1 đến 10

                em.persist(toa); // Lưu thực thể vào database
            }

            transaction.commit();
            System.out.println("Dữ liệu giả cho thực thể Toa đã được tạo thành công!");
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
