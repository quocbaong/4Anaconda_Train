package testCRUD;
import dao.TaiKhoanDao;
import entity.TaiKhoan;
import entity.NhanVien;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;
import java.util.Scanner;

public class TestTaiKhoan {
    public static void main(String[] args) {
        // Create EntityManagerFactory and TaiKhoanDao instance
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("theroyal");
        TaiKhoanDao taiKhoanDao = new TaiKhoanDao(emf);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add TaiKhoan");
            System.out.println("2. Update TaiKhoan");
            System.out.println("3. Get TaiKhoan by Username");
            System.out.println("4. Get All TaiKhoan");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Add TaiKhoan
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter role: ");
                    String role = scanner.nextLine();

                    // Create a dummy NhanVien (assuming NhanVien exists in the database)
                    System.out.print("Enter NhanVien ID (String): ");
                    String nhanVienId = scanner.nextLine();  // Use String for NhanVien ID

                    NhanVien nhanVien = new NhanVien(); // Fetch or create NhanVien object
                    nhanVien.setMaNhanVien(nhanVienId); // Set the ID of NhanVien

                    TaiKhoan newAccount = new TaiKhoan(username, password);
                    newAccount.setNhanVien(nhanVien);

                    if (taiKhoanDao.addTaiKhoan(newAccount)) {
                        System.out.println("Account added successfully!");
                    } else {
                        System.out.println("Failed to add account.");
                    }
                    break;

                case 2:
                    // Update TaiKhoan
                    System.out.print("Enter username of the account to update: ");
                    String updateUsername = scanner.nextLine();
                    TaiKhoan existingAccount = taiKhoanDao.getTaiKhoanByUserName(updateUsername);

                    if (existingAccount != null) {
                        System.out.print("Enter new password: ");
                        String newPassword = scanner.nextLine();
                        System.out.print("Enter new role: ");
                        String newRole = scanner.nextLine();

                        existingAccount.setMatKhau(newPassword);
                        existingAccount.setNhanVien(existingAccount.getNhanVien()); // Keep the same NhanVien for simplicity

                        if (taiKhoanDao.updateTaiKhoan(existingAccount)) {
                            System.out.println("Account updated successfully!");
                        } else {
                            System.out.println("Failed to update account.");
                        }
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    // Get TaiKhoan by Username
                    System.out.print("Enter username: ");
                    String searchUsername = scanner.nextLine();
                    TaiKhoan foundAccount = taiKhoanDao.getTaiKhoanByUserName(searchUsername);

                    if (foundAccount != null) {
                        System.out.println("Account found: " + foundAccount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    // Get All TaiKhoan
                    List<TaiKhoan> allAccounts = taiKhoanDao.getAllTaiKhoan();
                    if (!allAccounts.isEmpty()) {
                        System.out.println("List of all accounts:");
                        allAccounts.forEach(System.out::println);
                    } else {
                        System.out.println("No accounts found.");
                    }
                    break;

                case 0:
                    // Exit
                    System.out.println("Exiting...");
                    emf.close();
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}