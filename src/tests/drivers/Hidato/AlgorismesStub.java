package tests.drivers.Hidato;

import java.util.Vector;

import main.domain.com.hidato.Algorismes;
import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.Hidato;

//stub necessari per HidatoStub
public class AlgorismesStub extends Algorismes{

	public AlgorismesStub(Hidato hidato) {
		super(hidato);
	}

	public int[][] generarHidato(int forats, int tamanyi, int tamanyj) {
		// TODO Auto-generated method stub
		return new int[][] {
			{1,-1,-1},
			{2,11,-1},
			{3,0,0},
			{4,-1,8},
			{5,6,0}
		};
	}

	public void modificarHidato(Hidato hidato) {
		// TODO Auto-generated method stub
		
	}

	public boolean solucionar() {
		// TODO Auto-generated method stub
		return true;
	}

	public Vector<Integer> getGiven() {
		Vector<Integer> v = new Vector<Integer>(4);
    	v.add(1);
    	v.add(5);
    	v.add(8);
    	v.add(11);
    	return v;
	}

	public int[][] getMatriuSolucio() {
		return new int[][] {
			{1,-1,-1},
			{2,11,-1},
			{3,10,9},
			{4,-1,8},
			{5,6,7}
		};
	}
	
	
	public Dificultat obtenirDificultat() {
		return Dificultat.FACIL;
	}

}
