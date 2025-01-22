package datafaker;

import entity.Tuyen;
import entity.Ga;
import entity.Chuyen;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import net.datafaker.Faker;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Tuyen_Data {
    public static void main(String[] args) {
        Faker faker = new Faker();
        EntityManager em = Persistence.createEntityManagerFactory("SourceMSSQL").createEntityManager();
        EntityTransaction tr = em.getTransaction();

        for (int i = 1; i <= 10; i++) {
            Tuyen tuyen = new Tuyen();
            tuyen.setMaTuyen("T" + i);

            String startCity = faker.address().city();
            String endCity = faker.address().city();
            tuyen.setTenTuyen(startCity + " - " + endCity);

            tuyen.setDiemDi(startCity);
            tuyen.setDiemDen(endCity);

            tuyen.setThoiGianKhoiHanh(LocalDateTime.now().plusDays(i).toString());
            tuyen.setThoiGianDenDuKien(LocalDateTime.now().plusDays(i + 1).toString());

            tuyen.setGiaVeCoBan(faker.number().randomDouble(2, 100, 1000));
            tuyen.setTrangThai(i % 2 == 0);

            Set<Ga> gas = new HashSet<>();
            Ga ga = new Ga();
            ga.setID(i);
            ga.setName(faker.address().cityName());
            gas.add(ga);

            tuyen.setListGas(gas);

            Set<Chuyen> chuyens = new HashSet<>();
            Chuyen chuyen = new Chuyen();
            chuyen.setID(i);
            chuyens.add(chuyen);

            tr.begin();
            em.persist(tuyen);
            tr.commit();
        }
    }
}
