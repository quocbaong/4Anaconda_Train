
package component;

import java.util.List;
import net.miginfocom.swing.MigLayout;

public class ListPanelVe extends javax.swing.JPanel {

    public ListPanelVe() {
        initComponents();
        setLayout(new MigLayout("fillx","0[]0","0[]0"));
    }
    
    public void setData(List<DataVe> data){
        this.removeAll();
        for(DataVe d : data){
            VeItem item = new VeItem(d);
            this.add(item,"wrap");
        }
        repaint();
        revalidate();
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
