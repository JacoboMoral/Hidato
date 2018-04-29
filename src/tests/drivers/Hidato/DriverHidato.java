package tests.drivers.Hidato;

import java.util.Scanner;

import main.domain.com.hidato.Hidato;
import main.domain.com.hidato.HidatoFactory;
import main.domain.com.hidato.HidatoHexagon;
import main.domain.com.hidato.HidatoQuadrat;
import main.domain.com.hidato.HidatoTriangle;
import main.domain.com.hidato.Partida;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class DriverHidato {
	private static int numeroTests = 14;
	
    public static void main(String[] args) throws Exception{
		System.out.println("Aquest es el driver de hidato, indica quina funcio vols provar");
		llistaTests();
		int req = -1;
		req = getRequest();
		while (req == -1 || req > numeroTests) {
			System.out.println("Si us plau, entra un dels nombres corresponents a la funcio que vols provar\n");
			llistaTests();
			req = getRequest();
		}
		tractaRequest(req);
	}
	
	private static void tractaRequest(int req) {
		switch (req) {
			case 1:
				constructoraSenseMatriu();
				break;
			case 2:
				constructoraAmbMatriu();
				break;
			case 3:
				driverAutogenerar();
				break;
			case 4:
				driverGetNombresPerDefecte();
				break;
			case 5:
			case 6:
			case 7:
			default:
		}
	}

	private static void driverGetNombresPerDefecte() {
		
	}

	private static void driverAutogenerar() {
		System.out.println("Has escollit provar el metode autogenerar");
		System.out.println();
		System.out.println("Per això creem un hidato de tipus quadrat amb adjacencia per costats sense matriu");
		Hidato hidato = new HidatoQuadrat(TipusAdjacencia.COSTATS);
		System.out.println("Hidato creat correctament");

	}

	private static void constructoraAmbMatriu() {
		System.out.println("Has escollit provar el metode ConstructoraAmbMatriu");
		System.out.println();
		System.out.println("introdueix quin tipus d'hidato vols [Quadrat | Triangle | Hexagon]");
		String tipusHidato = readLine();
		TipusCella tc = stringToTipusCella(tipusHidato);
		if(tc == null) constructoraAmbMatriu();
		
		System.out.println("introdueix quin tipus d'adjacencia vols [COSTATS | COSTATSIANGLES]");
		String tipusAdjacencia = readLine();
		TipusAdjacencia ta = stringToTipusAdjacencia(tipusAdjacencia);
		if (ta == null) {
			System.out.println("Tipus d'adjacencia incorrecte");
			constructoraAmbMatriu();
		}
		if(tipusNoCompatible(tc, ta)) {
			System.out.println("Adjacencia no compatible amb el tipus d'hidato");
			constructoraAmbMatriu();
		}
		
		int[][] matriu = new int[][] {};
		
		Hidato hidato;
		
		if (tc == TipusCella.QUADRAT) hidato = new HidatoQuadrat(ta, matriu);
		else if (tc == TipusCella.TRIANGLE) hidato = new HidatoTriangle(matriu);
		else if (tc == TipusCella.HEXAGON) hidato = new HidatoHexagon(matriu);
		else {
			System.out.println("Error desconegut, es torna a cridar constructoraAmbMatriu");
			constructoraAmbMatriu();
		}

		System.out.println();
		System.out.println("Hidato creat correctament, constructoraAmbMatriu acabat amb exit");
		System.out.println();
		System.out.println();
		
	}
	
	private static void constructoraSenseMatriu() {
		System.out.println("Has escollit provar el metode ConstructoraSenseMatriu");
		System.out.println();
		System.out.println("introdueix quin tipus d'hidato vols [Quadrat | Triangle | Hexagon]");
		String tipusHidato = readLine();
		TipusCella tc = stringToTipusCella(tipusHidato);
		if(tc == null) {
			System.out.println("Tipus de Cella incorrece, es torna a cridar driver constructora sense Matriu");
			System.out.println();
			System.out.println();
			constructoraSenseMatriu();
		} 
		
		System.out.println("introdueix quin tipus d'adjacencia vols [COSTATS | COSTATSIANGLES]");
		String tipusAdjacencia = readLine();
		TipusAdjacencia ta = stringToTipusAdjacencia(tipusAdjacencia);
		if (ta == null) {
			System.out.println("Tipus d'adjacencia incorrecte, es torna a cridar driver constructora sense Matriu");
			System.out.println();
			System.out.println();
			constructoraSenseMatriu();
		}
		if(tipusNoCompatible(tc, ta)) {
			System.out.println("Adjacencia no compatible amb el tipus d'hidato, es torna a cridar driver constructora sense Matriu");
			System.out.println();
			System.out.println();
			constructoraSenseMatriu();
		}
		Hidato hidato;
		if (tc == TipusCella.QUADRAT) hidato = new HidatoQuadrat(ta);
		else if (tc == TipusCella.TRIANGLE) hidato = new HidatoTriangle();
		else if (tc == TipusCella.HEXAGON) hidato = new HidatoHexagon();
		else {
			System.out.println("Error desconegut, es torna a cridar constructoraAmbMatriu");
			constructoraAmbMatriu();
		}
		
		System.out.println();
		System.out.println("Hidato creada correctament, constructoraSenseMatriu acabat amb exit");
		System.out.println();
		System.out.println();
		
	}
	
	
	public static void llistaTests() {
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
