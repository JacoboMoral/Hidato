/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.presentation;

import com.sun.awt.AWTUtilities;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author admin
 */
public class VistaLoading extends javax.swing.JFrame implements Runnable{

    private Thread tiempo = null;
    private static final int levelEasy = 1;
    private static final int levelInter = 2;
    private static final int levelHard = 3;
    private int level;
    ControladorPresentacio cp = ControladorPresentacio.getInstance();
    VistaMenuPrincipal vMP;
    /**
     * Creates new form VistaLoading
     */

    public VistaLoading() {
    	initComponents();
        tiempo = new Thread(this);
        tiempo.start();
        this.setOpacity((float) 0.5);
    }

    public VistaLoading(int dificultat, VistaMenuPrincipal aThis) {
        initComponents();
        level = dificultat;
        tiempo = new Thread(this);
        tiempo.start();
        vMP = aThis;
        this.setOpacity((float) 0.5);
    }
    
    public void close() {
    	this.dispose();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 50)); // NOI18N
        jLabel1.setText("Carregant...");

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/cargando.gif"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3)
                .addGap(10, 10, 10)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        setSize(new java.awt.Dimension(401, 87));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VistaLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaLoading.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaLoading().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    // End of variables declaration//GEN-END:variables

    @Override
    public void run() {
        while(tiempo != null){
                tiempo = null;
            if (level == levelEasy) {

                VistaPartida v = new VistaPartida(levelEasy, 1, cp.getUsername());
                //Thread.sleep(1000);
                v.setVisible(true);

                vMP.dispose();
                this.dispose();
            }
            else if (level == levelInter) {
                VistaPartida v = new VistaPartida(levelInter, 1, cp.getUsername());
                //Thread.sleep(1000);
                v.setVisible(true);
                vMP.dispose();
                this.dispose();
            }
            else {
                VistaPartida v = new VistaPartida(levelHard, 1, cp.getUsername());
                //Thread.sleep(1000);
                v.setVisible(true);
                vMP.dispose();
                this.dispose();
            }
        }
    }
}
