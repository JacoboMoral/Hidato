
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args){



        Scanner reader = new Scanner(System.in);  // Reading from System.in
        boolean exit = false;
        while (!exit){

        		String n = reader.next();
        		if (n.equals("exit")) exit = true;
        		if (n.equals("hidato")){
        			System.out.println("Hidato seleccionat");
        			/*HidatoIO hidatoIO = new HidatoIO();
        			hidatoIO.hidatoReaderFromInput();
        			hidatoIO.hidatoWriterToOutput();*/
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
        			
        			
        			
        			
        			/*for (int i = 0; i < matriu.length; ++i) {
            			for (int j = 0; j < matriu.length; ++j) {
            				System.out.print(matriu[i][j]+"    ");
            			}
        				System.out.println("\n");

            		}*/
        			
        			
        			//Hidato hidato = new Hidato(hidatoIO.getTipusCella(), hidatoIO.getTipusAdjacencia(), hidatoIO.gethHdatoMatrix());
        			//System.out.println(hidato.getNombreColumnes());
            }
        		
        		
        }
        reader.close();
    }
    
    
}