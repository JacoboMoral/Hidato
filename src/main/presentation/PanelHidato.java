package main.presentation;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static java.lang.Math.sqrt;
import javax.swing.JPanel;

public class PanelHidato extends JPanel{		

    Cella cella;

    private double cellaHeight;
    private int border;  
    
    int[][] board;
    
    public PanelHidato(Cella cella, double cellaHeight, int border, int[][] board){
        this.cella = cella;
        this.board = board;
        
        this.cellaHeight = cellaHeight;
        this.border = border;
        
        System.out.println("PanelHidato: Height: " + cellaHeight);
        
        cella.setTamany(cellaHeight);
        setBackground(new Color(239, 245, 255));
        MyMouseListener ml = new MyMouseListener();            
        addMouseListener(ml);
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
                    cella.emplenaCella(i,j,board[i][j],g2);
                }
            }
        }
    }

    class MyMouseListener extends MouseAdapter {	//inner class inside DrawingPanel 
        public void mouseClicked(MouseEvent e){ 
            int x = e.getX(); 
            int y = e.getY(); 
            Point p = new Point( cella.locationToMatriu(e.getX(),e.getY()) );
            if (p.x < 0 || p.y < 0 || p.x >= board[0].length || p.y >= board.length) return;

            board[p.y][p.x] = 69;
            repaint();
        }		 
    } //end of MyMouseListener class 
} // end of DrawingPanel class