package main.domain.com.hidato;

import java.util.Vector;

public abstract class Hidato {

    protected TipusAdjacencia tipusAdjacencia;
    private Dificultat dificultat;
        
    private int[][] matriuHidato;
    private int[][] matriuOriginal;
    private int[][] matriuSolucio;
    
    private Boolean solucionable;
    private Vector<Integer> nombresEscrits;
    private Vector<Integer> nombresDonats;
    protected Algoritmes al;
    

    public Hidato(TipusAdjacencia tipusAdjacencia, int[][] matriu){
		matriuHidato = matriuOriginal = matriu;
		this.tipusAdjacencia = tipusAdjacencia;
    }
    
    //NOMES EN CAS de moment
    //
    private boolean comprovarMoviment(int i, int j, int value) {
    	
    	if (estaRepetit(value)) return false;
    	boolean anterior = nombresEscrits.contains(value-1);
    	boolean posterior = nombresEscrits.contains(value+1);
    	boolean trobatAnterior = false;
    	boolean trobatPosterior = false;
    	for(int ii = i - 1; ii < i + 2; ++ii) {
    		for(int jj = j - 1; jj < j + 2; ++jj) {
    			if(estaDintreElsLimits(ii, jj)) {
    				if ((matriuHidato[ii][jj] - value) == 1 ) {
    					trobatPosterior = true;
    				}
    				if ((value - matriuHidato[ii][jj]) == 1 ) {
    					trobatAnterior = true;
    				}
    			}
    		}
    	}
	    	if (posterior && !trobatPosterior) return false; 		//si hi ha un posterior escrit pero no esta al voltant
	    	if (anterior && !trobatAnterior) return false; 		//si hi ha un anterior escrit pero no esta al voltant
	    	else if (!anterior || !posterior) return false; 		//si no hi ha escrits ni el anterior ni el posterior
	    	return true; 										//else
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