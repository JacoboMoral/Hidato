/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacio;

import Usuari.CtrlUsr;
import Ranking.CtrlRanking;
import Ranking.Ranking;
import Usuari.Usuari;

/**
 *
 * @author admin
 */
public class CtrlVista {

    private CtrlUsr cu;
    private CtrlRanking cr;

    public CtrlVista() {
        cu = new CtrlUsr();
        cr = new CtrlRanking();
    }

    public Usuari getUsuari() {
        return cu.getUser();
    }
    
    public boolean registrarUsuari(String usr, String pass) {
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
    
    public String getCurrentUsername() {
        return cu.getUsername();
    }
    
    public String[] getRank_easy() {
        return cr.getRanking_easy();
    }

    public String[] getRank_inter() {
        return cr.getRanking_inter();
    }

    public String[] getRank_hard() {
        return cr.getRanking_hard();
    }

    public String[] getRankFacilUsr(String usr) {
        return cr.getFacilUsr(usr);
    }

    public String[] getRankNormalUsr(String usr) {
        return cr.getNormalUsr(usr);
    }

    public String[] getRankDificilUsr(String usr) {
        return cr.getDificilUsr(usr);
    }

    public void deleteUsr(String nom) {
        cr.deleteUsr(nom);
    }
    
    public void saveResultat(int dificultat, String usr, int puntuacio) {
        cr.saveScore(dificultat, puntuacio, usr);
    }

    boolean existsUsr(String usr) {
        return cr.existsUsuari(usr);
    }
}
