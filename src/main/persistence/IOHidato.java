package main.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Vector;

import main.domain.com.hidato.HidatoIO;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class IOHidato {
	
	 private static TipusCella tipusCella;
	 private static TipusAdjacencia tipusAdjacencia;
	 private static int[][] matriu;
	 
	 public static TipusCella getTipusCella() {
		 return tipusCella;
	 }

	 public static TipusAdjacencia getTipusAdjacencia() {
		 return tipusAdjacencia;
	 } 
	 
	 public static int[][] getMatriu(){
		 return matriu;
	 }
	 
	 public static void importarHidatoDeFitxer(String file, String nom) throws IOException { 
		//ABANS FER CARREGAR HIDATO  I SOLUCIONARLO PER COMPROVAR QUE ES CORRECTA
        FileReader fr = new FileReader(file);
        BufferedReader b = new BufferedReader(fr);
          
		File arxiu = new File("HidatosImportats/", nom +".txt");
		arxiu.delete();
		arxiu.createNewFile();
		FileWriter fileWriter = new FileWriter("HidatosImportats/" + nom + ".txt", true);
		BufferedWriter bw = new BufferedWriter(fileWriter);
		PrintStream console = System.out;
		PrintStream o = new PrintStream(arxiu);
		
		String cadena = b.readLine();
		String[] cabecera = cadena.split(",");
		
		int altura = Integer.parseInt(cabecera[2]);
		int anchura = Integer.parseInt(cabecera[3]);
		
		o.println(cadena);
		
		for(int i = 0; i < altura; i++) {
			cadena = b.readLine();
			o.println(cadena);
			if(cadena.split(",").length != anchura) System.out.println("Error");
		}
		
		bw.close();
		fileWriter.close();
	}
	 
	public static void carregarHidatoFitxer(String file) throws Exception {
		
		FileReader fr = new FileReader(file);
        BufferedReader b = new BufferedReader(fr);
        String cadena = b.readLine();
      	String[] cabecera = cadena.split(",");
      	if(cabecera.length != 4) throw new Exception("Cap�alera del fitxer" + file + " no es correcte (t� m�s de 4 coses)");
      	tipusCella = stringToTipusCella(cabecera[0]);
      	tipusAdjacencia = stringToTipusAdjacencia(cabecera[1]);
      	if(tipusCella == null || tipusAdjacencia == null) throw new Exception("tipusCella o tipusAdjcacencia no v�lid");
      	
      	int altura = Integer.parseInt(cabecera[2]);
      	int anchura = Integer.parseInt(cabecera[3]);
      	
      	matriu = new int[altura][anchura];
      	     	
      	for(int i = 0; i < altura; i++) {
      		cadena = b.readLine();
          	String[] linea = cadena.split(",");
      		for(int j = 0; j < linea.length; j++) {
      			if(linea[j].equals("#")) matriu[i][j] = -2;
      			else if(linea[j].equals("*")) matriu[i][j] = -1;
      			else if(linea[j].equals("?")) matriu[i][j] = 0;
      			else matriu[i][j] = Integer.parseInt(linea[j]);
      		}
      		
      	}
	}


	public static void importarHidatoCreat(int[][] matriu, TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, String nomFitxer) throws IOException {
		File arxiu = new File("HidatosImportats/", nomFitxer +".txt");
		arxiu.createNewFile();
		PrintStream fitxerOutput = new PrintStream(arxiu);
		
		writeMatriu(matriu, tipusCella, tipusAdjacencia, fitxerOutput);
		
    	fitxerOutput.close();
	}
	
	public static Vector<String> nomHidatos() {
		return null;
	}
	
	
	private static void writeMatriu(int[][] matriu, TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, PrintStream output) {
		String primeraLinea = "";
    	if (tipusCella == TipusCella.QUADRAT) primeraLinea += "Q,";
    	else if(tipusCella == TipusCella.TRIANGLE) primeraLinea += "T,";
    	else primeraLinea += "H,";
    	if (tipusAdjacencia == TipusAdjacencia.COSTATS) primeraLinea += "C,";
    	else primeraLinea += "CA,";
    	primeraLinea += matriu.length + "," + matriu[0].length;
    	output.println(primeraLinea);
    	for (int i = 0; i < matriu.length; ++i) {
    		for (int j = 0; j < matriu[0].length; ++j) {
    			if (j < matriu[0].length-1) {
    				if (matriu[i][j] == -1)  output.print("*,");
    				else output.print(matriu[i][j] + ",");
    			}
    			else {
    				if (matriu[i][j] == -1)  System.out.println("*");
        			else if (matriu[i][j] == -2) System.out.println("#");
        			else output.println(matriu[i][j]);
    			}
    		}
    	}
	}
	
	private static TipusCella stringToTipusCella(String tc) {
		if (tc.equals("Q")) return TipusCella.QUADRAT;
		if (tc.equals("T")) return TipusCella.TRIANGLE;
		if (tc.equals("H")) return TipusCella.HEXAGON;
		return null;
	}

	private static TipusAdjacencia stringToTipusAdjacencia(String ta) {
		 if (ta.equals("C")) return TipusAdjacencia.COSTATS;
		 if (ta.equals("CA")) return TipusAdjacencia.COSTATSIANGLES;
		 return null;
	}

	
}