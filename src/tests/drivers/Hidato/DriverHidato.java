package tests.drivers.Hidato;

import java.util.Scanner;

import main.domain.com.hidato.Hidato;
import main.domain.com.hidato.HidatoIO;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;


//hem fet servir una subclasse stub de hidato (HidatoStub), canviant la part on cridava
//a la classe algorismes, i canviant aquesta per un stub d'algorismes, per
//poder provar la classe sense dependències
public class DriverHidato {
	private static int numeroTests = 14;
	private static int[][] matriu = new int[][] {
		{1,-1,-1},
		{0,11,-1},
		{0,0,0},
		{0,-1,8},
		{5,0,0}
	};
	
    public static void main(String[] args) throws Exception{
		System.out.println("Aquest es el driver de hidato, indica quina funcio vols provar");
		llistaTests();
		int req = 0;
		while (req != -1) {
			req = getRequest();
			while (req == 0 || req > numeroTests) {
				System.out.println("Si us plau, entra un dels nombres corresponents a la funcio que vols provar\n");
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
				driverAutogenerar();
				break;
			case 2:
				driverMoviment();
				break;
			case 3:
				driverGetNombresPerDefecte();
				break;
			case 4:
				driverGetNombreFiles();
				break;
			case 5:
				driverGetNombreColumnes();
				break;
			case 6:
				driverGetMatriu();
				break;
			case 7:
				driverGetMatriuOriginal();
				break;
			case 8:
				driverResetMatriu();
				break;
			case 9:
				driverGetSolucio();
				break;
			case 10:
				driverTeSolucio();
				break;
			case 11:
				driverGetTipusAdjacencia();
				break;
			case 12:
				driverGetDificultat();
				break;
			default:
		}
	}

	private static void driverMoviment() {
		System.out.println("Has escollit provar el metode moviment");
		System.out.println();
		Hidato hidato = new HidatoStub(TipusAdjacencia.COSTATS, matriu);
		System.out.println("S'ha hagut de crear una instancia d'hidato amb la seguent matriu: ");
		HidatoIO.writeHidatoMatrixToOutput(matriu);
		System.out.println();
		System.out.println("S'ha cridat el metode teSolucio, que es precondicio d'aquest metode");
		hidato.teSolucio(); // aquesta funcio es precondicio, ja que es crida sempre quan es crea un hidato
		boolean continua = true;
		while (continua) {
			System.out.println("Escriu -2 per acabat l'execucio d'aquest driver");
			System.out.println("Escriu la coordenada y on vols fer el moviment (0..length-1)");
			int i = getNumero();
			while (i == -1) {
				i = getNumero();
			}
			System.out.println("Escriu la coordenada x on vols fer el moviment (0..length-1)");
			int j = getNumero();
			while (j == -1) {
				j = getNumero();
			}
			System.out.println("Escriu el valor x que vols introduir");
			int x = getNumero();
			while (x == -1) {
				x = getNumero();
			}
			System.out.println("El moviment que has fet es correcte?: " + hidato.moviment(i, j, x));
			System.out.println("La matriu queda aixi:");
			HidatoIO.writeHidatoMatrixToOutput(hidato.getMatriu());
			System.out.println("\n Vols ver un altre moviment? yes/no");
			String s = readLine();
			while (!s.equalsIgnoreCase("yes") && !s.equalsIgnoreCase("no")) {
				s = readLine();
			}
			if (s.equals("no")) continua = false;
		}
		System.out.println("Driver moviment finalitzat");
		System.out.println();
		System.out.println();		
	}

	private static void driverGetNombreFiles() {
		// TODO Auto-generated method stub
		
	}

	private static void driverGetNombreColumnes() {
		// TODO Auto-generated method stub
		
	}

	private static void driverGetMatriu() {
		// TODO Auto-generated method stub
		
	}

	private static void driverGetMatriuOriginal() {
		// TODO Auto-generated method stub
		
	}

	private static void driverResetMatriu() {
		// TODO Auto-generated method stub
		
	}

	private static void driverGetSolucio() {
		// TODO Auto-generated method stub
		
	}

	private static void driverTeSolucio() {
		// TODO Auto-generated method stub
		
	}

	private static void driverGetTipusAdjacencia() {
		// TODO Auto-generated method stub
		
	}

	private static void driverGetDificultat() {
		// TODO Auto-generated method stub
		
	}

	private static void driverGetNombresPerDefecte() {
		
	}

	private static void driverAutogenerar() {
		System.out.println("Has escollit provar el metode autogenerar");
		System.out.println();
		System.out.println("Per aix� creem un hidato de tipus quadrat amb adjacencia per costats sense matriu");
		Hidato hidato = new HidatoStub(TipusAdjacencia.COSTATS, matriu);
		System.out.println("Hidato creat correctament");

	}
	
	public static void llistaTests() {
		System.out.println("exit: Sortir del driver");
		System.out.println("1: ConstructoraSenseMatriu");
		System.out.println("2: ConstructoraAmbMatriu");
		System.out.println("3: autogenerar");
		System.out.println("4: getNombresPerDefecte");
		System.out.println("5: getNombreFiles");
		System.out.println("6: getNombreColumnes");
		System.out.println("7: getDificultat");
		System.out.println("8: getMatriu");
		System.out.println("9: getMatriuOriginal");
		System.out.println("10: resetMatriu");
		System.out.println("11: getSolucio");
		System.out.println("12: teSolucio");
		System.out.println("13: getTipusAdjacencia");
		System.out.println("14: getTipusCella");
		System.out.println("15: posicioValida");
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
	
	private static int getNumero() {
		String req = readLine();
		if (isNumber(req)) return Integer.parseInt(req);
		else return -1;
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
	
	private static TipusCella stringToTipusCella(String tc) {
		if (tc.equalsIgnoreCase("Quadrat")) return TipusCella.QUADRAT;
		if (tc.equalsIgnoreCase("Triangle")) return TipusCella.TRIANGLE;
		if (tc.equalsIgnoreCase("Hexagon")) return TipusCella.HEXAGON;
		return null;
	}

	private static TipusAdjacencia stringToTipusAdjacencia(String ta) {
		if (ta.equalsIgnoreCase("Costats")) return TipusAdjacencia.COSTATS;
		if (ta.equalsIgnoreCase("Ambdos")) return TipusAdjacencia.COSTATSIANGLES;
		return null;
	}
	private static boolean tipusNoCompatible(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia) {
		return ((tipusCella == TipusCella.HEXAGON && tipusAdjacencia == TipusAdjacencia.COSTATSIANGLES) ||
				tipusCella == TipusCella.TRIANGLE && tipusAdjacencia == TipusAdjacencia.COSTATSIANGLES);
	}
}
