package tests.drivers.Algorismes;

import java.util.Vector;

import main.domain.com.hidato.Algorismes;
import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.Hidato;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;


//stub necessari per DriveAlgorismes
public abstract class HidatoStub extends Hidato{

	protected TipusAdjacencia tipusAdjacencia;
	
    public HidatoStub(TipusAdjacencia tipusAdjacencia) {
		super(tipusAdjacencia);
	}
    
    public boolean autogenerar(int forats, int tamanyi, int tamanyj) {
		return true;
	}
    
    private boolean comprovarMoviment(int i, int j, int value) {
	    	return true;
    }

	private boolean estaRepetit(int value) {
		return true;
	}

	private boolean estaDintreElsLimits(int i, int j) {
		return true;
	}
    
    public boolean moviment(int i, int j, int value) {
    	return true;
    }
    
    public Vector<Integer> getNombresPerDefecte(){
    	return new Vector<Integer>();
    }
    
    public int getNombreFiles(){
        return 0;
    }

    public int getNombreColumnes(){
        return 0;

    }

	public Dificultat getDificultat() {
		return Dificultat.FACIL;
	}
	
	public int[][] getMatriu(){
		return new int[][] {};
	}
	
	public int[][] getMatriuOriginal(){
		return new int[][] {};
	}
	
	public void resetMatriu() {
	}
	
	public int[][] getSolucio(){
		return new int[][] {};

	}
	
	public boolean teSolucio() {
		return true;
	}

	public TipusAdjacencia getTipusAdjacencia(){
		return TipusAdjacencia.COSTATS;
	}
	
	public abstract TipusCella getTipusCella();

	public abstract boolean posicioValida(int i, int j, int r, int c);
	
	
	
}
