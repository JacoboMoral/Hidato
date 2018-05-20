package Usuari;
public class CtrlUsr {

    private Usuari currentUsr;
    private GestorUsr gu;

    public CtrlUsr() {
        gu = new GestorUsr();
    }

    public boolean afegirUsuari(String u, String p) {
        boolean afegit = false;
        Usuari aux = new Usuari(u, p);
        afegit = gu.afegirUsuari(aux);
        return afegit;
    }

    public boolean logUsr(String u, String p) {
        boolean exists = false;
        Usuari newCurrent = new Usuari(u, p);
        exists = gu.comprovarUsr(newCurrent);
        if (exists) {
            currentUsr = new Usuari(u, p);
        }
        return exists;
    }

    public boolean editUsr(String currentU, String unou) {
        boolean done = false;
        if (currentU.equals(currentUsr.getUsername()) & !gu.comprovarUsrMod(unou)) {
            Usuari newCurrent = new Usuari(unou, currentUsr.getPassword());
            done = gu.modUsr(currentU, unou, newCurrent.getPassword());
            if (done) {
                currentUsr = newCurrent;
            }
        }
        return done;
    }

    public boolean changePass(String pact, String pnov) {
        boolean fet = false;
        if (pact.equals(currentUsr.getPassword())) {
            Usuari newCurrent = new Usuari(currentUsr.getUsername(), pnov);
            fet = gu.modPassword(newCurrent.getUsername(), pnov);
            if (fet) {
                currentUsr = newCurrent;
            }
        }
        return fet;
    }

    public boolean deleteUsr(String pass) {
        boolean fet = false;
        if (pass.equals(currentUsr.getPassword())) {
            fet = gu.esbUsuari(currentUsr.getUsername());
        }
        return fet;
    }

    public String getUsername() {
        return currentUsr.getUsername();
    }

    public Usuari getUser() {
        return currentUsr;
    }

    public String getPassword() {
        return currentUsr.getPassword();
    }
}
