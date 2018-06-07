/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.presentation;

import java.awt.Color;
import main.domain.com.hidato.TipusAdjacencia;
import javax.swing.JOptionPane;
/**
 *
 * @author admin
 */
public class VistaPartida extends javax.swing.JFrame {

    private ControladorPresentacio controladorPresentacio = ControladorPresentacio.getInstance();
    ControladorPartida partida = ControladorPartida.getInstance();
    ControladorNavegacio controladorNavegacio = ControladorNavegacio.getInstance();
    private String seguentMoviment = " ";
    private boolean inputsAllowed = true;
    private boolean ajuda = false;
    int textHora = 0;
    int textMin = 0;
    int textSegons = 0;

    public VistaPartida() {
        initComponents();
    }

    public VistaPartida(javax.swing.JPanel hidatoPanel) {
        initComponents();
        this.setTitle("Partida");
        partida.setView(this);
        this.hidatoPanel = hidatoPanel;
        this.add(this.hidatoPanel);
        seguentMoviment = Integer.toString(partida.getSeguentMoviment());
        numActual.setText(seguentMoviment);
        tipusAdjacencia.setText(TipusAdjacenciaToString(controladorPresentacio.getTipusAdjacenciaPartida()));
        this.validate();
    }

    public void setPartidaAcabada() {
        int puntuacio = partida.getPuntuacioPartida();
        long temps = partida.tempsSolucionarPartida();
        String currentUsername = controladorPresentacio.getUsername();
        temps = temps / 1000000;
        double tempsSegons = (double) temps / 1000;
        int segons = (int) Math.floor(tempsSegons);
        double milisegons = tempsSegons - segons;
        milisegons *= 1000;

        JOptionPane.showMessageDialog(this, "El temps de partida ha estat: " + segons + "," + (int) milisegons + " segons.\nLa puntuacio total es de " + puntuacio + " punts.", "Informacio", 1);
        controladorPresentacio.saveScore(controladorPresentacio.getDificultatPartida(), currentUsername, puntuacio);
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
        numActual = new javax.swing.JLabel();
        seguentNum = new javax.swing.JButton();
        anteriorNum = new javax.swing.JButton();
        help = new javax.swing.JButton();
        back = new javax.swing.JLabel();
        guardarPartida = new javax.swing.JLabel();
        borrarNumeros = new javax.swing.JLabel();
        solucionarHidato = new javax.swing.JLabel();
        tipusAdjacencia = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        hidatoPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(400, 400));
        addMouseWheelListener(new java.awt.event.MouseWheelListener() {
            public void mouseWheelMoved(java.awt.event.MouseWheelEvent evt) {
                formMouseWheelMoved(evt);
            }
        });

        optionPanel.setBackground(new java.awt.Color(204, 204, 204));

        numActual.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        numActual.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        seguentNum.setBackground(new java.awt.Color(255, 255, 255));
        seguentNum.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        seguentNum.setText(">");
        seguentNum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                seguentNumMousePressed(evt);
            }
        });

        anteriorNum.setBackground(new java.awt.Color(255, 255, 255));
        anteriorNum.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        anteriorNum.setText("<");
        anteriorNum.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                anteriorNumMousePressed(evt);
            }
        });

        help.setBackground(new java.awt.Color(255, 135, 135));
        help.setFont(new java.awt.Font("Century Gothic", 0, 24)); // NOI18N
        help.setText("Ajuda");
        help.setToolTipText("Activar/desactivar ajut en el joc");
        help.setFocusPainted(false);
        help.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                helpMousePressed(evt);
            }
        });

        back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/anterior.png"))); // NOI18N
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });

        guardarPartida.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/save.png"))); // NOI18N
        guardarPartida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                guardarPartidaMousePressed(evt);
            }
        });

        borrarNumeros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/resetIcon.png"))); // NOI18N
        borrarNumeros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrarNumerosMouseClicked(evt);
            }
        });

        solucionarHidato.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/bombilla.png"))); // NOI18N
        solucionarHidato.setToolTipText("");
        solucionarHidato.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                solucionarHidatoMousePressed(evt);
            }
        });

        tipusAdjacencia.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel5.setText("Tipus d'adjacencia:");

        javax.swing.GroupLayout optionPanelLayout = new javax.swing.GroupLayout(optionPanel);
        optionPanel.setLayout(optionPanelLayout);
        optionPanelLayout.setHorizontalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionPanelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(back)
                .addGap(18, 18, 18)
                .addComponent(borrarNumeros)
                .addGap(18, 18, 18)
                .addComponent(guardarPartida)
                .addGap(18, 18, 18)
                .addComponent(solucionarHidato)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 160, Short.MAX_VALUE)
                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(help, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(optionPanelLayout.createSequentialGroup()
                        .addComponent(anteriorNum)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numActual, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(seguentNum)))
                .addGap(94, 94, 94)
                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(tipusAdjacencia, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(39, 39, 39))
        );
        optionPanelLayout.setVerticalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionPanelLayout.createSequentialGroup()
                        .addGap(10, 58, Short.MAX_VALUE)
                        .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(borrarNumeros, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(guardarPartida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(solucionarHidato, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(45, 45, 45))
                    .addGroup(optionPanelLayout.createSequentialGroup()
                        .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(numActual, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(anteriorNum)
                                .addComponent(seguentNum)))
                        .addGap(29, 29, 29)
                        .addComponent(help, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tipusAdjacencia, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46))
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

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        controladorNavegacio.openMenuView();
        this.dispose();
    }//GEN-LAST:event_backMouseClicked

    private void borrarNumerosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrarNumerosMouseClicked
        if (inputsAllowed) {
            partida.reset();
        }
    }//GEN-LAST:event_borrarNumerosMouseClicked

    private void guardarPartidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_guardarPartidaMousePressed
    	if (inputsAllowed) {
    		if (partida.guardarPartida()) {
    			controladorNavegacio.openMenuView();
				this.dispose();
            };
        }
    }//GEN-LAST:event_guardarPartidaMousePressed

    private void seguentNumMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_seguentNumMousePressed
        if (inputsAllowed) {
            int seguentMov = partida.incrementarSeguentMoviment();
            if (seguentMov != -1) {
                numActual.setText(Integer.toString(seguentMov));
            }
        }
    }//GEN-LAST:event_seguentNumMousePressed

    private void solucionarHidatoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_solucionarHidatoMousePressed
        if (inputsAllowed) {
            int input = JOptionPane.showOptionDialog(null, "Si decideixes solucionar la partida, no et contarà com feta. Vols solucionar-la igualment?", "Advertencia",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

            if (input == JOptionPane.OK_OPTION) {
                this.blockPartidaInputs();
                partida.solucionarPartida();
            }
        }
    }//GEN-LAST:event_solucionarHidatoMousePressed

    private void blockPartidaInputs() {
        inputsAllowed = false;
    }

    private void allowPartidaInputs() {
        inputsAllowed = true;
    }

	private void anteriorNumMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_anteriorNumMousePressed

            if (inputsAllowed) {
                int seguentMov = partida.decrementarSeguentMoviment();
                if (seguentMov != -1) {
                    numActual.setText(Integer.toString(seguentMov));
                }
            }
    }//GEN-LAST:event_anteriorNumMousePressed

    private void helpMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMousePressed
        if (ajuda == false) {
            ajuda = true;
            help.setBackground(new Color(135, 255, 137));
        } else {
            ajuda = false;
            help.setBackground(new Color(255, 135, 135));
        }
        partida.setAjuda(ajuda);
    }//GEN-LAST:event_helpMousePressed

    private void formMouseWheelMoved(java.awt.event.MouseWheelEvent evt) {//GEN-FIRST:event_formMouseWheelMoved
        if (inputsAllowed) {
            if (evt.getWheelRotation() < 0) {
                int seguentMov = partida.incrementarSeguentMoviment();
                if (seguentMov != -1) {
                    numActual.setText(Integer.toString(seguentMov));
                }
            } else {
                int seguentMov = partida.decrementarSeguentMoviment();
                if (seguentMov != -1) {
                    numActual.setText(Integer.toString(seguentMov));
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
        numActual.setText(moviment);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anteriorNum;
    private javax.swing.JLabel back;
    private javax.swing.JLabel borrarNumeros;
    private javax.swing.JLabel guardarPartida;
    private javax.swing.JButton help;
    private javax.swing.JPanel hidatoPanel;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel numActual;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JButton seguentNum;
    private javax.swing.JLabel solucionarHidato;
    private javax.swing.JLabel tipusAdjacencia;
    // End of variables declaration//GEN-END:variables

    public void solucionat() {
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
        allowPartidaInputs();
    }
}
