
package gui;

import form.FormMuaVe;
import jakarta.persistence.EntityManagerFactory;

import java.awt.event.ActionListener;

import entity.TaiKhoan;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import java.awt.Dimension;

public class GD_MuaVe extends javax.swing.JPanel {

	private EntityManagerFactory emf;
	private TaiKhoan taiKhoan;

	public GD_MuaVe(EntityManagerFactory emf, TaiKhoan taiKhoan) {
		this.emf = emf;
		this.taiKhoan = taiKhoan;
		initComponents();
		mainForm1.showForm(new FormMuaVe(mainForm1, emf, taiKhoan));
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		groupLanDi = new javax.swing.ButtonGroup();
		mainForm1 = new form.MainForm();

		setBackground(new java.awt.Color(204, 204, 204));
		setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED,
				new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 204),
				new java.awt.Color(204, 204, 204)));
		setPreferredSize(new Dimension(1306, 1017));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(mainForm1, GroupLayout.PREFERRED_SIZE, 1413, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(58, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addComponent(mainForm1, GroupLayout.PREFERRED_SIZE, 1014, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(57, Short.MAX_VALUE))
		);
		this.setLayout(layout);
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.ButtonGroup groupLanDi;
	private form.MainForm mainForm1;
	// End of variables declaration//GEN-END:variables

	public void remove(ActionListener aThis) {
		throw new UnsupportedOperationException("Not supported yet."); // Generated from
																		// nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
	}
}
