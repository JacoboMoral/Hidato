/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.presentation;

import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

/**
 *
 * @author admin
 */
public class ControladorNavegacio {
    
    private static ControladorNavegacio instance = null;
    private final int levelEasy = 1;
    private final int levelInter = 2;
    private final int levelHard = 3;
    
    
    public static ControladorNavegacio getInstance() {
        if (instance == null) {
            instance = new ControladorNavegacio();
        }
        return instance;
    }

    public void openRegisterView() {
        VistaRegistrar v = new VistaRegistrar();
        v.setVisible(true);
    }

    public void openMenuView() {
        VistaMenuPrincipal v = new VistaMenuPrincipal();
        v.setVisible(true);
       
    }

    public void openRankingView() {
        VistaRanking v = new VistaRanking();
        v.setVisible(true);
    }
    
    public void openInicialView() {
        Inici v = new Inici();
        v.setVisible(true);
    }

    void openLoadingView(int level, VistaMenuPrincipal aThis) {
        if (level == levelEasy) {
             VistaLoading v = new VistaLoading(levelEasy, aThis);
             v.setVisible(true);
        }
        else if (level == levelInter) {
            VistaLoading v = new VistaLoading(levelInter, aThis);
            v.setVisible(true);
        }
        else {
            VistaLoading v = new VistaLoading(levelHard, aThis);
            v.setVisible(true);
        }
    }

    void openCreateHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int alturaHidato, int ampladaHidato) {
        VistaCreateHidato v = new VistaCreateHidato(tipusCella, tipusAdjacencia, alturaHidato, ampladaHidato);
        v.setVisible(true);
    }
    
    void openInstruccions() {
        VistaInstruccions v = new VistaInstruccions();
        v.setVisible(true);
    }
    
    
}
