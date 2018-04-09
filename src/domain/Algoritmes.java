import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Algoritmes {
	
	public boolean solucionar(int[][] matriuOriginal) {
		
	
		
		int row1 = -1;
		int column1 = -1;
		int [][] matriu = new int[matriuOriginal.length+2][matriuOriginal[0].length+2];
		int[] given = null;
        List<Integer> list = new ArrayList<Integer>();		
		
		for (int i = 1; i < matriuOriginal.length-1; ++i) {
			for (int j = 1; j < matriuOriginal[0].length-1; ++j) {
				matriu[i][j] = matriuOriginal[i-1][j-1];
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
		if (given[0] != 1) return false; //comprova que sempre ens donin el primer numero (i.e. 1)
		if (given[given.length-1] != given.length) return false; //comprova que sempre ens donin el ultimo numero
		
        for (int i = 0; i < given.length; i++){
            given[i] = list.get(i);
            if (i != 0 && given[i] == given[i-1]) return false; //comprova que no ens donin cap nombre repetit
        }
        
		
		for (int x=0; x<matriu.length;  ++x){
        	matriu[0][x] = -1;
        	matriu[x][0] = -1;
        	matriu[matriu.length-1][x] = -1;
        	matriu[x][matriu.length-1] = -1;
        }
	
		return solucionador(row1, column1, 1, 0, given, matriu);
	}
	
	public boolean solucionador(int r, int c, int n, int next, int[] given, int[][] matriuSolucio) {
        if (n > given[given.length - 1])
            return true; //s'ha arribat al final (ultim numero) sense trobar cap error
 
        if (matriuSolucio[r][c] != 0 && matriuSolucio[r][c] != n)
            return false;
 
        if (matriuSolucio[r][c] == 0 && given[next] == n)
            return false;
 
        int back = matriuSolucio[r][c];
        if (back == n)
            next++;
     
        matriuSolucio[r][c] = n;
        for (int i = -1; i < 2; i++)
            for (int j = -1; j < 2; j++)
                if (solucionador(r + i, c + j, n + 1, next, given, matriuSolucio))
                    return true;
 
        matriuSolucio[r][c] = back;
        return false;
    }
}