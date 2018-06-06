import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Vector;

import javafx.util.Pair;
import main.domain.com.hidato.HidatoIO;

public class Solver {

	private static int[][] matriuSolucio = new int[][] {
		{1,-1,-1},
		{2,11,-1},
		{3,10,9},
		{4,-1,8},
		{5,6,7}
	};
	private static int[][] matriuOriginal = new int[][] {
		{1,-1,-1},
		{0,11,-1},
		{0,0,0},
		{0,-1,8},
		{5,0,0}
	};

	private static int[][] matriuHidato = new int[][] {
		{1,-1,-1},
		{0,11,-1},
		{3,0,0},
		{0,-1,8},
		{5,0,0}
	};
	
	private static Vector<Integer> nombresDonats;
	private static HashMap<Pair<Integer,Integer>,ArrayList<Pair<Integer,Integer>>> adjacencies;
	private static int[][] visitats;
	private static Pair<Integer,Integer> posicioInicial;
		
	public static void main(String[] args) {
		setUp();
		System.out.println(nombresDonats);
		boolean solved = solver(posicioInicial,1,0);
		HidatoIO.writeHidatoMatrixToOutput(matriuHidato);
		System.out.println(solved);
	}

	/*
	 * 
	 *        
	int anterior = matriuSolucio[fila][columna];

	if (anterior == profunditat) seg++;

    matriuSolucio[fila][columna] = profunditat;
    */
	
	private static boolean solver(Pair<Integer,Integer> posicioActual, int nivell, int nombresDonatsVists) {

		//HidatoIO.writeHidatoMatrixToOutput(matriuHidato);
		//System.out.println(posicioActual + "   " + nombresDonatsVists + " " + nivell + "     " +  getLastOf(nombresDonats));
        if (nivell > getLastOf(nombresDonats)) return true;
		
        int valuePosicioActual = getValue(matriuHidato,posicioActual);
		if (!equals(valuePosicioActual,0) && !equals(valuePosicioActual, nivell)) return false;
		if (equals(valuePosicioActual, 0) && equals(getValue(nombresDonats, nombresDonatsVists), nivell)) return false;
		
		//setValue(visitats,posicioActual, 1);	
		
		int reserva = getValue(matriuHidato,posicioActual);
		if (equals(reserva,nivell)) {
			//System.out.println("augmentem nombres donats visitats");
			nombresDonatsVists++;
		}
		setValue(matriuHidato,posicioActual, nivell);

		for (Pair<Integer,Integer> posicioAdjacent: adjacencies.get(posicioActual)) {
			if (solver(posicioAdjacent, nivell+1, nombresDonatsVists)) return true;
			//solver(posicioAdjacent, nivell+1);

		}

		setValue(matriuHidato,posicioActual,reserva);
		return false;
	}


	//POR MEJORAR:
	//PODRIA NO AÑADIR A LAS ADYACENCIAS DE UN "NODO", SUS "NODOS" ADYACENTES CUYO VALOR SEA -2,-1 U OTRO VALOR NO SIGUIENTE (-2, -1 HECHO)

	//POR MEJORAR:
	//PODRIA MIRAR TODAS LAS POSIBILIDADES INICIALES Y RELLENAR AQUELLAS QUE SOLO TENGAN UNA POSIBILIDAD
	// O SINO, HACER ESTO PARA CADA VUELTA (QUIZAS COMPARAR AMBAS OPCIONES VS NINGUNA?)
	
	//añadir como condicion del bucle mas interno (trobatSeguent == false) para no tener que recorrer vueltas innecesarias
	private static void setUp() {
		adjacencies = new HashMap<Pair<Integer,Integer>,ArrayList<Pair<Integer,Integer>>>();
		nombresDonats = new Vector<Integer>();
		visitats = new int[matriuHidato.length][matriuHidato[0].length];
		
		for (int i = 0; i < matriuHidato.length; ++i) {
			for (int j = 0; j < matriuHidato[0].length; ++j) {
				if (matriuHidato[i][j] < 0) continue;
				if (matriuHidato[i][j] > 0) {
					System.out.println(nombresDonats);
					System.out.println(matriuHidato[i][j]);
					int index = Collections.binarySearch(nombresDonats, matriuHidato[i][j]);
					if (index < 0) index = (index * -1) - 1;
					nombresDonats.add(index,matriuHidato[i][j]);
					
					if (matriuHidato[i][j] == 1) posicioInicial = new Pair<Integer,Integer>(i,j); //aixo ha de passar un i nomes un cop
				}

				Pair<Integer,Integer> posicioElement = new Pair<Integer,Integer>(i,j);
				ArrayList<Pair<Integer,Integer>> posicionsAdjacents = new ArrayList<Pair<Integer,Integer>>();
				int valuePosicio = getValue(matriuHidato,posicioElement);
				boolean trobatSeguent = false;
				for (int ii = -1; ii < 2; ii++) {
					for (int jj = -1; jj < 2 && trobatSeguent == false; jj++) {
						Pair<Integer,Integer> posicioAdjacent = new Pair<Integer,Integer>(i+ii,j+jj);
						if (posicioValida(ii, jj, i, j) && dinsLimits(i + ii, j + jj, matriuHidato.length, matriuHidato[0].length) && matriuHidato[i+ii][j+jj] > -1) {
							int valuePosicioAdjacent = getValue(matriuHidato,posicioAdjacent);
							
							//si trobem el seguent nombre, posem aquest com a unica posicio adjacent
							if (valuePosicioAdjacent-getValue(matriuHidato,posicioElement) == 1 && valuePosicio != 1 && valuePosicioAdjacent != 1) {
								trobatSeguent = true;		
								posicionsAdjacents = new ArrayList<Pair<Integer,Integer>>();
								posicionsAdjacents.add(new Pair<Integer,Integer>(i+ii,j+jj));
								continue;
							}

							//si dues caselles amb valor diferent de 0 son adjacents pero no son una la seguent de l'altra, no es posa com que son adjacents
							else if (!(valuePosicioAdjacent != 0 && valuePosicio != 0 && Math.abs(valuePosicioAdjacent-getValue(matriuHidato,posicioElement)) != 1)) {
								posicionsAdjacents.add(posicioAdjacent);
							}
						}
					}
				}
				adjacencies.put(posicioElement, posicionsAdjacents);
			}
		}
	}

	private static boolean posicioValida(int distanciaVertical, int distanciaHoritzontal, int fila, int columna) {
		if (distanciaVertical == 0 && distanciaHoritzontal == 0) return false;
		return true;
	}

	private static boolean dinsLimits(int posicioVertical, int posicioHoritzontal, int altura, int amplada) {
		if (posicioVertical >= 0 && posicioVertical < altura && posicioHoritzontal >= 0 && posicioHoritzontal < amplada) return true;
		return false;
	}
	
	private static int getValue(int[][] matriu, Pair<Integer, Integer> posicio) {
		return matriu[posicio.getKey()][posicio.getValue()];
	}

	private static int getValue(Vector<Integer> vector, int index) {
		return vector.get(index); 
	}
	
	private static void setValue(int[][] matriu, Pair<Integer, Integer> posicio, int value) {
		matriu[posicio.getKey()][posicio.getValue()] = value;
	}
	
	private static boolean equals(int value1, int value2) {
		return (value1 == value2);
	}

	private static int getLastOf(Vector<Integer> vector) {
		return vector.get(vector.size()-1);
	}

}
