package main.domain.com.hidato;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;


public class Algorismes {

	private int[][] matriuSolucio;
	boolean solucionat = false;
	private Hidato hidato;
	private Vector<Integer> given = new Vector<Integer>();

	public Algorismes(Hidato hidato) {
		this.matriuSolucio = hidato.getMatriu();
		this.hidato = hidato;
	}

	public void modificarHidato(Hidato hidato) {
		this.matriuSolucio = hidato.getMatriu();
		solucionat = false;
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
			this.solucionar();
		}
		return this.matriuSolucio;
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

	private boolean generarComplet(int r, int c, int celesBuides, int n, ArrayList<Integer> escrits, int[][] matriu) {
		if (n > celesBuides) return true;

		if (matriu[r][c] != 0) return false;

		if (escrits.contains(n)) return false;

		matriu[r][c] = n;
		escrits.add(n);
		
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 2; j++) {
				if (hidato.posicioValida(i, j, r, c) && dinsLimits(r+i, c+j, matriu.length, matriu[0].length)) {
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

	private boolean dinsLimits(int i, int j, int tamanyi, int tamanyj) {
		if (i < 0) return false;
		if (j < 0) return false;
		if (i >= tamanyi) return false;
		if (j >= tamanyj) return false;
		return true;
	}

	public int[][] generarHidato(int forats, int tamanyi, int tamanyj) {
		int[][] matriu = new int[tamanyi][tamanyj]; //per defecte esta emplenada amb 0
		boolean generat = false;
		int intents = 0;
		while (!generat && intents < 15) {
			emplenarForats(forats, matriu);
			generat = generarMatriuCompleta(forats, matriu);
			//System.out.println("intent numero: " + (intents+1));
			++intents;
			if (!generat) matriu = new int[tamanyi][tamanyj];

		}
		if (generat) {
			extreureNombres(forats, matriu);
			return matriu;
		}
		else return null;
	}

	public int[][] generarHidato(Dificultat dificultat) {
		boolean generat = false;
		int intentsTamany = 0;
		while (!generat && intentsTamany < 3 ) {
			int[] tamanys = getTamanySegonsDificultat(dificultat);
			int tamanyi = tamanys[0];
			int tamanyj = tamanys[1];
			int forats = tamanys[2];
			int[][] matriu = new int[tamanyi][tamanyj]; //per defecte esta emplenada amb 0
			int intents = 0;

			while (!generat && intents < 10) {
				emplenarForats(forats, matriu);
				generat = generarMatriuCompleta(forats, matriu);
				++intents;
				if (intents%3 == 0) {//cada 3 intents baixem el nombre de forats en un
					if (forats > 0) --forats;
				}
				if (!generat) matriu = new int[tamanyi][tamanyj];

			}
			if (generat) {
				extreureNombres(forats, matriu);
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
			i = rand.nextInt(4)+2; //[2,6]
			j = rand.nextInt(4)+2;  //[2,6]
			while (i * j > 17) {
				j = rand.nextInt(4)+2;
			}
			if (i*j == 4) f = rand.nextInt(1);
			else f = rand.nextInt(3);
		}
		else if (dificultat == Dificultat.MIG) {
			i = rand.nextInt(2)+6; //[6,8]
			j = rand.nextInt(2)+6;  //[6,8]
			f = rand.nextInt((i*j)/20); //com a molt 5% forats
		}
		else { //DIFICIL
			i = rand.nextInt(4)+8; 	//[8,12]
			j = rand.nextInt(4)+8;  //[8,12]
			f = rand.nextInt((i*j)/20); //com a molt 5% forats
		}
		tamanys[0] = i;
		tamanys[1] = j;
		tamanys[2] = f;
		return tamanys;
	}

	private void emplenarForats(int forats, int[][] matriu) {
		int tamanyi = matriu.length;
		int tamanyj = matriu[0].length;
		Random rand = new Random();
		for (int i = 0; i < forats; ++i) {
			int posi = rand.nextInt(tamanyi);
			int posj = rand.nextInt(tamanyj);
			if (matriu[posi][posj] == -1) --i;
			else matriu[posi][posj] = -1;
		}
	}

	private void extreureNombres(int forats, int[][] matriu) {
		Random rand = new Random();
		int celesNumeriques = matriu.length * matriu[0].length - forats;
		if (celesNumeriques <= 6) {
			for (int i = 0; i < matriu.length; ++i) {
				for (int j = 0; j < matriu[0].length; ++j) {
					if (matriu[i][j] != 1 && matriu[i][j] != celesNumeriques && matriu[i][j] > -1) { //primer i ultim numero han d'estar, i tampoc s'han de treure els forats
						matriu[i][j] = 0;
					}
				}
			}
		}
		else {
			for (int i = 0; i < matriu.length; ++i) {
				for (int j = 0; j < matriu[0].length; ++j) {
					if (matriu[i][j] != 1 && matriu[i][j] != celesNumeriques && matriu[i][j] > -1) { //primer i ultim numero han d'estar, i tampoc s'han de treure els forats
						 int treure = rand.nextInt(4); //         1/4 possibilitat de treure un numero = hi han ficats 1/4 dels numeros
						 if (treure != 0) matriu[i][j] = 0;
					}
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
		for (int i = 0; i < tamanyi; i++){ //to generate from 0-10 inclusive
			initialNumberi.add(i);
		}
		for (int j = 0; j < tamanyj; j++){ //to generate from 0-10 inclusive
			initialNumberj.add(j);
		}
		Collections.shuffle(initialNumberi);
		Collections.shuffle(initialNumberj);

		ArrayList<Integer> escrits;
		for (int i = 0; i < tamanyi; ++i) {
			for (int j = 0; j < tamanyj; ++j) {
				escrits = new ArrayList<>();
				if (generarComplet(initialNumberi.get(i), initialNumberj.get(j), tamanyi*tamanyj - forats, 1, escrits, matriu)) return true; //intentem generar una matriu amb l'1 a totes les posicions possibles
			}
		}
		return false;
	}
}
