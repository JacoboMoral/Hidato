/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.presentation;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import main.domain.com.hidato.Usuari;

/**
 *
 * @author admin
 */
public class VistaRegistrar extends javax.swing.JFrame {

    ControladorPresentacio cp = ControladorPresentacio.getInstance();
    /**
     * Creates new form VistaRegistrar
     */
    public VistaRegistrar() {
        initComponents();
        this.setTitle("Registrar");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator3 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        label = new javax.swing.JLabel();
        usernameField = new javax.swing.JTextField();
        label2 = new javax.swing.JLabel();
        label3 = new javax.swing.JLabel();
        crearUsuariButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        fieldRepeatPasword = new javax.swing.JPasswordField();
        registrationTitle = new javax.swing.JLabel();
        cancelButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Hidato - Register");
        setBackground(new java.awt.Color(36, 67, 65));
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        label.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        label.setText("Nom:");

        usernameField.setBackground(new java.awt.Color(204, 204, 204));
        usernameField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        usernameField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        usernameField.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        usernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameFieldActionPerformed(evt);
            }
        });

        label2.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        label2.setText("Contrasenya:");

        label3.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        label3.setText("Repetir contrasenya:");

        crearUsuariButton.setBackground(new java.awt.Color(255, 255, 255));
        crearUsuariButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        crearUsuariButton.setText("Crear");
        crearUsuariButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                crearUsuariButtonMouseClicked(evt);
            }
        });
        crearUsuariButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crearUsuariButtonActionPerformed(evt);
            }
        });

        passwordField.setBackground(new java.awt.Color(204, 204, 204));
        passwordField.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        passwordField.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        passwordField.setDisabledTextColor(new java.awt.Color(204, 204, 204));
        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        fieldRepeatPasword.setBackground(new java.awt.Color(204, 204, 204));
        fieldRepeatPasword.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        fieldRepeatPasword.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        fieldRepeatPasword.setDisabledTextColor(new java.awt.Color(204, 204, 204));

        registrationTitle.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        registrationTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        registrationTitle.setText("Registrar");

        cancelButton.setBackground(new java.awt.Color(255, 255, 255));
        cancelButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        cancelButton.setText("Cancel.lar");
        cancelButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelButtonMouseClicked(evt);
            }
        });
        cancelButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(176, 176, 176)
                .addComponent(registrationTitle)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(cancelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(usernameField)
                    .addComponent(passwordField)
                    .addComponent(label2)
                    .addComponent(label)
                    .addComponent(label3)
                    .addComponent(fieldRepeatPasword)
                    .addComponent(crearUsuariButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(198, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(registrationTitle)
                .addGap(53, 53, 53)
                .addComponent(label)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(label2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addComponent(label3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(fieldRepeatPasword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(crearUsuariButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cancelButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(516, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancelButtonActionPerformed

    private void cancelButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelButtonMouseClicked
        Inici v = new Inici();
        v.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelButtonMouseClicked

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void crearUsuariButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crearUsuariButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_crearUsuariButtonActionPerformed

    private void crearUsuariButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_crearUsuariButtonMouseClicked
        String name, password, rPassword;
        name = usernameField.getText();
        password = new String(passwordField.getPassword());
        rPassword = new String(fieldRepeatPasword.getPassword());
        if (name.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Enter your name please!");
        }
        else if (password.length() == 0) {
            JOptionPane.showMessageDialog(null, "Enter your password please!");
        }
        else if (rPassword.length() == 0) {
            JOptionPane.showMessageDialog(null, "Enter again your password please!");
        }
        else if (password.equals(rPassword) && !password.isEmpty() && !rPassword.isEmpty()) {
            boolean successful = false;
            try {
                successful = cp.afegirUsuari(name, password);
            } catch (IOException ex) {
                Logger.getLogger(VistaRegistrar.class.getName()).log(Level.SEVERE, null, ex);
            }
          
            if (successful) {
                int input = JOptionPane.showOptionDialog(null, "Registration done!", "Message",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

                if (input == JOptionPane.OK_OPTION) {
                    Inici v = new Inici();
                    v.setVisible(true);
                    this.dispose();
                }
                else {
                    Inici v = new Inici();
                    v.setVisible(true);
                    this.dispose();
                }

            } else {
                int input = JOptionPane.showOptionDialog(null, "The user is already exists, please try it again!", "Error message",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

                if (input == JOptionPane.OK_OPTION) {
                    usernameField.setText("");
                    passwordField.setText("");
                    fieldRepeatPasword.setText("");
                }

            }
        }
        else {
            int input = JOptionPane.showOptionDialog(null, "The passwords not match! Correct it.", "Error message",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

            if (input == JOptionPane.OK_OPTION) {
                fieldRepeatPasword.setText("");
            }

        }
    }//GEN-LAST:event_crearUsuariButtonMouseClicked

    private void usernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameFieldActionPerformed

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
            java.util.logging.Logger.getLogger(VistaRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRegistrar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRegistrar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelButton;
    private javax.swing.JButton crearUsuariButton;
    private javax.swing.JPasswordField fieldRepeatPasword;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel label;
    private javax.swing.JLabel label2;
    private javax.swing.JLabel label3;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel registrationTitle;
    private javax.swing.JTextField usernameField;
    // End of variables declaration//GEN-END:variables
}
