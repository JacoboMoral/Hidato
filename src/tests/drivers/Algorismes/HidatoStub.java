package tests.drivers.Algorismes;

import java.util.Vector;
import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.Hidato;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;


//stub necessari per DriverAlgorismes
public class HidatoStub extends Hidato{

	protected TipusAdjacencia tipusAdjacencia;
	
	private int[][] matriuOriginal;
	
    public HidatoStub(TipusAdjacencia tipusAdjacencia, int[][] matriu) {
		super(tipusAdjacencia);
		matriuOriginal = matriu;
	}
    
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
    	return new Vector<Integer>(0);
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
		return matriuOriginal;
	}
	
	public int[][] getMatriuOriginal(){
		return matriuOriginal;
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

	//aquests dos mètodes es provaran a les subclasses corresponents
	@Override
	public TipusCella getTipusCella() {
		return null;
	}

	//nomes valid per aquest stub i per hidatos quadrats amb adjacencia per costats
	@Override
	public boolean posicioValida(int i, int j, int r, int c) {
		return (Math.abs(i + j) == 1);
	}
}
