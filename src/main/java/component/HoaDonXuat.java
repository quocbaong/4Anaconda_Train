package component;

import entity.ChiTietVe;
import entity.Ga;
import entity.HoaDon;
import entity.KhuyenMai;
import entity.Ve;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.SwingConstants;

public class HoaDonXuat extends JPanel {
    
    DateTimeFormatter fomatDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    DateTimeFormatter fomatTime = DateTimeFormatter.ofPattern("hh:mm:ss");
    
    public HoaDonXuat(HoaDon hoaDon) {
        initComponents();
        setPreferredSize(new Dimension(1000, 800));
        panelVe.setLayout(new MigLayout("fillx","0[]0","0[]0"));
        lbMaHD.setText(hoaDon.getMaHoaDon());
        lbNgayGio.setText(fomatDate.format(hoaDon.getNgayTao()) + " " +fomatTime.format(hoaDon.getGioTao()));
        lbKhachHang.setText(hoaDon.getKhachHang().getHoTen());
        lbEmail.setText(hoaDon.getKhachHang().getEmail());
        lbSdt.setText(hoaDon.getKhachHang().getSdt());
        Set<KhuyenMai> lkms = hoaDon.getLisKhuyenMais();
        if(lkms != null){
            String kmText = "";
            for(KhuyenMai km : lkms)
                kmText += km.getTenKhuyenMai();
            lbKhuyenMai.setText(kmText);
        }
        List<DataVe> list = listData(hoaDon);
        double tongTien = 0;
        for(DataVe d : list){
            tongTien += d.getSoLuong() * d.getTongTien();
            VeItem item = new VeItem(d);
            panelVe.add(item,"wrap");
        }
        lbTongTien.setText((int)(tongTien/1000) +  ".000");
    }
    
    private List<DataVe> listData(HoaDon hoaDon) {
        List<DataVe> list = new ArrayList<DataVe>();
        Ga gaDi = null;
        Ga gaDen = null;
        DataVe temp;
        int index;
        double tien = 0;
        for (Ve ve : hoaDon.getListVes()) {
            for(ChiTietVe ctv : ve.getLisChiTietVes()){
                if(ctv.isChieu()){
                    gaDi = ctv.getGa();
                }
                else
                    gaDen = ctv.getGa();
            }
            if(ve.getKhuyenMai() != null) {
            	tien = ve.getChoNgoi().getGia() * Math.abs(gaDi.getId() - gaDen.getId()) * (1 - ve.getKhuyenMai().getChietKhau());
            }
            else {
            	tien = ve.getChoNgoi().getGia() * Math.abs(gaDi.getId() - gaDen.getId());
            }
            temp = new DataVe(ve.getKhachHang().getDoiTuong(), gaDen.getTenGa(), gaDi.getTenGa(), 1, tien);
            index = search(list, temp);
            if (index != -1) {
                list.get(index).setIntervolSL();
            }
            else
                list.add(temp);
        }
        return list;
    }
    
    private int search(List<DataVe> list, DataVe data) {
        if (list.isEmpty()) {
            return -1;
        }
        DataVe temp;
        for (int i = 0; i < list.size(); i++) {
            temp = list.get(i);
            if (temp.getDoiTuong().equalsIgnoreCase(data.getDoiTuong()) && temp.getGaDi().equalsIgnoreCase(data.getGaDi()) && temp.getGaDen().equalsIgnoreCase(data.getGaDen())) {
                return i;
            }
        }
        return -1;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel3 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jPanel1 = new JPanel();
        jLabel6 = new JLabel();
        jLabel7 = new JLabel();
        jLabel8 = new JLabel();
        jLabel9 = new JLabel();
        jLabel10 = new JLabel();
        jLabel15 = new JLabel();
        hearderHoaDon1 = new HearderHoaDon();
        lbMaHD = new JLabel();
        lbNgayGio = new JLabel();
        lbKhachHang = new JLabel();
        lbSdt = new JLabel();
        lbEmail = new JLabel();
        jPanel2 = new JPanel();
        jLabel16 = new JLabel();
        lbTongTien = new JLabel();
        jLabel12 = new JLabel();
        jLabel13 = new JLabel();
        lbKhuyenMai = new JLabel();
        jPanel3 = new JPanel();
        jLabel18 = new JLabel();
        jLabel19 = new JLabel();
        jLabel20 = new JLabel();
        jLabel21 = new JLabel();
        jLabel22 = new JLabel();
        panelVe = new JPanel();
        jLabel11 = new JLabel();
        
        
        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logoTrainHD.png"))); // NOI18N

        jLabel2.setFont(new Font("SansSerif", 1, 20)); // NOI18N
        jLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel2.setText("ĐƯỜNG SẮT VIỆT NAM");

        jLabel3.setFont(new Font("SansSerif", 0, 17)); // NOI18N
        jLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel3.setText("118 đường Lê Duẩn, Phường Cửa Nam, Quận Hoàn Kiếm, Thành phố Hà Nội, Việt Nam.");

        jLabel4.setFont(new Font("SansSerif", 1, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel4.setText("https://dsvn.vn/#/");

        jLabel5.setFont(new Font("SansSerif", 1, 16)); // NOI18N
        jLabel5.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel5.setText("Hostline: 19001520");

        jPanel1.setOpaque(false);

        jLabel6.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        jLabel6.setText("Ngày:");

        jLabel7.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        jLabel7.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel7.setText("Mã hóa đơn:  ");

        jLabel8.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        jLabel8.setText("Khách hàng: ");

        jLabel9.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        jLabel9.setText("Số điện thoại: ");

        jLabel10.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        jLabel10.setText("Email:");

        jLabel15.setFont(new Font("SansSerif", 1, 18)); // NOI18N
        jLabel15.setText("Thông tin vé");

        lbMaHD.setFont(new Font("SansSerif", 1, 16)); // NOI18N
        lbMaHD.setText("HD981729837121321");

        lbNgayGio.setFont(new Font("SansSerif", 1, 16)); // NOI18N
        lbNgayGio.setText("23/04/2024  08:45:30");

        lbKhachHang.setFont(new Font("SansSerif", 1, 16)); // NOI18N
        lbKhachHang.setText("Đào Huy Hoàng");

        lbSdt.setFont(new Font("SansSerif", 1, 16)); // NOI18N
        lbSdt.setText("093874849983");

        lbEmail.setFont(new Font("SansSerif", 1, 16)); // NOI18N
        lbEmail.setText("hoang@gmail.com");

        jPanel2.setOpaque(false);

        jLabel16.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        jLabel16.setText("Tổng tiền:");

        lbTongTien.setFont(new Font("SansSerif", 1, 16)); // NOI18N
        lbTongTien.setText("300.000");

        jLabel12.setFont(new Font("SansSerif", 1, 16)); // NOI18N
        jLabel12.setText("VNĐ");

        jLabel13.setFont(new Font("SansSerif", 0, 16)); // NOI18N
        jLabel13.setText("Khuyến mãi: ");

        lbKhuyenMai.setFont(new Font("SansSerif", 1, 16)); // NOI18N
        lbKhuyenMai.setText("Không");

        GroupLayout jPanel2Layout = new GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(lbTongTien)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addComponent(jLabel13)
                .addGap(120, 120, 120)
                .addComponent(lbKhuyenMai)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(lbTongTien)
                    .addComponent(jLabel12))
                .addGap(15, 15, 15)
                .addGroup(jPanel2Layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(lbKhuyenMai)))
        );

        jPanel3.setOpaque(false);

        jLabel18.setFont(new Font("SansSerif", 0, 14)); // NOI18N
        jLabel18.setText("Thông tin liên hệ: Đường sắt Việt Nam - 118 đường Lê Duẩn, Phường Cửa Nam, Quận Hoàn Kiếm, Thành phố Hà Nội, Việt Nam.");

        jLabel19.setFont(new Font("SansSerif", 0, 14)); // NOI18N
        jLabel19.setText("Hotline: 19001520");

        jLabel20.setFont(new Font("SansSerif", 1, 14)); // NOI18N
        jLabel20.setText("Lưu ý: ");

        jLabel21.setFont(new Font("SansSerif", 0, 14)); // NOI18N
        jLabel21.setText("Khách hàng có thể đổi-trả trước thời gian tàu khởi hành 1 ngày. ");

        GroupLayout jPanel3Layout = new GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(Alignment.LEADING)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(ComponentPlacement.RELATED)
                        .addComponent(jLabel21)))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel18)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jLabel21))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jLabel22.setFont(new Font("Segoe UI", 0, 16)); // NOI18N
        jLabel22.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel22.setText("--------------------------------------------------------------------------------------------------");

        panelVe.setOpaque(false);

        GroupLayout panelVeLayout = new GroupLayout(panelVe);
        panelVe.setLayout(panelVeLayout);
        panelVeLayout.setHorizontalGroup(
            panelVeLayout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        panelVeLayout.setVerticalGroup(
            panelVeLayout.createParallelGroup(Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        
        jLabel22_1 = new JLabel();
        jLabel22_1.setText("--------------------------------------------------------------------------------------------------");
        jLabel22_1.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel22_1.setFont(new Font("Segoe UI", Font.PLAIN, 16));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1Layout.setHorizontalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addGap(70)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(jLabel7)
        						.addComponent(jLabel6)
        						.addComponent(jLabel8)
        						.addComponent(jLabel9)
        						.addComponent(jLabel10))
        					.addGap(110)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lbNgayGio)
        						.addComponent(lbMaHD)
        						.addComponent(lbKhachHang)
        						.addComponent(lbSdt)
        						.addComponent(lbEmail)))
        				.addGroup(jPanel1Layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(jLabel15)))
        			.addGap(0, 685, Short.MAX_VALUE))
        		.addComponent(jPanel3, GroupLayout.DEFAULT_SIZE, 1136, Short.MAX_VALUE)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(jLabel22)
        			.addContainerGap(499, Short.MAX_VALUE))
        		.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        				.addComponent(jPanel2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        				.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
        					.addGap(68)
        					.addGroup(jPanel1Layout.createParallelGroup(Alignment.TRAILING, false)
        						.addComponent(panelVe, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(hearderHoaDon1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        			.addContainerGap(428, Short.MAX_VALUE))
        		.addGroup(Alignment.LEADING, jPanel1Layout.createSequentialGroup()
        			.addGap(31)
        			.addComponent(jLabel22_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addGap(407))
        );
        jPanel1Layout.setVerticalGroup(
        	jPanel1Layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(jPanel1Layout.createSequentialGroup()
        			.addGap(20)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel7)
        				.addComponent(lbMaHD))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel6)
        				.addComponent(lbNgayGio))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel8)
        				.addComponent(lbKhachHang))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel9)
        				.addComponent(lbSdt))
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addGroup(jPanel1Layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(jLabel10)
        				.addComponent(lbEmail))
        			.addGap(18)
        			.addComponent(jLabel15)
        			.addGap(2)
        			.addComponent(hearderHoaDon1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(panelVe, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jPanel2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(2)
        			.addComponent(jLabel22_1, GroupLayout.PREFERRED_SIZE, 22, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(jPanel3, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        			.addComponent(jLabel22)
        			.addContainerGap())
        );
        jPanel1.setLayout(jPanel1Layout);

        jLabel11.setFont(new Font("SansSerif", 1, 24)); // NOI18N
        jLabel11.setHorizontalAlignment(SwingConstants.CENTER);
        jLabel11.setText("HÓA ĐƠN BÁN HÀNG");

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addComponent(jLabel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel3, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel4, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jLabel5, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(ComponentPlacement.RELATED)
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private HearderHoaDon hearderHoaDon1;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel11;
    private JLabel jLabel12;
    private JLabel jLabel13;
    private JLabel jLabel15;
    private JLabel jLabel16;
    private JLabel jLabel18;
    private JLabel jLabel19;
    private JLabel jLabel2;
    private JLabel jLabel20;
    private JLabel jLabel21;
    private JLabel jLabel22;
    private JLabel jLabel3;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JPanel jPanel2;
    private JPanel jPanel3;
    private JLabel lbEmail;
    private JLabel lbKhachHang;
    private JLabel lbKhuyenMai;
    private JLabel lbMaHD;
    private JLabel lbNgayGio;
    private JLabel lbSdt;
    private JLabel lbTongTien;
    private JPanel panelVe;
    private JLabel jLabel22_1;
    // End of variables declaration//GEN-END:variables
}
