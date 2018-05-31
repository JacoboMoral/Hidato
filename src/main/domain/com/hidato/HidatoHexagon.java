package main.domain.com.hidato;

import java.util.Vector;

public class HidatoHexagon extends Hidato {

	public HidatoHexagon(int[][] matrix) {
		super(TipusAdjacencia.COSTATS, matrix);
		al = new Algorismes(this);
		dificultat = al.obtenirDificultat();
	}
	
	public HidatoHexagon() {
		super(TipusAdjacencia.COSTATS);
		al = new Algorismes(this);
	}
	
	public HidatoHexagon(int[][] matriuOriginal, int[][] matriuHidato, Vector<Integer> nombresEscrits, Vector<Integer> nombresDonats) {
		super(TipusAdjacencia.COSTATS, matriuHidato, matriuOriginal, nombresEscrits, nombresDonats);
		al = new Algorismes(this);
		dificultat = al.obtenirDificultat();
	}


	@Override
	public TipusCella getTipusCella() {
		return TipusCella.HEXAGON;
	}


    @Override
    public boolean posicioValida(int i, int j, int r, int c) { //posicio a verificar: (r+i,c+j) des de (r, c)
        return ((Math.abs(i + j) == 1) || ((j == 1) && (r % 2 != 0)) || ((j == -1) && (r % 2 == 0)));
    }
}
