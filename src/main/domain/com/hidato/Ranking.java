/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.domain.com.hidato;

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

    private static final int levelEasy = 1;
    private static final int levelInter = 2;
    private static final int levelHard = 3;

    private ArrayList<Posicio> rankingEasy = new ArrayList<Posicio>();
    private ArrayList<Posicio> rankingInter = new ArrayList<Posicio>();
    private ArrayList<Posicio> rankingHard = new ArrayList<Posicio>();

        
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
    
    public static class CustomCompare implements Comparator<Posicio> {

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
    

    public void deleteByUsername(int dificultat, String date) {
        boolean trobat = false;
        int i = 0;
        switch (dificultat) {
            case levelEasy:
                while (i < rankingEasy.size() && !trobat) {
                    if (rankingEasy.get(i).getUsername().equals(date)) {
                        System.out.println(rankingEasy.get(i).getUsername());
                        rankingEasy.remove(i);
                        trobat = true;
                    }
                    i++;
                }
                if (!trobat) {
                    System.out.println("No trobat");
                }
                break;
            case levelInter:
                while (i < rankingInter.size() && !trobat) {
                    if (rankingInter.get(i).getUsername().equals(date)) {
                        System.out.println(rankingInter.get(i).getUsername());
                        rankingInter.remove(i);
                        trobat = true;
                    }
                    i++;
                }
                if (!trobat) {
                    System.out.println("No trobat");
                }
                break;
            case levelHard:
                while (i < rankingHard.size() && !trobat) {
                    if (rankingHard.get(i).getUsername().equals(date)) {
                        System.out.println(rankingHard.get(i).getUsername());
                        rankingHard.remove(i);
                        trobat = true;
                    }
                    i++;
                }
                if (!trobat) {
                    System.out.println("No trobat");
                }
                break;
        }
    }

    public void delete_by_position(int index, int dificultat) {
        switch (dificultat) {
            case levelEasy:
                rankingEasy.remove(index);
                break;
            case levelInter:
                rankingInter.remove(index);
                break;
            case levelHard:
                rankingHard.remove(index);
                break;
        }

    }

    /*
    public void delete_by_date(LocalDate date) {
            int i = 0;
            while (i < llistaPosicions.size()) {
                    if (llistaPosicions.get(i).getDate().equals(date)) {
                            System.out.println(llistaPosicions.get(i).getDate());
                            llistaPosicions.remove(i);
                    }
                    i++;
            }
    }*/
    
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

    public ArrayList<Integer> getPos(String user, int dificultat) {
        ArrayList<Integer> ap = new ArrayList<Integer>();
        ListIterator<Posicio> it;

        switch (dificultat) {
            case levelEasy:
                it = rankingEasy.listIterator();
                while (it.hasNext()) {
                    if (it.next().getUsername().equals(user)) {
                        ap.add(it.previousIndex());
                    }
                }
                break;

            case levelInter:
                it = rankingInter.listIterator();
                while (it.hasNext()) {
                    if (it.next().getUsername().equals(user)) {
                        ap.add(it.previousIndex());
                    }
                }
                break;

            case levelHard:
                it = rankingHard.listIterator();
                while (it.hasNext()) {
                    if (it.next().getUsername().equals(user)) {
                        ap.add(it.previousIndex());
                    }
                }
                break;

            default:
                break;
        }
        return ap;
    }

    
    public ArrayList<Integer> getScore(String user, int dificultat) {
        ArrayList<Integer> ap = new ArrayList<Integer>();
        ListIterator<Posicio> it;
        Posicio pis;

        switch (dificultat) {
            case levelEasy:
                it = rankingEasy.listIterator();
                while (it.hasNext()) {
                    pis = it.next();
                    if (pis.getUsername().equals(user)) {
                        ap.add(pis.getScore());
                    }
                }
                break;

            case levelInter:
                it = rankingInter.listIterator();
                while (it.hasNext()) {
                    pis = it.next();
                    if (pis.getUsername().equals(user)) {
                        ap.add(pis.getScore());
                    }
                }
                break;

            case levelHard:
                it = rankingHard.listIterator();
                while (it.hasNext()) {
                    pis = it.next();
                    if (pis.getUsername().equals(user)) {
                        ap.add(pis.getScore());
                    }
                }
                break;

            default:
                break;
        }
        return ap;
    }

    public void deleteUsrRanking(String user) {
        ListIterator<Posicio> it;

        it = rankingEasy.listIterator();
        while (it.hasNext()) {
            if (it.next().getUsername().equals(user)) {
                it.remove();
            }
        }

        it = rankingInter.listIterator();
        while (it.hasNext()) {
            if (it.next().getUsername().equals(user)) {
                it.remove();
            }
        }

        it = rankingHard.listIterator();
        while (it.hasNext()) {
            if (it.next().getUsername().equals(user)) {
                it.remove();
            }
        }
    }

}
