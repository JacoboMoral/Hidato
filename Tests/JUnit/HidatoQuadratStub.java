package JUnit;

import main.domain.com.hidato.Hidato;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

//realment no es un stub, sino una copia de la classe original amb algunes linies menys que eren innecessaries per aquest test
public class HidatoQuadratStub extends Hidato{
	public HidatoQuadratStub(TipusAdjacencia tipusAdjacencia, int[][] matrix) {
		super(tipusAdjacencia, matrix);
	}
	
	public HidatoQuadratStub(TipusAdjacencia tipusAdjacencia) {
		super(tipusAdjacencia);
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
