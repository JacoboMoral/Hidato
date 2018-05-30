package main.presentation;

import java.awt.Dimension;
import java.util.Vector;

import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.TipusAdjacencia;
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
        if (instance == null) {
            instance = new ControladorPartida();
        }
        return instance;
    }

    public PanelPartida partidaAutogenerada(TipusCella tipusCella, Dificultat dificultat) {
        this.dificultat = dificultat;
        this.cella = tipusCellaToCella(tipusCella);
        int[][] matriuHidato = generarMatriuHidato(tipusCella, dificultat);
        partida = new PanelPartida(cella, matriuHidato);
        return partida;
    }

    public PanelPartida partidaAutogenerada(Dificultat dificultat) {
        this.dificultat = dificultat;
        int[][] matriuHidato = generarMatriuHidato(dificultat);
        this.cella = cella;
        partida = new PanelPartida(cella, matriuHidato);
        return partida;
    }

    public PanelPartida partidaAutogenerada(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, Dificultat dificultat) {
        this.dificultat = dificultat;
        this.cella = tipusCellaToCella(tipusCella);
        int[][] matriuHidato = generarMatriuHidato(tipusCella, tipusAdjacencia, dificultat);
        partida = new PanelPartida(cella, matriuHidato);
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

    private int[][] generarMatriuHidato(TipusCella tipusCella, Dificultat dificultat) {
        if (controller.autoGenerar(tipusCella, dificultat));
        controller.jugarHidatoGenerat();
        return controller.getMatriuHidatoDePartida();
    }

    private int[][] generarMatriuHidato(Dificultat dificultat) {
        if (controller.autoGenerar(dificultat));
        controller.jugarHidatoGenerat();
        return controller.getMatriuHidatoDePartida();
    }

    private int[][] generarMatriuHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, Dificultat dificultat) {
        if (controller.autoGenerar(tipusCella, tipusAdjacencia, dificultat));
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

    public void reset() {
        controller.reset();
        partida.updateMatriu(controller.getMatriuHidatoDePartida());
    }

    private Cella tipusCellaToCella(TipusCella tipusCella) {
        if (tipusCella == TipusCella.QUADRAT) {
            return new CellaQuadrat();
        }
        if (tipusCella == TipusCella.TRIANGLE) {
            return new CellaTriangle();
        }
        if (tipusCella == TipusCella.HEXAGON) {
            return new CellaHexagon();
        }
        return null;
    }

    public void guardarPartida() {
        controller.guardarPartida();
    }

}
