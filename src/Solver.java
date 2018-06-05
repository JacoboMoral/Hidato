import java.util.ArrayList;
import java.util.Vector;

import javafx.util.Pair;

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
		{2,11,-1},
		{3,0,0},
		{0,-1,8},
		{5,0,0}
	};

	private static Vector<Integer> nombresDonats;
	private static ArrayList<Pair<Pair<Integer,Integer>, ArrayList<Pair<Integer,Integer>>>> matriuAdjacencies;
	private static Pair<Integer,Integer> posicioInicial;
	private static int casellesNumeriques;
	private static int nombresEscrits;
	
	public static void main(String[] args) {
		setUp();
		//System.out.println(matriuAdjacencies);
		solver(posicioInicial);
	}

	
	private static boolean solver(Pair<Integer,Integer> posicio) {
		if (casellesNumeriques == nombresEscrits) return true;
		System.out.println(posicioInicial);
		System.out.println(matriuAdjacencies.indexOf(posicioInicial));
		//ArrayList<Pair<Integer,Integer>> llistaAdjacencies = matriuAdjacencies.get(matriuAdjacencies.indexOf(posicioInicial)).getValue();
		//for (ArrayList<Pair<Integer, Integer>> element: matriuAdjacencies.)) {
		//	Pair<Integer,Integer> posicio = element.getKey();
		//llistaAdjacencies.forEach((element) -> System.out.println(element));
		return true;
		
	}


	//POR MEJORAR:
	//PODRIA NO AÑADIR A LAS ADYACENCIAS DE UN "NODO", SUS "NODOS" ADYACENTES CUYO VALOR SEA -2,-1 U OTRO VALOR NO SIGUIENTE
	
	//POR MEJORAR:
	//PODRIA MIRAR TODAS LAS POSIBILIDADES INICIALES Y RELLENAR AQUELLAS QUE SOLO TENGAN UNA POSIBILIDAD
	// O SINO, HACER ESTO PARA CADA VUELTA (QUIZAS COMPARAR AMBAS OPCIONES VS NINGUNA?)
	private static void setUp() {
		matriuAdjacencies = new ArrayList<Pair<Pair<Integer,Integer>, ArrayList<Pair<Integer,Integer>>>>();
		nombresDonats = new Vector<Integer>();
		
		for (int i = 0; i < matriuHidato.length; ++i) {
			ArrayList<Pair<Integer,Integer>> aux = new ArrayList<Pair<Integer,Integer>>();
			for (int j = 0; j < matriuHidato[0].length; ++j) {				
				if (matriuHidato[i][j] > 0) {
					nombresDonats.add(matriuHidato[i][j]);
					if (matriuHidato[i][j] == 1) posicioInicial = new Pair<Integer,Integer>(i,j); //aixo ha de passar un i nomes un cop
				}
				//System.out.println(i + " " + j);

				Pair<Integer,Integer> posicioElement = new Pair<Integer,Integer>(i,j);
				ArrayList<Pair<Integer,Integer>> posicionsAdjacents = new ArrayList<Pair<Integer,Integer>>();
				for (int ii = -1; ii < 2; ii++) {
					for (int jj = -1; jj < 2; jj++) {
						if (posicioValida(ii, jj, i, j) && dinsLimits(i + ii, j + jj, matriuHidato.length, matriuHidato[0].length)) {
							posicionsAdjacents.add(new Pair<Integer,Integer>(i+ii,j+jj));
						}
					}
				}
				//System.out.println(posicioElement);
				//System.out.println(posicionsAdjacents);
				matriuAdjacencies.add(new Pair<Pair<Integer,Integer>, ArrayList<Pair<Integer,Integer>>> (posicioElement, posicionsAdjacents));
			}
		}
		casellesNumeriques = nombresDonats.size();
	}

	private static boolean posicioValida(int distanciaVertical, int distanciaHoritzontal, int fila, int columna) {
		if (distanciaVertical == 0 && distanciaHoritzontal == 0) return false;
		return true;
	}

	private static boolean dinsLimits(int posicioVertical, int posicioHoritzontal, int altura, int amplada) {
		if (posicioVertical >= 0 && posicioVertical < altura && posicioHoritzontal >= 0 && posicioHoritzontal < amplada) return true;
		//System.out.println("Fora dels limits: " + posicioVertical + ", " + posicioHoritzontal);
		return false;
	}

}
