package testCRUD;

import dao.KhuyenMaiDao;
import entity.KhuyenMai;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class KhuyenMai_Test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SourceMSSQL");
        KhuyenMaiDao khuyenMaiDao = new KhuyenMaiDao(emf);

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        while (true) {
            System.out.println("\nChọn chức năng:");
            System.out.println("1. Thêm Khuyến mãi");
            System.out.println("2. Cập nhật Khuyến mãi");
            System.out.println("3. Xem danh sách Khuyến mãi");
            System.out.println("4. Lấy Khuyến mãi theo mã");
            System.out.println("5. Lấy Khuyến mãi theo thời gian");
            System.out.println("0. Thoát");
            System.out.print("Nhập lựa chọn: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("=== Thêm Khuyến mãi ===");
                    sc.nextLine(); // Bỏ qua dòng thừa
                    System.out.print("Nhập mã KM: ");
                    String maKM = sc.nextLine();
                    System.out.print("Nhập tên KM: ");
                    String tenKM = sc.nextLine();
                    System.out.print("Nhập loại khuyến mãi: ");
                    String loaiKhuyenMai = sc.nextLine();
                    System.out.print("Nhập chiết khấu: ");
                    double chietKhau = sc.nextDouble();
                    sc.nextLine(); // Bỏ qua dòng thừa
                    System.out.print("Nhập thời gian bắt đầu (yyyy-MM-dd): ");
                    Date startTime = null;
                    try {
                        startTime = sdf.parse(sc.nextLine());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.print("Nhập thời gian kết thúc (yyyy-MM-dd): ");
                    Date endTime = null;
                    try {
                        endTime = sdf.parse(sc.nextLine());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.print("Nhập số lượng vé: ");
                    int soLuongVe = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Nhập trạng thái (true/false): ");
                    boolean trangThai = sc.nextBoolean();

                    KhuyenMai newKM = new KhuyenMai(maKM, tenKM, loaiKhuyenMai, startTime, endTime, soLuongVe, trangThai, chietKhau);

                    if (khuyenMaiDao.addKhuyenMai(newKM)) {
                        System.out.println("Thêm Khuyến mãi thành công!");
                    } else {
                        System.out.println("Thêm Khuyến mãi thất bại.");
                    }
                    break;

                case 2:
                    System.out.println("=== Cập nhật Khuyến mãi ===");
                    sc.nextLine(); // Bỏ qua dòng thừa
                    System.out.print("Nhập mã Khuyến mãi cần cập nhật: ");
                    String maUpdate = sc.nextLine();
                    KhuyenMai kmUpdate = khuyenMaiDao.getKhuyenMaiByMa(maUpdate);
                    if (kmUpdate != null) {
                        System.out.print("Nhập tên mới cho Khuyến mãi: ");
                        kmUpdate.setTenKhuyenMai(sc.nextLine());
                        System.out.print("Nhập chiết khấu mới: ");
                        kmUpdate.setChietKhau(sc.nextDouble());
                        sc.nextLine(); // Bỏ qua dòng thừa
                        if (khuyenMaiDao.updateKhuyenMai(kmUpdate)) {
                            System.out.println("Cập nhật Khuyến mãi thành công!");
                        } else {
                            System.out.println("Cập nhật Khuyến mãi thất bại.");
                        }
                    } else {
                        System.out.println("Không tìm thấy Khuyến mãi với mã: " + maUpdate);
                    }
                    break;

                case 3:
                    System.out.println("=== Danh sách Khuyến mãi ===");
                    List<KhuyenMai> danhSachKM = khuyenMaiDao.getAllKhuyenMai();
                    for (KhuyenMai km : danhSachKM) {
                        System.out.println(km);
                    }
                    break;

                case 4:
                    System.out.println("=== Lấy Khuyến mãi theo mã ===");
                    sc.nextLine(); // Bỏ qua dòng thừa
                    System.out.print("Nhập mã Khuyến mãi: ");
                    String maTim = sc.nextLine();
                    KhuyenMai kmTim = khuyenMaiDao.getKhuyenMaiByMa(maTim);
                    if (kmTim != null) {
                        System.out.println("Thông tin Khuyến mãi: " + kmTim);
                    } else {
                        System.out.println("Không tìm thấy Khuyến mãi với mã: " + maTim);
                    }
                    break;

                case 5:
                    System.out.println("=== Lấy Khuyến mãi theo khoảng thời gian ===");
                    sc.nextLine(); // Bỏ qua dòng thừa
                    System.out.print("Nhập ngày bắt đầu (yyyy-MM-dd): ");
                    Date startRange = null;
                    try {
                        startRange = sdf.parse(sc.nextLine());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    System.out.print("Nhập ngày kết thúc (yyyy-MM-dd): ");
                    Date endRange = null;
                    try {
                        endRange = sdf.parse(sc.nextLine());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    List<KhuyenMai> dsTimeRange = khuyenMaiDao.getKhuyenMaiByTimeRange(startRange, endRange);
                    for (KhuyenMai km : dsTimeRange) {
                        System.out.println(km);
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    emf.close();
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng thử lại.");
            }
        }
    }
}
