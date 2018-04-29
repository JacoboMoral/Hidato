package tests.drivers.Algorismes;
import java.util.Scanner;

import main.domain.com.hidato.Algorismes;


public class DriverAlgorismes {
	private static int numeroTests = 7;
	
    public static void main(String[] args) throws Exception{
		System.out.println("Aquest es el driver de algorismes, indica quina funcio vols provar");
		llistaTests();
		int req = -1;
		req = getRequest();
		while (req < 1 || req > numeroTests) {
			System.out.println("Si us plau, entra un dels nombres corresponents a la funcio que vols provar\n");
			llistaTests();
			req = getRequest();
		}
		tractaRequest(req);
	}
	
	private static void tractaRequest(int req) {
		switch (req) {
			case 1:
				driverConstructora();
				break;
			case 2:
				driverModificarHidato();
				break;
			case 3:
				driverSolucianar();
				break;
			case 4:
				driverGetMatriuSolucio();
				break;
			case 5:
				driverObtenirHidato();
				break;
			case 6:
				driverGetGiven();
				break;
			case 7:
				driverGenerarHidato();
				break;
			default:
		}
	}


	private static void driverGenerarHidato() {
		// TODO Auto-generated method stub
		
	}

	private static void driverGetGiven() {
		// TODO Auto-generated method stub
		
	}

	private static void driverObtenirHidato() {
		// TODO Auto-generated method stub
		
	}

	private static void driverGetMatriuSolucio() {
		// TODO Auto-generated method stub
		
	}

	private static void driverSolucianar() {
		// TODO Auto-generated method stub
		
	}

	private static void driverModificarHidato() {
		// TODO Auto-generated method stub
		
	}

	private static void driverConstructora() {
		// TODO Auto-generated method stub
		
	}

	public static void llistaTests() {
		System.out.println("1: Constructora");
		System.out.println("2: Modificar hidato");
		System.out.println("3: Solucionar");
		System.out.println("4: getMatriuSolucio");
		System.out.println("5: obtenirDificultat");
		System.out.println("6: getGiven");
		System.out.println("7: generarHidato");
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
	
}