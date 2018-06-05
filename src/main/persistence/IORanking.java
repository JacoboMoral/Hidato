/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.persistence;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import main.domain.com.hidato.Posicio;
import main.domain.com.hidato.Ranking;

/**
 *
 * @author admin
 */
public class IORanking {

    private static final int levelEasy = 1;
    private static final int levelInter = 2;
    private static final int levelHard = 3;

    public static void saveScoreDB(Ranking ranking, int dif, int score, String username) {
        LocalDate date = LocalDate.now();
        Posicio p = new Posicio(username, score, date);
        ranking.insertPosition(p, dif);
        saveRanking(ranking);
    }

    public static void saveRanking(Ranking r) {
        try {
            ArrayList<Posicio> rankingEasy = r.getLlistaPosicio(levelEasy);
            ArrayList<Posicio> rankingInter = r.getLlistaPosicio(levelInter);
            ArrayList<Posicio> rankingHard = r.getLlistaPosicio(levelHard);
            
            File temp = new File("DB/Ranking");
            if (!temp.exists()) {
                temp.mkdirs();
            }

            File easyFile = new File("DB/Ranking/", "easy.txt");
            if (!easyFile.exists()) {
                easyFile.createNewFile();
            }

            File interFile = new File("DB/Ranking/", "inter.txt");
            if (!interFile.exists()) {
                interFile.createNewFile();
            }

            File hardFIle = new File("DB/Ranking/", "hard.txt");
            if (!hardFIle.exists()) {
                hardFIle.createNewFile();
            }

            FileWriter createFile = new FileWriter("DB/Ranking/easy.txt");
            BufferedWriter bw = new BufferedWriter(createFile);
            String positionContent = null;

            for (int i = 0; i < rankingEasy.size(); ++i) {
                positionContent = rankingEasy.get(i).getUsername() + " " + rankingEasy.get(i).getScore() + " " + rankingEasy.get(i).getDate() + " ";
                bw.write(positionContent);
            }
            bw.close();
            createFile.close();

            createFile = new FileWriter("DB/Ranking/inter.txt");
            bw = new BufferedWriter(createFile);
            for (int i = 0; i < rankingInter.size(); ++i) {
                positionContent = rankingInter.get(i).getUsername() + " " + rankingInter.get(i).getScore() + " " + rankingInter.get(i).getDate() + " ";
                bw.write(positionContent);
            }
            bw.close();
            createFile.close();

            createFile = new FileWriter("DB/Ranking/hard.txt");
            bw = new BufferedWriter(createFile);
            for (int i = 0; i < rankingHard.size(); ++i) {
                positionContent = rankingHard.get(i).getUsername() + " " + rankingHard.get(i).getScore() + " " + rankingHard.get(i).getDate() + " ";
                bw.write(positionContent);
            }
            bw.close();
            createFile.close();

        } catch (IOException ex) {

        }

    }

    public static Ranking readRanking() {
        Ranking r = new Ranking();
        try {
            File easyFile = new File("DB/Ranking/", "easy.txt");
            if (easyFile.exists()) {
                Scanner s = new Scanner(easyFile);
                int points;
                String username;
                LocalDate date;
                while (s.hasNext()) {
                    username = s.next();
                    points = s.nextInt();
                    date = LocalDate.parse(s.next());
                    Posicio p = new Posicio(username, points, date);
                    r.insertPosition(p, levelEasy);
                }
                s.close();
            }
            File interFile = new File("DB/Ranking/", "inter.txt");
            if (interFile.exists()) {
                Scanner s = new Scanner(interFile);
                int puntuacio;
                String nom;
                LocalDate date;
                while (s.hasNext()) {
                    nom = s.next();
                    puntuacio = s.nextInt();
                    date = LocalDate.parse(s.next());
                    Posicio p = new Posicio(nom, puntuacio, date);
                    r.insertPosition(p, levelInter);
                }
                s.close();
            }
            File hardFile = new File("DB/Ranking/", "hard.txt");
            if (hardFile.exists()) {
                Scanner s = new Scanner(hardFile);
                int puntuacio;
                String nom;
                LocalDate date;
                while (s.hasNext()) {
                    nom = s.next();
                    puntuacio = s.nextInt();
                    date = LocalDate.parse(s.next());
                    Posicio p = new Posicio(nom, puntuacio, date);
                    r.insertPosition(p, levelHard);
                }
                s.close();
            }
        } catch (IOException ex) {

        }
        return r;
    }

    public static String[] getRankingEasy(Ranking r) {
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

    public static String[] getRankingInter(Ranking r) {
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

    public static String[] getRankingHard(Ranking r) {
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

    public static String[] getFilterByUsername(Ranking r, String username, int level) {
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

    public static void deteleUserRanking(Ranking r, String nom) {
        r.deleteUserRanking(nom);
        saveRanking(r);
    }

    public static boolean existsUser(Ranking r, String nom) {
        return r.existsUser(nom);
    }

    public static String[] getFilterByDate(Ranking r, String date, int level) {
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

    public static boolean existsDate(Ranking r, String date) {
        return r.existsDate(date);
    }

}
