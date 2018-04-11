package com.hidato;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.List;

import com.hidato.InteraccioTerminal.CustomCompare;

public class InteraccioTerminal {

	public static class CustomCompare implements Comparator<Posicio> {
	    @Override
	    public int compare(Posicio p1, Posicio p2) {
	        return Integer.compare(p1.getPuntacio(), p2.getPuntacio());
	    }
	}
	

	public void interactuar() throws Exception {
		ControladorDomini controladorDomini = new ControladorDomini();
		System.out.println("Benvinguts fills de puta");
		
		if (request("partida")) {
			System.out.println("Has seleccionat [partida], si us plau, escull entre una de les seguents opcions:");
			System.out.println("* [carregar] Jugar a una partida anteriorment guardada");
			System.out.println("* [importar] Jugar a una partida amb un hidato importat");
			System.out.println("* [auto] Jugar a una partida amb un hidato autogenerat\n");
	
			//NO SE SI EL HIDATO ES CREA AQUI O MILLOR EL CREA CONTROLADOR DE DOMINI
			if (request("importar")) {
				int[][] entradaHidato = HidatoIO.readHidatoFromInput();
				int[][] matriuHidato = extreuMatriuHidato(entradaHidato);
				TipusCella tipusCella = extreuTipusCella(entradaHidato);
				TipusAdjacencia tipusAdjacencia = extreuTipusAdjacencia(entradaHidato);
				controladorDomini.jugarHidato(tipusCella, tipusAdjacencia, matriuHidato);
				HidatoIO.writeHidatoMatrixToOutput(matriuHidato); 											//output sense graella
				HidatoIO.writeHidatoMatrixToOutputWithGrid(controladorDomini.solucionarHidatoPartida()); 	//output amb graella
				
				if (request("moviment")) {
					int[] numbers = readNumbers(3);
					boolean estatMoviment = controladorDomini.ferMoviment(numbers[0]-1,numbers[1]-1,numbers[2]); //peta amb 1 1 32, ja ho mirare
					//boolean estatMoviment = controladorDomini.ferMoviment(9,6,2);
					if (estatMoviment) {
						System.out.println("\n\nMoviment valid, el hidato queda en el seguent estat:\n\n");
						HidatoIO.writeHidatoMatrixToOutputWithGrid(controladorDomini.getHidatoJugant());
					}
					else {
						System.out.println("Moviment no valid");
					}
				}
			}
		}
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
		return req;
	}
	
	private int[][] extreuMatriuHidato(int[][] matriu) {
		int[][] matriuHidato = new int[matriu.length-1][matriu[1].length];
		for (int i = 0; i < matriu.length-1; ++i) {
			for (int j = 0; j < matriu[1].length; ++j) {
				matriuHidato[i][j] = matriu[i+1][j];
			}
		}
		return matriuHidato;
	}

	private TipusAdjacencia extreuTipusAdjacencia(int[][] matriu) {
	        if (matriu[0][1] == 1) return TipusAdjacencia.COSTATS;
	        else if (matriu[0][1] == 2) return TipusAdjacencia.VERTEXS;
	        else return TipusAdjacencia.VERTEXS;
	}

	private TipusCella extreuTipusCella(int[][] matriu) {
		 if (matriu[0][0] == 4) return TipusCella.QUADRAT;
	        else if (matriu[0][0] == 3) return TipusCella.TRIANGLE;
	        else return TipusCella.HEXAGON;

	}
}


