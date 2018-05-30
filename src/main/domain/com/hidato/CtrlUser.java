package main.domain.com.hidato;

import main.domain.com.hidato.Usuari;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import main.persistence.ControladorPersistencia;

public class CtrlUser {

    private Usuari currentUser;
    ControladorPersistencia cp = new ControladorPersistencia();

    public CtrlUser() {

    }

    public boolean loginUsuari(String username, String pass) throws FileNotFoundException, IOException {
        boolean userPassMatch = false;
        String contingut_password;
        File temp = new File("DB/Usuaris/" + username);
        if (temp.exists()) {
            FileReader fr = new FileReader("DB/Usuaris/" + username + "/password.txt");
            BufferedReader br = new BufferedReader(fr);
            contingut_password = br.readLine();
            br.close();
            fr.close();
            if (contingut_password.equals(pass)) {
                userPassMatch = true;
                currentUser = new Usuari(username, pass);
            }
        }
        return userPassMatch;
    }

    public boolean afegirUsuari(String username, String pass) throws IOException {
        boolean successful = false;
        File temp = new File("DB/Usuaris/" + username);
        if (!temp.exists()) {
            temp.mkdirs();          //fem varies carpetes
            File temp2 = new File("DB/Usuaris/" + username + "/", "password.txt");
            temp2.createNewFile();
            FileWriter esc = new FileWriter("DB/Usuaris/" + username + "/password.txt", true);
            BufferedWriter bw = new BufferedWriter(esc);
            bw.write(pass);
            bw.close();
            esc.close();
            successful = true;
        }
        return successful;
    }

    public boolean editUsername(String currentUsername, String newUsername) {
        boolean successful = false;
        if (!usernameExists(newUsername) && currentUsername.equals(currentUser.getUsername())) {
            Usuari newCurrent = new Usuari(newUsername, currentUser.getPassword());
            successful = changeUsername(currentUsername, newUsername);
            if (successful) {
                currentUser = newCurrent;
            }
        }
        return successful;
    }

    public boolean changePass(String currentPass, String newPass) throws IOException {
        boolean successful = false;
        if (currentPass.equals(currentUser.getPassword())) {
            Usuari newCurrent = new Usuari(currentUser.getUsername(), newPass);
            successful = changePassword(newCurrent.getUsername(), newPass);
            if (successful) {
                currentUser = newCurrent;
            }
        }
        return successful;
    }

    public boolean deleteUsr(String pass) {
        if (pass.equals(currentUser.getPassword())) {
            return deleteUser(currentUser.getUsername());
        }
        return false;
    }

    public String getUsername() {
        return currentUser.getUsername();
    }

    public Usuari getUser() {
        return currentUser;
    }

    public String getPassword() {
        return currentUser.getPassword();
    }

    private boolean usernameExists(String username) {
        return cp.usernameExists(username);
    }

    private boolean changeUsername(String currentUsername, String newUsername) {
        return cp.changeUsername(currentUsername, newUsername);
    }

    private boolean deleteUser(String username) {
        return cp.deleteUser(username);
    }

    private boolean changePassword(String currentUsername, String newPassword) throws IOException {
        return cp.changePassword(currentUsername, newPassword);
    }
}
