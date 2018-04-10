package com.hidato;

public class Partida {
	private Dificultat dificultat;
	private int puntacio;
	private int Date;
	private Hidato hidato;
	boolean finalitzada;
	
	public Partida() {
		finalitzada = false;
	}
	
	public void checkCorrecte() {
		
	}
	
	public void acabarPartida() {
			
	}
	
	public void reset() {
		
	}
	public void ferJugada() {
			
	}
	public void demanarPista() {
		
	}
	public void demanarSolucio() {
		
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