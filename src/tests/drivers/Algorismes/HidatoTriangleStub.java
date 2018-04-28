package tests.drivers.Algorismes;

import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class HidatoTriangleStub extends HidatoStub{
	public HidatoTriangleStub(TipusAdjacencia tipusAdjacencia, int[][] matriu) {
		super(tipusAdjacencia, matriu);
		al = new AlgorismesStub(this);
	}
	
	public HidatoTriangleStub(TipusAdjacencia tipusAdjacencia) {
		super(tipusAdjacencia);
		al = new AlgorismesStub(this);
	}

	public TipusCella getTipusCella() {
		return TipusCella.TRIANGLE;
	}
	
	public boolean posicioValida(int i, int j, int r, int c) {
		if (tipusAdjacencia == TipusAdjacencia.COSTATS) return ( ((Math.abs(j) == 1) && i == 0) || ((i == -1) && (j == 0) && diferentParitat(r,c)) || ((i == 1) && (j == 0) && !diferentParitat(r,c)) );
		return true;
	}
	
	private boolean diferentParitat(int i, int j) {
		return (i%2 != j%2);
	}
}
