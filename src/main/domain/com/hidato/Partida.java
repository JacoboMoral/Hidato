package main.domain.com.hidato;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

public class Partida {

    private Dificultat dificultat;
    private int puntuacio;
    private Date dataIni;
    private Date dataFi;
    private Hidato hidato;
    private int status; //0 = sense començar; 1 = jugant; 2 = aturada; -1 finalitzada
    private Contador contador;
    private int temps;
    private Usuari usuari;

    public Partida(Hidato hidato, Usuari user) {
        this.hidato = hidato;
        dificultat = hidato.getDificultat();
        status = 0;
        puntuacio = 0;
        contador = new Contador();
        temps = -1;
        usuari = user;

        //NO SE SI AIXO HAURIA D'ANAR AQUI, ESTA FICAT PERQUE FUNCIONI**********************************
        iniciarPartida();
    }

    public void setDataInici(Date dataIni) {
        this.dataIni = dataIni;
    }

    public void setTemps(int temps) {
        this.temps = temps;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private void acabarPartida() {
        contador.detener();
        temps = contador.getSegons();
        status = -1;
        dataFi = new Date();
        ControladorDomini.getInstance().finalitzarPartida();
    }

    public void iniciarPartida() {
        contador.iniciar();
        dataIni = new Date();
        status = 1;
    }

    public void reset() {
        hidato.resetMatriu();
    }

    public boolean ferJugada(int i, int j, int value) {
        if (hidato.moviment(i, j, value)) {
            puntuacio += 10;
            if (hidato.getPossiblesMoviments().size() == 0) {
                acabarPartida();
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean esborrarNombre(int i, int j) {
        if (status != 2 && status != -1) {
            if (hidato.desferMoviment(i, j)) {
                puntuacio -= 2;
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public void demanarPista() {

    }

    public int status() {
        return status;
    }

    public Dificultat getDificultat() {
        return dificultat;
    }

    public TipusAdjacencia getTipusAdjacencia() {
        return hidato.getTipusAdjacencia();
    }

    public Vector<Integer> getNombresPerDefecte() {
        return hidato.getNombresPerDefecte();
    }

    public Vector<Integer> getNombresEscrits() {
        return hidato.getNombresEscrits();
    }

    public Vector<Integer> getPossiblesMoviments() {
        return hidato.getPossiblesMoviments();
    }

    public int getTemps() {
        return temps;
    }

    public int[][] getSolucio() {
        return hidato.getSolucio();
    }

    public int[][] getHidato() {
        return hidato.getMatriu();
    }

    public int[][] getHidatoOriginal() {
        return hidato.getMatriuOriginal();

    }

    public void reprendrePartida() {
        status = 1;
        contador.iniciar();
    }

    public void pausarPartida() {
        status = 2;
        contador.iniciar();
    }

    public Date getDataInici() {
        return dataIni;
    }

    public Date getDataFi() {
        return dataFi;
    }

    public int getPuntuacio() {
        return puntuacio;
    }

    public String getNomUsuari() {
        return usuari.getUsername();
    }

    public boolean esSolucionable() {
        return hidato.teSolucio();
    }

    public boolean completatHidato() {
        return hidato.completat();
    }

    int[] seguentMoviment() {
        return null;
    }

    public TipusCella getTipusCella() {
        return hidato.getTipusCella();
    }

}
