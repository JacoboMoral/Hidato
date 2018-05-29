package main.presentation;

import java.util.Vector;

import main.domain.com.hidato.HidatoIO;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class ControladorCreateHidato extends ControladorHidatoGrafic {

	private VistaCreateHidato view;
	private PanelPartida partida;
	private static ControladorCreateHidato instance = null;
	private Vector<Integer> possiblesMoviments;
	private Vector<Integer> nombresPerDefecte;
	private int currentWriteable = 0;
	private int[][] matriuCreacio;

	/*public static ControladorCreateHidato getInstance() {
        if (instance == null) instance = new ControladorCreateHidato();
        return instance;
    }*/

	public PanelPartida createHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int i, int j) {
		this.cella = tipusCellaToCella(tipusCella);
		matriuCreacio = new int[i][j];
		partida = new PanelPartida(cella,matriuCreacio, true, this);
		return partida;
	}

	public void setView(VistaCreateHidato vistaCreateHidato) {
		view = vistaCreateHidato;
	}


	public void setAlmoadilla() {
		currentWriteable = -2;
	}


	public void setNumero() {
		currentWriteable = 0;
	}


	public void setAsterisc() {	
		currentWriteable = -1;
	}

	public int[][] getMatriuHidato() {
		return matriuCreacio;
	}

	public Vector<Integer> getNombresPerDefecte() {
		if (nombresPerDefecte == null) nombresPerDefecte = new Vector<Integer>();
		return nombresPerDefecte;
	}

	public Vector<Integer> getPossiblesMoviments() {
		calcPossiblesMoviments();
		return possiblesMoviments;
	}

	private void calcPossiblesMoviments() {
		possiblesMoviments = new Vector<Integer>();
		nombresPerDefecte = new Vector<Integer>();
		int celesNumeriques = 0;
		for (int i = 0; i < matriuCreacio.length; ++i) {
			for (int j = 0; j < matriuCreacio[0].length; ++j) {
				if (matriuCreacio[i][j] >= 0) {
					++celesNumeriques;
					nombresPerDefecte.add(matriuCreacio[i][j]);
				}
			}
		}
		if (currentWriteable == 0) {
			for (int i = 1; i <= celesNumeriques; ++i) {
				if (!nombresPerDefecte.contains(i)) possiblesMoviments.add(i); //si no esta posat, es un possible moviment
			}
		}

		else if (currentWriteable == -1) {
			for (int i = 1; i <= celesNumeriques; ++i) {
				possiblesMoviments.add(-1); //si no esta posat, es un possible moviment
			}
		}

		else if (currentWriteable == -2) {
			for (int i = 1; i <= celesNumeriques; ++i) {
				possiblesMoviments.add(-2); //si no esta posat, es un possible moviment
			}
		}	
	}
	
	public void setSeguentMovimentVista(int seguentMoviment) {
		if (seguentMoviment > 0) view.setSeguentMoviment(seguentMoviment);
	}
	
	public void reset() {
		matriuCreacio = new int[matriuCreacio.length][matriuCreacio[0].length];
		partida.updateMatriu(matriuCreacio);
	}

	@Override
	public int decrementarSeguentMoviment() {
		return partida.decrementarMovimentIterator();
	}

	@Override
	public int incrementarSeguentMoviment() {
		return partida.incrementarMovimentIterator();
	}
	
	@Override
	public int getMaximMoviment() {
		return possiblesMoviments.get(possiblesMoviments.size()-1);
	}
	
	@Override
	public int getMinimMoviment() {
		return possiblesMoviments.get(0);
	}
	
}
