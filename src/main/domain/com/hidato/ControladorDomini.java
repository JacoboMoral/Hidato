package main.domain.com.hidato;

public class ControladorDomini {
	Partida partidaEnCurs;
	

	public boolean jugarHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matriuHidato) {
		partidaEnCurs = new Partida (new Hidato(tipusCella,tipusAdjacencia,matriuHidato));
		if (!partidaEnCurs.esSolucionable()) {
			partidaEnCurs = null;
			return false;
		}
		else return true;
	}

	public int[][] solucionarHidatoPartida() {
		return partidaEnCurs.getSolucio();
	}

	public boolean ferMoviment(int i, int j, int value) {
		if (partidaEnCurs.ferJugada(i, j, value)) return true;
		else return false;
	}

	public int[][] getHidatoJugant() {
		return partidaEnCurs.getHidato();
	}

	public boolean enPartida() {
		return (partidaEnCurs != null);
	}

}
