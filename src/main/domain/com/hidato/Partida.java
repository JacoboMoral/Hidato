package main.domain.com.hidato;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

import Usuari.Usuari;

public class Partida implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 8329220665972618748L;
	private Dificultat dificultat;
    private int puntuacio;
    private Date dataIni;
    private Date dataFi;
    private Hidato hidato;
    private Usuari usuari;
    private int status; //0 = sense començar; 1 = jugant; -1 finalitzada

    public Partida(Hidato hidato) {
            this.hidato = hidato;
            dificultat = hidato.getDificultat();
            status = 0;
            puntuacio = 0;
    }

    public void acabarPartida() {
            status = -1;
            dataFi = new Date();
    }

    public void iniciarPartida() {
            dataIni = new Date();
            status = 1;
    }

    public void reset() {
            hidato.resetMatriu();
    }

    public boolean ferJugada(int i, int j, int value) {
            if (hidato.moviment(i, j, value)) return true;
            else return false;
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

    public Vector<Integer> getNombresPerDefecte(){
            return hidato.getNombresPerDefecte();
    }
    public Vector<Integer> getNombresEscrits(){
    	return hidato.getNombresEscrits();
    }

    public int[][] getSolucio() {
            return hidato.getSolucio();
    }

    public int[][] getHidato(){
            return hidato.getMatriu();
    }

    public int[][] getHidatoOriginal(){
            return hidato.getMatriuOriginal();
    }

    public void reprendrePartida() {

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
    		return "aaa";
    		//return usuari.getUsername();
    }

    public boolean esSolucionable() {
            return hidato.teSolucio();
    }

    int[] seguentMoviment() {
        return null;
    }

	public TipusCella getTipusCella() {
		// TODO Auto-generated method stub
		return hidato.getTipusCella();
	}
}
