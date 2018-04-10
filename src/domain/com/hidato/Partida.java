package com.hidato;

public class Partida {
	private Dificultat dificultat;
	private int puntacio;
	private int Date;
	private Hidato hidato;
	boolean finalitzada;
	int[][] solucioHidato;
	
	public Partida(Hidato hidato) {
		this.hidato = hidato;
		dificultat = hidato.getDificultat();
		finalitzada = false;
	}
	
	
	
	public void acabarPartida() {
			
	}
	
	public void reset() {
		
	}
	// i = 0 j = 0 es possible!!!!!!!!!!!!!!!!
	public void ferJugada(int i, int j, int value) {
		if (hidato.movimentAMatriuHidato(i, j, value)) hidato.imprimirMatriuHidato();
		else System.out.println("Moviment no valid");
	}
	
	public void demanarPista() {
		
	}
	public void demanarSolucio() {

		solucioHidato = hidato.getSolucioHidato();
		//System.out.println("hola");
		//System.out.println(hidato.getNombreFiles() + " " + hidato.getNombreColumnes());
		
		
		/*for(int i = 0; i < hidato.getNombreFiles(); ++i) {
			System.out.println(i);
			for(int j = 0; j < hidato.getNombreColumnes(); ++j) {
				System.out.print(solucioHidato[i][j]);
			}
		}
		System.out.println("fins aqui matriu solucio de partida");*/
		
		
		finalitzada = true;
	}
	public void reprendrePartida() {
		
	}
}
/*
Q,CA,3,4
#,1,?,#
?,#,#,#
7,?,9,#

FALSE > FALTAN NUMEROS
*/


/*
Q,CA,3,4
#,1,?,#
?,?,?,?
7,?,9,#

TRUE
*/


/*
Q,CA,5,5
#,#,1,#,#
#,?,*,?,#
8,?,?,?,3
#,?,11,*,#
#,#,?,#,#

TRUE
*/


/*
Wikipedia:

Q,CA,8,8
?,33,35,?,?,#,#,#
?,?,24,22,?,#,#,#
?,?,?,21,?,?,#,#
?,26,?,13,40,11,#,#
27,?,?,?,9,?,1,#
#,#,?,?,18,?,?,#
#,#,#,#,?,7,?,?
#,#,#,#,#,#,5,?

TRUE
*/


/*
Wikipedia modificat:

Q,CA,8,8
?,35,33,?,?,#,#,#
?,?,24,22,?,#,#,#
?,?,?,21,?,?,#,#
?,26,?,13,40,11,#,#
27,?,?,?,9,?,1,#
#,#,?,?,18,?,?,#
#,#,#,#,?,7,?,?
#,#,#,#,#,#,5,?

TRUE
*/