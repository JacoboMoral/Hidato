package tests.drivers.Hidato;

import main.domain.com.hidato.Algorismes;
import main.domain.com.hidato.Hidato;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class HidatoStub extends Hidato{

    //els seguents son protected per tal que el driver pugui accedir (ja que esta fet com una subclasse)    
	
    public HidatoStub(TipusAdjacencia tipusAdjacencia, int[][] matrix) {
		super(tipusAdjacencia, matrix);
		al = new AlgorismesStub(this);
		dificultat = al.obtenirDificultat();
	}
	
	public HidatoStub(TipusAdjacencia tipusAdjacencia) {
		super(tipusAdjacencia);
		al = new AlgorismesStub(this);
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