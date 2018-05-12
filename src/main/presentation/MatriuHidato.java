package main.presentation;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*; 
import static java.lang.Math.round;
import static java.lang.Math.sqrt;


public class MatriuHidato{
  
    private MatriuHidato(){
        createAndShowGUI();
    }

    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MatriuHidato();
            }
        });
    }

    final static int BSIZE = 10;
    final static int CELLAHEIGHT = 50;	//altura hexagon
    final static int CELLAWIDTH = (int) (CELLAHEIGHT*sqrt(3)/2);
    final static int BORDER = 15;  
    final static long SCRWIDTH = Math.round(CELLAWIDTH * BSIZE + (CELLAWIDTH/2) + BORDER*2); //en horitzontal
    final static long SCRHEIGHT = Math.round((CELLAHEIGHT * BSIZE)*0.8333333 + BORDER*2);

    int[][] board = new int[][]{
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
        
    

    private void createAndShowGUI(){
            DrawingPanel panel = new DrawingPanel(new CellaHexagon());

            JFrame frame = new JFrame("Hidato Hexagon");
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            Container content = frame.getContentPane();
            content.add(panel);
            Dimension dim = new Dimension((int)SCRWIDTH+5, (int) SCRHEIGHT+30);
            frame.setPreferredSize(dim);
            frame.pack();

            frame.setResizable(false);
            frame.setLocationRelativeTo( null );
            frame.setVisible(true);
    }

    private class DrawingPanel extends JPanel{		
        
        Cella cella;
        
        public DrawingPanel(Cella cella){
                this.cella = cella;
                cella.setTamany(CELLAHEIGHT);
                setBackground(new Color(239, 245, 255));

                MyMouseListener ml = new MyMouseListener();            
                addMouseListener(ml);
        }
        
        public void paintComponent(Graphics g){
            Graphics2D g2 = (Graphics2D)g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON); //millora linies diagonals dibuixades
            g.setFont(new Font("Arial", Font.BOLD, CELLAHEIGHT/3));
            super.paintComponent(g2);

            for (int i=0;i<BSIZE;i++) {
                for (int j=0;j<BSIZE;j++) {
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
                if (p.x < 0 || p.y < 0 || p.x >= BSIZE || p.y >= BSIZE) return;

                board[p.y][p.x] = 69;
                repaint();
            }		 
        } //end of MyMouseListener class 
    } // end of DrawingPanel class
}