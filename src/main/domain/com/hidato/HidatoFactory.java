package main.domain.com.hidato;

public class HidatoFactory {
	
	public static Hidato createHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matrix) {
		if (tipusCella == null) return null;
		if (tipusCella == TipusCella.QUADRAT) return new HidatoQuadrat(tipusAdjacencia, matrix);
		if (tipusCella == TipusCella.TRIANGLE) return new HidatoTriangle(tipusAdjacencia, matrix);
		return new HidatoHexagon(matrix);
	}
}
