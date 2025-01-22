package datafaker;

import entity.KhachHang;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

import java.util.Random;

public class KhachHang_Data {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("SourceMSSQL").createEntityManager();
        Faker faker = new Faker();
        EntityTransaction tr = em.getTransaction();
        Random rd = new Random();

        for(int i = 0; i < 10; i++){
            KhachHang khachHang = new KhachHang();

            khachHang.setCccd("0" + faker.number().digits(11));
            khachHang.setHoTen(faker.name().fullName());

            String[] prefixes = {"09", "08", "07"};
            String prefix = prefixes[faker.random().nextInt(prefixes.length)];
            String sdt = prefix + faker.number().digits(8);
            khachHang.setSdt(sdt);
            khachHang.setEmail(faker.internet().emailAddress());
            khachHang.setDoiTuong(faker.options().option("Sinh Viên", "Người lớn", "Người già", "Trẻ em"));

            tr.begin();
            em.persist(khachHang);
            tr.commit();
        }
        em.close();
    }
}
