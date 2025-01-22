package datafaker;

import entity.Ve;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

import java.time.LocalDateTime;

public class Ve_Data {
    public static void main(String[] args) {
        Faker faker = new Faker();
        EntityManager em = Persistence.createEntityManagerFactory("SourceMSSQL").createEntityManager();
        EntityTransaction tr = em.getTransaction();

        for (int i = 1; i <= 10; i++) {
            Ve ve = new Ve();
            ve.setMaVe("VE" + i);
            ve.setThoiGianLenTau(LocalDateTime.now().plusDays(i));
            ve.setTrangThai(i % 2 == 0);

            tr.begin();
            em.persist(ve);
            tr.commit();
        }
    }
}
