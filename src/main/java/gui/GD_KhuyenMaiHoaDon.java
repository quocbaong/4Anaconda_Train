
package gui;

import jakarta.persistence.EntityManagerFactory;
import swing.ScrollBar;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.KhuyenMaiDao;
import entity.KhuyenMai;
import entity.NhanVien;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;

public class GD_KhuyenMaiHoaDon extends javax.swing.JPanel {
	private EntityManagerFactory emf;
	private KhuyenMaiDao khuyenMaiDao;
	private SimpleDateFormat dinhDang = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private SimpleDateFormat dinhDangMa = new SimpleDateFormat("ddMMyyyy");
	LocalDate localDate = LocalDate.now();
	Date dateNow = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
	private List<KhuyenMai> list;

	public GD_KhuyenMaiHoaDon(EntityManagerFactory emf) {
		this.emf = emf;
		initComponents();
		formText.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE),
				"Thông tin khuyến mãi", 0, HEIGHT, new Font(Font.SANS_SERIF, Font.BOLD, 20) {
				}, Color.WHITE));
		formTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE),
				"Khuyến mãi trên hóa đơn", 0, HEIGHT, new Font(Font.SANS_SERIF, Font.PLAIN, 14) {
				}, Color.WHITE));
		table.setShowGrid(false);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 16));
		table.getTableHeader().setPreferredSize(new Dimension(30, 30));
		jScrollPane1.setVerticalScrollBar(new ScrollBar());
		((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
		khuyenMaiDao = new KhuyenMaiDao(emf);
		list = khuyenMaiDao.getAllKhuyenMaiHD();
		addDataTable(list);
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formTable = new form.Form();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setPreferredSize(new Dimension(1600, 759));

        table.setFont(new Font("SansSerif", 0, 14)); // NOI18N
        table.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khuyến Mãi", "Tên khuyến mãi", "Số vé khả dụng", "Thời gian áp dụng", "Thời gian kết thúc", "Chiết khấu", "Trạng thái"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table.setGridColor(new Color(255, 255, 255));
        table.setRowHeight(30);
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);
        formText = new form.Form();
        lbMa = new JLabel();
        lbTen = new JLabel();
        lbSoL = new JLabel();
        lbTimeStart = new JLabel();
        lbTimeEnd = new JLabel();
        lbChietK = new JLabel();
        jtMa = new javax.swing.JTextField();
        jtTen = new javax.swing.JTextField();
        jtSoL = new javax.swing.JTextField();
        jDateStart = new com.toedter.calendar.JDateChooser();
        jDateEnd = new com.toedter.calendar.JDateChooser();
        jtChietK = new javax.swing.JTextField();
        
        lbMa.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        lbMa.setForeground(new Color(255, 255, 255));
        lbMa.setText("Mã khuyến mãi");
                
        lbTen.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        lbTen.setForeground(new Color(255, 255, 255));
        lbTen.setText("Tên khuyến mãi");
                        
        lbSoL.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        lbSoL.setForeground(new Color(255, 255, 255));
        lbSoL.setText("Số lượng vé");
                                
        lbTimeStart.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        lbTimeStart.setForeground(new Color(255, 255, 255));
        lbTimeStart.setText("Thời gian áp dụng");
                                        
        lbTimeEnd.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        lbTimeEnd.setForeground(new Color(255, 255, 255));
        lbTimeEnd.setText("Thời gian kết thúc");
                                                
        lbChietK.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        lbChietK.setForeground(new Color(255, 255, 255));
        lbChietK.setText("Chiết khấu");
                                                        
        jtMa.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        jtMa.setBorder(null);
        jtMa.setMinimumSize(new Dimension(64, 40));
        jtMa.setPreferredSize(new Dimension(64, 40));
                                                                
        jtTen.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        jtTen.setBorder(null);
        jtTen.setMinimumSize(new Dimension(64, 40));
        jtTen.setPreferredSize(new Dimension(64, 40));
                                                                        
        jtSoL.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        jtSoL.setBorder(null);
        jtSoL.setMinimumSize(new Dimension(64, 40));
        jtSoL.setPreferredSize(new Dimension(64, 40));
                                                                                
        jDateStart.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        jDateStart.setPreferredSize(new Dimension(88, 40));
        jDateStart.setDateFormatString("dd/MM/yyyy");
                                                                                        
                                                                                                jDateEnd.setFont(new Font("SansSerif", 0, 16)); // NOI18N
                                                                                                jDateEnd.setPreferredSize(new Dimension(88, 40));
                                                                                                jDateEnd.setDateFormatString("dd/MM/yyyy");
                                                                                                
                                                                                                        jtChietK.setFont(new Font("SansSerif", 0, 16)); // NOI18N
                                                                                                        jtChietK.setBorder(null);
                                                                                                        jtChietK.setMinimumSize(new Dimension(64, 40));
                                                                                                        jtChietK.setPreferredSize(new Dimension(64, 40));
                                                                                                        
                                                                                                                GroupLayout formTextLayout = new GroupLayout(formText);
                                                                                                                formText.setLayout(formTextLayout);
                                                                                                                formTextLayout.setHorizontalGroup(
                                                                                                                    formTextLayout.createParallelGroup(Alignment.LEADING)
                                                                                                                    .addGroup(formTextLayout.createSequentialGroup()
                                                                                                                        .addGroup(formTextLayout.createParallelGroup(Alignment.LEADING)
                                                                                                                            .addGroup(formTextLayout.createSequentialGroup()
                                                                                                                                .addGap(24, 24, 24)
                                                                                                                                .addGroup(formTextLayout.createParallelGroup(Alignment.LEADING)
                                                                                                                                    .addComponent(lbTimeEnd)
                                                                                                                                    .addComponent(lbChietK))
                                                                                                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                                                                                                .addGroup(formTextLayout.createParallelGroup(Alignment.LEADING, false)
                                                                                                                                    .addComponent(jDateEnd, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                                                                                                                    .addComponent(jtChietK, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                                                                                            .addGroup(formTextLayout.createSequentialGroup()
                                                                                                                                .addGroup(formTextLayout.createParallelGroup(Alignment.LEADING)
                                                                                                                                    .addGroup(formTextLayout.createSequentialGroup()
                                                                                                                                        .addGap(24, 24, 24)
                                                                                                                                        .addGroup(formTextLayout.createParallelGroup(Alignment.LEADING)
                                                                                                                                            .addComponent(lbTen)
                                                                                                                                            .addComponent(lbSoL)
                                                                                                                                            .addComponent(lbMa))
                                                                                                                                        .addGap(21, 21, 21))
                                                                                                                                    .addGroup(Alignment.TRAILING, formTextLayout.createSequentialGroup()
                                                                                                                                        .addContainerGap()
                                                                                                                                        .addComponent(lbTimeStart)
                                                                                                                                        .addPreferredGap(ComponentPlacement.RELATED)))
                                                                                                                                .addGroup(formTextLayout.createParallelGroup(Alignment.TRAILING, false)
                                                                                                                                    .addComponent(jtSoL, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                                    .addComponent(jtTen, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                                    .addComponent(jtMa, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                                    .addComponent(jDateStart, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE))))
                                                                                                                        .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                                                );
                                                                                                                formTextLayout.setVerticalGroup(
                                                                                                                    formTextLayout.createParallelGroup(Alignment.LEADING)
                                                                                                                    .addGroup(formTextLayout.createSequentialGroup()
                                                                                                                        .addGap(16, 16, 16)
                                                                                                                        .addGroup(formTextLayout.createParallelGroup(Alignment.BASELINE)
                                                                                                                            .addComponent(lbMa)
                                                                                                                            .addComponent(jtMa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                                                                        .addGap(20, 20, 20)
                                                                                                                        .addGroup(formTextLayout.createParallelGroup(Alignment.BASELINE)
                                                                                                                            .addComponent(jtTen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                                            .addComponent(lbTen))
                                                                                                                        .addGap(20, 20, 20)
                                                                                                                        .addGroup(formTextLayout.createParallelGroup(Alignment.BASELINE)
                                                                                                                            .addComponent(jtSoL, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                                            .addComponent(lbSoL))
                                                                                                                        .addGroup(formTextLayout.createParallelGroup(Alignment.LEADING)
                                                                                                                            .addGroup(formTextLayout.createSequentialGroup()
                                                                                                                                .addGap(31, 31, 31)
                                                                                                                                .addComponent(lbTimeStart)
                                                                                                                                .addGap(38, 38, 38)
                                                                                                                                .addComponent(lbTimeEnd))
                                                                                                                            .addGroup(formTextLayout.createSequentialGroup()
                                                                                                                                .addGap(20, 20, 20)
                                                                                                                                .addComponent(jDateStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                                                .addGap(20, 20, 20)
                                                                                                                                .addComponent(jDateEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                                                                        .addGap(20, 20, 20)
                                                                                                                        .addGroup(formTextLayout.createParallelGroup(Alignment.BASELINE)
                                                                                                                            .addComponent(jtChietK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                                            .addComponent(lbChietK))
                                                                                                                        .addContainerGap(46, Short.MAX_VALUE))
                                                                                                                );
        btnTim = new javax.swing.JButton();
        
                btnTim.setFont(new Font("SansSerif", 1, 20)); // NOI18N
                btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search2.png"))); // NOI18N
                btnTim.setText("Tìm");
                btnTim.setBorder(null);
                btnTim.setBorderPainted(false);
                btnTim.setPreferredSize(new Dimension(75, 55));
                btnTim.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnTimActionPerformed(evt);
                    }
                });
        btnLoc = new javax.swing.JButton();
        
                btnLoc.setFont(new Font("SansSerif", 1, 20)); // NOI18N
                btnLoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/loc.png"))); // NOI18N
                btnLoc.setText("Lọc");
                btnLoc.setBorder(null);
                btnLoc.setBorderPainted(false);
                btnLoc.setPreferredSize(new Dimension(75, 55));
                btnLoc.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnLocActionPerformed(evt);
                    }
                });
        btnXoaT = new javax.swing.JButton();
        
                btnXoaT.setFont(new Font("SansSerif", 1, 20)); // NOI18N
                btnXoaT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tay.png"))); // NOI18N
                btnXoaT.setText("Xóa trắng");
                btnXoaT.setBorder(null);
                btnXoaT.setBorderPainted(false);
                btnXoaT.setPreferredSize(new Dimension(75, 55));
                btnXoaT.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnXoaTActionPerformed(evt);
                    }
                });
        btnTamN = new javax.swing.JButton();
        
                btnTamN.setFont(new Font("SansSerif", 1, 20)); // NOI18N
                btnTamN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pause.png"))); // NOI18N
                btnTamN.setText("Tạm ngưng");
                btnTamN.setBorder(null);
                btnTamN.setBorderPainted(false);
                btnTamN.setPreferredSize(new Dimension(75, 55));
                btnTamN.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnTamNActionPerformed(evt);
                    }
                });
        btnThem = new javax.swing.JButton();
        
                btnThem.setFont(new Font("SansSerif", 1, 20)); // NOI18N
                btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
                btnThem.setText("Thêm");
                btnThem.setBorder(null);
                btnThem.setBorderPainted(false);
                btnThem.setPreferredSize(new Dimension(75, 55));
                btnThem.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnThemActionPerformed(evt);
                    }
                });
        btnCapN = new javax.swing.JButton();
        
                btnCapN.setFont(new Font("SansSerif", 1, 20)); // NOI18N
                btnCapN.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
                btnCapN.setText("Cập nhật");
                btnCapN.setBorder(null);
                btnCapN.setBorderPainted(false);
                btnCapN.setPreferredSize(new Dimension(75, 55));
                btnCapN.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnCapNActionPerformed(evt);
                    }
                });

        GroupLayout formTableLayout = new GroupLayout(formTable);
        formTableLayout.setHorizontalGroup(
        	formTableLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(formTableLayout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 810, GroupLayout.PREFERRED_SIZE)
        			.addGroup(formTableLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(formTableLayout.createSequentialGroup()
        					.addGap(6)
        					.addComponent(formText, GroupLayout.PREFERRED_SIZE, 394, GroupLayout.PREFERRED_SIZE))
        				.addGroup(formTableLayout.createSequentialGroup()
        					.addGap(18)
        					.addGroup(formTableLayout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(btnTamN, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addGroup(formTableLayout.createSequentialGroup()
        							.addComponent(btnCapN, GroupLayout.PREFERRED_SIZE, 162, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(btnXoaT, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        						.addGroup(formTableLayout.createSequentialGroup()
        							.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(btnLoc, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)))))
        			.addGap(55))
        );
        formTableLayout.setVerticalGroup(
        	formTableLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(formTableLayout.createSequentialGroup()
        			.addGap(10)
        			.addGroup(formTableLayout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 853, GroupLayout.PREFERRED_SIZE)
        				.addGroup(formTableLayout.createSequentialGroup()
        					.addComponent(formText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addGap(27)
        					.addGroup(formTableLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnLoc, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(formTableLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnCapN, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnXoaT, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnTamN, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(47, Short.MAX_VALUE))
        );
        formTable.setLayout(formTableLayout);

        GroupLayout layout = new GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(formTable, GroupLayout.PREFERRED_SIZE, 1273, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(327, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(formTable, GroupLayout.PREFERRED_SIZE, 907, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(30, Short.MAX_VALUE))
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents

	private void tableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tableMouseClicked
		selectedRowTable();
	}// GEN-LAST:event_tableMouseClicked

	private void btnXoaTActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaTActionPerformed
		xoaTrang();
	}// GEN-LAST:event_btnXoaTActionPerformed

	private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTimActionPerformed
		String ma = jtMa.getText();
		KhuyenMai khuyenMai = khuyenMaiDao.getKhuyenMaiByMa(ma);
		if (khuyenMai == null) {
			JOptionPane.showMessageDialog(btnTim, "Không tồn tại khuyến mãi", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = 0; i < model.getRowCount(); i++) {
			if (khuyenMai.getMaKhuyenMai().equalsIgnoreCase(model.getValueAt(i, 0).toString())) {
				table.setRowSelectionInterval(i, i);
			}
		}
		selectedRowTable();
	}// GEN-LAST:event_btnTimActionPerformed

	private void btnLocActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnLocActionPerformed
		Date ngayBatDau = jDateStart.getDate();
        Date ngayKetThuc = jDateStart.getDate();

        // Kiểm tra xem đã chọn đủ thông tin ngày bắt đầu và ngày kết thúc chưa
        if (ngayBatDau == null || ngayKetThuc == null) {
            // Hiển thị thông báo lỗi nếu không chọn đủ thông tin
            JOptionPane.showMessageDialog(this, "Vui lòng chọn đầy đủ ngày bắt đầu và ngày kết thúc.", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Chạy truy vấn để lấy danh sách khuyến mãi trong khoảng thời gian từ ngày bắt đầu đến ngày kết thúc
        List<KhuyenMai> danhSachKhuyenMai = null;
        danhSachKhuyenMai = khuyenMaiDao.layDSKhuyenMaiTheoKhoangThoiGian(ngayBatDau, ngayKetThuc,"KMHD");
        addDataTable(danhSachKhuyenMai);
	}// GEN-LAST:event_btnLocActionPerformed

	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemActionPerformed
		int chose = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm khuyến mãi mới không","Xác nhận",JOptionPane.YES_NO_OPTION);
		if(chose != JOptionPane.YES_OPTION) {
			return;
		}
		String ten = jtTen.getText().trim();
		String soL = jtSoL.getText().trim();
		String chietK = jtChietK.getText().trim();
		Date timeEnd = jDateEnd.getDate();
		Date timeStart = jDateStart.getDate();
		KhuyenMai khuyenMai = new KhuyenMai(ten, ten, "KMHD", timeStart, timeEnd, true);
		int check = checkData(khuyenMai, soL, chietK);
		if (check > 0) {
			showMessageValue(check);
			return;
		}
		String numberMa = "KM" + dinhDangMa.format(timeStart).toString();
		List<KhuyenMai> list = khuyenMaiDao.getAllKhuyenMaiByNumber(numberMa);

		String index = (list.size() / 10 > 0) ? "" + (list.size() + 1) : "0" + (list.size() + 1);
		khuyenMai.setMaKhuyenMai(numberMa + index);
		khuyenMai.setSoLuongVe(Integer.parseInt(soL));
		khuyenMai.setChietKhau(Double.parseDouble(chietK));

		khuyenMaiDao.addKhuyenMai(khuyenMai);
		xoaTrang();
		addRowTable(khuyenMai);
	}// GEN-LAST:event_btnThemActionPerformed

	private void btnTamNActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTamNActionPerformed
		int index = table.getSelectedRow();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		if (index < 0) {
			JOptionPane.showMessageDialog(btnTim, "Chưa chọn khuyến mãi", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		String ma = jtMa.getText();
		if (ma.equalsIgnoreCase(""))
			ma = model.getValueAt(index, 0).toString();
		KhuyenMai khuyenMai = khuyenMaiDao.getKhuyenMaiByMa(ma);
		boolean trangThai = khuyenMai.isTrangThai();
		khuyenMai.setTrangThai(!trangThai);
		khuyenMaiDao.updateKhuyenMai(khuyenMai);
		xoaTrang();
		updateDataTable(khuyenMai);
		JOptionPane.showMessageDialog(btnTim, "Đã thay đổi trạng thái khuyến mãi " + khuyenMai.getMaKhuyenMai(),
				"Thông báo", JOptionPane.INFORMATION_MESSAGE);
	}// GEN-LAST:event_btnTamNActionPerformed

	private void btnCapNActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCapNActionPerformed
		int chose = JOptionPane.showConfirmDialog(null, "Bạn có muốn cập nhật khuyến mãi mới không","Xác nhận",JOptionPane.YES_NO_OPTION);
		if(chose != JOptionPane.YES_OPTION) {
			return;
		}
		String ma = jtMa.getText();
		Date timeEnd = jDateEnd.getDate();
		KhuyenMai khuyenMai = khuyenMaiDao.getKhuyenMaiByMa(ma);
		int check = checkDataUpdate(khuyenMai, timeEnd);
		if (check > 0) {
			showMessageValue(check);
			return;
		}
		khuyenMai.setThoiGianKetThuc(timeEnd);
		khuyenMai.setTrangThai(true);
		khuyenMaiDao.updateKhuyenMai(khuyenMai);
		updateDataTable(khuyenMai);
		xoaTrang();
	}// GEN-LAST:event_btnCapNActionPerformed

	private void addRowTable(KhuyenMai khuyenMai) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] { khuyenMai.getMaKhuyenMai(), khuyenMai.getTenKhuyenMai(), khuyenMai.getSoLuongVe(),
				dinhDang.format(khuyenMai.getThoiGianBatDau()).toString(),
				dinhDang.format(khuyenMai.getThoiGianKetThuc()).toString(), khuyenMai.getChietKhau(),
				(khuyenMai.getThoiGianKetThuc().before(dateNow) ? "Hết hạn"
						: khuyenMai.isTrangThai() ? "Đang áp dụng" : "Tạm ngưng") });
	}

	private void updateDataTable(KhuyenMai khuyenMai) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		for (int i = 0; i < table.getRowCount(); i++) {
			String cellValue = table.getValueAt(i, 0).toString();
			if (khuyenMai.getMaKhuyenMai().equalsIgnoreCase(cellValue)) {
				model.setValueAt(dinhDang.format(khuyenMai.getThoiGianKetThuc()).toString(), i, 4);
				model.setValueAt((khuyenMai.getThoiGianKetThuc().before(dateNow) ? "Hết hạn"
						: khuyenMai.isTrangThai() ? "Đang áp dụng" : "Tạm ngưng"), i, 6);
			}
		}
	}

	private int checkData(KhuyenMai khuyenMai, String soL, String trietKhau) {
		if (!khuyenMai.getTenKhuyenMai().matches("^[^!@#$%^&*()]+$")) {
			return 1;
		}
		if (!(Integer.parseInt(soL) > 0)) {
			return 2;
		}
		if (khuyenMai.getThoiGianKetThuc().before(khuyenMai.getThoiGianBatDau())) {
			return 3;
		}
		if (!(Double.parseDouble(trietKhau) > 0 && Double.parseDouble(trietKhau) < 1)) {
			return 4;
		}
		return 0;
	}

	private int checkDataUpdate(KhuyenMai khuyenMai, Date timeEnd) {
		if (!khuyenMai.getTenKhuyenMai().equalsIgnoreCase(jtTen.getText())) {
			return 7;
		}
		if (!dinhDang.format(khuyenMai.getThoiGianBatDau()).toString()
				.equalsIgnoreCase(dinhDang.format(jDateStart.getDate()).toString())) {
			return 7;
		}
		if (!khuyenMai.getThoiGianKetThuc().before(timeEnd)) {
			return 6;
		}
		if (!(khuyenMai.getSoLuongVe() == Integer.parseInt(jtSoL.getText())))
			return 7;
		if (!(khuyenMai.getChietKhau() == Double.parseDouble(jtChietK.getText()))) {
			return 7;
		}
		return 0;
	}

	private void showMessageValue(int check) {
		switch (check) {
		case 1:
			JOptionPane.showMessageDialog(btnThem, "Tên không chứa ký tự đặc biệt", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		case 2:
			JOptionPane.showMessageDialog(btnThem, "Số lượng vé phải là số nguyên dương", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		case 3:
			JOptionPane.showMessageDialog(btnThem, "Ngày áp dụng phải trước ngày kết thúc", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		case 4:
			JOptionPane.showMessageDialog(btnThem, "Chiết khấu phải lớn hơn không và nhỏ hơn 1", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		case 6:
			JOptionPane.showMessageDialog(btnThem, "Ngày kết thúc mới phải sau ngày kết thúc cũ", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		case 7:
			JOptionPane.showMessageDialog(btnThem, "Chỉ được thay đổi trên ngày kết thúc", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		}
	}

	private void xoaTrang() {
		jtMa.setText("");
		jtMa.setFocusable(true);
		jtTen.setText("");
		jtSoL.setText("");
		jDateEnd.setDate(null);
		jDateStart.setDate(null);
		jtChietK.setText("");
		addDataTable(list);
	}

	private void selectedRowTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int index = table.getSelectedRow();
		if (index < 0) {
			JOptionPane.showMessageDialog(btnTim, "Chưa chọn dòng", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		jtMa.setText(model.getValueAt(index, 0).toString());
		jtMa.setFocusable(false);
		jtTen.setText(model.getValueAt(index, 1).toString());
		jtSoL.setText(model.getValueAt(index, 2).toString());
		try {
			jDateStart.setDate(dinhDang.parse(model.getValueAt(index, 3).toString()));
			jDateEnd.setDate(dinhDang.parse(model.getValueAt(index, 4).toString()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jtChietK.setText(model.getValueAt(index, 5).toString());

	}

	private void addDataTable(List<KhuyenMai> list) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);

		for (KhuyenMai khuyenMai : list) {
			Object[] row = { khuyenMai.getMaKhuyenMai(), khuyenMai.getTenKhuyenMai(), khuyenMai.getSoLuongVe(),
					dinhDang.format(khuyenMai.getThoiGianBatDau()).toString(),
					dinhDang.format(khuyenMai.getThoiGianKetThuc()).toString(), khuyenMai.getChietKhau(),
					(khuyenMai.getThoiGianKetThuc().before(dateNow) ? "Hết hạn"
							: khuyenMai.isTrangThai() ? "Đang áp dụng" : "Tạm ngưng") };

			model.addRow(row);
		}
		model.fireTableDataChanged();
	}

	protected void paintChildren(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		GradientPaint g3 = new GradientPaint(0, 0, Color.decode("#6699CC"), 0, getHeight(), Color.decode("#6699CC"));
		g2.setPaint(g3);
		g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
		super.paintChildren(g);
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCapN;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnTamN;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoaT;
    private form.Form formTable;
    private form.Form formText;
    private com.toedter.calendar.JDateChooser jDateEnd;
    private com.toedter.calendar.JDateChooser jDateStart;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jtChietK;
    private javax.swing.JTextField jtMa;
    private javax.swing.JTextField jtSoL;
    private javax.swing.JTextField jtTen;
    private JLabel lbChietK;
    private JLabel lbMa;
    private JLabel lbSoL;
    private JLabel lbTen;
    private JLabel lbTimeEnd;
    private JLabel lbTimeStart;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
