
package swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import gui.LoginScreen;


public class Button extends JButton {

    public Color getEffectColor() {
        return effectColor;
    }

    public void setEffectColor(Color effectColor) {
        this.effectColor = effectColor;
    }

    private Color effectColor = new Color(255, 255, 255);

    private JFrame frame;
    private JFrame loginScreen;
    
    
    
    public JFrame getLoginScreen() {
		return loginScreen;
	}

	public void setLoginScreen(JFrame loginScreen) {
		this.loginScreen = loginScreen;
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public Button() {
        setContentAreaFilled(false);
        setFont(new Font(Font.SANS_SERIF,  Font.LAYOUT_RIGHT_TO_LEFT, 25));
        setBorderPainted(false);
        setOpaque(false);
        setForeground(effectColor);
        setBackground(Color.WHITE);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent me) {
            	int chose = JOptionPane.showConfirmDialog(null, "Bạn có muốn đăng xuất không","Xác nhận",JOptionPane.YES_NO_OPTION);
				if(chose == JOptionPane.YES_OPTION) {
					frame.dispose();
					loginScreen.setVisible(true);
				}
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (!isOpaque() && getBackground().getAlpha() < 255) {
            g.setColor(getBackground());
            g.fillRect(0, 0, getWidth(), getHeight());
        }
        super.paintComponent(g);
    }
}
