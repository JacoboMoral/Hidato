package tests.drivers.Hidato;

import java.util.Scanner;

import main.domain.com.hidato.Hidato;
import main.domain.com.hidato.HidatoFactory;
import main.domain.com.hidato.Partida;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class DriverHidato {
	private static int numeroTests = 14;
	
    public static void main(String[] args) throws Exception{
		System.out.println("Aquest es el driver de algorismes, indica quina funcio vols provar");
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
			case 4:
			case 5:
			case 6:
			case 7:
			default:
		}
	}

	public static void llistaTests() {
		System.out.println("1: ConstructoraSenseMatriu");
		System.out.println("2: ConstructoraAmbMatriu");
		System.out.println("3: Solucionar");
		System.out.println("4: getMatriuSolucio");
		System.out.println("5: obtenirDificultat");
		System.out.println("6: getGiven");
		System.out.println("7: generarHidato");
	}
	
	private static void constructoraAmbMatriu() {
		
		//PER FER PARTIDA NECESITEM UN HIDATO!!!!!!!!!!!!!!!!!!!!!
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
		
	
		
		Hidato hidato = HidatoFactory.createHidato(tc, ta);
		
		
		System.out.println("Partida creada correctament, constructoraAmbMatriu acabat amb èxit");
		
	}
	
	private static void constructoraSenseMatriu() {
		
		//PER FER PARTIDA NECESITEM UN HIDATO!!!!!!!!!!!!!!!!!!!!!
		System.out.println("introdueix quin tipus d'hidato vols [Quadrat | Triangle | Hexagon]");
		String tipusHidato = readLine();
		TipusCella tc = stringToTipusCella(tipusHidato);
		if(tc == null) constructora();
		
		System.out.println("introdueix quin tipus d'adjacencia vols [COSTATS | COSTATSIANGLES]");
		String tipusAdjacencia = readLine();
		TipusAdjacencia ta = stringToTipusAdjacencia(tipusAdjacencia);
		if (ta == null) {
			System.out.println("Tipus d'adjacencia incorrecte");
			constructora();
		}
		if(tipusNoCompatible(tc, ta)) {
			System.out.println("Adjacencia no compatible amb el tipus d'hidato");
			constructora();
		}
		
	
		
		Hidato hidato = HidatoFactory.createHidato(tc, ta);
			
		System.out.println("Hidato creada correctament, constructoraSenseMatriu acabat amb èxit");
		
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
