package Usuari;

/**
 *
 * @author admin
 */
public class Usuari {

    String username;
    String password;

    public Usuari(String u, String p) {
        username = new String(u);
        password = new String(p);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String usr) {
        this.username = usr;
    }

    public void setPassword(String pwd) {
        this.password = pwd;
    }
    
    
}
