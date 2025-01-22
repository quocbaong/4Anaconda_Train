package datafaker;

import entity.Tuyen;
import entity.Ga;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Tuyen_Data {
    public static void main(String[] args) {
        Faker faker = new Faker();
        EntityManager em = Persistence.createEntityManagerFactory("SourceMSSQL").createEntityManager();
        EntityTransaction tr = em.getTransaction();

        try {
            tr.begin();

            for (int i = 1; i <= 10; i++) {
                Tuyen tuyen = new Tuyen();
                tuyen.setMaTuyen("T" + i);

                String startCity = faker.address().city();
                String endCity = faker.address().city();
                tuyen.setTenTuyen(startCity + " - " + endCity);

                tuyen.setDiemDi(startCity);
                tuyen.setDiemDen(endCity);

                tuyen.setThoiGianKhoiHanh(LocalDate.now().plusDays(i).atTime(LocalTime.of(8, 0)).toString());
                tuyen.setThoiGianDenDuKien(LocalDate.now().plusDays(i + 1).atTime(LocalTime.of(18, 0)).toString());

                tuyen.setGiaVeCoBan(faker.number().randomDouble(2, 100, 1000));
                tuyen.setTrangThai(i % 2 == 0);

                Set<Ga> gas = new HashSet<>();
                for (int j = 1; j <= 2; j++) {
                    Ga ga = new Ga();
                    ga.setId(i * 10 + j);
                    ga.setTenGa(faker.address().cityName());
                    gas.add(ga);
                    em.persist(ga);
                }
                tuyen.setListGas(gas);

                em.persist(tuyen);
            }

            tr.commit();
        } catch (Exception e) {
            tr.rollback();
            e.printStackTrace();
        } finally {
            em.close();
        }
    }
}
