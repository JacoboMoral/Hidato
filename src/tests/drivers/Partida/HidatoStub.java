package tests.drivers.Partida;

import java.util.Vector;

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
		return new int[][] {
			{1,-1,-1},
			{2,11,-1},
			{3,0,0},
			{0,-1,8},
			{5,0,0}
		};
	}
	
	public int[][] getMatriuOriginal(){
		return new int[][] {
			{1,-1,-1},
			{0,11,-1},
			{0,0,0},
			{0,-1,8},
			{5,0,0}
		};
	}
	
	public void resetMatriu() {
	}
	
	public int[][] getSolucio(){
		return new int[][] {
			{1,-1,-1},
			{2,11,-1},
			{3,10,9},
			{4,-1,8},
			{5,6,7}
		};
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
