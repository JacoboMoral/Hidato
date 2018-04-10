package com.hidato;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException{


        Scanner reader = new Scanner(System.in);  // Reading from System.in
        boolean exit = false;
		System.out.println("Benvingut a Hidato, per comenï¿½ar una nova partida, escriu [partida], per carregar una guardada, escriu [carregar], per sortir escriu [exit]");
        while (!exit){


        		String n = reader.next();
        		if (n.equals("exit")) exit = true;
        		if (n.equals("ranking")) {
        			Ranking r = new Ranking();
        			Posicio pos0 = new Posicio("Jia Xiang", 3, LocalDate.now());
        			Posicio pos1 = new Posicio("Jia Xiang2", 4, LocalDate.now());
        			Posicio pos2 = new Posicio("Jia Xiang3", 7, LocalDate.now());
        			Posicio pos3 = new Posicio("Jia Xiang3", 213, LocalDate.now());
        			Posicio pos4 = new Posicio("Jia Xiang3", 143, LocalDate.now());
        			Posicio pos5 = new Posicio("Jia Xiang3", 743, LocalDate.now());


        			r.insertar_posicio(pos0);
        			r.insertar_posicio(pos1);
        			r.insertar_posicio(pos2); r.insertar_posicio(pos3); r.insertar_posicio(pos4); r.insertar_posicio(pos5);

        			//r.delete_by_nickname("Jia Xiang3");
        			//r.delete_by_position(1);

        			Collections.sort(r.getList(), new CustomCompare().reversed());

        			//r.delete_by_date(LocalDate.now());


        			r.print();

        			r.filter_by_nickname("Jia Xiang3");

        			/*LocalDate date = LocalDate.now();
        			System.out.println("Time: " + date);
        			System.out.println("Year: " + date.getYear());*/


        		}
        		if (n.equals("partida") && !n.equals("exit")){
        			System.out.println("Has seleccionat començar una nova partida, escull el tipus de partida:\n hidato autogenerat [auto] \n importar hidato [importar]");
            		//Partida p = new Partida();
        			n = reader.next();
            		if (n.equals("importar") && !n.equals("exit")){
            			HidatoIO hidatoInput = new HidatoIO();
            			System.out.println("Escriu el teu hidato amb el format estandar");
            			hidatoInput.hidatoReaderFromInput();
            			System.out.println("Hidato:");
            			int[][] hidato = hidatoInput.getHidatoMatrix();
            			/*for (int i = 0; i < hidatoInput.getNombreFiles(); ++i) {
            				for (int j = 0; j < hidatoInput.getNombreColumnes(); ++j) {
                    			System.out.print(hidato[i][j]+" ");
            				}
                			System.out.println();
            			}*/
            			/*Algoritmes al = new Algoritmes(hidato);
            			TimeUnit.MILLISECONDS.sleep(800);
            			System.out.print(al.solucionar()); //SHA DE COMPROVAR DINS DHIDATO*/

            			Hidato h = new Hidato(hidatoInput.getTipusCella(), hidatoInput.getTipusAdjacencia(), hidato);
            			Partida partida = new Partida(h);
            			System.out.println();
            			System.out.println();
            			System.out.println("PARTIDA EN JOC");

            			partida.demanarSolucio();

            			System.out.println("FES MOVIMENT GOS");
            			/*n = reader.nextLine();
            			int i = Integer.parseInt(n);
            			n = reader.nextLine();
            			int j = Integer.parseInt(n);
            			n = reader.next();
            			int value = Integer.parseInt(n);*/

            			/*Scanner scan = new Scanner(System.in);
            			String i = scan.next();
            			String j = scan.next();
            			String value = scan.next();*/

            			//partida.ferJugada(i, j, value);
            			partida.ferJugada(1, 2, 2);


            			//scan.close();

            			while(true);
            		}

            		else if (n.equals("autogenerar") && !n.equals("exit")) {
            		}

        		}


        }
        reader.close();
    }

    public static class CustomCompare implements Comparator<Posicio> {
	    @Override
	    public int compare(Posicio p1, Posicio p2) {
	        return Integer.compare(p1.getPuntacio(), p2.getPuntacio());
	    }
	}

}





/*

int tamany = 7;
int row1 = -1;
int column1 = -1;
int[][] matriu = new int[tamany+2][tamany+2];

int[] given = null;
List<Integer> list = new ArrayList<Integer>();

Scanner readerr = new Scanner(System.in);



for (int i = 1; i < matriu.length-1; ++i) {
	for (int j = 1; j < matriu[0].length-1; ++j) {
		matriu[i][j] = readerr.nextInt();
		if (matriu[i][j] == 1) {
			row1 = i;
			column1 = j;
		}
		if (matriu[i][j] != -1 && matriu[i][j] != 0) {
			list.add(matriu[i][j]);
		}
	}
}

Collections.sort(list);
given = new int[list.size()];

for (int i = 0; i < given.length; i++){
    given[i] = list.get(i);
    System.out.println(given[i]);
}


for (int x=0; x<tamany+2;  ++x){
	matriu[0][x] = -1;
	matriu[x][0] = -1;
	matriu[tamany+1][x] = -1;
	matriu[x][tamany+1] = -1;
}

Algoritmes al = new Algoritmes();
boolean sol = al.solucionador(row1, column1, 1, 0, given, matriu);
System.out.println(sol);
*/
