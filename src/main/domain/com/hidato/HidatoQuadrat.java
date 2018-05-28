package main.domain.com.hidato;

import java.io.Serializable;

public class HidatoQuadrat extends Hidato implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5013823874989881128L;

	public HidatoQuadrat(TipusAdjacencia tipusAdjacencia, int[][] matrix) {
		super(tipusAdjacencia, matrix);
		al = new Algorismes(this);
		dificultat = al.obtenirDificultat();
	}
	
	public HidatoQuadrat(TipusAdjacencia tipusAdjacencia) {
		super(tipusAdjacencia);
		al = new Algorismes(this);
	}
	
	@Override
	public TipusCella getTipusCella() {
		return TipusCella.QUADRAT;
	}
	
	@Override
	public boolean posicioValida(int i, int j, int r, int c) {
		if (tipusAdjacencia == TipusAdjacencia.COSTATS) return (Math.abs(i + j) == 1);
		return ((Math.abs(i) < 2) && Math.abs(j) < 2);
	}
}
