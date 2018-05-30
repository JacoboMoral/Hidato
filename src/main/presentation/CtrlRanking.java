package main.presentation;

import main.domain.com.hidato.Posicio;
import main.domain.com.hidato.Ranking;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import main.domain.com.hidato.Posicio;
import main.domain.com.hidato.Ranking;
import main.persistence.ControladorPersistencia;

public class CtrlRanking {

    Ranking r;
    ControladorPersistencia cp;
    private static final int levelEasy = 1;
    private static final int levelInter = 2;
    private static final int levelHard = 3;

    public CtrlRanking() {
        cp = new ControladorPersistencia();
        r = cp.readRanking();
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
        Posicio currentPosition = null;
        ListIterator<Posicio> it = llista.listIterator();
        while (i < llista.size()) {
            currentPosition = it.next();
            rankingList[i] = (i + 1) + "          " + Integer.toString(currentPosition.getScore()) + "          " + currentPosition.getUsername() + "         " + currentPosition.getDate();
            ++i;
        }
        return rankingList;
    }

    public String[] getRankingInter() {
        ArrayList<Posicio> llista = r.getLlistaPosicio(levelInter);
        String rankingList[] = new String[llista.size()];
        int i = 0;
        Posicio currentPosition = null;
        ListIterator<Posicio> it = llista.listIterator();
        while (i < llista.size()) {
            currentPosition = it.next();
            rankingList[i] = (i + 1) + "          " + Integer.toString(currentPosition.getScore()) + "          " + currentPosition.getUsername() + "         " + currentPosition.getDate();
            ++i;
        }
        return rankingList;
    }

    public String[] getRankingHard() {
        ArrayList<Posicio> llista = r.getLlistaPosicio(levelHard);
        String rankingList[] = new String[llista.size()];
        int i = 0;
        Posicio currentPosition = null;
        ListIterator<Posicio> it = llista.listIterator();
        while (i < llista.size()) {
            currentPosition = it.next();
            rankingList[i] = (i + 1) + "          " + Integer.toString(currentPosition.getScore()) + "          " + currentPosition.getUsername() + "         " + currentPosition.getDate();
            ++i;
        }
        return rankingList;
    }

    public String[] getFilterByUsername(String username, int level) {
        List<String> rankingList = new ArrayList<String>();
        Posicio currentPosition = null;
        int i, j;
        i = j = 0;
        if (level == levelEasy) {
            ArrayList<Posicio> llista = r.getLlistaPosicio(levelEasy);
            ListIterator<Posicio> it = llista.listIterator();
            while (i < llista.size()) {
                currentPosition = it.next();
                if ((currentPosition.getUsername().equals(username))) {
                    rankingList.add((j + 1) + "          " + Integer.toString(currentPosition.getScore()) + "          " + currentPosition.getUsername() + "          " + currentPosition.getDate());
                    ++j;
                }
                ++i;
            }
        }
        if (level == levelInter) {
            ArrayList<Posicio> llista = r.getLlistaPosicio(levelInter);
            ListIterator<Posicio> it = llista.listIterator();
            while (i < llista.size()) {
                currentPosition = it.next();
                if ((currentPosition.getUsername().equals(username))) {
                    rankingList.add((j + 1) + "          " + Integer.toString(currentPosition.getScore()) + "          " + currentPosition.getUsername() + "          " + currentPosition.getDate());
                    ++j;
                }
                ++i;
            }
        }
        if (level == levelHard) {
            ArrayList<Posicio> llista = r.getLlistaPosicio(levelHard);
            ListIterator<Posicio> it = llista.listIterator();
            while (i < llista.size()) {
                currentPosition = it.next();
                if ((currentPosition.getUsername().equals(username))) {
                    rankingList.add((j + 1) + "          " + Integer.toString(currentPosition.getScore()) + "          " + currentPosition.getUsername() + "          " + currentPosition.getDate());
                    ++j;
                }
                ++i;
            }
        }
        String[] result = rankingList.toArray(new String[0]);
        return result;
    }

    public void deleteUsr(String nom) {
        r.deleteUsrRanking(nom);
        cp.saveRanking(r);
    }

    public boolean existsUser(String nom) {
        return r.existsUser(nom);
    }


    public String[] getFilterByDate(String date, int level) {
        LocalDate localDate = LocalDate.parse(date);
        List<String> rankingList = new ArrayList<String>();
        Posicio currentPosition = null;
        int i, j;
        i = j = 0;
        if (level == levelEasy) {
            ArrayList<Posicio> llista = r.getLlistaPosicio(levelEasy);
            ListIterator<Posicio> it = llista.listIterator();
            while (i < llista.size()) {
                currentPosition = it.next();
                if ((currentPosition.getDate().equals(localDate))) {
                    rankingList.add((j + 1) + "          " + Integer.toString(currentPosition.getScore()) + "          " + currentPosition.getUsername() + "          " + currentPosition.getDate());
                    ++j;
                }
                ++i;
            }
        }
        if (level == levelInter) {
            ArrayList<Posicio> llista = r.getLlistaPosicio(levelInter);
            ListIterator<Posicio> it = llista.listIterator();
            while (i < llista.size()) {
                currentPosition = it.next();
                if ((currentPosition.getDate().equals(localDate))) {
                    rankingList.add((j + 1) + "          " + Integer.toString(currentPosition.getScore()) + "          " + currentPosition.getUsername() + "          " + currentPosition.getDate());
                    ++j;
                }
                ++i;
            }
        }
        if (level == levelHard) {
            ArrayList<Posicio> llista = r.getLlistaPosicio(levelHard);
            ListIterator<Posicio> it = llista.listIterator();
            while (i < llista.size()) {
                currentPosition = it.next();
                if ((currentPosition.getDate().equals(localDate))) {
                    rankingList.add((j + 1) + "          " + Integer.toString(currentPosition.getScore()) + "          " + currentPosition.getUsername() + "          " + currentPosition.getDate());
                    ++j;
                }
                ++i;
            }
        }
        String[] result = rankingList.toArray(new String[0]);
        return result;
    }

    public boolean existsDate(String date) {
        return r.existsDate(date);
    }
}
