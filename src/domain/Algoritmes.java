
public class Algoritmes {
	
	
	
	public boolean solucionador(int r, int c, int n, int next, int[] given, int[][] Matriu_solucio) {
        if (n > given[given.length - 1])
            return true;
 
        if (Matriu_solucio[r][c] != 0 && Matriu_solucio[r][c] != n)
            return false;
 
        if (Matriu_solucio[r][c] == 0 && given[next] == n)
            return false;
 
        int back = Matriu_solucio[r][c];
        if (back == n)
            next++;
     
        Matriu_solucio[r][c] = n;
        for (int i = -1; i < 2; i++)
            for (int j = -1; j < 2; j++)
                if (solucionador(r + i, c + j, n + 1, next, given, Matriu_solucio))
                    return true;
 
        Matriu_solucio[r][c] = back;
        return false;
    }
}