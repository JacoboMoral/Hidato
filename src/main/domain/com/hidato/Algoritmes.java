package main.domain.com.hidato;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;


public class Algoritmes {

	private int[][] matriuSolucio;
	Hidato hidato;

	Vector<Integer> given = new Vector<Integer>();

	public Algoritmes(Hidato hidato) {
		this.matriuSolucio = hidato.getMatriu();
		this.hidato = hidato;
	}

	public boolean solucionar() {
		
		int row1 = -1; 
		int column1 = -1; //fila i columna on es troba el numero 1
		int casellesNumeriques = 0;
				
		int[][] matriu = new int[matriuSolucio.length][matriuSolucio[0].length];
		
		
		//fem una copia de matriu solucio mentre cerquem el valor de row1 i column1
		for (int i = 0; i < matriuSolucio.length; ++i) {
			for (int j = 0; j < matriuSolucio[0].length; ++j) {
				matriu[i][j] = matriuSolucio[i][j];
				if (matriu[i][j] == 1) {
					row1 = i;
					column1 = j;
				}
				if (matriu[i][j] > 0) { //valor igual a un numero
					given.addElement(matriu[i][j]);
				}
				if (matriu[i][j] > -1) {
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
		
		return solucionador(row1, column1, 1, 0, matriu);
	}

	private boolean solucionador(int r, int c, int n, int next, int[][] matriuSolucio) {
		if (n > given.get(given.size() - 1)) return true;

		if (matriuSolucio[r][c] != 0 && matriuSolucio[r][c] != n) return false;

		if (matriuSolucio[r][c] == 0 && given.get(next) == n) return false;

		int back = matriuSolucio[r][c];
		if (back == n) next++;

		matriuSolucio[r][c] = n;

			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (hidato.posicioValida(i, j, r, c) && dinsLimits(r+i, c+j, matriuSolucio.length, matriuSolucio[0].length)) {
						if (solucionador(r + i, c + j, n + 1, next, matriuSolucio)) {
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
		matriuSolucio = matriu;
		System.out.println("holaaaa");
		HidatoIO.writeHidatoMatrixToOutput(matriuSolucio);
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
	
	
	private static void emplenarForats(int celesBuides, int[][] matriu) {
		int tamany = matriu.length;
		int forats = tamany*tamany - celesBuides;
		Random rand = new Random();
		for (int i = 0; i < forats; ++i) {
			int posi = rand.nextInt(tamany);
			int posj = rand.nextInt(tamany);
			if (matriu[posi][posj] == -1) --i;
			else matriu[posi][posj] = -1;
		}
	}
	
	private static boolean generarComplet(int r, int c, int celesBuides, int n, ArrayList<Integer> escrits, int[][] matriu) {
		if (n > celesBuides) return true;

		if (matriu[r][c] != 0) return false;
		
		if (escrits.contains(n)) return false;
		
		matriu[r][c] = n;
		escrits.add(n);
		
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				
				if (posicioValida(i, j, r, c) && dinsLimits(r+i, c+j, matriu.length, matriu[0].length)) {
					if (generarComplet(r + i, c + j, celesBuides, n + 1, escrits, matriu)) {
						return true;
					}
				}
			}
		}
		escrits.remove(escrits.size()-1);
		matriu[r][c] = 0;
		return false;
	}
	
	private static boolean dinsLimits(int i, int j, int tamanyi, int tamanyj) {
		if (i < 0) return false;
		if (j < 0) return false;
		if (i >= tamanyi) return false;
		if (j >= tamanyj) return false;
		return true;
	}

	private static boolean posicioValida(int i, int j, int r, int c) {
		return true;
	}

	public static int[][] generarHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int celesBuides, int tamany) {
		int[][] matriu = new int[tamany][tamany]; //per defecte esta emplenada amb 0
		emplenarForats(celesBuides, matriu);
		
		
		if (generarMatriuCompleta(celesBuides, matriu)) {
			extreureNombres(celesBuides, matriu);
			return matriu;
		}
		else return null;
	}


	private static boolean self(int ii, int jj) {
		
		return (ii == 0 && jj == 0);
	}

	private static void extreureNombres(int celesBuides, int[][] matriu) {
		Random rand = new Random();
		for (int i = 0; i < matriu.length; ++i) {
			for (int j = 0; j < matriu.length; ++j) {
				if (matriu[i][j] != 1 && matriu[i][j] != celesBuides && matriu[i][j] > -1) { //primer i ultim numero han d'estar, i tampoc s'han de treure els forats
					 int treure = rand.nextInt(4); //         1/4 possibilitat de treure un numero = hi han ficats 1/4 dels numeros
					 if (treure != 0) matriu[i][j] = 0;
				}
			}
		}
	}

	private static boolean generarMatriuCompleta(int celesBuides, int[][] matriu) {
		int tamany = matriu.length;
		//generem [tamany] nombres posicions aleatoris per començar a emplenar la matriu autogenerada
		ArrayList<Integer> initialNumberi = new ArrayList<>(tamany);
		ArrayList<Integer> initialNumberj = new ArrayList<>(tamany);
		for (int i = 0; i < tamany; i++){ //to generate from 0-10 inclusive. 
		                               //For 0-9 inclusive, remove the = on the <=
			initialNumberi.add(i);
			initialNumberj.add(i);
		}
		Collections.shuffle(initialNumberi);
		Collections.shuffle(initialNumberj);
		
		ArrayList<Integer> escrits;
		for (int i = 0; i < tamany; ++i) {
			for (int j = 0; j < tamany; ++j) {
				escrits = new ArrayList<>();
				if (generarComplet(initialNumberi.get(i), initialNumberj.get(j), celesBuides, 1, escrits, matriu)) return true; //intentem generar una matriu amb l'1 a totes les posicions possibles
			}
		}
		return false;
	}
}