
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException{


        Scanner reader = new Scanner(System.in);  // Reading from System.in
        boolean exit = false;
		System.out.println("Benvingut a Hidato, per comen�ar una nova partida, escriu [partida], per carregar una guardada, escriu [carregar], per sortir escriu [exit]");
        while (!exit){
        	

        		String n = reader.next();
        		if (n.equals("exit")) exit = true;
        		if (n.equals("ranking")) {
        			Ranking r = new Ranking();
        			Posicio pos0 = new Posicio("Jia Xiang", 10, LocalDate.now());
        			Posicio pos1 = new Posicio("Jia Xiang2", 100, LocalDate.now());
        			Posicio pos2 = new Posicio("Jia Xiang3", 1000, LocalDate.now());
        			
        			r.insertar_posicio(pos0);
        			r.insertar_posicio(pos1);
        			r.insertar_posicio(pos2);
        			r.delete_by_nickname("Jia Xiang3");
        			r.delete_by_position(1);
        			
        			//r.delete_by_date(LocalDate.now());
        			
        			r.print();
        			
        			LocalDate date = LocalDate.now();
        			System.out.println("Time: " + date);
        			System.out.println("Year: " + date.getYear());
        			
        			
        		}
        		if (n.equals("partida")){
        			System.out.println("Has seleccionat començar una nova partida, escull el tipus de partida:\n hidato autogenerat [auto] \n importar hidato [importar]");
            		Partida p = new Partida();
        			n = reader.next();
            		if (n.equals("importar")){
            			HidatoIO hidatoInput = new HidatoIO();
            			System.out.println("Escriu el teu hidato amb el format estandar");
            			hidatoInput.hidatoReaderFromInput();
            			System.out.println("Hidato:");
            			int[][] hidato = hidatoInput.getHidatoMatrix();
            			for (int i = 0; i < hidatoInput.getNombreFiles(); ++i) {
            				for (int j = 0; j < hidatoInput.getNombreColumnes(); ++j) {
                    			System.out.print(hidato[i][j]+" ");
            				}
                			System.out.println();
            			}
            			Algoritmes al = new Algoritmes();
            			TimeUnit.MILLISECONDS.sleep(800);
            			System.out.print(al.solucionar(hidato));
            			
            			while(true);
            		}
            }
        		
        	
        }
        reader.close();
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