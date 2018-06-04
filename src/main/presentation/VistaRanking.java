/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.presentation;

import main.domain.com.hidato.Ranking;
import main.domain.com.hidato.Posicio;
import main.domain.com.hidato.Usuari;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;

/**
 *
 * @author admin
 */
public class VistaRanking extends javax.swing.JFrame {

    private ControladorPresentacio cp = ControladorPresentacio.getInstance();
    private ControladorNavegacio cn = ControladorNavegacio.getInstance();
    private static Ranking ranking = Ranking.getInstance();
    private static final int levelEasy = 1;
    private static final int levelInter = 2;
    private static final int levelHard = 3;
    private static Ranking r = Ranking.getInstance();

    public VistaRanking() {
        initComponents();

        filterType.add(filterByDate);
        filterType.add(filterByUsername);

        /*cp.saveScore(1, "Jia", 10);
        cp.saveScore(2, "Jia2", 1450);
        cp.saveScore(3, "Jia3", 14350);
        cp.saveScore(1, "Jia2", 13242);
        cp.saveScore(2, "Jia3", 11233);
        cp.saveScore(3, "Jia2", 11235);
        cp.saveScore(1, "Jia", 131);
        cp.saveScore(2, "Jia2", 112);
        cp.saveScore(3, "Jia3", 14234);*/
        cp.getUpdate();
        
        if (cp.getRankingEasySize() > 0) {
            
            showEasyRanking();
        }
        if (cp.getRankingInterSize() > 0) {
            showInterRanking();
        }
        if (cp.getRankingHardSize() > 0) {
            showHardRanking();
        }

    }

    private void showEasyRanking() {
        DefaultListModel model = new DefaultListModel();
        String[] rankEasy = cp.getRankingEasy();
        for (int i = 0; i < rankEasy.length; ++i) {
            model.addElement(rankEasy[i]);
        }
        jList1.setModel(model);

    }

    private void showInterRanking() {
        DefaultListModel model1 = new DefaultListModel();
        String[] rankInter = cp.getRankingInter();
        for (int i = 0; i < rankInter.length; ++i) {
            model1.addElement(rankInter[i]);
        }
        jList2.setModel(model1);
    }

    private void showHardRanking() {
        DefaultListModel model2 = new DefaultListModel();

        String[] rankHard = cp.getRankingHard();

        for (int i = 0; i < rankHard.length; ++i) {
            model2.addElement(rankHard[i]);
        }
        jList3.setModel(model2);
    }

    private void showFilteredRank(String input) {
        DefaultListModel model = new DefaultListModel();
        DefaultListModel model1 = new DefaultListModel();
        DefaultListModel model2 = new DefaultListModel();

        if (filterByUsername.isSelected()) {
            if (!cp.existsUser(input)) {
                int message = JOptionPane.showOptionDialog(null, "Username not exists in the Datebase", "Error message",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            } else {
                String[] rankEasy = cp.getFilterByUsername(input, levelEasy);
                String[] rankInter = cp.getFilterByUsername(input, levelInter);
                String[] rankHard = cp.getFilterByUsername(input, levelHard);
                for (int i = 0; i < rankEasy.length; ++i) {
                    model.addElement(rankEasy[i]);
                }
                for (int i = 0; i < rankInter.length; ++i) {
                    model1.addElement(rankInter[i]);
                }
                for (int i = 0; i < rankHard.length; ++i) {
                    model2.addElement(rankHard[i]);
                }
            }
        }
        if (filterByDate.isSelected()) {
            if (validDate(input)) {
                if (!cp.existsDate(input)) {
                    int message = JOptionPane.showOptionDialog(null, "Date not exists in the Datebase", "Error message",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                } else {
                    String[] rankEasy = cp.getFilterByDate(input, levelEasy);
                    String[] rankInter = cp.getFilterByDate(input, levelInter);
                    String[] rankHard = cp.getFilterByDate(input, levelHard);
                    for (int i = 0; i < rankEasy.length; ++i) {
                        model.addElement(rankEasy[i]);
                    }
                    for (int i = 0; i < rankInter.length; ++i) {
                        model1.addElement(rankInter[i]);
                    }
                    for (int i = 0; i < rankHard.length; ++i) {
                        model2.addElement(rankHard[i]);
                    }
                }
            }
        }

        jList1.setModel(model);
        jList2.setModel(model1);
        jList3.setModel(model2);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filterType = new javax.swing.ButtonGroup();
        optionsPanel = new javax.swing.JPanel();
        user_to_delete = new javax.swing.JTextField();
        b_deleteUsr = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        t_input = new javax.swing.JTextField();
        b_filter = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        b_back = new javax.swing.JButton();
        showInterRanking = new javax.swing.JButton();
        showEasyRanking = new javax.swing.JButton();
        showHardRanking = new javax.swing.JButton();
        b_filterByUsr1 = new javax.swing.JButton();
        filterByUsername = new javax.swing.JRadioButton();
        filterByDate = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        rankingPanel = new javax.swing.JPanel();
        easyPanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        hardPanel = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        interPanel = new javax.swing.JPanel();
        titleInter = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 650));
        setResizable(false);

        optionsPanel.setBackground(new java.awt.Color(204, 204, 204));

        user_to_delete.setBackground(new java.awt.Color(204, 204, 204));
        user_to_delete.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        user_to_delete.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        b_deleteUsr.setBackground(new java.awt.Color(255, 255, 255));
        b_deleteUsr.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        b_deleteUsr.setText("Eliminar");
        b_deleteUsr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_deleteUsrMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setText("Filtrar segons:");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel12.setText("Entrada:");

        t_input.setBackground(new java.awt.Color(204, 204, 204));
        t_input.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        t_input.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        b_filter.setBackground(new java.awt.Color(255, 255, 255));
        b_filter.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        b_filter.setText("Filtrar");
        b_filter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_filterMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Eliminar puntacio del usuari:");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setText("Nom:");

        b_back.setBackground(new java.awt.Color(255, 255, 255));
        b_back.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        b_back.setText("Enrere");
        b_back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_backMouseClicked(evt);
            }
        });
        b_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                b_backActionPerformed(evt);
            }
        });

        showInterRanking.setBackground(new java.awt.Color(255, 255, 255));
        showInterRanking.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        showInterRanking.setText("Mig");
        showInterRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showInterRankingActionPerformed(evt);
            }
        });

        showEasyRanking.setBackground(new java.awt.Color(255, 255, 255));
        showEasyRanking.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        showEasyRanking.setText("Facil");
        showEasyRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showEasyRankingActionPerformed(evt);
            }
        });

        showHardRanking.setBackground(new java.awt.Color(255, 255, 255));
        showHardRanking.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        showHardRanking.setText("Dificil");
        showHardRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showHardRankingActionPerformed(evt);
            }
        });

        b_filterByUsr1.setBackground(new java.awt.Color(255, 255, 255));
        b_filterByUsr1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        b_filterByUsr1.setText("Mostrar tot");
        b_filterByUsr1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_filterByUsr1MouseClicked(evt);
            }
        });

        filterByUsername.setBackground(new java.awt.Color(204, 204, 204));
        filterByUsername.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        filterByUsername.setText("Nom");
        filterByUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterByUsernameActionPerformed(evt);
            }
        });

        filterByDate.setBackground(new java.awt.Color(204, 204, 204));
        filterByDate.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        filterByDate.setText("Data (Format: YYYY-MM-DD)");

        javax.swing.GroupLayout optionsPanelLayout = new javax.swing.GroupLayout(optionsPanel);
        optionsPanel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addContainerGap(80, Short.MAX_VALUE)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addComponent(filterByUsername)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(filterByDate))
                    .addComponent(jLabel9)
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(user_to_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(b_deleteUsr))
                    .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(optionsPanelLayout.createSequentialGroup()
                            .addComponent(showEasyRanking)
                            .addGap(117, 117, 117)
                            .addComponent(showInterRanking)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(showHardRanking))
                        .addGroup(optionsPanelLayout.createSequentialGroup()
                            .addComponent(jLabel12)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(t_input, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(32, 32, 32)
                            .addComponent(b_filter, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(b_filterByUsr1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(68, 68, 68))
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jSeparator1)
        );
        optionsPanelLayout.setVerticalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(showHardRanking)
                    .addComponent(showInterRanking)
                    .addComponent(showEasyRanking))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(user_to_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_deleteUsr))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterByUsername)
                    .addComponent(filterByDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(b_filter)
                    .addComponent(b_filterByUsr1)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addComponent(b_back)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        getContentPane().add(optionsPanel, java.awt.BorderLayout.CENTER);

        rankingPanel.setLayout(new java.awt.CardLayout());

        easyPanel.setBackground(new java.awt.Color(204, 204, 204));
        easyPanel.setPreferredSize(new java.awt.Dimension(579, 430));

        title.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        title.setText("Ranking-Facil");

        jList1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout easyPanelLayout = new javax.swing.GroupLayout(easyPanel);
        easyPanel.setLayout(easyPanelLayout);
        easyPanelLayout.setHorizontalGroup(
            easyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(easyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(easyPanelLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(title)
                .addContainerGap(185, Short.MAX_VALUE))
        );
        easyPanelLayout.setVerticalGroup(
            easyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(easyPanelLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        rankingPanel.add(easyPanel, "card4");

        hardPanel.setBackground(new java.awt.Color(204, 204, 204));
        hardPanel.setPreferredSize(new java.awt.Dimension(579, 430));

        title1.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        title1.setText("Ranking-Dificil");

        jList3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jScrollPane4.setViewportView(jList3);

        javax.swing.GroupLayout hardPanelLayout = new javax.swing.GroupLayout(hardPanel);
        hardPanel.setLayout(hardPanelLayout);
        hardPanelLayout.setHorizontalGroup(
            hardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4)
                .addContainerGap())
            .addGroup(hardPanelLayout.createSequentialGroup()
                .addGap(162, 162, 162)
                .addComponent(title1)
                .addContainerGap(175, Short.MAX_VALUE))
        );
        hardPanelLayout.setVerticalGroup(
            hardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hardPanelLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(title1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        rankingPanel.add(hardPanel, "card2");

        interPanel.setBackground(new java.awt.Color(204, 204, 204));
        interPanel.setPreferredSize(new java.awt.Dimension(579, 430));

        titleInter.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        titleInter.setText("Ranking-Mig");

        jList2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout interPanelLayout = new javax.swing.GroupLayout(interPanel);
        interPanel.setLayout(interPanelLayout);
        interPanelLayout.setHorizontalGroup(
            interPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(interPanelLayout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(titleInter)
                .addContainerGap(196, Short.MAX_VALUE))
        );
        interPanelLayout.setVerticalGroup(
            interPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interPanelLayout.createSequentialGroup()
                .addContainerGap(50, Short.MAX_VALUE)
                .addComponent(titleInter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        rankingPanel.add(interPanel, "card3");

        getContentPane().add(rankingPanel, java.awt.BorderLayout.PAGE_START);

        setSize(new java.awt.Dimension(595, 747));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void b_backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_backMouseClicked

        cn.openMenuView();
        this.dispose();

    }//GEN-LAST:event_b_backMouseClicked

    private void b_deleteUsrMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_deleteUsrMouseClicked
        String username = user_to_delete.getText();
        if (username.equals("")) {
            JOptionPane.showMessageDialog(null, "Enter the username that you want to delete");
        } else {
            if (!cp.existsUser(username)) {
                JOptionPane.showMessageDialog(null, "The user: " + username + " not exists in any ranking");
            }
            cp.deleteUserRanking(username);
            user_to_delete.setText("");
            showEasyRanking();
            showInterRanking();
            showHardRanking();
            repaint();
        }
    }//GEN-LAST:event_b_deleteUsrMouseClicked

    private void b_filterMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_filterMouseClicked
        String input = t_input.getText();
        if (!filterByDate.isSelected() && !filterByUsername.isSelected()) {
            int message = JOptionPane.showOptionDialog(null, "Choose the variable that you want to filter", "Error message",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        } else if ((filterByDate.isSelected() || filterByUsername.isSelected()) && input.equals("")) {
            int message = JOptionPane.showOptionDialog(null, "Enter a input to filter!", "Error message",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        } else {
            showFilteredRank(input);
        }
    }//GEN-LAST:event_b_filterMouseClicked

    private void b_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_b_backActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_b_backActionPerformed

    private void showEasyRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showEasyRankingActionPerformed
        rankingPanel.removeAll();
        rankingPanel.add(easyPanel);
        rankingPanel.repaint();
        rankingPanel.revalidate();
    }//GEN-LAST:event_showEasyRankingActionPerformed

    private void showInterRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showInterRankingActionPerformed
        rankingPanel.removeAll();
        rankingPanel.add(interPanel);
        rankingPanel.repaint();
        rankingPanel.revalidate();
    }//GEN-LAST:event_showInterRankingActionPerformed

    private void showHardRankingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_showHardRankingActionPerformed
        rankingPanel.removeAll();
        rankingPanel.add(hardPanel);
        rankingPanel.repaint();
        rankingPanel.revalidate();
    }//GEN-LAST:event_showHardRankingActionPerformed

    private void b_filterByUsr1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_b_filterByUsr1MouseClicked
        showEasyRanking();
        showInterRanking();
        showHardRanking();
        t_input.setText("");
    }//GEN-LAST:event_b_filterByUsr1MouseClicked

    private void filterByUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterByUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_filterByUsernameActionPerformed

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
            java.util.logging.Logger.getLogger(VistaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaRanking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaRanking().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton b_back;
    private javax.swing.JButton b_deleteUsr;
    private javax.swing.JButton b_filter;
    private javax.swing.JButton b_filterByUsr1;
    private javax.swing.JPanel easyPanel;
    private javax.swing.JRadioButton filterByDate;
    private javax.swing.JRadioButton filterByUsername;
    private javax.swing.ButtonGroup filterType;
    private javax.swing.JPanel hardPanel;
    private javax.swing.JPanel interPanel;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JPanel rankingPanel;
    private javax.swing.JButton showEasyRanking;
    private javax.swing.JButton showHardRanking;
    private javax.swing.JButton showInterRanking;
    private javax.swing.JTextField t_input;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel titleInter;
    private javax.swing.JTextField user_to_delete;
    // End of variables declaration//GEN-END:variables

    private boolean validDate(String input) {
        try {
            LocalDate localDate = LocalDate.parse(input);
        } catch (DateTimeParseException excepcion) {
            int message = JOptionPane.showOptionDialog(null, "Invalid data form!", "Error message",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            return false;
        }
        return true;
    }
}
