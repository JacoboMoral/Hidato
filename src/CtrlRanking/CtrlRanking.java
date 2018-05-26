package CtrlRanking;

import main.domain.com.hidato.Posicio;
import main.domain.com.hidato.Ranking;
import main.persistence.CtrlPersistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ListIterator;

public class CtrlRanking {

    Ranking r;
    CtrlPersistence cp = new CtrlPersistence();
    private static final int levelEasy = 1;
    private static final int levelInter = 2;
    private static final int levelHard = 3;
    
    public CtrlRanking() {
        CtrlPersistence gr = new CtrlPersistence();
        r = gr.readRanking();
    }

    public void saveScore(int dif, int score, String usr) {
        LocalDate date = LocalDate.now();
        Posicio p = new Posicio(usr, score, date);
        r.insertPosition(p, dif);
        
        cp.saveRanking(r);
    }

    public String[] getRankingEasy() {
        ArrayList<Posicio> llista = r.getLlistaPosicio(levelEasy);
        String rankingList[] = new String[llista.size()];
        int i = 0;
        Posicio temp = null;
        ListIterator<Posicio> it = llista.listIterator();
        while (i < llista.size()) {
            temp = it.next();
            rankingList[i] = (i + 1) + "     " + Integer.toString(temp.getScore()) + "     " + temp.getUsername() + "    " + temp.getDate();
            ++i;
        }
        return rankingList;
    }

    public String[] getRankingInter() {
        ArrayList<Posicio> llista = r.getLlistaPosicio(levelInter);
        String rankingList[] = new String[llista.size()];
        int i = 0;
        Posicio temp = null;
        ListIterator<Posicio> it = llista.listIterator();
        while (i < llista.size()) {
            temp = it.next();
            rankingList[i] = (i + 1) + "     " + Integer.toString(temp.getScore()) + "     " + temp.getUsername() + "    " + temp.getDate();
            ++i;
        }
        return rankingList;
    }

    public String[] getRankingHard() {
        ArrayList<Posicio> llista = r.getLlistaPosicio(levelHard);
        String rankingList[] = new String[llista.size()];
        int i = 0;
        Posicio temp = null;
        ListIterator<Posicio> it = llista.listIterator();
        while (i < llista.size()) {
            temp = it.next();
            rankingList[i] = (i + 1) + "     " + Integer.toString(temp.getScore()) + "     " + temp.getUsername() + "    " + temp.getDate();
            ++i;
        }
        return rankingList;
    }
    
    /*
    public String[] getFacilUsr(String usr) {
        ArrayList<Posicio> facaux = r.getLlistaPosicio(1);
        String rankingList[] = new String[facaux.size()];
        int i = 0;
        Posicio aux = null;
        ListIterator<Posicio> it = facaux.listIterator();
        while (i < facaux.size()) {
            aux = it.next();
            if ((aux.getUsername().equals(usr))) {
                rankingList[i] = (i + 1) + " " + Integer.toString(aux.getScore()) + " " + aux.getUsername();
            }
            ++i;
        }
        return rankingList;
    }

    public String[] getNormalUsr(String usr) {
        ArrayList<Posicio> noraux = r.getLlistaPosicio(2);
        String nor[] = new String[noraux.size()];
        int i = 0;
        Posicio aux = null;
        ListIterator<Posicio> it = noraux.listIterator();
        while (i < noraux.size()) {
            aux = it.next();
            if ((aux.getUsername().equals(usr))) {
                nor[i] = (i + 1) + " " + Integer.toString(aux.getScore()) + " " + aux.getUsername();
            }
            ++i;
        }
        return nor;
    }

    public String[] getDificilUsr(String usr) {
        ArrayList<Posicio> difaux = r.getLlistaPosicio(3);
        String dif[] = new String[difaux.size()];
        int i = 0;
        Posicio aux = null;
        ListIterator<Posicio> it = difaux.listIterator();
        while (i < difaux.size()) {
            aux = it.next();
            if ((aux.getUsername().equals(usr))) {
                dif[i] = (i + 1) + " " + Integer.toString(aux.getScore()) + " " + aux.getUsername();
            }
            ++i;
        }
        return dif;
    }*/

    public void deleteUsr(String nom) {
        r.deleteUsrRanking(nom);
        cp.saveRanking(r);
    }

    public boolean existsUsuari(String nom) {
        return r.exists(nom);
    }
}
