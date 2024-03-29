/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.domain.com.hidato;

import main.persistence.ControladorPersistencia;
import main.presentation.VistaRanking;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;

/**
 *
 * @author admin
 */
public class Ranking {

    private final int levelEasy = 1;
    private final int levelInter = 2;
    private final int levelHard = 3;

    private ArrayList<Posicio> rankingEasy = new ArrayList<Posicio>();
    private ArrayList<Posicio> rankingInter = new ArrayList<Posicio>();
    private ArrayList<Posicio> rankingHard = new ArrayList<Posicio>();

    private static Ranking instance = null;

    public static Ranking getInstance() {
        if (instance == null) {
            instance = new Ranking();

        }
        return instance;
    }

    public int getRankingEasySize() {
        return rankingEasy.size();
    }
    
    public int getRankingInterSize() {
        return rankingInter.size();
    }
    public int getRankingHardSize() {
        return rankingHard.size();
    }
    
    public ArrayList<Posicio> getLlistaPosicio(int dificultat) {
        switch (dificultat) {
            case levelEasy:
                return rankingEasy;
            case levelInter:
                return rankingInter;
            case levelHard:
                return rankingHard;
        }
        return null;
    }

    public void insertPosition(Posicio pos, int dificultat) {
        if (dificultat == levelEasy) {
            rankingEasy.add(pos);
            Collections.sort(rankingEasy, new CustomCompare().reversed());
        }

        if (dificultat == levelInter) {
            rankingInter.add(pos);
            Collections.sort(rankingInter, new CustomCompare().reversed());
        }

        if (dificultat == levelHard) {
            rankingHard.add(pos);
            Collections.sort(rankingHard, new CustomCompare().reversed());
        }
    }

    private static class CustomCompare implements Comparator<Posicio> {

        @Override
        public int compare(Posicio p1, Posicio p2) {
            return Integer.compare(p1.getScore(), p2.getScore());
        }
    }

    public boolean existsUser(String date) {
        ListIterator<Posicio> it_easy = rankingEasy.listIterator();
        ListIterator<Posicio> it_inter = rankingInter.listIterator();
        ListIterator<Posicio> it_hard = rankingHard.listIterator();
        boolean trobat = false;
        while (it_easy.hasNext()) {
            Posicio temp = it_easy.next();
            if (temp.getUsername().equals(date)) {
                trobat = true;
            }
        }
        while (it_inter.hasNext()) {
            Posicio temp = it_inter.next();
            if (temp.getUsername().equals(date)) {
                trobat = true;
            }
        }
        while (it_hard.hasNext()) {
            Posicio temp = it_hard.next();
            if (temp.getUsername().equals(date)) {
                trobat = true;
            }
        }
        return trobat;
    }

    public boolean existsDate(String date) {
        ListIterator<Posicio> it_easy = rankingEasy.listIterator();
        ListIterator<Posicio> it_inter = rankingInter.listIterator();
        ListIterator<Posicio> it_hard = rankingHard.listIterator();
        boolean trobat = false;
        LocalDate localDate = LocalDate.parse(date);
        while (it_easy.hasNext()) {
            Posicio temp = it_easy.next();
            if (temp.getDate().equals(localDate)) {
                trobat = true;
            }
        }
        while (it_inter.hasNext()) {
            Posicio temp = it_inter.next();
            if (temp.getDate().equals(localDate)) {
                trobat = true;
            }
        }
        while (it_hard.hasNext()) {
            Posicio temp = it_hard.next();
            if (temp.getDate().equals(localDate)) {
                trobat = true;
            }
        }
        return trobat;
    }

    public ArrayList<Posicio> filterByUsername(String date, int dificultat) {
        int i = 0;
        ArrayList<Posicio> aux = new ArrayList<Posicio>();
        switch (dificultat) {
            case levelEasy:
                while (i < rankingEasy.size()) {
                    if (rankingEasy.get(i).getUsername().equals(date)) {
                        aux.add(rankingEasy.get(i));
                    }
                    i++;
                }
                return aux;
            case levelInter:
                while (i < rankingInter.size()) {
                    if (rankingInter.get(i).getUsername().equals(date)) {
                        aux.add(rankingInter.get(i));
                    }
                    i++;
                }
                return aux;
            case levelHard:
                while (i < rankingHard.size()) {
                    if (rankingHard.get(i).getUsername().equals(date)) {
                        aux.add(rankingHard.get(i));
                    }
                    i++;
                }
                return aux;
        }
        return null;
    }

    public void deleteUserRanking(String user) {
        ListIterator<Posicio> it;
        ListIterator<Posicio> it2;
        ListIterator<Posicio> it3;
        it = rankingEasy.listIterator();
        while (it.hasNext()) {
            if (it.next().getUsername().equals(user)) {
                it.remove();
            }
        }

        it2 = rankingInter.listIterator();
        while (it2.hasNext()) {
            if (it2.next().getUsername().equals(user)) {
                it2.remove();
            }
        }

        it3 = rankingHard.listIterator();
        while (it3.hasNext()) {
            if (it3.next().getUsername().equals(user)) {
                it3.remove();
            }
        }
    }

}
