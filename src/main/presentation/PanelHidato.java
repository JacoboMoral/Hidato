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
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import main.domain.com.hidato.HidatoIO;

public class PanelHidato extends JPanel{		

	PanelPartida controller;
    Cella cella;

    private double cellaHeight;
    private int border = 0;
    Vector<Integer> nombresPerDefecte;
    int[][] matriuHidato;
    
    private double screenWidth;
    private double screenHeight;
    private int matriuHidatoWidth;
    private int matriuHidatoHeight;
    private int ultim = 1;
    
    //necessita que el creador faci panel.setPreferredSize(dim);
    //Aquesta constructora es fa servir per jugar una nova partida
    public PanelHidato(Cella cella, int[][] matriuHidato, Vector<Integer> nombresPerDefecte, PanelPartida controller){
    	//setBorder(new LineBorder(new Color(0, 0, 0)));
        this.controller = controller;
    	this.cella = cella;
        this.matriuHidato = matriuHidato;
        this.ultim = nombresPerDefecte.get(nombresPerDefecte.size()-1);
        this.nombresPerDefecte = nombresPerDefecte;        

        matriuHidatoWidth = matriuHidato[0].length;
        matriuHidatoHeight = matriuHidato.length;

        setOpaque(false);

        MouseListener mouseListener = new MouseListener();            
        addMouseListener(mouseListener);
        calcCellaSize();
        
        ResizeListener resizeListener = new ResizeListener();            
        addComponentListener(resizeListener);
    }
    
    //Aquesta constructora es fa servir per crear un nou Hidato
    public PanelHidato(Cella cella, int[][] matriuHidato, PanelPartida controller){
        this.controller = controller;
    	this.cella = cella;
        this.matriuHidato = matriuHidato;
        this.nombresPerDefecte = new Vector<Integer>();
        this.ultim = -3;
        
        matriuHidatoWidth = matriuHidato[0].length;
        matriuHidatoHeight = matriuHidato.length;

        
        
        setOpaque(false);

        MouseListener mouseListener = new MouseListener();            
        addMouseListener(mouseListener);
        
        
        calcCellaSize();
        
        ResizeListener resizeListener = new ResizeListener();            
        addComponentListener(resizeListener);
    }
    
    public void calcSizeAndRepaint(int screenWidth, int screenHeight) {
    	this.screenWidth = screenWidth;
    	this.screenHeight = screenHeight;
    	
    	
    	calcCellaSize();
    }
    
    private void calcCellaSize(){
    	Vector<Double> properties = cella.screenProperties((int)screenWidth, (int)screenHeight, matriuHidatoHeight, matriuHidatoWidth);
    	double borderLeft = properties.get(2);
    	double borderTop = properties.get(1);
    	cellaHeight = properties.get(0);

        cella.setBorderLeft((int)borderLeft);
        cella.setBorderTop((int)borderTop);
        cella.setTamany(cellaHeight);

    }
    
    public void updateMatriu(int[][] matriuHidato) {
    	this.matriuHidato = matriuHidato;
        repaint();
    }
    
    public void paintComponent(Graphics g){    	
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //millora linies diagonals dibuixades
        g.setFont(new Font("Arial", Font.BOLD, (int)cellaHeight/3));
        super.paintComponent(g2);

        for (int i=0;i<matriuHidato.length;i++) {
            for (int j=0;j<matriuHidato[0].length;j++) {
                if (matriuHidato[i][j] > -2){
                    cella.dibuixaCella(i,j,g2);
                    int value = matriuHidato[i][j];
                    if (nombresPerDefecte.contains(value) || value < 1) cella.emplenaCella(i,j,value, ultim, g2);
                    else cella.emplenaCella(i, j, value, ultim, g2, new Color(255, 229, 114));
                }
            }
        }
    }
    
    public void setPossiblesMoviments(Vector<Integer> nombresPerDefecte) {
    	this.nombresPerDefecte = nombresPerDefecte;
    }
    
    class MouseListener extends MouseAdapter {
        public void mousePressed(MouseEvent e){ 
            Point p = new Point( cella.pixelsToPosicioMatriu(e.getX(),e.getY()) );
            if (p.x < 0 || p.y < 0 || p.x >= matriuHidato[0].length || p.y >= matriuHidato.length) return;
            if (SwingUtilities.isLeftMouseButton(e)) if (controller.tractaClick(p.y,p.x, 0)) matriuHidato = controller.getMatriu();
            if (SwingUtilities.isRightMouseButton(e)) if (controller.tractaClick(p.y,p.x, 1)) matriuHidato = controller.getMatriu();
            repaint();
        }		 
    }
    
    class ResizeListener extends ComponentAdapter{
    	public void componentResized(ComponentEvent componentEvent) {
    		screenHeight = getHeight();
            screenWidth = getWidth();
    		calcCellaSize();
    		repaint();
    	}
    }
}
