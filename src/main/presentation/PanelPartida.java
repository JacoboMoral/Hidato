package main.presentation;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.Vector;
import java.awt.event.ActionEvent;


public class PanelPartida extends JPanel{
  
	private Vector<Integer> possiblesMoviments = new Vector<Integer>();
	private Vector<Integer> nombresPerDefecte = new Vector<Integer>();
	
	private int movimentIterator = 0;
	private int[][] matriuHidato = null;
	private final ControladorPartida controller = new ControladorPartida().getInstance();

	
	int boardHeight = 0;
    int boardWidth = 0;

    private int BORDER = 0;  
    private int screenWidth;
    private int screenHeight;
    //static double CELLAHEIGHT= ((SCRHEIGHT - (3 * BORDER))/(boardHeight*0.75));
    
    private int ultim = 10;
	
    private PanelHidato panelHidato;
    private JLabel proximMovimentLabel;
    private boolean completat = false;
    
    private Cella cella;
    
	
    public PanelPartida(Cella cella, Dimension dimension){
    	this.cella = cella;
    	this.setPreferredSize(dimension);
    	screenHeight = dimension.height;
    	screenWidth = dimension.width;
    	getMatriu();
        getPossiblesMoviments();
        createAndShowGUI();
    }
    
    
    /*public PanelPartida(boolean viejo){
    	getMatriu();
        getPossiblesMoviments();
        createAndShowGUI();
    }*/
    
    public boolean ferMoviment(int y, int x, int proximMoviment) {
		boolean fet = controller.ferMoviment(y,x,proximMoviment);
		if (fet) {
			getPossiblesMoviments();
			if (controller.partidaCompletada()) completat = true;
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

	private void getMatriu() {

    	matriuHidato = controller.getMatriuHidato();
		nombresPerDefecte = controller.getNombresPerDefecte();
    	boardHeight = matriuHidato[0].length;
    	boardWidth = matriuHidato.length;
	}

	private void getPossiblesMoviments() {
		possiblesMoviments = controller.getPossiblesMoviments();
	}
 
    private void createAndShowGUI(){
            
    		//creació del frame i set de Box Layout
            /*JFrame frame = new JFrame("Hidato Hexagon");
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
    		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));*/
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    		//creació de panel de Hidato
    		//hardcoded ultim
    		panelHidato = new PanelHidato(cella, matriuHidato, 225, nombresPerDefecte, this);
    		panelHidato.setPreferredSize(new Dimension(screenWidth,(int)(screenHeight*0.9)));
    		panelHidato.setSeguentMoviment(possiblesMoviments.get(movimentIterator));

    		//panel infoPanel
    		JPanel info = new JPanel();
    		info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
    		
    		//panel Butons de infoPanel
            JPanel movimentPanel = new JPanel();
    		//movimentPanel.setPreferredSize(new Dimension((int)(Math.round(SCRWIDTH*0)), (int)(Math.round(SCRHEIGHT*0.1))));
    		movimentPanel.setLayout(new BoxLayout(movimentPanel, BoxLayout.X_AXIS));
    		
    		JButton left = new JButton("<");
    		left.setFocusable(false);
    		left.setFocusTraversalKeysEnabled(false);
    		left.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    		left.addActionListener(new ActionListener() {
    			public void actionPerformed(ActionEvent e) {
    				if (movimentIterator > 0) {
    					--movimentIterator;
    					updateSeguentMoviment();
    				}

    			}
    		});
    		left.setFont(new Font("Dialog", Font.PLAIN, 26));
    		left.setPreferredSize(new Dimension((int)(Math.round(screenWidth*0.4)), (int)(Math.round(screenHeight*0.1))));
    		
    		JButton right = new JButton(">");
    		right.setFocusable(false);
    		right.setFocusTraversalKeysEnabled(false);
    		right.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
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
    		right.setPreferredSize(new Dimension((int)(Math.round(screenWidth*0.4)), (int)(Math.round(screenHeight*0.1))));

    		
    		movimentPanel.add(left);
    		
    		JPanel proximMoviment = new JPanel(new GridBagLayout());
    		movimentPanel.add(proximMoviment);
    		
    		proximMovimentLabel = new JLabel(Integer.toString(possiblesMoviments.get(movimentIterator)));
    		proximMovimentLabel.setFont(new Font("Dialog", Font.PLAIN, 26));

    		proximMoviment.add(proximMovimentLabel);
    		//proximMoviment.setPreferredSize(new Dimension((int)(Math.round(SCRWIDTH*0.2)), (int)(Math.round(SCRHEIGHT*0.1))));
    		
    		movimentPanel.add(right);
    		
    		//panel infoMoviment de infoPanel
    		
    		JPanel accions = new JPanel();
    		accions.setPreferredSize(new Dimension((int)(Math.round(screenWidth*0)), (int)(Math.round(screenHeight*0.08))));
    		
    		info.add(movimentPanel);
    		info.add(accions);

    		this.add(panelHidato);
    		this.add(info);
    		
    		/*frame.getContentPane().add(panelHidato);
    		frame.getContentPane().add(info);
    		
    		
    		frame.setResizable(false);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);*/
    }

	public void updateSeguentMoviment() {
		if (possiblesMoviments.size() > 0) {
			if (movimentIterator >= possiblesMoviments.size()) --movimentIterator;
			proximMovimentLabel.setText(Integer.toString(possiblesMoviments.get(movimentIterator)));
			panelHidato.setSeguentMoviment(possiblesMoviments.get(movimentIterator));
		}
		else proximMovimentLabel.setText(" ");
		
		if (completat) completat();
	}
	
	public void completat() {
		JFrame victoria = new JFrame("Enhorabona");
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300,30));
		panel.add(new JLabel("Enhorabona, has completat l'hidato correctament!"));
		victoria.getContentPane().add(panel);
		victoria.setResizable(false);
		victoria.pack();
		victoria.setLocationRelativeTo(null);
		victoria.setVisible(true);
	}

	
}