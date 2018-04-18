package main.domain.com.hidato;

import java.util.Vector;

public class ControladorDomini {
	
	Partida partidaEnCurs;
	

	public boolean jugarHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matriuHidato) {
		partidaEnCurs = new Partida (HidatoFactory.createHidato(tipusCella, tipusAdjacencia, matriuHidato));
		if (!partidaEnCurs.esSolucionable()) {
			partidaEnCurs = null;
			return false;
		}
		else return true;
	}
	
	public int[][] obtenirHidatoOriginal(){
		return partidaEnCurs.getHidatoOriginal();
	}
	
	public int[][] obtenirHidato() {
		return partidaEnCurs.getHidato();
	}

	public int[][] solucionarHidatoPartida() {
		return partidaEnCurs.getSolucio();
	}
	
	public Vector<Integer> obtenirNombresPerDefecte(){
		return partidaEnCurs.getNombresPerDefecte();
	}
 
	public boolean ferMoviment(int i, int j, int value) {
		if (partidaEnCurs.ferJugada(i, j, value)) return true;
		else return false;
	}
	
	public int[][] getHidatoOriginal(){
		return partidaEnCurs.getHidatoOriginal();
	}

	public int[][] getHidatoJugant() {
		return partidaEnCurs.getHidato();
	}

	public boolean enPartida() {
		return (partidaEnCurs != null);
	}

	public boolean autogenerar(TipusCella tipusCella, int celesBuides, int forats, Dificultat dificultat, TipusAdjacencia tipusAdjacencia) {
		int[][] matriuHidato = Algoritmes.generarHidato(tipusCella, tipusAdjacencia,  celesBuides, forats, dificultat);
		if (matriuHidato == null) return false;
		partidaEnCurs = new Partida (HidatoFactory.createHidato(tipusCella, tipusAdjacencia, matriuHidato));
		return true;
	}

}
