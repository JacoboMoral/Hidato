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
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

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
    public PanelHidato(Cella cella, int[][] board, int ultim, Vector<Integer> nombresPerDefecte, PanelPartida controller, int screenWidth, int screenHeight){
    	//setBorder(new LineBorder(new Color(0, 0, 0)));
        this.controller = controller;
    	this.cella = cella;
        this.board = board;
        this.ultim = ultim;
        this.nombresPerDefecte = nombresPerDefecte;        

        boardWidth = board[0].length;
        boardHeight = board.length;

        setOpaque(false);


        MouseListener mouseListener = new MouseListener();            
        addMouseListener(mouseListener);
        
        this.screenHeight = screenHeight;
        this.screenWidth = screenWidth;
        
        calcCellaSize();
        
        //ResizeListener resizeListener = new ResizeListener();            
        //addComponentListener(resizeListener);
    }
    
    

    private void calcCellaSize(){
 
    	Vector<Double> properties = cella.screenProperties((int)screenWidth, (int)screenHeight, boardHeight, boardWidth);
    	double borderLeft = properties.get(2);
    	double borderTop = properties.get(1);
    	cellaHeight = properties.get(0);

        cella.setBorderLeft((int)borderLeft);
        cella.setBorderTop((int)borderTop);
        cella.setTamany(cellaHeight);

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
            Point p = new Point( cella.pixelsToPosicioMatriu(e.getX(),e.getY()) );
            if (p.x < 0 || p.y < 0 || p.x >= board[0].length || p.y >= board.length) return;

            /*boolean movimentPossible = controller.ferMoviment(p.y,p.x, seguentMoviment);
            if (movimentPossible) board[p.y][p.x] = seguentMoviment;
            else {
            	movimentPossible = controller.desferMoviment(p.y,p.x);
                if (movimentPossible) board[p.y][p.x] = 0;
            }*/
            
            boolean movimentPossible = controller.ferMoviment(p.y,p.x, seguentMoviment);
            if (!movimentPossible) movimentPossible = controller.desferMoviment(p.y,p.x);
            board = controller.getMatriu();
            
            controller.updateSeguentMoviment();
            repaint();
        }		 
    } //end of MyMouseListener class 
    
    
    class ResizeListener extends ComponentAdapter{
    	public void componentResized(ComponentEvent componentEvent) {
    		screenHeight = getHeight();
            screenWidth = getWidth();
            
            System.out.println("resize"+screenHeight);
            System.out.println(screenWidth);

    		calcCellaSize();
    		repaint();
    	}
    }

} // end of DrawingPanel class
