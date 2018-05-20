package main.presentation;

import Usuari.CtrlUsr;
import Ranking.CtrlRanking;
import Ranking.Ranking;
import Usuari.Usuari;

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
    
    public boolean altaUsuari(String usr, String pass) {
        return cu.afegirUsuari(usr, pass);
    }

    public boolean logUsr(String u, String p) {
        return cu.logUsr(u, p);
    }

    public boolean editUsr(String usr1, String usr2) {
        return cu.editUsr(usr1, usr2);
    }

    public boolean changePass(String pass1, String pass2) {
        return cu.changePass(pass1, pass2);
    }

    public boolean esbUsr(String pass) {
        return cu.deleteUsr(pass);
    }
    
    public String getCurrentUsername() {
        return cu.getUsername();
    }
    
    public String getCurrentPassword() {
        return cu.getPassword();
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
