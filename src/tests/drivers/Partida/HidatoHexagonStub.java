package tests.drivers.Partida;

import main.domain.com.hidato.Hidato;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;
import tests.drivers.Algorismes.AlgorismesStub;

public class HidatoHexagonStub extends Hidato{
	public HidatoHexagonStub(int[][] matrix) {
		super(TipusAdjacencia.COSTATS, matrix);
		al = new AlgorismesStub(this);
	}
	
	public HidatoHexagonStub() {
		super(TipusAdjacencia.COSTATS);
		al = new AlgorismesStub(this);
	}
	
	public TipusCella getTipusCella() {
		return TipusCella.HEXAGON;
	}

	@Override
	public boolean posicioValida(int i, int j, int r, int c) {
		return ((Math.abs(i + j) == 1) || ((j == 1) && (r%2 != 0)) || ((j == -1) && (r%2 == 0)));
	}
}
