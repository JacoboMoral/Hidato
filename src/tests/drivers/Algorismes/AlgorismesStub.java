package tests.drivers.Algorismes;

import java.util.Vector;

import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.Hidato;

//stub necessari per HidatoStub
public class AlgorismesStub{
	
	Hidato hidato;
	
	private int[][] matriuSolucio = new int[][] {
		{1,-1,-1},
		{2,11,-1},
		{3,10,9},
		{4,-1,8},
		{5,6,7}
	};
	
	private int[][] matriuGenerada = new int[][] {
		{1,-1,-1},
		{0,11,-1},
		{0,0,0},
		{0,-1,8},
		{5,0,0}
	};
	
	public AlgorismesStub(Hidato hidato) {
		this.hidato = hidato;
	}

	public int[][] generarHidato(int forats, int tamanyi, int tamanyj) {
		return matriuGenerada;
	}
	
	public int[][] generarHidato(Dificultat dificultat){
		return matriuGenerada;
	}
	
	public void modificarHidato(Hidato hidato) {
		
	}

	public boolean solucionar() {
		// TODO Auto-generated method stub
		return false;
	}

	public Vector<Integer> getGiven() {
		// TODO Auto-generated method stub
		return null;
	}

	public int[][] getMatriuSolucio() {
		// TODO Auto-generated method stub
		return null;
	}

}
