package main.domain.com.hidato;
import java.util.Collections;
import java.util.Vector;


public class Algoritmes {
	
	private int[][] matriuSolucio;
	private int[][] matriuOriginal;
	TipusCella tipusCella;
	TipusAdjacencia tipusAdjacencia;
	
	Vector<Integer> given = new Vector<Integer>();
	
	public Algoritmes(Hidato hidato) {
		this.matriuOriginal = hidato.getMatriu();
		System.out.println(hidato.getMatriu().length);
		HidatoIO.writeHidatoMatrixToOutput(hidato.getMatriu());
		HidatoIO.writeHidatoMatrixToOutput(hidato.getMatriuOriginal());

		this.tipusAdjacencia = hidato.getTipusAdjacencia();
		this.tipusCella = hidato.getTipusCella();
	}
	
	public boolean solucionar() {

		int row1 = -1; 
		int column1 = -1; //fila i columna on es troba el numero 1
		int [][] matriu = new int[matriuOriginal.length+2][matriuOriginal[0].length+2];
        int casellesNumeriques = 0;
       
		for (int i = 0; i < matriuOriginal.length; ++i) {
			for (int j = 0; j < matriuOriginal[0].length; ++j) {
				matriu[i+1][j+1] = matriuOriginal[i][j];
				if (matriu[i+1][j+1] == 1) {
					row1 = i+1;
					column1 = j+1;
				}
				if (matriu[i+1][j+1] > 0) { //valor igual a un numero
					given.addElement(matriu[i+1][j+1]);
				}
				if (matriu[i+1][j+1] > -1) {
					casellesNumeriques++;
				}
			}
		}
		        
        Collections.sort(given);
		
		if (given.get(0) != 1) {
			System.out.println("no ens donen el primer numero: " + given + "    " + given.get(0));
			return false; //comprova que sempre ens donin el primer numero (i.e. 1)		
		}
		if (given.get(given.size()-1) != casellesNumeriques) {
			System.out.println("no ens donen el ultimo numero: " + given.get(given.size()-1) + "    " + casellesNumeriques);
			return false; //comprova que sempre ens donin el ultimo numero
		}
        
		
		for (int x=0; x<matriu.length;  ++x){
	        	matriu[0][x] = -1;
	        	matriu[x][0] = -1;
	        	matriu[matriu.length-1][x] = -1;
	        	matriu[x][matriu[0].length-1] = -1;
        }
	
		return solucionador(row1, column1, 1, 0, given, matriu);
	}
	
	private boolean solucionador(int r, int c, int n, int next, Vector<Integer> given, int[][] matriuSolucio) {
        if (n > given.get(given.size() - 1)) {
            return true;
        }
        
        if (matriuSolucio[r][c] != 0 && matriuSolucio[r][c] != n) {
            return false; 
        }
 
        if (matriuSolucio[r][c] == 0 && given.get(next) == n) {
            return false;
        }
 
        int back = matriuSolucio[r][c];
        if (back == n)
            next++;
     
        matriuSolucio[r][c] = n;
        
        if (tipusAdjacencia == TipusAdjacencia.COSTATS && tipusCella == TipusCella.QUADRAT) { 	//Q C
        	for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                	if (Math.abs(i + j) == 1) {
	                    if (solucionador(r + i, c + j, n + 1, next, given, matriuSolucio)) {
	                    		if(n == 1) tractarMatriuSolucio(matriuSolucio);
	                    		return true;
	                    }
                	}
                }
            }
        }
        else if (tipusCella == TipusCella.QUADRAT) {        									//Q C
        	for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (solucionador(r + i, c + j, n + 1, next, given, matriuSolucio)) {
                    		if(n == 1) tractarMatriuSolucio(matriuSolucio);
                    		return true;
                    }
                }
            }
        }
        
 
        matriuSolucio[r][c] = back;
        return false;
    }
	
	private void tractarMatriuSolucio(int[][] matriu) {
		matriuSolucio = new int[matriu.length-2][matriu[0].length-2];
		for (int i = 1; i < matriu.length-1; ++i) {
			for (int j = 1; j < matriu[0].length-1; ++j) {
				matriuSolucio[i-1][j-1] = matriu[i][j];
			}
		}
	}

	public int[][] getMatriuSolucio(){		
		return this.matriuSolucio;
	}

	public Dificultat obtenirDificultat() {
		return null;
	}
	
	public Vector<Integer> getGiven() {
		return given;
	}
}