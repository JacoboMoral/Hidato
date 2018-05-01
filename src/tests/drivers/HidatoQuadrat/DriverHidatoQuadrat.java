package tests.drivers.HidatoQuadrat;

import java.util.Scanner;

import main.domain.com.hidato.Hidato;
import main.domain.com.hidato.HidatoIO;
import main.domain.com.hidato.HidatoQuadrat;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class DriverHidatoQuadrat {
	
	private static int numeroTests = 2;
	private static int[][] matriuTest = new int[][] {
		{1,2,3,4,5},
		{6,7,8,9,10},
		{11,12,13,14,15},
		{16,17,18,19,20},
		{21,22,23,24,25}
	};
	
    public static void main(String[] args) throws Exception{
		System.out.println("Aquest es el driver de de HidatoQuadrat, indica quina funcio vols provar");
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
				driverGetTipusCella();
				llistaTests();
				break;
			case 2:
				driverPosicioValida();
				llistaTests();
				break;
			default:
		}
	}

	private static void driverGetTipusCella() {
		System.out.println("Has escollit provar el metode getTipusCella");
		int n = -1;
		while (n != 1 && n != 2) {
			System.out.println("Digues quin tipus d'adjacencia vols per l'hidato quadrat: [1 = Costats; 2 = Costats i angles]");
			n = getNumero();
		}
		TipusAdjacencia ta = intToTipusAdjacencia(n);
		Hidato hidato = new HidatoQuadrat(ta);
		System.out.println("S'ha creat un hidato quadrat amb el tipus d'adjacencia escollit");
		System.out.println("Ara es cridara el mètode getTipusCella, s'espera que es retorni el seguent tipus de cella: " + TipusCella.QUADRAT);
		TipusCella retornat = hidato.getTipusCella();
		System.out.println("El tipus d'adjacencia retornat es: " + retornat);
		boolean correcte = (retornat == TipusCella.QUADRAT);
		System.out.println("Comprovacio de correctesa: " + correcte);
		System.out.println();
		if(correcte) System.out.println("Driver getTipusCella executat correctament!");
		else System.out.println("Ha sorgit un problema. Driver getTipusCella executat sense exit.");
		System.out.println();
		System.out.println();
		llistaTests();
	}

	//Aquesta funcio prova el mètode posicioValida. Per provar-ho, s'ha de escollir una posicio inicial, i despres
	//una posicio secundaria. La funcio et diu si es possible accedir a la segona posicio desde la primera, es a dir
	// si les dues posicions son adjacents
	private static void driverPosicioValida() {
		System.out.println("Has escollit provar el metode posicioValida");
		int n = -1;
		while (n != 1 && n != 2) {
			System.out.println("Digues quin tipus d'adjacencia vols per l'hidato quadrat: [1 = Costats; 2 = Costats i angles]");
			n = getNumero();
		}
		TipusAdjacencia ta = intToTipusAdjacencia(n);
		Hidato hidato = new HidatoQuadrat(ta);
		System.out.println("S'ha creat un hidato quadrat amb el tipus d'adjacencia escollit\n");
		boolean continua = true;
		while (continua) {
			System.out.println("Per provar el mètode posicioValida, has d'escollir una posicio de la seguent matriu,");
			System.out.println("i despres una altra posicio, per comprovar si son adjacents segons l'hidato hexagon.");
			System.out.println("Tingues en compte que han de ser diferents, ja que aquesta comprovacio es fa en una altra classe\n");
			HidatoIO.writeHidatoMatrixToOutput(matriuTest);
			int r = -1;
			while (r < 0 || r > 4) {
				System.out.println("Escull la coordenada y/i de la primera posicio (0..4)");
				r = getNumero();
			}
			int c = -1;
			while (c < 0 || c > 4) {
				System.out.println("Escull la coordenada x/j de la primera posicio (0..4)");
				c = getNumero();
			}
			System.out.println("Per a la posicio inicial, has escollit la coordenada: (" + r + "," + c + "), que equival al valor: " + matriuTest[r][c]);
			
			int i = -1;
			while (i < 0 || i > 4) {
				System.out.println("Escull la coordenada y/i de la segona posicio (0..4)");
				i = getNumero();
			}
			int j = -1;
			while (j < 0 || j > 4 || (i == r && j == c)) {
				System.out.println("Escull la coordenada x/j de la segona posicio (0..4)");
				if (i == r && j == c) System.out.println("Les dues posicions no poden ser la mateixa");
				j = getNumero();
			}
			System.out.println("Per a la segona posicio, has escollit la coordenada: (" + r + "," + c + "), que equival al valor: " + matriuTest[i][j] + "\n");
			System.out.println("La posicio inicial pot explorar la segona posicio?: " + hidato.posicioValida(i-r, j-c, r, c) + "\n\n");
			System.out.println("Vols fer una altra comprobacio? yes/no");
			String s = readLine();
			while (!s.equalsIgnoreCase("yes") && !s.equalsIgnoreCase("no")) {
				s = readLine();
			}
			if (s.equals("no")) continua = false;
		}
		llistaTests();
	}
	
	private static void llistaTests() {
		System.out.println();
		System.out.println("exit: Sortir del driver");
		System.out.println("1: getTipusCella");
		System.out.println("2: posicioValida");
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
	
	private static TipusAdjacencia intToTipusAdjacencia(int ta) {
		if (ta == 1) return TipusAdjacencia.COSTATS;
		if (ta == 2) return TipusAdjacencia.COSTATSIANGLES;
		return null;
	}
}
