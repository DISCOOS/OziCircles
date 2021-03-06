/*
    Copyright 2014-2017 DISCO Open Source (https://discoos.org/)

    This file is part of Ozi circles.
*/

import com.oziexplorer.LatLon;
import com.oziexplorer.MapClickCallback;
import com.oziexplorer.MapClickType;
import com.oziexplorer.OziAPI;
import com.oziexplorer.OziException;
import com.oziexplorer.UTMGridRef;
import com.oziexplorer.Waypoint;
import java.awt.Point;
import java.text.DecimalFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Sven-Ove Bjerkan
 *
 */
public class Main extends javax.swing.JFrame implements MapClickCallback {
    private MissingCategory mc = null;
    
    private static final int R_MANUAL = 75;
    private static final int R25 = 76;
    private static final int R50 = 77;
    private static final int R75 = 78;
    private static final int R95 = 79;
    
    private MissingCategory[] mcs = new MissingCategory[35];
                   
    private Track T_manual;
    private Track T25;
    private Track T50;
    private Track T75;
    private Track T95;
    private boolean got_book = false;
    
    private static final int COLOR_PURPLE = 16711935;
    private static final int COLOR_RED = 255;
    private static final int COLOR_YELLOW = 65535;
    private static final int COLOR_BLUE = 16711680;
    private static final int COLOR_GREEN = 65280;
    
    /**
     * Creates new form Main
     */
    public Main() {
        LPBData data = new LPBData();
        mcs = data.loadData();
        
        initComponents();
        
        for (MissingCategory mc1 : mcs) {
            if (mc1 == null)
                continue;
            selectCategory.addItem(mc1.getDesc());
        }
                
        setTitle("Ozi Circles v0.9.5 - DISCO Open Source (https://discoos.org/)");
        setAlwaysOnTop( true );
        setResizable(false);
        btnNewPos.setVisible(false);
                                
        // Check that Ozi is running 
        try {
            if (!OziAPI.findOzi()) {
                JOptionPane.showMessageDialog(null, "OziExplorer må kjøre først!", "Brukerfeil", JOptionPane.ERROR_MESSAGE);
                System.exit(1);
            }
            OziAPI.mapDoubleClickOn(this);
            
        } catch (OziException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int boka = JOptionPane.showConfirmDialog(null, 
                "Eier du eller en på laget boka aller app'en \"Lost Person Behavior\"?", 
                "Lost Person Behavior", JOptionPane.YES_NO_OPTION);
        if (boka == JOptionPane.NO_OPTION) {
            got_book = false;
            selectCategory.setEnabled(false);
            chk25.setEnabled(false);
            chk50.setEnabled(false);
            chk75.setEnabled(false);
            chk95.setEnabled(false);
            JOptionPane.showMessageDialog(null, "Data fra \"Lost Person Behavior\" vil ikke være tilgjengelig.");
        }
        else {
            got_book = true;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fldLat = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        fldLon = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fldRadius = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnDraw = new javax.swing.JButton();
        txtDblClkInfo = new javax.swing.JLabel();
        selectCategory = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        fld50 = new javax.swing.JTextField();
        fld25 = new javax.swing.JTextField();
        fldN = new javax.swing.JTextField();
        fld75 = new javax.swing.JTextField();
        fld95 = new javax.swing.JTextField();
        chk25 = new javax.swing.JCheckBox();
        chk50 = new javax.swing.JCheckBox();
        chk75 = new javax.swing.JCheckBox();
        jLabel13 = new javax.swing.JLabel();
        chk95 = new javax.swing.JCheckBox();
        btnNewPos = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        fldLat.setEditable(false);
        fldLat.setEnabled(false);

        jLabel1.setText("Latitude");

        jLabel2.setText("Longtitude");

        fldLon.setEditable(false);
        fldLon.setEnabled(false);

        jLabel3.setText("Radius");

        fldRadius.setEditable(false);
        fldRadius.setEnabled(false);
        fldRadius.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fldRadiusActionPerformed(evt);
            }
        });

        jLabel4.setText("meter");

        btnDraw.setText("Tegn manuell sirkel");
        btnDraw.setEnabled(false);
        btnDraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDrawActionPerformed(evt);
            }
        });

        txtDblClkInfo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        txtDblClkInfo.setForeground(new java.awt.Color(255, 51, 51));
        txtDblClkInfo.setText("Dobbelklikk i kartet for utfylling av posisjon");

        selectCategory.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "--- Velg ---" }));
        selectCategory.setEnabled(false);
        selectCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCategoryActionPerformed(evt);
            }
        });

        jLabel7.setText("Kategori");

        jLabel8.setText("n");

        jLabel9.setText("25%");

        jLabel10.setText("50%");

        jLabel11.setText("75%");

        jLabel12.setText("95%");

        fld50.setEditable(false);
        fld50.setEnabled(false);

        fld25.setEditable(false);
        fld25.setEnabled(false);

        fldN.setEditable(false);
        fldN.setEnabled(false);

        fld75.setEditable(false);
        fld75.setEnabled(false);

        fld95.setEditable(false);
        fld95.setEnabled(false);

        chk25.setEnabled(false);
        chk25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk25ActionPerformed(evt);
            }
        });

        chk50.setEnabled(false);
        chk50.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk50ActionPerformed(evt);
            }
        });

        chk75.setEnabled(false);
        chk75.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk75ActionPerformed(evt);
            }
        });

        jLabel13.setText("Tegn");

        chk95.setEnabled(false);
        chk95.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chk95ActionPerformed(evt);
            }
        });

        btnNewPos.setText("Angi ny posjon");
        btnNewPos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewPosActionPerformed(evt);
            }
        });

        jLabel6.setText("R (m)");

        jLabel5.setText("Tall i meter");

        jLabel14.setText("Tallene er hentet fra boka \"Lost Person Behavior\", med tillatelse.");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)))
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel14)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(txtDblClkInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fldLon, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fldRadius, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnDraw)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnNewPos)))
                                .addGap(2, 16, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(fldLat, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(7, 7, 7)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(12, 12, 12))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addGap(71, 71, 71)
                                        .addComponent(jLabel9)
                                        .addGap(19, 19, 19))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel13)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(fldN, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(fld25, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addComponent(chk25)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addGap(39, 39, 39)
                                        .addComponent(jLabel11)
                                        .addGap(32, 32, 32)
                                        .addComponent(jLabel12)
                                        .addGap(26, 26, 26))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(fld50, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fld75, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(fld95, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(chk50)
                                        .addGap(42, 42, 42)
                                        .addComponent(chk75)
                                        .addGap(36, 36, 36)
                                        .addComponent(chk95)
                                        .addGap(25, 25, 25))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(selectCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14)))))
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(txtDblClkInfo, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fldLon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fldRadius, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnDraw)
                            .addComponent(btnNewPos)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(selectCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7)
                            .addComponent(fldLat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fld50, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fld25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fldN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fld75, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fld95, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(chk25)
                            .addComponent(jLabel13)
                            .addComponent(chk50)
                            .addComponent(chk75)
                            .addComponent(chk95))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(jLabel5))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fldRadiusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fldRadiusActionPerformed
        T_manual.drawCircle(fldRadius.getText(), "Radius "+fldRadius.getText()+" m", COLOR_BLUE);
    }//GEN-LAST:event_fldRadiusActionPerformed

    private void btnDrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDrawActionPerformed
        if (T_manual != null && T_manual.isDrawn()) {
            T_manual.deleteCircle();
            btnDraw.setText("Tegn manuell sirkel");
        }
        else {
            if (fldRadius.getText().equals(""))
                return;
            T_manual.drawCircle(fldRadius.getText(), "Radius "+fldRadius.getText()+" m", COLOR_BLUE);
            btnDraw.setText("Slett sirkel");
        }
    }//GEN-LAST:event_btnDrawActionPerformed

    private void selectCategoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectCategoryActionPerformed
        if (mc != null && T25 != null) {
            T25.deleteCircle();
            T50.deleteCircle();
            T75.deleteCircle();
            T95.deleteCircle();
            
            chk25.setSelected(false);
            chk50.setSelected(false);
            chk75.setSelected(false);
            chk95.setSelected(false);
        }
        
        if (selectCategory.getSelectedIndex() == 0) {
            mc = null;
        }
        else {
            mc = mcs[selectCategory.getSelectedIndex()];
        }
        
        if (mc != null) {
            fldN.setText(String.valueOf(mc.getN()));
            fld25.setText(String.valueOf(mc.getR25()));
            fld50.setText(String.valueOf(mc.getR50()));
            fld75.setText(String.valueOf(mc.getR75()));
            fld95.setText(String.valueOf(mc.getR95()));
            
            chk25.setEnabled(true);
            chk50.setEnabled(true);
            chk75.setEnabled(true);
            chk95.setEnabled(true);
        }
        else {
            fldN.setText("");
            fld25.setText("");
            fld50.setText("");
            fld75.setText("");
            fld95.setText("");
            
            chk25.setEnabled(false);
            chk50.setEnabled(false);
            chk75.setEnabled(false);
            chk95.setEnabled(false);
        }
        
    }//GEN-LAST:event_selectCategoryActionPerformed

    private void chk25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk25ActionPerformed
        if (mc != null && T25 != null) {
            if (chk25.isSelected()) {
                repaint();
                T25.drawCircle(fld25.getText(), mc.getDesc()+ " (25%="+fld25.getText()+"m)", COLOR_BLUE);
            }
            else {
                T25.hideCircle();
            }
        }
    }//GEN-LAST:event_chk25ActionPerformed

    private void chk50ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk50ActionPerformed
        if (mc != null && T50 != null) {
            if (chk50.isSelected()) {
                T50.drawCircle(fld50.getText(), mc.getDesc()+ " (50%="+fld50.getText()+"m)", COLOR_YELLOW);
            }
            else {
                T50.hideCircle();
            }
        }
    }//GEN-LAST:event_chk50ActionPerformed

    private void chk75ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk75ActionPerformed
        if (mc != null && T75 != null) {
            if (chk75.isSelected()) {
                T75.drawCircle(fld75.getText(), mc.getDesc()+ " (75%="+fld75.getText()+"m)", COLOR_RED);
            }
            else {
                T75.hideCircle();
            }
        }
    }//GEN-LAST:event_chk75ActionPerformed

    private void chk95ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chk95ActionPerformed
        if (mc != null && T95 != null) {
            if (chk95.isSelected()) {
                T95.drawCircle(fld95.getText(), mc.getDesc()+ " (95%="+fld95.getText()+"m)", COLOR_PURPLE);
            }
            else {
                T95.hideCircle();
            }
        }
    }//GEN-LAST:event_chk95ActionPerformed

    private void btnNewPosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewPosActionPerformed
        if (fldLat.getText().equals(""))
            return;
        
        fldLat.setText("");
        fldLon.setText("");
        btnNewPos.setVisible(false);
        txtDblClkInfo.setText("Dobbelklikk i kartet for utfylling av posisjon");
        btnDraw.setText("Tegn sirkel");
        btnDraw.setEnabled(false);
        fldRadius.setEnabled(false);
        fldRadius.setEditable(false);
        
        try {
            OziAPI.mapDoubleClickOn(this);
                    
            int option = JOptionPane.showConfirmDialog(null, "Slett IPP også?", "Slett IPP?", JOptionPane.YES_NO_OPTION);
            if (option == JOptionPane.YES_OPTION) {
                OziAPI.deleteWaypoint("IPP");
            }
            
            T25.deleteCircle();
            chk25.setSelected(false);
            T50.deleteCircle();
            chk50.setSelected(false);
            T75.deleteCircle();
            chk75.setSelected(false);
            T95.deleteCircle();
            chk95.setSelected(false);
            T_manual.deleteCircle();
            
            chk25.setEnabled(false);
            chk50.setEnabled(false);
            chk75.setEnabled(false);
            chk95.setEnabled(false);
            
        } catch (OziException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnNewPosActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDraw;
    private javax.swing.JButton btnNewPos;
    private javax.swing.JCheckBox chk25;
    private javax.swing.JCheckBox chk50;
    private javax.swing.JCheckBox chk75;
    private javax.swing.JCheckBox chk95;
    private javax.swing.JTextField fld25;
    private javax.swing.JTextField fld50;
    private javax.swing.JTextField fld75;
    private javax.swing.JTextField fld95;
    private javax.swing.JTextField fldLat;
    private javax.swing.JTextField fldLon;
    private javax.swing.JTextField fldN;
    private javax.swing.JTextField fldRadius;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JComboBox selectCategory;
    private javax.swing.JLabel txtDblClkInfo;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mapClickCallback(MapClickType mct, Point point, LatLon latlon, UTMGridRef utmgr) {
        if (mct == MapClickType.DOUBLE) {
            try {
                OziAPI.centerMapAtPosition(latlon);
                T_manual = new Track(R_MANUAL, latlon);
                T25 = new Track(R25, latlon);
                T50 = new Track(R50, latlon);
                T75 = new Track(R75, latlon);
                T95 = new Track(R95, latlon);
                
                if (OziAPI.getWaypointNumberFromName("IPP") == 0) {
                    OziAPI.addWaypoint(new Waypoint("IPP", OziAPI.DEFVAL, latlon));
                }
                else 
                    OziAPI.addWaypoint(new Waypoint("PP", OziAPI.DEFVAL, latlon));
            } catch (OziException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            DecimalFormat df = new DecimalFormat("##.######");
            fldLat.setText(df.format(latlon.getLat()));
            fldLon.setText(df.format(latlon.getLon()));
            btnNewPos.setVisible(true);
            btnDraw.setEnabled(true);
            if (got_book)
                selectCategory.setEnabled(true);
            
            txtDblClkInfo.setText("");
            fldRadius.setEnabled(true);
            fldRadius.setEditable(true);
            
            if (selectCategory.getSelectedIndex() > 0) {
                chk25.setEnabled(true);
                chk50.setEnabled(true);
                chk75.setEnabled(true);
                chk95.setEnabled(true);
            }
                        
            toFront();
            repaint();
                     
            try {
                OziAPI.mapDoubleClickOff();
            } catch (OziException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
