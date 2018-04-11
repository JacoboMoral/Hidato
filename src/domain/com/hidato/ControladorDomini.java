package com.hidato;

public class ControladorDomini {
	Partida partidaEnCurs;
	

	public void jugarHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matriuHidato) throws Exception {
		partidaEnCurs = new Partida (new Hidato(tipusCella,tipusAdjacencia,matriuHidato));
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
	
}
