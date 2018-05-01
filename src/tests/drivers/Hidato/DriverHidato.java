package tests.drivers.Hidato;

import java.util.Scanner;
import java.util.Vector;

import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.Hidato;
import main.domain.com.hidato.HidatoIO;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;


//hem fet servir una subclasse stub de hidato (HidatoStub), canviant la part on cridava
//a la classe algorismes, i canviant aquesta per un stub d'algorismes, per
//poder provar la classe sense dependències
public class DriverHidato {
	private static int numeroTests = 12;
	private static int[][] matriu = new int[][] {
		{1,-1,-1},
		{0,11,-1},
		{0,0,0},
		{0,-1,8},
		{5,0,0}
	};
	static Vector<Integer> v = new Vector<Integer>(4);
	
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
				driverAutogenerarAmbDificultat();
				llistaTests();
				break;
			case 3:
				driverMoviment();
				llistaTests();
				break;
			case 4:
				driverGetNombresPerDefecte();
				llistaTests();
				break;
			case 5:
				driverGetNombreFiles();
				llistaTests();
				break;
			case 6:
				driverGetNombreColumnes();
				llistaTests();
				break;
			case 7:
				driverGetMatriu();
				llistaTests();
				break;
			case 8:
				driverGetMatriuOriginal();
				llistaTests();
				break;
			case 9:
				driverResetMatriu();
				llistaTests();
				break;
			case 10:
				driverGetSolucio();
				llistaTests();
				break;
			case 11:
				driverTeSolucio();
				llistaTests();
				break;
			case 12:
				driverGetTipusAdjacencia();
				llistaTests();
				break;
			case 13:
				driverGetDificultat();
				llistaTests();
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
		System.out.println("Has escollit provar el metode getNombreFiles");
		System.out.println();
		Hidato hidato = new HidatoStub(TipusAdjacencia.COSTATS, matriu);
		System.out.println("S'ha hagut de crear una instancia d'hidato amb la seguent matriu: ");
		HidatoIO.writeHidatoMatrixToOutput(matriu);
		System.out.println();
		System.out.println("S'espera que el numero de files sigui: " + matriu.length);
		System.out.println("El numero de files al fer GetnombreFiles es: " + hidato.getNombreFiles());
		System.out.println();
		if(matriu.length == hidato.getNombreFiles()) System.out.println("Driver GetNombreFiles executat correctament!");
		else System.out.println("Ha sorgit un problema. Driver getNombreFiles executat sense exit.");
		System.out.println();
		System.out.println();
	}

	private static void driverGetNombreColumnes() {
		System.out.println("Has escollit provar el metode getNombreColumnes");
		System.out.println();
		Hidato hidato = new HidatoStub(TipusAdjacencia.COSTATS, matriu);
		System.out.println("S'ha hagut de crear una instancia d'hidato amb la seguent matriu: ");
		HidatoIO.writeHidatoMatrixToOutput(matriu);
		System.out.println();
		System.out.println("S'espera que el numero de columnes sigui: " + matriu[0].length);
		System.out.println("El numero de columnes al fer Columnes es: " + hidato.getNombreColumnes());
		System.out.println();
		if(matriu[0].length == hidato.getNombreColumnes()) System.out.println("Driver getNombreColumnes executat correctament!");
		else System.out.println("Ha sorgit un problema. Driver getNombreColumnes executat sense exit.");
		System.out.println();
		System.out.println();		
	}

	private static void driverGetMatriu() {
		System.out.println("Has escollit provar el metode GetMatriu");
		System.out.println();
		Hidato hidato = new HidatoStub(TipusAdjacencia.COSTATS, matriu);
		System.out.println("S'ha hagut de crear una instancia d'hidato amb la seguent matriu: ");
		HidatoIO.writeHidatoMatrixToOutput(matriu);
		System.out.println();
		int[][] matriuRetornada = hidato.getMatriu();
		System.out.println("La matriu esperada es:");
		HidatoIO.writeHidatoMatrixToOutput(matriu);
		System.out.println("La matriu obtinguda es:");
		HidatoIO.writeHidatoMatrixToOutput(matriuRetornada);
		System.out.println("Comprovacio de igualtat: " + java.util.Arrays.deepEquals(matriu, matriuRetornada));
		System.out.println();
		if(java.util.Arrays.deepEquals(matriu, matriuRetornada)) System.out.println("Driver GetMatriu executat correctament!");
		else System.out.println("Ha sorgit un problema. Driver GetMatriu executat sense exit");
		System.out.println();
		System.out.println();
	}

	private static void driverGetMatriuOriginal() {
		System.out.println("Has escollit provar el metode GetMatriuOriginal");
		System.out.println();
		Hidato hidato = new HidatoStub(TipusAdjacencia.COSTATS, matriu);
		System.out.println("S'ha hagut de crear una instancia d'hidato amb la seguent matriu: ");
		HidatoIO.writeHidatoMatrixToOutput(matriu);
		System.out.println();
		int[][] matriuRetornada = hidato.getMatriuOriginal();
		System.out.println("La matriu esperada es:");
		HidatoIO.writeHidatoMatrixToOutput(matriu);
		System.out.println("La matriu obtinguda es:");
		HidatoIO.writeHidatoMatrixToOutput(matriuRetornada);
		System.out.println("Comprovacio de igualtat: " + java.util.Arrays.deepEquals(matriu, matriuRetornada));
		System.out.println();
		if(java.util.Arrays.deepEquals(matriu, matriuRetornada)) System.out.println("Driver GetMatriuOriginal executat correctament!");
		else System.out.println("Ha sorgit un problema. Driver GetMatriuOriginal executat sense exit");
		System.out.println();
		System.out.println();		
	}

	private static void driverResetMatriu() {
		System.out.println("Has escollit provar el metode ResetMatriu");
		System.out.println();
		Hidato hidato = new HidatoStub(TipusAdjacencia.COSTATS, matriu);
		System.out.println("S'ha hagut de crear una instancia d'hidato amb la seguent matriu: ");
		HidatoIO.writeHidatoMatrixToOutput(matriu);
		System.out.println();
		System.out.println("S'ha hagut de cridar el metode teSolucio, que es precondicio d'aquest");
		hidato.teSolucio();
		
		System.out.println("Per fer reset previament s'ha d'haver fet un moviment");
		System.out.println("Cridem a la funcio fer moviment(1,0,2) on y = 1 x = 0 i col�loquem el nombre 2");
		hidato.moviment(1, 0, 2);
		System.out.println("Per saber com queda la matriu cridem a la funcio get matriu i en retorna la matriu:");
		HidatoIO.writeHidatoMatrixToOutput(hidato.getMatriu());
		
		System.out.println("Ara fem reset");
		hidato.resetMatriu();
		System.out.println("Un cop fem reset la matriu ens queda aix�:");
		int[][] matriuAmbMoviment = hidato.getMatriu();
		HidatoIO.writeHidatoMatrixToOutput(matriuAmbMoviment);

		System.out.println("I ha de ser igual que la matriu amb que hem inicialitzat l'hidato:");
		int[][] matriuOriginal = hidato.getMatriuOriginal();
		HidatoIO.writeHidatoMatrixToOutput(matriuOriginal);
		
		System.out.println("Comprovacio de igualtat: " + java.util.Arrays.deepEquals(matriuOriginal, matriuAmbMoviment));
		System.out.println();
		if(java.util.Arrays.deepEquals(matriuOriginal, matriuAmbMoviment)) System.out.println("Driver hidato executat correctament!");
		else System.out.println("Ha sorgit un problema. Driver hidato executat sense exit");
		System.out.println();
		System.out.println();		
	}

	private static void driverGetSolucio() {
		System.out.println("Has escollit provar el metode getSolucio");
		System.out.println();
		Hidato hidato = new HidatoStub(TipusAdjacencia.COSTATS, matriu);
		System.out.println("S'ha hagut de crear una instancia d'hidato amb la seguent matriu: ");
		HidatoIO.writeHidatoMatrixToOutput(matriu);
		System.out.println();
		int[][] matriuRetornada = hidato.getSolucio();
		System.out.println("La matriu obtinguda es:");
		HidatoIO.writeHidatoMatrixToOutput(matriuRetornada);
		System.out.println("Driver GetMatriuOriginal executat");
		System.out.println();
		System.out.println();	
	}

	private static void driverTeSolucio() {
		System.out.println("Has escollit provar el metode getSolucio");
		System.out.println();
		Hidato hidato = new HidatoStub(TipusAdjacencia.COSTATS, matriu);
		System.out.println("S'ha hagut de crear una instancia d'hidato amb la seguent matriu: ");
		HidatoIO.writeHidatoMatrixToOutput(matriu);
		System.out.println();
		System.out.println("El hidato es solucionable?: " + hidato.teSolucio());
		System.out.println("Driver GetMatriuOriginal executat");
		System.out.println();
		System.out.println();			
	}

	private static void driverGetTipusAdjacencia() {
		System.out.println("Has escollit provar el metode getTipusAdjacencia");
		boolean error = false;
		System.out.println();
		Hidato hidato = new HidatoStub(TipusAdjacencia.COSTATS);
		System.out.println("S'ha hagut de crear una instancia d'hidato amb tipusAdjacencia COSTATS ");
		System.out.println();
		System.out.println("El tipus d'Adjacencia es: " + hidato.getTipusAdjacencia());
		if(hidato.getTipusAdjacencia() != TipusAdjacencia.COSTATS) error = true;
		
		System.out.println();
		Hidato hidato2 = new HidatoStub(TipusAdjacencia.COSTATSIANGLES);
		System.out.println("S'ha hagut de crear una instancia d'hidato amb tipusAdjacencia COSTATSIANGLES ");
		System.out.println();
		System.out.println("El tipus d'Adjacencia es: " + hidato2.getTipusAdjacencia());
		if(hidato2.getTipusAdjacencia() != TipusAdjacencia.COSTATSIANGLES) error = true;
		System.out.println();
		if(!error)System.out.println("Driver getTipusAdjacencia executat correctament");
		else System.out.println("Ha sorgit un problema. Driver getTipusAdjacencia executat sense exit");
		System.out.println();
		System.out.println();			
	}

	private static void driverGetDificultat() {
		System.out.println("Has escollit provar el metode getDificultat");
		System.out.println();
		Hidato hidato = new HidatoStub(TipusAdjacencia.COSTATS, matriu);
		System.out.println("S'ha hagut de crear una instancia d'hidato amb la seguent matriu: ");
		HidatoIO.writeHidatoMatrixToOutput(matriu);
		System.out.println();
		System.out.println("La dificultat esperada d'aquesta Matriu es: " + Dificultat.FACIL);
		System.out.println("La didficultat d'aquesta matriu es: " + hidato.getDificultat());
		System.out.println();
		if(Dificultat.FACIL == hidato.getDificultat()) System.out.println("Driver GetDificultat executat correctament!");
		else System.out.println("Ha sorgit un problema. Driver getDificultat executat sense exit.");
		System.out.println();
		System.out.println();		
	}

	private static void driverGetNombresPerDefecte() {
		System.out.println("Has escollit provar el metode autogenerar");
		System.out.println();
		System.out.println("Per aixo creem un hidato de tipus quadrat amb adjacencia per costats amb la seg�ent matriu:");
		Hidato hidato = new HidatoStub(TipusAdjacencia.COSTATS, matriu);
		HidatoIO.writeHidatoMatrixToOutput(matriu);
		v.add(1);
    	v.add(5);
    	v.add(8);
    	v.add(11);
		System.out.println("S'ha cridat el metode teSolucio, que es precondicio d'aquest metode");
		hidato.teSolucio(); // aquesta funcio es precondicio, ja que es crida sempre quan es crea un hidato
    	Vector<Integer> nombresPerDefecte =  hidato.getNombresPerDefecte();
    	System.out.println("S'espera obtenir el seguent vector: ");
		System.out.println(v+"\n");
		System.out.println("Vector obtingut: ");
		System.out.println(nombresPerDefecte);
		boolean comprovacio = v.equals(nombresPerDefecte);
		System.out.println("Comprovacio de igualtat dels dos: " + comprovacio);
		System.out.println();
		if (comprovacio) System.out.println("Driver GetNombresPerDefecte executat correctament!");
		else System.out.println("Ha sorgit un problema. Driver getNombrePerDefecte executat sense exit.");
		System.out.println();
		System.out.println();
	}

	private static void driverAutogenerar() {
		System.out.println("Has escollit provar el metode autogenerar");
		System.out.println();
		System.out.println("Per aixo haurem de crear un hidato sense matriu. Ens donara igual el tipus de casella, ja que no ho necessitarem");
		System.out.println();
		System.out.println("Digues el tipus d'adjacencia:");
		int req = -1;
		TipusAdjacencia tipusAdjacencia = null;
		while ((req != 1 && req != 2)) {
			System.out.println("[1 = Costats; 2 = Costats i angles (nomes quadrat)]");
			req = getNumero();
		}
		tipusAdjacencia = intToTipusAdjacencia(req);
		
		Hidato hidato = null;
		if (tipusAdjacencia == TipusAdjacencia.COSTATS) hidato = new HidatoStub(TipusAdjacencia.COSTATS);
		else hidato = new HidatoStub(TipusAdjacencia.COSTATSIANGLES);
		System.out.println("\nJa s'ha creat l'hidato escollit buit (sense matriu), per crear-ne d'una, digues les caracteristiques de l'hidato\n");
		int caract[] = null;
		while (caract == null || caract[0] < 2 || caract[1] < 2 || (caract[2] < 0 || caract[2] >= caract[0]*caract[1]/2)) {
			System.out.println("Posa-ho de la seguent manera: [i j f] (i = altura (minim 2); j = amplada (minim 2), f = nombre de forats(no pot ser mes gran o igual que la meitat de caselles))\n");
			caract = getNumeros(3);
		}
		if(hidato.autogenerar(caract[0], caract[1], caract[2])) {
			System.out.println("Autogenerat amb exit");	
			System.out.println("L'hidato generat es el seguent (tingues en compte que prove d'un stub)");
			HidatoIO.writeHidatoMatrixToOutput(hidato.getMatriu());
			System.out.println();
			System.out.println("Driver autogenerar finalitzat");
		}
		else {
			System.out.println("Ha sorgit un problema. Driver Autogenerar executat sense exit");
		}
		System.out.println();
		System.out.println();
	}
	
	private static void driverAutogenerarAmbDificultat() {
		System.out.println("Has escollit provar el metode autogenerarAmbDificultat");
		System.out.println();
		System.out.println("Per aixo haurem de crear un hidato sense matriu. Ens donara igual el tipus de casella, ja que no ho necessitarem");
		System.out.println();
		
		System.out.println("Digues el tipus d'adjacencia:");
		int req = -1;
		TipusAdjacencia tipusAdjacencia = null;
		while ((req != 1 && req != 2)) {
			System.out.println("[1 = Costats; 2 = Costats i angles (nomes quadrat)]");
			req = getNumero();
		}
		tipusAdjacencia = intToTipusAdjacencia(req);
		
		Hidato hidato = null;
		if (tipusAdjacencia == TipusAdjacencia.COSTATS) hidato = new HidatoStub(TipusAdjacencia.COSTATS);
		else hidato = new HidatoStub(TipusAdjacencia.COSTATSIANGLES);
		System.out.println("\nJa s'ha creat l'hidato escollit buit (sense matriu), per crear-ne d'una, digues la dificultat\n");
		int dif = -1;
		while (dif < 1 || dif > 3) {
			System.out.println("[1 = FACIL; 2 = MIG, 3 = DIFICIL]\n");
			dif = getNumero();
		}
		Dificultat dificultat = intToDificultat(dif);
		if(hidato.autogenerar(dificultat)) {
			System.out.println("Autogenerat amb exit");	
			System.out.println("L'hidato generat es el seguent (tingues en compte que prove d'un stub)");
			HidatoIO.writeHidatoMatrixToOutput(hidato.getMatriu());
			System.out.println();
			System.out.println("Driver autogenerar finalitzat");
		}
		else {
			System.out.println("Ha sorgit un problema. Driver Autogenerar executat sense exit");
		}
		System.out.println();
		System.out.println();
	}
	
	private static void llistaTests() {
		System.out.println();
		System.out.println("exit: Sortir del driver");
		System.out.println("1: Autogenerar");
		System.out.println("2: Autogenerar amb dificultat");
		System.out.println("3: Moviment");
		System.out.println("4: GetNombresPerDefecte");
		System.out.println("5: getNombreFiles");
		System.out.println("6: getNombreColumnes");
		System.out.println("7: getMatriu");
		System.out.println("8: getMatriuOriginal");
		System.out.println("9: resetMatriu");
		System.out.println("10: getSolucio");
		System.out.println("11: teSolucio");
		System.out.println("12: getTipusAdjacencia");
		System.out.println("13: getDificultat");
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

	private static Dificultat intToDificultat(int i) {
		if (i == 3) return Dificultat.DIFICIL;
		if (i == 2) return Dificultat.MIG;
		if (i == 1) return Dificultat.FACIL;
		return null;
	}
	
	private static TipusAdjacencia intToTipusAdjacencia(int ta) {
		if (ta == 1) return TipusAdjacencia.COSTATS;
		if (ta == 2) return TipusAdjacencia.COSTATSIANGLES;
		return null;
	}
}
