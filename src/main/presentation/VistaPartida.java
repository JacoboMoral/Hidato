/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.presentation;

import java.awt.Color;
import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

import main.domain.com.hidato.Contador;

/**
 *
 * @author admin
 */
public class VistaPartida extends javax.swing.JFrame {

    private ControladorPresentacio cp = ControladorPresentacio.getInstance();
    private static final int levelEasy = 1;
    private static final int levelInter = 2;
    private static final int levelHard = 3;
    ControladorPartida partida = ControladorPartida.getInstance();
    ControladorNavegacio cn = ControladorNavegacio.getInstance();
    private String seguentMoviment = " ";
    private int nivellPartida;
    private boolean inputsAllowed = true;
    private boolean ajuda = false;
    int textHora = 0;
    int textMin = 0;
    int textSegons = 0;

    Thread cronometre = new Thread() {
        @Override
        public void run() {

            for (;;) {
                for (textHora = 0; textHora < 60; textHora++) {
                    for (textMin = 0; textMin < 60; textMin++) {
                        for (textSegons = 0; textSegons < 60; textSegons++) {
                            try {
                                if (textSegons < 10 && textMin < 10 && textHora < 10) {
                                    crono.setText("0" + textHora + ":" + "0" + textMin + ":" + "0" + textSegons);
                                } else if (textSegons < 10 && textMin >= 10 && textHora < 10) {
                                    crono.setText("0" + textHora + ":" + textMin + ":" + "0" + textSegons);
                                } else if (textSegons >= 10) {
                                    crono.setText("0" + textHora + ":" + "0" + textMin + ":" + textSegons);
                                } else if (textSegons >= 10 && textMin >= 10) {
                                    crono.setText("0" + textHora + ":" + textMin + ":" + textSegons);
                                } else if (textSegons < 10 && textMin < 10 && textHora >= 10) {
                                    crono.setText(textHora + ":" + "0" + textMin + ":" + "0" + textSegons);
                                } else if (textSegons < 10 && textMin >= 10 && textHora >= 10) {
                                    crono.setText(textHora + ":" + textMin + ":" + "0" + textSegons);
                                } else if (textSegons >= 10 && textMin >= 10 && textHora >= 10) {
                                    crono.setText(textHora + ":" + textMin + ":" + textSegons);
                                }
                                Thread.sleep(1000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(VistaPartida.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        }
                    }
                }
            }
        }
    };

    public VistaPartida() {
        initComponents();
    }

    public VistaPartida(int level, String username) {
        initComponents();
        this.setTitle("Partida");
        cronometre.start();
        nivellPartida = level;
        partida.setView(this);
        if (level == levelEasy) {
            hidatoPanel = partida.partidaAutogenerada(Dificultat.FACIL);
        }
        if (level == levelInter) {
            hidatoPanel = partida.partidaAutogenerada(Dificultat.MIG);
        }
        if (level == levelHard) {
            hidatoPanel = partida.partidaAutogenerada(Dificultat.DIFICIL);
        }
        this.add(hidatoPanel);
        seguentMoviment = Integer.toString(partida.getSeguentMoviment());
        jLabel1.setText(seguentMoviment);

        tipusAdjacencia.setText(TipusAdjacenciaToString(cp.getTipusAdjacenciaPartida()));
        this.validate();

    }

    public VistaPartida(javax.swing.JPanel hidatoPanel) {
        initComponents();
        this.setTitle("Partida");
        cronometre.start();
        Dificultat dif = cp.getDificultatPartida();
        if (dif == Dificultat.FACIL) {
            nivellPartida = levelEasy;
        }
        if (dif == Dificultat.MIG) {
            nivellPartida = levelInter;
        }
        if (dif == Dificultat.DIFICIL) {
            nivellPartida = levelHard;
        }
        partida.setView(this);
        this.hidatoPanel = hidatoPanel;
        this.add(this.hidatoPanel);
        seguentMoviment = Integer.toString(partida.getSeguentMoviment());
        jLabel1.setText(seguentMoviment);
        tipusAdjacencia.setText(TipusAdjacenciaToString(cp.getTipusAdjacenciaPartida()));
        this.validate();
    }

    public void setPartidaAcabada() {
        int puntuacio = partida.getPuntuacioPartida();
        long temps = partida.tempsSolucionarPartida();
        String currentUsername = cp.getUsername();
        temps = temps / 1000000;
        double tempsSegons = (double) temps / 1000;
        int segons = (int) Math.floor(tempsSegons);
        double milisegons = tempsSegons - segons;
        milisegons *= 1000;

        JOptionPane.showMessageDialog(this, "El temps de partida ha estat: " + segons + "," + (int) milisegons + " segons.\nLa puntuacio total es de " + puntuacio + " punts.", "Informacio", 1);
        cp.saveScore(nivellPartida, currentUsername, puntuacio);
        blockPartidaInputs();
    }

    private String TipusAdjacenciaToString(TipusAdjacencia tipusAdjacencia) {
        if (tipusAdjacencia == TipusAdjacencia.COSTATS) {
            return "Costats";
        }
        if (tipusAdjacencia == TipusAdjacencia.COSTATSIANGLES) {
            return "Costats i angles";
        }
        return " ";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        optionPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        saveGame = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        tipusAdjacencia = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        crono = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        hidatoPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });

        optionPanel.setBackground(new java.awt.Color(204, 204, 204));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jButton1.setText(">");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jButton2.setText("<");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(255, 135, 135));
        jButton3.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jButton3.setText("Ajuda");
        jButton3.setToolTipText("Activar/desactivar ajut en el joc");
        jButton3.setFocusPainted(false);
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/anterior.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });

        saveGame.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save.png"))); // NOI18N
        saveGame.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                saveGameMousePressed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/resetIcon.png"))); // NOI18N
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bombilla.png"))); // NOI18N
        jLabel4.setToolTipText("");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        tipusAdjacencia.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setText("Tipus d'adjacencia:");

        crono.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        crono.setText("00:00:00");
        crono.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/stopwatch.png"))); // NOI18N

        javax.swing.GroupLayout optionPanelLayout = new javax.swing.GroupLayout(optionPanel);
        optionPanel.setLayout(optionPanelLayout);
        optionPanelLayout.setHorizontalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(saveGame)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 141, Short.MAX_VALUE)
                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(optionPanelLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 92, Short.MAX_VALUE)
                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(tipusAdjacencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(optionPanelLayout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(crono)))
                .addGap(43, 43, 43))
        );
        optionPanelLayout.setVerticalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(saveGame, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45))
                    .addGroup(optionPanelLayout.createSequentialGroup()
                        .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(optionPanelLayout.createSequentialGroup()
                                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(jButton1)))
                                .addGap(29, 29, 29)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(optionPanelLayout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(crono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tipusAdjacencia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(16, Short.MAX_VALUE))))
        );

        getContentPane().add(optionPanel, java.awt.BorderLayout.PAGE_END);

        hidatoPanel.setBackground(new java.awt.Color(204, 204, 204));

        javax.swing.GroupLayout hidatoPanelLayout = new javax.swing.GroupLayout(hidatoPanel);
        hidatoPanel.setLayout(hidatoPanelLayout);
        hidatoPanelLayout.setHorizontalGroup(
            hidatoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 870, Short.MAX_VALUE)
        );
        hidatoPanelLayout.setVerticalGroup(
            hidatoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 552, Short.MAX_VALUE)
        );

        getContentPane().add(hidatoPanel, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(886, 739));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        cn.openMenuView();
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        if (inputsAllowed) {
            partida.reset();
        }
    }//GEN-LAST:event_jLabel3MouseClicked

    private void saveGameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveGameMousePressed
        if (inputsAllowed) {
            partida.guardarPartida();
            cn.openMenuView();
            this.dispose();
        }
    }//GEN-LAST:event_saveGameMousePressed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        if (inputsAllowed) {
            int seguentMov = partida.incrementarSeguentMoviment();
            if (seguentMov != -1) {
                jLabel1.setText(Integer.toString(seguentMov));
            }
        }
    }//GEN-LAST:event_jButton1MousePressed

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        if (inputsAllowed) {
            int input = JOptionPane.showOptionDialog(null, "Si decideixes solucionar la partida, no et contarà com feta. Vols solucionar-la igualment?", "Advertencia",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

            if (input == JOptionPane.OK_OPTION) {

                partida.solucionarPartida();
                long temps = partida.tempsSolucionarPartida();
                if (temps > 5000000) {
                    temps = temps / 1000000;
                    JOptionPane.showMessageDialog(this, "El temps que s'ha tardat en solucionar aquest hidato ha estat: " + temps + " milisegons", "Informacio", 1);
                } else if (temps > 5000) {
                    temps = temps / 1000;
                    JOptionPane.showMessageDialog(this, "El temps que s'ha tardat en solucionar aquest hidato ha estat: " + temps + " microsegons", "Informacio", 1);
                } else {
                    JOptionPane.showMessageDialog(this, "El temps que s'ha tardat en solucionar aquest hidato ha estat: " + temps + " nanosegons", "Informacio", 1);
                }

                this.blockPartidaInputs();
            }
        }
    }//GEN-LAST:event_jLabel4MousePressed

    private void blockPartidaInputs() {
        inputsAllowed = false;
    }

	private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed

            if (inputsAllowed) {
                int seguentMov = partida.decrementarSeguentMoviment();
                if (seguentMov != -1) {
                    jLabel1.setText(Integer.toString(seguentMov));
                }
            }
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed
        if (ajuda == false) {
            ajuda = true;
            jButton3.setBackground(new Color(135, 255, 137));
        } else {
            ajuda = false;
            jButton3.setBackground(new Color(255, 135, 135));
        }
        partida.setAjuda(ajuda);
    }//GEN-LAST:event_jButton3MousePressed

    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
        if (inputsAllowed) {
            if (evt.getWheelRotation() < 0) {
                int seguentMov = partida.incrementarSeguentMoviment();
                if (seguentMov != -1) {
                    jLabel1.setText(Integer.toString(seguentMov));
                }
            } else {
                int seguentMov = partida.decrementarSeguentMoviment();
                if (seguentMov != -1) {
                    jLabel1.setText(Integer.toString(seguentMov));
                }
            }
        }
    }//GEN-LAST:event_formMouseWheelMoved

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
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaPartida().setVisible(true);

            }
        });
    }

    public void updateSeguentMoviment(String moviment) {
        jLabel1.setText(moviment);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel crono;
    private javax.swing.JPanel hidatoPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JLabel saveGame;
    private javax.swing.JLabel tipusAdjacencia;
    // End of variables declaration//GEN-END:variables
}
