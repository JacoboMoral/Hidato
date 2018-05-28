/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.presentation;

import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

import static main.presentation.ControladorPresentacio.panelPartida;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 *
 * @author admin
 */
public class VistaPartida extends javax.swing.JFrame {
    CtrlVista cv;
    private static final int levelEasy = 1;
    private static final int levelInter = 2;
    private static final int levelHard = 3;
    ControladorPartida partida = ControladorPartida.getInstance();
    private String seguentMoviment = " ";
    /**
     * Creates new form NewJFrame
     */
    public VistaPartida() {
        initComponents();
    }

    public VistaPartida(CtrlVista v, int level, int type) {
        initComponents();

        cv = v;
        partida.setView(this);
        if (level == levelEasy) {
            if (type == 1) {
                System.out.println("estoy en hexagon");
                hidatoPanel = partida.partidaAutogenerada(TipusCella.HEXAGON, Dificultat.FACIL);
            }
            if (type == 2) hidatoPanel = partida.partidaAutogenerada(TipusCella.TRIANGLE, Dificultat.FACIL);
            else hidatoPanel = partida.partidaAutogenerada(TipusCella.QUADRAT, Dificultat.FACIL);
        }
        if (level == levelInter) {
            if (type == 1) hidatoPanel = partida.partidaAutogenerada(TipusCella.HEXAGON, Dificultat.MIG);
            if (type == 2) hidatoPanel = partida.partidaAutogenerada(TipusCella.TRIANGLE, Dificultat.MIG);
            else hidatoPanel = partida.partidaAutogenerada(TipusCella.QUADRAT, Dificultat.MIG);
        }
        if (level == levelHard) {
            if (type == 1) hidatoPanel = partida.partidaAutogenerada(TipusCella.HEXAGON, Dificultat.DIFICIL);
            if (type == 2) hidatoPanel = partida.partidaAutogenerada(TipusCella.TRIANGLE, Dificultat.DIFICIL);
            else hidatoPanel = partida.partidaAutogenerada(TipusCella.QUADRAT, Dificultat.DIFICIL);
        }
        this.add(hidatoPanel);
        seguentMoviment = Integer.toString(partida.getSeguentMoviment());
        jLabel1.setText(seguentMoviment);

        this.validate();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        controlPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        saveGame = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        hidatoPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        controlPanel.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setText("s");

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jButton1.setText(">");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jButton2.setText("<");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jButton3.setText("Help");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/anterior.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        saveGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save.png"))); // NOI18N

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/resetIcon.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout controlPanelLayout = new javax.swing.GroupLayout(controlPanel);
        controlPanel.setLayout(controlPanelLayout);
        controlPanelLayout.setHorizontalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(saveGame)
                .addGap(201, 201, 201)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(controlPanelLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(42, 42, 42)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jButton1)))
                .addContainerGap(345, Short.MAX_VALUE))
        );
        controlPanelLayout.setVerticalGroup(
            controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(controlPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(23, 23, 23)
                .addComponent(jButton3)
                .addContainerGap(20, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, controlPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(controlPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(saveGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(45, 45, 45))
        );

        getContentPane().add(controlPanel, java.awt.BorderLayout.PAGE_END);

        hidatoPanel.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout hidatoPanelLayout = new javax.swing.GroupLayout(hidatoPanel);
        hidatoPanel.setLayout(hidatoPanelLayout);
        hidatoPanelLayout.setHorizontalGroup(
            hidatoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 904, Short.MAX_VALUE)
        );
        hidatoPanelLayout.setVerticalGroup(
            hidatoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 694, Short.MAX_VALUE)
        );

        getContentPane().add(hidatoPanel, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(920, 864));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        VistaMenuPrincipal v = new VistaMenuPrincipal(cv);
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        partida.reset();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        int seguentMov = partida.decrementarSeguentMoviment();
        if (seguentMov != -1) {
            jLabel1.setText(Integer.toString(seguentMov));
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        int seguentMov = partida.incrementarSeguentMoviment();
        if (seguentMov != -1) {
            jLabel1.setText(Integer.toString(seguentMov));
        }
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(VistaPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaPartida.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPartida().setVisible(true);
            }
        });
    }
    
    public void incrementarSeguentMoviment() {
        int seguentMov = partida.incrementarSeguentMoviment();
        if (seguentMov != -1) {
            jLabel1.setText(Integer.toString(seguentMov));
        }
    }

    public void decrementarSeguentMoviment() {
        int seguentMov = partida.decrementarSeguentMoviment();
        if (seguentMov != -1) {
            jLabel1.setText(Integer.toString(seguentMov));
        }
    }

    public void updateSeguentMoviment(String moviment) {
        jLabel1.setText(moviment);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel controlPanel;
    private javax.swing.JPanel hidatoPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel saveGame;
    // End of variables declaration//GEN-END:variables
}
