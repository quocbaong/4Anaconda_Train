
package component;


public class VeItem extends javax.swing.JPanel {

    public VeItem(DataVe data) {
        initComponents();
        setData(data);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbDoiTuong = new javax.swing.JLabel();
        lbGaDi = new javax.swing.JLabel();
        lbGaDen = new javax.swing.JLabel();
        lbSoLuong = new javax.swing.JLabel();
        lbTien = new javax.swing.JLabel();

        setOpaque(false);

        lbDoiTuong.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbDoiTuong.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbDoiTuong.setText("Người lớn");

        lbGaDi.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbGaDi.setText("Sài Gòn");

        lbGaDen.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbGaDen.setText("Long Khánh");

        lbSoLuong.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbSoLuong.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbSoLuong.setText("6");

        lbTien.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lbTien.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbTien.setText("100.000 VNĐ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lbDoiTuong, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbGaDi, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbGaDen, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbSoLuong, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbTien, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbDoiTuong, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
            .addComponent(lbGaDi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbGaDen, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbSoLuong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void setData(DataVe data){
        lbDoiTuong.setText(data.getDoiTuong());
        lbGaDi.setText(data.getGaDi());
        lbGaDen.setText(data.getGaDen());
        lbSoLuong.setText(data.getSoLuong()+"");
        lbTien.setText((int)(data.getTongTien()/1000)+".000 VNĐ");
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lbDoiTuong;
    private javax.swing.JLabel lbGaDen;
    private javax.swing.JLabel lbGaDi;
    private javax.swing.JLabel lbSoLuong;
    private javax.swing.JLabel lbTien;
    // End of variables declaration//GEN-END:variables
}
