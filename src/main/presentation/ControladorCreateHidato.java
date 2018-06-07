package main.presentation;

import java.util.Vector;
import javax.swing.JOptionPane;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class ControladorCreateHidato extends ControladorHidatoGrafic {

	private VistaCreateHidato view;
	private PanelPartida partida;
	private Vector<Integer> possiblesMoviments;
	private Vector<Integer> nombresPerDefecte;
	private int currentWriteable = 0;
	private int[][] matriuCreacio;
	private TipusCella tipusCella;
	private TipusAdjacencia tipusAdjacencia;

	public PanelPartida createHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int i, int j) {
		this.cella = tipusCellaToCella(tipusCella);
		matriuCreacio = new int[i][j];
		this.tipusCella = tipusCella;
		this.tipusAdjacencia = tipusAdjacencia;
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
		int cellesNumeriques = 0;
		for (int i = 0; i < matriuCreacio.length; ++i) {
			for (int j = 0; j < matriuCreacio[0].length; ++j) {
				if (matriuCreacio[i][j] >= 0) {
					++cellesNumeriques;
					nombresPerDefecte.add(matriuCreacio[i][j]);
				}
			}
		}
		for (int i = 1; i <= cellesNumeriques; ++i) {
			if (!nombresPerDefecte.contains(i)) possiblesMoviments.add(i); //si no esta posat, es un possible moviment
		}
	}
	
	public int getCurrentWriteable() {
		return currentWriteable;
	}
	
	public void setSeguentMovimentVista(int seguentMoviment) {
		if (seguentMoviment > 0) view.setSeguentMoviment(seguentMoviment);
		else {
			view.setSeguentMoviment(0);
		}
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
	
	@Override
	public void guardarHidato() {
		System.out.println("enviat per guardar");
		if (getCellesLliures() == 0) JOptionPane.showMessageDialog(null, "Ha d'haver minim una casella lliure");
		new CheckResolubleWorker(tipusCella, tipusAdjacencia, matriuCreacio, this).execute();
	}
	
	public void setResoluble(boolean resoluble) {
		if (resoluble) {
			String hidatoName = JOptionPane.showInputDialog("", "Entra el nom que li vols posar a l'hidato");
		    if (hidatoName != null) controller.guardarHidatoCreat(tipusCella, tipusAdjacencia, matriuCreacio, hidatoName);
		}
		else {
			JOptionPane.showMessageDialog(null, "L'hidato proposat no es resoluble");
		}
	    view.allowInputs();
	}

	private int getCellesLliures() {
		int lliures = 0;
		for (int i = 0; i < matriuCreacio.length; ++i) {
			for (int j = 0; j < matriuCreacio[0].length; ++j) {
				if (matriuCreacio[i][j] == 0) {
					++lliures;
				}
			}
		}
		return lliures;
	}
	
}
