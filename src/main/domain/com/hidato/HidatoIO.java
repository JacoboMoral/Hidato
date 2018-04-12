package main.domain.com.hidato;
import java.util.Scanner;

//"static" class
public final class HidatoIO {

    public static int[][] readHidatoFromInput(){
        Scanner reader = new Scanner(System.in);
        String line = reader.nextLine();
        String[] values = line.split(",");
        
        int nombreFiles = Integer.parseInt(values[2]);
        int nombreColumnes = Integer.parseInt(values[3]);
        int[][] hidato = new int[nombreFiles+1][nombreColumnes];
        
        if (values[0].equals("Q")) hidato[0][0] = 4;
        else if (values[0].equals("T")) hidato[0][0] = 3;
        else hidato[0][0] = 6;

        if (values[1].equals("C")) hidato[0][1] = 1;
        else hidato[0][1] = 2;

        hidato[0][2] = nombreFiles;
        hidato[0][3] = nombreColumnes;
        
        for (int i = 1; i < nombreFiles+1; ++i) {
            line = reader.nextLine();
            values = line.split(",");
            for (int j = 0; j < nombreColumnes; ++j){
                	if (values[j].equals("#")) hidato[i][j] = -2;
                	else if (values[j].equals("*")) hidato[i][j] = -1;
                	else if (values[j].equals("?")) hidato[i][j] = 0;
                	else hidato[i][j] = Integer.parseInt(values[j]);        	
            }
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
    	System.out.print("      ");
    	if (matrix.length > 8) System.out.print(" ");
    	for (int i = 0; i < matrix[0].length; ++i) {
    		if (i == 0) System.out.print(" " + 1);
    		else {
    			if (i < 9) System.out.print("   "+(i+1));
    			else System.out.print(i+1);
    		}
    		
    	}
    	
    	System.out.println();
    	System.out.println();
    	System.out.println();

    	for (int i = 0; i < matrix.length; ++i) {
    		for (int j = 0; j < matrix[0].length; ++j) {
    			if (j == 0) System.out.print((i+1) + "     ");
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
