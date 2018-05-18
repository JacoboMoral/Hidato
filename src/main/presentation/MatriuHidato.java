package main.presentation;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;

import main.domain.com.hidato.ControladorDomini;
import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.TipusCella;


public class MatriuHidato{
  
	private static Vector<Integer> possiblesMoviments = new Vector<Integer>();
	private static Vector<Integer> nombresPerDefecte = new Vector<Integer>();
	
	private static int movimentIterator = 0;
	private int[][] matriuHidato = null;
	private final ControladorDomini domini = new ControladorDomini().getInstance();
	private final ControladorPresentacio controller = new ControladorPresentacio().getInstance();

	
	static int boardHeight = 0;
    static int boardWidth = 0;

    final static int BORDER = 0;  
    final static int SCRWIDTH = 600;
    final static int SCRHEIGHT = 600;
    //static double CELLAHEIGHT= ((SCRHEIGHT - (3 * BORDER))/(boardHeight*0.75));
    
    private int ultim = 10;
	
    private PanelHidato panelHidato;
    private JLabel proximMoviment;
    
	
    public MatriuHidato(){
    	generarHidato();
    	getNombresPerDefecte();
        getPossiblesMoviments();
        createAndShowGUI();
    }
    
    public boolean ferMoviment(int y, int x, int proximMoviment) {
		boolean fet = controller.ferMoviment(y,x,proximMoviment);
		if (fet) {
			getPossiblesMoviments();
			return true;
		}
		return false;
	}

	public boolean desferMoviment(int y, int x) {
		boolean desfet = controller.desferMoviment(y,x);
		if (desfet) {
			getPossiblesMoviments();
			return true;
		}
		return false;
	}


	private void generarHidato() {
    	domini.autoGenerar(TipusCella.HEXAGON, Dificultat.MIG);
    	domini.jugarHidatoGenerat();
    	matriuHidato = domini.getMatriuHidatoDePartida();
    	
    	boardHeight = matriuHidato[0].length;
    	boardWidth = matriuHidato.length;
	}
	
    private void getNombresPerDefecte() {
		nombresPerDefecte = domini.getNombresPerDefecte();
	}

	private void getPossiblesMoviments() {
		possiblesMoviments = domini.getPossiblesMoviments();
	}

	public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MatriuHidato();
            }
        });
    }

    
    
    private void createAndShowGUI(){
            
    		//creació del frame i set de Box Layout
            JFrame frame = new JFrame("Hidato Hexagon");
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
            
    		//creació de panel de Hidato
    		//hardcoded ultim
    		panelHidato = new PanelHidato(new CellaHexagon(), matriuHidato, 225, nombresPerDefecte, this);
    		panelHidato.setPreferredSize(new Dimension(SCRWIDTH,SCRHEIGHT));
    		panelHidato.setSeguentMoviment(possiblesMoviments.get(movimentIterator));

    		//panel infoPanel
    		JPanel moviments = new JPanel();
    		moviments.setLayout(new BoxLayout(moviments, BoxLayout.Y_AXIS));
    		
    		//panel Butons de infoPanel
            JPanel buttonsPanel = new JPanel();
    		buttonsPanel.setPreferredSize(new Dimension((int)(Math.round(SCRWIDTH*0)), (int)(Math.round(SCRHEIGHT*0.1))));
    		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
    		
    		proximMoviment = new JLabel(Integer.toString(possiblesMoviments.get(movimentIterator)));
    		
    		Button left = new Button("<");
    		left.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				if (movimentIterator > 0) {
    					--movimentIterator;
    					updateSeguentMoviment();
    				}

    			}
    		});
    		left.setFont(new Font("Dialog", Font.PLAIN, 26));
    		
    		Button right = new Button(">");
    		right.setFont(new Font("Dialog", Font.PLAIN, 26));
    		right.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent arg0) {
    				if (movimentIterator < possiblesMoviments.size()-1) {
    					++movimentIterator;
    					System.out.println("iterator: " + movimentIterator + " possiblesMoviments: " + possiblesMoviments);
    					updateSeguentMoviment();
    				}
    			}
    		});
    		
    		buttonsPanel.add(left);
    		
    		buttonsPanel.add(proximMoviment);
    		
    		buttonsPanel.add(right);
    		
    		//panel infoMoviment de infoPanel
    		
    		JPanel accions = new JPanel();
    		accions.setPreferredSize(new Dimension((int)(Math.round(SCRWIDTH*0)), (int)(Math.round(SCRHEIGHT*0.08))));
    		
    		moviments.add(buttonsPanel);
    		moviments.add(accions);

    		frame.add(panelHidato);
    		frame.add(moviments);
    		
    		
    		frame.setResizable(false);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
    }

	public void updateSeguentMoviment() {
		proximMoviment.setText(Integer.toString(possiblesMoviments.get(movimentIterator)));
		panelHidato.setSeguentMoviment(possiblesMoviments.get(movimentIterator));
	}

	
}