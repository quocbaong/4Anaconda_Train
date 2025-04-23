package gui;

import form.FormNhanVien;
import form.FormTaiKhoan;
import form.FormTraCuuHoaDon;
import form.FormTraCuuNhanVien;
import form.FormTraCuuKhuyenMai;
import form.FormTraCuuKhachHang;
import form.FormTraCuuTuyen;
import form.FormTraCuuVe;
import jakarta.persistence.EntityManagerFactory;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;

public class GD_TraCuuTuyen extends javax.swing.JPanel {

	private EntityManagerFactory emf;

	public GD_TraCuuTuyen(EntityManagerFactory emf) {
		initComponents();
		setBorder(new EmptyBorder(10, 10, 10, 10));

		btnTraCuuKhuyenMai.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainForm1.showForm(new FormTraCuuKhuyenMai(emf));
			}
		});
		btnTraCuuNhanVien.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainForm1.showForm(new FormTraCuuNhanVien(emf));
			}
		});
		btnTraCuuTuyen.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mainForm1.showForm(new FormTraCuuTuyen(emf));
			}
		});

		mainForm1.showForm(new FormTraCuuTuyen(emf));
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

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainForm1 = new form.MainForm();
        btnTraCuuKhuyenMai = new javax.swing.JButton();
        btnTraCuuNhanVien = new javax.swing.JButton();
        btnTraCuuTuyen = new javax.swing.JButton();

        setOpaque(false);
        setPreferredSize(new Dimension(1574, 1041));

        mainForm1.setPreferredSize(new java.awt.Dimension(1600, 1000));

        btnTraCuuKhuyenMai.setBackground(new java.awt.Color(0, 199, 255));
        btnTraCuuKhuyenMai.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnTraCuuKhuyenMai.setText("Tra cứu khuyến mãi");
        btnTraCuuKhuyenMai.setBorderPainted(false);
        btnTraCuuKhuyenMai.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnTraCuuKhuyenMai.setMaximumSize(new java.awt.Dimension(120, 45));
        btnTraCuuKhuyenMai.setMinimumSize(new java.awt.Dimension(120, 45));
        btnTraCuuKhuyenMai.setPreferredSize(new java.awt.Dimension(120, 45));
        btnTraCuuKhuyenMai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraCuuKhuyenMaiActionPerformed(evt);
            }
        });

        btnTraCuuNhanVien.setBackground(new java.awt.Color(0, 199, 255));
        btnTraCuuNhanVien.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnTraCuuNhanVien.setText("Tra cứu nhân viên");
        btnTraCuuNhanVien.setBorderPainted(false);
        btnTraCuuNhanVien.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnTraCuuNhanVien.setMaximumSize(new java.awt.Dimension(120, 45));
        btnTraCuuNhanVien.setMinimumSize(new java.awt.Dimension(120, 45));
        btnTraCuuNhanVien.setPreferredSize(new java.awt.Dimension(120, 45));
        btnTraCuuNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraCuuNhanVienActionPerformed(evt);
            }
        });
        
        btnTraCuuTuyen.setBackground(new java.awt.Color(0, 199, 255));
        btnTraCuuTuyen.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        btnTraCuuTuyen.setText("Tra cứu tuyến");
        btnTraCuuTuyen.setBorderPainted(false);
        btnTraCuuTuyen.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnTraCuuTuyen.setMaximumSize(new java.awt.Dimension(120, 45));
        btnTraCuuTuyen.setMinimumSize(new java.awt.Dimension(120, 45));
        btnTraCuuTuyen.setPreferredSize(new java.awt.Dimension(120, 45));
        btnTraCuuTuyen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTraCuuTuyenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addComponent(btnTraCuuNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnTraCuuKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(btnTraCuuTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(928, Short.MAX_VALUE))
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(mainForm1, javax.swing.GroupLayout.DEFAULT_SIZE, 1570, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnTraCuuNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTraCuuKhuyenMai, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnTraCuuTuyen, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                    .addComponent(mainForm1, javax.swing.GroupLayout.DEFAULT_SIZE, 1031, Short.MAX_VALUE))
        );

    }// </editor-fold>//GEN-END:initComponents

	private void btnTraCuuKhuyenMaiActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTraCuuKhuyenMaiActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnTraCuuKhuyenMaiActionPerformed

	private void btnTraCuuNhanVienActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTraCuuNhanVienActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnTraCuuNhanVienActionPerformed
	
	private void btnTraCuuTuyenActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnTraCuuTuyenActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_btnTraCuuTuyenActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnTraCuuKhuyenMai;
    private javax.swing.JButton btnTraCuuNhanVien;
    private javax.swing.JButton btnTraCuuTuyen;
    private form.MainForm mainForm1;
    // End of variables declaration//GEN-END:variables
}
