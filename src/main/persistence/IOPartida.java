package main.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Vector;

import main.domain.com.hidato.HidatoIO;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class IOPartida {


	private static int status;
	private static int puntuacio;
	private static TipusCella tipusCella;
	private static TipusAdjacencia tipusAdjacencia;
	private static int[][] matriu;
	private static int[][] matriuOriginal;
	private static Vector<Integer> nombresDonats;
	private static Vector<Integer> nombresEscrits;


	public static int getStatus() {
		return status;
	}

	public static int getPuntuacio() {
		return puntuacio;
	}

	public static TipusCella getTipusCella() {
		return tipusCella;
	}

	public static TipusAdjacencia getTipusAdjcacencia() {
		return tipusAdjacencia;
	}

	public static int[][] getMatriu(){
		return matriu;
	}

	public static int[][] getMatriuOriginal(){
		return matriuOriginal;
	}

	public static Vector<Integer> getNombresDonats(){
		return nombresDonats;
	}

	public static Vector<Integer> getNombresEscrits(){
		return nombresEscrits;
	}

	private static void writeHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matriuHidato, PrintStream output) {
		
		String primeraLinea = "";
		
		if (tipusCella == TipusCella.QUADRAT) primeraLinea += "Q,";
		else if(tipusCella == TipusCella.TRIANGLE) primeraLinea += "T,";
		else primeraLinea += "H,";
		
		if (tipusAdjacencia == TipusAdjacencia.COSTATS) primeraLinea += "C,";
		else primeraLinea += "CA,";
		
		primeraLinea += matriuHidato.length + "," + matriuHidato[0].length;
		output.println(primeraLinea);
		for (int i = 0; i < matriuHidato.length; ++i) {
			for (int j = 0; j < matriuHidato[0].length; ++j) {
				if (j < matriuHidato[0].length-1) {
					if (matriuHidato[i][j] == -1)  output.print("*,");
					else output.print(matriuHidato[i][j] + ",");
				}
				else {
					if (matriuHidato[i][j] == -1)  output.println("*");
					else if (matriuHidato[i][j] == -2) output.println("#");
					else output.println(matriuHidato[i][j]);
				}
			}
		}
	}

	public static void guardarPartida(int status, int puntuacio, TipusCella cella, TipusAdjacencia tipusAdj, int[][] matriu, int[][] matriuOriginal, Vector<Integer> nombresDonats, Vector<Integer> nombresEscrits, String nomUsuari){

		try {
			File arxiu = new File("Usuaris/" + nomUsuari + "/partida.txt");
			// MIRAR SI HI HA UNA PARTIDA GUARDADA!!!!
			arxiu.delete();
			arxiu.createNewFile();
			FileWriter fileWriter = new FileWriter("Usuaris/" + nomUsuari + "/partida.txt", true);
			BufferedWriter bw = new BufferedWriter(fileWriter);
			PrintStream output = new PrintStream(arxiu);
			writeHidato(cella, tipusAdj, matriu, output);
			output.println(";");
			writeHidato(cella, tipusAdj, matriuOriginal, output);
			output.println(";");
			bw.write(status + ";" + puntuacio + ";" + nombresDonats + ";"+ nombresEscrits +";");
			bw.close();
			fileWriter.close();

		} catch(IOException ex){ex.printStackTrace();}

	}

	public static void carregarPartida(String usuari) {
		try {
			FileReader fr = new FileReader("Usuaris/" + usuari + "/partida.txt");
			BufferedReader b = new BufferedReader(fr);
			String cadena = b.readLine();
			String[] cabecera = cadena.split(",");
			tipusCella = stringToTipusCella(cabecera[0]);
			if (tipusCella == null); //ficar missatge
			tipusAdjacencia = stringToTipusAdjacencia(cabecera[1]);
			matriu = new int[Integer.parseInt(cabecera[2])][Integer.parseInt(cabecera[3])];
			matriuOriginal = new int[Integer.parseInt(cabecera[2])][Integer.parseInt(cabecera[3])];

			int i = 0;
			
			//Matriu partida

			cadena = b.readLine();
			String[] linea = cadena.split(",");
			while (cadena != null && linea.length == Integer.parseInt(cabecera[3])) {
				for (int j = 0; j < linea.length; ++j) {
					matriu[i][j] = Integer.parseInt(linea[j]);
				}
				++i;
				cadena = b.readLine();
				linea = cadena.split(",");
			}
			
			
			//Matriu original
			
			cadena = b.readLine();
			cadena = b.readLine();
			
			linea = cadena.split(",");
			i = 0;
			while (cadena != null && linea.length == Integer.parseInt(cabecera[3])) {
				for (int j = 0; j < linea.length; ++j) {
					matriuOriginal[i][j] = Integer.parseInt(linea[j]);
				}
				++i;
				cadena = b.readLine();
				linea = cadena.split(",");
			}
			
			cadena = b.readLine();
			linea = cadena.split(";");
			
			status = Integer.parseInt(linea[0]);
			puntuacio = Integer.parseInt(linea[1]);
			nombresDonats = stringToVector(linea[2]);
			nombresEscrits = stringToVector(linea[3]);

			
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			//ex.printStackTrace();
		}
	}

	private static Vector<Integer> stringToVector(String vectorInput) {
		Vector<Integer> vectorOutput = new Vector<Integer>();
		vectorInput = vectorInput.replace(" ","");
		vectorInput = vectorInput.replace("[","");
		vectorInput = vectorInput.replace("]","");
		String[] linea = vectorInput.split(",");
		for(int i = 0; i < linea.length; ++i) {
			vectorOutput.add(Integer.parseInt(linea[i]));
		}
		return vectorOutput;
	}

	private static TipusCella stringToTipusCella(String tc) {
		if (tc.equals("C")) return TipusCella.QUADRAT;
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
