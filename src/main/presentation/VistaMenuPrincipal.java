/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.presentation;

import Usuari.Usuari;

/**
 *
 * @author admin
 */
public class VistaMenuPrincipal extends javax.swing.JFrame {
    CtrlVista cv;

    public VistaMenuPrincipal() {
        initComponents();
    }

    public VistaMenuPrincipal(CtrlVista v) {
        initComponents();
        cv = v;
        l_username.setText(cv.getCurrentUsername());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        topBarPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        b_userProfile = new javax.swing.JLabel();
        l_username = new javax.swing.JLabel();
        parentPanel = new javax.swing.JPanel();
        menuPrincipalPanel = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        b_play = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        seleccioPanel = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hidato - Menu Principal");

        topBarPanel.setBackground(new java.awt.Color(0, 204, 204));

        jLabel3.setFont(new java.awt.Font("Century Gothic", 0, 50)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Menu Principal");

        b_userProfile.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/userIcon.png"))); // NOI18N
        b_userProfile.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_userProfileMouseClicked(evt);
            }
        });

        l_username.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        l_username.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout topBarPanelLayout = new javax.swing.GroupLayout(topBarPanel);
        topBarPanel.setLayout(topBarPanelLayout);
        topBarPanelLayout.setHorizontalGroup(
            topBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(b_userProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(l_username, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        topBarPanelLayout.setVerticalGroup(
            topBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(topBarPanelLayout.createSequentialGroup()
                .addContainerGap(21, Short.MAX_VALUE)
                .addGroup(topBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topBarPanelLayout.createSequentialGroup()
                        .addGroup(topBarPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(l_username, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(b_userProfile, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(43, 43, 43))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, topBarPanelLayout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(27, 27, 27))))
        );

        getContentPane().add(topBarPanel, java.awt.BorderLayout.PAGE_START);

        parentPanel.setBackground(new java.awt.Color(0, 153, 153));
        parentPanel.setForeground(new java.awt.Color(255, 255, 255));
        parentPanel.setLayout(new java.awt.CardLayout());

        menuPrincipalPanel.setBackground(new java.awt.Color(0, 153, 153));

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jButton1.setText("Ranking");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        b_play.setBackground(new java.awt.Color(204, 204, 204));
        b_play.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        b_play.setText("Play");
        b_play.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_playMouseClicked(evt);
            }
        });
        b_play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_playActionPerformed(evt);
            }
        });

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout menuPrincipalPanelLayout = new javax.swing.GroupLayout(menuPrincipalPanel);
        menuPrincipalPanel.setLayout(menuPrincipalPanelLayout);
        menuPrincipalPanelLayout.setHorizontalGroup(
            menuPrincipalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPrincipalPanelLayout.createSequentialGroup()
                .addGap(706, 706, 706)
                .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 1, Short.MAX_VALUE))
            .addGroup(menuPrincipalPanelLayout.createSequentialGroup()
                .addGap(209, 209, 209)
                .addGroup(menuPrincipalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_play, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menuPrincipalPanelLayout.setVerticalGroup(
            menuPrincipalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPrincipalPanelLayout.createSequentialGroup()
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 218, Short.MAX_VALUE)
                .addComponent(b_play)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addGap(82, 82, 82))
        );

        parentPanel.add(menuPrincipalPanel, "card4");

        seleccioPanel.setBackground(new java.awt.Color(0, 153, 153));

        jButton2.setBackground(new java.awt.Color(204, 204, 204));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jButton2.setText("Quick game");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(204, 204, 204));
        jButton3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jButton3.setText("Import");

        jButton4.setBackground(new java.awt.Color(204, 204, 204));
        jButton4.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        jButton4.setText("Resume");

        javax.swing.GroupLayout seleccioPanelLayout = new javax.swing.GroupLayout(seleccioPanel);
        seleccioPanel.setLayout(seleccioPanelLayout);
        seleccioPanelLayout.setHorizontalGroup(
            seleccioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seleccioPanelLayout.createSequentialGroup()
                .addGap(262, 262, 262)
                .addGroup(seleccioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(297, Short.MAX_VALUE))
        );
        seleccioPanelLayout.setVerticalGroup(
            seleccioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(seleccioPanelLayout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jButton2)
                .addGap(18, 18, 18)
                .addComponent(jButton3)
                .addGap(28, 28, 28)
                .addComponent(jButton4)
                .addContainerGap(136, Short.MAX_VALUE))
        );

        parentPanel.add(seleccioPanel, "card3");

        getContentPane().add(parentPanel, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(716, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_playMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_playMouseClicked

    }//GEN-LAST:event_b_playMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        VistaRanking v = new VistaRanking(cv);
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1MouseClicked

    private void b_userProfileMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_userProfileMouseClicked
        VistaProfile v = new VistaProfile(cv);
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_b_userProfileMouseClicked

    private void b_playActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_playActionPerformed
        parentPanel.removeAll();
        parentPanel.add(seleccioPanel);
        parentPanel.repaint();
        parentPanel.revalidate();
    }//GEN-LAST:event_b_playActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(VistaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaMenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaMenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_play;
    private javax.swing.JLabel b_userProfile;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel l_username;
    private javax.swing.JPanel menuPrincipalPanel;
    private javax.swing.JPanel parentPanel;
    private javax.swing.JPanel seleccioPanel;
    private javax.swing.JPanel topBarPanel;
    // End of variables declaration//GEN-END:variables
}
