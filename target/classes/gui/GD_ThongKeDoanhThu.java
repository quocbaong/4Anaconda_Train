/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package gui;

import dao.HoaDonDao;
import dao.KhachHangDao;
import dao.VeDao;
import entity.ChiTietVe;
import entity.Ga;
import entity.HoaDon;
import entity.KhuyenMai;
import entity.Ve;
import jakarta.persistence.EntityManagerFactory;
import swing.ScrollBar;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Set;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

/**
 *
 * @author Asus
 */
public class GD_ThongKeDoanhThu extends javax.swing.JPanel {

	private EntityManagerFactory emf;
	private KhachHangDao khachHangDao;
    private HoaDonDao hoaDonDao;
    private VeDao veDao;
    DateTimeFormatter dinhDangGio = DateTimeFormatter.ofPattern("HH:mm");
	DateTimeFormatter dinhDangNgay = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	public GD_ThongKeDoanhThu(EntityManagerFactory emf) {
		this.emf = emf;
		hoaDonDao = new HoaDonDao(emf);
        khachHangDao = new KhachHangDao(emf);
        veDao = new VeDao(emf);
		initComponents();
		
		table.setShowGrid(false);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 16));
		table.getTableHeader().setPreferredSize(new Dimension(30, 30));
		scroll.setVerticalScrollBar(new ScrollBar());
		((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
		
        
        List<HoaDon> list = hoaDonDao.getAllHoaDon();
        addDataTable(list);
	}
        
	private void addDataTable(List<HoaDon> list) {
	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0); // Xóa dữ liệu cũ

	    DecimalFormat dtf = new DecimalFormat("#,##0 VNĐ");

	    for (HoaDon hoaDon : list) {
	        // Tính tổng tiền cho hóa đơn hiện tại
	        double tongTienHoaDon = tinhTongTienTheoHoaDon(hoaDon);

	        // Định dạng tổng tiền
	        String tongTienStr = dtf.format(tongTienHoaDon);

	        // Tạo hàng dữ liệu với tổng tiền
	        
	        Object[] row = {
	            hoaDon.getMaHoaDon(),
	            hoaDon.getNhanVien().getMaNhanVien(),
	            hoaDon.getKhachHang().getCccd(),
	            dinhDangNgay.format(hoaDon.getNgayTao()),
	            dinhDangGio.format(hoaDon.getGioTao()),
	            tongTienStr
	        };
	        model.addRow(row);
	    }
	    model.fireTableDataChanged(); // Cập nhật bảng
	}

//        private double tinhTongTienTheoHoaDon(HoaDon hoaDon) {
//            double tongTien = 0;
//            List<Ve> listVe = hoaDon.getListVes();
//
//            for (Ve ve : listVe) {
//                if (!ve.isTrangThai())
//                    continue;
//
//                Set<ChiTietVe> listChiTietVes = ve.getLisChiTietVes();
//                Ga gaChieuDi = null;
//                Ga gaChieuDen = null;
//
//                for (ChiTietVe ctv : listChiTietVes) {
//                    if (ctv.isChieu())
//                        gaChieuDi = ctv.getGa();
//                    else
//                        gaChieuDen = ctv.getGa();
//                }
//
//                tongTien += ve.getChoNgoi().getGia() * Math.abs(gaChieuDen.getId() - gaChieuDi.getId())
//                        * (ve.getKhuyenMai() == null ? 1 : 1 - ve.getKhuyenMai().getChietKhau());
//            }
//
//            Set<KhuyenMai> listKhuyenMai = hoaDon.getLisKhuyenMais();
//            double km = 0;
//
//            for (KhuyenMai khuyenMai : listKhuyenMai) {
//                km += khuyenMai.getChietKhau();
//            }
//
//            return tongTien * (1 - km);
//        }

	private double tinhTongTienTheoHoaDon(HoaDon hoaDon) {
	    double tongTien = 0;
	    List<Ve> listVe = hoaDon.getListVes();

	    for (Ve ve : listVe) {
	        if (!ve.isTrangThai()) {
	            continue; // Bỏ qua vé không hợp lệ
	        }

	        Set<ChiTietVe> listChiTietVes = ve.getLisChiTietVes();
	        Ga gaChieuDi = null;
	        Ga gaChieuDen = null;

	        // Lấy thông tin ga khởi hành và ga đến
	        for (ChiTietVe ctv : listChiTietVes) {
	            if (ctv.isChieu()) {
	                gaChieuDi = ctv.getGa(); // Gán ga khởi hành
	            } else {
	                gaChieuDen = ctv.getGa(); // Gán ga đến
	            }
	        }

	        // Kiểm tra xem gaChieuDi và gaChieuDen có khác null không
	        if (gaChieuDi != null && gaChieuDen != null) {
	            // Tính tiền vé nếu cả hai ga đều hợp lệ
	            tongTien += ve.getChoNgoi().getGia() * Math.abs(gaChieuDen.getId() - gaChieuDi.getId())
	                    * (ve.getKhuyenMai() == null ? 1 : 1 - ve.getKhuyenMai().getChietKhau());
	        } else {
	            // Xử lý trường hợp gaChieuDi hoặc gaChieuDen là null nếu cần
	            System.err.println("Warning: One of the Ga objects is null for Ve: " + ve);
	        }
	    }

	    Set<KhuyenMai> listKhuyenMai = hoaDon.getLisKhuyenMais();
	    double km = 0;

	    for (KhuyenMai khuyenMai : listKhuyenMai) {
	        km += khuyenMai.getChietKhau();
	    }

	    return tongTien * (1 - km); // Tính tổng tiền sau khuyến mãi
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        scroll = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        chartPanel = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jMonthChooser1 = new com.toedter.calendar.JMonthChooser();
        jYearChooser1 = new com.toedter.calendar.JYearChooser();

        setBackground(new java.awt.Color(43, 84, 100));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("THỐNG KÊ");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin chi tiết", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Doanh thu trong tháng");

        jTextField3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Số hóa đơn trong tháng");

        jTextField4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Hóa đơn trả");

        jTextField5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Vé trả");

        jTextField6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jTextField5, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
                        .addComponent(jTextField3, javax.swing.GroupLayout.Alignment.LEADING))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(107, 107, 107)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextField4)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 198, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField6))
                .addGap(0, 69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông Tin Hóa Đơn", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        jPanel2.setLayout(new java.awt.BorderLayout());

        table.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
        	    new Object [][] {}, // Không có dữ liệu ban đầu
        	    new String [] {"Mã hóa đơn", "Mã nhân viên", "Mã khách hàng", "Ngày tạo", "Giờ tạo", "Tổng tiền"}
        	));
        	table.setRowHeight(30); // Tăng chiều cao dòng để dễ đọc

        table.setGridColor(new java.awt.Color(255, 255, 255));
        table.setRowHeight(30);
        scroll.setViewportView(table);

        jPanel2.add(scroll, java.awt.BorderLayout.CENTER);

        chartPanel.setBackground(new java.awt.Color(255, 255, 255));
        chartPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Doanh thu các ngày trong tháng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 1, 18))); // NOI18N
        chartPanel.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Lọc", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 18))); // NOI18N

        jMonthChooser1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jMonthChooser1MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jMonthChooser1MousePressed(evt);
            }
        });
        jMonthChooser1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jMonthChooser1PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jMonthChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jYearChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, 1133, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGap(15)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        				.addComponent(jPanel1, 0, 0, Short.MAX_VALUE)
        				.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 607, Short.MAX_VALUE))
        			.addGap(18)
        			.addComponent(jPanel2, GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
        			.addContainerGap())
        		.addGroup(layout.createSequentialGroup()
        			.addGap(15)
        			.addComponent(chartPanel, GroupLayout.DEFAULT_SIZE, 1108, Short.MAX_VALUE)
        			.addContainerGap())
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, 320, GroupLayout.PREFERRED_SIZE))
        				.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, 426, GroupLayout.PREFERRED_SIZE))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(chartPanel, GroupLayout.PREFERRED_SIZE, 334, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(26, Short.MAX_VALUE))
        );
        int thangHienTai = LocalDate.now().getMonthValue();
        int namHienTai = LocalDate.now().getYear();
        jMonthChooser1.setMonth(thangHienTai - 1); // Tháng bắt đầu từ 0
        jYearChooser1.setYear(namHienTai);
        updateTableData(namHienTai, thangHienTai);
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents

	private void updateTableData(int nam, int thang) {
	    List<HoaDon> danhSachHoaDon = hoaDonDao.getHoaDonHopLeTheoThang(nam, thang);

	    DefaultTableModel model = (DefaultTableModel) table.getModel();
	    model.setRowCount(0); // Xóa dữ liệu cũ

	    for (HoaDon hoaDon : danhSachHoaDon) {
	        double tongTien = tinhTongTienHoaDon(hoaDon); // Tính tổng tiền của hóa đơn
	        model.addRow(new Object[]{
	            hoaDon.getMaHoaDon(),
	            hoaDon.getNhanVien().getMaNhanVien(),
	            hoaDon.getKhachHang().getCccd(),
	            hoaDon.getNgayTao(),
	            hoaDon.getGioTao(),
	            tongTien // Hiển thị tổng tiền
	        });
	    }
	}

	private double tinhTongTienHoaDon(HoaDon hoaDon) {
	    List<Ve> listVe = hoaDon.getListVes(); // Lấy danh sách vé từ hóa đơn
	    double tongTien = 0;

	    for (Ve ve : listVe) {
	        if (!ve.isTrangThai()) // Bỏ qua vé không hợp lệ
	            continue;

	        Set<ChiTietVe> listChiTietVes = ve.getLisChiTietVes();
	        Ga gaChieuDi = null;
	        Ga gaChieuDen = null;

	        for (ChiTietVe ctv : listChiTietVes) {
	            if (ctv.isChieu())
	                gaChieuDi = ctv.getGa();
	            else
	                gaChieuDen = ctv.getGa();
	        }

	        // Tính tiền nếu cả ga đi và ga đến đều hợp lệ
	        if (gaChieuDi != null && gaChieuDen != null) {
	            tongTien += ve.getChoNgoi().getGia() * Math.abs(gaChieuDen.getId() - gaChieuDi.getId()) 
	                    * (ve.getKhuyenMai() == null ? 1 : 1 - ve.getKhuyenMai().getChietKhau());
	        }
	    }

	    // Tính khuyến mãi toàn hóa đơn
	    Set<KhuyenMai> listKhuyenMai = hoaDon.getLisKhuyenMais();
	    double km = 0;
	    for (KhuyenMai khuyenMai : listKhuyenMai) {
	        km += khuyenMai.getChietKhau();
	    }

	    return tongTien * (1 - km);
	}

	
	private void jMonthChooser1MouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jMonthChooser1MouseClicked
		// TODO add your handling code here:
	}// GEN-LAST:event_jMonthChooser1MouseClicked

	private void jMonthChooser1MousePressed(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_jMonthChooser1MousePressed
		// TODO add your handling code here:
	}// GEN-LAST:event_jMonthChooser1MousePressed

	
	private void jMonthChooser1PropertyChange(java.beans.PropertyChangeEvent evt) {// GEN-FIRST:event_jMonthChooser1PropertyChange
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		double tongDoanhThuTrongNgay = 0;
		int tongHoaDon = 0;
		int tongHoaDonTra = 0;
		int tongVeTra = 0;
		switch (jMonthChooser1.getMonth()+1) {
		case 2:
		case 4:
		case 6:
		case 9:
		case 11:
			for (int i = 1; i <= 30; i++) {
				dataset.setValue(tinhTongTienTheoNgay(LocalDate.of(jYearChooser1.getYear(), jMonthChooser1.getMonth()+1, i)),
						"Tổng tiền", i+ "");
				tongDoanhThuTrongNgay += tinhTongTienTheoNgay(LocalDate.of(jYearChooser1.getYear(), jMonthChooser1.getMonth()+1, i));
				tongHoaDon += ((Long)hoaDonDao.layTongHoaDonTrongThang(jYearChooser1.getYear(), jMonthChooser1.getMonth()+1, i)).intValue()
						+((Long)hoaDonDao.layTongHoaDonTraTrongThang(jYearChooser1.getYear(), jMonthChooser1.getMonth()+1, i)).intValue();
				tongHoaDonTra += ((Long)hoaDonDao.layTongHoaDonTraTrongThang(jYearChooser1.getYear(), jMonthChooser1.getMonth()+1, i)).intValue();
				tongVeTra += ((Long)hoaDonDao.layTongHoaDonTraTrongThang(jYearChooser1.getYear(), jMonthChooser1.getMonth()+1, i)).intValue();
			}
			break;
//			tongVeTra += ((Long)veDao.layTongVeHuyTrongThang(jYearChooser1.getYear(), jMonthChooser1.getMonth()+1, i)).intValue();
		default:
			for (int i = 1; i <= 31; i++) {
				dataset.setValue(tinhTongTienTheoNgay(LocalDate.of(jYearChooser1.getYear(), jMonthChooser1.getMonth()+1, i)),
						"Tổng tiền", i+ "");
				tongDoanhThuTrongNgay += tinhTongTienTheoNgay(LocalDate.of(jYearChooser1.getYear(), jMonthChooser1.getMonth()+1, i));
				tongHoaDon += ((Long)hoaDonDao.layTongHoaDonTrongThang(jYearChooser1.getYear(), jMonthChooser1.getMonth()+1, i)).intValue();
				tongHoaDonTra += ((Long)hoaDonDao.layTongHoaDonTraTrongThang(jYearChooser1.getYear(), jMonthChooser1.getMonth()+1, i)).intValue();
				tongVeTra += ((Long)hoaDonDao.layTongHoaDonTraTrongThang(jYearChooser1.getYear(), jMonthChooser1.getMonth()+1, i)).intValue();
			}
			break;
		}
		
		DecimalFormat dtf = new DecimalFormat("#,##,000 VNĐ");
		if (tongDoanhThuTrongNgay == 0) {
			jTextField3.setText("0 VNĐ");
			jTextField3.setFont(new Font("Consalas", Font.BOLD, 18));
			jTextField3.setEditable(false);
		} else {
			jTextField3.setText(dtf.format(tongDoanhThuTrongNgay));
			jTextField3.setFont(new Font("Consalas", Font.BOLD, 18));
			jTextField3.setEditable(false);
		}
		
		jTextField4.setText(tongHoaDon + "");
		jTextField4.setEditable(false);
		jTextField5.setText(tongHoaDonTra + "");
		jTextField5.setEditable(false);
		jTextField6.setText(tongVeTra + "");
		jTextField6.setEditable(false);
		
		JFreeChart chart = ChartFactory.createBarChart("", "Tháng " + (jMonthChooser1.getMonth()+1),
				"Doanh thu", dataset, PlotOrientation.VERTICAL, false, true, false);

		CategoryPlot categoryPlot = chart.getCategoryPlot();
		categoryPlot.setBackgroundPaint(Color.WHITE);
		categoryPlot.setOutlineVisible(false);
		BarRenderer renderer = (BarRenderer) categoryPlot.getRenderer();
		Color clr3 = new Color(0, 204, 204);
		renderer.setSeriesPaint(0, clr3);

		NumberAxis rangeAxis = (NumberAxis) categoryPlot.getRangeAxis();
		rangeAxis.setRange(0, 5000000);

		ChartPanel barpChartPanel = new ChartPanel(chart);
		chartPanel.removeAll();
		chartPanel.add(barpChartPanel, BorderLayout.CENTER);
		chartPanel.validate();
		 int thang = jMonthChooser1.getMonth() + 1; // Lấy tháng (0-based nên cần +1)
		    int nam = jYearChooser1.getYear(); // Lấy năm
		    updateTableData(nam, thang); // Cập nhật dữ liệu bảng
	}// GEN-LAST:event_jMonthChooser1PropertyChange
//	
//	public double tinhTongTienTheoNgay(LocalDate ngay) {
//        List<HoaDon> lhd = hoaDonDao.getAllHoaDonTrue();
//        double tongTienTheoNgay = 0;
//
//        for (HoaDon hoaDon : lhd) {
//            // Convert the creation date of the invoice to LocalDate
//            LocalDate ngayTaoHoaDon = hoaDon.getNgayTao();
//
//            if (ngayTaoHoaDon.equals(ngay)) {
//                List<Ve> listVe = hoaDon.getListVes();
//                double tongTien = 0;
//                for (Ve ve : listVe) {
//                    if (!ve.isTrangThai())
//                        continue;
//                    Set<ChiTietVe> listChiTietVes = ve.getLisChiTietVes();
//                    Ga gaChieuDi = null;
//                    Ga gaChieuDen = null;
//                    for (ChiTietVe ctv : listChiTietVes) {
//                        if (ctv.isChieu())
//                            gaChieuDi = ctv.getGa();
//                        else
//                            gaChieuDen = ctv.getGa();
//                    }
//                    tongTien += ve.getChoNgoi().getGia() * Math.abs(gaChieuDen.getId() - gaChieuDi.getId())
//                            * (ve.getKhuyenMai() == null ? 1 : 1 - ve.getKhuyenMai().getChietKhau());
//                }
//                Set<KhuyenMai> listKhuyenMai = hoaDon.getLisKhuyenMais();
//                double km = 0;
//                for (KhuyenMai khuyenMai : listKhuyenMai) {
//                    km += khuyenMai.getChietKhau();
//                }
//                tongTienTheoNgay += (tongTien * (1 - km));
//            }
//        }
//        return tongTienTheoNgay;
//    }

//	public double tinhTongTienTheoNgay(LocalDate ngay) {
//        List<HoaDon> lhd = hoaDonDao.getAllHoaDonTrue();
//        double tongTienTheoNgay = 0;
//
//        for (HoaDon hoaDon : lhd) {
//            // Convert the creation date of the invoice to LocalDate
//            LocalDate ngayTaoHoaDon = hoaDon.getNgayTao();
//
//            if (ngayTaoHoaDon.equals(ngay)) {
//                List<Ve> listVe = hoaDon.getListVes();
//                double tongTien = 0;
//                for (Ve ve : listVe) {
//                    if (!ve.isTrangThai())
//                        continue;
//                    Set<ChiTietVe> listChiTietVes = ve.getLisChiTietVes();
//                    Ga gaChieuDi = null;
//                    Ga gaChieuDen = null;
//                    for (ChiTietVe ctv : listChiTietVes) {
//                        if (ctv.isChieu())
//                            gaChieuDi = ctv.getGa();
//                        else
//                            gaChieuDen = ctv.getGa();
//                    }
//                    tongTien += ve.getChoNgoi().getGia() * Math.abs(gaChieuDen.getId() - gaChieuDi.getId())
//                            * (ve.getKhuyenMai() == null ? 1 : 1 - ve.getKhuyenMai().getChietKhau());
//                }
//                Set<KhuyenMai> listKhuyenMai = hoaDon.getLisKhuyenMais();
//                double km = 0;
//                for (KhuyenMai khuyenMai : listKhuyenMai) {
//                    km += khuyenMai.getChietKhau();
//                }
//                tongTienTheoNgay += (tongTien * (1 - km));
//            }
//        }
//        return tongTienTheoNgay;
//    }
	public double tinhTongTienTheoNgay(LocalDate ngay) {
	    List<HoaDon> lhd = hoaDonDao.getAllHoaDonTrue();
	    double tongTienTheoNgay = 0;

	    for (HoaDon hoaDon : lhd) {
	        // Convert the creation date of the invoice to LocalDate
	        LocalDate ngayTaoHoaDon = hoaDon.getNgayTao();

	        if (ngayTaoHoaDon.equals(ngay)) {
	            List<Ve> listVe = hoaDon.getListVes();
	            double tongTien = 0;
	            for (Ve ve : listVe) {
	                if (!ve.isTrangThai())
	                    continue;
	                Set<ChiTietVe> listChiTietVes = ve.getLisChiTietVes();
	                Ga gaChieuDi = null;
	                Ga gaChieuDen = null;
	                
	                for (ChiTietVe ctv : listChiTietVes) {
	                    if (ctv.isChieu())
	                        gaChieuDi = ctv.getGa();
	                    else
	                        gaChieuDen = ctv.getGa();
	                }
	                
	                // Ensure both gaChieuDi and gaChieuDen are not null before calculating
	                if (gaChieuDi != null && gaChieuDen != null) {
	                    tongTien += ve.getChoNgoi().getGia() * Math.abs(gaChieuDen.getId() - gaChieuDi.getId())
	                            * (ve.getKhuyenMai() == null ? 1 : 1 - ve.getKhuyenMai().getChietKhau());
	                }
	            }
	            
	            Set<KhuyenMai> listKhuyenMai = hoaDon.getLisKhuyenMais();
	            double km = 0;
	            for (KhuyenMai khuyenMai : listKhuyenMai) {
	                km += khuyenMai.getChietKhau();
	            }
	            tongTienTheoNgay += (tongTien * (1 - km));
	        }
	    }
	    return tongTienTheoNgay;
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel chartPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private com.toedter.calendar.JMonthChooser jMonthChooser1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private com.toedter.calendar.JYearChooser jYearChooser1;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
