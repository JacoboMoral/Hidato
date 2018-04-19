package main.domain.com.hidato;

public class HidatoFactory {
	
	public static Hidato createHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matriu) {
		if (tipusCella == null) return null;
		if (tipusCella == TipusCella.QUADRAT) return new HidatoQuadrat(tipusAdjacencia, matriu);
		if (tipusCella == TipusCella.TRIANGLE) return new HidatoTriangle(tipusAdjacencia, matriu);
		return new HidatoHexagon(matriu);
	}
}
