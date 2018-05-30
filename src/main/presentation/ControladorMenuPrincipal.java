/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.presentation;

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
    
    public String[] getHidatosGuardats() {
        return controller.getHidatos();
    }
    
}
