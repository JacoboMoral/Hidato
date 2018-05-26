package main.presentation;

import java.awt.Dimension;
import java.util.Vector;

import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.TipusCella;

public class ControladorPartida {

    private static ControladorPartida instance = null;
    private final ControladorPresentacio controller = ControladorPresentacio.getInstance();
    private Dificultat dificultat = Dificultat.FACIL;
    private Cella cella;
    private PanelPartida partida;
    private VistaPartida view;

    public ControladorPartida() {
    }

    public static ControladorPartida getInstance() {
        if (instance == null) instance = new ControladorPartida();
        return instance;
    }

    public PanelPartida partidaAutogenerada(Cella cella, Dificultat dificultat) {
        this.dificultat = dificultat;
        this.cella = cella;
        partida = new PanelPartida(cella, new Dimension(800, 665));
        return partida;
    }

    public boolean ferMoviment(int y, int x, int value) {
        return controller.ferMoviment(y, x, value);
    }

    public boolean partidaCompletada() {
        return controller.partidaCompletada();
    }

    public boolean desferMoviment(int y, int x) {
        return controller.desferMoviment(y, x);
    }

    public int[][] generarMatriuHidato() {
        if (controller.autoGenerar(cella.getTipusCella(), dificultat));
        controller.jugarHidatoGenerat();
        return controller.getMatriuHidatoDePartida();
    }

    public int[][] getMatriuHidato() {
        return controller.getMatriuHidatoDePartida();
    }

    public Vector<Integer> getNombresPerDefecte() {
        return controller.getNombresPerDefecte();
    }

    public Vector<Integer> getPossiblesMoviments() {
        return controller.getPossiblesMoviments();
    }
    
    public int incrementarSeguentMoviment() {
    	return partida.incrementarMovimentIterator();
    }
    
    public int decrementarSeguentMoviment() {
    	return partida.decrementarMovimentIterator();
    }
    
    public void updateSeguentMoviment(String moviment) {
    	view.updateSeguentMoviment(moviment);
    }
    
    public int getSeguentMoviment() {
    	return partida.getSeguentMoviment();
    }

    public void setView(VistaPartida vistaPartida) {
        view = vistaPartida;
    }
    
}
