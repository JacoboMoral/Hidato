/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import main.domain.com.hidato.Usuari;

/**
 *
 * @author admin
 */
public class IOUsuari {

    private static String currentUsername;
    private static String currentPassword;

    public static boolean usernameExists(String username) {
        File temp = new File("DB/Usuaris/" + username);
        return temp.exists();
    }

    public static boolean changeUsername(String currentUsername, String newUsername) {
        File temp = new File("DB/Usuaris/" + currentUsername);
        if (temp.exists()) {
            File temp2 = new File("DB/Usuaris/" + newUsername);
            temp.renameTo(temp2);
            return true;
        }
        return false;
    }

    public static boolean deleteUser(String username) {
        File temp = new File("DB/Usuaris/" + username);
        File temp2 = new File("DB/Usuaris/" + username + "/password.txt");
        temp2.delete();
        temp.delete();
        return true;
    }

    public static boolean changePassword(String currentUsername, String newPassword) throws IOException {
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

    public static boolean loginUsuari(String username, String password) throws FileNotFoundException, IOException {
        boolean userPassMatch = false;
        String contingut_password;
        File temp = new File("DB/Usuaris/" + username);
        if (temp.exists()) {
            FileReader fr = new FileReader("DB/Usuaris/" + username + "/password.txt");
            BufferedReader br = new BufferedReader(fr);
            contingut_password = br.readLine();
            br.close();
            fr.close();
            if (contingut_password.equals(password)) {
                userPassMatch = true;
                currentUsername = username;
                currentPassword = password;
            }
        }
        return userPassMatch;
    }

    public static boolean afegirUsuari(String username, String password) throws IOException {
        boolean successful = false;
        String nospaceName = username.trim();
        File temp = new File("DB/Usuaris/" + nospaceName);
        if (!temp.exists()) {
            temp.mkdirs();
            File temp2 = new File("DB/Usuaris/" + nospaceName + "/", "password.txt");
            temp2.createNewFile();
            FileWriter esc = new FileWriter("DB/Usuaris/" + nospaceName + "/password.txt", true);
            BufferedWriter bw = new BufferedWriter(esc);
            bw.write(password);
            bw.close();
            esc.close();
            successful = true;
        }
        return successful;
    }

    public static boolean editUseranme(String currentname, String newUsername) {
        boolean successful = false;
        if (!usernameExists(newUsername) && currentname.equals(currentUsername)) {
            successful = changeUsername(currentUsername, newUsername);
            if (successful) {
                currentUsername = currentname;
            }
        }
        return successful;
    }

    public static boolean changePass(String currentPass, String newPass) throws IOException {
        boolean successful = false;
        if (currentPass.equals(currentPassword)) {
            successful = changePassword(currentUsername, newPass);
            if (successful) {
                currentPassword = newPass;
            }
        }
        return successful;
    }

    public static boolean deleteUer(String pass) {
        if (pass.equals(currentPassword)) {
            return deleteUser(currentUsername);
        }
        return false;
    }
}
