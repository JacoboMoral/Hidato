package main.domain.com.hidato;

import java.util.Vector;

public class Hidato {

    private TipusCella tipusCella;
    private TipusAdjacencia tipusAdjacencia;
    private Dificultat dificultat;
    
    private int nombreFiles;
    private int nombreColumnes;
    
    private int[][] matriuHidato;
    private int[][] matriuOriginal;
    private int[][] matriuSolucio;
    
    private Vector<Integer> nombresEscrits;
    private Algoritmes al;
    

    public Hidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matriu) throws Exception{
		al = new Algoritmes(matriu);
		if (!al.solucionar()) throw new Exception("El hidato escollit no es pot solucionar");
		nombresEscrits = al.getGiven();
		this.tipusAdjacencia = tipusAdjacencia;
		this.tipusCella = tipusCella;
		nombreFiles = matriu.length;
		nombreColumnes = matriu[0].length;
		matriuHidato = matriuOriginal = matriu;
		matriuSolucio = al.getMatriuSolucio();
		this.dificultat = al.obtenirDificultat();
    		
    }
    
    //NOMES EN CAS de moment
    private boolean comprovarMoviment(int i, int j, int value) {
    	
    	if (estaRepetit(value)) return false;
    	
    	for(int ii = i - 1; ii < i + 2; ++ii) {
    		for(int jj = j - 1; jj < j + 2; ++jj) {
    			if(estaDintreElsLimits(ii, jj)) {
    				if (Math.abs(matriuHidato[ii][jj] - value) == 1 ) {
    					return true;
    				}
    			}
    		}
    	}
    	return false;
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
    
    public int getNombreFiles(){
        return nombreFiles;

    }

    public int getNombreColumnes(){
        return nombreColumnes;

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
	
	public void matriuOriginal() {
		matriuHidato = matriuOriginal;
	}

	
	public int[][] getSolucio(){
		return matriuSolucio;
	}


}