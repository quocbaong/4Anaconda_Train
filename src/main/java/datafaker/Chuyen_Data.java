package datafaker;

import entity.Chuyen;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chuyen_Data {
    public static void main(String[] args) {
        EntityManager em = Persistence.createEntityManagerFactory("SourceMSSQL").createEntityManager();
        EntityTransaction tr = em.getTransaction();
        Random rd = new Random();

        List<String> diaDiem = List.of("Sài Gòn", "Bình Thuận", "Hà Nội", "Đà Nẵng", "Nha Trang", "Huế", "Tuy Hòa");

        List<String> maTauList = List.of("SE01", "SE02", "SE03", "TN01", "TN02", "TN03");

        List<LocalTime> gioKhoiHanhList = List.of(
                LocalTime.of(9, 0),
                LocalTime.of(12, 0),
                LocalTime.of(16, 30),
                LocalTime.of(18, 45)
        );

        List<LocalDate> ngayKhoiHanhList = List.of(
                LocalDate.of(2025, 1, 25),
                LocalDate.of(2025, 1, 27),
                LocalDate.of(2025, 2, 1)
        );

        for (int i = 0; i < 10; i++) {
            Chuyen chuyen = new Chuyen();

            String diaDiemDi = diaDiem.get(rd.nextInt(diaDiem.size()));
            String diaDiemDen;
            do {
                diaDiemDen = diaDiem.get(rd.nextInt(diaDiem.size()));
            } while (diaDiemDi.equals(diaDiemDen));

            String tenTuyen = diaDiemDi + " - " + diaDiemDen;

            String maTau = maTauList.get(rd.nextInt(maTauList.size()));
            LocalTime gioKhoiHanh = gioKhoiHanhList.get(rd.nextInt(gioKhoiHanhList.size()));
            LocalDate ngayKhoiHanh = ngayKhoiHanhList.get(rd.nextInt(ngayKhoiHanhList.size()));

            boolean chieu = diaDiem.indexOf(diaDiemDi) < diaDiem.indexOf(diaDiemDen); // True: N-B, False: B-N

            String maChuyen = maTau + gioKhoiHanh.format(DateTimeFormatter.ofPattern("HHmm"))
                    + ngayKhoiHanh.format(DateTimeFormatter.ofPattern("yyyyMMdd"))
                    + (chieu ? "NB" : "BN");

            chuyen.setMaChuyen(maChuyen);
            chuyen.setTenCHuyen(tenTuyen);
            chuyen.setGioKhoiHanh(gioKhoiHanh);
            chuyen.setNgayKhoiHanh(ngayKhoiHanh);
            chuyen.setTau(maTau);
            chuyen.setChieu(chieu);
            chuyen.setTuyen(chieu ? "N-B" : "B-N");

            tr.begin();
            em.persist(chuyen);
            tr.commit();
        }
        em.close();
    }
}
