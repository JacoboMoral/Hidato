package tests.drivers.Algorismes;

import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class HidatoQuadratStub extends HidatoStub {
	public HidatoQuadratStub(TipusAdjacencia tipusAdjacencia, int[][] matrix) {
		super(tipusAdjacencia, matrix);
		al = new AlgorismesStub(this);
	}
	
	public HidatoQuadratStub(TipusAdjacencia tipusAdjacencia) {
		super(tipusAdjacencia);
		al = new AlgorismesStub(this);
	}

	public TipusCella getTipusCella() {
		return TipusCella.QUADRAT;
	}
	
	@Override
	public boolean posicioValida(int i, int j, int r, int c) {
		if (tipusAdjacencia == TipusAdjacencia.COSTATS) return (Math.abs(i + j) == 1);
		return true;
	}
}
