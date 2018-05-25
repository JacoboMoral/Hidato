package main.persistence;

import main.domain.com.hidato.Posicio;
import main.domain.com.hidato.Ranking;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;

public class CtrlPersistence {

    private static final int levelEasy = 1;
    private static final int levelInter = 2;
    private static final int levelHard = 3;

    public CtrlPersistence() {

    }

    public void saveRanking(Ranking r) {
        try {
            ArrayList<Posicio> rankingEasy = r.getLlistaPosicio(levelEasy);
            ArrayList<Posicio> rankingInter = r.getLlistaPosicio(levelInter);
            ArrayList<Posicio> rankingHard = r.getLlistaPosicio(levelHard);

            File temp = new File("DB/Ranking");
            if (!temp.exists()) temp.mkdirs();
            
            File easyFile = new File("DB/Ranking/", "easy.txt");
            if (!easyFile.exists()) easyFile.createNewFile();
            
            File interFile = new File("DB/Ranking/", "inter.txt");
            if (!interFile.exists()) interFile.createNewFile();
            
            File hardFIle = new File("DB/Ranking/", "hard.txt");
            if (!hardFIle.exists()) hardFIle.createNewFile();

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
                positionContent = rankingInter.get(i).getUsername() + " " + rankingInter.get(i).getScore() + " " + rankingEasy.get(i).getDate() + " ";
                bw.write(positionContent);
            }
            bw.close();
            createFile.close();

            createFile = new FileWriter("DB/Ranking/hard.txt");
            bw = new BufferedWriter(createFile);
            for (int i = 0; i < rankingHard.size(); ++i) {
                positionContent = rankingHard.get(i).getUsername() + " " + rankingHard.get(i).getScore() + " " + rankingEasy.get(i).getDate() + " ";
                bw.write(positionContent);
            }
            bw.close();
            createFile.close();
            
        } catch (IOException ex) {

        }

    }

    public Ranking readRanking() {
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
    
    public boolean usernameExists(String username) {
        File temp = new File("DB/Usuaris/" + username);
        return temp.exists();
    }
    
    public boolean changeUsername(String currentUsername, String newUsername) {
        File temp = new File("DB/Usuaris/" + currentUsername);
        if (temp.exists()) {
            File temp2 = new File("DB/Usuaris/" + newUsername);
            temp.renameTo(temp2);
            return true;
        }
        return false;
    }
    
    public boolean deleteUser(String username) {
        File temp = new File("DB/Usuaris/" + username);
        File temp2 = new File("Usuaris/" + username + "/password.txt");
        temp2.delete();
        temp.delete();
        return true;
    }
    
    public boolean changePassword(String currentUsername, String newPassword) throws IOException {
        File temp = new File("DB/Usuaris/" + currentUsername);
        if (temp.exists()) {
            FileWriter fw = new FileWriter("DB/Usuaris/" + currentUsername + "/password.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(newPassword);
            bw.close();
            fw.close();
            return true;
        }
        return false;
    }
    
}
