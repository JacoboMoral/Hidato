package main.domain.com.hidato;
import java.util.Scanner;
import java.util.Vector;

//"static" class
public final class HidatoIO {

	
	
	public static int[] readCapcaleraHidatoFromInput() {
		Scanner reader = new Scanner(System.in);
        String line = reader.nextLine();
        String[] values = line.split(",");
        
        int nombreFiles = Integer.parseInt(values[2]);
        int nombreColumnes = Integer.parseInt(values[3]);
        int[] array = new int[4];
        
        if (values[0].equals("Q")) array[0] = 4;
        else if (values[0].equals("T")) array[0] = 3;
        else array[0] = 6;

        if (values[1].equals("C")) array[1] = 1;
        else array[1] = 2;

        array[2] = nombreFiles;
        array[3] = nombreColumnes;
        return array;
	}
	
    public static int[][] readHidatoFromInput(int nombreFiles, int nombreColumnes){

    	Scanner reader = new Scanner(System.in);
        String line = reader.nextLine();
        String[] values = line.split(",");
        
        int[][] hidato = new int[nombreFiles][nombreColumnes];
        
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


	public static void writeHidatoSolucioMatrixToOutput(int[][] matrixSolucio, int[][] matrixOriginal, Vector<Integer> nombresPerDefecte) {
		for(int k = 0; k < matrixSolucio.length * matrixSolucio[0].length; ++k) {
			
			System.out.println();
	    	System.out.print("      ");
	    	if (matrixSolucio.length > 8) System.out.print(" ");
	    	for (int i = 0; i < matrixSolucio[0].length; ++i) {
	    		if (i == 0) System.out.print(" " + 1);
	    		else {
	    			if (i < 9) System.out.print("   "+(i+1));
	    			else System.out.print(i+1);
	    		}
	    	}
	    	
	    	System.out.println();
	    	System.out.println();
	    	System.out.println();

	    	for (int i = 0; i < matrixSolucio.length; ++i) {
	    		for (int j = 0; j < matrixSolucio[0].length; ++j) {
	    			if (j == 0) System.out.print((i+1) + "     ");
	    			if (matrixOriginal[i][j] > 9) System.out.print(matrixSolucio[i][j]);
	    			else if (matrixOriginal[i][j] > 0) System.out.print(" " + matrixSolucio[i][j]);
	    			else if (matrixOriginal[i][j] == 0) System.out.print("__");
	    			else if (matrixOriginal[i][j] == -1) System.out.print("**");
	    			else System.out.print("##");
	    			if (j != matrixSolucio[0].length - 1) System.out.print("  ");
	    		}
	    		System.out.println();
	    		System.out.println();
	    	}
			
		}	
		
		
	}
}
