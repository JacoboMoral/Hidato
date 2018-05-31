package main.domain.com.hidato;

import java.util.Vector;

public class HidatoQuadrat extends Hidato {
	
	public HidatoQuadrat(TipusAdjacencia tipusAdjacencia, int[][] matriu) {
		super(tipusAdjacencia, matriu);

		al = new Algorismes(this);
		dificultat = al.obtenirDificultat();
		System.out.println(dificultat);
	}
	
	public HidatoQuadrat(TipusAdjacencia tipusAdjacencia) {
		super(tipusAdjacencia);
		al = new Algorismes(this);
	}
	
	public HidatoQuadrat(TipusAdjacencia tipusAdjacencia, int[][] matriuOriginal, int[][] matriuHidato, Vector<Integer> nombresEscrits, Vector<Integer> nombresDonats) {
		super(tipusAdjacencia, matriuHidato, matriuOriginal, nombresEscrits, nombresDonats);
		al = new Algorismes(this);
		dificultat = al.obtenirDificultat();
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
