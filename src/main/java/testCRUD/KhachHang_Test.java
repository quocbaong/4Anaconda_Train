package testCRUD;

import dao.KhachHangDao;
import entity.KhachHang;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class KhachHang_Test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SourceMSSQL");
        KhachHangDao khachHangDao = new KhachHangDao(emf);
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ KHÁCH HÀNG =====");
            System.out.println("1. Thêm khách hàng");
            System.out.println("2. Cập nhật thông tin khách hàng");
            System.out.println("3. Tìm khách hàng theo số điện thoại");
            System.out.println("4. Tìm khách hàng theo CCCD");
            System.out.println("5. Lấy danh sách tất cả khách hàng");
            System.out.println("0. Thoát");
            System.out.print("Vui lòng chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Nhập CCCD: ");
                    String cccd = scanner.nextLine();
                    System.out.print("Nhập họ và tên: ");
                    String hoTen = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String sdt = scanner.nextLine();
                    System.out.print("Nhập email: ");
                    String email = scanner.nextLine();
                    System.out.print("Nhập đối tượng: ");
                    String doiTuong = scanner.nextLine();

                    KhachHang khMoi = new KhachHang(cccd, hoTen, sdt, email, doiTuong);
                    if (khachHangDao.addKhachHang(khMoi)) {
                        System.out.println("Thêm khách hàng thành công!");
                    } else {
                        System.out.println("Thêm khách hàng thất bại.");
                    }
                    break;

                case 2:
                    System.out.print("Nhập CCCD của khách hàng cần cập nhật: ");
                    cccd = scanner.nextLine();
                    KhachHang khCapNhat = khachHangDao.getKhachHangByCCCD(cccd);
                    if (khCapNhat != null) {
                        System.out.print("Nhập họ và tên mới: ");
                        khCapNhat.setHoTen(scanner.nextLine());
                        System.out.print("Nhập số điện thoại mới: ");
                        khCapNhat.setSdt(scanner.nextLine());
                        System.out.print("Nhập email mới: ");
                        khCapNhat.setEmail(scanner.nextLine());
                        System.out.print("Nhập đối tượng mới: ");
                        khCapNhat.setDoiTuong(scanner.nextLine());

                        if (khachHangDao.updateKhachHang(khCapNhat)) {
                            System.out.println("Cập nhật thông tin khách hàng thành công!");
                        } else {
                            System.out.println("Cập nhật thất bại.");
                        }
                    } else {
                        System.out.println("Không tìm thấy khách hàng với CCCD đã nhập.");
                    }
                    break;

                case 3:
                    System.out.print("Nhập số điện thoại: ");
                    sdt = scanner.nextLine();
                    KhachHang khBySdt = khachHangDao.getKhachHangByPhoneNumber(sdt);
                    if (khBySdt != null) {
                        System.out.println("Thông tin khách hàng:");
                        System.out.println(khBySdt);
                    } else {
                        System.out.println("Không tìm thấy khách hàng với số điện thoại đã nhập.");
                    }
                    break;

                case 4:
                    System.out.print("Nhập CCCD: ");
                    cccd = scanner.nextLine();
                    KhachHang khByCccd = khachHangDao.getKhachHangByCCCD(cccd);
                    if (khByCccd != null) {
                        System.out.println("Thông tin khách hàng:");
                        System.out.println(khByCccd);
                    } else {
                        System.out.println("Không tìm thấy khách hàng với CCCD đã nhập.");
                    }
                    break;

                case 5:
                    List<KhachHang> dsKhachHang = khachHangDao.getAllKhachHang();
                    if (dsKhachHang != null && !dsKhachHang.isEmpty()) {
                        System.out.println("Danh sách khách hàng:");
                        for (KhachHang kh : dsKhachHang) {
                            System.out.println(kh);
                        }
                    } else {
                        System.out.println("Không có khách hàng nào trong danh sách.");
                    }
                    break;

                case 0:
                    System.out.println("Đã thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                    break;
            }
        } while (choice != 0);

        emf.close();
        scanner.close();
    }
}
