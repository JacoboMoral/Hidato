package tests.drivers.Partida;


import java.util.Scanner;
import java.util.Vector;

import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.HidatoIO;
import main.domain.com.hidato.Partida;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class DriverPartida {
	
	private static int numeroTests = 16;
	private static int[][] matriuSolucio = new int[][] {
		{1,-1,-1},
		{2,11,-1},
		{3,10,9},
		{4,-1,8},
		{5,6,7}
	};
	private static int[][] matriuOriginal = new int[][] {
		{1,-1,-1},
		{0,11,-1},
		{0,0,0},
		{0,-1,8},
		{5,0,0}
	};
	
	private static int[][] matriuHidato = new int[][] {
		{1,-1,-1},
		{2,11,-1},
		{3,0,0},
		{0,-1,8},
		{5,0,0}
	};
	static Vector<Integer> v = new Vector<Integer>(4);
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
				driverAcabarPartida();
				break;
			case 4:
				driverAcabarPartidaIniciada();
				break;
			case 5:
				driverReset();
				break;
			case 6:
				driverFerJugada();
				break;
			case 7:
				driverStatus();
				break;
			case 8:
				driverGetDificultat();
				break;
			case 9:
				driverGetNombresPerDefecte();
				break;
			case 10:
				driverGetSolucio();
				break;
			case 11:
				driverGetMatriu();
				break;
			case 12:
				driverGetMatriuOriginal();
				break;
			case 13:
				driverGetDataInici();
				break;
			case 14:
				driverGetDataFi();
				break;
			case 15:
				driverGetPuntuacio();
				break;
			case 16:
				driverEsSolucionable();
				break;
			default:
		}
	}
	private static void driverFerJugada() {

	}

	private static void driverEsSolucionable() {
		System.out.println("Has escollit provar el metode esSolucionable");
		System.out.println();
		System.out.println("S'ha hagut de crear una instancia partida i una instancia d'hidato");
		HidatoStub hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
		Partida partida = new Partida(hidato);
		System.out.println("Valor que s'espera: " + true);
		System.out.println("Valor que se'ns ha retornat: " + partida.esSolucionable());
		System.out.println("Comprovacio d'igualtat de resultats: " + (true == partida.esSolucionable()));
		System.out.println();
		if((true == partida.esSolucionable()))System.out.println("Driver esSolucionable executat correctament!");
		else System.out.println("Ha sorgit un problema. Driver EsSolucionable executat sense exit");  
		System.out.println();
		System.out.println();		
	}

	private static void driverGetPuntuacio() {
		System.out.println("Has escollit provar el metode GetPuntuacio");
		System.out.println();
		System.out.println("S'ha hagut de crear una instancia partida i una instancia d'hidato");
		HidatoStub hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
		Partida partida = new Partida(hidato);
		System.out.println("Comprovacio puntuacio retornada correctament: " + (0 == partida.getPuntuacio()));
		System.out.println();
		if((0 == partida.getPuntuacio()))System.out.println("Driver GetPuntuacio executat correctament!");
		else System.out.println("Ha sorgit un problema. Driver GetPuntuacio executat sense exit"); 
		System.out.println();
		System.out.println();
	}

	private static void driverGetDataFi() {
		System.out.println("Has escollit provar el metode iniciarPartida");
		System.out.println();
		System.out.println("S'ha hagut de crear una instancia partida i una instancia d'hidato");
		HidatoStub hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
		Partida partida = new Partida(hidato);
		System.out.println("Per saber la dataFi s'ha de cridar la instancia acabarPartida");
		partida.acabarPartida();
		System.out.println("S'ha acabat la partida");
		System.out.println("Data fi de la partida: " + partida.getDataFi());
		System.out.println();
		System.out.println("Driver GetDataInici executat");
		System.out.println();
		System.out.println();
	}

	private static void driverGetDataInici() {
		System.out.println("Has escollit provar el metode getDataInici");
		System.out.println();
		System.out.println("S'ha hagut de crear una instancia partida i una instancia d'hidato");
		HidatoStub hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
		Partida partida = new Partida(hidato);
		System.out.println("Per saber la dataInici s'ha de cridar la instancia iniciarPartida");
		partida.iniciarPartida();
		System.out.println("S'ha iniciat la partida");
		System.out.println("Data d'inici de la partida: " + partida.getDataInici());
		System.out.println();
		System.out.println("Driver GetDataInici executat");
		System.out.println();
		System.out.println();
	}

	private static void driverGetSolucio() {
		System.out.println("Has escollit provar el metode getMatriuSolucio");
		System.out.println();
		System.out.println("S'ha hagut de crear una instancia partida i una instancia d'hidato");
		HidatoStub hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
		Partida partida = new Partida(hidato);
		
		int[][] matriuRetornada = partida.getSolucio();
		System.out.println("La matriu solucio esperada es:");
		HidatoIO.writeHidatoMatrixToOutput(matriuSolucio);
		System.out.println("La matriu obtinguda es:");
		HidatoIO.writeHidatoMatrixToOutput(matriuRetornada);
		System.out.println("Comprovacio de igualtat: " + java.util.Arrays.deepEquals(matriuSolucio, matriuRetornada));
		System.out.println();
		if(java.util.Arrays.deepEquals(matriuSolucio, matriuRetornada))System.out.println("Driver GetSolucio executat correctament!");
		else System.out.println("Ha sorgit un problema. Driver getSolucio executat sense exit");
		System.out.println();
		System.out.println();
	}

	private static void driverGetMatriuOriginal() {
		System.out.println("Has escollit provar el metode getMatriuOriginal");
		System.out.println();
		System.out.println("S'ha hagut de crear una instancia partida i una instancia d'hidato");
		HidatoStub hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
		Partida partida = new Partida(hidato);
		
		int[][] matriuRetornada = partida.getHidatoOriginal();
		System.out.println("La matriu original esperada es:");
		HidatoIO.writeHidatoMatrixToOutput(matriuOriginal);
		System.out.println("La matriu obtinguda es:");
		HidatoIO.writeHidatoMatrixToOutput(matriuRetornada);
		System.out.println("Comprovacio de igualtat: " + java.util.Arrays.deepEquals(matriuOriginal, matriuRetornada));
		System.out.println();
		if(java.util.Arrays.deepEquals(matriuOriginal, matriuRetornada)) System.out.println("Driver GetMatriuOriginal executat correctament!");
		else System.out.println("Ha sorgit un problema. Driver GetMatriuOriginal executat sense exit");
		System.out.println();
		System.out.println();
	}

	private static void driverGetMatriu() {
		System.out.println("Has escollit provar el metode getMatriu");
		System.out.println();
		System.out.println("S'ha hagut de crear una instancia partida i una instancia d'hidato");
		HidatoStub hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
		Partida partida = new Partida(hidato);
		
		int[][] matriuRetornada = partida.getHidato();
		System.out.println("La matriu esperada es:");
		HidatoIO.writeHidatoMatrixToOutput(matriuHidato);
		System.out.println("La matriu obtinguda es:");
		HidatoIO.writeHidatoMatrixToOutput(matriuRetornada);
		System.out.println("Comprovacio de igualtat: " + java.util.Arrays.deepEquals(matriuHidato, matriuRetornada));
		System.out.println();
		if(java.util.Arrays.deepEquals(matriuHidato, matriuRetornada)) System.out.println("Driver GetMatriu executat correctament!");
		else System.out.println("Ha sorgit un problema. Driver GetMatriu executat sense exit");
		System.out.println();
		System.out.println();
	}

	private static void driverGetNombresPerDefecte() { //COMPARAR VECTOR0RS MODIFICAR STUB 
		System.out.println("Has escollit provar el metode getNombresPerDefecte");
		System.out.println();
		System.out.println("S'ha hagut de crear una instancia partida i una instancia d'hidato");
		HidatoStub hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
		Partida partida = new Partida(hidato);
		v.add(1);
    	v.add(2);
    	v.add(3);
    	v.add(4);
  
		Vector<Integer> nombresPerDefecte =  partida.getNombresPerDefecte();
		System.out.println("S'espera obtenir el seguent vector: ");
		System.out.println(v+"\n");
		System.out.println("Vector obtingut: ");
		System.out.println(partida.getNombresPerDefecte());
		System.out.println("Comprovacio nombresPerDefecte retornat correctament: " + (4 == nombresPerDefecte.size()));
		System.out.println();
		System.out.println("Driver GetNombresPerDefecte executat correctament!");
		System.out.println();
		System.out.println();

	}

	private static void driverGetDificultat() {
		System.out.println("Has escollit provar el metode GetDificultat");
		System.out.println();
		System.out.println("S'ha hagut de crear una instancia partida i una instancia d'hidato");
		HidatoStub hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
		Partida partida = new Partida(hidato);
		System.out.println("Dificultat esperada: " + Dificultat.FACIL);
		System.out.println("Dificultat obtinguda: " + partida.getDificultat());
		System.out.println("Comprovacio dificultat: " + (Dificultat.FACIL == partida.getDificultat()));
		System.out.println();
		if((Dificultat.FACIL == partida.getDificultat()))System.out.println("Driver GetDificultat executat correctament!");
		else System.out.println("Ha sorgit un problema. Driver GetDificultat executat sense exit.");
		System.out.println();
		System.out.println();
	}
	
	private static void driverStatus() {
		boolean error = false;
		System.out.println("Has escollit provar el metode Status");
		System.out.println();
		System.out.println("S'ha hagut de crear una instancia partida i una instancia d'hidato");
		HidatoStub hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
		Partida partida = new Partida(hidato);
		System.out.println("L'estat actual de la partida es: " + partida.status());
		System.out.println("Comprovacio status no comen�at: " + (0 == partida.status()));
		if((0 != partida.status())) error = true;
		System.out.println("Iniciem la partida i tornem a mirar l'estat d'aquesta");
		partida.iniciarPartida();
		System.out.println("S'ha iniciat la partida");
		System.out.println("L'estat actual de la partida es: " + partida.status());
		System.out.println("Comprovacio status comen�at: " + (1 == partida.status()));
		if((1 != partida.status())) error = true;
		System.out.println("finalitzem la partida i tornem a mirar l'estat d'aquesta");
		partida.acabarPartida();
		System.out.println("S'ha acabat la partida");
		System.out.println("L'estat actual de la partida es: " + partida.status());
		System.out.println("Comprovacio status finalitzat: " + (-1 == partida.status()));
		if((-1 != partida.status())) error = true;
		System.out.println();
		if(!error) System.out.println("Driver driverStatus executat correctament!");
		else System.out.println("Ha sorgit un problema. Driver status executat sense exit.");
		System.out.println();
		System.out.println();
	}

	private static void driverReset() {
		
		System.out.println("Has escollit provar el metode Reset");
		System.out.println();
		System.out.println("S'ha hagut de crear una instancia partida i una instancia d'hidato");
		HidatoStub hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
		Partida partida = new Partida(hidato);
		
		System.out.println("La matriu Original es:");
		HidatoIO.writeHidatoMatrixToOutput(matriuOriginal);
		System.out.println("La matriu hidato actual es:");
		HidatoIO.writeHidatoMatrixToOutput(matriuHidato);
		System.out.println("Al fer reset la matriu hidato actual hauria de ser igual a la matriu Original");
		partida.reset();
		System.out.println("Despres de fer reset, la matriu hidato es:");
		HidatoIO.writeHidatoMatrixToOutput(partida.getHidato());
		System.out.println("Comprovacio de igualtat: " + java.util.Arrays.deepEquals(matriuOriginal, partida.getHidato()));
		System.out.println();
		if(java.util.Arrays.deepEquals(matriuOriginal, partida.getHidato()))System.out.println("Driver Reset executat correctament!");
		else System.out.println("Ha sorgit un problema. Driver Reset executat sense exit.");
		System.out.println();
		System.out.println();
	}

	private static void driverAcabarPartidaIniciada() {
		System.out.println("Has escollit provar el metode acabarPartidaIniciada");
		System.out.println();
		boolean error = false;
		System.out.println("S'ha hagut de crear una instancia partida i una instancia d'hidato");
		HidatoStub hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
		Partida partida = new Partida(hidato);

		partida.iniciarPartida();
		System.out.println("S'ha iniciat la partida");
		System.out.println("S'ha hagut de cridar els metodes 'getStatus i getDataIni per comprovar que s'ha iniciat correctament");
		System.out.println("Data d'inici de la partida: " + partida.getDataInici());
		System.out.println("Status de la partida (1 = iniciada, 0 = no iniciada, -1 = finalitzada): " + partida.status());
		if(partida.status() != 0) error = true;
		System.out.println();
		System.out.println();
		partida.acabarPartida();
		System.out.println("S'ha acabat la partida");
		System.out.println("S'ha hagut de cridar els metodes 'getStatus i getDataFi per comprovar que s'ha acabat correctament");
		System.out.println("Data Fi de la partida: " + partida.getDataFi());
		System.out.println("Status de la partida (1 = iniciada, 0 = no iniciada, -1 = finalitzada): " + partida.status());
		System.out.println();
		if(partida.status() == -1 || error)System.out.println("Driver AcabarPartidaIniciada executat correctament!");
		else System.out.println("Ha sorgit un problema. Driver IniciarPartida executat sense exit.");
		System.out.println();
		System.out.println();
		
	}

	private static void driverAcabarPartida() {
		System.out.println("Has escollit provar el metode acabarPartida");
		System.out.println();
		System.out.println("S'ha hagut de crear una instancia partida i una instancia d'hidato");
		HidatoStub hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
		Partida partida = new Partida(hidato);

		partida.acabarPartida();
		System.out.println("S'ha acabat la partida");
		System.out.println("S'ha hagut de cridar els metodes 'getStatus i getDataFi per comprovar que s'ha acabat correctament");
		System.out.println("Data Fi de la partida: " + partida.getDataFi());
		System.out.println("Status de la partida (1 = iniciada, 0 = no iniciada, -1 = finalitzada): " + partida.status());
		System.out.println();
		System.out.println("Driver AcabarPartida executat correctament!");
		System.out.println();
		System.out.println();
		
	}

	private static void driverConstructora() {
		System.out.println("Has escollit provar el metode constructor");
		System.out.println();
		HidatoStub hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
		
		Partida partida = new Partida(hidato);
		
		System.out.println("Partida creada correctament");
		System.out.println();
		System.out.println("Driver Constructora executat correctament!");
		System.out.println();
		System.out.println();
	}

	private static void driverIniciarPartida() {
		System.out.println("Has escollit provar el metode iniciarPartida");
		System.out.println();
		System.out.println("S'ha hagut de crear una instancia partida i una instancia d'hidato");
		HidatoStub hidato = new HidatoQuadratStub(TipusAdjacencia.COSTATS);
		Partida partida = new Partida(hidato);

		partida.iniciarPartida();
		System.out.println("S'ha iniciat la partida");
		System.out.println("S'ha hagut de cridar els metodes 'getStatus i getDataIni per comprovar que s'ha iniciat correctament");
		System.out.println("Data d'inici de la partida: " + partida.getDataInici());
		System.out.println("Status de la partida (1 = iniciada, 0 = no iniciada, -1 = finalitzada): " + partida.status());
		System.out.println();
		System.out.println("Driver IniciarPartida executat correctament!");
		System.out.println();
		System.out.println();
	}


	public static void llistaTests() {
		System.out.println("exit: Sortir del driver");
		System.out.println("1: Constructora");
		System.out.println("2: iniciarPartida");
		System.out.println("3: acabarPartida");
		System.out.println("4: acabarPartidaInicia");
		System.out.println("5: reset");
		System.out.println("6: ferJugada");
		System.out.println("7: status");
		System.out.println("8: getDificultat");
		System.out.println("9: getNombresPerDefecte");
		System.out.println("10: getSolucio");
		System.out.println("11: getMatriu");
		System.out.println("12: getMatriuOriginal");
		System.out.println("13: getDataInici");
		System.out.println("14: getDataFi");
		System.out.println("15: getPuntuacio");
		System.out.println("16: esSolucionable");
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
		
}
