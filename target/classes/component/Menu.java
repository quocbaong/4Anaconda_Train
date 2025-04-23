package component;

import event.EventShowPopupMenu;
import event.EventMenuSelected;
import event.EvenMenu;
import java.awt.Color;
import java.awt.Component;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import entity.TaiKhoan;
import model.Model_Menu;
import net.miginfocom.swing.MigLayout;

import swing.MenuAnimation;
import swing.MenuItem;
import swing.ScrollBarCustom;
import javax.swing.GroupLayout.Alignment;
import javax.swing.GroupLayout;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Dimension;

public class Menu extends javax.swing.JPanel {

    public boolean isShowMenu() {
        return showMenu;
    }

    public void addEvent(EventMenuSelected event) {
        this.event = event;
    }

    public void setEnableMenu(boolean enableMenu) {
        this.enableMenu = enableMenu;
    }

    public void setShowMenu(boolean showMenu) {
        this.showMenu = showMenu;
    }

    public void addEventShowPopup(EventShowPopupMenu eventShowPopup) {
        this.eventShowPopup = eventShowPopup;
    }

    private TaiKhoan taiKhoan;
    private boolean isClickBlog = false;
    private Blog blog;
    private final MigLayout layout;
    private EventMenuSelected event;
    private EventShowPopupMenu eventShowPopup;
    private boolean enableMenu = true;
    private boolean showMenu = true;

    public Menu(TaiKhoan taiKhoan, JFrame frame, JFrame freameLogin) {
        this.taiKhoan = taiKhoan;
        initComponents();
        setOpaque(false);
        sp.getViewport().setOpaque(false);
        sp.setViewportBorder(null);
        sp.setVerticalScrollBar(new ScrollBarCustom());
        layout = new MigLayout("wrap, fillx, insets 0", "[fill]", "[]3[]");
        panel.setLayout(layout);
    }

    private void addMenu(Model_Menu menu) {
        panel.add(new MenuItem(menu, getEventMenu(), event, panel.getComponentCount()), "h 66!");
    }

    public void initMenuItem() {
        addMenu(new Model_Menu(new ImageIcon(getClass().getResource("/icon/train_ticket.png")), "Vé", "Mua vé", "Trả vé"));
        addMenu(new Model_Menu(new ImageIcon(getClass().getResource("/icon/guests.png")), "Khách Hàng"));
        if (taiKhoan.getNhanVien().getLoaiNV().equalsIgnoreCase("Admin")) {
            addMenu(new Model_Menu(new ImageIcon(getClass().getResource("/icon/customer.png")), "Nhân viên"));
            addMenu(new Model_Menu(new ImageIcon(getClass().getResource("/icon/voucher.png")), "Khuyến Mãi", "Khuyến mãi trên hóa đơn", "Khuyến mãi theo đối tượng"));
            addMenu(new Model_Menu(new ImageIcon(getClass().getResource("/icon/analysis.png")), "Thống kê", "Thống kê doanh thu", "Thống kê lượt vé"));
        } else {
            addMenu(new Model_Menu(new ImageIcon(getClass().getResource("/icon/analysis.png")), "Thống kê", "Thống kê đi lại", "Thống kê vé bán"));
            addMenu(new Model_Menu(new ImageIcon(getClass().getResource("/icon/search.png")), "Tra cứu", "Tra cứu nhân viên", "Tra cứu khuyến mãi", "Tra cứu tuyến"));
        }
        addMenu(new Model_Menu(new ImageIcon(getClass().getResource("/icon/help.png")), "Hỗ trợ"));
        addMenu(new Model_Menu(new ImageIcon(getClass().getResource("/icon/logout.png")), "Đăng xuất"));
    }

    private EvenMenu getEventMenu() {
        return new EvenMenu() {
            @Override
            public boolean menuPressed(Component com, boolean open) {
                if (enableMenu) {
                    if (isShowMenu()) {
                        if (open) {
                            hideallMenu();
                            new MenuAnimation(layout, com).openMenu();
                        } else {
                            new MenuAnimation(layout, com).closeMenu();
                        }
                        return true;
                    } else {
                        eventShowPopup.showPopup(com);
                    }
                }
                return false;
            }
        };
    }

    // Tắt menu đang select
    public void hideallMenu() {
        for (Component com : panel.getComponents()) {
            MenuItem item = (MenuItem) com;
            if (item.isOpen()) {
                new MenuAnimation(layout, com, 200).closeMenu();
                item.setOpen(false);
            }
        }
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        Logo = new javax.swing.JPanel();
        lbIcon = new javax.swing.JLabel();
        sp = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new Dimension(282, 1100));

        Logo.setOpaque(false);
        Logo.setPreferredSize(new java.awt.Dimension(300, 300));

        lbIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icon/logoTrain.png"))); // NOI18N
        lbIcon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbIconMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout LogoLayout = new javax.swing.GroupLayout(Logo);
        LogoLayout.setHorizontalGroup(
        	LogoLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(LogoLayout.createSequentialGroup()
        			.addComponent(lbIcon, GroupLayout.PREFERRED_SIZE, 279, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(21, Short.MAX_VALUE))
        );
        LogoLayout.setVerticalGroup(
        	LogoLayout.createParallelGroup(Alignment.LEADING)
        		.addComponent(lbIcon, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        Logo.setLayout(LogoLayout);

        sp.setBorder(null);
        sp.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        sp.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        sp.setAlignmentX(0.0F);
        sp.setAlignmentY(0.0F);
        sp.setOpaque(false);
        sp.setPreferredSize(new java.awt.Dimension(333, 900));
        sp.setViewportView(null);

        panel.setAlignmentX(0.0F);
        panel.setAlignmentY(0.0F);
        panel.setMaximumSize(new java.awt.Dimension(333, 900));
        panel.setOpaque(false);
        panel.setPreferredSize(new java.awt.Dimension(333, 900));

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 333, Short.MAX_VALUE)
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 900, Short.MAX_VALUE)
        );

        sp.setViewportView(panel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(sp, GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(Logo, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(32, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(Logo, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(sp, GroupLayout.PREFERRED_SIZE, 666, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(128, Short.MAX_VALUE))
        );
        this.setLayout(layout);
    }

    private void lbIconMouseClicked(java.awt.event.MouseEvent evt) {
        if (isClickBlog)
            return;
        isClickBlog = true;
        blog = new Blog();
        blog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                isClickBlog = false;
            }
        });
        blog.setVisible(true);
    }

    @Override
    protected void paintChildren(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint g3 = new GradientPaint(0, 0, Color.decode("#56CCF2"), 0, getHeight(), Color.decode("#CCFFCC"));
        g2.setPaint(g3);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
        super.paintChildren(g);
    }

    // Variables declaration - do not modify
    private javax.swing.JPanel Logo;
    private javax.swing.JLabel lbIcon;
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane sp;
    // End of variables declaration
}
