package Usuari;
public class CtrlUsr {

    private Usuari current;
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

    public boolean logUsuari(String u, String p) {
        System.out.println("HOLA");
        boolean loguejat = false;
        Usuari newCurrent = new Usuari(u, p);
        loguejat = gu.comprovarUsr(newCurrent);
        if (loguejat) {
            current = new Usuari(u, p);
            System.out.println("HOLA SOY " + current.getUsername());
        }
        return loguejat;
    }

    public boolean modUsr(String uact, String unou) {
        boolean fet = false;
        if (uact.equals(current.getUsername()) & !gu.comprovarUsrMod(unou)) {
            Usuari newCurrent = new Usuari(unou, current.getPassword());
            fet = gu.modUsr(uact, unou, newCurrent.getPassword());
            if (fet) {
                current = newCurrent;
            }
        }
        return fet;
    }

    public boolean modPass(String pact, String pnov) {
        boolean fet = false;
        if (pact.equals(current.getPassword())) {
            Usuari newCurrent = new Usuari(current.getUsername(), pnov);
            fet = gu.modPassword(newCurrent.getUsername(), pnov);
            if (fet) {
                current = newCurrent;
            }
        }
        return fet;
    }

    public boolean esbUsr(String pass) {
        boolean fet = false;
        if (pass.equals(current.getPassword())) {
            fet = gu.esbUsuari(current.getUsername());
        }
        return fet;
    }

    public String getUsername() {
        return current.getUsername();
    }

    public Usuari getUser() {
        return current;
    }
}
