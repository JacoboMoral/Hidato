package main.domain.com.hidato;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.List;

import main.domain.com.hidato.InteraccioTerminal.CustomCompare;

public class InteraccioTerminal {
	
	private ControladorDomini controladorDomini;
	String status = "start";
	
	public static class CustomCompare implements Comparator<Posicio> {
	    @Override
	    public int compare(Posicio p1, Posicio p2) {
	        return Integer.compare(p1.getPuntacio(), p2.getPuntacio());
	    }
	}
	
	public void start() {
		controladorDomini = new ControladorDomini();
		System.out.println("Benvinguts fills de puta");
		interactuar(readLine());
	}

	public void interactuar(String req) {
		if (req.equals("partida") && status.equals("start")) {
			partida();
			status = "partida";
			interactuar(readLine());
		}	
		else if(req.equals("importar") && status.equals("partida")) {
			autogenerar();
		}		
		else if(req.equals("importar") && status.equals("partida")) {
			importar();
		}
		else if (req.equals("moviment") && status.equals("jugant")) {
			infoMoviment();
			moviment();
		}
		else if (req.equals("moviment") && status.equals("movimentFet")) {
			moviment();
		}
		else if (req.equals("solucio") && status.equals("jugant")){
			solucio();
		}
		else if (req.equals("auto") && status.equals("partida")){
			autogenerar();
		}
		else if (req.equals("exit") || req.equals("sortir") || req.equals("surt")) {
			System.out.println("Sortint del programa, esperem que torni aviat ..............................................................");
		}
		else {
			interactuar(readLine());
		}
	}

	
	
	
	
	private void solucio() {
		if(status.equals("jugant")||status.equals("movimentFet")) {
			System.out.println("\n\n La solucio del teu hidato es la seguent: \n\n");
			HidatoIO.writeHidatoMatrixToOutput(controladorDomini.solucionarHidatoPartida());
			/*HidatoIO.writeHidatoSolucioMatrixToOutput(controladorDomini.solucionarHidatoPartida(),
					controladorDomini.obtenirHidatoOriginal(),
					controladorDomini.obtenirNombresPerDefecte());*/
		}
		else System.out.println("No es pot donar la solucio");
		interactuar(readLine());
	}

	private void infoMoviment() {
		System.out.println("\nFes un moviment, el format sera: [i j v], on:");
		System.out.println("    i = posicio i (comencant per 1) de on es vol colocar el numero");
		System.out.println("    j = posicio j (comencant per 1) de on es vol colocar el numero");
		System.out.println("    v = nombre que es vol colocar al hidato \n");
	}

	private void moviment() {
		int[] numbers = readNumbers(3);
		boolean estatMoviment = controladorDomini.ferMoviment(numbers[0]-1,numbers[1]-1,numbers[2]); //peta amb 1 1 32, ja ho mirare
		//boolean estatMoviment = controladorDomini.ferMoviment(9,6,2);
		if (estatMoviment) {
			System.out.println("\n\n Moviment valid, el hidato queda en el seguent estat:\n\n");
			HidatoIO.writeHidatoMatrixToOutputWithGrid(controladorDomini.getHidatoJugant());
			System.out.println("\nPots fer un altre moviment si ho dessitges\n");
			status = "movimentFet";
			interactuar(readLine());
		}
		else {
			System.out.println("Moviment no valid, intenta-ho de nou");
			status = "movimentFet";
			interactuar("moviment");
		}
	}
	private void autogenerar() {
		System.out.println("\nEscriu de quin tipus vols l'hidato [Quadrat | Triangle | Hexagon]");
		String tipus = readLine();
		if (stringToTipusCella(tipus) == null) {
			System.out.println("Escriu be el tipus de hidato");
			autogenerar();
		}
 		System.out.println("\nEscriu el nombre de cel�les buides");
		String celesBuides = readLine();
		System.out.println("\nEscriu el nombre de forats");
		String forats = readLine();
		//COMPROVAR CELESBBUIDDES I FORATS SIGUIN INTS
		
		System.out.println("\nEscriu la dificultat [Facil | Mig | Dificil]");
		String dificultat = readLine();
		if(stringToDificultat(dificultat) == null) {
			System.out.println("Escriu be el tipus de dificultat");
			autogenerar();
		}
		controladorDomini.autogenerar(stringToTipusCella(tipus), Integer.parseInt(celesBuides),
				Integer.parseInt(forats), stringToDificultat(dificultat));
	}

	private Dificultat stringToDificultat(String dificultat) {
		if (dificultat == "Facil") return Dificultat.FACIL;
		if (dificultat == "Mig") return Dificultat.MIG;
		if (dificultat == "Dificil") return Dificultat.DIFICIL;
		return null;
	}

	private void importar() {
		System.out.println("\nEscriu el teu hidato per pantalla seguint el format estandar\n\n");
		ArrayList<ArrayList<Integer>> entradaHidato = HidatoIO.readHidatoFromInput();
		int[][] matriuHidato = extreuMatriuHidato(entradaHidato);
		HidatoIO.writeHidatoMatrixToOutput(matriuHidato);
		TipusCella tipusCella = extreuTipusCella(entradaHidato);
		TipusAdjacencia tipusAdjacencia = extreuTipusAdjacencia(entradaHidato);
		
		if (tipusNoCompatible(tipusCella, tipusAdjacencia)) {
			System.out.println("Tipus de cella i tipus de adjacencia no son compatibles, torna a importar el hidato sencer");
			interactuar("importar");
		}
		
		else { 
			if (controladorDomini.jugarHidato(tipusCella, tipusAdjacencia, matriuHidato)) {
				System.out.println("\n\nHidato importat i validad correctament. El teu hidato es el seguent: \n");
				HidatoIO.writeHidatoMatrixToOutputWithGrid(controladorDomini.getHidatoJugant());
				status = "jugant";
				interactuar(readLine());
			}
			else {
				System.out.println("\n\nEl hidato importat no es vàlid i per tant no es pot resoldre. Si us plau, escolleix un altre");
				interactuar("importar");
			}
		}
	}

	private void partida() {
		System.out.println("Has seleccionat [partida], si us plau, escull entre una de les seguents opcions:");
		System.out.println("* [carregar] Jugar a una partida anteriorment guardada");
		System.out.println("* [importar] Jugar a una partida amb un hidato importat");
		System.out.println("* [auto] Jugar a una partida amb un hidato autogenerat\n");
	}



	private boolean tipusNoCompatible(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia) {
		return (tipusCella == TipusCella.HEXAGON && tipusAdjacencia == TipusAdjacencia.COSTATSIANGLES);
	}


	private boolean request(String req) {
		return readLine().equals(req);
	}
	
	private String readLine() {		
		Scanner input = new Scanner(System.in);
		String req = input.nextLine();
		return req;
	}
	
	private int[] readNumbers(int n) {
		
		Scanner input = new Scanner(System.in);
		int[] req = new int[3];
		for (int i = 0; i < n; ++i) {
			req[i] = input.nextInt();
		}
		input.nextLine();
		return req;
	}
	
	private int[][] extreuMatriuHidato(ArrayList<ArrayList<Integer>> matriu) {
		int[][] matriuHidato = new int[matriu.size()-1][matriu.get(1).size()];
		for (int i = 0; i < matriuHidato.length; ++i) {
			for (int j = 0; j < matriuHidato[1].length; ++j) {
				matriuHidato[i][j] = matriu.get(i+1).get(j);
			}
		}
		return matriuHidato;
	}

	private TipusAdjacencia extreuTipusAdjacencia(ArrayList<ArrayList<Integer>> matriu) {
		if (matriu.get(0).get(1) == 1) return TipusAdjacencia.COSTATS;
		return TipusAdjacencia.COSTATSIANGLES;
	}

	private TipusCella extreuTipusCella(ArrayList<ArrayList<Integer>> matriu) {
		int aux = matriu.get(0).get(0);
		if (aux == 4) return TipusCella.QUADRAT;
		if (aux == 3) return TipusCella.TRIANGLE;
		return TipusCella.HEXAGON;
	}
	
	private TipusCella stringToTipusCella(String tc) {
		if (tc.equalsIgnoreCase("Quadrat")) return TipusCella.QUADRAT;
		if (tc.equalsIgnoreCase("Triangle")) return TipusCella.TRIANGLE;
		if (tc.equalsIgnoreCase("Hexagon")) return TipusCella.HEXAGON;
		return null;
	}
}




