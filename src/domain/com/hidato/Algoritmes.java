package com.hidato;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Algoritmes {
	
	private int[][] matriuSolucio;
	private int[][] matriuOriginal;
	
	public Algoritmes(int[][] matriuOriginal) {
		this.matriuOriginal = matriuOriginal;
	}
	
	public boolean solucionar() {
		
		
		
		int row1 = -1; 
		int column1 = -1; //fila i columna on es troba el numero 1
		int [][] matriu = new int[matriuOriginal.length+2][matriuOriginal[0].length+2];
		int[] given = null;
        List<Integer> list = new ArrayList<Integer>();		
        int casellesNumeriques = 0;
        
		
		//System.out.println("Tamanys matriu original: " + matriuOriginal.length + " " + matriuOriginal[0].length);
		//System.out.println("Tamanys matriu nova: " + matriu.length + " " + matriu[0].length);

        
		for (int i = 0; i < matriuOriginal.length; ++i) {
			for (int j = 0; j < matriuOriginal[0].length; ++j) {
				matriu[i+1][j+1] = matriuOriginal[i][j];
				//System.out.println("vuelta: " + i + " " + j);
				if (matriu[i+1][j+1] == 1) {
					row1 = i+1;
					column1 = j+1;
				}
				if (matriu[i+1][j+1] > 0) { //valor igual a un numero
					//System.out.println("Afegit a la llista el numero: " + matriu[i+1][j+1]);
					list.add(matriu[i+1][j+1]);
					//System.out.println("Numero afegit 100% real: " + matriu[i+1][j+1]);
				}
				if (matriu[i+1][j+1] > -1) {
					casellesNumeriques++;
				}
			}
		}
		
        Collections.sort(list);
		given = new int[list.size()];
		
		//emplenar given a partir de la llista ordenada
        for (int i = 0; i < given.length; i++){
            given[i] = list.get(i);
            if (i != 0 && given[i] == given[i-1]) {
    				System.out.println("Hi ha repetits: " + given + "    " + given[i-1] + " " + given[i]);
            		return false; //comprova que no ens donin cap nombre repetit
            }
        }
        
        
        /*System.out.println("given:");
		for (int i = 0; i < given.length; ++i) {
			System.out.println(given[i]);
		}*/
		
		if (given[0] != 1) {
			System.out.println("no ens donen el primer numero: " + given + "    " + given[0]);
			return false; //comprova que sempre ens donin el primer numero (i.e. 1)		
		}
		if (given[given.length-1] != casellesNumeriques) {
			System.out.println("no ens donen el ultimo numero: " + given[given.length-1] + "    " + casellesNumeriques);
			return false; //comprova que sempre ens donin el ultimo numero
		}
        
		
		for (int x=0; x<matriu.length;  ++x){
	        	matriu[0][x] = -1;
	        	matriu[x][0] = -1;
	        	matriu[matriu.length-1][x] = -1;
	        	matriu[x][matriu[0].length-1] = -1;
        }
		
		/*for (int i = 0; i < matriu.length; ++i) {
        	for (int j = 0; j < matriu[0].length; ++j) {
        		System.out.print(matriu[i][j]+ " ");
        	}
        	System.out.println();
        }*/
		
	
		return solucionador(row1, column1, 1, 0, given, matriu);
		//return false;
	}
	
	public boolean solucionador(int r, int c, int n, int next, int[] given, int[][] matriuSolucio) {
        if (n > given[given.length - 1]) {
            return true; //s'ha arribat al final (ultim numero) sense trobar cap error    
        }
        
        if (matriuSolucio[r][c] != 0 && matriuSolucio[r][c] != n) {
        		System.out.println("diferent a 0 i diferent a n; value = " + matriuSolucio[r][c] + " i = " + r + " j = " + c + " n = " + n);
            return false; 
        }
 
        if (matriuSolucio[r][c] == 0 && given[next] == n) {
        		System.out.println("igual a 0 i a n");
            return false;
        }
 
        int back = matriuSolucio[r][c];
        if (back == n)
            next++;
     
        matriuSolucio[r][c] = n;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (solucionador(r + i, c + j, n + 1, next, given, matriuSolucio)) {
                
	                	/*for (int ii = 0; ii < matriuSolucio.length; ++ii) {
	                		for (int jj = 0; jj < matriuSolucio[0].length; ++jj) {
	                			System.out.print(matriuSolucio[ii][jj]+ " ");
	                		}
	                		System.out.println();
	                }*/
                		if(n == 1) tractarMatriuSolucio(matriuSolucio);
                		return true;
                }
            }
        }
 
        matriuSolucio[r][c] = back;
        /*for (int i = 0; i < matriuSolucio.length; ++i) {
        		for (int j = 0; j < matriuSolucio[0].length; ++j) {
        			System.out.print(matriuSolucio[i][j]+ " ");
        	}
        	System.out.println();
        }*/
        return false;
    }
	
	private void tractarMatriuSolucio(int[][] matriu) {
		matriuSolucio = new int[matriu.length-2][matriu[0].length-2];
		for (int i = 1; i < matriu.length-1; ++i) {
			for (int j = 1; j < matriu[0].length-1; ++j) {
				matriuSolucio[i-1][j-1] = matriu[i][j];
				
				System.out.print(matriuSolucio[i-1][j-1]+ "   ");
			}
			System.out.println("fins aqui matriu solucio desde algoritmes");
		}

	}

	public int[][] getMatriuSolucio(){		
		return this.matriuSolucio;
	}

	public Dificultat obtenirDificultat() {
		return null;
	}
}