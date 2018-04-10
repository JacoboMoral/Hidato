package com.hidato;
import java.util.Scanner;
import java.util.ArrayList;

public class HidatoIO {
    private TipusAdjacencia tipusAdjacencia;
    private TipusCella tipusCella;
    private int nombreFiles;
    private int nombreColumnes;
    private ArrayList<ArrayList<String>> matrix = new ArrayList<ArrayList<String>>();
	int[][] hidato;
	
    public void hidatoReaderFromInput(){
        Scanner reader = new Scanner(System.in);
        String line = reader.nextLine();
        String[] values = line.split(",");

        if (values[0] == "Q") tipusCella = TipusCella.QUADRAT;
        else if (values[0] == "T") tipusCella = TipusCella.TRIANGLE;
        else tipusCella = TipusCella.HEXAGON;

        if (values[1] == "C") tipusAdjacencia = TipusAdjacencia.COSTATS;
        else if (values[1] == "V") tipusAdjacencia = TipusAdjacencia.VERTEXS;
        else tipusAdjacencia = TipusAdjacencia.VERTEXS;

        nombreFiles = Integer.parseInt(values[2]);
        nombreColumnes = Integer.parseInt(values[3]);
        hidato = new int[nombreFiles][nombreColumnes];

        for (int i = 0; i < nombreFiles; ++i) {
            line = reader.nextLine();
            values = line.split(",");
    			ArrayList<String> fila = new ArrayList<String>();
            for (int ii = 0; ii < nombreColumnes; ++ii){
            		fila.add(values[ii]);
                	if (values[ii].equals("#")) hidato[i][ii] = -2;
                	else if (values[ii].equals("*")) hidato[i][ii] = -1;
                	else if (values[ii].equals("?")) hidato[i][ii] = 0;
                	else hidato[i][ii] = Integer.parseInt(values[ii]);        	
            }
            matrix.add(fila);
        }
        reader.close();
    }

    public void writeHidatoToOutput(int[][] matrix){
    	for (int i = 0; i < matrix.length; ++i) {
    		for (int j = 0; j < matrix[0].length; ++j) {
    	        System.out.print(matrix[i][j]+ "  ");
    		}
    		System.out.println();
    	}
    }
    
    public int getNombreFiles() {
    		return nombreFiles;
    }
    
    public int getNombreColumnes() {
    		return nombreColumnes;
    }
    
    public TipusCella getTipusCella() {
    		return tipusCella;
    }
    
    public TipusAdjacencia getTipusAdjacencia() {
    		return tipusAdjacencia;
    }
    
    public int[][] getHidatoMatrix() {
    		return hidato;
    }
}
