package main.presentation;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class PanelPartida extends JPanel {

    private Vector<Integer> possiblesMoviments = new Vector<Integer>();
    private Vector<Integer> nombresPerDefecte = new Vector<Integer>();

    private int movimentIterator = 0;
    private int[][] matriuHidato = null;
    private final ControladorPartida controller = ControladorPartida.getInstance();

    int boardHeight = 0;
    int boardWidth = 0;

    private int BORDER = 0;

    private int ultim = 10;

    private PanelHidato panelHidato;
    private boolean completat = false;

    private Cella cella;

    public PanelPartida(Cella cella, int[][] matriuHidato) {
        this.cella = cella;
        this.matriuHidato = matriuHidato;
        
        setup();
        getPossiblesMoviments();
        createAndShowGUI();
    }

    private void setup() {

        //matriuHidato = controller.generarMatriuHidato();
        nombresPerDefecte = controller.getNombresPerDefecte();
        boardHeight = matriuHidato[0].length;
        boardWidth = matriuHidato.length;
    }
    
    
    /*public PanelPartida(boolean viejo){
    	getMatriu();
        getPossiblesMoviments();
        createAndShowGUI();
    }*/
    public boolean ferMoviment(int y, int x, int proximMoviment) {
        boolean fet = controller.ferMoviment(y, x, proximMoviment);
        if (fet) {
            getPossiblesMoviments();
            if (controller.partidaCompletada()) {
                completat = true;
            }
            return true;
        }
        return false;
    }

    public boolean desferMoviment(int y, int x) {
        boolean desfet = controller.desferMoviment(y, x);
        if (desfet) {
            getPossiblesMoviments();
            return true;
        }
        return false;
    }

    public int[][] getMatriu() {
        return controller.getMatriuHidato();
    }

    private void getPossiblesMoviments() {
        possiblesMoviments = controller.getPossiblesMoviments();
    }

    private void createAndShowGUI() {

        //creació del frame i set de Box Layout
        /*JFrame frame = new JFrame("Hidato Hexagon");
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));*/
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        //creació de panel de Hidato
        //hardcoded ultim

        //JPanel panelHidatoWithBorder = new JPanel();
        this.setBackground(new Color(0, 153, 153));
        this.setBorder(
                BorderFactory.createEmptyBorder(50, 50, 50, 50));
        this.setLayout(new BorderLayout(50, 50));

        panelHidato = new PanelHidato(cella, matriuHidato, nombresPerDefecte, this);
        //panelHidato.setPreferredSize(new Dimension(screenWidth, (int) (screenHeight)));
        panelHidato.setSeguentMoviment(possiblesMoviments.get(movimentIterator));

        this.add(panelHidato);

        

        //this.add(panelHidatoWithBorder);

        /*frame.getContentPane().add(panelHidato);
    		frame.getContentPane().add(info);
    		
    		
    		frame.setResizable(false);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);*/
    }

    public void updateSeguentMoviment() {
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
    	System.out.println(possiblesMoviments);
    	if ((movimentIterator-1) >= 0) {
        	System.out.println("Holaaa" + " " + movimentIterator);
    		--movimentIterator;
            panelHidato.setSeguentMoviment(possiblesMoviments.get(movimentIterator));
    		return possiblesMoviments.get(movimentIterator);
    	}
    	return -1;
    }

    public void completat() {
        JFrame victoria = new JFrame("Enhorabona");
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(300, 30));
        panel.add(new JLabel("Enhorabona, has completat l'hidato correctament!"));
        victoria.getContentPane().add(panel);
        victoria.setResizable(false);
        victoria.pack();
        victoria.setLocationRelativeTo(null);
        victoria.setVisible(true);
    }

	public int getSeguentMoviment() {
		return possiblesMoviments.get(movimentIterator);
	}

}
