package com.hidato;
import java.util.ArrayList;


import java.util.Objects;
import java.util.Scanner;

public class Hidato {

    private TipusCella tipusCella;
    private TipusAdjacencia tipusAdjacencia;
    private int nombreFiles;
    private int nombreColumnes;
    private int[][] matriuHidato;
    private Dificultat dificultat;
    private Algoritmes al;
    private int[][] hidatoOriginal;
    private int[][] solucioHidato;
    

    public Hidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matriu){
    		this.tipusAdjacencia = tipusAdjacencia;
    		this.tipusCella = tipusCella;
    		nombreFiles = matriu.length;
    		nombreColumnes = matriu[0].length;
    		/*
    		for (int i = 0; i < nombreFiles; ++i) {
    			for (int j = 0; j < nombreColumnes; ++j) {
    				/*Casella c = new Casella(); 
    				if (matriu[i][j] == -2) c.setTipus(TipusCasella.LIMIT);
    				else if (matriu[i][j] == -1) c.setTipus(TipusCasella.FORAT);
    				else if (matriu[i][j] == 0) c.setTipus(TipusCasella.BUIT);
    				else {
    					c.setTipus(TipusCasella.VALOR, matriu[i][j]);
    				}
    			}
    		}
    		*/
    		matriuHidato = hidatoOriginal = matriu;
    		//HidatoIO io = new HidatoIO();
    		//io.writeHidatoToOutput(matriuHidato);
    		al = new Algoritmes(matriuHidato);
    		System.out.println(al.solucionar()); //CANVIAR: SHA DE COMPROBAR QUE ES PUGUI SOLUCIONAR
    		this.dificultat = al.obtenirDificultat();
    		
    }
    
    //NOMES EN CA de moment
    private boolean comprovarMoviment(int i, int j, int value) {
    	for(int ii = i - 1; ii < i + 2; ++ii) {
    		for(int jj = j - 1; jj < j + 2; ++jj) {
    			if(estaDintreElsLimits(ii, jj)) {
    				if (Math.abs(matriuHidato[ii][jj] - value) == 1 ) {
    					return true;
    				}
    			}
    		}
    	}
    	return false;
    }

	private boolean estaDintreElsLimits(int ii, int jj) {
		return ii > 0 && ii < matriuHidato.length && jj > 0 && jj > matriuHidato[0].length;
	}
    
    public boolean movimentAMatriuHidato(int i, int j, int value) {
    	if(comprovarMoviment(i, j, value)) {
    		matriuHidato[i][j] = value;
    		return true;
    	} 
    	else return false;
    }
    
    public int getNombreFiles(){
        return nombreFiles;

    }

    public int getNombreColumnes(){
        return nombreColumnes;

    }

	public Dificultat getDificultat() {
		return dificultat;
	}
	
	public int[][] getSolucioHidato(){
		
		//MEJORAR EFICIENCIA, GUARDAR LA PRIMERA VEZ
		
		solucioHidato = al.getMatriuSolucio();
		/*for(int i = 0; i < matriuHidato.length; ++i) {
			for(int j = 0; j < matriuHidato[0].length; ++j) {
				System.out.print(matriuHidato[i][j] + " ");
			}
			System.out.println();
		}*/
		return solucioHidato;
	}
	
	public void imprimirMatriuHidato() {
		for(int i = 0; i < matriuHidato.length; ++i) {
			for(int j = 0; j < matriuHidato[0].length; ++j) {
				System.out.print(matriuHidato[i][j] + " ");
			}
			System.out.println();
		}
	}

}