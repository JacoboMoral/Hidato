/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.presentation;

import main.domain.com.hidato.Hidato;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

/**
 *
 * @author admin
 */
public class ControladorMenuPrincipal {
    private static ControladorMenuPrincipal instance = null;
    private final ControladorPresentacio controller = ControladorPresentacio.getInstance();
    
    public ControladorMenuPrincipal() {
    }

    public static ControladorMenuPrincipal getInstance() {
        if (instance == null) {
            instance = new ControladorMenuPrincipal();
        }
        return instance;
    }
    
    public int[][] getMatriuHidatoSeleccionat(String nomHidato) throws Exception {
        return controller.getMatriu(nomHidato);
    }

    public TipusAdjacencia getTipusAdjacenciaHidatoSeleccionat(String nomHidato) throws Exception {
        return controller.getTipusAdjacencia(nomHidato);
    }

    public TipusCella getTipusCellaHidatoSeleccionat(String nomHidato) throws Exception {
        return controller.getTipusCella(nomHidato);
    }

    public String[] getAllHidatoNames() {
        return controller.getAllHidatoNames();
    }
    
    
}
