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

    public String getUsr(){
        return username;
    }

    public String getPass(){
            return password;
    }

    public void setUsr(String usr){
            this.username = usr;
    }

    public void setPass(String pwd){
            this.password = pwd;
    }
}

