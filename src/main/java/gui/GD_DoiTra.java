package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import component.FrameShowDoiTra;
import dao.GaDao;
import dao.HoaDonDao;
import dao.KhachHangDao;
import dao.VeDao;
import entity.ChiTietVe;
import entity.Ga;
import entity.HoaDon;
import entity.KhachHang;
import entity.KhuyenMai;
import entity.Ve;
import jakarta.persistence.EntityManagerFactory;
import java.util.Date;
import java.util.HashMap;

import swing.ScrollBar;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GD_DoiTra extends javax.swing.JPanel {
	private HoaDonDao hoaDonDao;
	private KhachHangDao khachHangDao;
	private EntityManagerFactory emf;
	private VeDao veDao;
	private GaDao gaDao;;
	DateTimeFormatter dinhDang2 = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
	DateTimeFormatter dinhDangGio = DateTimeFormatter.ofPattern("HH:mm");
	DateTimeFormatter dinhDangNgay = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	private boolean isClickHD;
	private boolean isClickVe;
	private FrameShowDoiTra frame;

	public GD_DoiTra(EntityManagerFactory emf) {
		initComponents();
		formHoaDon.setBorder(new EmptyBorder(0, 0, 0, 0));
		formHoaDon.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE),
				"Bảng hóa đơn", 0, 0, new Font(Font.SANS_SERIF, Font.PLAIN, 18) {
				}, Color.WHITE));

		formVe.setBorder(new EmptyBorder(0, 0, 0, 0));
		formVe.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Bảng vé", 0, 0,
				new Font(Font.SANS_SERIF, Font.PLAIN, 18) {
				}, Color.WHITE));

		form1.setBorder(new EmptyBorder(0, 0, 0, 0));
		form1.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE),
				"Thông tin hóa đơn", 0, HEIGHT, new Font(Font.SANS_SERIF, Font.PLAIN, 20) {
				}, Color.WHITE));
		form2.setBorder(new EmptyBorder(0, 0, 0, 0));
		form2.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE), "Thông tin vé", 0,
				HEIGHT, new Font(Font.SANS_SERIF, Font.PLAIN, 20) {
				}, Color.WHITE));

		this.isClickHD = false;
		this.isClickVe = false;
		this.emf = emf;
		veDao = new VeDao(emf);
		tableHD.setShowGrid(false);
		tableHD.setShowHorizontalLines(false);
		tableHD.setShowVerticalLines(false);
		tableHD.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 16));
		tableHD.getTableHeader().setPreferredSize(new Dimension(30, 30));
		((DefaultTableCellRenderer) tableHD.getTableHeader().getDefaultRenderer())
				.setHorizontalAlignment(JLabel.CENTER);

		tableVe.setShowGrid(false);
		tableVe.setShowHorizontalLines(false);
		tableVe.setShowVerticalLines(false);
		tableVe.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 14));
		tableVe.getTableHeader().setPreferredSize(new Dimension(30, 30));
		scrollHD.setVerticalScrollBar(new ScrollBar());
		scrollVe.setVerticalScrollBar(new ScrollBar());
		((DefaultTableCellRenderer) tableVe.getTableHeader().getDefaultRenderer())
				.setHorizontalAlignment(JLabel.CENTER);
		btnTimHD.setFont(new Font("SansSerif", 1, 20)); // NOI18N
		btnTimHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search2.png"))); // NOI18N
		btnXoaT.setFont(new Font("SansSerif", 1, 20)); // NOI18N
		btnXoaT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tay.png"))); // NOI18N
		btnTimV.setFont(new Font("SansSerif", 1, 20)); // NOI18N
		btnTimV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search2.png"))); // NOI18N
		btnInHoaDon.setFont(new Font("SansSerif", 1, 20)); // NOI18N
		btnInHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/printer.png"))); // NOI18N
		btnInVe.setFont(new Font("SansSerif", 1, 20)); // NOI18N
		btnInVe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/printer.png"))); // NOI18N
		btnTraHD.setText("Trả tập vé");
		btnTraHD.setFont(new Font("SansSerif", 1, 20)); // NOI18N
		btnTraHD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/document.png"))); // NOI18N
		btnTra.setFont(new Font("SansSerif", 1, 20)); // NOI18N
		btnTra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/paper.png"))); // NOI18N

		renderHoaDon();

	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		formHoaDon = new form.Form();
		scrollHD = new javax.swing.JScrollPane();
		tableHD = new javax.swing.JTable();
		formVe = new form.Form();
		scrollVe = new javax.swing.JScrollPane();
		tableVe = new javax.swing.JTable();
		form1 = new form.Form();
		lbMHD = new JLabel();
		jtMHD = new javax.swing.JTextField();
		lbMNV = new JLabel();
		jtMNV = new javax.swing.JTextField();
		lbCCCCHD = new JLabel();
		jtCCCDHD = new javax.swing.JTextField();
		lbTenHKHD = new JLabel();
		jtTenKHHD = new javax.swing.JTextField();
		lbSDT = new JLabel();
		jtSDT = new javax.swing.JTextField();
		btnTimHD = new javax.swing.JButton();
		btnInHoaDon = new javax.swing.JButton();
		btnTraHD = new javax.swing.JButton();
		form2 = new form.Form();
		lbMV = new JLabel();
		jtMV = new javax.swing.JTextField();
		lbCCCDV = new JLabel();
		jtCCCDV = new javax.swing.JTextField();
		lbGia = new JLabel();
		jtGia = new javax.swing.JTextField();
		jLabel1 = new JLabel();
		jtHoTenVe = new javax.swing.JTextField();
		btnTimV = new javax.swing.JButton();
		btnTra = new javax.swing.JButton();
		btnInVe = new javax.swing.JButton();

		setPreferredSize(new Dimension(1286, 950));

		tableHD.setFont(new Font("SansSerif", 0, 14)); // NOI18N
		tableHD.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null, null, null, null },
						{ null, null, null, null, null, null, null, null, null } },
				new String[] { "Mã hóa đơn", "Mã nhân viên", "CCCD", "Tên khách hàng", "Số điện thoại", "Khuyến mãi",
						"Ngày lập hóa đơn", "Giời lập Hóa đơn", "Tổng tiền" }));
		tableHD.setAlignmentX(0.0F);
		tableHD.setAlignmentY(0.0F);
		tableHD.setGridColor(new Color(255, 255, 255));
		tableHD.setRowHeight(30);
		tableHD.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				tableHDMouseClicked(evt);
			}
		});
		scrollHD.setViewportView(tableHD);

		GroupLayout formHoaDonLayout = new GroupLayout(formHoaDon);
		formHoaDonLayout.setHorizontalGroup(
			formHoaDonLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(formHoaDonLayout.createSequentialGroup()
					.addComponent(scrollHD, GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
					.addContainerGap())
		);
		formHoaDonLayout.setVerticalGroup(
			formHoaDonLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(formHoaDonLayout.createSequentialGroup()
					.addComponent(scrollHD, GroupLayout.PREFERRED_SIZE, 382, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(19, Short.MAX_VALUE))
		);
		formHoaDon.setLayout(formHoaDonLayout);

		tableVe.setFont(new Font("SansSerif", 0, 14)); // NOI18N
		tableVe.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Mã vé", "CCCD", "Tên khách hàng", "Đối tượng", "Ga đi", "Ga đến", "Mã tàu", "Số toa",
				"Vị trí Chổ", "Giờ lên tàu", "Giá" }));
		tableVe.setAlignmentX(0.0F);
		tableVe.setAlignmentY(0.0F);
		tableVe.setGridColor(new Color(255, 255, 255));
		tableVe.setRowHeight(30);
		tableVe.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				tableVeMouseClicked(evt);
			}
		});
		scrollVe.setViewportView(tableVe);
		if (tableVe.getColumnModel().getColumnCount() > 0) {
			tableVe.getColumnModel().getColumn(0).setResizable(false);
			tableVe.getColumnModel().getColumn(1).setResizable(false);
			tableVe.getColumnModel().getColumn(2).setResizable(false);
			tableVe.getColumnModel().getColumn(3).setResizable(false);
			tableVe.getColumnModel().getColumn(4).setResizable(false);
			tableVe.getColumnModel().getColumn(5).setResizable(false);
			tableVe.getColumnModel().getColumn(6).setResizable(false);
			tableVe.getColumnModel().getColumn(7).setResizable(false);
			tableVe.getColumnModel().getColumn(8).setResizable(false);
			tableVe.getColumnModel().getColumn(9).setResizable(false);
			tableVe.getColumnModel().getColumn(10).setResizable(false);
		}

		GroupLayout formVeLayout = new GroupLayout(formVe);
		formVeLayout.setHorizontalGroup(
			formVeLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(formVeLayout.createSequentialGroup()
					.addComponent(scrollVe, GroupLayout.DEFAULT_SIZE, 806, Short.MAX_VALUE)
					.addContainerGap())
		);
		formVeLayout.setVerticalGroup(
			formVeLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(formVeLayout.createSequentialGroup()
					.addComponent(scrollVe, GroupLayout.PREFERRED_SIZE, 363, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(14, Short.MAX_VALUE))
		);
		formVe.setLayout(formVeLayout);

		lbMHD.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		lbMHD.setForeground(new Color(255, 255, 255));
		lbMHD.setText("Mã hóa đơn");

		jtMHD.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		jtMHD.setToolTipText("");
		jtMHD.setAlignmentX(1.0F);
		jtMHD.setAlignmentY(1.0F);
		jtMHD.setPreferredSize(new Dimension(310, 40));

		lbMNV.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		lbMNV.setForeground(new Color(255, 255, 255));
		lbMNV.setText("Mã nhân viên");

		jtMNV.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		jtMNV.setToolTipText("");
		jtMNV.setPreferredSize(new Dimension(64, 40));

		lbCCCCHD.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
		lbCCCCHD.setForeground(new Color(255, 255, 255));
		lbCCCCHD.setText("CCCD");

		jtCCCDHD.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		jtCCCDHD.setToolTipText("");
		jtCCCDHD.setPreferredSize(new Dimension(64, 40));

		lbTenHKHD.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		lbTenHKHD.setForeground(new Color(255, 255, 255));
		lbTenHKHD.setText("Tên khách hàng");

		jtTenKHHD.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		jtTenKHHD.setToolTipText("");
		jtTenKHHD.setPreferredSize(new Dimension(64, 40));

		lbSDT.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		lbSDT.setForeground(new Color(255, 255, 255));
		lbSDT.setText("Số điện thoại");

		jtSDT.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		jtSDT.setToolTipText("");
		jtSDT.setPreferredSize(new Dimension(64, 40));

		btnTimHD.setFont(new Font("SansSerif", 0, 18)); // NOI18N
		btnTimHD.setText("Tìm hóa đơn");
		btnTimHD.setBorder(null);
		btnTimHD.setBorderPainted(false);
		btnTimHD.setMaximumSize(new Dimension(75, 60));
		btnTimHD.setPreferredSize(new Dimension(75, 50));
		btnTimHD.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				btnTimHDMouseClicked(evt);
			}
		});

		btnInHoaDon.setFont(new Font("SansSerif", 0, 18)); // NOI18N
		btnInHoaDon.setText("In Hóa đơn");
		btnInHoaDon.setBorder(null);
		btnInHoaDon.setBorderPainted(false);
		btnInHoaDon.setMaximumSize(new Dimension(75, 60));
		btnInHoaDon.setPreferredSize(new Dimension(75, 50));
		btnInHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				btnInHoaDonMouseClicked(evt);
			}
		});

		btnTraHD.setFont(new Font("SansSerif", 0, 18)); // NOI18N
		btnTraHD.setText("Trả hóa đơn");
		btnTraHD.setBorder(null);
		btnTraHD.setBorderPainted(false);
		btnTraHD.setMaximumSize(new Dimension(75, 60));
		btnTraHD.setPreferredSize(new Dimension(75, 50));
		btnTraHD.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				btnTraHDActionPerformed(evt);
			}
		});
		btnXoaT = new javax.swing.JButton();
		
				btnXoaT.setFont(new Font("SansSerif", 0, 18)); // NOI18N
				btnXoaT.setText("Xóa trắng");
				btnXoaT.setBorder(null);
				btnXoaT.setBorderPainted(false);
				btnXoaT.setMaximumSize(new Dimension(75, 60));
				btnXoaT.setPreferredSize(new Dimension(75, 50));
				btnXoaT.addActionListener(new java.awt.event.ActionListener() {
					public void actionPerformed(java.awt.event.ActionEvent evt) {
						btnXoaTActionPerformed(evt);
					}
				});

		GroupLayout form1Layout = new GroupLayout(form1);
		form1Layout.setHorizontalGroup(
			form1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(form1Layout.createSequentialGroup()
					.addGroup(form1Layout.createParallelGroup(Alignment.LEADING)
						.addGroup(form1Layout.createSequentialGroup()
							.addGap(20)
							.addGroup(form1Layout.createParallelGroup(Alignment.TRAILING)
								.addGroup(form1Layout.createSequentialGroup()
									.addGroup(form1Layout.createParallelGroup(Alignment.LEADING)
										.addComponent(lbMNV)
										.addComponent(lbCCCCHD)
										.addComponent(lbMHD)
										.addComponent(lbSDT))
									.addGap(23))
								.addGroup(form1Layout.createSequentialGroup()
									.addComponent(lbTenHKHD)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(0)
							.addGroup(form1Layout.createParallelGroup(Alignment.LEADING)
								.addComponent(jtMHD, GroupLayout.PREFERRED_SIZE, 220, GroupLayout.PREFERRED_SIZE)
								.addGroup(form1Layout.createParallelGroup(Alignment.LEADING, false)
									.addComponent(jtMNV, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(jtCCCDHD, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(jtTenKHHD, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(jtSDT, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE))))
						.addGroup(form1Layout.createSequentialGroup()
							.addContainerGap()
							.addGroup(form1Layout.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnTimHD, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
								.addComponent(btnInHoaDon, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
							.addGap(18)
							.addGroup(form1Layout.createParallelGroup(Alignment.LEADING, false)
								.addComponent(btnXoaT, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(btnTraHD, GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE))))
					.addGap(39))
		);
		form1Layout.setVerticalGroup(
			form1Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(form1Layout.createSequentialGroup()
					.addGap(8)
					.addGroup(form1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lbMHD)
						.addComponent(jtMHD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(form1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtMNV, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbMNV))
					.addGap(19)
					.addGroup(form1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtCCCDHD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbCCCCHD))
					.addGap(20)
					.addGroup(form1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtTenKHHD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbTenHKHD))
					.addGap(18)
					.addGroup(form1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(jtSDT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lbSDT))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(form1Layout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnTimHD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnXoaT, GroupLayout.PREFERRED_SIZE, 60, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(form1Layout.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnTraHD, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnInHoaDon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
		);
		form1.setLayout(form1Layout);

		lbMV.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
		lbMV.setForeground(new Color(255, 255, 255));
		lbMV.setText("Mã vé");

		jtMV.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		jtMV.setToolTipText("");
		jtMV.setPreferredSize(new Dimension(64, 40));

		lbCCCDV.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
		lbCCCDV.setForeground(new Color(255, 255, 255));
		lbCCCDV.setText("CCCD");

		jtCCCDV.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		jtCCCDV.setToolTipText("");
		jtCCCDV.setPreferredSize(new Dimension(64, 40));

		lbGia.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
		lbGia.setForeground(new Color(255, 255, 255));
		lbGia.setText("Giá");

		jtGia.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		jtGia.setToolTipText("");
		jtGia.setPreferredSize(new Dimension(64, 40));

		jLabel1.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		jLabel1.setForeground(new Color(255, 255, 255));
		jLabel1.setText("Họ tên");

		jtHoTenVe.setFont(new Font("SansSerif", 0, 16)); // NOI18N
		jtHoTenVe.setPreferredSize(new Dimension(71, 40));

		btnTimV.setFont(new Font("SansSerif", 0, 18)); // NOI18N
		btnTimV.setText("Tìm vé");
		btnTimV.setBorder(null);
		btnTimV.setFocusPainted(false);
		btnTimV.setMaximumSize(new Dimension(75, 60));
		btnTimV.setPreferredSize(new Dimension(75, 50));
		btnTimV.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				btnTimVMouseClicked(evt);
			}
		});

		btnTra.setFont(new Font("SansSerif", 0, 18)); // NOI18N
		btnTra.setText("Trả vé");
		btnTra.setBorder(null);
		btnTra.setBorderPainted(false);
		btnTra.setMaximumSize(new Dimension(75, 60));
		btnTra.setPreferredSize(new Dimension(75, 50));
		btnTra.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				btnTraMouseClicked(evt);
			}
		});

		btnInVe.setFont(new Font("SansSerif", 0, 18)); // NOI18N
		btnInVe.setText("In vé");
		btnInVe.setBorder(null);
		btnInVe.setBorderPainted(false);
		btnInVe.setMaximumSize(new Dimension(75, 60));
		btnInVe.setPreferredSize(new Dimension(75, 50));
		btnInVe.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				btnInVeMouseClicked(evt);
			}
		});

		GroupLayout form2Layout = new GroupLayout(form2);
		form2.setLayout(form2Layout);
		form2Layout.setHorizontalGroup(form2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(form2Layout.createSequentialGroup().addGap(20, 20, 20).addGroup(form2Layout
						.createParallelGroup(Alignment.LEADING)
						.addGroup(form2Layout.createSequentialGroup().addGroup(form2Layout
								.createParallelGroup(Alignment.TRAILING).addGroup(form2Layout
										.createParallelGroup(Alignment.LEADING)
										.addGroup(form2Layout
												.createParallelGroup(Alignment.TRAILING)
												.addComponent(jLabel1)
												.addComponent(lbCCCDV, Alignment.LEADING))
										.addComponent(lbGia))
								.addGroup(form2Layout.createSequentialGroup().addComponent(lbMV).addGap(4, 4, 4)))
								.addGap(72, 72, 72)
								.addGroup(form2Layout
										.createParallelGroup(Alignment.LEADING, false)
										.addComponent(jtMV, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jtCCCDV, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(jtHoTenVe, GroupLayout.DEFAULT_SIZE, 220,
												Short.MAX_VALUE)
										.addComponent(jtGia, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(form2Layout.createParallelGroup(Alignment.LEADING, false)
								.addGroup(form2Layout.createSequentialGroup()
										.addComponent(btnInVe, GroupLayout.PREFERRED_SIZE, 172,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)
										.addComponent(btnTra, GroupLayout.DEFAULT_SIZE,
												GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
								.addComponent(btnTimV, GroupLayout.PREFERRED_SIZE, 351,
										GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(11, Short.MAX_VALUE)));
		form2Layout.setVerticalGroup(form2Layout.createParallelGroup(Alignment.LEADING)
				.addGroup(form2Layout.createSequentialGroup().addGap(8, 8, 8)
						.addGroup(form2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jtMV, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(lbMV))
						.addGap(16, 16, 16)
						.addGroup(form2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbCCCDV).addComponent(jtCCCDV, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(16, 16, 16)
						.addGroup(form2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(jtHoTenVe, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(form2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(lbGia).addComponent(jtGia, GroupLayout.PREFERRED_SIZE,
										GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
						.addComponent(btnTimV, GroupLayout.PREFERRED_SIZE, 60,
								GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addGroup(form2Layout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnTra, GroupLayout.PREFERRED_SIZE, 60,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnInVe, GroupLayout.PREFERRED_SIZE, 60,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap()));

		GroupLayout layout = new GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(formVe, 0, 0, Short.MAX_VALUE)
						.addComponent(formHoaDon, GroupLayout.DEFAULT_SIZE, 826, Short.MAX_VALUE))
					.addGap(29)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addComponent(form2, GroupLayout.PREFERRED_SIZE, 414, GroupLayout.PREFERRED_SIZE)
						.addComponent(form1, GroupLayout.PREFERRED_SIZE, 396, GroupLayout.PREFERRED_SIZE))
					.addGap(17))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addGap(0)
					.addGroup(layout.createParallelGroup(Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
							.addComponent(form1, GroupLayout.PREFERRED_SIZE, 449, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(form2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
							.addComponent(formHoaDon, GroupLayout.PREFERRED_SIZE, 421, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(formVe, GroupLayout.PREFERRED_SIZE, 397, GroupLayout.PREFERRED_SIZE)))
					.addGap(114))
		);
		this.setLayout(layout);
	}// </editor-fold>//GEN-END:initComponents

	private void btnInVeMouseClicked(MouseEvent evt) {// GEN-FIRST:event_btnInVeMouseClicked
		
		int index = tableVe.getSelectedRow();
		if (index < 0)
			return;
		if (isClickVe)
			return;
		isClickVe = true;
		int chose = JOptionPane.showConfirmDialog(null, "Bạn có muốn in vé không", "Xác nhận",
				JOptionPane.YES_NO_OPTION);
		if (chose == JOptionPane.YES_OPTION) {
			Ve ve = veDao.layVeBangMa(tableVe.getValueAt(index, 0).toString());
			frame = new FrameShowDoiTra(null, ve);
			frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					isClickHD = false;
				}
			});
			frame.setVisible(true);
		}
	}// GEN-LAST:event_btnInVeMouseClicked

	private void btnInHoaDonMouseClicked(MouseEvent evt) {// GEN-FIRST:event_btnInHoaDonMouseClicked
		
		int index = tableHD.getSelectedRow();
		if (index < 0)
			return;
		if (isClickHD)
			return;
		isClickHD = true;
		int chose = JOptionPane.showConfirmDialog(null, "Bạn có muốn in hóa đơn không", "Xác nhận",
				JOptionPane.YES_NO_OPTION);
		if (chose == JOptionPane.YES_OPTION) {
			HoaDon hd = hoaDonDao.getHoaDonByMa(tableHD.getValueAt(index, 0).toString());
			frame = new FrameShowDoiTra(hd, null);
			frame.addWindowListener(new WindowAdapter() {
				@Override
				public void windowClosed(WindowEvent e) {
					isClickHD = false;
				}
			});
			frame.setVisible(true);
		}

	}// GEN-LAST:event_btnInHoaDonMouseClicked

	private void btnTraHDActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTraHDActionPerformed
		int index = tableHD.getSelectedRow();
		if (index < 0) {
			JOptionPane.showMessageDialog(null, "Chọn hóa đơn cần trả");
			return;
		}
		String maHD = tableHD.getValueAt(index, 0).toString();
		HoaDon hd = hoaDonDao.getHoaDonByMa(maHD);
		int chose = JOptionPane.showConfirmDialog(null, "Bạn có muốn trả tập vé không", "Xác nhận",
				JOptionPane.YES_NO_OPTION);
		if (chose == JOptionPane.YES_OPTION) {
			
			List<Ve> listVe = hd.getListVes();
			double tongTien = 0;
			double tien = 0;
			int count = 0;
			for (Ve ve : listVe) {
				if (!ve.isTrangThai())
					continue;
				tien= traVeHoaDon(ve);
				if(tien == 0)
					count++;
				tongTien += tien;
			}
			Set<KhuyenMai> listKhuyenMai = hd.getLisKhuyenMais();
			double km = 0;
			for (KhuyenMai khuyenMai : listKhuyenMai) {
				km += khuyenMai.getChietKhau();
			}
			km = 1 - km;
			
			if (tongTien == 0) {
				JOptionPane.showMessageDialog(null, "Không thể trả hóa đơn, không có vé để trả");
				return;
			}
			
			if(count != 0) {
				xoaTrangVe();
				hienBangVe(maHD, "");
				JOptionPane.showMessageDialog(null, "Hóa đơn chưa trả hết vé, tiền trả lại: " + (int) (tongTien * km / 1000) * 1000 + "VNĐ" + "\nXem quy định trả vé tại mục 3 phần hỗ trợ");
			}
			else {
				hoaDonDao.capNhatHDTheoTrangThai(hd, false);
				xoaTrangVe();
				xoaTrangHoaDon();
				renderHoaDon();
				JOptionPane.showMessageDialog(null, "Trả hóa đơn thành công, tiền trả lại: " + (int) (tongTien * km / 1000) * 1000 + "VNĐ" + "\nXem quy định trả vé tại mục 3 phần hỗ trợ");
			}
				
			

		}
	}// GEN-LAST:event_btnTraHDActionPerformed

	private void tableHDMouseClicked(MouseEvent evt) {// GEN-FIRST:event_tableHDMouseClicked
		int index = tableHD.getSelectedRow();
		if (index < 0)
			return;

		xoaTrangVe();
		String maHD = tableHD.getValueAt(tableHD.getSelectedRow(), 0).toString();
		HoaDon hd;
		hd = hoaDonDao.getHoaDonByMa(maHD);
		hienHoaDon(hd);
		hienBangVe(maHD, "");
		if (tableVe.getRowCount() > 0)
			tableVe.setRowSelectionInterval(0, 0);
		tableVe.clearSelection();

	}// GEN-LAST:event_tableHDMouseClicked

	private void tableVeMouseClicked(MouseEvent evt) {// GEN-FIRST:event_tableVeMouseClicked
		String maVe = tableVe.getValueAt(tableVe.getSelectedRow(), 0).toString();
		Ve ve;
		ve = veDao.layVeBangMa(maVe);
		hienChiTietVe(ve);

	}// GEN-LAST:event_tableVeMouseClicked

	private void jcbSoToaActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_jcbSoToaActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jcbSoToaActionPerformed

	private void btnXoaTActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaTActionPerformed
		xoaTrangHoaDon();
		xoaTrangVe();

	}// GEN-LAST:event_btnXoaTActionPerformed

	private void btnTimHDMouseClicked(MouseEvent evt) {// GEN-FIRST:event_btnTimHDMouseClicked
		timHoaDon();
	}// GEN-LAST:event_btnTimHDMouseClicked

	private void btnTimVMouseClicked(MouseEvent evt) {// GEN-FIRST:event_btnTimVMouseClicked
		timVe();
	}// GEN-LAST:event_btnTimVMouseClicked

	private void btnTraMouseClicked(MouseEvent evt) {// GEN-FIRST:event_btnTraMouseClicked
		traVe();
	}// GEN-LAST:event_btnTraMouseClicked

	protected void paintChildren(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint g3 = new GradientPaint(0, 0, Color.decode("#6699CC"), 0, getHeight(), Color.decode("#6699CC"));
		g2.setPaint(g3);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
		super.paintChildren(g);
	}

	private void xoaTrangHoaDon() {
		jtMHD.setText("");
		jtMNV.setText("");
		jtCCCDHD.setText("");
		jtTenKHHD.setText("");
		jtSDT.setText("");
		renderHoaDon();
	}

	private void xoaTrangVe() {
		jtMV.setText("");
		jtCCCDV.setText("");
		jtGia.setText("");
		jtHoTenVe.setText("");
		DefaultTableModel model = (DefaultTableModel) tableVe.getModel();
		model.setRowCount(0);
		tableVe.setModel(model);
	}

	private void renderHoaDon() {
		khachHangDao = new KhachHangDao(emf);
		hoaDonDao = new HoaDonDao(emf);
		List<HoaDon> lhd = hoaDonDao.getAllHoaDonTrue();
		DefaultTableModel model = (DefaultTableModel) tableHD.getModel();
		model.setRowCount(0);

		for (HoaDon hoaDon : lhd) {
			KhachHang kh = khachHangDao.getKhachHangByCCCD(hoaDon.getKhachHang().getCccd());
			List<Ve> listVe = hoaDon.getListVes();
			double tongTien = 0;
//			for (Ve ve : listVe) {
//				if (!ve.isTrangThai())
//					continue;
//				Set<ChiTietVe> listChiTietVes = ve.getLisChiTietVes();
//				Ga gaChieuDi = null;
//				Ga gaChieuDen = null;
//				for (ChiTietVe ctv : listChiTietVes) {
//					if (ctv.isChieu())
//						gaChieuDi = ctv.getGa();
//					else
//						gaChieuDen = ctv.getGa();
//				}
//				tongTien += ve.getChoNgoi().getGia() * Math.abs(gaChieuDen.getId() - gaChieuDi.getId())
//						* (ve.getKhuyenMai() == null ? 1 : 1 - ve.getKhuyenMai().getChietKhau());
//			}
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

			    if (gaChieuDi != null && gaChieuDen != null && ve.getChoNgoi() != null) {
			        tongTien += ve.getChoNgoi().getGia() * Math.abs(gaChieuDen.getId() - gaChieuDi.getId())
			                * (ve.getKhuyenMai() == null ? 1 : 1 - ve.getKhuyenMai().getChietKhau());
			    } else {
			        // Xử lý các trường hợp bị null
			        System.out.println("gaChieuDi or gaChieuDen or ChoNgoi is null for ve: " + ve);
			    }
			}

			Set<KhuyenMai> listKhuyenMai = hoaDon.getLisKhuyenMais();
			double km = 0;
			for (KhuyenMai khuyenMai : listKhuyenMai) {
				km += khuyenMai.getChietKhau();
			}
			
			Object[] row = { hoaDon.getMaHoaDon(), hoaDon.getNhanVien().getMaNhanVien(), kh.getCccd(), kh.getHoTen(),
					kh.getSdt(), km, dinhDangNgay.format(hoaDon.getNgayTao()), dinhDangGio.format(hoaDon.getGioTao()),
					(int) (tongTien * (1 - km) / 1000) * 1000};
			model.addRow(row);
		}
		model.fireTableDataChanged();
	}

	private void hienHoaDon(HoaDon hd) {
		jtMHD.setText(hd.getMaHoaDon());
		jtMNV.setText(hd.getNhanVien().getMaNhanVien());
		KhachHang kh = khachHangDao.getKhachHangByCCCD(hd.getKhachHang().getCccd());
		jtCCCDHD.setText(kh.getCccd());
		jtTenKHHD.setText(kh.getHoTen());
		jtSDT.setText(kh.getSdt());
	}

	private void hienChiTietVe(Ve ve) {
		jtMV.setText(ve.getMaVe());
		jtCCCDV.setText(ve.getKhachHang().getCccd());
		jtHoTenVe.setText(ve.getKhachHang().getHoTen());
		Set<ChiTietVe> listChiTietVes = ve.getLisChiTietVes();
		Ga gaChieuDi = null;
		Ga gaChieuDen = null;
		for (ChiTietVe ctv : listChiTietVes) {
			if (ctv.isChieu())
				gaChieuDi = ctv.getGa();
			else
				gaChieuDen = ctv.getGa();
		}
		jtGia.setText((int) (ve.getChoNgoi().getGia() * Math.abs(gaChieuDen.getId() - gaChieuDi.getId())
				* (ve.getKhuyenMai() == null ? 1 : 1 - ve.getKhuyenMai().getChietKhau())) + "");

	}

	private void timHoaDon() {
		String maHD = jtMHD.getText();
		if (maHD.equals("")) {
			JOptionPane.showMessageDialog(null, "Chưa nhập mã hoá đơn", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
		} else {
			HoaDon hoaDon = hoaDonDao.getHoaDonByMa(maHD);
			if (hoaDon != null) {
				DefaultTableModel model = (DefaultTableModel) tableHD.getModel();
				model.setRowCount(0);
				KhachHang kh = khachHangDao.getKhachHangByCCCD(hoaDon.getKhachHang().getCccd());
				List<Ve> listVe = hoaDon.getListVes();
				double tongTien = 0;
				for (Ve ve : listVe) {
					Set<ChiTietVe> listChiTietVes = ve.getLisChiTietVes();
					Ga gaChieuDi = null;
					Ga gaChieuDen = null;
					for (ChiTietVe ctv : listChiTietVes) {
						if (ctv.isChieu())
							gaChieuDi = ctv.getGa();
						else
							gaChieuDen = ctv.getGa();
					}
					tongTien += ve.getChoNgoi().getGia() * Math.abs(gaChieuDen.getId() - gaChieuDi.getId())
							* (ve.getKhuyenMai() == null ? 1 : ve.getKhuyenMai().getChietKhau());
				}
				Set<KhuyenMai> listKhuyenMai = hoaDon.getLisKhuyenMais();
				double km = 0;
				for (KhuyenMai khuyenMai : listKhuyenMai) {
					km += khuyenMai.getChietKhau();

				}
				Object[] row = { hoaDon.getMaHoaDon(), hoaDon.getNhanVien().getMaNhanVien(), kh.getCccd(),
						kh.getHoTen(), kh.getSdt(), (int) km, hoaDon.getNgayTao(), hoaDon.getGioTao(), (int) tongTien };
				model.addRow(row);
				model.fireTableDataChanged();
				hienBangVe(maHD, "");
			} else {
				JOptionPane.showMessageDialog(null, "Mã hóa đơn nhập không có trong hệ thống", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void hienBangVe(String maHD, String maVe) {
		List<Ve> listVe = !maHD.equals("") ? veDao.layDSVeBangMaHD(maHD) : veDao.layDSVeBangMaVe(maVe);
		DefaultTableModel model = (DefaultTableModel) tableVe.getModel();
		model.setRowCount(0);
		for (Ve ve : listVe) {
			KhachHang kh = khachHangDao.getKhachHangByCCCD(ve.getKhachHang().getCccd());
			Set<ChiTietVe> listChiTietVes = ve.getLisChiTietVes();
			Ga gaChieuDi = null;
			Ga gaChieuDen = null;
			for (ChiTietVe ctv : listChiTietVes) {
				if (ctv.isChieu())
					gaChieuDi = ctv.getGa();
				else
					gaChieuDen = ctv.getGa();
			}
			Object[] row = { ve.getMaVe(), kh.getCccd(), kh.getHoTen(), kh.getDoiTuong(), gaChieuDi.getTenGa(),
					gaChieuDen.getTenGa(), ve.getChuyen().getTau().getMaTau(), ve.getChoNgoi().getToa().getViTri(),
					ve.getChoNgoi().getViTri(), dinhDang2.format(ve.getThoiGianLenTau()),
					(int) (ve.getChoNgoi().getGia() * Math.abs(gaChieuDen.getId() - gaChieuDi.getId())
							* (ve.getKhuyenMai() == null ? 1 : 1 - ve.getKhuyenMai().getChietKhau())) };
			model.addRow(row);
		}
		model.fireTableDataChanged();
	}

	private void timVe() {
		String maVe = jtMV.getText();
		if (maVe.equals("")) {
			JOptionPane.showMessageDialog(null, "Chưa nhập mã vé", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			jtMV.requestFocus();
		} else {
			Ve ve = veDao.layVeBangMa(maVe);
			if (ve != null) {
				hienBangVe("", maVe);
				tableVe.setRowSelectionInterval(0, 0);
				hienChiTietVe(ve);
			} else {
				JOptionPane.showMessageDialog(null, "Mã vé nhập không có trong hệ thống", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	private void traVe() {
		if (tableVe.getRowCount() > 0) {
			String maVe = tableVe.getValueAt(tableVe.getSelectedRow(), 0).toString();
			Ve ve = veDao.layVeBangMa(maVe);
			traVe(ve);
		} else {
			JOptionPane.showMessageDialog(null, "Bạn chưa nhập vé để trả", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		}

	}

	private double traVeHoaDon(Ve ve) {
		LocalDateTime ngayDi = ve.getThoiGianLenTau();
		LocalDate timeDate = ngayDi.toLocalDate();

		long tinhTime = ChronoUnit.DAYS.between(LocalDate.now(), ngayDi);
		if (timeDate.isBefore(LocalDate.now())) {
			return 0;
		} else {

			if (tinhTime > 1) {
				Set<ChiTietVe> listChiTietVes = ve.getLisChiTietVes();
				Ga gaChieuDi = null;
				Ga gaChieuDen = null;
				for (ChiTietVe ctv : listChiTietVes) {
					if (ctv.isChieu())
						gaChieuDi = ctv.getGa();
					else
						gaChieuDen = ctv.getGa();
				}

//				tính tổng tiền
				double soTienDuocTra = ve.getChoNgoi().getGia() * Math.abs(gaChieuDen.getId() - gaChieuDi.getId())
						* (ve.getKhuyenMai() == null ? 1 : 1 - ve.getKhuyenMai().getChietKhau());
				if (tinhTime > 3 && tinhTime <= 7) {
					soTienDuocTra = soTienDuocTra * 0.8;
				} else if (tinhTime <= 3) {
					soTienDuocTra = soTienDuocTra * 0.5;
				}
				boolean check = veDao.updateDoiVe(ve.getMaVe(), LocalDateTime.now());
				if (check) {
					return soTienDuocTra;
				} else {
					return 0;
				}

			} else {
				return 0;
			}
		}
	}

	private void traVe(Ve ve) {
		LocalDateTime ngayDi = ve.getThoiGianLenTau();
		LocalDate timeDate = ngayDi.toLocalDate();

		long tinhTime = ChronoUnit.DAYS.between(LocalDate.now(), ngayDi);
		System.out.println(tableHD.getSelectedRow());
		if (timeDate.isBefore(LocalDate.now())) {
			JOptionPane.showMessageDialog(null, "Chuyến tàu này đã khởi hành , trả vé không có hiệu lực", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
		} else {

			if (tinhTime > 1) {
				Set<ChiTietVe> listChiTietVes = ve.getLisChiTietVes();
				Ga gaChieuDi = null;
				Ga gaChieuDen = null;
				for (ChiTietVe ctv : listChiTietVes) {
					if (ctv.isChieu())
						gaChieuDi = ctv.getGa();
					else
						gaChieuDen = ctv.getGa();
				}
//				chi dc tra 80%
				double soTienDuocTra = ve.getChoNgoi().getGia() * Math.abs(gaChieuDen.getId() - gaChieuDi.getId())
						* (ve.getKhuyenMai() == null ? 1 : 1 - ve.getKhuyenMai().getChietKhau());
				if (tinhTime > 3 && tinhTime <= 7) {
					soTienDuocTra = soTienDuocTra * 0.8;
				} else if (tinhTime <= 3) {
					soTienDuocTra = soTienDuocTra * 0.5;
				}
				if(ve.getHoaDon().getLisKhuyenMais() != null) {
					Set<KhuyenMai> listKhuyenMai = ve.getHoaDon().getLisKhuyenMais();
					double km = 0;
					for (KhuyenMai khuyenMai : listKhuyenMai) {
						km += khuyenMai.getChietKhau();
					}
					soTienDuocTra = soTienDuocTra * (1 - km);
				}
				int chose = JOptionPane.showConfirmDialog(null,
						"Số tiền hoàn lại cho khách hàng là " + ((int) soTienDuocTra / 1000) * 1000 + "VNĐ" +" Xem quy định trả vé tại mục 3 phần hỗ trợ", "Xác nhận",
						JOptionPane.YES_NO_OPTION);
				if (chose == JOptionPane.YES_OPTION) {
					boolean check = veDao.updateDoiVe(ve.getMaVe(), LocalDateTime.now());
					if (check) {
						if (tableVe.getRowCount() == 1) {
							hoaDonDao.capNhatHDTheoTrangThai(ve.getHoaDon(), false);
							DefaultTableModel model = (DefaultTableModel) tableHD.getModel();
							model.removeRow(tableHD.getSelectedRow());
							model.fireTableDataChanged();
						}
						DefaultTableModel model = (DefaultTableModel) tableVe.getModel();
						model.removeRow(tableVe.getSelectedRow());
						model.fireTableDataChanged();

					}

				}

			} else {
				JOptionPane.showMessageDialog(null, "Vé không thể trả do sắp đến giờ khởi hành", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton btnInHoaDon;
	private javax.swing.JButton btnInVe;
	private javax.swing.JButton btnTimHD;
	private javax.swing.JButton btnTimV;
	private javax.swing.JButton btnTra;
	private javax.swing.JButton btnTraHD;
	private javax.swing.JButton btnXoaT;
	private form.Form form1;
	private form.Form form2;
	private form.Form formHoaDon;
	private form.Form formVe;
	private JLabel jLabel1;
	private javax.swing.JTextField jtCCCDHD;
	private javax.swing.JTextField jtCCCDV;
	private javax.swing.JTextField jtGia;
	private javax.swing.JTextField jtHoTenVe;
	private javax.swing.JTextField jtMHD;
	private javax.swing.JTextField jtMNV;
	private javax.swing.JTextField jtMV;
	private javax.swing.JTextField jtSDT;
	private javax.swing.JTextField jtTenKHHD;
	private JLabel lbCCCCHD;
	private JLabel lbCCCDV;
	private JLabel lbGia;
	private JLabel lbMHD;
	private JLabel lbMNV;
	private JLabel lbMV;
	private JLabel lbSDT;
	private JLabel lbTenHKHD;
	private javax.swing.JScrollPane scrollHD;
	private javax.swing.JScrollPane scrollVe;
	private javax.swing.JTable tableHD;
	private javax.swing.JTable tableVe;
}
