package JUnit;

import main.domain.com.hidato.Hidato;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

//realment no es un stub, sino una copia de la classe original amb algunes linies menys que eren innecessaries per aquest test
public class HidatoTriangleStub extends Hidato{
	public HidatoTriangleStub(int[][] matriu) {
		super(TipusAdjacencia.COSTATS, matriu);
	}
	
	public HidatoTriangleStub() {
		super(TipusAdjacencia.COSTATS);
	}

	public TipusCella getTipusCella() {
		return TipusCella.TRIANGLE;
	}
	
	public boolean posicioValida(int i, int j, int r, int c) {
		return ( ((Math.abs(j) == 1) && i == 0) || ((i == -1) && (j == 0) && diferentParitat(r,c)) || ((i == 1) && (j == 0) && !diferentParitat(r,c)) );
	}
	
	private boolean diferentParitat(int i, int j) {
		return (i%2 != j%2);
	}
}
