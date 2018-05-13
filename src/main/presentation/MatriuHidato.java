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

    final static int BSIZE = 10;
    final static int CELLAHEIGHT = 50;	//altura hexagon
    final static int CELLAWIDTH = (int) (CELLAHEIGHT*sqrt(3)/2);
    final static int BORDER = 15;  
    final static long SCRWIDTH = Math.round(CELLAWIDTH * BSIZE + (CELLAWIDTH/2) + BORDER*2); //en horitzontal
    final static long SCRHEIGHT = Math.round((CELLAHEIGHT * BSIZE)*0.8333333 + BORDER*2);

  
    private void createAndShowGUI(){
            PanelHidato panel = new PanelHidato(new CellaHexagon());

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
}