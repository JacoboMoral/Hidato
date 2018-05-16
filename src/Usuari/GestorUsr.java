package Usuari;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GestorUsr {

    public GestorUsr() {

    }

    public boolean afegirUsuari(Usuari u) {
        boolean x = false;
        try {
            File aux = new File("Usuaris/" + u.getUsername());
            if (!aux.exists()) {
                aux.mkdirs();
                File axu = new File("Usuaris/" + u.getUsername() + "/", "password.txt");
                axu.createNewFile();
                FileWriter esc = new FileWriter("Usuaris/" + u.getUsername() + "/password.txt", true);
                BufferedWriter bw = new BufferedWriter(esc);
                bw.write(u.getPassword());
                bw.close();
                esc.close();
                x = true;
            }
        } catch (IOException ex) {

        }
        return x;
    }

    public boolean comprovarUsr(Usuari u) {
        boolean trobat = false;
        try {
            File aux = new File("Usuaris/" + u.getUsername());
            if (aux.exists()) {
                FileReader fr = new FileReader("Usuaris/" + u.getUsername() + "/password.txt");
                BufferedReader bf = new BufferedReader(fr);
                String cont = bf.readLine();
                bf.close();
                fr.close();
                if (cont.equals(u.getPassword())) trobat = true;
            }
        } catch (IOException ex) {

        }
        return trobat;
    }

    public boolean comprovarUsrMod(String u) {
        boolean trobat = false;
        File aux = new File("Usuaris/" + u);
        if (aux.exists()) {
            trobat = true;
        } else {
            trobat = false;
        }
        return trobat;
    }

    public boolean modUsr(String uact, String unou, String pass) {
        boolean trobat = false;
        File fitxer = new File("Usuaris/" + uact);
        if (fitxer.exists()) {
            File fitxer2 = new File("Usuaris/" + unou);
            fitxer.renameTo(fitxer2);
            trobat = true;
        }
        return trobat;
    }

    public boolean modPassword(String u, String pass) {
        boolean trobat = false;
        try {
            File fitxer = new File("Usuaris/" + u);
            if (fitxer.exists()) {
                FileWriter esc = new FileWriter("Usuaris/" + u + "/password.txt");
                BufferedWriter bw = new BufferedWriter(esc);
                bw.write(pass);
                bw.close();
                esc.close();
                trobat = true;
            }
        } catch (IOException ex) {
            
        }
        return trobat;
    }

    public boolean esbUsuari(String u) {
        boolean borr = false;
        File fitxer = new File("Usuaris/" + u);
        File esc = new File("Usuaris/" + u + "/password.txt");
        esc.delete();
        fitxer.delete();
        borr = true;
        return borr;
    }

}
