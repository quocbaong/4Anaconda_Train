package form;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.TuyenDao;
import entity.KhuyenMai;
import entity.Tuyen;
import jakarta.persistence.EntityManagerFactory;
import swing.ScrollBar;

import java.awt.event.ActionEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JDateChooser;

import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class FormTraCuuTuyen extends javax.swing.JPanel {

    private EntityManagerFactory emf;
    private TuyenDao tuyenDao;
    private SimpleDateFormat formatNgay = new SimpleDateFormat("dd-MM-yyyy");
    private LocalDate localDate = LocalDate.now();
    private Date dateNow = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	private JLabel lbDiemDi;
	private JTextField jtDiemDi;
	private JLabel lbDiemDen;
	private JTextField jtDiemDen;
	private JLabel lbThoiGianKhoiHanh;
	private JDateChooser jtThoiGianKhoiHanh;
	private JLabel lbThoiGianDenDuKien;
	private JDateChooser jtThoiGianDenDuKien;
	private Component btnLocTheoTrangThai;

    public FormTraCuuTuyen(EntityManagerFactory emf) {
        this.emf = emf;
        initComponents();
        formThongTin.setBorder(new EmptyBorder(0, 0, 0, 0));
        formThongTin.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE),
                "Thông tin tuyến", 0, HEIGHT, new Font(Font.SANS_SERIF, Font.BOLD, 20) {
        }, Color.WHITE));
        tableTraCuuTuyen.setShowGrid(false);
        tableTraCuuTuyen.setShowHorizontalLines(false);
        tableTraCuuTuyen.setShowVerticalLines(false);
        tableTraCuuTuyen.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 14));
        tableTraCuuTuyen.getTableHeader().setPreferredSize(new Dimension(30, 30));
        jScrollPane1.setVerticalScrollBar(new ScrollBar());
        ((DefaultTableCellRenderer) tableTraCuuTuyen.getTableHeader().getDefaultRenderer())
                .setHorizontalAlignment(JLabel.CENTER);
        tuyenDao = new TuyenDao(emf);
        List<Tuyen> list = tuyenDao.getAllTuyen();
        addDataTable(list);
    }

    private void addDataTable(List<Tuyen> list) {
    	
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupRadio = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableTraCuuTuyen = new javax.swing.JTable();
        formThongTin = new form.Form();
        lbMaTuyen = new javax.swing.JLabel();
        jtMaTuyen = new javax.swing.JTextField();
        lbTenTuyen = new javax.swing.JLabel();
        jtTenTuyen = new javax.swing.JTextField();
        lbDiemDi = new javax.swing.JLabel();
        jtDiemDi = new javax.swing.JTextField();
        lbDiemDen = new javax.swing.JLabel();
        jtDiemDen = new javax.swing.JTextField();
        lbThoiGianKhoiHanh = new javax.swing.JLabel();
        jtThoiGianKhoiHanh = new com.toedter.calendar.JDateChooser();
        lbThoiGianDenDuKien = new javax.swing.JLabel();
        jtThoiGianDenDuKien = new com.toedter.calendar.JDateChooser();
        lbTrangThai = new javax.swing.JLabel();
        jcbTrangThai = new javax.swing.JComboBox<>();
        btnTraCuu = new javax.swing.JButton();
        btnXoaTrang = new javax.swing.JButton();
        btnLoc = new javax.swing.JButton();

        setOpaque(false);
        setPreferredSize(new Dimension(1430, 844));

        tableTraCuuTuyen.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        tableTraCuuTuyen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
            		"Mã tuyến", "Tên tuyến", "Điểm đi", "Điểm đến", "Thời gian khởi hành", "Thời gian đến dự kiến", "Giá vé cơ bản", "Trạng thái"
            }
        ));
        tableTraCuuTuyen.setColumnSelectionAllowed(true);
        tableTraCuuTuyen.setRowHeight(30);
        tableTraCuuTuyen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                try {
					tableTraCuuTuyenMouseClicked(evt);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        jScrollPane1.setViewportView(tableTraCuuTuyen);
        if (tableTraCuuTuyen.getColumnModel().getColumnCount() > 0) {
        	tableTraCuuTuyen.getColumnModel().getColumn(0).setResizable(false);
        	tableTraCuuTuyen.getColumnModel().getColumn(1).setResizable(false);
            tableTraCuuTuyen.getColumnModel().getColumn(2).setResizable(false);
            tableTraCuuTuyen.getColumnModel().getColumn(3).setResizable(false);
            tableTraCuuTuyen.getColumnModel().getColumn(4).setResizable(false);
            tableTraCuuTuyen.getColumnModel().getColumn(5).setResizable(false);
            tableTraCuuTuyen.getColumnModel().getColumn(6).setResizable(false);
            tableTraCuuTuyen.getColumnModel().getColumn(7).setResizable(false);
        }
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);

        for (int i = 0; i < tableTraCuuTuyen.getColumnCount(); i++) {
        	tableTraCuuTuyen.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        int[] columnWidths = {100, 100, 150, 100, 70, 200, 180, 100, 100}; // Mảng chứa kích thước cố định của từng cột
        for (int i = 0; i < columnWidths.length; i++) {
            TableColumn column = tableTraCuuTuyen.getColumnModel().getColumn(i);
            column.setPreferredWidth(columnWidths[i]);
        }

        lbMaTuyen.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbMaTuyen.setForeground(new java.awt.Color(255, 255, 255));
        lbMaTuyen.setText("Mã tuyến");

        jtMaTuyen.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jtMaTuyen.setPreferredSize(new java.awt.Dimension(300, 40));

        lbTenTuyen.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbTenTuyen.setForeground(new java.awt.Color(255, 255, 255));
        lbTenTuyen.setText("Tên tuyến");
        

        lbDiemDi.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbDiemDi.setForeground(new java.awt.Color(255, 255, 255));
        lbDiemDi.setText("Điểm đi");

        jtDiemDi.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jtDiemDi.setMinimumSize(new java.awt.Dimension(64, 30));
        jtDiemDi.setPreferredSize(new java.awt.Dimension(64, 40));
        
        lbDiemDen.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbDiemDen.setForeground(new java.awt.Color(255, 255, 255));
        lbDiemDen.setText("Điểm đến");

        lbDiemDen.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbDiemDen.setMinimumSize(new java.awt.Dimension(64, 30));
        lbDiemDen.setPreferredSize(new java.awt.Dimension(64, 40));
        
        lbThoiGianKhoiHanh.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbThoiGianKhoiHanh.setForeground(new java.awt.Color(255, 255, 255));
        lbThoiGianKhoiHanh.setText("Thời gian khởi hành");

        jtThoiGianKhoiHanh.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jtThoiGianKhoiHanh.setAlignmentX(0.0F);
        jtThoiGianKhoiHanh.setAlignmentY(0.0F);
        jtThoiGianKhoiHanh.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jtThoiGianKhoiHanh.setPreferredSize(new java.awt.Dimension(88, 40));
        jtThoiGianKhoiHanh.setDateFormatString("dd/MM/yyyy");
        
        lbThoiGianDenDuKien.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbThoiGianDenDuKien.setForeground(new java.awt.Color(255, 255, 255));
        lbThoiGianDenDuKien.setText("Thời gian khởi hành");

        jtThoiGianDenDuKien.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 5, 0, 0));
        jtThoiGianDenDuKien.setAlignmentX(0.0F);
        jtThoiGianDenDuKien.setAlignmentY(0.0F);
        jtThoiGianDenDuKien.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jtThoiGianDenDuKien.setPreferredSize(new java.awt.Dimension(88, 40));
        jtThoiGianDenDuKien.setDateFormatString("dd/MM/yyyy");
        
        lbTrangThai.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbTrangThai.setForeground(new java.awt.Color(255, 255, 255));
        lbTrangThai.setText("Trạng thái");

        jcbTrangThai.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jcbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang hoạt động", "Tạm ngừng" }));
        jcbTrangThai.setSelectedItem(null);
        jcbTrangThai.setAutoscrolls(true);
        jcbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTrangThaiActionPerformed(evt);
            }
        });


        btnTraCuu.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnTraCuu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search2.png"))); // NOI18N
        btnTraCuu.setText("Tra Cứu");
        btnTraCuu.setBorder(null);
        btnTraCuu.setBorderPainted(false);
        btnTraCuu.setFocusPainted(false);
        btnTraCuu.setPreferredSize(new java.awt.Dimension(103, 55));
        btnTraCuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraCuuActionPerformed(evt);
            }
        });

        btnXoaTrang.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnXoaTrang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tay.png"))); // NOI18N
        btnXoaTrang.setText("Xóa Trắng");
        btnXoaTrang.setBorder(null);
        btnXoaTrang.setBorderPainted(false);
        btnXoaTrang.setFocusPainted(false);
        btnXoaTrang.setPreferredSize(new java.awt.Dimension(103, 55));
        btnXoaTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaTrangActionPerformed(evt);
            }
        });

        lbTrangThai.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbTrangThai.setForeground(new java.awt.Color(255, 255, 255));
        lbTrangThai.setText("Trạng thái");

        jcbTrangThai.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jcbTrangThai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đang hoạt động", "Tạm ngừng"}));
        jcbTrangThai.setSelectedItem(null);
        jcbTrangThai.setAutoscrolls(true);
        jcbTrangThai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbTrangThaiActionPerformed(evt);
            }
        });

        btnLoc.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnLoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loc.png"))); // NOI18N
        btnLoc.setText("Lọc");
        btnLoc.setBorder(null);
        btnLoc.setBorderPainted(false);
        btnLoc.setFocusPainted(false);
        btnLoc.setPreferredSize(new java.awt.Dimension(103, 55));
        btnLoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLocActionPerformed(evt);
            }
        });

        lbMaTuyen.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbMaTuyen.setForeground(new java.awt.Color(255, 255, 255));
        lbMaTuyen.setText("Mã tuyến");

        jtMaTuyen.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jtMaTuyen.setPreferredSize(new java.awt.Dimension(64, 40));
        jtMaTuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtSDTActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout formThongTinLayout = new javax.swing.GroupLayout(formThongTin);
        formThongTinLayout.setHorizontalGroup(
            formThongTinLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, formThongTinLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(formThongTinLayout.createParallelGroup(Alignment.TRAILING)
                        .addGroup(formThongTinLayout.createParallelGroup(Alignment.LEADING)
                            .addComponent(btnXoaTrang, GroupLayout.PREFERRED_SIZE, 340, GroupLayout.PREFERRED_SIZE)
                            .addGroup(formThongTinLayout.createSequentialGroup()
                                .addComponent(btnLocTheoTrangThai, GroupLayout.PREFERRED_SIZE, 178, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(btnTraCuu, GroupLayout.PREFERRED_SIZE, 156, GroupLayout.PREFERRED_SIZE)))
                        .addGroup(formThongTinLayout.createSequentialGroup()
                            .addGroup(formThongTinLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(lbMaTuyen, GroupLayout.PREFERRED_SIZE, 117, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbTenTuyen)
                                .addComponent(lbDiemDi)
                                .addComponent(lbDiemDen)
                                .addComponent(lbThoiGianKhoiHanh, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
                                .addComponent(lbThoiGianDenDuKien, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(ComponentPlacement.UNRELATED)
                            .addGroup(formThongTinLayout.createParallelGroup(Alignment.LEADING)
                                .addComponent(jtTenTuyen, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                .addComponent(jtThoiGianKhoiHanh, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                .addComponent(jtMaTuyen, GroupLayout.PREFERRED_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtThoiGianDenDuKien, GroupLayout.DEFAULT_SIZE, 225, Short.MAX_VALUE)
                                .addComponent(jtDiemDi, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 225, GroupLayout.PREFERRED_SIZE)
                                .addComponent(jtDiemDen, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 225, GroupLayout.PREFERRED_SIZE))))
                    .addGap(23))
        );
        formThongTinLayout.setVerticalGroup(
            formThongTinLayout.createParallelGroup(Alignment.LEADING)
                .addGroup(formThongTinLayout.createSequentialGroup()
                    .addGap(11)
                    .addGroup(formThongTinLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lbMaTuyen)
                        .addComponent(jtMaTuyen, GroupLayout.PREFERRED_SIZE, 40, GroupLayout.PREFERRED_SIZE))
                    .addGap(20)
                    .addGroup(formThongTinLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lbTenTuyen)
                        .addComponent(jtTenTuyen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(20)
                    .addGroup(formThongTinLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lbDiemDi)
                        .addComponent(jtDiemDi, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(20)
                    .addGroup(formThongTinLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(lbDiemDen)
                        .addComponent(jtDiemDen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                    .addGap(20)
                    .addGroup(formThongTinLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(jtThoiGianKhoiHanh, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbThoiGianKhoiHanh, GroupLayout.PREFERRED_SIZE, 29, GroupLayout.PREFERRED_SIZE))
                    .addGap(18)
                    .addGroup(formThongTinLayout.createParallelGroup(Alignment.LEADING)
                        .addComponent(jtThoiGianDenDuKien, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbThoiGianDenDuKien))
                    .addGap(65)
                    .addGroup(formThongTinLayout.createParallelGroup(Alignment.BASELINE)
                        .addComponent(btnLocTheoTrangThai, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTraCuu, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(btnXoaTrang, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(448, Short.MAX_VALUE))
        );
        formThongTin.setLayout(formThongTinLayout);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
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
    private void jtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtSDTActionPerformed

    private void btnTraCuuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTraCuuActionPerformed                                        
    	String tieuChi = jtMaTuyen.getText().trim();
        if (!tieuChi.isEmpty()) {
            List<Tuyen> list = tuyenDao.layTuyenBangMa(tieuChi);
            if (!list.isEmpty()) {
                addDataTable(list); // Hiển thị các tuyến trong bảng
            } else {
                JOptionPane.showMessageDialog(null, "Không tìm thấy tuyến với mã này", "Thông báo",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Chưa nhập tiêu chí tìm kiếm", "Thông báo",
                    JOptionPane.INFORMATION_MESSAGE);
          }

    	    // Khởi tạo danh sách nhân viên tìm được
    	    List<Tuyen> list = new ArrayList<>();

//    	    // Tìm kiếm theo mã (nếu có)
//    	    if (!ma.isEmpty()) {
//    	        list.addAll(tuyenDao.timKiemTuyen(ma)); // Tìm kiếm theo mã
//    	    }

    	    // Loại bỏ các kết quả trùng lặp
    	    list = list.stream().distinct().collect(Collectors.toList());

    	    // Nếu không tìm thấy kết quả nào
    	    if (list.isEmpty()) {
    	        JOptionPane.showMessageDialog(null, "Không tìm thấy tuyến", "Thông báo",
    	                JOptionPane.INFORMATION_MESSAGE);
    	    } else {
    	        // Thêm dữ liệu vào bảng hiển thị
    	        addDataTable(list);
    	    }

    }// GEN-LAST:event_btnTraCuuActionPerformed

    private void jcbTrangThaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jcbTrangThaiActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jcbTrangThaiActionPerformed

    private void jtMaNVActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jtMaNVActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_jtMaNVActionPerformed

    private void tableTraCuuTuyenMouseClicked(java.awt.event.MouseEvent evt) throws ParseException {// GEN-FIRST:event_tableTraCuuNVMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tableTraCuuTuyen.getModel();
        int index = tableTraCuuTuyen.getSelectedRow();
        if (index < 0) {
            return;
        }
        jtMaTuyen.setText(model.getValueAt(index, 0).toString());
        jtTenTuyen.setText(model.getValueAt(index, 1).toString());
        jtDiemDi.setText(model.getValueAt(index, 2).toString());
        jtDiemDen.setText(model.getValueAt(index, 3).toString());
        jtThoiGianKhoiHanh.setDate(formatNgay.parse(model.getValueAt(index, 4).toString()));
        jtThoiGianDenDuKien.setDate(formatNgay.parse(model.getValueAt(index, 5).toString()));
        jcbTrangThai.setSelectedItem(model.getValueAt(index, 7));
    }// GEN-LAST:event_tableTraCuuNVMouseClicked

    private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLocActionPerformed
        // TODO add your handling code here:
        Object selectedItem = jcbTrangThai.getSelectedItem();
        if (selectedItem != null) {
            String sltTT = selectedItem.toString();
            DefaultTableModel model = (DefaultTableModel) tableTraCuuTuyen.getModel();
            model.setRowCount(0);

            if (!sltTT.equals("Đang hoạt động")) {

                List<Tuyen> l = tuyenDao.getTuyenByTrangThaiForUser(sltTT.equals("Tạm ngừng"));
            } else {
                List<Tuyen> allTuyen = tuyenDao.getAllTuyen();
                addDataTable(allTuyen);
                // Bạn cần điều chỉnh phần này để đảm bảo rằng bạn sử dụng danh sách chính xác
            }
        } else {
            // Xử lý trường hợp giá trị được chọn từ combobox là null
        }

    }// GEN-LAST:event_btnLocActionPerformed

    private void btnXoaTrangActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaTrangActionPerformed
        jtMaTuyen.setText("");
        jtTenTuyen.setText("");
        jtDiemDi.setText("");
        jtDiemDen.setText("");
        jtThoiGianKhoiHanh.setDate(null);
        jtThoiGianDenDuKien.setDate(null);
        jcbTrangThai.setSelectedIndex(0);
        btnLocActionPerformed(evt);

    }// GEN-LAST:event_btnXoaTrangActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnTraCuu;
    private javax.swing.JButton btnXoaTrang;
    private form.Form formThongTin;
    private javax.swing.ButtonGroup groupRadio;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JComboBox<String> jcbTrangThai;
    private javax.swing.JTextField jtTenTuyen;
    private javax.swing.JTextField jtMaTuyen;
    private javax.swing.JLabel lbTenTuyen;
    private javax.swing.JLabel lbMaTuyen;
    private javax.swing.JLabel lbTrangThai;
    private javax.swing.JTable tableTraCuuTuyen;
    // End of variables declaration//GEN-END:variables

}