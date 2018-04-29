package tests.drivers.Partida;

import java.util.Scanner;

import main.domain.com.hidato.HidatoIO;
import main.domain.com.hidato.Partida;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class DriverPartida {
	
	private static int numeroTests = 13;
	private static int[][] matriuSolucio = new int[][] {
		{1,-1,-1},
		{2,11,-1},
		{3,10,9},
		{4,-1,8},
		{5,6,7}
	};
	
	public static void main(String[] args) throws Exception{
		System.out.println("Aquest es el driver de partida, indica quina funcio vols provar");
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
				driverConstructora();
				break;
			case 2:
				driverIniciarPartida();
				break;
			case 3:
				break;
			case 4:
				
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
				driverGetSolucio();
				break;
			case 10:
			case 11:
			case 12:
			default:
		}
	}

	private static void driverConstructora() {
		System.out.println("Has escollit provar el metode constructor");

		HidatoStub hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
		
		Partida partida = new Partida(hidato);
		
		System.out.println("Partida creada correctament, constructora executada amb exit");
		System.out.println();
		System.out.println();
	}

	private static void driverIniciarPartida() {
		System.out.println("Has escollit provar el metode iniciarPartida");
		
		System.out.println("S'ha hagut de crar una instància partida i una instància d'hidato");
		HidatoStub hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
		Partida partida = new Partida(hidato);

		partida.iniciarPartida();
		System.out.println("S'ha iniciat la partida");
		System.out.println("S'ha hagut de cridar els metodes 'getStatus i getDataIni per comprovar que s'ha iniciat correctament");
		System.out.println("Data d'inici de la partida: " + partida.getDataInici());
		System.out.println("Status de la partida (1 = iniciada, 0 = no iniciada, -1 = finalitzada): " + partida.status());
		System.out.println();
		System.out.println();
	}

	private static void driverGetSolucio() {
		System.out.println("Has escollit provar el metode getMatriuSolucio");
		
		System.out.println("S'ha hagut de crar una instància partida i una instància d'hidato");
		HidatoStub hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
		Partida partida = new Partida(hidato);
		
		int[][] matriuRetornada = partida.getSolucio();
		System.out.println("La matriu solucio esperada es:");
		HidatoIO.writeHidatoMatrixToOutput(matriuSolucio);
		System.out.println("La matriu obtinguda es:");
		HidatoIO.writeHidatoMatrixToOutput(matriuRetornada);
		System.out.println("Comprovacio de igualtat: " + java.util.Arrays.deepEquals(matriuSolucio, matriuRetornada));
		System.out.println();
		System.out.println();
	}

	public static void llistaTests() {
		System.out.println("exit: Sortir del driver");
		System.out.println("1: Constructora");
		System.out.println("2: iniciarPartida");
		System.out.println("3: acabarPartida");
		System.out.println("4: reset");
		System.out.println("5: ferJugada");
		System.out.println("6: status");
		System.out.println("7: getDificultat");
		System.out.println("8: getNombresPerDefecte");
		System.out.println("9: getSolucio");
		System.out.println("10: getMatriu");
		System.out.println("11: getMatriuOriginal");
		System.out.println("12: getDataInici");
		System.out.println("12: getDataFi");
		System.out.println("12: getPuntuacio");
		System.out.println("13: esSolucionable");
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
