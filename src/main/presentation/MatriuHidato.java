package main.presentation;

import java.awt.*;
import javax.swing.*;
import static java.lang.Math.sqrt;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;


public class MatriuHidato{
  
	private static Vector<Integer> possiblesMoviments = new Vector<Integer>();
	private static int movimentIterator = 0;
	
	
    private MatriuHidato(){
        possiblesMoviments.add(2);
        possiblesMoviments.add(5);
    		possiblesMoviments.add(6);
    		possiblesMoviments.add(8);
        createAndShowGUI();
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MatriuHidato();
            }
        });
    }
    static int[][] board = new int[][]{
        {0,19,0,16,0,-1,10,0,143,144,0,214,213,0,0},
        {21,23,0,0,15,0,12,142,0,0,216,0,207,210,0},
        {0,0,0,0,8,0,6,0,0,219,148,205,0,0,202},
        {0,0,111,-1,0,0,1,3,-1,0,0,0,204,0,0},
        {0,0,112,0,0,99,4,-1,0,138,221,0,0,151,-1},
        {28,0,0,96,100,115,-1,0,137,0,223,224,0,198,0},
        {30,105,0,0,0,117,119,0,132,0,154,0,225,196,0},
        {0,31,0,103,102,120,0,131,134,133,0,0,0,195,0},
        {34,32,92,0,0,87,0,129,0,0,188,0,160,0,0},
        {0,91,0,0,0,0,0,124,128,0,186,189,191,192,0},
        {0,0,0,58,0,83,0,123,125,127,0,184,0,0,163},
        {0,0,59,62,0,84,0,81,0,71,0,0,0,0,164},
        {38,41,0,63,0,0,52,0,0,0,73,171,0,182,165},
        {45,46,0,0,49,0,51,0,69,0,174,175,0,180,179},
        {-2,-2,47,0,0,50,0,0,0,0,-2,0,-2,-2,-2}
        //{0,0,47,0,0,50,0,0,0,0,75,0,176,177,0}
    };
    
    final static int boardHeight = board.length;
    final static int boardWidth = board[0].length;

    final static int BORDER = 15;  
    final static int SCRWIDTH = 600;
    final static int SCRHEIGHT = 600;
    //static double CELLAHEIGHT= ((SCRHEIGHT - (3 * BORDER))/(boardHeight*0.75));
    
    private int ultim = 10;
    
    private void createAndShowGUI(){
            
    		//creació del frame i set de Box Layout
            JFrame frame = new JFrame("Hidato Hexagon");
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
            
    		//creació de panel de Hidato
    		//hardcoded ultim
    		PanelHidato panelHidato = new PanelHidato(new CellaHexagon(), (int)(Math.round(SCRWIDTH*0.9)), (int)(Math.round(SCRHEIGHT*0.9)) , BORDER, board, 225);
		panelHidato.setSeguentMoviment(possiblesMoviments.get(movimentIterator));

    		//panel infoPanel
    		JPanel moviments = new JPanel();
    		moviments.setLayout(new BoxLayout(moviments, BoxLayout.Y_AXIS));
    		
    		//panel Butons de infoPanel
            JPanel buttonsPanel = new JPanel();
    		buttonsPanel.setPreferredSize(new Dimension((int)(Math.round(SCRWIDTH*0)), (int)(Math.round(SCRHEIGHT*0.1))));
    		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.X_AXIS));
    		
    		JLabel proximMoviment = new JLabel(Integer.toString(possiblesMoviments.get(movimentIterator)));
    		
    		Button left = new Button("<");
    		left.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				if (movimentIterator > 0) {
    					--movimentIterator;
    					proximMoviment.setText(Integer.toString(possiblesMoviments.get(movimentIterator)));
    					proximMoviment.repaint();
    					panelHidato.setSeguentMoviment(possiblesMoviments.get(movimentIterator));
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
    					proximMoviment.setText(Integer.toString(possiblesMoviments.get(movimentIterator)));
    					proximMoviment.repaint();
    					panelHidato.setSeguentMoviment(possiblesMoviments.get(movimentIterator));

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
}