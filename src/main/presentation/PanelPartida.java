package main.presentation;

import java.awt.*;
import javax.swing.*;

import main.domain.com.hidato.HidatoIO;

import java.util.Vector;

public class PanelPartida extends JPanel {

    private Vector<Integer> possiblesMoviments = new Vector<Integer>();
    private Vector<Integer> nombresPerDefecte = new Vector<Integer>();

    private int movimentIterator = 0;
    private int[][] matriuHidato = null;
    private final ControladorHidatoGrafic controller;

    int boardHeight = 0;
    int boardWidth = 0;

    private PanelHidato panelHidato;
    private Cella cella;
    
    private int tipusHidato = 0; // 0 = partida normal; 1 = creacio de hidato 

    public PanelPartida(Cella cella, int[][] matriuHidato) {
        this.cella = cella;
        this.matriuHidato = matriuHidato;
        controller = ControladorPartida.getInstance();
        setup();
        createAndShowGUI();

    }
    
    public PanelPartida(Cella cella, int[][] matriuHidato, boolean creacio, ControladorHidatoGrafic controller) {
        this.cella = cella;
        this.matriuHidato = matriuHidato;
        tipusHidato = 1;
        //controller = ControladorCreateHidato.getInstance();
        this.controller = controller;
        setup();
        //createAndShowGUI();
        
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(0, 153, 153));
        this.setBorder(
                BorderFactory.createEmptyBorder(50, 50, 50, 50));
        this.setLayout(new BorderLayout(50, 50));

        panelHidato = new PanelHidato(cella, matriuHidato, this);
        panelHidato.setSeguentMoviment(possiblesMoviments.get(movimentIterator));

        this.add(panelHidato);

    }

    private void setup() {

        nombresPerDefecte = controller.getNombresPerDefecte();
        System.out.println(nombresPerDefecte);
        boardHeight = matriuHidato[0].length;
        boardWidth = matriuHidato.length;
        setPossiblesMoviments();

    }

    private boolean ferMoviment(int y, int x, int proximMoviment) {
        boolean fet = controller.ferMoviment(y, x, proximMoviment);
        if (fet) {
            setPossiblesMoviments();
            return true;
        }
        return false;
    }

    private boolean desferMoviment(int i, int j) {
        boolean desfet = controller.desferMoviment(i, j);
        if (desfet) {
            setPossiblesMoviments();
            return true;
        }
        return false;
    }
    
    public boolean tractaClick(int i, int j, int mouseButton) {
    	setPossiblesMoviments();
    	if (movimentIterator >= possiblesMoviments.size()) return false;
		if (tipusHidato == 0 && mouseButton == 0) { //partida i boto esquerre
			boolean possible = ferMoviment(i,j,possiblesMoviments.get(movimentIterator));
			if (!possible) possible = desferMoviment(i,j);
			if (possible) updateSeguentMoviment();
			return possible;
		}
		else if (tipusHidato == 1) {
			if (mouseButton == 0) {
				tractaMatriu(i,j,possiblesMoviments.get(movimentIterator));
				setPossiblesMoviments();
				controller.setSeguentMovimentVista(possiblesMoviments.get(movimentIterator));
				return true;
			}
			else if (mouseButton == 1) {
				tractaMatriu(i,j, true);
				setPossiblesMoviments();
				controller.setSeguentMovimentVista(possiblesMoviments.get(movimentIterator));
				return true;
			}
		}
		return false;
	}

    private void tractaMatriu(int i, int j, int value) {
    		matriuHidato[i][j] = value;
    }
    
    private void tractaMatriu(int i, int j, boolean esborra) {
    	matriuHidato[i][j] = 0;
    }
    
    public int[][] getMatriu() {
    	matriuHidato = controller.getMatriuHidato();
        return matriuHidato;
    }
    
    public void updateMatriu(int[][] matriu) {
	    	panelHidato.updateMatriu(matriu);
	    	setPossiblesMoviments();
	    	movimentIterator = 0;
	    	panelHidato.setSeguentMoviment(possiblesMoviments.get(movimentIterator));
	    	updateSeguentMoviment();
    }

    private void setPossiblesMoviments() {
        possiblesMoviments = controller.getPossiblesMoviments();
    }

    private void createAndShowGUI() {

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(new Color(0, 153, 153));
        this.setBorder(
                BorderFactory.createEmptyBorder(50, 50, 50, 50));
        this.setLayout(new BorderLayout(50, 50));

        panelHidato = new PanelHidato(cella, matriuHidato, nombresPerDefecte, this);

        panelHidato.setSeguentMoviment(possiblesMoviments.get(movimentIterator));

        
        this.add(panelHidato);


    }

    private void updateSeguentMoviment() {
        if (possiblesMoviments.size() > 0) {
            if (movimentIterator >= possiblesMoviments.size()) {
                --movimentIterator;
            }
            controller.updateSeguentMoviment(Integer.toString(possiblesMoviments.get(movimentIterator)));
            panelHidato.setSeguentMoviment(possiblesMoviments.get(movimentIterator));
        } else {
            controller.updateSeguentMoviment(" ");
        }
    }
    
    public int incrementarMovimentIterator(){
    	if ((movimentIterator+1) < possiblesMoviments.size()) {
    		++movimentIterator;
            panelHidato.setSeguentMoviment(possiblesMoviments.get(movimentIterator));
    		return possiblesMoviments.get(movimentIterator);
    	}
    	return -1;
    }
    
    public int decrementarMovimentIterator(){
    	if ((movimentIterator-1) >= 0) {
    		--movimentIterator;
            panelHidato.setSeguentMoviment(possiblesMoviments.get(movimentIterator));
    		return possiblesMoviments.get(movimentIterator);
    	}
    	return -1;
    }


	public int getSeguentMoviment() {
		return possiblesMoviments.get(movimentIterator);
	}

	

}
