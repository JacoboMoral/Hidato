package main.presentation;

import CtrlUser.CtrlUser;
import CtrlRanking.CtrlRanking;
import main.domain.com.hidato.Ranking;
import main.domain.com.hidato.Usuari;
import java.io.IOException;

public class CtrlVista {

    private CtrlUser cu;
    private CtrlRanking cr;

    public CtrlVista() {
        cu = new CtrlUser();
        cr = new CtrlRanking();
    }

    public Usuari getUsuari() {
        return cu.getUser();
    }
    
    public boolean altaUsuari(String usr, String pass) throws IOException {
        return cu.afegirUsuari(usr, pass);
    }

    public boolean loginUsuari(String usr, String pass) throws IOException {
        return cu.loginUsuari(usr, pass);
    }

    public boolean editUsr(String usr1, String usr2) {
        return cu.editUsername(usr1, usr2);
    }

    public boolean changePass(String oldPass, String newPass) throws IOException {
        return cu.changePass(oldPass, newPass);
    }

    public boolean deleteUser(String pass) {
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
