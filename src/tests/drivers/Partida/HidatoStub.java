package tests.drivers.Partida;

import java.util.Vector;

import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.Hidato;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;


//stub necessari per DriverPartida
public class HidatoStub extends Hidato{

	protected TipusAdjacencia tipusAdjacencia;
	
	private int[][] matriuHidato = new int[][] {
		{1,-1,-1},
		{2,11,-1},
		{3,0,0},
		{0,-1,8},
		{5,0,0}
	};
	
	
	private int[][] matriuOriginal = new int[][] {
		{1,-1,-1},
		{0,11,-1},
		{0,0,0},
		{0,-1,8},
		{5,0,0}
	};
	
    public HidatoStub(TipusAdjacencia tipusAdjacencia) {
		super(tipusAdjacencia);
	}
    
    public boolean autogenerar(int forats, int tamanyi, int tamanyj) {
		return true;
	}

	private boolean estaDintreElsLimits(int i, int j) {
		return true;
	}
    
    public boolean moviment(int i, int j, int value) {
    	return true;
    }
    
    public Vector<Integer> getNombresPerDefecte(){
    	Vector<Integer> v = new Vector<Integer>(4);
    	v.add(1);
    	v.add(2);
    	v.add(3);
    	v.add(4);
    	return v;
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
		return matriuHidato;
	}
	
	public int[][] getMatriuOriginal(){
		return matriuOriginal;
	}
	
	public void resetMatriu() {
		matriuHidato = matriuOriginal;
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

	//aquests dos mètodes es provaran a les subclasses corresponents
	@Override
	public TipusCella getTipusCella() {
		return null;
	}

	@Override
	public boolean posicioValida(int i, int j, int r, int c) {
		return false;
	}
}
