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

/**
 *
 * @author admin
 */
public class IOUsuari {
    /*
    ---------------------------------------------------------
    |                                                       |
    |                   GESTIONAR USER                      |                        
    |                                                       |
    ---------------------------------------------------------
    */
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
        File temp2 = new File("Usuaris/" + username + "/password.txt");
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
}
