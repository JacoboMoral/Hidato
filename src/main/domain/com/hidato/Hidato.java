package main.domain.com.hidato;

import java.util.Collections;
import java.util.Vector;

public abstract class Hidato {

    protected TipusAdjacencia tipusAdjacencia;
    protected Dificultat dificultat;

    //els seguents son protected per tal que el driver pugui accedir (ja que esta fet com una subclasse)
    private int[][] matriuHidato;
    private int[][] matriuOriginal;
    private int[][] matriuSolucio;

    protected Boolean solucionable = false;
    protected Vector<Integer> nombresEscrits;
    protected Vector<Integer> nombresDonats;
    protected Vector<Integer> possiblesMoviments = new Vector<Integer>();
    protected Algorismes al;


    protected Hidato(TipusAdjacencia tipusAdjacencia, int[][] matriu){
		this.tipusAdjacencia = tipusAdjacencia;

        matriuHidato = new int[matriu.length][matriu[0].length];
        copy(matriu, matriu);
        
        makeCopyOriginal(matriuHidato);
        calcPossiblesMoviments();
    }

    protected Hidato(TipusAdjacencia tipusAdjacencia, int[][] matriu, int[][] matriuOriginal, Vector<Integer> nombresEscrits, Vector<Integer> nombresDonats){
		this.tipusAdjacencia = tipusAdjacencia;
		matriuHidato = matriu;
		this.matriuOriginal = matriuOriginal;
		this.nombresEscrits = nombresEscrits;
		this.nombresDonats = nombresDonats;
		calcPossiblesMoviments();

    }

    protected Hidato(TipusAdjacencia tipusAdjacencia) {
    	this.tipusAdjacencia = tipusAdjacencia;

    }
    
    public boolean autogenerar(int forats, int tamanyi, int tamanyj) {
        matriuHidato = al.generarHidato(forats, tamanyi, tamanyj);
        if (matriuHidato != null) {
            matriuOriginal = new int[matriuHidato.length][matriuHidato[0].length];
            copy(matriuOriginal, matriuHidato);
            al.modificarHidato(this);
            dificultat = al.obtenirDificultat();
            return true;
        }
        matriuHidato = null;
        return false;
    }

    public boolean autogenerar(Dificultat dificultat) {
        matriuHidato = al.generarHidato(dificultat);
        if (matriuHidato != null) {
            matriuOriginal = new int[matriuHidato.length][matriuHidato[0].length];
            copy(matriuOriginal, matriuHidato);
            al.modificarHidato(this);
            this.dificultat = dificultat;
            return true;
        }
        matriuHidato = null;
        return false;
    }

    public boolean moviment(int i, int j, int value) {
        if (comprovarMoviment(i, j, value)) {
            matriuHidato[i][j] = value;
            nombresEscrits.add(value);
            Collections.sort(nombresEscrits);
            possiblesMoviments.remove((Integer) value);
            return true;
        } else {
            return false;
        }
    }

    public boolean desferMoviment(int i, int j) {
        int value = matriuHidato[i][j];
        if (notPerDefecte(i, j) && matriuHidato[i][j] > 0) {
            nombresEscrits.remove((Integer) value);
            possiblesMoviments.add(value);
            Collections.sort(possiblesMoviments);
            matriuHidato[i][j] = 0;
            return true;
        } else {
            return false;
        }
    }

    public Vector<Integer> getNombresPerDefecte() {
        return nombresDonats;
    }

    public Vector<Integer> getNombresEscrits() {
        return nombresEscrits;
    }

    public Vector<Integer> getPossiblesMoviments() {
        return possiblesMoviments;
    }

    public int getNombreFiles() {
        return matriuHidato.length;
    }

    public int getNombreColumnes() {
        return matriuHidato[0].length;
    }

    public Dificultat getDificultat() {
        return dificultat;
    }

    public int[][] getMatriu() {
        return matriuHidato;
    }

    public int[][] getMatriuOriginal() {
        return matriuOriginal;
    }

    public void resetMatriu() {
        copy(matriuHidato, matriuOriginal);
        nombresEscrits = new Vector<Integer>(nombresDonats);
        calcPossiblesMoviments();
    }

    public int[][] getSolucio() {
        if (teSolucio()) {
            return matriuSolucio;
        }
        return null;
    }

    public boolean teSolucio() {
        if (solucionable == false) {
            if (al.getMatriuSolucio() != null) {
                matriuSolucio = al.getMatriuSolucio();
                nombresDonats = new Vector<Integer>(al.getGiven());
                nombresEscrits = new Vector<Integer>(al.getGiven());
                calcPossiblesMoviments();
                solucionable = true;
            } else {
                solucionable = al.solucionar();
                nombresDonats = new Vector<Integer>(al.getGiven());
                nombresEscrits = new Vector<Integer>(al.getGiven());
                matriuSolucio = al.getMatriuSolucio();
                calcPossiblesMoviments();
            }
        }
        return solucionable;
    }

    public TipusAdjacencia getTipusAdjacencia() {
        return this.tipusAdjacencia;
    }

    public abstract TipusCella getTipusCella();

    public abstract boolean posicioValida(int i, int j, int r, int c);

    private boolean estaRepetit(int value) {
        return nombresEscrits.contains(value);
    }

    private boolean estaDintreElsLimits(int i, int j) {
        return i >= 0 && i < matriuHidato.length && j >= 0 && j < matriuHidato[0].length;
    }

    private boolean comprovarMoviment(int i, int j, int value) {

        if (matriuHidato[i][j] != 0) {
            return false;
        }
        if (estaRepetit(value)) {
            return false;
        }

        boolean anterior = nombresEscrits.contains(value - 1);
        boolean posterior = nombresEscrits.contains(value + 1);
        if (!anterior && !posterior) {
            return false; 		//si no hi ha escrits ni el anterior ni el posterior
        }
        boolean trobatAnterior = false;

        boolean trobatPosterior = false;

        for (int ii = i - 1; ii < i + 2; ++ii) {
            for (int jj = j - 1; jj < j + 2; ++jj) {
                if (estaDintreElsLimits(ii, jj)) {
                    if (posicioValida(ii - i, jj - j, i, j)) {
                        if ((matriuHidato[ii][jj] - value) == 1) {
                            trobatPosterior = true;
                        }
                        if ((value - matriuHidato[ii][jj]) == 1) {
                            trobatAnterior = true;
                        }
                    }
                }
            }
        }
        if (posterior && !trobatPosterior) {
            return false; 		//si hi ha un posterior escrit pero no esta al voltant
        }
        if (anterior && !trobatAnterior) {
            return false; 		//si hi ha un anterior escrit pero no esta al voltant
        }
        return true; 										//else
    }

    private void makeCopyOriginal(int[][] matriuHidato) {
        int y = matriuHidato.length;
        int x = matriuHidato[0].length;
        matriuOriginal = new int[y][x];
        for (int i = 0; i < y; ++i) {
            for (int j = 0; j < x; ++j) {
                matriuOriginal[i][j] = matriuHidato[i][j];
            }
        }
    }

    private void calcPossiblesMoviments() {
    	possiblesMoviments = new Vector<Integer>();
    	int cellesNumeriques = matriuHidato.length * matriuHidato[0].length;
    	for (int i = 0; i < matriuHidato.length; ++i) {
    		for (int j = 0; j < matriuHidato[0].length; ++j) {
    			int value = matriuHidato[i][j];
    			if (value < 0) {
    				--cellesNumeriques;
    			}
    		}
    	}
    	
    	for (int i = 1; i <= cellesNumeriques; ++i) {
    		if (!nombresEscrits.contains(i)) possiblesMoviments.add(i);
    	}
    	
		Collections.sort(possiblesMoviments);

    }

    private boolean notPerDefecte(int i, int j) {
        return (!nombresDonats.contains(matriuHidato[i][j]));  //return false if nombresDonats contains element at (i,j)
    }

    public boolean completat() {
        return possiblesMoviments.size() == 0;
    }

    private void copy(int[][] destination, int[][] source) {
        //assumeix que destination i source tenen la mateixa mida
        for (int i = 0; i < destination.length; ++i) {
            for (int j = 0; j < destination[0].length; ++j) {
                destination[i][j] = source[i][j];
            }
        }
    }
}
