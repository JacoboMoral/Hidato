package tests.drivers.Partida;

import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class HidatoQuadratStub extends HidatoStub {

	public HidatoQuadratStub(TipusAdjacencia tipusAdjacencia) {
		super(tipusAdjacencia);
		// TODO Auto-generated constructor stub
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
