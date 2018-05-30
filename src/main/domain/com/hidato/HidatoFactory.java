package main.domain.com.hidato;

import java.util.Vector;

public class HidatoFactory {
	
	public static Hidato createHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matriu) {
		if (tipusCella == null) return null;
		if (tipusCella == TipusCella.QUADRAT) return new HidatoQuadrat(tipusAdjacencia, matriu);
		if (tipusCella == TipusCella.TRIANGLE) return new HidatoTriangle(matriu);
		return new HidatoHexagon(matriu);
	}
	
	public static Hidato createHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia) {
		if (tipusCella == null) return null;
		if (tipusCella == TipusCella.QUADRAT) return new HidatoQuadrat(tipusAdjacencia);
		if (tipusCella == TipusCella.TRIANGLE) return new HidatoTriangle();
		return new HidatoHexagon();
	}
	
	public static Hidato carregarHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matriuOriginal, int[][] matriuHidato, Vector<Integer> nombresDonats, Vector<Integer> nombresEscrits) {
		if (tipusCella == null) return null;
		if (tipusCella == TipusCella.QUADRAT) return new HidatoQuadrat(tipusAdjacencia, matriuOriginal, matriuHidato, nombresEscrits, nombresDonats);
		if (tipusCella == TipusCella.TRIANGLE) return new HidatoTriangle(matriuOriginal, matriuHidato, nombresEscrits, nombresDonats);
		return new HidatoHexagon(matriuOriginal, matriuHidato, nombresEscrits, nombresDonats);
	}
		
}
