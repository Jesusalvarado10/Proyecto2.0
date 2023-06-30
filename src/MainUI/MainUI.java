/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package MainUI;

import App.App;
import HashTable.HashTable;
import javax.swing.JFrame;

/**
 *
 * @author User
 */
public class MainUI extends javax.swing.JFrame {
    // HashTable class
    HashTable hashTable;
    
    // Name of principal GUI
    static String nameUI;
    
    // App class
    static App app;

    // <editor-fold defaultstate="collapsed" desc="Constructor"> 
    /**
     * Creates new form MainUI
     * @param nameUI
     * @param appClass
     */
    public MainUI(String nameUI, App appClass) {
        // Ignore
        initComponents();
        
        // Windows config
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle(nameUI);

        // Utils
        app = appClass;
        hashTable = new HashTable(2);
    }
    // </editor-fold>
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        layoutP = new javax.swing.JPanel();
        userPanel = new javax.swing.JPanel();
        userTitle = new javax.swing.JLabel();
        searchClient = new javax.swing.JButton();
        adminPanel = new javax.swing.JPanel();
        adminTitle = new javax.swing.JLabel();
        checkOut = new javax.swing.JButton();
        searchReservation = new javax.swing.JButton();
        searchHistory = new javax.swing.JButton();
        checkIn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        layoutP.setBackground(new java.awt.Color(0, 102, 102));
        layoutP.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userPanel.setBackground(new java.awt.Color(0, 102, 102));
        userPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        userPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        userTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        userTitle.setForeground(new java.awt.Color(255, 255, 255));
        userTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        userTitle.setText("Panel de usuario");
        userPanel.add(userTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, -1));

        searchClient.setBackground(new java.awt.Color(255, 255, 255));
        searchClient.setText("Ver clientes hospedados");
        searchClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchClientActionPerformed(evt);
            }
        });
        userPanel.add(searchClient, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 190, -1));

        layoutP.add(userPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 0, 230, 210));

        adminPanel.setBackground(new java.awt.Color(0, 102, 102));
        adminPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        adminPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        adminTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        adminTitle.setForeground(new java.awt.Color(255, 255, 255));
        adminTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        adminTitle.setText("Panel de administrador");
        adminPanel.add(adminTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 20));

        checkOut.setBackground(new java.awt.Color(255, 255, 255));
        checkOut.setText("Check-Out");
        checkOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkOutActionPerformed(evt);
            }
        });
        adminPanel.add(checkOut, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 190, -1));

        searchReservation.setBackground(new java.awt.Color(255, 255, 255));
        searchReservation.setText("Buscar reservación");
        searchReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchReservationActionPerformed(evt);
            }
        });
        adminPanel.add(searchReservation, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 190, -1));

        searchHistory.setBackground(new java.awt.Color(255, 255, 255));
        searchHistory.setText("Ver historial de habitación");
        searchHistory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchHistoryActionPerformed(evt);
            }
        });
        adminPanel.add(searchHistory, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 190, -1));

        checkIn.setBackground(new java.awt.Color(255, 255, 255));
        checkIn.setText("Check-In");
        checkIn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkInActionPerformed(evt);
            }
        });
        adminPanel.add(checkIn, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 190, -1));

        layoutP.add(adminPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 230, 210));

        getContentPane().add(layoutP, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // <editor-fold defaultstate="collapsed" desc="Events">     
    private void searchReservationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchReservationActionPerformed
//        app.searchReservation();
    }//GEN-LAST:event_searchReservationActionPerformed

    private void searchHistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchHistoryActionPerformed
//        app.searchBedroomHistorial();
    }//GEN-LAST:event_searchHistoryActionPerformed

    private void checkInActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkInActionPerformed
//        app.checkIn();
    }//GEN-LAST:event_checkInActionPerformed

    private void checkOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_checkOutActionPerformed
//        app.checkOut();
    }//GEN-LAST:event_checkOutActionPerformed

    private void searchClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchClientActionPerformed
//        app.searchHosted();
    }//GEN-LAST:event_searchClientActionPerformed
    // </editor-fold>     
    
    // <editor-fold defaultstate="collapsed" desc="Main function">  
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
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new MainUI(nameUI, app).setVisible(true);
        });
    }
    // </editor-fold>

    // <editor-fold defaultstate="collapsed" desc="Variables delcaration">  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel adminPanel;
    private javax.swing.JLabel adminTitle;
    private javax.swing.JButton checkIn;
    private javax.swing.JButton checkOut;
    private javax.swing.JPanel layoutP;
    private javax.swing.JButton searchClient;
    private javax.swing.JButton searchHistory;
    private javax.swing.JButton searchReservation;
    private javax.swing.JPanel userPanel;
    private javax.swing.JLabel userTitle;
    // End of variables declaration//GEN-END:variables
    // </editor-fold>
}
