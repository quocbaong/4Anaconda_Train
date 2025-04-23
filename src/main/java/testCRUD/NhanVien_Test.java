package testCRUD;

import dao.NhanVienDao;
import entity.NhanVien;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class NhanVien_Test {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("SourceMSSQL");
        NhanVienDao nhanVienDao = new NhanVienDao(emf);
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ NHÂN VIÊN =====");
            System.out.println("1. Thêm nhân viên");
            System.out.println("2. Cập nhật thông tin nhân viên");
            System.out.println("3. Tìm nhân viên theo mã");
            System.out.println("4. Lấy danh sách tất cả nhân viên");
            System.out.println("0. Thoát");
            System.out.print("Vui lòng chọn: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    System.out.print("Nhập mã nhân viên: ");
                    String maNhanVien = scanner.nextLine();
                    System.out.print("Nhập họ và tên: ");
                    String hoTen = scanner.nextLine();
                    System.out.print("Nhập CCCD: ");
                    String cccd = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    String sdt = scanner.nextLine();
                    System.out.print("Nhập email: ");
                    String email = scanner.nextLine();
                    System.out.print("Nhập giới tính (nam/nữ): ");
                    String gioiTinhStr = scanner.nextLine();
                    boolean gioiTinh = gioiTinhStr.equalsIgnoreCase("nam");

                    System.out.print("Nhập địa chỉ: ");
                    String diaChi = scanner.nextLine();
                    System.out.print("Nhập loại nhân viên (Toàn thời gian/Bán thời gian): ");
                    String loaiNV = scanner.nextLine();
                    System.out.print("Nhập trạng thái (true/false): ");
                    boolean trangThai = Boolean.parseBoolean(scanner.nextLine());

                    System.out.print("Nhập ngày sinh (YYYY-MM-DD): ");
                    LocalDate ngaySinh = LocalDate.parse(scanner.nextLine());
                    System.out.print("Nhập ngày vào làm (YYYY-MM-DD): ");
                    LocalDate ngayVaoLam = LocalDate.parse(scanner.nextLine());

                    NhanVien nhanVienMoi = new NhanVien(maNhanVien, hoTen, cccd, sdt, email, gioiTinh, diaChi, loaiNV, trangThai, ngaySinh, ngayVaoLam);
                    if (nhanVienDao.addNhanVien(nhanVienMoi)) {
                        System.out.println("Thêm nhân viên thành công!");
                    } else {
                        System.out.println("Thêm nhân viên thất bại.");
                    }
                    break;

                case 2:
                    System.out.print("Nhập mã nhân viên cần cập nhật: ");
                    maNhanVien = scanner.nextLine();
                    NhanVien nhanVienCapNhat = nhanVienDao.getNhanVienByMa(maNhanVien);
                    if (nhanVienCapNhat != null) {
                        System.out.print("Nhập họ và tên mới: ");
                        nhanVienCapNhat.setHoTen(scanner.nextLine());
                        System.out.print("Nhập số điện thoại mới: ");
                        nhanVienCapNhat.setSdt(scanner.nextLine());
                        System.out.print("Nhập email mới: ");
                        nhanVienCapNhat.setEmail(scanner.nextLine());
                        System.out.print("Nhập ngày sinh mới (YYYY-MM-DD): ");
                        nhanVienCapNhat.setNgaySinh(LocalDate.parse(scanner.nextLine()));
                        System.out.print("Nhập địa chỉ mới: ");
                        nhanVienCapNhat.setDiaChi(scanner.nextLine());

                        if (nhanVienDao.updateNhanVien(nhanVienCapNhat)) {
                            System.out.println("Cập nhật thông tin nhân viên thành công!");
                        } else {
                            System.out.println("Cập nhật thất bại.");
                        }
                    } else {
                        System.out.println("Không tìm thấy nhân viên với mã đã nhập.");
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã nhân viên: ");
                    maNhanVien = scanner.nextLine();
                    NhanVien nhanVienByMa = nhanVienDao.getNhanVienByMa(maNhanVien);
                    if (nhanVienByMa != null) {
                        System.out.println("Thông tin nhân viên:");
                        System.out.println(nhanVienByMa);
                    } else {
                        System.out.println("Không tìm thấy nhân viên với mã đã nhập.");
                    }
                    break;

                case 4:
                    List<NhanVien> dsNhanVien = nhanVienDao.getAllNhanVien();
                    if (dsNhanVien != null && !dsNhanVien.isEmpty()) {
                        System.out.println("Danh sách nhân viên:");
                        for (NhanVien nhanVien : dsNhanVien) {
                            System.out.println(nhanVien);
                        }
                    } else {
                        System.out.println("Không có nhân viên nào trong danh sách.");
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
