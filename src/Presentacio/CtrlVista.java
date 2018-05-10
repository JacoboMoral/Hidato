/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import Usuari.CtrlUsr;
/**
 *
 * @author admin
 */
public class CtrlVista {
    private CtrlUsr cu;

    public CtrlVista(){
        cu = new CtrlUsr();
    }

    //Funcions Usuari
    public boolean afegirUsr(String usr, String pass) {
        return cu.afegirUsuari(usr, pass);
    }
    
    public boolean compUsr(String u, String p) {
        return cu.logUsuari(u, p);
    }
    
    public boolean modUsr(String usr1, String usr2) {
        return cu.modUsr(usr1, usr2);
    }
    
    public boolean modPass(String pass1, String pass2) {
        return cu.modPass(pass1, pass2);
    }
    
    public boolean esbUsr(String pass) {
        return cu.esbUsr(pass);
    }
}
