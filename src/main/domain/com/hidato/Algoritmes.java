package main.domain.com.hidato;
import java.util.Collections;
import java.util.Vector;


public class Algoritmes {

	private int[][] matriuSolucio;
	private int[][] matriuOriginal;
	Hidato hidato;

	Vector<Integer> given = new Vector<Integer>();

	public Algoritmes(Hidato hidato) {
		this.matriuOriginal = hidato.getMatriu();
		this.hidato = hidato;
	}

	public boolean solucionar() {
		
		int row1 = -1; 
		int column1 = -1; //fila i columna on es troba el numero 1
		int [][] matriu = new int[matriuOriginal.length+2][matriuOriginal[0].length+2];
		int casellesNumeriques = 0;
				
		for (int i = 0; i < matriuOriginal.length; ++i) {
			for (int j = 0; j < matriuOriginal[0].length; ++j) {
				matriu[i+1][j+1] = matriuOriginal[i][j];
				if (matriu[i+1][j+1] == 1) {
					row1 = i+1;
					column1 = j+1;
				}
				if (matriu[i+1][j+1] > 0) { //valor igual a un numero
					given.addElement(matriu[i+1][j+1]);
				}
				if (matriu[i+1][j+1] > -1) {
					casellesNumeriques++;
				}
			}
		}

		Collections.sort(given);

		if (given.get(0) != 1) {
			return false; //comprova que sempre ens donin el primer numero (i.e. 1)		
		}
		if (given.get(given.size()-1) != casellesNumeriques) {
			return false; //comprova que sempre ens donin el ultimo numero
		}

		
		for (int i=0; i<matriu.length;  ++i){
			matriu[i][0] = -1;
			matriu[i][matriu[0].length-1] = -1;
		}
		
		for (int i = 0; i < matriu[0].length; ++i) {
			matriu[0][i] = -1;
			matriu[matriu.length-1][i] = -1;
		}
		
		return solucionador(row1, column1, 1, 0, given, matriu);
	}

	private boolean solucionador(int r, int c, int n, int next, Vector<Integer> given, int[][] matriuSolucio) {
		if (n > given.get(given.size() - 1)) return true;

		if (matriuSolucio[r][c] != 0 && matriuSolucio[r][c] != n) return false;

		if (matriuSolucio[r][c] == 0 && given.get(next) == n) return false;

		int back = matriuSolucio[r][c];
		if (back == n) next++;

		matriuSolucio[r][c] = n;

			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (hidato.posicioValida(i, j, r, c)) {
						if (solucionador(r + i, c + j, n + 1, next, given, matriuSolucio)) {
							if(n == 1) tractarMatriuSolucio(matriuSolucio);
							return true;
						}
					}
				}
			}

		matriuSolucio[r][c] = back;
		return false;
	}

	private void tractarMatriuSolucio(int[][] matriu) {
		matriuSolucio = new int[matriu.length-2][matriu[0].length-2];
		for (int i = 1; i < matriu.length-1; ++i) {
			for (int j = 1; j < matriu[0].length-1; ++j) {
				matriuSolucio[i-1][j-1] = matriu[i][j];
			}
		}
	}

	public int[][] getMatriuSolucio(){		
		return this.matriuSolucio;
	}

	public Dificultat obtenirDificultat() {
		return null;
	}

	public Vector<Integer> getGiven() {
		return given;
	}
	
	public static int[][] generarHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int celesBuides, int forats) {
		return null;
	}
}