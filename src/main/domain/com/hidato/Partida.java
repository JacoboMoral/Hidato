package main.domain.com.hidato;

import java.util.Date;
import java.util.Vector;

public class Partida {
	private Dificultat dificultat;
	private int puntuacio;
	private Date dataIni;
	private Date dataFi;
	private Hidato hidato;
	boolean finalitzada;
	int[][] solucioHidato;
	
	public Partida(Hidato hidato) {
		this.hidato = hidato;
		dificultat = hidato.getDificultat();
		finalitzada = false;
		dataIni = new Date();
		puntuacio = 0;
	}
	
	
	public void acabarPartida() {
		finalitzada = true;
		dataFi = new Date();
	}
	
	public void start() {
		
	}
	
	public void reset() {
		hidato.resetMatriu();
		start();
	}
	
	public boolean ferJugada(int i, int j, int value) {
		if (hidato.moviment(i, j, value)) return true;
		else return false;
	}
	
	public void demanarPista() {
		
	}
	
	public Vector<Integer> getNombresPerDefecte(){
		return hidato.getNombresPerDefecte();
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
	
	public Date getDataIni() {
		return dataIni;
	}
	
	public Date getDataFi() {
		return dataFi;
	}
	
	public int getPuntuacio() {
		return puntuacio;
	}


	public boolean esSolucionable() {
		return hidato.teSolucio();
	}
}
