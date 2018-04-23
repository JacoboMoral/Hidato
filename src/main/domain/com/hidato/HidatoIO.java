package main.domain.com.hidato;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

//"static" class
public final class HidatoIO {

	
    public static ArrayList<ArrayList<Integer>> readHidatoFromInput(){

    		Scanner reader = new Scanner(System.in);
        String line = reader.nextLine();
        String[] values = line.split(",");
        
        int nombreFiles = Integer.parseInt(values[2]);
        int nombreColumnes = Integer.parseInt(values[3]);
        
        ArrayList<ArrayList<Integer>> hidato = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> auxLine = new ArrayList<Integer>();
        
        if (values[0].equals("Q")) auxLine.add(4);
        else if (values[0].equals("T")) auxLine.add(3);
        else auxLine.add(6);

        if (values[1].equals("C")) auxLine.add(1);
        else auxLine.add(2);

        auxLine.add(nombreFiles);
        auxLine.add(nombreColumnes);
        hidato.add(auxLine);
        
        for (int i = 0; i < nombreFiles; ++i) {
            line = reader.nextLine();
            values = line.split(",");
            auxLine = new ArrayList<Integer>();
            for (int j = 0; j < nombreColumnes; ++j){
                	if (values[j].equals("#")) auxLine.add(-2);
                	else if (values[j].equals("*")) auxLine.add(-1);
                	else if (values[j].equals("?")) auxLine.add(0);
                	else auxLine.add(Integer.parseInt(values[j]));      	
            }
            hidato.add(auxLine);
        }
        return hidato;
    }

    
    public static void writeHidatoMatrixToOutput(int[][] matrix){
	    	System.out.println();
	    	for (int i = 0; i < matrix.length; ++i) {
	    		for (int j = 0; j < matrix[0].length; ++j) {
	    			if (matrix[i][j] > 9) System.out.print(matrix[i][j]);
	    			else if (matrix[i][j] > 0) System.out.print(" " + matrix[i][j]);
	    			else if (matrix[i][j] == 0) System.out.print("__");
	    			else if (matrix[i][j] == -1) System.out.print("**");
	    			else System.out.print("##");
	    			if (j != matrix[0].length - 1) System.out.print("  ");
	    		}
	    		System.out.println();
	    		System.out.println();
	
	    	}
    }
    
    public static void writeHidatoMatrixToOutputWithGrid(int[][] matrix){
	    	System.out.println();
	    	System.out.print("     ");
	    	if (matrix.length > 8) System.out.print(" ");
	    	for (int i = 0; i < matrix[0].length; ++i) {
	    		if (i == 0) System.out.print(" " + 1);
	    		else {
	    			if (i < 9) System.out.print("   "+(i+1));
	    			else if (i == 9) System.out.print("  " + (i+1));
	    			else System.out.print(i+1);
	    		}
	    		
	    	}
    	
	    	System.out.println();
	    	System.out.println();
	    	System.out.println();
	
	    	for (int i = 0; i < matrix.length; ++i) {
	    		for (int j = 0; j < matrix[0].length; ++j) {
	    			if (j == 0) {
	    				if (i < 9) System.out.print((i+1) + "     ");
	    				else if (i < 99) System.out.print((i+1) + "    ");
	    				else System.out.print((i+1) + "   ");
	    			}
	    			if (matrix[i][j] > 9) System.out.print(matrix[i][j]);
	    			else if (matrix[i][j] > 0) System.out.print(" " + matrix[i][j]);
	    			else if (matrix[i][j] == 0) System.out.print("__");
	    			else if (matrix[i][j] == -1) System.out.print("**");
	    			else System.out.print("##");
	    			if (j != matrix[0].length - 1) System.out.print("  ");
	    		}
	    		System.out.println();
	    		System.out.println();
	    	}
    	
    	
    }


}
