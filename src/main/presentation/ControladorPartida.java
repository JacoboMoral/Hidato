package main.presentation;

import java.awt.Dimension;
import java.util.Random;
import java.util.Vector;

import javax.swing.JOptionPane;
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
    private ControladorNavegacio controladorNavegacio = ControladorNavegacio.getInstance();
    private boolean ajuda = false;
	private boolean allowInputs = true;

    public static ControladorPartida getInstance() {
        if (instance == null) {
            instance = new ControladorPartida();
        }
        return instance;
    }
    
	
	public PanelPartida partidaCarregada(TipusCella tipusCella, int[][] matriuHidato) {
		ajuda = false;
        this.cella = tipusCellaToCella(tipusCella);
        partida = new PanelPartida(cella, matriuHidato);
        return partida;
    }

    public void partidaAutogenerada(TipusCella tipusCella, Dificultat dificultat) {
        this.dificultat = dificultat;
        this.cella = tipusCellaToCella(tipusCella);
        new GeneratorWorker(tipusCella, getRandomTipusAdjacencia(tipusCella), dificultat).execute();
    }

    public void partidaAutogenerada(Dificultat dificultat) {
        this.dificultat = dificultat;
        TipusCella tipusCella = getRandomTipusCella();
		this.cella = tipusCellaToCella(tipusCella);
        new GeneratorWorker(tipusCella, getRandomTipusAdjacencia(tipusCella), dificultat).execute();
    }

    public void partidaAutogenerada(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, Dificultat dificultat) {
        this.dificultat = dificultat;
        this.cella = tipusCellaToCella(tipusCella);
        new GeneratorWorker(tipusCella, tipusAdjacencia, dificultat).execute();
    }
	
	public void partidaAutogenerada(TipusCella tipusCella, int altura, int amplada, int forats) {
		this.cella = tipusCellaToCella(tipusCella);
        new GeneratorWorker(tipusCella, getRandomTipusAdjacencia(tipusCella), altura, amplada, forats).execute();
	}


	public void partidaAutogenerada(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int altura, int amplada, int forats) {
		this.cella = tipusCellaToCella(tipusCella);
		new GeneratorWorker(tipusCella, tipusAdjacencia, altura, amplada, forats).execute();
	}

	public void partidaAutogenerada(int altura, int amplada, int forats) {
		TipusCella tipusCella = getRandomTipusCella();
		this.cella = tipusCellaToCella(tipusCella);
        new GeneratorWorker(tipusCella, getRandomTipusAdjacencia(tipusCella), altura, amplada, forats).execute();
	}

	public boolean ferMoviment(int y, int x, int value) {
		if (!allowInputs) return false;
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
		if (!allowInputs) return false;
        return controller.desferMoviment(y, x);
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
		allowInputs = false;
		new SolverWorker().execute();		
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

	public void setMatriuGenerada(int[][] matriu) {
		if (matriu != null) {
        	partida = new PanelPartida(cella, matriu);
    		VistaPartida v = new VistaPartida(partida);
    		ajuda = false;
    		v.setVisible(true);
            controladorNavegacio.closeMenuPrincipal();
        }
		else {
            controladorNavegacio.enableMenuPrincipal();
			JOptionPane.showMessageDialog(null, "No s'ha pogut generar l'hidato, intenta-ho de nou");
		}
	}
	
	private TipusCella getRandomTipusCella() {
        Random rand = new Random();
        int randomValue = rand.nextInt(3);
        if (randomValue == 0) {
            return TipusCella.QUADRAT;
        }
        if (randomValue == 1) {
            return TipusCella.HEXAGON;
        }
        return TipusCella.TRIANGLE;

    }

    private TipusAdjacencia getRandomTipusAdjacencia(TipusCella tipusCella) {
        if (tipusCella == TipusCella.QUADRAT) {
            Random rand = new Random();
            int randomValue = rand.nextInt(2);
            if (randomValue == 0) return TipusAdjacencia.COSTATSIANGLES;
        }
        return TipusAdjacencia.COSTATS;
    }


	public void setMatriuResolta(int[][] matriuResolta) {
		if (matriuResolta != null) {
			partida.solucionar(matriuResolta);
			view.solucionat();
			allowInputs   = true;
		}
        //controladorNavegacio.enableMenuPrincipal();
	}
}
