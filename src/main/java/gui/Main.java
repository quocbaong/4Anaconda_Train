package gui;

import component.Herder;
import component.Menu;
import entity.TaiKhoan;
import event.EventMenuSelected;
import form.MainForm;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;

public class Main extends JFrame {

	private MigLayout layout;
	private Menu menu;
	private Herder herder;
	private MainForm main;

	private EntityManagerFactory emf;
	private TaiKhoan taiKhoan;
	private JFrame frame;

	public Main(EntityManagerFactory emf, TaiKhoan taiKhoan,JFrame loginScreen) {
		this.emf = emf;
		this.taiKhoan = taiKhoan;
		this.frame = loginScreen;
		initComponents();
		
		setExtendedState(JFrame.MAXIMIZED_BOTH);
//        setLocation(0, 0);
		setResizable(false);
		init();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void init() {
		layout = new MigLayout("fill", "0[]0[100%,fill]0", "0[fill,top]0");
		bg.setLayout(layout);
		menu = new Menu(taiKhoan,this,frame);
		//herder = new Herder(taiKhoan.getNhanVien().getHoTen(), taiKhoan.getNhanVien().getLoaiNV());
		main = new MainForm();
		menu.addEvent(new EventMenuSelected() {
			@Override
			public void menuSelected(int menuIndex, int subMenuIndex) {

				switch (menuIndex) {
				case 0:
					switch (subMenuIndex) {
					case 0:
						main.showForm(new GD_MuaVe(emf, taiKhoan));
						menu.hideallMenu();
						break;
					case 1:
						main.showForm(new GD_DoiTra(emf));
						menu.hideallMenu();
						break;
					}
					break;
				case 1:
					main.showForm(new GD_QuanLyKhachHang(emf));
					menu.hideallMenu();
					break;
				case 2:
					if (taiKhoan.getNhanVien().getLoaiNV().equalsIgnoreCase("Admin")) {
						main.showForm(new GD_QuanLyNhanVien(emf));
						menu.hideallMenu();
					} else {
						switch (subMenuIndex) {
						case 0:
							main.showForm(new GD_ThongKeDoanhThu(emf));
							menu.hideallMenu();
							break;
						case 1:
							main.showForm(new GD_ThongKeLuotVe(emf));
							menu.hideallMenu();
							break;
						}
					}
					break;
				case 3:
					if (taiKhoan.getNhanVien().getLoaiNV().equalsIgnoreCase("Admin")) {
						switch (subMenuIndex) {
						case 0:
							main.showForm(new GD_KhuyenMaiHoaDon(emf));
							menu.hideallMenu();
							break;
						case 1:
							main.showForm(new GD_KhuyenMaiTrenKhachHang(emf));
							menu.hideallMenu();
							break;

						}
					} else {
						switch (subMenuIndex) {
						case 0:
							main.showForm(new GD_TraCuuNhanVien(emf));
							menu.hideallMenu();
							break;
						case 1:
							main.showForm(new GD_TraCuuKhuyenMai(emf));
							menu.hideallMenu();
							break;

						case 2:
							main.showForm(new GD_TraCuuTuyen(emf));
							menu.hideallMenu();
							break;
						}
					}
					break;
				case 4:
					if (taiKhoan.getNhanVien().getLoaiNV().equalsIgnoreCase("Admin")) {
						switch (subMenuIndex) {
						case 0:
							main.showForm(new GD_ThongKeDoanhThu(emf));
							menu.hideallMenu();
							break;
						case 1:
							main.showForm(new GD_ThongKeLuotVe(emf));
							menu.hideallMenu();
							break;
						}
					}
					else {
						if (Desktop.isDesktopSupported()) {
						    try {
						        File myFile = new File("./troGiup/Support.pdf");
						        Desktop.getDesktop().open(myFile);
						    } catch (IOException ex) {
						        // no application registered for PDFs
						    	ex.printStackTrace();
						    }
						}
					}
					break;
				case 5:
					if (taiKhoan.getNhanVien().getLoaiNV().equalsIgnoreCase("Admin")) {
						if (Desktop.isDesktopSupported()) {
						    try {
						        File myFile = new File("./troGiup/Support.pdf");
						        Desktop.getDesktop().open(myFile);
						    } catch (IOException ex) {
						        // no application registered for PDFs
						    	ex.printStackTrace();
						    }
						}
						break;
					}else {
						dispose();
						java.awt.EventQueue.invokeLater(() -> {
				            new LoginScreen().setVisible(true);
				        });
						break;
					}
				case 6:
					dispose();
					java.awt.EventQueue.invokeLater(() -> {
			            new LoginScreen().setVisible(true);
			        });
					break;
			}
			}
		});
		menu.initMenuItem();
		bg.add(menu, "w 265!, spany 2");
		//bg.add(herder, "h 100!,wrap");
		bg.add(main, "w 100%, h 80%");
		main.add(new GD_Chinh());
	}
	// <editor-fold defaultstate="collapsed" desc="Generated
	// Code">//GEN-BEGIN:initComponents
	
	private void initComponents() {

		bg = new javax.swing.JLayeredPane();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setTitle("Phần mềm quản lý bán vé tàu");
		setPreferredSize(new java.awt.Dimension(2000, 1100));

		bg.setOpaque(true);

		javax.swing.GroupLayout bgLayout = new javax.swing.GroupLayout(bg);
		bg.setLayout(bgLayout);
		bgLayout.setHorizontalGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
				1712, Short.MAX_VALUE));
		bgLayout.setVerticalGroup(bgLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGap(0,
				1129, Short.MAX_VALUE));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(bg));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addComponent(bg));

		pack();
		setLocationRelativeTo(null);
	}// </editor-fold>//GEN-END:initComponents

//    public static void main(String args[]) {
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Main().setVisible(true);
//            }
//        });
//    }

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JLayeredPane bg;
	// End of variables declaration//GEN-END:variables
}
