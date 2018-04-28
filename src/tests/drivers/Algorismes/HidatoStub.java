package tests.drivers.Algorismes;

import java.util.Vector;

import main.domain.com.hidato.Algorismes;
import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public abstract class HidatoStub {

	protected TipusAdjacencia tipusAdjacencia;
    private Dificultat dificultat;
        
    private int[][] matriuHidato;
    private int[][] matriuOriginal;
    private int[][] matriuSolucio;
    
    private Boolean solucionable;
    private Vector<Integer> nombresEscrits;
    private Vector<Integer> nombresDonats;
    protected AlgorismesStub al;
	
	public HidatoStub(TipusAdjacencia tipusAdjacencia, int[][] matriu){
		matriuHidato = matriuOriginal = matriu;
		this.tipusAdjacencia = tipusAdjacencia;
    }
    
    public HidatoStub(TipusAdjacencia tipusAdjacencia) {
    	this.tipusAdjacencia = tipusAdjacencia;
    }
    
    public boolean autogenerar(int forats, int tamanyi, int tamanyj) {
		matriuHidato = al.generarHidato(forats, tamanyi, tamanyj);
		if (matriuHidato != null){
			matriuOriginal = matriuHidato;
			al.modificarHidato(this);
			return true;
		}
		matriuHidato = null;
		return false;
	}
    
    private boolean comprovarMoviment(int i, int j, int value) {
	    	return true;
    }

	private boolean estaRepetit(int value) {
		return nombresEscrits.contains(value);
	}

	private boolean estaDintreElsLimits(int i, int j) {
		return i >= 0 && i < matriuHidato.length && j >= 0 && j < matriuHidato[0].length;
	}
    
    public boolean moviment(int i, int j, int value) {
    	if(comprovarMoviment(i, j, value)) {
    		matriuHidato[i][j] = value;
    		nombresEscrits.add(value);
    		return true;
    	} 
    	else return false;
    }
    
    public Vector<Integer> getNombresPerDefecte(){
    	return nombresDonats;
    }
    
    public int getNombreFiles(){
        return matriuHidato.length;
    }

    public int getNombreColumnes(){
        return matriuHidato[0].length;

    }

	public Dificultat getDificultat() {
		return dificultat;
	}
	
	
	public int[][] getMatriu(){
		return matriuHidato;
	}
	
	public int[][] getMatriuOriginal(){
		return matriuOriginal;
	}
	
	public void resetMatriu() {
		matriuHidato = matriuOriginal;
	}

	
	public int[][] getSolucio(){
		if (teSolucio()) return matriuSolucio;
		return null;
	}
	
	public boolean teSolucio() {
		if (solucionable == null){
			solucionable = al.solucionar();
			nombresDonats = al.getGiven();
			nombresEscrits = al.getGiven();
			matriuSolucio = al.getMatriuSolucio();
		}
		return solucionable;
	}
	

	public TipusAdjacencia getTipusAdjacencia(){
		return this.tipusAdjacencia;
	}
	
	public abstract TipusCella getTipusCella();

	public abstract boolean posicioValida(int i, int j, int r, int c);
	
	
	
}
