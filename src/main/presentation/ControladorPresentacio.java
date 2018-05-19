package main.presentation;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ControladorPresentacio {

    private static final ControladorPresentacio instance = new ControladorPresentacio();

	static private int[][] board = new int[][]{
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

    public static ControladorPresentacio getInstance() {
    	return instance;
    }

	public static void main(String args[]){
		JFrame frame = new JFrame();

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		JPanel panel3 = new PanelHidato(new CellaHexagon(), (double)20, 15, board);
		panel1.setBackground(Color.ORANGE);
		panel2.setBackground(Color.GREEN);

		JButton button = new JButton("Button1");
		JTextField textField = new JTextField();
		textField.setPreferredSize(new Dimension(200,50));
		panel1.add(button);
		panel1.add(textField);

		frame.add(panel3);

		frame.setSize(600,400);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Titulo del FRAME");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
    }

	public void launchPartidaScreen(){

	}

	public void launchLogin() {
		Inici inici = new Inici();
		inici.run();
	}

}
