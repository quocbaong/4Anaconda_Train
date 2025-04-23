package datafaker;

import entity.Tau;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

import java.util.Random;

public class Tau_Data {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("SourceMSSQL").createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        Faker faker = new Faker();
        Random random = new Random();

        try {
            transaction.begin();

            // Tạo 10 bản ghi giả cho thực thể Tàu
            for (int i = 0; i < 10; i++) {
                Tau tau = new Tau();
                tau.setMaTau("T" + (i + 1)); // Mã tàu giả định
                tau.setLoaiTau(faker.vehicle().type()); // Lấy loại tàu từ faker
                tau.setTenTau(faker.space().star()); // Tên tàu là tên ngôi sao
                tau.setTocDo(50 + random.nextDouble() * 100); // Tốc độ ngẫu nhiên từ 50 đến 150

                em.persist(tau); // Lưu thực thể vào database
            }

            transaction.commit();
            System.out.println("Dữ liệu giả cho thực thể Tàu đã được tạo thành công!");
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
