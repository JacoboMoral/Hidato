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
    private int tempsSegons;
    private long tempsNanosegons;
    private Usuari usuari;

    public Partida(Hidato hidato, Usuari user) {
        this.hidato = hidato;
        dificultat = hidato.getDificultat();
        status = 0;
        puntuacio = 0;
        contador = new Contador();
        tempsSegons = -1;
        tempsNanosegons = -1;
        usuari = user;

        iniciarPartida();
    }

    public void setDataInici(Date dataIni) {
        this.dataIni = dataIni;
    }

    public void setTemps(int temps) {
        this.tempsSegons = temps;
    }

    public void setPuntuacio(int puntuacio) {
        this.puntuacio = puntuacio;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    private void acabarPartida() {
        if (status != -1) {
            status = -1;
            puntuacio += hidato.getCellesNumeriques() * 5;
            if (puntuacio < 0) {
                puntuacio = 1;
            }
            contador.detener();
            //tempsSegons += contador.getSegons();
            //tempsNanosegons += contador.getNanosegons();
            status = -1;
            dataFi = new Date();
            ControladorDomini.getInstance().finalitzarPartida();
        }
    }

    public void iniciarPartida() {
        contador.iniciar();
        dataIni = new Date();
        status = 1;
        tempsSegons = 0;
        tempsNanosegons = 0;
    }

    public void reset() {
        hidato.resetMatriu();
    }

    public boolean ferJugada(int i, int j, int value, boolean ajuda) {
        if (hidato.moviment(i, j, value, ajuda)) {
            if (hidato.getPossiblesMoviments().size() == 0 && hidato.completat()) {
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
    
    public int gettempsPartidaGuardada() {
    	if(tempsSegons != -1) return tempsSegons;
    	return 0;
    }
    

    public int getTemps() {
        return contador.getSegons();
    }

    public long getTempsNano() {
        return contador.getNanosegons();
    }

    public int[][] getSolucio() {
        return hidato.getSolucio();
    }

    public int[][] getSolucio(boolean solucioRespecteMatriuHidato) {
        //es "cancela" la partida actual
        iniciarPartida();
        int[][] matriu = hidato.getSolucio(solucioRespecteMatriuHidato);
        acabarPartida();
        return matriu;
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

    public boolean completada() {
        if (hidato.completat()) {
            acabarPartida();
            return true;
        }
        return false;
    }

    int[] seguentMoviment() {
        return null;
    }

    public TipusCella getTipusCella() {
        return hidato.getTipusCella();
    }
}
