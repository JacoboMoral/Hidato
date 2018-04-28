package tests.drivers.Partida;

import java.util.Scanner;

import main.domain.com.hidato.Hidato;
import main.domain.com.hidato.HidatoFactory;
import main.domain.com.hidato.HidatoQuadrat;
import main.domain.com.hidato.Partida;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class DriverPartida {
	
	private static int numeroTests = 12;
		
    public static void main(String[] args) throws Exception{
		System.out.println("Aquest es el driver de partida, indica quina funcio vols provar");
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
				constructora();
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				
			case 5:
			case 6:
			case 7:
			case 8:
			case 9:
			case 10:
			case 11:
			case 12:
			default:
		}
	}

	private static void constructora() {
	
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
		
		Partida partida = new Partida(hidato);
		
		System.out.println("Partida creada correctament, constructoraSenseMatriu acabat amb �xit");
		
	}
	

	public static void llistaTests() {
		System.out.println("1: ConstructoraSenseMatriu");
		System.out.println("2: ConstructoraAmbMatriu");
		System.out.println("3: getNombresPerDefecte");
		System.out.println("4: getNombreFiles");
		System.out.println("5: getNombreColumnes");
		System.out.println("6: getDificultat");
		System.out.println("7: getMatriu");
		System.out.println("8: getMatriuOriginal");
		System.out.println("9: resetMatriu");
		System.out.println("10: teSolucio");
		System.out.println("11: getTipusAdjacencia");
		System.out.println("12: getTipusCella");
		System.out.println("13: posicioValida");
		
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
