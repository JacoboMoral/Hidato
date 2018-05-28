package main.domain.com.hidato;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;

public class Algorismes{
	
	private int[][] matriuSolucio;
	boolean solucionat = false;
	private Hidato hidato;
	private Vector<Integer> given = new Vector<Integer>();
	private Random randomSeed;


	public Algorismes(Hidato hidato) {
		this.matriuSolucio = hidato.getMatriu();
		this.hidato = hidato;
	}

	public void modificarHidato(Hidato hidato) {
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
		solucionat = true;

	}

	public int[][] getMatriuSolucio(){
		if (!solucionat) {
			if (solucionar()) return matriuSolucio;
			else return null;
		}
		return matriuSolucio;
	}

	//es igual que encara no s'hagi solucionat --> per tests
	public int[][] getMatriuSolucioForce(){
		return this.matriuSolucio;
	}

	public Dificultat obtenirDificultat() {
		int tamany = matriuSolucio.length * matriuSolucio[0].length;
		if (tamany <= 18) return Dificultat.FACIL;
		if (tamany < 50) return Dificultat.MIG;
		return Dificultat.DIFICIL;
	}

	public Vector<Integer> getGiven() {
		if (!solucionat) {
			this.solucionar();
		}
		return given;
	}

	private boolean generarComplet(int r, int c, int celesBuides, int n, ArrayList<Integer> escrits, int[][] matriu, int seed) {
		if (n > celesBuides) return true;

		if (matriu[r][c] != 0) return false;

		if (escrits.contains(n)) return false;

		matriu[r][c] = n;
		escrits.add(n);

		if (seed == 0) {
			for (int i = -1; i < 2; i++) {
				for (int j = -1; j < 2; j++) {
					if (hidato.posicioValida(i, j, r, c) && dinsLimits(r+i, c+j, matriu.length, matriu[0].length)) {
						if (generarComplet(r + i, c + j, celesBuides, n + 1, escrits, matriu, randomSeed.nextInt(4))) {
							return true;
						}
					}
				}
			}
		}
		else if (seed == 1) {
			for (int i = -1; i < 2; i++) {
				for (int j = 1; j > -2 ; j--) {
					if (hidato.posicioValida(i, j, r, c) && dinsLimits(r+i, c+j, matriu.length, matriu[0].length)) {
						if (generarComplet(r + i, c + j, celesBuides, n + 1, escrits, matriu, randomSeed.nextInt(4))) {
							return true;
						}
					}
				}
			}
		}
		else if (seed == 2) {
			for (int i = 1; i > -2; i--) {
				for (int j = -1; j < 2; j++) {
					if (hidato.posicioValida(i, j, r, c) && dinsLimits(r+i, c+j, matriu.length, matriu[0].length)) {
						if (generarComplet(r + i, c + j, celesBuides, n + 1, escrits, matriu, randomSeed.nextInt(4))) {
							return true;
						}
					}
				}
			}
		}
		else {
			for (int i = 1; i > 2; i--) {
				for (int j = 1; j > 2; j--) {
					if (hidato.posicioValida(i, j, r, c) && dinsLimits(r+i, c+j, matriu.length, matriu[0].length)) {
						if (generarComplet(r + i, c + j, celesBuides, n + 1, escrits, matriu, randomSeed.nextInt(4))) {
							return true;
						}
					}
				}
			}
		}
		escrits.remove(escrits.size()-1);
		matriu[r][c] = 0;
		return false;
	}

	private boolean dinsLimits(int i, int j, int tamanyi, int tamanyj) {
		if (i < 0) return false;
		if (j < 0) return false;
		if (i >= tamanyi) return false;
		if (j >= tamanyj) return false;
		return true;
	}

	public int[][] generarHidato(int tamanyi, int tamanyj, int forats) {
		int[][] matriu = new int[tamanyi][tamanyj]; //per defecte esta emplenada amb 0
		boolean generat = false;
		generat = generarMatriuCompleta(forats, matriu);
		if (generat) {
			emplenarForats(matriu);
			matriuSolucio = makeCopy(matriu);
			solucionat = true;
			extreureNombres(forats, matriu);
			emplenarGiven(matriu);
			return matriu;
		}
		else return null;
	}

	public int[][] generarHidato(Dificultat dificultat) {
		boolean generat = false;
		int[] tamanys = getTamanySegonsDificultat(dificultat);
		int tamanyi = tamanys[0];
		int tamanyj = tamanys[1];
		int forats = tamanys[2];
		int[][] matriu = new int[tamanyi][tamanyj]; //per defecte esta emplenada amb 0

		for (int i = 0; i < 10; ++i) { //10 intents per generar un hidato, cadascun amb un forat mes (mes facil cada cop)
			generat = generarMatriuCompleta(forats+i, matriu);
			if (generat) {
				emplenarForats(matriu);
				matriuSolucio = makeCopy(matriu);
				solucionat = true;
				extreureNombres(forats, matriu);
				emplenarGiven(matriu);
				return matriu;
			}
		}
		return null;
	}

	private int[] getTamanySegonsDificultat(Dificultat dificultat) {
		Random rand = new Random();
		int[] tamanys = new int[3];
		int i;
		int j;
		int f;
		if (dificultat == Dificultat.FACIL) {
			i = rand.nextInt(4)+2; //[2,5]
			j = rand.nextInt(4)+2;  //[2,5]
			if (i*j == 4) f = rand.nextInt(1);
			else f = rand.nextInt(3);
		}
		else if (dificultat == Dificultat.MIG) {
			i = rand.nextInt(2)+6; //[6,7]
			j = rand.nextInt(2)+6;  //[6,7]
			f = rand.nextInt((i*j)/5) + (i*j)/20; //entre 5 i 20%
		}
		else { //DIFICIL
			i = rand.nextInt(3)+8; 	//[8,10]
			j = rand.nextInt(3)+8;  //[8,10]
			f = rand.nextInt((i*j)/5) + (i*j)/20; //entre 5 i 20%
		}
		tamanys[0] = i;
		tamanys[1] = j;
		tamanys[2] = f;
		return tamanys;
	}

	private void extreureNombres(int forats, int[][] matriu) {
		Random rand = new Random();
		int celesNumeriques = matriu.length * matriu[0].length - forats;
		for (int i = 0; i < matriu.length; ++i) {
			for (int j = 0; j < matriu[0].length; ++j) {
				if (matriu[i][j] != 1 && matriu[i][j] != celesNumeriques && matriu[i][j] > -1) { //primer i ultim numero han d'estar, i tampoc s'han de treure els forats
					 int treure = rand.nextInt(4); //         1/4 possibilitat de treure un numero = hi han ficats 1/4 dels numeros
					 if (celesNumeriques > 6 && treure != 0) matriu[i][j] = 0;
				}
			}
		}
	}

	private boolean generarMatriuCompleta(int forats, int[][] matriu) {
		int tamanyi = matriu.length;
		int tamanyj = matriu[0].length;
		//generem [tamany] nombres posicions aleatoris per començar a emplenar la matriu autogenerada
		ArrayList<Integer> initialNumberi = new ArrayList<>(tamanyi);
		ArrayList<Integer> initialNumberj = new ArrayList<>(tamanyj);
		for (int i = 0; i < tamanyi; i++){
			initialNumberi.add(i);
		}
		for (int j = 0; j < tamanyj; j++){
			initialNumberj.add(j);
		}
		Collections.shuffle(initialNumberi);
		Collections.shuffle(initialNumberj);

		ArrayList<Integer> escrits;
		randomSeed = new Random();
              
                  
          
		for (int i = 0; i < tamanyi; ++i) {
			for (int j = 0; j < tamanyj; ++j) {
				escrits = new ArrayList<>();
				if (generarComplet(initialNumberi.get(i), initialNumberj.get(j), tamanyi*tamanyj - forats, 1, escrits, matriu, randomSeed.nextInt(4))) return true; //intentem generar una matriu amb l'1 a totes les posicions possibles
			}
		}
		return false;
	}

	private void emplenarForats(int[][] matriu) {
		for (int i = 0; i < matriu.length; ++i) {
			for (int j = 0; j < matriu[0].length; ++j) {
				if (matriu[i][j] == 0) matriu[i][j] = -1;
			}
		}
	}

	private int[][] makeCopy(int[][] matriuOriginal) {
    	int y = matriuOriginal.length;
    	int x = matriuOriginal[0].length;
    	int[][] matriuNova = new int[y][x];
    	for (int i = 0; i < y; ++i) {
    		for (int j = 0; j < x; ++j) {
    			matriuNova[i][j] = matriuOriginal[i][j];
    		}
    	}
    	return matriuNova;
	}

	private void emplenarGiven(int[][] matriu) {
		for (int i = 0; i < matriu.length; ++i) {
			for (int j = 0; j < matriu[0].length; ++j) {
				if (matriu[i][j] > 0) { //valor igual a un numero
					given.addElement(matriu[i][j]);
				}
			}
		}
		Collections.sort(given);
	}
}
