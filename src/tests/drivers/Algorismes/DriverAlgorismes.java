package tests.drivers.Algorismes;
import java.util.Scanner;
import java.util.Vector;

import main.domain.com.hidato.Algorismes;
import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.HidatoIO;
import main.domain.com.hidato.TipusAdjacencia;

public class DriverAlgorismes {
	private static int numeroTests = 7;
	
	private static int[][] matriuSolucio1 = new int[][] {
		{1,-1,-1},
		{2,11,-1},
		{3,10,9},
		{4,-1,8},
		{5,6,7}
	};
	
	private static int[][] matriuSolucio2 = new int[][] {
		{1,-1,-1},
		{2,3,4},
		{7,6,5},
		{8,9,-1},
		{-1,10,11}
	};
	
	private static int[][] matriuHidato1 = new int[][] {
		{1,-1,-1},
		{0,11,-1},
		{0,0,0},
		{0,-1,8},
		{5,0,0}
	};
	
	private static int[][] matriuHidato2 = new int[][] {
		{1,-1,-1},
		{0,0,0},
		{0,0,5},
		{8,0,-1},
		{-1,0,11}
	};

	
	
    public static void main(String[] args) throws Exception{
		System.out.println("Aquest es el driver de algorismes, indica quina funcio vols provar");
		llistaTests();
		int req = 0;
		while (req != -1) {
			req = getRequest();
			while (req == 0 || req > numeroTests) {
				System.out.println("Si us plau, entra un dels nombres corresponents al metode que vols provar\n");
				llistaTests();
				req = getRequest();
			}
			if (req != -1) tractaRequest(req);
		}
		System.out.println("Driver ha acabat amb exit");
	}
	
	private static void tractaRequest(int req) {
		switch (req) {
			case 1:
				driverConstructora();
				break;
			case 2:
				driverModificarHidato();
				break;
			case 3:
				driverSolucionar();
				break;
			case 4:
				driverGetMatriuSolucio();
				break;
			case 5:
				driverObtenirDificultat();
				break;
			case 6:
				driverGetGiven();
				break;
			case 7:
				driverGenerarHidato();
				break;
			default:
		}
	}


	private static void driverGenerarHidato() {
		System.out.println("Has escollit provar el metode generarHidato");
		System.out.println();
		HidatoStub hidato = new HidatoStub(TipusAdjacencia.COSTATS);
		Algorismes algorismes = new Algorismes(hidato);
		System.out.println("S'ha creat una instancia algorismes amb un hidato sense matriu:");
		
		boolean continua = true;
		while (continua) {
			System.out.println("Escriu el nombre de files (minim 2) ");
			int i = getNumero();
			while (i < 2) {
				i = getNumero();
			}
			System.out.println("Escriu el nombre de columnes (minim 2)");
			int j = getNumero();
			while (j < 2) {
				j = getNumero();
			}
			System.out.println("Escriu el nombre de forats que vols introduir (no pot ser mes gran que la meitat de celles totals)");
			int x = getNumero();
			while (x > (i*j)/2) {
				x = getNumero();
			}
			int[][] mat = algorismes.generarHidato(x,i,j);
			if (mat != null) {
				System.out.println("La matriu generada es la seguent:");
				HidatoIO.writeHidatoMatrixToOutput(mat);
			}
			else {
				System.out.println("No s'ha pogut generar un hidato amb les condicions anteriors:");
			}
			System.out.println("\n Vols generar un altre hidato? yes/no");
			String s = readLine();
			while (!s.equalsIgnoreCase("yes") && !s.equalsIgnoreCase("no")) {
				s = readLine();
			}
			if (s.equals("no")) continua = false;
		}
		
		System.out.println("Sortint del driver de generarHidato");
		System.out.println();
		System.out.println();			
	}

	private static void driverGetGiven() {
		System.out.println("Has escollit provar el metode getGiven");
		System.out.println();
		HidatoStub hidato = new HidatoStub(TipusAdjacencia.COSTATS,matriuHidato1);
		Algorismes algorismes = new Algorismes(hidato);
		System.out.println("S'ha creat una instancia algorismes amb un hidato amb la seguent matriu:");
		HidatoIO.writeHidatoMatrixToOutput(matriuHidato1);
		System.out.println("S'espera el seguent vector de nombres donats:");
		Vector<Integer> v = new Vector<Integer>(4);
		v.add(1);
		v.add(5);
		v.add(8);
		v.add(11);
		System.out.println(v);
		
		Vector<Integer> donats = algorismes.getGiven();
		System.out.println("S'espera el seguent vector de nombres donats:");
		System.out.println(donats);
		
		boolean correcte = donats.equals(v);
		System.out.println("Comprovacio que els dos vectors siguin iguals: " + correcte);
		if (correcte) System.out.println("Sortint amb exit del driver de getGiven");
		else System.out.println("Hi ha hagut algun problema, sortint del driver de getGiven");
		System.out.println();
		System.out.println();	
	}

	private static void driverObtenirDificultat() {
		System.out.println("Has escollit provar el metode obtenirDificultat");
		System.out.println();
		HidatoStub hidato = new HidatoStub(TipusAdjacencia.COSTATS,matriuHidato1);
		Algorismes algorismes = new Algorismes(hidato);
		System.out.println("S'ha creat una instancia algorismes amb un hidato amb la seguent matriu:");
		HidatoIO.writeHidatoMatrixToOutput(matriuHidato1);
		System.out.println("S'espera la seguent dificultat: " + Dificultat.FACIL);
		Dificultat difObtinguda = algorismes.obtenirDificultat();
		System.out.println("S'ha obtes la seguent dificultat amb el metode: " + difObtinguda);
		boolean correcte = difObtinguda == Dificultat.FACIL;
		System.out.println("Comprovacio que les dues dificultats siguin iguals: " + correcte);
		if (correcte) System.out.println("Sortint amb exit del driver de obtenirDificultat");
		else System.out.println("Hi ha hagut algun problema, sortint del driver de obtenirDificultat");
		System.out.println();
		System.out.println();			
	}

	private static void driverGetMatriuSolucio() {
		System.out.println("Has escollit provar el metode getMatriuSolucio");
		System.out.println();
		HidatoStub hidato = new HidatoStub(TipusAdjacencia.COSTATS, matriuHidato1);
		Algorismes algorismes = new Algorismes(hidato);
		System.out.println("S'ha creat una nova instancia algorismes");
		System.out.println("S'ha creat una nova instancia hidato amb la seguent matriu:");
		HidatoIO.writeHidatoMatrixToOutput(matriuHidato1);
		System.out.println("Aquesta es la matriuSolucio esperada per l'hidato anterior:");
		HidatoIO.writeHidatoMatrixToOutput(matriuSolucio1);
		int[][] mat = algorismes.getMatriuSolucio();
		System.out.println("Aquesta es la matriuSolucio obtinguda amb el metode:");
		HidatoIO.writeHidatoMatrixToOutput(mat);
		
		boolean correcte = java.util.Arrays.deepEquals(mat, matriuSolucio1);
		System.out.println("Comprovacio que les dues matrius siguin iguals: " + correcte);
		System.out.println();
		if (correcte) System.out.println("Sortint amb exit del driver de getMatriuSolucio");
		else System.out.println("Hi ha hagut algun problema, sortint del driver de getMatriuSolucio");
		System.out.println();
		System.out.println();			
	}

	private static void driverSolucionar() {
		System.out.println("Has escollit provar el metode Solucionar");
		System.out.println();
		HidatoStub hidato = new HidatoStub(TipusAdjacencia.COSTATS, matriuHidato1);
		Algorismes algorismes = new Algorismes(hidato);
		System.out.println("S'ha creat una nova instancia hidato i algorismes");
		int mat[][] = algorismes.getMatriuSolucio();
		System.out.println("S'ha cridat el metode Solucionar. La matriu sense solucionar era:");
		HidatoIO.writeHidatoMatrixToOutput(matriuHidato1);
		System.out.println("\nDespres de solucionar-lo, la matriu que ens retorna getMatriuSolucio es:");
		HidatoIO.writeHidatoMatrixToOutput(mat);
		System.out.println("\nLa matriu que s'esperava obtenir es:");
		HidatoIO.writeHidatoMatrixToOutput(matriuSolucio1);
		boolean correcte = java.util.Arrays.deepEquals(mat, matriuSolucio1);
		System.out.println("Comprovacio que les dues matrius siguin iguals: " + correcte);
		System.out.println();
		if (correcte) System.out.println("Sortint amb exit del driver de Solucionar");
		else System.out.println("Hi ha hagut algun problema, sortint del driver de Solucionar");
		System.out.println();
		System.out.println();			
	}

	private static void driverModificarHidato() {
		System.out.println("Has escollit provar el metode ModificarHidato");
		System.out.println();
		HidatoStub hidato1 = new HidatoStub(TipusAdjacencia.COSTATS, matriuHidato1);
		Algorismes algorismes = new Algorismes(hidato1);
		System.out.println("S'ha creat una nova instancia hidato i algorismes");
		System.out.println("Abans de modificar el hidato, aquesta es la seva matriu solucionada:");
		int[][] mat1 = algorismes.getMatriuSolucio();
		HidatoIO.writeHidatoMatrixToOutput(mat1);
		HidatoStub hidato2 = new HidatoStub(TipusAdjacencia.COSTATS, matriuHidato2);
		algorismes.modificarHidato(hidato2);
		System.out.println("\nDespres de modificar el hidato amb un nou amb diferent matriu, aquesta es la seva matriu solucionada:");
		int mat2[][] = algorismes.getMatriuSolucio();
		HidatoIO.writeHidatoMatrixToOutput(mat2);
		
		boolean correcte = !java.util.Arrays.deepEquals(mat1, mat2);
		System.out.println("Comprovacio que les dues matrius siguin diferents: " + correcte);
		System.out.println();
		if (correcte) System.out.println("Sortint amb exit del driver de modificarHidato");
		else System.out.println("Hi ha hagut algun problema, sortint del driver de modificarHidato");
		System.out.println();
		System.out.println();			
	}

	private static void driverConstructora() {
		System.out.println("Has escollit provar el metode constructor");
		System.out.println();
		HidatoStub hidato = new HidatoStub(TipusAdjacencia.COSTATS,matriuHidato1);
		Algorismes algorismes = new Algorismes(hidato);
		
		System.out.println("Classe algorismes creada sense cap excepció");
		System.out.println();
		System.out.println("Sortint del driver de Constructora");
		System.out.println();
		System.out.println();		
	}

	public static void llistaTests() {
		System.out.println("exit: Sortir del driver");
		System.out.println("1: Constructora");
		System.out.println("2: Modificar hidato");
		System.out.println("3: Solucionar");
		System.out.println("4: getMatriuSolucio");
		System.out.println("5: obtenirDificultat");
		System.out.println("6: getGiven");
		System.out.println("7: generarHidato");
	}
	
	private static String readLine() {		
		Scanner input = new Scanner(System.in);
		String req = input.nextLine();
		return req;
	}
	
	private static int getRequest() {
		String req = readLine();
		if (isNumber(req)) return Integer.parseInt(req);
		else if (req.equalsIgnoreCase("exit")) return -1;
		else return 0;
	}

	private static boolean isNumber(String s) {
		boolean validNumber = false;
		try {
			Integer.parseInt(s);
			//si arriba fins aqui, es un numero
			validNumber = true;
		} catch (NumberFormatException e) {
			//si entra aqui, alhesores ha saltat l'excepcio de que no es pot convertir en numero
		}
		return validNumber;	
	}
	
	private static int getNumero() {
		String req = readLine();
		if (isNumber(req)) return Integer.parseInt(req);
		else return -1;
	}
	
}
