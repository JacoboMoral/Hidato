package main.domain.com.hidato;

import java.util.Vector;

public class ControladorDomini {
	
	private Partida partidaEnCurs = null;
	private Hidato hidatoGenerat = null;;
	

	public boolean jugarHidatoImportat(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matriuHidato) {
		partidaEnCurs = new Partida (HidatoFactory.createHidato(tipusCella, tipusAdjacencia, matriuHidato));
		if (!partidaEnCurs.esSolucionable()) {
			partidaEnCurs = null;
			return false;
		}
		else return true;
	}
	
	public void jugarHidatoGenerat() {
		if (hidatoGenerat != null) partidaEnCurs = new Partida(hidatoGenerat);
	}

	public boolean autoGenerar(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int forats, int tamanyi, int tamanyj) {
		boolean generat = hidatoGenerat.autogenerar(forats, tamanyi, tamanyj);
		if (generat) hidatoGenerat = HidatoFactory.createHidato(tipusCella, tipusAdjacencia);
		return generat;
	}

	public int[][] getMatriuHidatoOriginalDePartida(){
		return partidaEnCurs.getHidatoOriginal();
	}
	
	public int[][] getMatriuHidatoDePartida() {
		return partidaEnCurs.getHidato();
	}

	public int[][] solucionarHidatoPartida() {
		return partidaEnCurs.getSolucio();
	}
	
	public int[][] solucionarHidatoGenerat() {
		if (hidatoGenerat == null) return null;
		return hidatoGenerat.getSolucio();
	}
	
	public int[][] getMatriuHidatoGenerat(){
		if (hidatoGenerat == null) return null;
		return hidatoGenerat.getMatriu();
	}
	
	public Vector<Integer> getNombresPerDefecte(){
		return partidaEnCurs.getNombresPerDefecte();
	}
 
	public boolean ferMoviment(int i, int j, int value) {
		if (partidaEnCurs.ferJugada(i, j, value)) return true;
		return false;
	}

	public boolean enPartida() {
		return (partidaEnCurs != null);
	}

}
