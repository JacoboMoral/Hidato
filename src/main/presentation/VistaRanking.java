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
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import java.util.Collections;
import java.util.Comparator;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author admin
 */
public class VistaRanking extends javax.swing.JFrame {

    private ControladorPresentacio controladorPresentacio = ControladorPresentacio.getInstance();
    private ControladorNavegacio controladorNavegacio = ControladorNavegacio.getInstance();
    private static final int levelEasy = 1;
    private static final int levelInter = 2;
    private static final int levelHard = 3;

    public VistaRanking() {
        initComponents();
        this.setTitle("Ranking");
        filterType.add(filterByDate);
        filterType.add(filterByUsername);
        
        
        controladorPresentacio.getUpdate();

        if (controladorPresentacio.getRankingEasySize() > 0) {
            showEasyRanking();
        }
        if (controladorPresentacio.getRankingInterSize() > 0) {
            showInterRanking();
        }
        if (controladorPresentacio.getRankingHardSize() > 0) {
            showHardRanking();
        }

    }

    private void showEasyRanking() {
        DefaultTableModel model = (DefaultTableModel) easyRanking.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[4];
        ArrayList<Posicio> rankEasy = controladorPresentacio.getRankingEasy();
        for (int i = 0; i < rankEasy.size(); ++i) {
            rowData[0] = i + 1;
            rowData[1] = rankEasy.get(i).getScore();
            rowData[2] = rankEasy.get(i).getUsername();
            rowData[3] = rankEasy.get(i).getDate();
            model.addRow(rowData);
        }
        easyRanking.setModel(model);
    }

    private void showInterRanking() {
        DefaultTableModel model = (DefaultTableModel) interRanking.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[4];
        ArrayList<Posicio> rankInter = controladorPresentacio.getRankingInter();
        for (int i = 0; i < rankInter.size(); ++i) {
            rowData[0] = i + 1;
            rowData[1] = rankInter.get(i).getScore();
            rowData[2] = rankInter.get(i).getUsername();
            rowData[3] = rankInter.get(i).getDate();
            model.addRow(rowData);
        }
        interRanking.setModel(model);
    }

    private void showHardRanking() {
        DefaultTableModel model = (DefaultTableModel) hardRanking.getModel();
        model.setRowCount(0);
        Object rowData[] = new Object[4];
        ArrayList<Posicio> rankHard = controladorPresentacio.getRankingHard();
        for (int i = 0; i < rankHard.size(); ++i) {
            rowData[0] = i + 1;
            rowData[1] = rankHard.get(i).getScore();
            rowData[2] = rankHard.get(i).getUsername();
            rowData[3] = rankHard.get(i).getDate();
            model.addRow(rowData);
        }
        hardRanking.setModel(model);
    }

    private void showFilteredRank(String input) {
        DefaultTableModel model = (DefaultTableModel) easyRanking.getModel();
        DefaultTableModel model2 = (DefaultTableModel) interRanking.getModel();
        DefaultTableModel model3 = (DefaultTableModel) hardRanking.getModel();
        model.setRowCount(0);
        model2.setRowCount(0);
        model3.setRowCount(0);
        Object rowData[] = new Object[4];
        if (filterByUsername.isSelected()) {
            if (!controladorPresentacio.existsUser(input)) {
                int message = JOptionPane.showOptionDialog(null, "L'usuari no te cap puntuacio en el Ranking!", "Error message",
                        JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
            } else {
                ArrayList<Posicio> rankEasy = controladorPresentacio.getFilterByUsername(input, levelEasy);
                ArrayList<Posicio> rankInter = controladorPresentacio.getFilterByUsername(input, levelInter);
                ArrayList<Posicio> rankHard = controladorPresentacio.getFilterByUsername(input, levelHard);
                for (int i = 0; i < rankEasy.size(); ++i) {
                    rowData[0] = i + 1;
                    rowData[1] = rankEasy.get(i).getScore();
                    rowData[2] = rankEasy.get(i).getUsername();
                    rowData[3] = rankEasy.get(i).getDate();
                    model.addRow(rowData);
                }
                for (int i = 0; i < rankInter.size(); ++i) {
                    rowData[0] = i + 1;
                    rowData[1] = rankInter.get(i).getScore();
                    rowData[2] = rankInter.get(i).getUsername();
                    rowData[3] = rankInter.get(i).getDate();
                    model.addRow(rowData);
                }
                for (int i = 0; i < rankHard.size(); ++i) {
                    rowData[0] = i + 1;
                    rowData[1] = rankHard.get(i).getScore();
                    rowData[2] = rankHard.get(i).getUsername();
                    rowData[3] = rankHard.get(i).getDate();
                    model.addRow(rowData);
                }
            }
        }
        if (filterByDate.isSelected()) {
            if (validDate(input)) {
                if (!controladorPresentacio.existsDate(input)) {
                    int message = JOptionPane.showOptionDialog(null, "No hi ha cap puntuacio feta en aquesta data!", "Error message",
                            JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
                } else {
                    ArrayList<Posicio> rankEasy = controladorPresentacio.getFilterByDate(input, levelEasy);
                    ArrayList<Posicio> rankInter = controladorPresentacio.getFilterByDate(input, levelInter);
                    ArrayList<Posicio> rankHard = controladorPresentacio.getFilterByDate(input, levelHard);
                    for (int i = 0; i < rankEasy.size(); ++i) {
                        rowData[0] = i + 1;
                        rowData[1] = rankEasy.get(i).getScore();
                        rowData[2] = rankEasy.get(i).getUsername();
                        rowData[3] = rankEasy.get(i).getDate();
                        model.addRow(rowData);
                    }
                    for (int i = 0; i < rankInter.size(); ++i) {
                        rowData[0] = i + 1;
                        rowData[1] = rankInter.get(i).getScore();
                        rowData[2] = rankInter.get(i).getUsername();
                        rowData[3] = rankInter.get(i).getDate();
                        model.addRow(rowData);
                    }
                    for (int i = 0; i < rankHard.size(); ++i) {
                        rowData[0] = i + 1;
                        rowData[1] = rankHard.get(i).getScore();
                        rowData[2] = rankHard.get(i).getUsername();
                        rowData[3] = rankHard.get(i).getDate();
                        model.addRow(rowData);
                    }
                }
            }
        }
        easyRanking.setModel(model);
        interRanking.setModel(model2);
        hardRanking.setModel(model3);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filterType = new javax.swing.ButtonGroup();
        optionsPanel = new javax.swing.JPanel();
        usernameToDelete = new javax.swing.JTextField();
        eliminarUsuari = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        t_input = new javax.swing.JTextField();
        filtrar = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        showInterRanking = new javax.swing.JButton();
        showEasyRanking = new javax.swing.JButton();
        showHardRanking = new javax.swing.JButton();
        showAllRanking = new javax.swing.JButton();
        filterByUsername = new javax.swing.JRadioButton();
        filterByDate = new javax.swing.JRadioButton();
        jSeparator1 = new javax.swing.JSeparator();
        rankingPanel = new javax.swing.JPanel();
        easyPanel = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        easyRanking = new javax.swing.JTable();
        hardPanel = new javax.swing.JPanel();
        title1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        hardRanking = new javax.swing.JTable();
        interPanel = new javax.swing.JPanel();
        titleInter = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        interRanking = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(600, 650));
        setResizable(false);

        optionsPanel.setBackground(new java.awt.Color(204, 204, 204));

        usernameToDelete.setBackground(new java.awt.Color(204, 204, 204));
        usernameToDelete.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        usernameToDelete.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        eliminarUsuari.setBackground(new java.awt.Color(255, 255, 255));
        eliminarUsuari.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        eliminarUsuari.setText("Eliminar");
        eliminarUsuari.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                eliminarUsuariMouseClicked(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setText("Filtrar segons:");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel12.setText("Entrada:");

        t_input.setBackground(new java.awt.Color(204, 204, 204));
        t_input.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        t_input.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        filtrar.setBackground(new java.awt.Color(255, 255, 255));
        filtrar.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        filtrar.setText("Filtrar");
        filtrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                filtrarMouseClicked(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Eliminar puntacio del usuari:");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setText("Nom:");

        back.setBackground(new java.awt.Color(255, 255, 255));
        back.setFont(new java.awt.Font("Century Gothic", 0, 18)); // NOI18N
        back.setText("Enrere");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
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

        showAllRanking.setBackground(new java.awt.Color(255, 255, 255));
        showAllRanking.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        showAllRanking.setText("Mostrar tot");
        showAllRanking.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showAllRankingMouseClicked(evt);
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
                        .addComponent(usernameToDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(eliminarUsuari))
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
                            .addComponent(filtrar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(showAllRanking, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(68, 68, 68))
            .addGroup(optionsPanelLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                    .addComponent(usernameToDelete, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(eliminarUsuari))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterByUsername)
                    .addComponent(filterByDate))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(optionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t_input, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(filtrar)
                    .addComponent(showAllRanking)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(back)
                .addGap(20, 20, 20))
        );

        getContentPane().add(optionsPanel, java.awt.BorderLayout.CENTER);

        rankingPanel.setLayout(new java.awt.CardLayout());

        easyPanel.setBackground(new java.awt.Color(204, 204, 204));
        easyPanel.setPreferredSize(new java.awt.Dimension(579, 430));

        title.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        title.setText("Ranking-Facil");

        easyRanking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Posicio", "Puntuacio", "Nom", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(easyRanking);
        if (easyRanking.getColumnModel().getColumnCount() > 0) {
            easyRanking.getColumnModel().getColumn(0).setResizable(false);
            easyRanking.getColumnModel().getColumn(1).setResizable(false);
            easyRanking.getColumnModel().getColumn(2).setResizable(false);
            easyRanking.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout easyPanelLayout = new javax.swing.GroupLayout(easyPanel);
        easyPanel.setLayout(easyPanelLayout);
        easyPanelLayout.setHorizontalGroup(
            easyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(easyPanelLayout.createSequentialGroup()
                .addGap(172, 172, 172)
                .addComponent(title)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(easyPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                .addContainerGap())
        );
        easyPanelLayout.setVerticalGroup(
            easyPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(easyPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(272, 272, 272))
        );

        rankingPanel.add(easyPanel, "card4");

        hardPanel.setBackground(new java.awt.Color(204, 204, 204));
        hardPanel.setPreferredSize(new java.awt.Dimension(579, 430));

        title1.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        title1.setText("Ranking-Dificil");

        hardRanking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Posicio", "Puntuacio", "Nom", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(hardRanking);
        if (hardRanking.getColumnModel().getColumnCount() > 0) {
            hardRanking.getColumnModel().getColumn(0).setResizable(false);
            hardRanking.getColumnModel().getColumn(1).setResizable(false);
            hardRanking.getColumnModel().getColumn(2).setResizable(false);
            hardRanking.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout hardPanelLayout = new javax.swing.GroupLayout(hardPanel);
        hardPanel.setLayout(hardPanelLayout);
        hardPanelLayout.setHorizontalGroup(
            hardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hardPanelLayout.createSequentialGroup()
                .addGap(164, 164, 164)
                .addComponent(title1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(hardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                .addContainerGap())
        );
        hardPanelLayout.setVerticalGroup(
            hardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(hardPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        rankingPanel.add(hardPanel, "card2");

        interPanel.setBackground(new java.awt.Color(204, 204, 204));
        interPanel.setPreferredSize(new java.awt.Dimension(579, 430));

        titleInter.setFont(new java.awt.Font("Century Gothic", 0, 36)); // NOI18N
        titleInter.setText("Ranking-Mig");

        interRanking.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Posicio", "Puntuacio", "Nom", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane4.setViewportView(interRanking);
        if (interRanking.getColumnModel().getColumnCount() > 0) {
            interRanking.getColumnModel().getColumn(0).setResizable(false);
            interRanking.getColumnModel().getColumn(1).setResizable(false);
            interRanking.getColumnModel().getColumn(2).setResizable(false);
            interRanking.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout interPanelLayout = new javax.swing.GroupLayout(interPanel);
        interPanel.setLayout(interPanelLayout);
        interPanelLayout.setHorizontalGroup(
            interPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interPanelLayout.createSequentialGroup()
                .addGap(167, 167, 167)
                .addComponent(titleInter)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(interPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 559, Short.MAX_VALUE)
                .addContainerGap())
        );
        interPanelLayout.setVerticalGroup(
            interPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(interPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(titleInter)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 356, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68))
        );

        rankingPanel.add(interPanel, "card3");

        getContentPane().add(rankingPanel, java.awt.BorderLayout.PAGE_START);

        setSize(new java.awt.Dimension(595, 747));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked

        controladorNavegacio.openMenuView();
        this.dispose();

    }//GEN-LAST:event_backMouseClicked

    private void eliminarUsuariMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_eliminarUsuariMouseClicked
        String username = usernameToDelete.getText();
        if (username.equals("")) {
            JOptionPane.showMessageDialog(null, "Introdueix el nom que desitjes eliminar!");
        } else {
            if (!controladorPresentacio.existsUser(username)) {
                JOptionPane.showMessageDialog(null, "L'usuari: " + username + " no te cap puntuacio!");
            }
            controladorPresentacio.deleteUserRanking(username);
            usernameToDelete.setText("");
            showEasyRanking();
            showInterRanking();
            showHardRanking();
            repaint();
        }
    }//GEN-LAST:event_eliminarUsuariMouseClicked

    private void filtrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_filtrarMouseClicked
        String input = t_input.getText();
        if (!filterByDate.isSelected() && !filterByUsername.isSelected()) {
            int message = JOptionPane.showOptionDialog(null, "Escull quin criteri vols faci el filtratge!", "Error message",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        } else if ((filterByDate.isSelected() || filterByUsername.isSelected()) && input.equals("")) {
            int message = JOptionPane.showOptionDialog(null, "Introduix quelcom per ser el variable del filtratge!", "Error message",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
        } else {
            showFilteredRank(input);
        }
    }//GEN-LAST:event_filtrarMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_backActionPerformed

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

    private void showAllRankingMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showAllRankingMouseClicked
        showEasyRanking();
        showInterRanking();
        showHardRanking();
        t_input.setText("");
    }//GEN-LAST:event_showAllRankingMouseClicked

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
    private javax.swing.JButton back;
    private javax.swing.JPanel easyPanel;
    private javax.swing.JTable easyRanking;
    private javax.swing.JButton eliminarUsuari;
    private javax.swing.JRadioButton filterByDate;
    private javax.swing.JRadioButton filterByUsername;
    private javax.swing.ButtonGroup filterType;
    private javax.swing.JButton filtrar;
    private javax.swing.JPanel hardPanel;
    private javax.swing.JTable hardRanking;
    private javax.swing.JPanel interPanel;
    private javax.swing.JTable interRanking;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel optionsPanel;
    private javax.swing.JPanel rankingPanel;
    private javax.swing.JButton showAllRanking;
    private javax.swing.JButton showEasyRanking;
    private javax.swing.JButton showHardRanking;
    private javax.swing.JButton showInterRanking;
    private javax.swing.JTextField t_input;
    private javax.swing.JLabel title;
    private javax.swing.JLabel title1;
    private javax.swing.JLabel titleInter;
    private javax.swing.JTextField usernameToDelete;
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
