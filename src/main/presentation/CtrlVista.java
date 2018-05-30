package main.presentation;

import main.domain.com.hidato.Ranking;
import main.domain.com.hidato.Usuari;
import java.io.IOException;
import java.time.LocalDate;
import main.persistence.ControladorPersistencia;

public class CtrlVista {

    private CtrlUser cu;
    private CtrlRanking cr;
    private ControladorPersistencia cp;
    
    public CtrlVista() {
        cu = new CtrlUser();
        cr = new CtrlRanking();
        cp = new ControladorPersistencia();
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
    
    public String[] getRankEasy() {
        return cr.getRankingEasy();
    }

    public String[] getRankInter() {
        return cr.getRankingInter();
    }

    public String[] getRankHard() {
        return cr.getRankingHard();
    }

    public String[] getFilterByUsername(String username, int level) {
        return cr.getFilterByUsername(username, level);
    }
    
    public String[] getFilterByDate(String date, int level) {
        return cr.getFilterByDate(date, level);
    }

    public void deleteUsr(String nom) {
        cr.deleteUsr(nom);
    }
    
    public void saveResultat(int dificultat, String usr, int puntuacio) {
        cr.saveScore(dificultat, puntuacio, usr);
    }

    boolean existsUser(String username) {
        return cr.existsUser(username);
    }
    
    boolean existsDate(String date) {
        return cr.existsDate(date);
    }

    public String[] getHidatoList() {
        return null;
    }
}
