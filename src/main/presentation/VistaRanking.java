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
    

    public VistaRanking() {
        initComponents();
        
        filterType.add(filterByDate);
        filterType.add(filterByUsername);
                
        cp.saveScore(1, "Jia", 10);
        cp.saveScore(2, "Jia2", 1450);
        cp.saveScore(3, "Jia3", 14350);
        cp.saveScore(1, "Jia2", 13242);
        cp.saveScore(2, "Jia3", 11233);
        cp.saveScore(3, "Jia2", 11235);
        cp.saveScore(1, "Jia", 131);
        cp.saveScore(2, "Jia2", 112);
        cp.saveScore(3, "Jia3", 14234);
        cp.saveScore(1, "Jia", 10235);
        cp.saveScore(2, "Jia2", 110);
        cp.saveScore(3, "Jia3", 1120);
        cp.saveScore(1, "Jia2", 16212);
        cp.saveScore(2, "Jia", 14563);
        cp.saveScore(3, "Jia2", 14564356);
        cp.saveScore(1, "Jia3", 161);
        cp.saveScore(2, "Jia", 143562);
        cp.saveScore(3, "Jia3", 13454);
        showRankingList();
    }

    private void showRankingList() {
        DefaultListModel model = new DefaultListModel();
        DefaultListModel model1 = new DefaultListModel();
        DefaultListModel model2 = new DefaultListModel();
        String[] rankEasy = cp.getRankingEasy();
        String[] rankInter = cp.getRankingInter();
        String[] rankHard = cp.getRankingHard();
        for (int i = 0; i < rankEasy.length; ++i) {
            model.addElement(rankEasy[i]);
        }
        for (int i = 0; i < rankInter.length; ++i) {
            model1.addElement(rankInter[i]);
        }
        for (int i = 0; i < rankHard.length; ++i) {
            model2.addElement(rankHard[i]);
        }

        jList1.setModel(model);
        jList2.setModel(model1);
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
        rankingPanel = new javax.swing.JPanel();
        easyPanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        hardPanel = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        title1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        interPanel = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        titleInter = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        optionsPanel.setBackground(new java.awt.Color(0, 153, 153));

        user_to_delete.setBackground(new java.awt.Color(0, 153, 153));
        user_to_delete.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        user_to_delete.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        b_deleteUsr.setBackground(new java.awt.Color(0, 204, 204));
        b_deleteUsr.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        b_deleteUsr.setText("Delete");
        b_deleteUsr.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_deleteUsrMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setText("Filter by:");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel12.setText("Input:");

        t_input.setBackground(new java.awt.Color(0, 153, 153));
        t_input.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        t_input.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        b_filter.setBackground(new java.awt.Color(0, 204, 204));
        b_filter.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        b_filter.setText("Filter");
        b_filter.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_filterMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Delete user score:");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setText("Username:");

        b_back.setBackground(new java.awt.Color(0, 204, 204));
        b_back.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        b_back.setText("Back");
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

        showInterRanking.setBackground(new java.awt.Color(0, 204, 204));
        showInterRanking.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        showInterRanking.setText("Intermediate");
        showInterRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showInterRankingActionPerformed(evt);
            }
        });

        showEasyRanking.setBackground(new java.awt.Color(0, 204, 204));
        showEasyRanking.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        showEasyRanking.setText("Easy");
        showEasyRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showEasyRankingActionPerformed(evt);
            }
        });

        showHardRanking.setBackground(new java.awt.Color(0, 204, 204));
        showHardRanking.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        showHardRanking.setText("Hard");
        showHardRanking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                showHardRankingActionPerformed(evt);
            }
        });

        b_filterByUsr1.setBackground(new java.awt.Color(0, 204, 204));
        b_filterByUsr1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        b_filterByUsr1.setText("Show all");
        b_filterByUsr1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                b_filterByUsr1MouseClicked(evt);
            }
        });

        filterByUsername.setBackground(new java.awt.Color(0, 153, 153));
        filterByUsername.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        filterByUsername.setText("Username");
        filterByUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterByUsernameActionPerformed(evt);
            }
        });

        filterByDate.setBackground(new java.awt.Color(0, 153, 153));
        filterByDate.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        filterByDate.setText("Date (Format: YYYY-MM-DD)");

        javax.swing.GroupLayout optionsPanelLayout = new javax.swing.GroupLayout(optionsPanel);
        optionsPanel.setLayout(optionsPanelLayout);
        optionsPanelLayout.setHorizontalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addGap(224, 224, 224)
                .addComponent(b_back, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, optionsPanelLayout.createSequentialGroup()
                .addContainerGap(108, Short.MAX_VALUE)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addComponent(showEasyRanking)
                        .addGap(61, 61, 61)
                        .addComponent(showInterRanking)
                        .addGap(59, 59, 59)
                        .addComponent(showHardRanking))
                    .addComponent(jLabel9)
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel10)
                        .addGap(18, 18, 18)
                        .addComponent(user_to_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(59, 59, 59)
                        .addComponent(b_deleteUsr))
                    .addComponent(jLabel11)
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addComponent(filterByUsername)
                        .addGap(39, 39, 39)
                        .addComponent(filterByDate))
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addGap(18, 18, 18)
                        .addComponent(t_input, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(62, 62, 62)
                        .addComponent(b_filter, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(b_filterByUsr1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(35, 35, 35))
        );
        optionsPanelLayout.setVerticalGroup(
            optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(showEasyRanking)
                    .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(showHardRanking)
                        .addComponent(showInterRanking)))
                .addGap(18, 18, 18)
                .addComponent(jLabel9)
                .addGap(10, 10, 10)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(b_deleteUsr)
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(user_to_delete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(34, 34, 34)
                .addComponent(jLabel11)
                .addGap(2, 2, 2)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filterByUsername)
                    .addComponent(filterByDate))
                .addGap(15, 15, 15)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(b_filterByUsr1)
                        .addComponent(b_filter))
                    .addGroup(optionsPanelLayout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addComponent(t_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(b_back)
                .addGap(24, 24, 24))
        );

        getContentPane().add(optionsPanel, java.awt.BorderLayout.CENTER);

        rankingPanel.setLayout(new java.awt.CardLayout());

        easyPanel.setBackground(new java.awt.Color(0, 204, 204));
        easyPanel.setPreferredSize(new java.awt.Dimension(600, 470));

        title.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        title.setText("Ranking-Easy");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setText("Pos");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel8.setText("Score");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel6.setText("Username");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel7.setText("Date");

        jScrollPane1.setViewportView(jList1);

        javax.swing.GroupLayout easyPanelLayout = new javax.swing.GroupLayout(easyPanel);
        easyPanel.setLayout(easyPanelLayout);
        easyPanelLayout.setHorizontalGroup(
            easyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(easyPanelLayout.createSequentialGroup()
                .addGroup(easyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(easyPanelLayout.createSequentialGroup()
                        .addGap(161, 161, 161)
                        .addComponent(jLabel5)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel8)
                        .addGap(28, 28, 28)
                        .addComponent(jLabel6))
                    .addGroup(easyPanelLayout.createSequentialGroup()
                        .addGap(176, 176, 176)
                        .addGroup(easyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(title)))
                    .addGroup(easyPanelLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(153, 167, Short.MAX_VALUE))
        );
        easyPanelLayout.setVerticalGroup(
            easyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(easyPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(title)
                .addGap(20, 20, 20)
                .addGroup(easyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        rankingPanel.add(easyPanel, "card4");

        hardPanel.setBackground(new java.awt.Color(0, 204, 204));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel13.setText("Pos");

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel14.setText("Score");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel15.setText("Username");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel16.setText("Date");

        title1.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        title1.setText("Ranking-Hard");

        jScrollPane4.setViewportView(jList3);

        javax.swing.GroupLayout hardPanelLayout = new javax.swing.GroupLayout(hardPanel);
        hardPanel.setLayout(hardPanelLayout);
        hardPanelLayout.setHorizontalGroup(
            hardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hardPanelLayout.createSequentialGroup()
                .addGap(157, 157, 157)
                .addGroup(hardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hardPanelLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addGap(32, 32, 32)
                        .addComponent(jLabel14)
                        .addGap(40, 40, 40)
                        .addComponent(jLabel15)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel16))
                    .addGroup(hardPanelLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(title1))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(163, Short.MAX_VALUE))
        );
        hardPanelLayout.setVerticalGroup(
            hardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hardPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(title1)
                .addGap(18, 18, 18)
                .addGroup(hardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(hardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel13)
                        .addComponent(jLabel14))
                    .addGroup(hardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel16)
                        .addComponent(jLabel15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        rankingPanel.add(hardPanel, "card2");

        interPanel.setBackground(new java.awt.Color(0, 204, 204));
        interPanel.setPreferredSize(new java.awt.Dimension(600, 470));

        jLabel20.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel20.setText("Date");

        jLabel19.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel19.setText("Username");

        jLabel18.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel18.setText("Score");

        jLabel17.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel17.setText("Pos");

        titleInter.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        titleInter.setText("Ranking-Intermediate");

        jScrollPane2.setViewportView(jList2);

        javax.swing.GroupLayout interPanelLayout = new javax.swing.GroupLayout(interPanel);
        interPanel.setLayout(interPanelLayout);
        interPanelLayout.setHorizontalGroup(
            interPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interPanelLayout.createSequentialGroup()
                .addGroup(interPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(interPanelLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(titleInter))
                    .addGroup(interPanelLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addGroup(interPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(interPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel17)
                                .addGap(33, 33, 33)
                                .addComponent(jLabel18)
                                .addGap(42, 42, 42)
                                .addComponent(jLabel19)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel20))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(111, Short.MAX_VALUE))
        );
        interPanelLayout.setVerticalGroup(
            interPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interPanelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(titleInter)
                .addGap(30, 30, 30)
                .addGroup(interPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18)
                    .addComponent(jLabel19)
                    .addComponent(jLabel20))
                .addGap(6, 6, 6)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        rankingPanel.add(interPanel, "card3");

        getContentPane().add(rankingPanel, java.awt.BorderLayout.PAGE_START);

        setSize(new java.awt.Dimension(616, 839));
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
            showRankingList();
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
        showRankingList();

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
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
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
        }
        catch (DateTimeParseException excepcion) {
            int message = JOptionPane.showOptionDialog(null, "Invalid data form!", "Error message",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            return false;
        }
        return true;
    }
}
