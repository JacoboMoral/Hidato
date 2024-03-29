package JUnit;

import main.domain.com.hidato.Hidato;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

//realment no es un stub, sino una copia de la classe original amb algunes linies menys que eren innecessaries per aquest test
public class HidatoHexagonStub extends Hidato{
	public HidatoHexagonStub(int[][] matrix) {
		super(TipusAdjacencia.COSTATS, matrix);
	}
	
	public HidatoHexagonStub() {
		super(TipusAdjacencia.COSTATS);
	}
	
	public TipusCella getTipusCella() {
		return TipusCella.HEXAGON;
	}

	@Override
	public boolean posicioValida(int i, int j, int r, int c) {
		return ((Math.abs(i + j) == 1) || ((j == 1) && (r%2 != 0)) || ((j == -1) && (r%2 == 0)));
	}
}
