package main.domain.com.hidato;

public class HidatoTriangle extends Hidato {

	public HidatoTriangle(TipusAdjacencia tipusAdjacencia, int[][] matriu) {
		super(tipusAdjacencia, matriu);
		al = new Algoritmes(this);
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
