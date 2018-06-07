package main.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
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

    public static int[][] getMatriu() {
        return matriu;
    }

    public static void importarHidatoDeFitxer(String file, String nom) throws IOException {
    	CrearCarpetaSiNoExisteix();
        FileReader fr = new FileReader(file);
        BufferedReader b = new BufferedReader(fr);
        File arxiu = new File("DB/HidatosImportats/"+ nom + ".txt");
        arxiu.delete();
        arxiu.createNewFile();
        FileWriter fileWriter = new FileWriter("DB/HidatosImportats/" + nom + ".txt", true);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        PrintStream console = System.out;
        PrintStream o = new PrintStream(arxiu);

        String cadena = b.readLine();
        String[] cabecera = cadena.split(",");

        int altura = Integer.parseInt(cabecera[2]);
        int anchura = Integer.parseInt(cabecera[3]);

        o.println(cadena);

        for (int i = 0; i < altura; i++) {
            cadena = b.readLine();
            o.println(cadena);
        }

        bw.close();
        b.close();
        fileWriter.close();
    }

    public static void carregarHidatoFitxer(String file) throws Exception {

        FileReader fr = new FileReader(file);
        BufferedReader b = new BufferedReader(fr);
        String cadena = b.readLine();
        String[] cabecera = cadena.split(",");
        if (cabecera.length != 4) {
            throw new Exception("El format no es correcte");
        }
        tipusCella = stringToTipusCella(cabecera[0]);
        tipusAdjacencia = stringToTipusAdjacencia(cabecera[1]);
        if (tipusCella == null || tipusAdjacencia == null) {
            throw new Exception("tipusCella o tipusAdjcacencia no valid");
        }
        if(!compatibles(tipusCella,tipusAdjacencia)) throw new Exception("tipusCella i tipusAdjcacencia no compatible");

        int altura = Integer.parseInt(cabecera[2]);
        int anchura = Integer.parseInt(cabecera[3]);

        matriu = new int[altura][anchura];

        for (int i = 0; i < altura; i++) {
            cadena = b.readLine();
            String[] linea = cadena.split(",");
            for (int j = 0; j < linea.length; j++) {
                if (linea[j].equals("#")) {
                    matriu[i][j] = -2;
                } else if (linea[j].equals("*")) {
                    matriu[i][j] = -1;
                } else if (linea[j].equals("?")) {
                    matriu[i][j] = 0;
                } else {
                    matriu[i][j] = Integer.parseInt(linea[j]);
                }
            }

        }
        b.close();
        fr.close();
        
    }

    public static void carregarHidatoImportat(String nomHidato) throws IOException {
    	CrearCarpetaSiNoExisteix();
        FileReader fr = new FileReader("DB/HidatosImportats/" + nomHidato + ".txt");
        BufferedReader b = new BufferedReader(fr);
        String cadena = b.readLine();
        String[] cabecera = cadena.split(",");
        tipusCella = stringToTipusCella(cabecera[0]);
        tipusAdjacencia = stringToTipusAdjacencia(cabecera[1]);

        int altura = Integer.parseInt(cabecera[2]);
        int anchura = Integer.parseInt(cabecera[3]);

        matriu = new int[altura][anchura];

        for (int i = 0; i < altura; i++) {
            cadena = b.readLine();
            String[] linea = cadena.split(",");
            for (int j = 0; j < linea.length; j++) {
                if (linea[j].equals("#")) {
                    matriu[i][j] = -2;
                } else if (linea[j].equals("*")) {
                    matriu[i][j] = -1;
                } else if (linea[j].equals("?")) {
                    matriu[i][j] = 0;
                } else {
                    matriu[i][j] = Integer.parseInt(linea[j]);
                }
            }
        }
    }

    public static void importarHidatoCreat(int[][] matriu, TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, String nomHidato) throws IOException {
    	CrearCarpetaSiNoExisteix();
        File arxiu = new File("DB/HidatosImportats/"+ nomHidato + ".txt");
        arxiu.createNewFile();
        PrintStream fitxerOutput = new PrintStream(arxiu);

        writeMatriu(matriu, tipusCella, tipusAdjacencia, fitxerOutput);

        fitxerOutput.close();
    }

    public static String[] nomHidatosImportats() {
    	CrearCarpetaSiNoExisteix();
        File carpeta = new File("DB/HidatosImportats");
        ArrayList<String> llistaFitxers = new ArrayList<String>();
        for (File fitxer : carpeta.listFiles()) {
            String[] aux = fitxer.getName().split("\\.");

            llistaFitxers.add(aux[0]);
        }
        return (llistaFitxers.toArray(new String[0]));
    }

    private static void writeMatriu(int[][] matriu, TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, PrintStream output) {
        String primeraLinea = "";
        if (tipusCella == TipusCella.QUADRAT) {
            primeraLinea += "Q,";
        } else if (tipusCella == TipusCella.TRIANGLE) {
            primeraLinea += "T,";
        } else {
            primeraLinea += "H,";
        }
        if (tipusAdjacencia == TipusAdjacencia.COSTATS) {
            primeraLinea += "C,";
        } else {
            primeraLinea += "CA,";
        }
        primeraLinea += matriu.length + "," + matriu[0].length;
        output.println(primeraLinea);
        HidatoIO.writeHidatoMatrixToOutput(matriu);
        for (int i = 0; i < matriu.length; ++i) {
            for (int j = 0; j < matriu[0].length; ++j) {
                if (j < matriu[0].length - 1) {
                    if (matriu[i][j] == -1)output.print("*,");
                    else if (matriu[i][j] == -2) output.print("#,");
                    else output.print(matriu[i][j] + ",");
                } else {
                    if (matriu[i][j] == -1) output.println("*");
                    else if (matriu[i][j] == -2) output.println("#");
                    else output.println(matriu[i][j]);
                }
            }
        }
    }

    private static TipusCella stringToTipusCella(String tc) {
        if (tc.equals("Q")) {
            return TipusCella.QUADRAT;
        }
        if (tc.equals("T")) {
            return TipusCella.TRIANGLE;
        }
        if (tc.equals("H")) {
            return TipusCella.HEXAGON;
        }
        return null;
    }

    private static TipusAdjacencia stringToTipusAdjacencia(String ta) {
        if (ta.equals("C")) {
            return TipusAdjacencia.COSTATS;
        }
        if (ta.equals("CA")) {
            return TipusAdjacencia.COSTATSIANGLES;
        }
        return null;
    }

    private static boolean compatibles(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia) {
        if (tipusCella == TipusCella.QUADRAT) return true;
        else return (tipusAdjacencia == TipusAdjacencia.COSTATS);
    }

	public static void importarHidatoCreat(String nomHidato) throws IOException {
		CrearCarpetaSiNoExisteix();
		File arxiu = new File("DB/HidatosImportats/"+ nomHidato + ".txt");
        arxiu.createNewFile();
        PrintStream fitxerOutput = new PrintStream(arxiu);

        writeMatriu(matriu, tipusCella, tipusAdjacencia, fitxerOutput);
        fitxerOutput.close();
	}

	private static void CrearCarpetaSiNoExisteix() {
		File temp = new File("DB/HidatosImportats");
        if (!temp.exists()) temp.mkdirs();
	}
}
