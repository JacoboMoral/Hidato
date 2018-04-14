package main.domain.com.hidato;

public class HidatoHexagon extends Hidato {

	public HidatoHexagon(int[][] matrix) {
		super(TipusAdjacencia.COSTATS, matrix);
		al = new Algoritmes(this);
	}
	
	public TipusCella getTipusCella() {
		return TipusCella.HEXAGON;
	}

	public boolean posicioValida(int i, int j, int r, int c) {
		return ((Math.abs(i + j) == 1) || ((j == 1) && (r%2 == 0)) || ((j == -1) && (r%2 != 0)));
	}
}
