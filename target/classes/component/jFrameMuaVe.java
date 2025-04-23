
package component;

import java.awt.Color;
import java.awt.Font;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.ChiTietVeDao;
import dao.HoaDonDao;
import dao.KhachHangDao;
import dao.VeDao;
import entity.ChiTietVe;
import entity.Ga;
import entity.HoaDon;
import entity.KhuyenMai;
import entity.Ve;
import jakarta.persistence.EntityManagerFactory;

public class jFrameMuaVe extends javax.swing.JFrame {

	private HoaDon hoadon;
	private HoaDonDao hoaDonDao;
	private KhachHangDao khachHangDao;
	private VeDao veDao;
	private ChiTietVeDao chiTietVeDao;
	private EntityManagerFactory emf;
	private boolean isAddHoaDon;
	private FrameHienThi frameHD;

	public jFrameMuaVe(EntityManagerFactory emf, HoaDon hd) {
		this.hoadon = hd;
		this.emf = emf;
		this.khachHangDao = new KhachHangDao(emf);
		this.veDao = new VeDao(emf);
		this.chiTietVeDao = new ChiTietVeDao(emf);
		this.hoaDonDao = new HoaDonDao(emf);
		this.isAddHoaDon = false;
		initComponents();
		panelGY.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.BLACK, 2), "Giá gợi ý",
				0, HEIGHT, new Font(Font.SANS_SERIF, Font.BOLD, 15) {
				}, Color.BLACK));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(false);
		addLable();
	}

	public boolean isAddHoaDon() {
		return isAddHoaDon;
	}

	public void setAddHoaDon(boolean isAddHoaDon) {
		this.isAddHoaDon = isAddHoaDon;
	}

	public HoaDon getHoadon() {
		return hoadon;
	}

	public void setHoadon(HoaDon hoadon) {
		this.isAddHoaDon = false;
		this.hoadon = hoadon;
		addLable();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        lbCCCD = new javax.swing.JLabel();
        lbHoTen = new javax.swing.JLabel();
        lbSdt = new javax.swing.JLabel();
        lbSLV = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        jtGia = new javax.swing.JTextField();
        btnTreoD = new javax.swing.JButton();
        btnThanhToan = new javax.swing.JButton();
        title = new javax.swing.JLabel();
        ifCccd = new javax.swing.JLabel();
        ifHoTen = new javax.swing.JLabel();
        ifSdt = new javax.swing.JLabel();
        ifSLV = new javax.swing.JLabel();
        ifTongT = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ifTienThoi = new javax.swing.JLabel();
        ifKhuyenMai = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbTienTreo = new javax.swing.JLabel();
        panelGY = new javax.swing.JPanel();
        btn500 = new javax.swing.JButton();
        btn200 = new javax.swing.JButton();
        btn100 = new javax.swing.JButton();
        btn50 = new javax.swing.JButton();
        btn20 = new javax.swing.JButton();
        btn10 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(238, 241, 241));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        lbCCCD.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbCCCD.setText("CCCD:");

        lbHoTen.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbHoTen.setText("Họ tên:");

        lbSdt.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbSdt.setText("Số điện thoại:");

        lbSLV.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbSLV.setText("Số lượng vé:");

        lbTongTien.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbTongTien.setText("Tổng tiền:");

        jtGia.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jtGia.setPreferredSize(new java.awt.Dimension(91, 40));
        jtGia.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtGiaKeyReleased(evt);
            }
        });

        btnTreoD.setBackground(new java.awt.Color(153, 153, 255));
        btnTreoD.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnTreoD.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/up.png"))); // NOI18N
        btnTreoD.setText("Treo đơn");
        btnTreoD.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTreoDMouseClicked(evt);
            }
        });

        btnThanhToan.setBackground(new java.awt.Color(51, 255, 102));
        btnThanhToan.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        btnThanhToan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dollar.png"))); // NOI18N
        btnThanhToan.setText("Thanh toán");
        btnThanhToan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnThanhToanMouseClicked(evt);
            }
        });

        title.setFont(new java.awt.Font("SansSerif", 0, 24)); // NOI18N
        title.setForeground(new java.awt.Color(0, 51, 255));
        title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        title.setText("Xác nhận thông tin mua vé");

        ifCccd.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ifCccd.setText(" ");

        ifHoTen.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ifHoTen.setText(" ");

        ifSdt.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ifSdt.setText(" ");

        ifSLV.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ifSLV.setText(" ");

        ifTongT.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        ifTongT.setText(" ");

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel1.setText("Khuyến mãi:");

        ifTienThoi.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ifTienThoi.setForeground(new java.awt.Color(255, 51, 0));
        ifTienThoi.setText(" ");

        ifKhuyenMai.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        ifKhuyenMai.setText(" ");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        jLabel2.setText("Tiền khách đưa:");

        lbTienTreo.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbTienTreo.setForeground(new java.awt.Color(0, 102, 255));
        lbTienTreo.setText(" ");

        panelGY.setOpaque(false);

        btn500.setBackground(new java.awt.Color(153, 204, 255));
        btn500.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn500.setText("500.000");
        btn500.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn500ActionPerformed(evt);
            }
        });

        btn200.setBackground(new java.awt.Color(153, 204, 255));
        btn200.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn200.setText("200.000");
        btn200.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn200ActionPerformed(evt);
            }
        });

        btn100.setBackground(new java.awt.Color(153, 204, 255));
        btn100.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn100.setText("100.000");
        btn100.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn100ActionPerformed(evt);
            }
        });

        btn50.setBackground(new java.awt.Color(153, 204, 255));
        btn50.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn50.setText("50.000");
        btn50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn50ActionPerformed(evt);
            }
        });

        btn20.setBackground(new java.awt.Color(153, 204, 255));
        btn20.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn20.setText("20.000");
        btn20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn20ActionPerformed(evt);
            }
        });

        btn10.setBackground(new java.awt.Color(153, 204, 255));
        btn10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn10.setText("10.000");
        btn10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn10ActionPerformed(evt);
            }
        });

        btn5.setBackground(new java.awt.Color(153, 204, 255));
        btn5.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btn5.setText("5.000");
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelGYLayout = new javax.swing.GroupLayout(panelGY);
        panelGY.setLayout(panelGYLayout);
        panelGYLayout.setHorizontalGroup(
            panelGYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGYLayout.createSequentialGroup()
                .addGroup(panelGYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelGYLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(panelGYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelGYLayout.createSequentialGroup()
                                .addComponent(btn20, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelGYLayout.createSequentialGroup()
                                .addComponent(btn100, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn50, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelGYLayout.createSequentialGroup()
                                .addComponent(btn500, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn200, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(panelGYLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        panelGYLayout.setVerticalGroup(
            panelGYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelGYLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(panelGYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn500, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn200, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn100, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn50, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelGYLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn10, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnTreoD, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230)
                        .addComponent(btnThanhToan))
                    .addComponent(lbTienTreo)
                    .addComponent(lbCCCD)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbHoTen)
                            .addComponent(lbSdt)
                            .addComponent(lbSLV)
                            .addComponent(lbTongTien)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(73, 73, 73)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ifCccd)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ifTienThoi)
                                    .addComponent(jtGia, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ifKhuyenMai)
                                    .addComponent(ifTongT)
                                    .addComponent(ifSLV)
                                    .addComponent(ifSdt)
                                    .addComponent(ifHoTen))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(panelGY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(title)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCCCD)
                    .addComponent(ifCccd))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbHoTen)
                            .addComponent(ifHoTen))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSdt)
                            .addComponent(ifSdt))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbSLV)
                            .addComponent(ifSLV))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbTongTien)
                            .addComponent(ifTongT))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ifKhuyenMai))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtGia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(panelGY, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(ifTienThoi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 9, Short.MAX_VALUE)
                .addComponent(lbTienTreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTreoD, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

	private void btn10ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn10ActionPerformed
		if (jtGia.getText().equals("")) {
			jtGia.setText("10000");
			ifTienThoi.setText(Math.round((10000 - Integer.parseInt(ifTongT.getText().substring(0, ifTongT.getText().length() - 4))) / 100) * 100 + " VND");
		} else {
			jtGia.setText(Integer.parseInt(jtGia.getText()) + 10000 + "");
		}
		int tienNhap = Integer.parseInt(jtGia.getText());
		int tongTien = Integer.parseInt(ifTongT.getText().substring(0, ifTongT.getText().length() - 4));
		if (tienNhap - tongTien >= 1000) {
			ifTienThoi.setText(Math.round((tienNhap - tongTien) / 100) * 100 + " VND");
		}
	}// GEN-LAST:event_btn10ActionPerformed

	private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn5ActionPerformed
		if (jtGia.getText().equals("")) {
			jtGia.setText("5000");
		} else {
			jtGia.setText(Integer.parseInt(jtGia.getText()) + 5000 + "");
		}
		int tienNhap = Integer.parseInt(jtGia.getText());
		int tongTien = Integer.parseInt(ifTongT.getText().substring(0, ifTongT.getText().length() - 4));
		if (tienNhap - tongTien >= 1000) {
			ifTienThoi.setText(Math.round((tienNhap - tongTien) / 100) * 100 + " VND");
		}
	}// GEN-LAST:event_btn5ActionPerformed

	private void btn20ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn20ActionPerformed
		if (jtGia.getText().equals("")) {
			jtGia.setText("20000");
		} else {
			jtGia.setText(Integer.parseInt(jtGia.getText()) + 20000 + "");
		}
		int tienNhap = Integer.parseInt(jtGia.getText());
		int tongTien = Integer.parseInt(ifTongT.getText().substring(0, ifTongT.getText().length() - 4));
		if (tienNhap - tongTien >= 1000) {
			ifTienThoi.setText(Math.round((tienNhap - tongTien) / 100) * 100 + " VND");
		}
	}// GEN-LAST:event_btn20ActionPerformed

	private void btn50ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn50ActionPerformed
		if (jtGia.getText().equals("")) {
			jtGia.setText("50000");
		} else {
			jtGia.setText(Integer.parseInt(jtGia.getText()) + 50000 + "");
		}
		int tienNhap = Integer.parseInt(jtGia.getText());
		int tongTien = Integer.parseInt(ifTongT.getText().substring(0, ifTongT.getText().length() - 4));
		if (tienNhap - tongTien >= 1000) {
			ifTienThoi.setText(Math.round((tienNhap - tongTien) / 100) * 100 + " VND");
		}
	}// GEN-LAST:event_btn50ActionPerformed

	private void btn100ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn100ActionPerformed
		if (jtGia.getText().equals("")) {
			jtGia.setText("100000");
		} else {
			jtGia.setText(Integer.parseInt(jtGia.getText()) + 100000 + "");
		}
		int tienNhap = Integer.parseInt(jtGia.getText());
		int tongTien = Integer.parseInt(ifTongT.getText().substring(0, ifTongT.getText().length() - 4));
		if (tienNhap - tongTien >= 1000) {
			ifTienThoi.setText(Math.round((tienNhap - tongTien) / 100) * 100 + " VND");
		}
	}// GEN-LAST:event_btn100ActionPerformed

	private void btn200ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn200ActionPerformed
		if (jtGia.getText().equals("")) {
			jtGia.setText("200000");
		} else {
			jtGia.setText(Integer.parseInt(jtGia.getText()) + 200000 + "");
		}
		int tienNhap = Integer.parseInt(jtGia.getText());
		int tongTien = Integer.parseInt(ifTongT.getText().substring(0, ifTongT.getText().length() - 4));
		if (tienNhap - tongTien >= 1000) {
			ifTienThoi.setText(Math.round((tienNhap - tongTien) / 100) * 100 + " VND");
		}
	}// GEN-LAST:event_btn200ActionPerformed

	private void btn500ActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btn500ActionPerformed
		if (jtGia.getText().equals("")) {
			jtGia.setText("500000");
		} else {
			jtGia.setText(Integer.parseInt(jtGia.getText()) + 500000 + "");
		}
		int tienNhap = Integer.parseInt(jtGia.getText());
		int tongTien = Integer.parseInt(ifTongT.getText().substring(0, ifTongT.getText().length() - 4));
		if (tienNhap - tongTien >= 1000) {
			ifTienThoi.setText(Math.round((tienNhap - tongTien) / 100) * 100 + " VND");
		}
	}// GEN-LAST:event_btn500ActionPerformed

	private void jtGiaKeyReleased(java.awt.event.KeyEvent evt) {// GEN-FIRST:event_jtGiaKeyReleased
		try {
			double tienNhap = Double.parseDouble(jtGia.getText());
			double tongTien = Double.parseDouble(ifTongT.getText().substring(0, ifTongT.getText().length() - 4));
			if (tienNhap - tongTien >= 1000) {
				ifTienThoi.setText(Math.round((tienNhap - tongTien) / 100) * 100 + " VND");
			} else {
				ifTienThoi.setText(" ");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Chỉ được nhập số");
		}
	}// GEN-LAST:event_jtGiaKeyReleased

	private void btnTreoDMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnTreoDMouseClicked
		if (!hoadon.isTrangThai()) {
			JOptionPane.showMessageDialog(null, "Hóa đơn không đưuọc phép treo");
			return;
		}
		String tien = jtGia.getText();
		if (tien.equals("")) {
			JOptionPane.showMessageDialog(null, "Chưa nhập số tiền cần thanh toán");
			return;
		}
		try {
			double tienNhap = Double.parseDouble(tien);
			double tongTien = Double.parseDouble(ifTongT.getText().substring(0, ifTongT.getText().length() - 4));
			if (tienNhap - tongTien * 0.2 >= 0) {
				hoadon.setTrangThai(false);
				if (khachHangDao.getKhachHangByCCCD(hoadon.getKhachHang().getCccd()) == null) {
					khachHangDao.addKhachHang(hoadon.getKhachHang());
				}
				hoaDonDao.addHoaDon(hoadon);
				for (Ve v : hoadon.getListVes()) {
					if (khachHangDao.getKhachHangByCCCD(v.getKhachHang().getCccd()) == null) {
						khachHangDao.addKhachHang(v.getKhachHang());
					} else {
						khachHangDao.updateKhachHang(v.getKhachHang());
					}
					veDao.themVe(v);
					for (ChiTietVe ctv : v.getLisChiTietVes()) {
						chiTietVeDao.addChiTietVe(ctv);
					}
				}
				this.isAddHoaDon = true;
				setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Chưa nhập đủ tiền");
				return;
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ô nhập tiền thanh toán không đưuọc nhập dữ liệu gì ngoài số");
			return;
		}
	}// GEN-LAST:event_btnTreoDMouseClicked

	private void btnThanhToanMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_btnThanhToanMouseClicked
		String tien = jtGia.getText();
		if (tien.equals("")) {
			JOptionPane.showMessageDialog(null, "Chưa nhập số tiền thanh toán");
			return;
		}
		try {
			double tienNhap = Double.parseDouble(tien);
			double tongTien = Double.parseDouble(ifTongT.getText().substring(0, ifTongT.getText().length() - 4));
			if (tienNhap - tongTien >= 0) {
				if (hoadon.isTrangThai()) {
					if (khachHangDao.getKhachHangByCCCD(hoadon.getKhachHang().getCccd()) == null) {
						hoadon.getKhachHang().setDoiTuong("Người lớn");
						khachHangDao.addKhachHang(hoadon.getKhachHang());
					}
					hoaDonDao.addHoaDon(hoadon);
					for (Ve v : hoadon.getListVes()) {
						if (khachHangDao.getKhachHangByCCCD(v.getKhachHang().getCccd()) == null) {
							khachHangDao.addKhachHang(v.getKhachHang());
						} else {
							khachHangDao.updateKhachHang(v.getKhachHang());
						}
						veDao.themVe(v);
						for (ChiTietVe ctv : v.getLisChiTietVes()) {
							chiTietVeDao.addChiTietVe(ctv);
						}
					}

				} else {
					hoadon.setTrangThai(true);
					if (khachHangDao.getKhachHangByCCCD(hoadon.getKhachHang().getCccd()) == null) {
						khachHangDao.addKhachHang(hoadon.getKhachHang());
					}
					hoaDonDao.updateHoaDon(hoadon);
					for (Ve v : hoadon.getListVes()) {
						if (khachHangDao.getKhachHangByCCCD(v.getKhachHang().getCccd()) == null) {
							khachHangDao.addKhachHang(v.getKhachHang());
						} else {
							khachHangDao.updateKhachHang(v.getKhachHang());
						}
						if (veDao.layVeBangMa(v.getMaVe()) == null) {
							veDao.themVe(v);
						} else {
							veDao.capNhatVe(v);
						}
						for (ChiTietVe ctv : v.getLisChiTietVes()) {
							chiTietVeDao.addChiTietVe(ctv);
						}
					}
				}
				this.isAddHoaDon = true;
				frameHD = new FrameHienThi(hoadon);
				setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Chưa đủ số tiền");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ô nhập tiền thanh toán không đưuọc nhập dữu liệu gì ngoài số");
			e.printStackTrace();
		}

	}// GEN-LAST:event_btnThanhToanMouseClicked

	private void addLable() {
		ifCccd.setText(hoadon.getKhachHang().getCccd());
		ifHoTen.setText(hoadon.getKhachHang().getHoTen());
		ifSdt.setText(hoadon.getKhachHang().getSdt());
		ifSLV.setText(hoadon.getListVes().size() + "");
		jtGia.setText("");
		ifTienThoi.setText(" ");

		double tongTien = 0;
		for (Ve ve : hoadon.getListVes()) {
			Ga gaDi = null;
			Ga gaDen = null;
			for (ChiTietVe ctv : ve.getLisChiTietVes()) {
				if (ctv.isChieu()) {
					gaDi = ctv.getGa();
				} else {
					gaDen = ctv.getGa();
				}
			}
			tongTien += ve.getChoNgoi().getGia() * Math.abs(gaDi.getId() - gaDen.getId())
					* (ve.getKhuyenMai() == null ? 1 : 1 - ve.getKhuyenMai().getChietKhau());
		}
		ifKhuyenMai.setText("Không");
		if (hoadon.getLisKhuyenMais() != null) {
			String temp = "";
			int count = 0;
			for (KhuyenMai km : hoadon.getLisKhuyenMais()) {
				temp += km.getTenKhuyenMai();
				tongTien *= km.getChietKhau();
				if (count > 1) {
					temp += ", ";
				}
				count++;
			}
			ifKhuyenMai.setText(temp);
		}
		if (hoadon.isTrangThai()) {
			ifTongT.setText(((int) (tongTien / 1000)) * 1000 + " VND");
			lbTienTreo.setText((((int) (tongTien * 0.2) / 1000)) * 1000 + " VND");
		} else {
			ifTongT.setText(((int) ((tongTien * 0.8) / 1000)) * 1000 + " VND");
			lbTienTreo.setText("");
		}
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn10;
    private javax.swing.JButton btn100;
    private javax.swing.JButton btn20;
    private javax.swing.JButton btn200;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn50;
    private javax.swing.JButton btn500;
    private javax.swing.JButton btnThanhToan;
    private javax.swing.JButton btnTreoD;
    private javax.swing.JLabel ifCccd;
    private javax.swing.JLabel ifHoTen;
    private javax.swing.JLabel ifKhuyenMai;
    private javax.swing.JLabel ifSLV;
    private javax.swing.JLabel ifSdt;
    private javax.swing.JLabel ifTienThoi;
    private javax.swing.JLabel ifTongT;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jtGia;
    private javax.swing.JLabel lbCCCD;
    private javax.swing.JLabel lbHoTen;
    private javax.swing.JLabel lbSLV;
    private javax.swing.JLabel lbSdt;
    private javax.swing.JLabel lbTienTreo;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JPanel panelGY;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
