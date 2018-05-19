package main.presentation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import static java.lang.Math.sqrt;
import javax.swing.JPanel;

public class PanelHidato extends JPanel{		

	PanelPartida controller;
    Cella cella;

    private double cellaHeight;
    private int border = 0;
    Vector<Integer> nombresPerDefecte;
    int[][] board;
    
    private double screenWidth;
    private double screenHeight;
    private int boardWidth;
    private int boardHeight;
    private int seguentMoviment = -1;
    private int ultim = 1;
    
    //necessita que el creador faci panel.setPreferredSize(dim)
    public PanelHidato(Cella cella, int[][] board, int ultim, Vector<Integer> nombresPerDefecte, PanelPartida controller){
        this.controller = controller;
    	this.cella = cella;
        this.board = board;
        this.ultim = ultim;
        this.nombresPerDefecte = nombresPerDefecte;        

        boardWidth = board[0].length;
        boardHeight = board.length;
                
        setBackground(new Color(239, 245, 255));
        
        MouseListener ml = new MouseListener();            
        addMouseListener(ml);
        
        ResizeListener m2 = new ResizeListener();            
        addComponentListener(m2);
    }
    
    

    private void calcCellaSize(){
    	        
        double nombreRealCellesVerticals;
        if (boardHeight%2 == 0) nombreRealCellesVerticals = (double)(3*boardHeight+1)/4;
        else nombreRealCellesVerticals = (double)(1 + 3*boardHeight/4);
        
        //System.out.println(nombreRealCellesVerticals);
        	
        cellaHeight = ((screenHeight - (3 * border))/nombreRealCellesVerticals);
        System.out.println("CellaHeight (PanelHidato.calcCellaSize: " + cellaHeight);

        if ((double)screenHeight/(double)screenWidth > ( ((3/4)*(double)boardHeight)/((sqrt(3)/2)*(double)boardWidth) )){ // si la relacio altura/amplada es mes gran que la relacio ocupa altura/ocupa amplada
            if (screenWidth < (cellaHeight*boardWidth*sqrt(3)/2)){ //si l'amplada de la pantalla es mes petita que la de cada cella*numero de celles
                double width = (screenWidth-2*border)/(boardWidth+0.5);
                cellaHeight = (width*2/sqrt(3));
            }
        }
        setPreferredSize(new Dimension((int)(boardWidth*cellaHeight*sqrt(3)/2),(int)(nombreRealCellesVerticals*cellaHeight)));
        System.out.println("getHeight (PanelHidato.calcCellaSize: " + getHeight());
        System.out.println("getWidth (PanelHidato.calcCellaSize: " + getWidth());
        
        cella.setTamany(cellaHeight);
        cella.setBorder(border);
    }
    
    public void paintComponent(Graphics g){    	
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //millora linies diagonals dibuixades
        g.setFont(new Font("Arial", Font.BOLD, (int)cellaHeight/3));
        super.paintComponent(g2);

        
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                if (board[i][j] > -2){
                    cella.dibuixaCella(i,j,g2);
                    int value = board[i][j];
                    if (nombresPerDefecte.contains(value) || value < 1) cella.emplenaCella(i,j,value, ultim, g2);
                    else cella.emplenaCella(i, j, value, ultim, g2, new Color(255, 229, 114));
                }
            }
        }
    }
    
    
	public void setSeguentMoviment(int seguentMoviment) {
		this.seguentMoviment = seguentMoviment;
	}
    
    public void setUltim(int ultim) {
    	this.ultim = ultim;
    	repaint();
    }
    
    

    class MouseListener extends MouseAdapter {	//inner class inside DrawingPanel 
        public void mouseClicked(MouseEvent e){ 
            int x = e.getX(); 
            int y = e.getY(); 
            Point p = new Point( cella.locationToMatriu(e.getX(),e.getY()) );
            if (p.x < 0 || p.y < 0 || p.x >= board[0].length || p.y >= board.length) return;

            boolean movimentPossible = controller.ferMoviment(p.y,p.x, seguentMoviment);
            if (movimentPossible) board[p.y][p.x] = seguentMoviment;
            else {
            	movimentPossible = controller.desferMoviment(p.y,p.x);
                if (movimentPossible) board[p.y][p.x] = 0;
            }
            controller.updateSeguentMoviment();
            repaint();
        }		 
    } //end of MyMouseListener class 
    
    
    class ResizeListener extends ComponentAdapter{
    	public void componentResized(ComponentEvent componentEvent) {
    		screenHeight = getHeight();
            screenWidth = getWidth();
    		calcCellaSize();
    		repaint();
    	}
    }

} // end of DrawingPanel class
