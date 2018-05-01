package main.domain.com.hidato;

import java.util.Random;
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
		if (hidatoGenerat != null) {
			partidaEnCurs = new Partida(hidatoGenerat);
			partidaEnCurs.esSolucionable();
		}
	}

	public boolean autoGenerar(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int tamanyi, int tamanyj, int forats) {
		hidatoGenerat = HidatoFactory.createHidato(tipusCella, tipusAdjacencia); //es crea hidato sense matriu
		boolean generat = hidatoGenerat.autogenerar(tamanyi, tamanyj, forats);
		if (generat) return true;
		else{
			hidatoGenerat = null;
			return false;
		}
	}
	
	public boolean autoGenerar(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, Dificultat dificultat) {
		hidatoGenerat = HidatoFactory.createHidato(tipusCella, tipusAdjacencia); //es crea hidato sense matriu
		boolean generat = hidatoGenerat.autogenerar(dificultat);
		if (generat) return true;
		else{
			hidatoGenerat = null;
			return false;
		}
	}
	
	public boolean autoGenerar(Dificultat dificultat) {
		TipusCella tipusCella = getRandomTipusCella();
		TipusAdjacencia tipusAdjacencia = getRandomTipusAdjacencia();
		hidatoGenerat = HidatoFactory.createHidato(tipusCella, tipusAdjacencia); //es crea hidato sense matriu
		boolean generat = hidatoGenerat.autogenerar(dificultat);
		if (generat) return true;
		else{
			hidatoGenerat = null;
			return false;
		}
	}
	
	public boolean autoGenerar(TipusCella tipusCella, Dificultat dificultat) {
		if (tipusCella == TipusCella.QUADRAT) {
			TipusAdjacencia tipusAdjacencia = getRandomTipusAdjacencia();
			hidatoGenerat = HidatoFactory.createHidato(tipusCella, tipusAdjacencia); //es crea hidato sense matriu
		}
		else {
			hidatoGenerat = HidatoFactory.createHidato(tipusCella, TipusAdjacencia.COSTATS); //es crea hidato sense matriu
		}
		boolean generat = hidatoGenerat.autogenerar(dificultat);
		if (generat) return true;
		else{
			hidatoGenerat = null;
			return false;
		}
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
	
	private TipusCella getRandomTipusCella() {
		Random random = new Random();
		int tc = random.nextInt(3);
		if (tc == 0) return TipusCella.QUADRAT;
		if (tc == 1) return TipusCella.TRIANGLE;
		return TipusCella.HEXAGON;
	}

	private TipusAdjacencia getRandomTipusAdjacencia() {
		Random random = new Random();
		int ta = random.nextInt(2);
		if (ta == 0) return TipusAdjacencia.COSTATS;
		return TipusAdjacencia.COSTATSIANGLES;
	}
}
