package gui;

import form.FormTraCuuKhuyenMai;
import form.FormTraCuuNhanVien;
import jakarta.persistence.EntityManagerFactory;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;

import dao.KhuyenMaiDao;
import entity.KhuyenMai;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GD_TraCuuKhuyenMai extends javax.swing.JPanel {

    private EntityManagerFactory emf;
    private FormTraCuuKhuyenMai formTraCuuKhuyenMai;
    public GD_TraCuuKhuyenMai(EntityManagerFactory emf) {
        this.emf = emf;
        initComponents();
        setBorder(new EmptyBorder(10, 10, 10, 10));

        // Khởi tạo FormTraCuuKhuyenMai chỉ một lần
        formTraCuuKhuyenMai = new FormTraCuuKhuyenMai(emf);

        // Mặc định hiển thị Form Tra cứu Khuyến mãi
        mainForm1.showForm(formTraCuuKhuyenMai);

        // Sự kiện cho ComboBox TrangThai
        cbTrangThai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Kiểm tra trạng thái được chọn
                String trangThai = cbTrangThai.getSelectedItem() != null ? cbTrangThai.getSelectedItem().toString() : "";

                // Kiểm tra mainForm1 và form hiện tại
                if (mainForm1 != null && mainForm1.getCurrentForm() instanceof FormTraCuuKhuyenMai) {
                    FormTraCuuKhuyenMai form = (FormTraCuuKhuyenMai) mainForm1.getCurrentForm();

                    // Sử dụng switch-case truyền thống
                    switch (trangThai) {
                        case "Đang áp dụng":
                            form.hienThiDanhSachKhuyenMaiTheoTrangThai("Đang áp dụng");
                            break;
                        case "Hết hạn":
                            form.hienThiDanhSachKhuyenMaiTheoTrangThai("Hết hạn");
                            break;
                        case "Hết lượt":
                            form.hienThiDanhSachKhuyenMaiTheoTrangThai("Hết lượt");
                            break;
                        case "Sắp kết thúc":
                            form.hienThiDanhSachKhuyenMaiSapKetThuc();
                            break;
                        case "Lọc theo":
                            formTraCuuKhuyenMai.addDataTable(new KhuyenMaiDao(emf).getAllKhuyenMai());
                            break;
                        default:
                            System.out.println("Trạng thái không hợp lệ: " + trangThai);
                            break;
                    }
                } 
            }
        });



        // Sự kiện cho nút Tra cứu Nhân viên
        btnTraCuuNhanVien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainForm1.showForm(new FormTraCuuNhanVien(emf));
            }
        });
    }


    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g3 = new GradientPaint(0, 0, Color.decode("#6699CC"), 0, getHeight(), Color.decode("#6699CC"));
        g2.setPaint(g3);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
        super.paintChildren(g);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        mainForm1 = new form.MainForm();
        btnTraCuuKhuyenMai = new javax.swing.JButton();
        btnTraCuuNhanVien = new javax.swing.JButton();
        cbTrangThai = new javax.swing.JComboBox<>();

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1600, 1100));

        mainForm1.setPreferredSize(new java.awt.Dimension(1600, 1000));

        btnTraCuuKhuyenMai.setBackground(new java.awt.Color(0, 199, 255));
        btnTraCuuKhuyenMai.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnTraCuuKhuyenMai.setText("Tra cứu khuyến mãi");
        btnTraCuuKhuyenMai.setBorderPainted(false);
        btnTraCuuKhuyenMai.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnTraCuuKhuyenMai.setMaximumSize(new java.awt.Dimension(120, 45));
        btnTraCuuKhuyenMai.setMinimumSize(new java.awt.Dimension(120, 45));
        btnTraCuuKhuyenMai.setPreferredSize(new java.awt.Dimension(120, 45));

        btnTraCuuNhanVien.setBackground(new java.awt.Color(0, 199, 255));
        btnTraCuuNhanVien.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnTraCuuNhanVien.setText("Tra cứu nhân viên");
        btnTraCuuNhanVien.setBorderPainted(false);
        btnTraCuuNhanVien.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnTraCuuNhanVien.setMaximumSize(new java.awt.Dimension(120, 45));
        btnTraCuuNhanVien.setMinimumSize(new java.awt.Dimension(120, 45));
        btnTraCuuNhanVien.setPreferredSize(new java.awt.Dimension(120, 45));

        cbTrangThai.setFont(new java.awt.Font("SansSerif", 1, 18)); // NOI18N
        cbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lọc theo","Đang áp dụng", "Hết hạn", "Hết lượt", "Sắp kết thúc" }));
        cbTrangThai.setPreferredSize(new java.awt.Dimension(200, 45));
        cbTrangThai.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(btnTraCuuNhanVien, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnTraCuuKhuyenMai, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(cbTrangThai, GroupLayout.PREFERRED_SIZE, 265, GroupLayout.PREFERRED_SIZE))
        				.addComponent(mainForm1, GroupLayout.DEFAULT_SIZE, 1560, Short.MAX_VALUE))
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnTraCuuNhanVien, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnTraCuuKhuyenMai, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
        				.addComponent(cbTrangThai, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addComponent(mainForm1, GroupLayout.DEFAULT_SIZE, 1010, Short.MAX_VALUE)
        			.addGap(6))
        );
        this.setLayout(layout);
    }

    // Variables declaration
    private javax.swing.JButton btnTraCuuKhuyenMai;
    private javax.swing.JButton btnTraCuuNhanVien;
    private javax.swing.JComboBox<String> cbTrangThai;
    private form.MainForm mainForm1;
}
