
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

import static java.awt.image.ImageObserver.HEIGHT;

import java.util.Date;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.KhuyenMaiDao;
import entity.KhuyenMai;
import entity.NhanVien;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;

public class GD_KhuyenMaiTrenKhachHang extends javax.swing.JPanel {

	private EntityManagerFactory emf;
	private KhuyenMaiDao khuyenMaiDao;
	private SimpleDateFormat dinhDang = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
	private SimpleDateFormat dinhDangMa = new SimpleDateFormat("dd-MM-yyyy");
	LocalDate localDate = LocalDate.now();
	Date dateNow = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

	public GD_KhuyenMaiTrenKhachHang(EntityManagerFactory emf) {
		this.emf = emf;
		initComponents();
		formText.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE),
				"Thông tin khuyến mãi", 0, HEIGHT, new Font(Font.SANS_SERIF, Font.BOLD, 20) {
				}, Color.WHITE));                                                                                            
		formTable.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.WHITE),
				"Ưu đãi theo đối tượng", 0, HEIGHT, new Font(Font.SANS_SERIF, Font.PLAIN, 14) {
				}, Color.WHITE));

		table.setShowGrid(false);
		table.setShowHorizontalLines(false);
		table.setShowVerticalLines(false);
		table.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 16));
		table.getTableHeader().setPreferredSize(new Dimension(30, 30));
		((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
		khuyenMaiDao = new KhuyenMaiDao(emf);
		List<String> list = khuyenMaiDao.getAllKhuyenMaiKHLoai();
		jScrollPane1.setVerticalScrollBar(new ScrollBar());
		List<KhuyenMai> listKM = khuyenMaiDao.getAllKhuyenMaiKH();
		DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) jcbDoiT.getModel();
		model.addElement("");

		list.stream().forEach(km -> {
			model.addElement(km);
		});
		jcbDoiT.setModel(model);
		addDataTable(listKM);
		
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        formTable = new form.Form();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();

        setPreferredSize(new Dimension(1254, 736));

        table.setFont(new Font("SansSerif", 0, 14)); // NOI18N
        table.setModel(new DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khuyến mãi", "Tên khuyến mãi", "Đối tượng", "Thời gian áp dụng", "Thời gian kết thúc", "Chiết khấu", "Trạng thái"
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
        jtMa = new javax.swing.JTextField();
        lbTen = new JLabel();
        jtTen = new javax.swing.JTextField();
        lbDoiT = new JLabel();
        jcbDoiT = new JComboBox<>();
        JLabel lbTrangT = new JLabel();
        jcbTrangT = new JComboBox<>();
        lbTimeStart = new JLabel();
        jDateStart = new com.toedter.calendar.JDateChooser();
        lbTimeEnd = new JLabel();
        jDateEnd = new com.toedter.calendar.JDateChooser();
        lbChietK = new JLabel();
        jtChietK = new javax.swing.JTextField();
        
                lbMa.setFont(new Font("SansSerif", 0, 16)); // NOI18N
                lbMa.setForeground(new Color(255, 255, 255));
                lbMa.setText("Mã khuyến mãi");
                
                        jtMa.setFont(new Font("SansSerif", 0, 16)); // NOI18N
                        jtMa.setBorder(null);
                        jtMa.setMinimumSize(new Dimension(64, 64));
                        jtMa.setPreferredSize(new Dimension(91, 40));
                        
                                lbTen.setFont(new Font("SansSerif", 0, 16)); // NOI18N
                                lbTen.setForeground(new Color(255, 255, 255));
                                lbTen.setText("Tên khuyến mãi");
                                
                                        jtTen.setFont(new Font("SansSerif", 0, 16)); // NOI18N
                                        jtTen.setBorder(null);
                                        jtTen.setMinimumSize(new Dimension(64, 64));
                                        jtTen.setPreferredSize(new Dimension(91, 40));
                                        
                                                lbDoiT.setFont(new Font("SansSerif", 0, 16)); // NOI18N
                                                lbDoiT.setForeground(new Color(255, 255, 255));
                                                lbDoiT.setText("Đối tượng");
                                                
                                                        jcbDoiT.setFont(new Font("SansSerif", 0, 16)); // NOI18N
                                                        jcbDoiT.setBorder(null);
                                                        jcbDoiT.setPreferredSize(new Dimension(81, 40));
                                                        
                                                                lbTimeStart.setFont(new Font("SansSerif", 0, 16)); // NOI18N
                                                                lbTimeStart.setForeground(new Color(255, 255, 255));
                                                                lbTimeStart.setText("Thời gian áp dụng");
                                                                
                                                                        jDateStart.setFont(new Font("SansSerif", 0, 16)); // NOI18N
                                                                        jDateStart.setPreferredSize(new Dimension(88, 40));
                                                                        jDateStart.setDateFormatString("dd/MM/yyyy");
                                                                        
                                                                                lbTimeEnd.setFont(new Font("SansSerif", 0, 16)); // NOI18N
                                                                                lbTimeEnd.setForeground(new Color(255, 255, 255));
                                                                                lbTimeEnd.setText("Thời gian kết thúc");
                                                                                
                                                                                        jDateEnd.setFont(new Font("SansSerif", 0, 16)); // NOI18N
                                                                                        jDateEnd.setPreferredSize(new Dimension(88, 40));
                                                                                        jDateEnd.setDateFormatString("dd/MM/yyyy");
                                                                                        
                                                                                                lbChietK.setFont(new Font("SansSerif", 0, 16)); // NOI18N
                                                                                                lbChietK.setForeground(new Color(255, 255, 255));
                                                                                                lbChietK.setText("Chiết khấu");
                                                                                                
                                                                                                        jtChietK.setFont(new Font("SansSerif", 0, 16)); // NOI18N
                                                                                                        jtChietK.setBorder(null);
                                                                                                        jtChietK.setMinimumSize(new Dimension(64, 64));
                                                                                                        jtChietK.setPreferredSize(new Dimension(91, 40));
                                                                                                        
                                                                                                                GroupLayout formTextLayout = new GroupLayout(formText);
                                                                                                                formTextLayout.setHorizontalGroup(
                                                                                                                	formTextLayout.createParallelGroup(Alignment.LEADING)
                                                                                                                		.addGroup(formTextLayout.createSequentialGroup()
                                                                                                                			.addGap(23)
                                                                                                                			.addGroup(formTextLayout.createParallelGroup(Alignment.LEADING)
                                                                                                                				.addGroup(formTextLayout.createSequentialGroup()
                                                                                                                					.addGroup(formTextLayout.createParallelGroup(Alignment.LEADING)
                                                                                                                						.addComponent(lbDoiT)
                                                                                                                						.addComponent(lbTimeStart)
                                                                                                                						.addComponent(lbTimeEnd)
                                                                                                                						.addComponent(lbChietK))
                                                                                                                					.addPreferredGap(ComponentPlacement.RELATED)
                                                                                                                					.addGroup(formTextLayout.createParallelGroup(Alignment.LEADING, false)
                                                                                                                						.addComponent(jDateStart, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                						.addComponent(jcbDoiT, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                						.addComponent(jtTen, GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                                                                                                                						.addComponent(jtMa, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                						.addComponent(jDateEnd, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                                                						.addComponent(jtChietK, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                                                                                				.addComponent(lbTen)
                                                                                                                				.addComponent(lbMa))
                                                                                                                			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                                                                );
                                                                                                                formTextLayout.setVerticalGroup(
                                                                                                                	formTextLayout.createParallelGroup(Alignment.LEADING)
                                                                                                                		.addGroup(formTextLayout.createSequentialGroup()
                                                                                                                			.addGap(16)
                                                                                                                			.addGroup(formTextLayout.createParallelGroup(Alignment.BASELINE)
                                                                                                                				.addComponent(lbMa)
                                                                                                                				.addComponent(jtMa, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                                                                                                			.addGap(20)
                                                                                                                			.addGroup(formTextLayout.createParallelGroup(Alignment.BASELINE)
                                                                                                                				.addComponent(jtTen, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                                				.addComponent(lbTen))
                                                                                                                			.addGap(20)
                                                                                                                			.addGroup(formTextLayout.createParallelGroup(Alignment.BASELINE)
                                                                                                                				.addComponent(jcbDoiT, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                                				.addComponent(lbDoiT))
                                                                                                                			.addGroup(formTextLayout.createParallelGroup(Alignment.LEADING)
                                                                                                                				.addGroup(formTextLayout.createSequentialGroup()
                                                                                                                					.addGap(28)
                                                                                                                					.addComponent(lbTimeStart))
                                                                                                                				.addGroup(formTextLayout.createSequentialGroup()
                                                                                                                					.addGap(18)
                                                                                                                					.addComponent(jDateStart, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                                                                                                			.addGap(28)
                                                                                                                			.addGroup(formTextLayout.createParallelGroup(Alignment.TRAILING)
                                                                                                                				.addGroup(formTextLayout.createSequentialGroup()
                                                                                                                					.addComponent(lbTimeEnd)
                                                                                                                					.addGap(28))
                                                                                                                				.addGroup(formTextLayout.createSequentialGroup()
                                                                                                                					.addComponent(jDateEnd, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                                					.addGap(18)))
                                                                                                                			.addGroup(formTextLayout.createParallelGroup(Alignment.BASELINE)
                                                                                                                				.addComponent(jtChietK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                                                                                                				.addComponent(lbChietK))
                                                                                                                			.addContainerGap(104, Short.MAX_VALUE))
                                                                                                                );
                                                                                                                formText.setLayout(formTextLayout);
                                                                                                                
                                                                                                                        lbMa.getAccessibleContext().setAccessibleName("lbMa");
        btnTim = new javax.swing.JButton();
        
                btnTim.setFont(new Font("SansSerif", 1, 20)); // NOI18N
                btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search2.png"))); // NOI18N
                btnTim.setText("Tìm");
                btnTim.setBorder(null);
                btnTim.setBorderPainted(false);
                btnTim.setPreferredSize(new Dimension(105, 55));
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
                btnLoc.setPreferredSize(new Dimension(96, 55));
                btnLoc.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnLocActionPerformed(evt);
                    }
                });
        btnThem = new javax.swing.JButton();
        
                btnThem.setFont(new Font("SansSerif", 1, 20)); // NOI18N
                btnThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/add.png"))); // NOI18N
                btnThem.setText("Thêm");
                btnThem.setBorder(null);
                btnThem.setBorderPainted(false);
                btnThem.setPreferredSize(new Dimension(96, 55));
                btnThem.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnThemActionPerformed(evt);
                    }
                });
        btnCapNhat = new javax.swing.JButton();
        
                btnCapNhat.setFont(new Font("SansSerif", 1, 20)); // NOI18N
                btnCapNhat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/update.png"))); // NOI18N
                btnCapNhat.setText("Cập nhật");
                btnCapNhat.setBorder(null);
                btnCapNhat.setBorderPainted(false);
                btnCapNhat.setPreferredSize(new Dimension(96, 55));
                btnCapNhat.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnCapNhatActionPerformed(evt);
                    }
                });
        btnXoaT = new javax.swing.JButton();
        
                btnXoaT.setFont(new Font("SansSerif", 1, 20)); // NOI18N
                btnXoaT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/tay.png"))); // NOI18N
                btnXoaT.setText("Xóa trắng");
                btnXoaT.setBorder(null);
                btnXoaT.setBorderPainted(false);
                btnXoaT.setPreferredSize(new Dimension(96, 55));
                btnXoaT.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnXoaTActionPerformed(evt);
                    }
                });
        btnNgung = new javax.swing.JButton();
        
                btnNgung.setFont(new Font("SansSerif", 1, 20)); // NOI18N
                btnNgung.setText("Tạm ngưng");
                btnNgung.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/pause.png"))); // NOI18N
                btnNgung.setBorder(null);
                btnNgung.setBorderPainted(false);
                btnNgung.setPreferredSize(new Dimension(96, 55));
                btnNgung.addActionListener(new java.awt.event.ActionListener() {
                    public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btnNgungActionPerformed(evt);
                    }
                });

        GroupLayout formTableLayout = new GroupLayout(formTable);
        formTableLayout.setHorizontalGroup(
        	formTableLayout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(formTableLayout.createSequentialGroup()
        			.addGap(6)
        			.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 816, GroupLayout.PREFERRED_SIZE)
        			.addGroup(formTableLayout.createParallelGroup(Alignment.LEADING)
        				.addGroup(formTableLayout.createSequentialGroup()
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(formText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        				.addGroup(formTableLayout.createSequentialGroup()
        					.addGap(26)
        					.addGroup(formTableLayout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(btnNgung, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addGroup(Alignment.LEADING, formTableLayout.createSequentialGroup()
        							.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        							.addGap(14)
        							.addComponent(btnLoc, GroupLayout.PREFERRED_SIZE, 108, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(btnThem, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        						.addGroup(formTableLayout.createSequentialGroup()
        							.addComponent(btnXoaT, GroupLayout.PREFERRED_SIZE, 173, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.UNRELATED)
        							.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE)))
        					.addGap(8)))
        			.addGap(139))
        );
        formTableLayout.setVerticalGroup(
        	formTableLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(formTableLayout.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(formTableLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(jScrollPane1, GroupLayout.PREFERRED_SIZE, 856, GroupLayout.PREFERRED_SIZE)
        				.addGroup(formTableLayout.createSequentialGroup()
        					.addComponent(formText, GroupLayout.PREFERRED_SIZE, 411, GroupLayout.PREFERRED_SIZE)
        					.addGap(38)
        					.addGroup(formTableLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnThem, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnTim, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnLoc, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(formTableLayout.createParallelGroup(Alignment.BASELINE)
        						.addComponent(btnXoaT, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnCapNhat, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnNgung, GroupLayout.PREFERRED_SIZE, 65, GroupLayout.PREFERRED_SIZE)))
        			.addGap(20))
        );
        formTable.setLayout(formTableLayout);

        GroupLayout layout = new GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(formTable, GroupLayout.PREFERRED_SIZE, 1232, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(formTable, GroupLayout.PREFERRED_SIZE, 908, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        this.setLayout(layout);
    }// </editor-fold>//GEN-END:initComponents

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
			if (khuyenMai.getMaKhuyenMai().equalsIgnoreCase(model.getValueAt(0, i).toString()))
				table.setRowSelectionInterval(i, i);
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


	private void btnNgungActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnNgungActionPerformed
		String ma = jtMa.getText();
		KhuyenMai khuyenMai = khuyenMaiDao.getKhuyenMaiByMa(ma);
		boolean trangThai = khuyenMai.isTrangThai();
		khuyenMai.setTrangThai(!trangThai);
		khuyenMaiDao.updateKhuyenMai(khuyenMai);
		xoaTrang();
		updateDataTable(khuyenMai);
		JOptionPane.showMessageDialog(btnTim, "Đã thay đổi trạng thái khuyến mãi " + khuyenMai.getMaKhuyenMai(),
				"Thông báo", JOptionPane.INFORMATION_MESSAGE);
	}// GEN-LAST:event_btnNgungActionPerformed

	private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnThemActionPerformed
		int chose = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm khuyến mãi mới không","Xác nhận",JOptionPane.YES_NO_OPTION);
		if(chose != JOptionPane.YES_OPTION) {
			return;
		}
		String ten = jtTen.getText().trim();
		String doiTuong = jcbDoiT.getSelectedItem().toString();
		String chietK = jtChietK.getText().trim();
		Date timeEnd = jDateEnd.getDate();
		Date timeStart = jDateStart.getDate();
		KhuyenMai khuyenMai = new KhuyenMai(ten, ten, doiTuong, timeStart, timeEnd, true);
		int check = checkData(khuyenMai, chietK);
		if (check > 0) {
			showMessageValue(check);
			return;
		}
		String numberMa = "KM" + dinhDangMa.format(timeStart).toString();
		List<KhuyenMai> list = khuyenMaiDao.getAllKhuyenMaiByNumber(numberMa);

		String index = (list.size() / 10 > 0) ? "" + list.size() + 1 : "0" + list.size() + 1;
		khuyenMai.setMaKhuyenMai(numberMa + index);
		khuyenMai.setSoLuongVe(0);
		khuyenMai.setChietKhau(Double.parseDouble(chietK));

		khuyenMaiDao.addKhuyenMai(khuyenMai);
		xoaTrang();
		addRowTable(khuyenMai);
	}// GEN-LAST:event_btnThemActionPerformed

	private void tableMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tableMouseClicked
		selectedRowTable();
	}// GEN-LAST:event_tableMouseClicked

	private void btnXoaTActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnXoaTActionPerformed
		xoaTrang();
	}// GEN-LAST:event_btnXoaTActionPerformed

	private void btnCapNhatActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnCapNhatActionPerformed
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
	}// GEN-LAST:event_btnCapNhatActionPerformed

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

	private void addRowTable(KhuyenMai khuyenMai) {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.addRow(new Object[] { khuyenMai.getMaKhuyenMai(), khuyenMai.getTenKhuyenMai(),
				khuyenMai.getLoaiKhuyenMai(), dinhDang.format(khuyenMai.getThoiGianBatDau()).toString(),
				dinhDang.format(khuyenMai.getThoiGianKetThuc()).toString(), khuyenMai.getChietKhau(),
				(khuyenMai.getThoiGianKetThuc().before(dateNow) ? "Hết hạn"
						: khuyenMai.isTrangThai() ? "Đang áp dụng" : "Tạm ngưng") });
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
		if (!khuyenMai.getLoaiKhuyenMai().equalsIgnoreCase(jcbDoiT.getSelectedItem().toString()))
			return 7;
		if (!(khuyenMai.getChietKhau() == Double.parseDouble(jtChietK.getText()))) {
			return 7;
		}
		return 0;
	}

	private int checkData(KhuyenMai khuyenMai, String trietKhau) {
		if (!khuyenMai.getTenKhuyenMai().matches("^[^!@#$%^&*()]+$")) {
			return 1;
		}
		if (khuyenMai.getThoiGianKetThuc().before(khuyenMai.getThoiGianBatDau())) {
			return 3;
		}
		if (!(Double.parseDouble(trietKhau) > 0 && Double.parseDouble(trietKhau) < 1)) {
			return 4;
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
			JOptionPane.showMessageDialog(btnThem, "", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			break;
		case 4:
			JOptionPane.showMessageDialog(btnThem, "Chiết khấu phải lớn hơn không và nhỏ hơn 1", "Thông báo",
					JOptionPane.INFORMATION_MESSAGE);
			break;
		case 3:
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
		jcbDoiT.setSelectedIndex(0);
		jDateEnd.setDate(null);
		jDateStart.setDate(null);
		jtChietK.setText("");
	}

	private void selectedRowTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		int index = table.getSelectedRow();
		if (index < 0) {
			JOptionPane.showMessageDialog(btnTim, "Chưa chọn tài khoản", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
			return;
		}
		jtMa.setText(model.getValueAt(index, 0).toString());
		jtMa.setFocusable(false);
		jtTen.setText(model.getValueAt(index, 1).toString());
		jcbDoiT.setSelectedItem(model.getValueAt(index, 2));
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
			Object[] row = { khuyenMai.getMaKhuyenMai(), khuyenMai.getTenKhuyenMai(), khuyenMai.getLoaiKhuyenMai(),
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
    private javax.swing.JButton btnCapNhat;
    private javax.swing.JButton btnLoc;
    private javax.swing.JButton btnNgung;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXoaT;
    private form.Form formTable;
    private form.Form formText;
    private com.toedter.calendar.JDateChooser jDateEnd;
    private com.toedter.calendar.JDateChooser jDateStart;
    private javax.swing.JScrollPane jScrollPane1;
    private JComboBox<String> jcbDoiT;
    private JComboBox<String> jcbTrangT;
    private javax.swing.JTextField jtChietK;
    private javax.swing.JTextField jtMa;
    private javax.swing.JTextField jtTen;
    private JLabel lbChietK;
    private JLabel lbDoiT;
    private JLabel lbMa;
    private JLabel lbTen;
    private JLabel lbTimeEnd;
    private JLabel lbTimeStart;
    private javax.swing.JTable table;
}
