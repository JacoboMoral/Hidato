/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuari;

/**
 *
 * @author admin
 */
public class CtrlUsr {
    private Usuari current;
    private GestorUsr gu;

    /*Constructora*/    
    public CtrlUsr() {
        gu = new GestorUsr();
    }

    //Afegim un nou Usuari
    public boolean afegirUsuari(String u, String p) {
            boolean afegit = false;
            Usuari aux = new Usuari(u, p);
            afegit = gu.afegirUsuari(aux);
            return afegit;
    }

    //Quan passem false comprovem password i nom d'usuari.
    //Quan passem true comprovarem el noms d'usuari.
    public boolean logUsuari(String u, String p){
            boolean loguejat = false;
            Usuari newCurrent = new Usuari(u, p);
            loguejat = gu.comprovarUsr(newCurrent);
            if (loguejat) current = new Usuari(u, p);
            return loguejat;
    }

    //Ens modifica el nostre nom d'usuari
    public boolean modUsr(String uact, String unou){
            boolean fet = false;
            if (uact.equals(current.getUsr()) & !gu.comprovarUsrMod(unou)){
                    Usuari newCurrent = new Usuari(unou, current.getPass());
                    fet = gu.modUsr(uact, unou, newCurrent.getPass());
                    if (fet) current = newCurrent;
            }
            return fet;
    }

    //Modifica la nostra password
    public boolean modPass(String pact, String pnov){
            boolean fet = false;
            if (pact.equals(current.getPass())){
                    Usuari newCurrent = new Usuari(current.getUsr(), pnov);
                    fet=gu.modPassword(newCurrent.getUsr(), pnov);
                    if (fet) current = newCurrent;
            }
            return fet;
    }

    public boolean esbUsr(String pass){
            boolean fet = false;
            if (pass.equals(current.getPass())){
                    fet=gu.esbUsuari(current.getUsr());
            }
            return fet;
    }
}
