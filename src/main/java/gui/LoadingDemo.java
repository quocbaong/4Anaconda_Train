package gui;

import javax.swing.*;
import java.awt.*;

public class LoadingDemo {

    // Hàm tạo giao diện loading với hình ảnh
    private static void createAndShowLoading() {
        // Tạo JFrame cho cửa sổ chính
        JFrame frame = new JFrame("Loading...");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 450);
        frame.setLocationRelativeTo(null);  // Đặt giữa màn hình

        // Tạo JLabel cho thông báo loading
        JLabel label = new JLabel("Đang tải, vui lòng chờ trong giây lát...", SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.PLAIN, 14));

        // Nạp hình ảnh từ file (đảm bảo bạn có hình ảnh "login.jpg" trong thư mục)
        ImageIcon originalIcon = new ImageIcon(LoadingDemo.class.getResource("/icon/login.jpg"));  // Load original image

        // Thay đổi kích thước hình ảnh
        Image scaledImage = originalIcon.getImage().getScaledInstance(600, 400, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

     // Tạo thanh tiến trình (JProgressBar)
        JProgressBar progressBar = new JProgressBar(0, 100);  // Từ 0 đến 100
        progressBar.setValue(0);
        progressBar.setStringPainted(true);
        
        // Tạo JLabel để chứa hình ảnh đã được thu nhỏ
        JLabel imageLabel = new JLabel(scaledIcon, SwingConstants.CENTER);

        JPanel progressPanel = new JPanel(null);  // Sử dụng layout null để định vị thủ công
        progressPanel.setPreferredSize(new Dimension(600, 50));
        progressBar.setBounds(10, 10, 580, 20);  // Đặt kích thước cho thanh tiến trình
        progressPanel.add(progressBar);

        // Tạo layout cho các thành phần trong frame
        frame.setLayout(new BorderLayout());
        frame.add(imageLabel, BorderLayout.NORTH);  // Thêm hình ảnh ở trên
        frame.add(label, BorderLayout.CENTER);  // Thêm thông báo ở giữa
        frame.add(progressBar, BorderLayout.SOUTH);  // Thêm thanh tiến trình ở dưới

        // Hiển thị frame
        frame.setVisible(true);

        new SwingWorker<Void, Integer>() {
            @Override
            protected Void doInBackground() throws Exception {
                for (int i = 0; i <= 100; i++) {
                    // Mô phỏng quá trình tải dữ liệu
                    Thread.sleep(30);  // Chờ 30ms để mô phỏng quá trình tải
                    publish(i);  // Cập nhật thanh tiến trình
                }
                return null;
            }

            @Override
            protected void process(java.util.List<Integer> chunks) {
                int value = chunks.get(chunks.size() - 1);
                progressBar.setValue(value);

                // Cập nhật vị trí của icon tàu theo giá trị của thanh tiến trình
                int progressBarWidth = progressBar.getWidth();
                int newX = 10 + (progressBarWidth * value / 100);  // Tính toán vị trí X của tàu
            }

            @Override
            protected void done() {
                // Khi hoàn thành, đóng cửa sổ loading và hiển thị nội dung chính
                frame.dispose();  // Đóng cửa sổ loading

                // Hiển thị giao diện đăng nhập
                showMainApp();  // Gọi hàm showMainApp
            }
        }.execute();
    }

    // Hàm tạo giao diện chính (sau khi hoàn thành loading)
    private static void showMainApp() {
        // Khởi tạo và hiển thị giao diện đăng nhập
        new LoginScreen().setVisible(true);;  // Tạo instance mới của Login
    }

    // Hàm main để chạy chương trình
    public static void main(String[] args) {
        // Chạy giao diện trên luồng sự kiện của Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowLoading();  // Gọi hàm tạo giao diện loading
            }
        });
    }
}