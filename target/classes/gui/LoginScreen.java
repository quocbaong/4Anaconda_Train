package gui;

import dao.TaiKhoanDao;
import entity.TaiKhoan;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.Color;

public class LoginScreen extends javax.swing.JFrame {

    private TaiKhoanDao taiKhoanDao;
    private EntityManagerFactory emf;
    private TaiKhoan taiKhoan;

    public LoginScreen() {
        initComponents();

        txtusername.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtpassword.setBackground(new java.awt.Color(0, 0, 0, 1));
        txtusername.setText("admin");
        txtpassword.setText("admin");
        emf = Persistence.createEntityManagerFactory("SourceMSSQL");
        taiKhoanDao = new TaiKhoanDao(emf);
    }

    /*    @SuppressWarnings("unchecked");*/
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        jLabel12 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtusername = new javax.swing.JTextField();
        underPass = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtpassword = new javax.swing.JPasswordField();
        underUser = new javax.swing.JLabel();
        disable = new javax.swing.JLabel();
        show = new javax.swing.JLabel();
        btnDangNhap = new javax.swing.JButton();
        btnQuenMK = new javax.swing.JButton();
        btnQuenMK.setForeground(new Color(0, 0, 255));
        btnQuenMK.setHorizontalAlignment(SwingConstants.RIGHT);
        error = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setBackground(new java.awt.Color(255, 255, 255));
        jLabel12.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(204, 204, 255));
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
 
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 120, -1));

        ImageIcon originalIcon = new ImageIcon(getClass().getResource("/icon/login.jpg"));  // Load original image
        Image scaledImage = originalIcon.getImage().getScaledInstance(500, 440, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(scaledIcon);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 200));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 500, 440));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153), 2));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/closeLoginIcon.png"))); // NOI18N
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 30, 30));

        jLabel5.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 22)); // NOI18N
        jLabel5.setText("Tài khoản");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, 110, 30));

        
        txtusername.setBackground(new java.awt.Color(204, 204, 204));
        txtusername.setFont(txtusername.getFont().deriveFont(txtusername.getFont().getSize()+2f));
        txtusername.setBorder(null);
        txtusername.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtusernameMouseClicked(evt);
            }
        });
        txtusername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusernameActionPerformed(evt);
            }
        });
        txtusername.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtusernameKeyPressed(evt);
            }
        });
        jPanel2.add(txtusername, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, 200, 30));

        underPass.setText("_________________________________");
        underPass.setPreferredSize(new java.awt.Dimension(200, 15));
        underPass.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                underPassKeyPressed(evt);
            }
        });
        jPanel2.add(underPass, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 150, 200, 30));

        jLabel7.setBackground(new java.awt.Color(255, 255, 255));
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/userIcon.png"))); // NOI18N
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 135, 50, 50));

        jLabel8.setFont(new Font("Segoe UI", Font.BOLD | Font.ITALIC, 22)); // NOI18N
        jLabel8.setText("Mật khẩu");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 200, 110, 30));

        txtpassword.setBackground(new java.awt.Color(204, 204, 204));
        txtpassword.setFont(txtpassword.getFont().deriveFont(txtpassword.getFont().getSize()+2f));
        txtpassword.setBorder(null);
        
        txtpassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtpasswordMouseClicked(evt);
            }
        });
        txtpassword.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpasswordActionPerformed(evt);
            }
        });
        txtpassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtpasswordKeyPressed(evt);
            }
        });
        jPanel2.add(txtpassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 200, 30));

        underUser.setText("_________________________________");
        underUser.setPreferredSize(new java.awt.Dimension(200, 15));
        jPanel2.add(underUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 200, 30));

        disable.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        disable.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/disableIcon.png"))); // NOI18N
        disable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        disable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                disableMouseClicked(evt);
            }
        });
        jPanel2.add(disable, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 235, 50, 50));

        show.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        show.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/showIcon.png"))); // NOI18N
        show.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        show.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showMouseClicked(evt);
            }
        });
        jPanel2.add(show, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 235, 50, 50));
        btnDangNhap.setBackground(new java.awt.Color(0, 204, 0));
        btnDangNhap.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        btnDangNhap.setText("Đăng nhập");
        btnDangNhap.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDangNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDangNhapActionPerformed(evt);
            }
        });
        btnQuenMK.setBackground(new java.awt.Color(255, 255, 255)); // Background color for the button
        btnQuenMK.setFont(new java.awt.Font("Segoe UI", 0, 14)); // Font style for the button
        btnQuenMK.setText("Quên mật khẩu?"); // Text on the button
        btnQuenMK.setBorder(null);  // Remove the border
        btnQuenMK.setContentAreaFilled(false);  
        btnQuenMK.setBorder(null); // Remove the border from the button
        btnQuenMK.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR)); // Hand cursor on hover

        // Event listener for the button
        btnQuenMK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuenMKActionPerformed(evt);
            }
        });
        jPanel2.add(btnQuenMK, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 285, 200, 30)); // Adjust position if necessary
        error.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        error.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(error, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 325, -1, -1));
        
        jPanel2.add(btnDangNhap, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 325, 170, 40));

        error.setFont(new java.awt.Font("SansSerif", 0, 11)); // NOI18N
        error.setForeground(new java.awt.Color(255, 0, 0));
        jPanel2.add(error, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 340, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 0, 370, 440));

        setSize(new java.awt.Dimension(871, 441));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void disableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_disableMouseClicked
        txtpassword.setEchoChar((char) 0);
        disable.setVisible(false);
        disable.setEnabled(false);
        show.setEnabled(true);
        show.setEnabled(true);
    }//GEN-LAST:event_disableMouseClicked

    private void showMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showMouseClicked
        txtpassword.setEchoChar((char) 8226);
        disable.setVisible(true);
        disable.setEnabled(true);
        show.setEnabled(false);
        show.setEnabled(false);
    }//GEN-LAST:event_showMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        for (double i = 0.0; i <= 1.0; i = i + 0.1) {
            String val = i + "";
            float f = Float.valueOf(val);
            this.setOpacity(f);
            try {
                Thread.sleep(50);
            } catch (Exception e) {

            }
        }
    }//GEN-LAST:event_formWindowOpened

    private void btnDangNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDangNhapActionPerformed

        String userName = txtusername.getText();
        String passWord = new String(txtpassword.getPassword());
        taiKhoan = taiKhoanDao.getTaiKhoanByUserName(userName);
        if (taiKhoan != null && taiKhoan.getMatKhau().equalsIgnoreCase(passWord)) {
            
                    new Main(emf, taiKhoan,this).setVisible(true);
                    setVisible(false);
        } else {
            error.setText("Tên tài khoản hoặc mật khẩu không chính xác");
        }
    }//GEN-LAST:event_btnDangNhapActionPerformed


	private void btnQuenMKActionPerformed(ActionEvent evt) {
		
	}
    

    private void txtpasswordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpasswordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpasswordActionPerformed

    private void txtusernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusernameActionPerformed

    }//GEN-LAST:event_txtusernameActionPerformed

    private void txtusernameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtusernameMouseClicked
        error.setText("");
    }//GEN-LAST:event_txtusernameMouseClicked

    private void txtpasswordMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtpasswordMouseClicked
        error.setText("");
    }//GEN-LAST:event_txtpasswordMouseClicked

    private void txtusernameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtusernameKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnDangNhapActionPerformed(null);
        }
        if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtpassword.requestFocus(); // Chuyển focus đến ô mật khẩu
        } else if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtusername.requestFocus(); // Chuyển focus đến ô tên đăng nhập
        }
    }//GEN-LAST:event_txtusernameKeyPressed

    private void underPassKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_underPassKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_underPassKeyPressed

    private void txtpasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpasswordKeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            btnDangNhapActionPerformed(null);
        }
        if (evt.getKeyCode() == KeyEvent.VK_UP) {
            txtusername.requestFocus(); // Chuyển focus đến ô tên đăng nhập
        } else if (evt.getKeyCode() == KeyEvent.VK_DOWN) {
            txtpassword.requestFocus(); // Chuyển focus đến ô mật khẩu
    }//GEN-LAST:event_txtpasswordKeyPressed

    
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(() -> {
            new LoginScreen().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDangNhap;
    private javax.swing.JButton btnQuenMK;
    private javax.swing.JLabel disable;
    private javax.swing.JLabel error;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel show;
    private javax.swing.JPasswordField txtpassword;
    private javax.swing.JTextField txtusername;
    private javax.swing.JLabel underPass;
    private javax.swing.JLabel underUser;
    // End of variables declaration//GEN-END:variables
}
