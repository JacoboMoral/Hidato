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
import main.presentation.ControladorPresentacio;

public class ControladorPersistence {
	
    private static final ControladorPersistence instance = new ControladorPersistence();

    public static ControladorPersistence getInstance() {
    	return instance;
    }
    
    private ControladorPersistence() {
    	
    }

    
    public static void guardarPartida(int status, int puntuacio, TipusCella cella, TipusAdjacencia tipusAdj, int[][] matriu, int[][] matriuOriginal, Vector<Integer> nombresDonats, Vector<Integer> nombresEscrits, String nomUsuari){
    	
    	try {
    		File carpeta = new File("Usuaris/" + nomUsuari + "/Partida");
    		if(carpeta.exists()) {
    			System.out.println("Ja hi ha una partida guardada es sobreescriurà");
    			carpeta.delete();
    		}
    		carpeta.mkdirs();
    		System.out.println("holi");
    		File arxiu = new File("Usuaris/" + nomUsuari + "/Partida/", "partida.txt");
    		arxiu.delete();
    		arxiu.createNewFile();
    		FileWriter fileWriter = new FileWriter("Usuaris/" + nomUsuari + "/Partida/partida.txt", true);
    		BufferedWriter bw = new BufferedWriter(fileWriter);
    		PrintStream console = System.out;
    		PrintStream o = new PrintStream(arxiu);
    		System.setOut(o);
    		HidatoIO.writeHidatoMatrixToOutputFormat(cella, tipusAdj, matriu);
    		System.out.print(";");
    		HidatoIO.writeHidatoMatrixToOutputFormat(cella, tipusAdj, matriuOriginal);
    		System.out.print(";");
    		System.setOut(console);
    		bw.write(status + ";" + puntuacio + ";" + tipusAdj + ";"+ nombresDonats + ";"+ nombresEscrits +";");
    		bw.close();
    		fileWriter.close();
    		
    	} catch(IOException ex){ex.printStackTrace();}
    	
    }
    
    public static void importarHidato(String file, String nom) throws IOException {
    	
    	
        FileReader fr = new FileReader(file);
        BufferedReader b = new BufferedReader(fr);
    	
    	
    	File carpeta = new File("HidatosImportats/" + nom);
    	if(carpeta.exists()) {
			System.out.println("Ja hi ha una hidato amb aquest nom. Es sobreescriurà");
			carpeta.delete();
		}
    	carpeta.mkdirs();
		File arxiu = new File("HidatosImportats/" + nom, "hidato.txt");
		arxiu.delete();
		arxiu.createNewFile();
		FileWriter fileWriter = new FileWriter("HidatosImportats/" + nom + "/hidato.txt", true);
		BufferedWriter bw = new BufferedWriter(fileWriter);
		PrintStream console = System.out;
		PrintStream o = new PrintStream(arxiu);
		
		String cadena = b.readLine();
		String[] cabecera = cadena.split(",");
		if(cabecera.length != 4) {
			System.out.println("error en el format");
			//COMPROVAR CAPÇALERA
			//SALTAR EXCEPCIO
		}
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
   

    public static void main(String[] args) throws IOException {
    
	    /*Vector<Integer> v = new Vector<Integer>(4);
	    v.add(1);
		v.add(2);
		v.add(3);
		v.add(4);
		
	    guardarPartida(1, 150, TipusCella.HEXAGON, TipusAdjacencia.COSTATS, new int[][] {
			{1,2,3,4,5},
			{6,7,8,9,10},
			{11,12,13,14,15},
			{16,17,18,19,20},
			{21,22,23,24,25}
		}, new int[][] {
			{1,2,3,4,5},
			{6,7,8,9,10},
			{11,12,13,14,15},
			{16,17,18,19,20},
			{21,22,23,24,666666}
		}, v, v, "aaa"); */
    	
    	importarHidato("hola.txt", "hola2");
	    
	    
    }

}