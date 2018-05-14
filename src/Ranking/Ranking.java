/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ranking;

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

    private static final int DIF_easy = 1;
    private static final int DIF_inter = 2;
    private static final int DIF_hard = 3;

    private ArrayList<Posicio> llistaPosicions_easy = new ArrayList<Posicio>();
    private ArrayList<Posicio> llistaPosicions_inter = new ArrayList<Posicio>();
    private ArrayList<Posicio> llistaPosicions_hard = new ArrayList<Posicio>();

    public void insertar_posicio(Posicio pos, int dificultat) {
        switch (dificultat) {
            case DIF_easy:
                llistaPosicions_easy.add(pos);
                Collections.sort(llistaPosicions_easy, new CustomCompare().reversed());
                break;
            case DIF_inter:
                llistaPosicions_inter.add(pos);
                Collections.sort(llistaPosicions_inter, new CustomCompare().reversed());
                break;
            case DIF_hard:
                llistaPosicions_hard.add(pos);
                Collections.sort(llistaPosicions_hard, new CustomCompare().reversed());
                break;
        }
    }

    boolean exists(String nom) {
        ListIterator<Posicio> it_easy = llistaPosicions_easy.listIterator();
        ListIterator<Posicio> it_inter = llistaPosicions_inter.listIterator();
        ListIterator<Posicio> it_hard = llistaPosicions_hard.listIterator();
        boolean trobat = false;
        while (it_easy.hasNext()) {
            Posicio aux = it_easy.next();
            if(aux.getNickname().equals(nom)) trobat = true;
        }
        while (it_inter.hasNext()) {
            Posicio aux = it_inter.next();
            if(aux.getNickname().equals(nom)) trobat = true;
        }
        while (it_hard.hasNext()) {
            Posicio aux = it_hard.next();
            if(aux.getNickname().equals(nom)) trobat = true;
        }
        return trobat;
    }

    public static class CustomCompare implements Comparator<Posicio> {

        @Override
        public int compare(Posicio p1, Posicio p2) {
            return Integer.compare(p1.getPuntacio(), p2.getPuntacio());
        }
    }

    public ArrayList<Posicio> getLlistaPosicio(int dificultat) {
        switch (dificultat) {
            case DIF_easy:
                return llistaPosicions_easy;
            case DIF_inter:
                return llistaPosicions_inter;
            case DIF_hard:
                return llistaPosicions_hard;
        }
        return null;
    }

    public void delete_by_nickname(int dificultat, String nom) {
        boolean trobat = false;
        int i = 0;
        switch (dificultat) {
            case DIF_easy:
                while (i < llistaPosicions_easy.size() && !trobat) {
                    if (llistaPosicions_easy.get(i).getNickname().equals(nom)) {
                        System.out.println(llistaPosicions_easy.get(i).getNickname());
                        llistaPosicions_easy.remove(i);
                        trobat = true;
                    }
                    i++;
                }
                if (!trobat) {
                    System.out.println("No trobat");
                }
                break;
            case DIF_inter:
                while (i < llistaPosicions_inter.size() && !trobat) {
                    if (llistaPosicions_inter.get(i).getNickname().equals(nom)) {
                        System.out.println(llistaPosicions_inter.get(i).getNickname());
                        llistaPosicions_inter.remove(i);
                        trobat = true;
                    }
                    i++;
                }
                if (!trobat) {
                    System.out.println("No trobat");
                }
                break;
            case DIF_hard:
                while (i < llistaPosicions_hard.size() && !trobat) {
                    if (llistaPosicions_hard.get(i).getNickname().equals(nom)) {
                        System.out.println(llistaPosicions_hard.get(i).getNickname());
                        llistaPosicions_hard.remove(i);
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
            case DIF_easy:
                llistaPosicions_easy.remove(index);
                break;
            case DIF_inter:
                llistaPosicions_inter.remove(index);
                break;
            case DIF_hard:
                llistaPosicions_hard.remove(index);
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
    public ArrayList<Posicio> filter_by_nickname(String nom, int dificultat) {
        int i = 0;
        ArrayList<Posicio> aux = new ArrayList<Posicio>();
        switch (dificultat) {
            case DIF_easy:
                while (i < llistaPosicions_easy.size()) {
                    if (llistaPosicions_easy.get(i).getNickname().equals(nom)) {
                        aux.add(llistaPosicions_easy.get(i));
                    }
                    i++;
                }
                return aux;
            case DIF_inter:
                while (i < llistaPosicions_inter.size()) {
                    if (llistaPosicions_inter.get(i).getNickname().equals(nom)) {
                        aux.add(llistaPosicions_inter.get(i));
                    }
                    i++;
                }
                return aux;
            case DIF_hard:
                while (i < llistaPosicions_hard.size()) {
                    if (llistaPosicions_hard.get(i).getNickname().equals(nom)) {
                        aux.add(llistaPosicions_hard.get(i));
                    }
                    i++;
                }
                return aux;
        }

        /*
            for (int j = 0; j < aux.size(); j++) {
                    aux.get(j).print();
            }*/
        return null;
    }

    //dificultat=1 -> easy, dificultat=2 -> llistaPosicions_inter, dificultat=3 -> llistaPosicions_hard
    public ArrayList<Integer> getPos(String user, int dificultat) {
        ArrayList<Integer> ap = new ArrayList<Integer>();
        ListIterator<Posicio> it;

        switch (dificultat) {
            case DIF_easy:
                it = llistaPosicions_easy.listIterator();
                while (it.hasNext()) {
                    if (it.next().getNickname().equals(user)) {
                        ap.add(it.previousIndex());
                    }
                }
                break;

            case DIF_inter:
                it = llistaPosicions_inter.listIterator();
                while (it.hasNext()) {
                    if (it.next().getNickname().equals(user)) {
                        ap.add(it.previousIndex());
                    }
                }
                break;

            case DIF_hard:
                it = llistaPosicions_hard.listIterator();
                while (it.hasNext()) {
                    if (it.next().getNickname().equals(user)) {
                        ap.add(it.previousIndex());
                    }
                }
                break;

            default:
                break;
        }
        return ap;
    }

    //dificultat=1 -> easy, dificultat=2 -> llistaPosicions_inter, dificultat=3 -> llistaPosicions_hard
    public ArrayList<Integer> getScore(String user, int dificultat) {
        ArrayList<Integer> ap = new ArrayList<Integer>();
        ListIterator<Posicio> it;
        Posicio pis;

        switch (dificultat) {
            case DIF_easy:
                it = llistaPosicions_easy.listIterator();
                while (it.hasNext()) {
                    pis = it.next();
                    if (pis.getNickname().equals(user)) {
                        ap.add(pis.getPuntacio());
                    }
                }
                break;

            case DIF_inter:
                it = llistaPosicions_inter.listIterator();
                while (it.hasNext()) {
                    pis = it.next();
                    if (pis.getNickname().equals(user)) {
                        ap.add(pis.getPuntacio());
                    }
                }
                break;

            case DIF_hard:
                it = llistaPosicions_hard.listIterator();
                while (it.hasNext()) {
                    pis = it.next();
                    if (pis.getNickname().equals(user)) {
                        ap.add(pis.getPuntacio());
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

        it = llistaPosicions_easy.listIterator();
        while (it.hasNext()) {
            if (it.next().getNickname().equals(user)) {
                it.remove();
            }
        }

        it = llistaPosicions_inter.listIterator();
        while (it.hasNext()) {
            if (it.next().getNickname().equals(user)) {
                it.remove();
            }
        }

        it = llistaPosicions_hard.listIterator();
        while (it.hasNext()) {
            if (it.next().getNickname().equals(user)) {
                it.remove();
            }
        }
    }

}
