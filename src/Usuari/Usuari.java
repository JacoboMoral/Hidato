package Usuari;

/**
 *
 * @author admin
 */
public class Usuari {

    private String username;
    private String password;

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

    public void setUsername(String name) {
        this.username = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
