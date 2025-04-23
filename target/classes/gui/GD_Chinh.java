
package gui;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;

public class GD_Chinh extends javax.swing.JPanel {

	public GD_Chinh() {
		initComponents();
	}

	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		imgHome = new javax.swing.JLabel();

		imgHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/dsvn.jpg"))); // NOI18N

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		layout.setHorizontalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(imgHome, GroupLayout.PREFERRED_SIZE, 1129, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
					.addContainerGap()
					.addComponent(imgHome)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		this.setLayout(layout);
	}// </editor-fold>//GEN-END:initComponents

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLabel imgHome;
	// End of variables declaration//GEN-END:variables
}
