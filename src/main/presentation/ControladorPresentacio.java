package main.presentation;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.domain.com.hidato.ControladorDomini;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class ControladorPresentacio {

    private static final ControladorPresentacio instance = new ControladorPresentacio();
    private static final ControladorDomini controladorDomini = new ControladorDomini().getInstance();
    private static int[][] board;

    public static ControladorPresentacio getInstance() {
    	return instance;
    }

	public static void main(String args[]){
		JFrame frame = new JFrame();

		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		
		JPanel panel3 = new PanelHidato(new CellaHexagon(), 600, 600, 15, board, 225);
		panel1.setBackground(Color.ORANGE);
		panel2.setBackground(Color.GREEN);

		JButton button = new JButton("Button1");
		JTextField textField = new JTextField();
		textField.setPreferredSize(new Dimension(200,50));
		panel3.add(button);
		panel3.add(textField);
		
		frame.add(panel3);

		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Titulo del FRAME");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
    }

	public void launchPartidaScreen(){
		
	}

	public void launchLogin() {
		VistaLogin vistaLogin = new VistaLogin();
		//vistaLogin.run();
		main(null);
	}

}
