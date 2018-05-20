package main.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.TipusCella;

public class ControladorPartida {
	private static final ControladorPartida instance = new ControladorPartida();
    private final ControladorPresentacio controller = ControladorPresentacio.getInstance();
    Dificultat dificultat;
    
    public ControladorPartida() {
    }
    
    public ControladorPartida getInstance() {
    	return instance;
    }
    
    public PanelPartida partidaAutogenerada(Cella cella, Dificultat dificultat) {
    	this.dificultat = dificultat;
    	PanelPartida panel;
    	panel = new PanelPartida(cella, new Dimension(600,600));
    	//panel.setPreferredSize(new Dimension(600,600));
    	return panel;
    }

	public boolean ferMoviment(int y, int x, int value) {
		return controller.ferMoviment(y, x, value);
	}

	public boolean partidaCompletada() {
		return controller.partidaCompletada();
	}

	public boolean desferMoviment(int y, int x) {
		return controller.desferMoviment(y,x);
	}

	public int[][] generarMatriuHidato() {
    	if (controller.autoGenerar(TipusCella.HEXAGON, dificultat));
    	controller.jugarHidatoGenerat();
    	return controller.getMatriuHidatoDePartida();
	}
	
	public int[][] getMatriuHidato(){
		return controller.getMatriuHidatoDePartida();
	}

	public Vector<Integer> getNombresPerDefecte() {
		return controller.getNombresPerDefecte();
	}

	public Vector<Integer> getPossiblesMoviments() {
		return controller.getPossiblesMoviments();
	}
	
	
}
