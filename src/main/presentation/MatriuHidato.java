package main.presentation;

import java.awt.*;
import javax.swing.*;
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
    
    private void createAndShowGUI(){
            //PanelHidato panel = new PanelHidato(new CellaHexagon(), CELLAHEIGHT, BORDER, board);
    		PanelHidato panel = new PanelHidato(new CellaHexagon(), SCRWIDTH, SCRHEIGHT , BORDER, board);
            

            JFrame frame = new JFrame("Hidato Hexagon");
            frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
            Container content = frame.getContentPane();
            
            content.add(panel);
            frame.pack();
            
            frame.setLocationRelativeTo( null );
            frame.setVisible(true);


    }
}