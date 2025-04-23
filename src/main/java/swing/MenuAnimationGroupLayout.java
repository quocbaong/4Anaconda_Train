package swing;

import java.awt.Component;

import javax.swing.GroupLayout;
import javax.swing.JPanel;
import org.jdesktop.animation.timing.Animator;
import org.jdesktop.animation.timing.TimingTarget;
import org.jdesktop.animation.timing.TimingTargetAdapter;

import net.miginfocom.swing.MigLayout;

public class MenuAnimationGroupLayout {

    private final GroupLayout layout;
    private final MenuItem menuItem;
    private Animator animator;
    private boolean open;

    public MenuAnimationGroupLayout(GroupLayout layout, JPanel panel, MenuItem menuItem, int duration) {
        this.layout = layout;
        this.menuItem = menuItem;
        initAnimator(panel, duration);
    }
    public MenuAnimationGroupLayout(GroupLayout layout, Component component) {
        this.layout = layout;
        this.menuItem = (MenuItem) component;
        initAnimator(component, 200);
    }
    
	private void initAnimator(Component component, int duration) {
        int initialHeight = 66; // Chiều cao ban đầu của menu item
        int expandedHeight = menuItem.getPreferredSize().height; // Chiều cao khi mở

        // Thiết lập nhóm horizontal cho menuItem trong layout
        GroupLayout.Group horizontalGroup = layout.createParallelGroup()
                .addComponent(menuItem, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE);
        layout.setHorizontalGroup(horizontalGroup);

        // Thiết lập nhóm vertical ban đầu
        GroupLayout.Group verticalGroup = layout.createSequentialGroup()
                .addComponent(menuItem, initialHeight, initialHeight, expandedHeight);
        layout.setVerticalGroup(verticalGroup);

        TimingTarget target = new TimingTargetAdapter() {
            @Override
            public void timingEvent(float fraction) {
                int height;
                if (open) {
                    height = (int) (initialHeight + (expandedHeight - initialHeight) * fraction);
                    menuItem.setAlpha(fraction); // Cập nhật độ trong suốt
                } else {
                    height = (int) (initialHeight + (expandedHeight - initialHeight) * (1f - fraction));
                    menuItem.setAlpha(1f - fraction);
                }

                // Tạo một nhóm vertical mới
                GroupLayout.Group newVerticalGroup = layout.createSequentialGroup()
                        .addComponent(menuItem, height, height, height);

                // Cập nhật layout với nhóm vertical mới
                layout.setVerticalGroup(newVerticalGroup);
                component.revalidate(); // Cập nhật lại bố cục
                component.repaint();    // Vẽ lại panel
            }
        };

        animator = new Animator(duration, target);
        animator.setResolution(0);
        animator.setDeceleration(0.5f);
    }

    public void openMenu() {
        open = true;
        animator.start();
    }

    public void closeMenu() {
        open = false;
        animator.start();
    }
}
