package tests.drivers.Partida;

import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class HidatoTriangleStub extends HidatoStub{
	
	public HidatoTriangleStub(TipusAdjacencia tipusAdjacencia) {
		super(tipusAdjacencia);
		// TODO Auto-generated constructor stub
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
