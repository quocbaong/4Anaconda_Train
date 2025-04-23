package form;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.KhuyenMaiDao;
import entity.KhuyenMai;
import jakarta.persistence.EntityManagerFactory;
import swing.ScrollBar;

import java.awt.Component;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import static java.time.temporal.TemporalQueries.localDate;
import java.util.Date;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;


public class FormTraCuuKhuyenMai extends javax.swing.JPanel {

    private EntityManagerFactory emf;
    private KhuyenMaiDao khuyenMaiDao;
    private SimpleDateFormat formatNgay = new SimpleDateFormat("dd-MM-yyyy");
    private LocalDate localDate = LocalDate.now();
    private Date dateNow = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

    public FormTraCuuKhuyenMai(EntityManagerFactory emf) {
        this.emf = emf;
        initComponents();
        formThongTin.setBorder(new EmptyBorder(0, 0, 0, 0));
        formThongTin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE),
                "Thông tin khuyến mãi", 0, HEIGHT, new Font(Font.SANS_SERIF, Font.BOLD, 20) {
        }, Color.WHITE)); 
        tableTraCuuKM.setShowGrid(false);
        tableTraCuuKM.setShowHorizontalLines(false);
        tableTraCuuKM.setShowVerticalLines(false);
        tableTraCuuKM.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 14));
        tableTraCuuKM.getTableHeader().setPreferredSize(new Dimension(30, 30));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        ((DefaultTableCellRenderer) tableTraCuuKM.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
        khuyenMaiDao = new KhuyenMaiDao(emf);
        List<KhuyenMai> list = khuyenMaiDao.getAllKhuyenMai();
        addDataTable(list);
    }

    public void addDataTable(List<KhuyenMai> list) {
        DefaultTableModel model = (DefaultTableModel) tableTraCuuKM.getModel();
        model.setRowCount(0);
        String trangThai = "";
        for (KhuyenMai khuyenMai : list) {
        	if (khuyenMai.getThoiGianKetThuc().before(dateNow)) {
				trangThai="Hết hạn";
			}else {
				if (khuyenMai.isTrangThai()) {
					trangThai="Đang áp dụng";
				
			}
        	if (khuyenMai.getSoLuongVe()==0) {
				trangThai="Hết lượt";
			}
            Object[] row = {
                khuyenMai.getMaKhuyenMai(),
                khuyenMai.getTenKhuyenMai(),
                khuyenMai.getLoaiKhuyenMai(),
                khuyenMai.getSoLuongVe(),
                formatNgay.format(khuyenMai.getThoiGianBatDau()), // Format ngày/tháng/năm
                formatNgay.format(khuyenMai.getThoiGianKetThuc()), // Format ngày/tháng/năm
                khuyenMai.getChietKhau(),
                trangThai
            };
            model.addRow(row);
        }
        model.fireTableDataChanged();
    }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupRadio = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTraCuuKM = new JTable();
        formThongTin = new Form();
        lbMaKM = new JLabel();
        jtMaKM = new javax.swing.JTextField();
        lbTenKM = new JLabel();
        jtTenKM = new javax.swing.JTextField();
        lbChietKhau = new JLabel();
        jtChietKhau = new javax.swing.JTextField();
        lbNgayBatDauKM = new JLabel();
        jNgayBatDauKM = new com.toedter.calendar.JDateChooser();
        lbNgayKetThucKM = new JLabel();
        jNgayKetThucKM = new com.toedter.calendar.JDateChooser();
        btnXoaTrang = new javax.swing.JButton();
        btnTraCuu = new javax.swing.JButton();
        btnLocTheoNgay = new javax.swing.JButton();

        setOpaque(false);
        setPreferredSize(new Dimension(1430, 920));

        tableTraCuuKM.setFont(new Font("SansSerif", 0, 14)); // NOI18N
        tableTraCuuKM.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khuyến mãi", "Tên khuyến mãi", "Loại khuyến mãi", "Số lượng vé", "Ngày bắt đầu khuyến mãi", "Ngày kết thúc khuyến mãi", "Chiết khấu", "Trạng thái"
            }
        ));
        tableTraCuuKM.setColumnSelectionAllowed(true);
        tableTraCuuKM.setRowHeight(30);
        tableTraCuuKM.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTraCuuKMMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableTraCuuKM);
        tableTraCuuKM.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tableTraCuuKM.getColumnModel().getColumnCount() > 0) {
            tableTraCuuKM.getColumnModel().getColumn(0).setResizable(false);
            tableTraCuuKM.getColumnModel().getColumn(1).setResizable(false);
            tableTraCuuKM.getColumnModel().getColumn(2).setResizable(false);
            tableTraCuuKM.getColumnModel().getColumn(3).setResizable(false);
            tableTraCuuKM.getColumnModel().getColumn(4).setResizable(false);
            tableTraCuuKM.getColumnModel().getColumn(5).setResizable(false);
            tableTraCuuKM.getColumnModel().getColumn(6).setResizable(false);
            tableTraCuuKM.getColumnModel().getColumn(7).setResizable(false);
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < tableTraCuuKM.getColumnCount(); i++) {
            tableTraCuuKM.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        int[] columnWidths = {120, 120, 120, 90, 220, 220, 100, 120}; // Mảng chứa kích thước cố định của từng cột
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = tableTraCuuKM.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        lbMaKM.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        lbMaKM.setForeground(new Color(255, 255, 255));
        lbMaKM.setText("Mã khuyến mãi");

        jtMaKM.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        jtMaKM.setPreferredSize(new Dimension(300, 40));
        jtMaKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtMaKMActionPerformed(evt);
            }
        });

        lbTenKM.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        lbTenKM.setForeground(new Color(255, 255, 255));
        lbTenKM.setText("Tên khuyến mãi");

        jtTenKM.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        jtTenKM.setPreferredSize(new Dimension(64, 40));
        jtTenKM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtTenKMActionPerformed(evt);
            }
        });

        lbChietKhau.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        lbChietKhau.setForeground(new Color(255, 255, 255));
        lbChietKhau.setText("Chiết khấu");

        jtChietKhau.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        jtChietKhau.setMinimumSize(new Dimension(64, 30));
        jtChietKhau.setPreferredSize(new Dimension(64, 40));

        lbNgayBatDauKM.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        lbNgayBatDauKM.setForeground(new Color(255, 255, 255));
        lbNgayBatDauKM.setText("Ngày bắt đầu");

        jNgayBatDauKM.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jNgayBatDauKM.setAlignmentX(0.0F);
        jNgayBatDauKM.setAlignmentY(0.0F);
        jNgayBatDauKM.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        jNgayBatDauKM.setPreferredSize(new Dimension(88, 40));
        jNgayBatDauKM.setDateFormatString("dd/MM/yyyy");

        lbNgayKetThucKM.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        lbNgayKetThucKM.setForeground(new Color(255, 255, 255));
        lbNgayKetThucKM.setText("Ngày kết thúc");

        jNgayKetThucKM.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jNgayKetThucKM.setAlignmentX(0.0F);
        jNgayKetThucKM.setAlignmentY(0.0F);
        jNgayKetThucKM.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        jNgayKetThucKM.setPreferredSize(new Dimension(88, 40));
        jNgayKetThucKM.setDateFormatString("dd/MM/yyyy");

        btnXoaTrang.setFont(new Font("SansSerif", 1, 20)); // NOI18N
        btnXoaTrang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tay.png"))); // NOI18N
        btnXoaTrang.setText("Xóa Trắng");
        btnXoaTrang.setBorder(null);
        btnXoaTrang.setBorderPainted(false);
        btnXoaTrang.setFocusPainted(false);
        btnXoaTrang.setPreferredSize(new Dimension(103, 55));
        btnXoaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTrangActionPerformed(evt);
            }
        });

        btnTraCuu.setFont(new Font("SansSerif", 1, 20)); // NOI18N
        btnTraCuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search2.png"))); // NOI18N
        btnTraCuu.setText("Tra cứu");
        btnTraCuu.setBorder(null);
        btnTraCuu.setBorderPainted(false);
        btnTraCuu.setFocusPainted(false);
        btnTraCuu.setPreferredSize(new Dimension(103, 55));
        btnTraCuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraCuuActionPerformed(evt);
            }
        });

        btnLocTheoNgay.setFont(new Font("SansSerif", 1, 20)); // NOI18N
        btnLocTheoNgay.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loc.png"))); // NOI18N
        btnLocTheoNgay.setText("Lọc");
        btnLocTheoNgay.setBorder(null);
        btnLocTheoNgay.setBorderPainted(false);
        btnLocTheoNgay.setFocusPainted(false);
        btnLocTheoNgay.setPreferredSize(new Dimension(103, 55));
        btnLocTheoNgay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocTheoNgayActionPerformed(evt);
            }
        });

        GroupLayout formThongTinLayout = new GroupLayout(formThongTin);
        formThongTinLayout.setHorizontalGroup(
        	formThongTinLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, formThongTinLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(formThongTinLayout.createParallelGroup(Alignment.TRAILING)
        				.addGroup(formThongTinLayout.createParallelGroup(Alignment.LEADING)
        					.addComponent(btnXoaTrang, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
        					.addGroup(formThongTinLayout.createSequentialGroup()
        						.addComponent(btnLocTheoNgay, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(btnTraCuu, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(formThongTinLayout.createSequentialGroup()
        					.addGroup(formThongTinLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lbMaKM, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lbTenKM)
        						.addGroup(formThongTinLayout.createParallelGroup(Alignment.TRAILING, false)
        							.addComponent(lbChietKhau, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        							.addComponent(lbNgayBatDauKM, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE))
        						.addComponent(lbNgayKetThucKM, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(formThongTinLayout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jtTenKM, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        						.addComponent(jNgayBatDauKM, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        						.addGroup(formThongTinLayout.createSequentialGroup()
        							.addComponent(jtMaKM, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
        							.addGap(0, 0, Short.MAX_VALUE))
        						.addComponent(jNgayKetThucKM, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
        						.addComponent(jtChietKhau, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE))))
        			.addGap(23))
        );
        formThongTinLayout.setVerticalGroup(
        	formThongTinLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(formThongTinLayout.createSequentialGroup()
        			.addGap(11)
        			.addGroup(formThongTinLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lbMaKM)
        				.addComponent(jtMaKM, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
        			.addGap(20)
        			.addGroup(formThongTinLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lbTenKM)
        				.addComponent(jtTenKM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        			.addGap(20)
        			.addGroup(formThongTinLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jtChietKhau, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbChietKhau))
        			.addGap(20)
        			.addGroup(formThongTinLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jNgayBatDauKM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbNgayBatDauKM, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
        			.addGap(18)
        			.addGroup(formThongTinLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jNgayKetThucKM, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addComponent(lbNgayKetThucKM))
        			.addGap(65)
        			.addGroup(formThongTinLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(btnLocTheoNgay, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
        				.addComponent(btnTraCuu, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(btnXoaTrang, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(448, Short.MAX_VALUE))
        );
        formThongTin.setLayout(formThongTinLayout);

        GroupLayout layout = new GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, layout.createSequentialGroup()
        			.addComponent(jScrollPane1, GroupLayout.DEFAULT_SIZE, 1029, Short.MAX_VALUE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(formThongTin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 896, GroupLayout.PREFERRED_SIZE)
        				.addComponent(formThongTin, GroupLayout.PREFERRED_SIZE, 580, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(24, Short.MAX_VALUE))
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents

    private void btnTraCuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTraCuuActionPerformed
        // TODO add your handling code here:
        String tieuChi = jtMaKM.getText().trim();
        if (!tieuChi.isEmpty()) {
            KhuyenMai khuyenMai = khuyenMaiDao.getKhuyenMaiByMa(tieuChi);
            if (khuyenMai != null) {
                List<KhuyenMai> list = new ArrayList<>();
                list.add(khuyenMai);
                addDataTable(list);
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy khuyến mãi với mã này", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Chưa nhập tiêu chí tìm kiếm", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_btnTraCuuActionPerformed

    private void jtMaKMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtMaKMActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtMaKMActionPerformed

    private void tableTraCuuKMMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTraCuuKMMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableTraCuuKM.getModel();
    int index = tableTraCuuKM.getSelectedRow();
    if (index < 0) {
        return; // Không có dòng nào được chọn, không cần thực hiện gì cả
    }
    
    // Lấy dữ liệu từ bảng và cập nhật vào các trường dữ liệu
    jtMaKM.setText(model.getValueAt(index, 0).toString());
    jtTenKM.setText(model.getValueAt(index, 1).toString());
    
    // Xử lý dữ liệu cho trường chiết khấu
    double chietKhau = 0.0;
    Object chietKhauObj = model.getValueAt(index, 6);
    if (chietKhauObj instanceof Double) {
        chietKhau = (Double) chietKhauObj;
    } else if (chietKhauObj instanceof String) {
        try {
            chietKhau = Double.parseDouble((String) chietKhauObj);
        } catch (NumberFormatException e) {
            // Xử lý nếu không thể chuyển đổi thành số
            e.printStackTrace();
        }
    }
    jtChietKhau.setText(String.valueOf(chietKhau));
    
    // Xử lý dữ liệu cho trường ngày bắt đầu khuyến mãi
    try {
        jNgayBatDauKM.setDate(formatNgay.parse(model.getValueAt(index, 4).toString()));
    } catch (ParseException e) {
        e.printStackTrace();
    }
    
    // Xử lý dữ liệu cho trường ngày kết thúc khuyến mãi
    try {
        jNgayKetThucKM.setDate(formatNgay.parse(model.getValueAt(index, 5).toString()));
    } catch (ParseException e) {
        e.printStackTrace();
    }


    }//GEN-LAST:event_tableTraCuuKMMouseClicked

    private void btnLocTheoNgayActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLocTheoNgayActionPerformed
        // Xoá bảng trước khi điền dữ liệu mới
      
        // Lấy ngày bắt đầu và ngày kết thúc từ các JDateChooser
        Date ngayBatDau = jNgayBatDauKM.getDate();
        Date ngayKetThuc = jNgayKetThucKM.getDate();

        // Kiểm tra xem đã chọn đủ thông tin ngày bắt đầu và ngày kết thúc chưa
        if (ngayBatDau == null || ngayKetThuc == null) {
            // Hiển thị thông báo lỗi nếu không chọn đủ thông tin
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đầy đủ ngày bắt đầu và ngày kết thúc.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Chạy truy vấn để lấy danh sách khuyến mãi trong khoảng thời gian từ ngày bắt đầu đến ngày kết thúc
        List<KhuyenMai> danhSachKhuyenMai = null;
        try {
            danhSachKhuyenMai = khuyenMaiDao.getKhuyenMaiByTimeRange(ngayBatDau, ngayKetThuc);
        } catch (Exception ex) {
            // Xử lý nếu có lỗi khi lấy danh sách khuyến mãi
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Đã xảy ra lỗi khi lấy danh sách khuyến mãi.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }
        DefaultTableModel model = (DefaultTableModel) tableTraCuuKM.getModel();
        model.setRowCount(0);

        // Hiển thị danh sách khuyến mãi lên giao diện người dùng
        addDataTable(danhSachKhuyenMai);
    }//GEN-LAST:event_btnLocTheoNgayActionPerformed

    private void jtTenKMActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtTenKMActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jtTenKMActionPerformed

    private void btnXoaTrangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaTrangActionPerformed
        jtMaKM.setText("");
        jtTenKM.setText("");
        jtChietKhau.setText("");
        jNgayBatDauKM.setDate(null);
        jNgayKetThucKM.setDate(null);
    }// GEN-LAST:event_btnXoaTrangActionPerformed


    public void hienThiDanhSachKhuyenMaiTheoTrangThai(String trangThaiCode) {
        List<KhuyenMai> danhSachKhuyenMai = KhuyenMaiDao.layKhuyenMaiTheoTrangThai(emf, trangThaiCode);
        hienThiDanhSachKhuyenMai(danhSachKhuyenMai);
    }

    private void hienThiDanhSachKhuyenMai(List<KhuyenMai> danhSachKhuyenMai) {
        DefaultTableModel model = (DefaultTableModel) tableTraCuuKM.getModel();
        model.setRowCount(0); // Xóa toàn bộ dữ liệu cũ
        Date dateNow = new Date(); // Lấy thời gian hiện tại

        for (KhuyenMai khuyenMai : danhSachKhuyenMai) {
            String trangThai = ""; // Xác định trạng thái
            if (khuyenMai.getThoiGianKetThuc().before(dateNow)) {
                trangThai = "Hết hạn";
            } else if (khuyenMai.getSoLuongVe() == 0) {
                trangThai = "Hết lượt";
            } else if (khuyenMai.isTrangThai()) {
                trangThai = "Đang áp dụng";
            }

            // Thêm dòng mới vào bảng
            model.addRow(new Object[] {
                khuyenMai.getMaKhuyenMai(),
                khuyenMai.getTenKhuyenMai(),
                khuyenMai.getLoaiKhuyenMai(),
                khuyenMai.getSoLuongVe(),
                khuyenMai.getThoiGianBatDau(),
                khuyenMai.getThoiGianKetThuc(),
                khuyenMai.getChietKhau(),
                trangThai
            });
        }
    }

    public void hienThiDanhSachKhuyenMaiSapKetThuc() {
        List<KhuyenMai> danhSachKhuyenMai = new KhuyenMaiDao(emf).getKhuyenMaiSapKetThuc();
        hienThiDanhSachKhuyenMai(danhSachKhuyenMai); // Hiển thị danh sách lên bảng
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLocTheoNgay;
    private javax.swing.JButton btnTraCuu;
    private javax.swing.JButton btnXoaTrang;
    private Form formThongTin;
    private javax.swing.ButtonGroup groupRadio;
    private com.toedter.calendar.JDateChooser jNgayBatDauKM;
    private com.toedter.calendar.JDateChooser jNgayKetThucKM;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtChietKhau;
    private javax.swing.JTextField jtMaKM;
    private javax.swing.JTextField jtTenKM;
    private JLabel lbChietKhau;
    private JLabel lbMaKM;
    private JLabel lbNgayBatDauKM;
    private JLabel lbNgayKetThucKM;
    private JLabel lbTenKM;
    private JTable tableTraCuuKM;
    // End of variables declaration//GEN-END:variables

}
