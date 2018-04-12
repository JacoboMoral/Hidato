package main.domain.com.hidato;

public class ControladorDomini {
	Partida partidaEnCurs;
	

	public boolean jugarHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matriuHidato) {
		Algoritmes al = new Algoritmes(matriuHidato);
		if (!al.solucionar()) return false;
		if (tipusCella == TipusCella.QUADRAT) partidaEnCurs = new Partida (new HidatoQuadrat(tipusAdjacencia,matriuHidato));
		else if (tipusCella == TipusCella.TRIANGLE) partidaEnCurs = new Partida (new HidatoQuadrat(tipusAdjacencia,matriuHidato));
		else partidaEnCurs = new Partida (new HidatoQuadrat(tipusAdjacencia,matriuHidato));
		return partidaEnCurs.solucionable();
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
