package main.domain.com.hidato;

import java.util.Vector;

public class ControladorDomini {
	
	private Partida partidaEnCurs;
	private Hidato hidatoGenerat;
	

	public boolean jugarHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matriuHidato) {
		partidaEnCurs = new Partida (HidatoFactory.createHidato(tipusCella, tipusAdjacencia, matriuHidato));
		if (!partidaEnCurs.esSolucionable()) {
			partidaEnCurs = null;
			return false;
		}
		else return true;
	}
	
	public int[][] obtenirHidatoOriginalDePartida(){
		return partidaEnCurs.getHidatoOriginal();
	}
	
	public int[][] obtenirHidatoDePartida() {
		return partidaEnCurs.getHidato();
	}

	public int[][] solucionarHidatoPartida() {
		return partidaEnCurs.getSolucio();
	}
	
	public int[][] solucionarHidatoGenerat() {
		return hidatoGenerat.getSolucio();
	}
	
	public Vector<Integer> obtenirNombresPerDefecte(){
		return partidaEnCurs.getNombresPerDefecte();
	}
 
	public boolean ferMoviment(int i, int j, int value) {
		if (partidaEnCurs.ferJugada(i, j, value)) return true;
		else return false;
	}
	
	public int[][] getHidatoGenerat(){
		return hidatoGenerat.getMatriu();
	}

	public boolean enPartida() {
		return (partidaEnCurs != null);
	}

	public boolean autoGenerar(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int forats, int tamanyi, int tamanyj) {
		hidatoGenerat = HidatoFactory.createHidato(tipusCella, tipusAdjacencia);
		return hidatoGenerat.autogenerar(forats, tamanyi, tamanyj);
	}
	
	public void jugarHidatoGenerat() {
		partidaEnCurs = new Partida(hidatoGenerat);
	}
	
}
