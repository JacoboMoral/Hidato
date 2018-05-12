package Ranking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ListIterator;

public class CtrlRanking {

    Ranking r;

    public CtrlRanking() {
        GestorRanking gr = new GestorRanking();
        r = gr.load();
    }

    public void saveScore(int dif, int score, String usr) {
        LocalDate date = LocalDate.now();
        Posicio p = new Posicio(usr, score, date);
        r.insertar_posicio(p, dif);

        GestorRanking gr = new GestorRanking();
        gr.store(r);
    }

    public String getRank(int dif) {
        ArrayList<Posicio> rank = r.getLlistaPosicio(dif);
        ListIterator<Posicio> it = rank.listIterator();
        String s = "";
        Posicio aux = null;

        while (it.hasNext()) {
            aux = it.next();
            s += (it.previousIndex() + 1) + ": " + aux.getNickname() + " - " + aux.getPuntacio() + "\n"; // "pos,score,usuario<salto-de-linea>"

        }

        s += ".";		//indica final de string

        return s;
    }

    /*
    public ArrayList<Integer> getPos(String usr, int dif) {
        return r.getPos(usr, dif);
    }

    public ArrayList<Integer> getScore(String usr, int dif) {
        return r.getScore(usr, dif);
    }

    public String getUsrScore(String usr, int dif) {
        ArrayList<Integer> pos = r.getPos(usr, dif);
        ArrayList<Integer> score = r.getScore(usr, dif);
        String s = usr + ":\n";
        ListIterator<Integer> itPos = pos.listIterator();
        ListIterator<Integer> itScore = score.listIterator();
        int aux;

        while (itPos.hasNext() && itScore.hasNext()) {
            aux = itPos.next();
            s += (aux + 1) + ": "; // "pos,"
            aux = itScore.next();
            s += aux + "\n"; //"pos,score<salto-de-linea>"
        }
        s += ".";	//indica final de string

        return s;
    }
     */

    public String[] getRanking_easy() {
        ArrayList<Posicio> llista = r.getLlistaPosicio(1);
        String fac[] = new String[llista.size()];
        int i = 0;
        Posicio aux = null;
        ListIterator<Posicio> it = llista.listIterator();
        while (i < llista.size()) {
            aux = it.next();
            fac[i] = (i + 1) + "     " + Integer.toString(aux.getPuntacio()) + "     " + aux.getNickname() + "    " + aux.getDate();
            ++i;
        }
        return fac;
    }

    public String[] getRanking_inter() {
        ArrayList<Posicio> llista = r.getLlistaPosicio(2);
        String nor[] = new String[llista.size()];
        int i = 0;
        Posicio aux = null;
        ListIterator<Posicio> it = llista.listIterator();
        while (i < llista.size()) {
            aux = it.next();
            nor[i] = (i + 1) + "     " + Integer.toString(aux.getPuntacio()) + "     " + aux.getNickname() + "    " + aux.getDate();
            ++i;
        }
        return nor;
    }

    public String[] getRanking_hard() {
        ArrayList<Posicio> llista = r.getLlistaPosicio(3);
        String dif[] = new String[llista.size()];
        int i = 0;
        Posicio aux = null;
        ListIterator<Posicio> it = llista.listIterator();
        while (i < llista.size()) {
            aux = it.next();
            dif[i] = (i + 1) + "     " + Integer.toString(aux.getPuntacio()) + "     " + aux.getNickname() + "    " + aux.getDate();
            ++i;
        }
        return dif;
    }

    public String[] getFacilUsr(String usr) {
        ArrayList<Posicio> facaux = r.getLlistaPosicio(1);
        String fac[] = new String[facaux.size()];
        int i = 0;
        Posicio aux = null;
        ListIterator<Posicio> it = facaux.listIterator();
        while (i < facaux.size()) {
            aux = it.next();
            if ((aux.getNickname().equals(usr))) {
                fac[i] = (i + 1) + " " + Integer.toString(aux.getPuntacio()) + " " + aux.getNickname();
            }
            ++i;
        }
        return fac;
    }

    public String[] getNormalUsr(String usr) {
        ArrayList<Posicio> noraux = r.getLlistaPosicio(2);
        String nor[] = new String[noraux.size()];
        int i = 0;
        Posicio aux = null;
        ListIterator<Posicio> it = noraux.listIterator();
        while (i < noraux.size()) {
            aux = it.next();
            if ((aux.getNickname().equals(usr))) {
                nor[i] = (i + 1) + " " + Integer.toString(aux.getPuntacio()) + " " + aux.getNickname();
            }
            ++i;
        }
        return nor;
    }

    public String[] getDificilUsr(String usr) {
        ArrayList<Posicio> difaux = r.getLlistaPosicio(3);
        String dif[] = new String[difaux.size()];
        int i = 0;
        Posicio aux = null;
        ListIterator<Posicio> it = difaux.listIterator();
        while (i < difaux.size()) {
            aux = it.next();
            if ((aux.getNickname().equals(usr))) {
                dif[i] = (i + 1) + " " + Integer.toString(aux.getPuntacio()) + " " + aux.getNickname();
            }
            ++i;
        }
        return dif;
    }

    public void deleteUsr(String nom) {
        r.deleteUsrRanking(nom);

        GestorRanking gr = new GestorRanking();
        gr.store(r);
    }

    public boolean existsUsuari(String nom) {
        return r.exists(nom);
    }
}
