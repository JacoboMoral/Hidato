package tests.drivers.HidatoQuadrat;

import main.domain.com.hidato.TipusAdjacencia;

public class DriverHidatoQuadrat {
	
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
				driverMoviment();
				break;
			case 3:
				driverGetNombresPerDefecte();
				break;
			default:
		}
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
		if(matriu[0].length == hidato.getNombreFiles()) System.out.println("Driver getNombreColumnes executat correctament!");
		else System.out.println("Ha sorgit un problema. Driver getNombreColumnes executat sense exit.");
		System.out.println();
		System.out.println();		
	}
	
	private static void llistaTests() {
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
	
	private static TipusAdjacencia stringToTipusAdjacencia(String ta) {
		if (ta.equalsIgnoreCase("Costats")) return TipusAdjacencia.COSTATS;
		if (ta.equalsIgnoreCase("Ambdos")) return TipusAdjacencia.COSTATSIANGLES;
		return null;
	}
}
