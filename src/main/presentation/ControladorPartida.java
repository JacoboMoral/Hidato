package main.presentation;

import java.awt.Dimension;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import main.domain.com.hidato.ControladorDomini;
import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.HidatoIO;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class ControladorPartida extends ControladorHidatoGrafic{
    
    private static ControladorPartida instance = null;
    private VistaPartida view;
    private PanelPartida partida;
    private boolean ajuda = false;

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
        if (matriuHidato != null) {
        	partida = new PanelPartida(cella, matriuHidato);
            return partida;
        }
        return null;
    }

    public PanelPartida partidaAutogenerada(Dificultat dificultat) {
        this.dificultat = dificultat;
        int[][] matriuHidato = generarMatriuHidato(dificultat);
        if (matriuHidato != null) {
        	TipusCella tipusCella = controller.getTipusCellaPartida();
        	this.cella = tipusCellaToCella(tipusCella);
            partida = new PanelPartida(cella, matriuHidato);
            return partida;
        }
        return null;
    }

    public PanelPartida partidaAutogenerada(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, Dificultat dificultat) {
        this.dificultat = dificultat;
        this.cella = tipusCellaToCella(tipusCella);
        int[][] matriuHidato = generarMatriuHidato(tipusCella, tipusAdjacencia, dificultat);
        if (matriuHidato != null) {
        	partida = new PanelPartida(cella, matriuHidato);
            return partida;
        }
        return null;
    }
	
	public PanelPartida partidaCarregada(TipusCella tipusCella, int[][] matriuHidato) {
        this.cella = tipusCellaToCella(tipusCella);
        partida = new PanelPartida(cella, matriuHidato);
        return partida;
    }
	
	public PanelPartida partidaAutogenerada(TipusCella tipusCella, int altura, int amplada, int forats) {
		this.cella = tipusCellaToCella(tipusCella);
        int[][] matriuHidato = generarMatriuHidato(tipusCella, altura, amplada, forats);
        if (matriuHidato != null) {
        	partida = new PanelPartida(cella, matriuHidato);
    		return partida;
        }
        return null;
	}

	private int[][] generarMatriuHidato(TipusCella tipusCella, int altura, int amplada, int forats) {
		if (controller.autoGenerar(tipusCella, altura, amplada, forats)) {
	        controller.jugarHidatoGenerat();
	        return controller.getMatriuHidatoDePartida();
		}
		return null;
	}

	public PanelPartida partidaAutogenerada(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int altura, int amplada, int forats) {
		this.cella = tipusCellaToCella(tipusCella);
        int[][] matriuHidato = generarMatriuHidato(tipusCella, tipusAdjacencia, altura, amplada, forats);
        if (matriuHidato != null) {
        	partida = new PanelPartida(cella, matriuHidato);
    		return partida;
        }
        return null;
	}
	
	private int[][] generarMatriuHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int altura, int amplada,
			int forats) {
		if (controller.autoGenerar(tipusCella, tipusAdjacencia, altura, amplada, forats)) {
	        controller.jugarHidatoGenerat();
	        return controller.getMatriuHidatoDePartida();
		}
		return null;
	}

	public PanelPartida partidaAutogenerada(int altura, int amplada, int forats) {
        int[][] matriuHidato = generarMatriuHidato(altura, amplada, forats);
		if (matriuHidato != null) {
			TipusCella tipusCella = controller.getTipusCellaPartida();
			this.cella = tipusCellaToCella(tipusCella);
        	partida = new PanelPartida(cella, matriuHidato);
    		return partida;
        }
        return null;
	}
	
	private int[][] generarMatriuHidato(int altura, int amplada, int forats) {
		if (controller.autoGenerar(altura, amplada, forats)) {
			ControladorDomini c = ControladorDomini.getInstance();
	        controller.jugarHidatoGenerat();
	        return controller.getMatriuHidatoDePartida();
		}
		return null;
	}

	public boolean ferMoviment(int y, int x, int value) {
		boolean movimentPossible = controller.ferMoviment(y, x, value, ajuda);
		if (movimentPossible) {
			return true;
		}
		return false;
    }

    public boolean partidaCompletada() {
        if (controller.partidaCompletada()) {
        	view.setPartidaAcabada();
        	return true;
        }
        return false;
    }

    public boolean desferMoviment(int y, int x) {
        return controller.desferMoviment(y, x);
    }

    private int[][] generarMatriuHidato(TipusCella tipusCella, Dificultat dificultat) {
        if (controller.autoGenerar(tipusCella, dificultat)) {
        	controller.jugarHidatoGenerat();
            return controller.getMatriuHidatoDePartida();
        }
        return null;
        
    }

    private int[][] generarMatriuHidato(Dificultat dificultat) {
        if (controller.autoGenerar(dificultat)) {
        	controller.jugarHidatoGenerat();
            return controller.getMatriuHidatoDePartida();
        }
        return null;
    }

    private int[][] generarMatriuHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, Dificultat dificultat) {
        if (controller.autoGenerar(tipusCella, tipusAdjacencia, dificultat)) {
        	controller.jugarHidatoGenerat();
            return controller.getMatriuHidatoDePartida();
        }
        return null;
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
    
    public Cella tipusCellaToCella(TipusCella tipusCella) {
    	if (tipusCella == TipusCella.QUADRAT) return new CellaQuadrat();
    	if (tipusCella == TipusCella.TRIANGLE) return new CellaTriangle();
    	if (tipusCella == TipusCella.HEXAGON) return new CellaHexagon();
    	return null;
    }
  
    public void guardarPartida() {
        controller.guardarPartida();
    }

	public void solucionarPartida() {
		int[][] matriuSolucio = controller.solucionarPartida();
		if (matriuSolucio != null) partida.solucionar(matriuSolucio);
		
	}

	public long tempsSolucionarPartida() {
		return controller.getTempsSolucionarPartida();
	}    
	
	public int getPuntuacioPartida() {
		return controller.getPuntuacioPartida();
	}

	public void setAjuda(boolean ajuda) {
		this.ajuda = ajuda;
	}
}
