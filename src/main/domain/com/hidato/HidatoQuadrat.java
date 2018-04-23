package main.domain.com.hidato;

public class HidatoQuadrat extends Hidato {
	
	public HidatoQuadrat(TipusAdjacencia tipusAdjacencia, int[][] matrix) {
		super(tipusAdjacencia, matrix);
		al = new Algoritmes(this);
	}
	
	public HidatoQuadrat(TipusAdjacencia tipusAdjacencia) {
		super(tipusAdjacencia);
		al = new Algoritmes(this);
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
