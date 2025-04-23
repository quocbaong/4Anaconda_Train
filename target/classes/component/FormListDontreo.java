package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;

import static java.awt.image.ImageObserver.HEIGHT;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import dao.HoaDonDao;
import dao.VeDao;
import entity.HoaDon;
import entity.Ve;
import jakarta.persistence.EntityManagerFactory;
import swing.ScrollBar;

public class FormListDontreo extends javax.swing.JFrame {

    private EntityManagerFactory emf;
    private HoaDonDao hoaDonDao;
    private HoaDon hoaDon;
    private VeDao veDao;
    private List<HoaDon> list;
    private boolean isClick;
    private DefaultTableModel model;

    public FormListDontreo(EntityManagerFactory emf) {
        this.emf = emf;
        this.hoaDonDao = new HoaDonDao(emf);
        this.veDao = new VeDao(emf);
        this.list = hoaDonDao.layHoaDonTam();
        initComponents();
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Thông tin đơn treo");
        setLocationRelativeTo(null);
        setResizable(false);
        jpTraCuu.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black), "Thông tin đơn đặt", 0, HEIGHT, new Font(Font.SANS_SERIF, Font.PLAIN, 17) {
        }, Color.black));
        jpTraCuu.setBackground(Color.white);
        table.getTableHeader().setFont(new Font("SansSerif", Font.PLAIN, 14));
        table.getTableHeader().setPreferredSize(new Dimension(30, 30));
        scpTable.setVerticalScrollBar(new ScrollBar());
        ((DefaultTableCellRenderer) table.getTableHeader().getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
        model = (DefaultTableModel) table.getModel();
        addDataTable(list);

    }

    public HoaDon getHoaDon() {
        return hoaDon;
    }

    public void setHoaDon(HoaDon hoaDon) {
        this.hoaDon = hoaDon;
    }

    public boolean isClick() {
        return isClick;
    }

    public void setClick(boolean isClick) {
        this.isClick = isClick;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scpTable = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jpTraCuu = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jtCCCD = new javax.swing.JTextField();
        jtSĐT = new javax.swing.JTextField();
        btnTim = new javax.swing.JButton();
        btnXuLy = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        table.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CCCD", "Họ tên", "Số điện thoại", "Ngày lập", "Giờ lập", "Số lượng vé"
            }
        ));
        table.setRowHeight(30);
        scpTable.setViewportView(table);
        table.getAccessibleContext().setAccessibleParent(table);

        jLabel1.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel1.setText("CCCD");

        jLabel2.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jLabel2.setText("Số điện thoại");

        jtCCCD.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        jtCCCD.setPreferredSize(new java.awt.Dimension(64, 35));

        jtSĐT.setPreferredSize(new java.awt.Dimension(64, 35));

        btnTim.setBackground(new java.awt.Color(0, 199, 255));
        btnTim.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnTim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/search2.png"))); // NOI18N
        btnTim.setText("Tìm");
        btnTim.setBorder(null);
        btnTim.setPreferredSize(new java.awt.Dimension(75, 50));
        btnTim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimActionPerformed(evt);
            }
        });

        btnXuLy.setBackground(new java.awt.Color(0, 199, 255));
        btnXuLy.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnXuLy.setText("Xử lý");
        btnXuLy.setBorder(null);
        btnXuLy.setPreferredSize(new java.awt.Dimension(75, 50));
        btnXuLy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXuLyActionPerformed(evt);
            }
        });

        btnHuy.setBackground(new java.awt.Color(255, 51, 51));
        btnHuy.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnHuy.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/delete.png"))); // NOI18N
        btnHuy.setText("Hủy đơn");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jpTraCuuLayout = new javax.swing.GroupLayout(jpTraCuu);
        jpTraCuu.setLayout(jpTraCuuLayout);
        jpTraCuuLayout.setHorizontalGroup(
            jpTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTraCuuLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jpTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtSĐT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnTim, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnXuLy, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnHuy, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(36, 36, 36))
        );
        jpTraCuuLayout.setVerticalGroup(
            jpTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpTraCuuLayout.createSequentialGroup()
                .addGroup(jpTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jpTraCuuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jpTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpTraCuuLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21))
                            .addGroup(jpTraCuuLayout.createSequentialGroup()
                                .addComponent(btnTim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(btnXuLy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpTraCuuLayout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jpTraCuuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jpTraCuuLayout.createSequentialGroup()
                                .addComponent(jtCCCD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16)
                                .addComponent(jtSĐT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jpTraCuuLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)
                                .addComponent(jLabel2)
                                .addGap(9, 9, 9)))))
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpTraCuu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(scpTable, javax.swing.GroupLayout.PREFERRED_SIZE, 652, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(scpTable, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jpTraCuu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimActionPerformed
        if (jtCCCD.getText().equalsIgnoreCase("") && jtSĐT.getText().equalsIgnoreCase("")) {
            JOptionPane.showMessageDialog(null, "Chưa nhập tiêu chí tìm kiếm");
            return;
        } else {
            if (!jtCCCD.getText().equalsIgnoreCase("")) {
                String cccd = jtCCCD.getText();
                list = hoaDonDao.layHoaDonTamBangCccd(cccd);
                if (list.size() < 0) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy đơn tạm");
                    return;
                }
                addDataTable(list);
            } else {
                String sdt = jtSĐT.getText();
                list = hoaDonDao.layHoaDonTamBangSdt(sdt);
                if (list.size() < 0) {
                    JOptionPane.showMessageDialog(null, "Không tìm thấy đơn tạm");
                    return;
                }
                addDataTable(list);
            }
        }

    }//GEN-LAST:event_btnTimActionPerformed

    private void btnXuLyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXuLyActionPerformed
        int index = table.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn đơn để xử lý");
            return;
        }
        hoaDon = list.get(index);
        isClick = true;
        setVisible(false);

    }//GEN-LAST:event_btnXuLyActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        int index = table.getSelectedRow();
        if (index == -1) {
            JOptionPane.showMessageDialog(null, "Bạn chưa chọn đơn để hủy");
            return;
        } else {
        	int chose = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn hủy đơn này không?", "Thông báo", JOptionPane.YES_NO_OPTION);
        	if(chose == JOptionPane.NO_OPTION) {
        		return;
        	}
            HoaDon hd = list.get(index);
            for (Ve ve : hd.getListVes()) {
                veDao.capNhatTrangThaiVeTamHetNgay(ve);
            }
            table.remove(index);
            list = hoaDonDao.layHoaDonTam();
        }

    }//GEN-LAST:event_btnHuyActionPerformed

    private void addDataTable(List<HoaDon> list) {
        if (list.size() < 0) {
            return;
        }
        model.setRowCount(0);
        for (int i = 0; i < list.size(); i++) {
            model.addRow(new Object[]{list.get(i).getKhachHang().getCccd(), list.get(i).getKhachHang().getHoTen(),
                list.get(i).getKhachHang().getSdt(), list.get(i).getNgayTao(), list.get(i).getGioTao(),
                list.get(i).getListVes().size()});
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnTim;
    private javax.swing.JButton btnXuLy;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jpTraCuu;
    private javax.swing.JTextField jtCCCD;
    private javax.swing.JTextField jtSĐT;
    private javax.swing.JScrollPane scpTable;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
}
