package tests.drivers.Algorismes;

import java.util.Vector;

import main.domain.com.hidato.Algorismes;
import main.domain.com.hidato.Hidato;
import tests.drivers.Partida.HidatoStub;

//stub necessari per HidatoStub
public class AlgorismesStub extends Algorismes{

	public AlgorismesStub(Hidato hidato) {
		super(hidato);
	}

	public int[][] generarHidato(int forats, int tamanyi, int tamanyj) {
		// TODO Auto-generated method stub
		return null;
	}

	public void modificarHidato(HidatoStub hidatoStub) {
		// TODO Auto-generated method stub
		
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
