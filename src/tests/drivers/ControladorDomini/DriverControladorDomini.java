package tests.drivers.ControladorDomini;

import java.util.ArrayList;
import java.util.Scanner;

import main.domain.com.hidato.ControladorDomini;
import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.HidatoIO;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

//no es ben be un driver. Esta fet a proposit per poder controlar totes les funcionalitats que te el nostre programa fins ara sense
//utilitzar valors retornats trivialment
public class DriverControladorDomini {
	private static int numeroTests = 11;
	private static ControladorDomini controladorDomini;
	
    public static void main(String[] args) throws Exception{
		System.out.println("Aquest es el driver de de Controlador de Domini, indica quina funcio vols provar");
		controladorDomini = new ControladorDomini();
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
				driverJugarHidatoImportat();
				llistaTests();
				break;
			case 2:
				driverJugarHidatoGenerat();
				llistaTests();
				break;
			case 3:
				driverAutoGenerar();
				llistaTests();
				break;
			case 4:
				drivergetMatriuHidatoOriginalDePartida();
				llistaTests();
				break;
			case 5:
				driverGetMatriuHidatoDePartida();
				llistaTests();
				break;
			case 6:
				driverSolucionarHidatoPartida();
				llistaTests();
				break;
			case 7:
				driverSolucionarHidatoGenerat();
				llistaTests();
				break;
			case 8:
				driverGetMatriuHidatoGenerat();
				llistaTests();
				break;
			case 9:
				driverGetNombresPerDefecte();
				llistaTests();
				break;
			case 10:
				driverFerMoviment();
				llistaTests();
				break;
			case 11:
				driverEnPartida();
				llistaTests();
				break;
			default:
		}
	}

	private static void driverFerMoviment() {
		// TODO Auto-generated method stub
		
	}

	private static void driverGetMatriuHidatoDePartida() {
		System.out.println("Has escollit provar el metode getMatriuHidatoDePartida");
		boolean enPartida = controladorDomini.enPartida();
		if (enPartida == false) {
			System.out.println("Oops, es veu que no estas en partida, hauras de cridar els metodes jugarHidatoGenerat o jugarHidatoImportat");
		}
		else {
			System.out.println("Aquest es l'hidato actual de la partida:");
			HidatoIO.writeHidatoMatrixToOutput(controladorDomini.getMatriuHidatoDePartida());
		}	
	}

	private static void drivergetMatriuHidatoOriginalDePartida() {
		System.out.println("Has escollit provar el metode getMatriuHidatoOriginalDePartida");
		boolean enPartida = controladorDomini.enPartida();
		if (enPartida == false) {
			System.out.println("Oops, es veu que no estas en partida, hauras de cridar els metodes jugarHidatoGenerat o jugarHidatoImportat");
		}
		else {
			System.out.println("Aquest es l'hidato original de la partida:");
			HidatoIO.writeHidatoMatrixToOutput(controladorDomini.getMatriuHidatoOriginalDePartida());
		}		
	}

	private static void driverSolucionarHidatoPartida() {
		System.out.println("Has escollit provar el metode solucionarHidatoPartida");
		boolean enPartida = controladorDomini.enPartida();
		if (enPartida == false) {
			System.out.println("Oops, es veu que no estas en partida, hauras de cridar els metodes jugarHidatoGenerat o jugarHidatoImportat");
		}
		else {
			System.out.println("Aquesta es la solucio de l'hidato de la partida en curs");
			HidatoIO.writeHidatoMatrixToOutput(controladorDomini.solucionarHidatoPartida());
		}				
	}

	private static void driverSolucionarHidatoGenerat() {
		System.out.println("Has escollit provar el metode solucionarHidatoGenerat");
		System.out.println("Passem a obtenir l'hidato previament generat");
		int[][] solucioHidatoGenerat = controladorDomini.solucionarHidatoGenerat();
		if (solucioHidatoGenerat == null) {
			System.out.println("Oops, es veu que no havies generat un hidato anteriorment, ho vols fer ara? (yes/no)");
			String s = readLine();
			while (!s.equalsIgnoreCase("yes") && !s.equalsIgnoreCase("no")) {
				s = readLine();
			}
			if (s.equalsIgnoreCase("yes")) {
				System.out.println("Cridant driverAutoGenerar...\n\n");
				driverAutoGenerar();
			}
		}
		else {
			solucioHidatoGenerat = controladorDomini.solucionarHidatoGenerat();
			System.out.println("Aquesta es la solucio de l'hidato que havies generat:");
			HidatoIO.writeHidatoMatrixToOutput(solucioHidatoGenerat);
		}		
	}

	private static void driverGetMatriuHidatoGenerat() {
		System.out.println("Has escollit provar el metode getMatriuHidatoGenerat");
		System.out.println("Passem a obtenir l'hidato previament generat");
		int[][] hidatoGenerat = controladorDomini.getMatriuHidatoGenerat();
		if (hidatoGenerat == null) {
			System.out.println("Oops, es veu que no havies generat un hidato anteriorment, ho vols fer ara? (yes/no)");
			String s = readLine();
			while (!s.equalsIgnoreCase("yes") && !s.equalsIgnoreCase("no")) {
				s = readLine();
			}
			if (s.equalsIgnoreCase("yes")) {
				System.out.println("Cridant driverAutoGenerar...\n\n");
				driverAutoGenerar();
			}
		}
		else {
			System.out.println("Aquest es l'hidato que havies generat:");
			HidatoIO.writeHidatoMatrixToOutput(hidatoGenerat);
		}
	}

	private static void driverAutoGenerar() {
		System.out.println("Has escollit provar el metode autoGenerar");
		System.out.println("Si us plau, escull como vols generar un hidato, donant les seves caracteristiques o la seva dificultat\n");
		boolean generatCorrectament = false;
		int tipus = -1;
		while (tipus < 1 || tipus > 2) {
			System.out.println("[1 = caracteristiques; 2 = dificultat]\n");
			tipus = getNumero();
		}
		if (tipus == 1) {
			System.out.println("A continuacio digues les caracteristiques de l'hidato\n");
			System.out.println("Digues el tipus de cella:");
			int req = -1;
			TipusCella tipusCella = null;
			while (req != 1 && req != 2) {
				System.out.println("[1 = Quadrat; 2 = Triangle; 3 = Hexagon]");
				req = getNumero();
			}
			tipusCella = intToTipusCella(req);
			
			System.out.println("\nDigues el tipus d'adjacencia:");
			req = -1;
			TipusAdjacencia tipusAdjacencia = null;
			while (req != 1 && req != 2 || (tipusNoCompatible(tipusCella, tipusAdjacencia))) {
				System.out.println("[1 = Costats; 2 = Costats i angles (nomes quadrat)]");
				req = getNumero();
			}
			tipusAdjacencia = intToTipusAdjacencia(req);
			
			int caract[] = null;
			while (caract == null || caract[0] < 2 || caract[1] < 2 || (caract[2] < 0 || caract[2] >= caract[0]*caract[1]/2)) {
				System.out.println("Posa-ho de la seguent manera: [i j f] (i = altura (minim 2); j = amplada (minim 2), f = nombre de forats(no pot ser mes gran o igual que la meitat de caselles))\n");
				caract = getNumeros(3);
			}
			generatCorrectament = controladorDomini.autoGenerar(tipusCella, tipusAdjacencia, caract[0], caract[1], caract[2]);
		}
		
		else if (tipus == 2) {
			System.out.println("Digues la dificultat per l'hidato");
			int dif = -1;
			while (dif < 1 || dif > 3) {
				System.out.println("[1 = FACIL; 2 = MIG, 3 = DIFICIL]\n");
				dif = getNumero();
			}
			Dificultat dificultat = intToDificultat(dif);
			System.out.println("Vols escollir el tipus de cella?");
			String s = readLine();
			while (!s.equalsIgnoreCase("yes") && !s.equalsIgnoreCase("no")) {
				System.out.println("yes/no\n");
				s = readLine();
			}
			if (s.equalsIgnoreCase("yes")) {
				System.out.println("Molt be, digues quin vols\n");
				int tc = -1;
				while (tc < 1 || tc > 3) {
					System.out.println("[1 = Quadrat; 2 = Triangle, 3 = Hexagon]\n");
					tc = getNumero();
				}
				TipusCella tipusCella = intToTipusCella(tc);
				TipusAdjacencia tipusAdjacencia;
				if (tc == 1) {
					System.out.println("Vols escollir el tipus d'adjacencia?");
					s = readLine();
					while (!s.equalsIgnoreCase("yes") && !s.equalsIgnoreCase("no")) {
						System.out.println("yes/no\n");
						s = readLine();
					}
					if (s.equalsIgnoreCase("yes")) {
						System.out.println("Molt be, digues quina vols\n");
						int ta = -1;
						while (ta < 1 || ta > 3) {
							System.out.println("[1 = Costats; 2 = Costats i angles\n");
							ta = getNumero();
						}
						tipusAdjacencia = intToTipusAdjacencia(ta);
						generatCorrectament = controladorDomini.autoGenerar(tipusCella, tipusAdjacencia, dificultat); //quadrat
					}
					else {
						generatCorrectament = controladorDomini.autoGenerar(tipusCella, dificultat); //quadrat random
					}
				}
				else {
					tipusAdjacencia = TipusAdjacencia.COSTATS;
					controladorDomini.autoGenerar(tipusCella, tipusAdjacencia, dificultat); //triangle/hexagon
				}
			}
			else {
				generatCorrectament = controladorDomini.autoGenerar(dificultat); //random
				
			}
		}
		
		else; //unexpected, en principi no pot passar
		if (generatCorrectament) {
			System.out.println("Molt be, aquest es l'hidato que s'ha generat");
			HidatoIO.writeHidatoMatrixToOutput(controladorDomini.getMatriuHidatoGenerat());
		}
		else System.out.println("No s'ha pogut generar un hidato amb les condicions especificades");
	}

	private static void driverEnPartida() {
		System.out.println("Has escollit provar el metode enPartida");
		boolean enPartida = controladorDomini.enPartida();
		System.out.println("Comprovarem si estem en partida o no (encara que no estigui iniciada):" + enPartida);
		if (enPartida) {
			System.out.println("Hi ha una partida creada");
		}
		else System.out.println("No hi ha cap partida creada");
	}

	private static void driverJugarHidatoImportat() {
		System.out.println("Has escollit provar el metode jugarHidatoImportat");
		TipusCella tipusCella;
		TipusAdjacencia tipusAdjacencia;
		int req = -1;
		while (req != 1 && req != 2) {
			System.out.println("Com vols importar la matriu?: [1 = copyPaste amb el format oficial; 2 = donant els numeros un a un]");
			req = getNumero();
		}
		int matriuHidato[][];
		if (req == 1) {
			System.out.println("Fes copi paste aqui:");
			ArrayList<ArrayList<Integer>> entradaHidato = HidatoIO.readHidatoFromInputClipboard();
			matriuHidato = extreuMatriuHidato(entradaHidato);
			tipusCella = extreuTipusCella(entradaHidato);
			tipusAdjacencia = extreuTipusAdjacencia(entradaHidato);
		}
		else {
			System.out.println("Digues el tipus de cella:");
			req = -1;
			while (req != 1 && req != 2 && req != 3) {
				System.out.println("[1 = Quadrat; 2 = Triangle; 3 = Hexagon]");
				req = getNumero();
			}
			tipusCella = intToTipusCella(req);
			System.out.println("Digues el tipus d'adjacencia:");
			req = -1;
			tipusAdjacencia = null;
			while ((req != 1 && req != 2) || tipusNoCompatible(tipusCella,tipusAdjacencia)) {
				System.out.println("[1 = Costats; 2 = Costats i angles (nomes quadrat)]");
				req = getNumero();
			}
			tipusAdjacencia = intToTipusAdjacencia(req);
			matriuHidato = HidatoIO.readHidatoFromInput1x1();
		}
		boolean resoluble = controladorDomini.jugarHidatoImportat(tipusCella, tipusAdjacencia, matriuHidato);
		System.out.println("S'ha creat una nova partida amb el seguent hidato i s'ha comprovat que es pugui resoldre:");
		HidatoIO.writeHidatoMatrixToOutput(matriuHidato);
		System.out.println("Es pot resoldre?: " + resoluble);
		System.out.println("Comprovem ara que tenim una partida creada...: " + controladorDomini.enPartida());
	}

	private static void driverJugarHidatoGenerat() {
		System.out.println("Has escollit provar el metode jugarHidatoGenerat");
		System.out.println("Passem a obtenir l'hidato previament generat");
		int[][] solucioHidatoGenerat = controladorDomini.solucionarHidatoGenerat();
		if (solucioHidatoGenerat == null) {
			System.out.println("Oops, es veu que no havies generat un hidato anteriorment, ho vols fer ara? (yes/no)");
			String s = readLine();
			while (!s.equalsIgnoreCase("yes") && !s.equalsIgnoreCase("no")) {
				s = readLine();
			}
			if (s.equalsIgnoreCase("yes")) {
				System.out.println("Cridant driverAutoGenerar...\n\n");
				driverAutoGenerar();
			}
		}
		else {
			solucioHidatoGenerat = controladorDomini.solucionarHidatoGenerat();
			System.out.println("Aquest es l'hidato que havies generat:");
			HidatoIO.writeHidatoMatrixToOutput(solucioHidatoGenerat);
			controladorDomini.jugarHidatoGenerat();
			System.out.println("\nS'ha creat una partida amb l'hidato generat");
			System.out.println("\nComprovarem mitjançant el metode enPartida que tot hagi sortit be: " + controladorDomini.enPartida());
		}		
	}
	
	private static void driverGetNombresPerDefecte() {
		System.out.println("Has escollit provar el metode getNombresPerDefecte");
		boolean enPartida = controladorDomini.enPartida();
		if (enPartida == false) {
			System.out.println("Oops, es veu que no estas en partida, hauras de cridar els metodes jugarHidatoGenerat o jugarHidatoImportat");
		}	
		else {
			System.out.println("Recordem la matriu de l'hidato que has escollit:");
			HidatoIO.writeHidatoMatrixToOutput(controladorDomini.getMatriuHidatoDePartida());
			System.out.println("Els nombres que inicialment estaven presents eren:");
			System.out.println(controladorDomini.getNombresPerDefecte());
		}
	}
	
	private static void llistaTests() {
		System.out.println();
		System.out.println("exit: Sortir del driver");
		System.out.println("1: jugarHidatoImportat");
		System.out.println("2: jugarHidatoGenerat");
		System.out.println("3: autoGenerar");
		System.out.println("4: getHidatoOriginalDePartida");
		System.out.println("5: getHidatoDePartida");
		System.out.println("6: solucionarHidatoPartida");
		System.out.println("7: solucionarHidatoGenerat");
		System.out.println("8: getMatriuHidatoGenerat");
		System.out.println("9: getNombresPerDefecte");
		System.out.println("10: ferMoviment");
		System.out.println("11: enPartida");
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

	private static int[] getNumeros(int n) {
		//els numeros han d'estar separats per un espai
		String req = readLine();
		String[] nums = req.split(" ");
		if (nums.length != n) return null;
		int[] numeros = new int[n];
		for (int i = 0; i < n; ++i) {
			if (isNumber(nums[i])) numeros[i] = Integer.parseInt(nums[i]);
		}
		return numeros;
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
	
	private static TipusAdjacencia extreuTipusAdjacencia(ArrayList<ArrayList<Integer>> matriu) {
		if (matriu.get(0).get(1) == 1) return TipusAdjacencia.COSTATS;
		return TipusAdjacencia.COSTATSIANGLES;
	}

	
	private static TipusCella extreuTipusCella(ArrayList<ArrayList<Integer>> matriu) {
		int aux = matriu.get(0).get(0);
		if (aux == 4) return TipusCella.QUADRAT;
		if (aux == 3) return TipusCella.TRIANGLE;
		return TipusCella.HEXAGON;
	}

	private static int[][] extreuMatriuHidato(ArrayList<ArrayList<Integer>> matriu) {
		int[][] matriuHidato = new int[matriu.size()-1][matriu.get(1).size()];
		for (int i = 0; i < matriuHidato.length; ++i) {
			for (int j = 0; j < matriuHidato[1].length; ++j) {
				matriuHidato[i][j] = matriu.get(i+1).get(j);
			}
		}
		return matriuHidato;
	}
	
	private static TipusAdjacencia intToTipusAdjacencia(int ta) {
		if (ta == 1) return TipusAdjacencia.COSTATS;
		if (ta == 2) return TipusAdjacencia.COSTATSIANGLES;
		return null;
	}
	
	private static TipusCella intToTipusCella(int tc) {
		if (tc == 1) return TipusCella.QUADRAT;
		if (tc == 2) return TipusCella.TRIANGLE;
		if (tc == 3) return TipusCella.HEXAGON;
		return null;
	}
	
	private static boolean tipusNoCompatible(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia) {
		return ((tipusCella == TipusCella.HEXAGON && tipusAdjacencia == TipusAdjacencia.COSTATSIANGLES) ||
				tipusCella == TipusCella.TRIANGLE && tipusAdjacencia == TipusAdjacencia.COSTATSIANGLES);
	}
	
	private static Dificultat intToDificultat(int i) {
		if (i == 3) return Dificultat.DIFICIL;
		if (i == 2) return Dificultat.MIG;
		if (i == 1) return Dificultat.FACIL;
		return null;
	}
	
}
