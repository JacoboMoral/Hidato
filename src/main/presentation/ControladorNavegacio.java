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
    private VistaRegistrar registre;
    private VistaMenuPrincipal menuPrincipal;
    private Inici inici;
    private VistaRanking ranking;
    private VistaCreateHidato createHidato;
    
    
    public static ControladorNavegacio getInstance() {
        if (instance == null) {
            instance = new ControladorNavegacio();
        }
        return instance;
    }

    public void openRegisterView() {
    	registre = new VistaRegistrar();
    	registre.setVisible(true);
    }

    public void openMenuView() {
    	menuPrincipal = new VistaMenuPrincipal();
    	menuPrincipal.setVisible(true);
    }

    public void openRankingView() {
    	ranking = new VistaRanking();
        ranking.setVisible(true);
    }
    
    public void openInicialView() {
    	inici = new Inici();
    	inici.setVisible(true);
    }

    public void openCreateHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int alturaHidato, int ampladaHidato) {
    	createHidato = new VistaCreateHidato(tipusCella, tipusAdjacencia, alturaHidato, ampladaHidato);
    	createHidato.setVisible(true);
    }

    public void closeMenuPrincipal() {
    	menuPrincipal.dispose();
    }

	public void enableMenuPrincipal() {
		menuPrincipal.setEnabled(true);
	}
	
	public void disableMenuPrincipal() {
		menuPrincipal.setEnabled(false);
	}
    
}
