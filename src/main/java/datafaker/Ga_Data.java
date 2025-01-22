package datafaker;

import entity.Ga;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

import java.util.Random;

public class Ga_Data {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("SourceMSSQL").createEntityManager();
        Faker faker = new Faker();
        EntityTransaction tr = em.getTransaction();
        Random rd = new Random();

        for (int i = 0; i < 10; i++) {
            Ga ga = new Ga();

            String city = faker.address().city();
            ga.setTenGa("Ga "+city);
            ga.setDiaChi(faker.address().streetAddress());
            ga.setId(i);
            ga.setCuLy(faker.number().randomDouble(2,1, 12));

            tr.begin();
            em.persist(ga);
            tr.commit();
        }
        em.close();
    }
}
