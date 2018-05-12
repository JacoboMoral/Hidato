package Ranking;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class GestorRanking {

    public GestorRanking() {

    }

    public void store(Ranking r) {
        try {
            File aux = new File("Ranking");
            if (!aux.exists()) {
                aux.mkdirs();
            }
            File easy = new File("Ranking/", "facil.txt");
            if (!easy.exists()) {
                easy.createNewFile();
            }
            File inter = new File("Ranking/", "normal.txt");
            if (!inter.exists()) {
                inter.createNewFile();
            }
            File hard = new File("Ranking/", "dificil.txt");
            if (!hard.exists()) {
                hard.createNewFile();
            }
            ArrayList<Posicio> ranking_easy = r.getLlistaPosicio(1);
            ArrayList<Posicio> ranking_inter = r.getLlistaPosicio(2);
            ArrayList<Posicio> ranking_hard = r.getLlistaPosicio(3);
            FileWriter store_easy = new FileWriter("Ranking/facil.txt");
            BufferedWriter bweasy = new BufferedWriter(store_easy);
            String f = null;
            for (int i = 0; i < ranking_easy.size(); ++i) {
                f = ranking_easy.get(i).getNickname() + " " + ranking_easy.get(i).getPuntacio() + " ";
                bweasy.write(f);
            }
            bweasy.close();
            store_easy.close();
            FileWriter store_inter = new FileWriter("Ranking/normal.txt");
            BufferedWriter bwinter = new BufferedWriter(store_inter);
            for (int i = 0; i < ranking_inter.size(); ++i) {
                f = ranking_inter.get(i).getNickname() + " " + ranking_inter.get(i).getPuntacio() + " ";
                bwinter.write(f);
            }
            bwinter.close();
            store_inter.close();
            FileWriter store_hard = new FileWriter("Ranking/dificil.txt");
            BufferedWriter bwhard = new BufferedWriter(store_hard);
            for (int i = 0; i < ranking_hard.size(); ++i) {
                f = ranking_hard.get(i).getNickname() + " " + ranking_hard.get(i).getPuntacio() + " ";
                bwhard.write(f);
            }
            bwhard.close();
            store_hard.close();
        } catch (IOException ex) {

        }
    }

    public Ranking load() {
        Ranking r = new Ranking();
        try {
            File fac = new File("Ranking/", "facil.txt");
            if (fac.exists()) {
                Scanner fc = new Scanner(fac);
                int puntuacio;
                String nom;
                while (fc.hasNext()) {
                    nom = fc.next();
                    puntuacio = fc.nextInt();
                    LocalDate date = LocalDate.now();
                    Posicio p = new Posicio(nom, puntuacio, date);
                    r.insertar_posicio(p, 1);
                }
                fc.close();
            }
            File nor = new File("Ranking/", "normal.txt");
            if (nor.exists()) {
                Scanner nc = new Scanner(nor);
                int puntuacio;
                String nom;
                while (nc.hasNext()) {
                    nom = nc.next();
                    puntuacio = nc.nextInt();
                    LocalDate date = LocalDate.now();
                    Posicio p = new Posicio(nom, puntuacio, date);
                    r.insertar_posicio(p, 2);
                }
                nc.close();
            }
            File dif = new File("Ranking/", "dificil.txt");
            if (dif.exists()) {
                Scanner dc = new Scanner(dif);
                int puntuacio;
                String nom;
                while (dc.hasNext()) {
                    nom = dc.next();
                    puntuacio = dc.nextInt();
                    LocalDate date = LocalDate.now();
                    Posicio p = new Posicio(nom, puntuacio, date);
                    r.insertar_posicio(p, 3);
                }
                dc.close();
            }
        } catch (IOException ex) {

        }
        return r;
    }
}
