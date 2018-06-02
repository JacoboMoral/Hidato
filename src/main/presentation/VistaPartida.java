/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.presentation;

import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    int hora = 0;
    int min = 0;
    int segons = 0;
    private boolean inputsAllowed = true;
    
    Thread cronometre = new Thread() {
        @Override public void run() {
            
            for (;;) {
            for (hora = 0; hora < 60; hora++) {
                for (min = 0; min < 60; min++) {
                    for (segons = 0; segons < 60; segons++) {
                        try {
                            if (segons < 10 && min < 10 && hora < 10) crono.setText("0" + hora + ":" + "0" + min + ":" + "0" + segons);
                            else if (segons < 10 && min >= 10 && hora < 10) crono.setText("0" + hora + ":" + min + ":" + "0" + segons);                           
                            else if (segons >= 10) crono.setText("0" + hora + ":" + "0" + min + ":" + segons);
                            else if (segons >= 10 && min >= 10) crono.setText("0" + hora + ":" + min + ":" + segons);
                            else if (segons < 10 && min < 10 && hora >= 10) crono.setText(hora + ":" + "0" + min + ":" + "0" + segons);
                            else if (segons < 10 && min >= 10 && hora >= 10) crono.setText(hora + ":" + min + ":" + "0" + segons);
                            else if (segons >= 10 && min >= 10 && hora >= 10) crono.setText(hora + ":" + min + ":" + segons);
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
    

    /**
     * Creates new form NewJFrame
     */
    public VistaPartida() {
        initComponents();
        
    }
    
    public VistaPartida(int level, int type, String username) {
        initComponents();
        
        partida.setView(this);
        if (level == levelEasy) {
            if (type == 1) {
                System.out.println("estoy en hexagon");
                hidatoPanel = partida.partidaAutogenerada(TipusCella.HEXAGON, Dificultat.FACIL);
            }
            if (type == 2) {
                hidatoPanel = partida.partidaAutogenerada(TipusCella.TRIANGLE, Dificultat.FACIL);
            } else {
                hidatoPanel = partida.partidaAutogenerada(TipusCella.QUADRAT, Dificultat.FACIL);
            }
        }
        if (level == levelInter) {
            if (type == 1) {
                hidatoPanel = partida.partidaAutogenerada(TipusCella.HEXAGON, Dificultat.MIG);
            }
            if (type == 2) {
                hidatoPanel = partida.partidaAutogenerada(TipusCella.TRIANGLE, Dificultat.MIG);
            } else {
                hidatoPanel = partida.partidaAutogenerada(TipusCella.QUADRAT, Dificultat.MIG);
            }
        }
        if (level == levelHard) {
            if (type == 1) {
                hidatoPanel = partida.partidaAutogenerada(TipusCella.HEXAGON, Dificultat.DIFICIL);
            }
            if (type == 2) {
                hidatoPanel = partida.partidaAutogenerada(TipusCella.TRIANGLE, Dificultat.DIFICIL);
            } else {
                hidatoPanel = partida.partidaAutogenerada(TipusCella.QUADRAT, Dificultat.DIFICIL);
            }
        }
        this.add(hidatoPanel);
        seguentMoviment = Integer.toString(partida.getSeguentMoviment());
        jLabel1.setText(seguentMoviment);
        
        this.validate();
        
    }
    
    public VistaPartida(javax.swing.JPanel hidatoPanel) {
        initComponents();
        partida.setView(this);
        this.hidatoPanel = hidatoPanel;
        this.add(this.hidatoPanel);
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

        optionPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        saveGame = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        playButton = new javax.swing.JButton();
        crono = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        hidatoPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        optionPanel.setBackground(new java.awt.Color(0, 153, 153));

        jLabel1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jButton1.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jButton1.setText(">");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        jButton2.setText("<");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
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

        playButton.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        playButton.setText("PLAY");
        playButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                playButtonActionPerformed(evt);
            }
        });

        crono.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        crono.setText("00:00:00");
        crono.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bombilla.png"))); // NOI18N
        jLabel4.setToolTipText("");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

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
                .addGap(140, 140, 140)
                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(optionPanelLayout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(crono)
                    .addComponent(playButton, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
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
                        .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(playButton)
                            .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel1)
                                .addComponent(jButton2)
                                .addComponent(jButton1)))
                        .addGap(18, 18, 18)
                        .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(crono, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(14, Short.MAX_VALUE))))
        );

        getContentPane().add(optionPanel, java.awt.BorderLayout.PAGE_END);

        hidatoPanel.setBackground(new java.awt.Color(0, 204, 204));

        javax.swing.GroupLayout hidatoPanelLayout = new javax.swing.GroupLayout(hidatoPanel);
        hidatoPanel.setLayout(hidatoPanelLayout);
        hidatoPanelLayout.setHorizontalGroup(
            hidatoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 904, Short.MAX_VALUE)
        );
        hidatoPanelLayout.setVerticalGroup(
            hidatoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 688, Short.MAX_VALUE)
        );

        getContentPane().add(hidatoPanel, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(920, 864));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        cn.openMenuView();
        this.dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        if (inputsAllowed) partida.reset();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void playButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_playButtonActionPerformed
        cronometre.start();

    }//GEN-LAST:event_playButtonActionPerformed

    private void saveGameMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_saveGameMousePressed
    	if (inputsAllowed) partida.guardarPartida();
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
    		int input = JOptionPane.showOptionDialog(null, "Si decideixes solucionar la partida, no et contarà com feta. Vols solucionar-la igualment?","Advertencia",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

            if (input == JOptionPane.OK_OPTION) {
            	partida.solucionarPartida();
            	long temps = partida.tempsSolucionarPartida();
            	if (temps > 5000000) {
            		temps = temps/1000000;
                	JOptionPane.showMessageDialog(this, "El temps que s'ha tardat en solucionar aquest hidato ha estat: " + temps + " milisegons", "Informacio",1);
            	}
            	
            	else if (temps > 5000) {
            		temps = temps/1000;
                	JOptionPane.showMessageDialog(this, "El temps que s'ha tardat en solucionar aquest hidato ha estat: " + temps + " microsegons", "Informacio",1);
            	}
            	else {
                	JOptionPane.showMessageDialog(this, "El temps que s'ha tardat en solucionar aquest hidato ha estat: " + temps + " nanosegons", "Informacio",1);
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
    private javax.swing.JLabel crono;
    private javax.swing.JPanel hidatoPanel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JButton playButton;
    private javax.swing.JLabel saveGame;
    // End of variables declaration//GEN-END:variables
}
