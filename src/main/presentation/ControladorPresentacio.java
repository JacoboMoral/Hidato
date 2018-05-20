package main.presentation;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.domain.com.hidato.ControladorDomini;
import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class ControladorPresentacio {

    private static final ControladorPresentacio instance = new ControladorPresentacio();
    private static final ControladorDomini domini = new ControladorDomini().getInstance();

    static JPanel panelPartida; //JPanel vs PanelPartida??? hi ha cap diferencia?'
    
    public static ControladorPresentacio getInstance() {
    	return instance;
    }

	public static void main(String args[]){

		final JFrame frame = new JFrame();
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		final ControladorPartida partida = new ControladorPartida().getInstance();
		panelPartida = partida.partidaAutogenerada(new CellaHexagon(), Dificultat.FACIL);
		
				
		JButton buttonFacil = new JButton("Facil");
		frame.add(buttonFacil);
		buttonFacil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().remove(panelPartida);
				panelPartida = partida.partidaAutogenerada(new CellaHexagon(), Dificultat.FACIL);
				frame.add(panelPartida);
				frame.validate();				
			}
		});
		
		JButton buttonMig = new JButton("Mig");
		frame.add(buttonMig);
		buttonMig.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().remove(panelPartida);
				panelPartida = partida.partidaAutogenerada(new CellaHexagon(), Dificultat.MIG);
				frame.add(panelPartida);
				frame.validate();
			}
		});
		
		JButton buttonDificil = new JButton("Dificil");
		frame.add(buttonDificil);
		buttonDificil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.getContentPane().remove(panelPartida);
				panelPartida = partida.partidaAutogenerada(new CellaHexagon(), Dificultat.DIFICIL);
				frame.add(panelPartida);
				frame.validate();				
			}
		});
		
		frame.add(panelPartida);
		
		
		
		
		
		frame.pack();

		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Titulo del FRAME");
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setVisible(true);
    }

	public void launchPartidaScreen(){
		
	}
	
	public boolean ferMoviment(int i, int j, int value) {
		return domini.ferMoviment(i, j, value);
	}
	
	public boolean desferMoviment(int i, int j) {
		return domini.desferMoviment(i, j);
	}
	
	public boolean partidaCompletada() {
		return domini.partidaCompletada();
	}
	
	public void launchLogin() {
		VistaLogin vistaLogin = new VistaLogin();
		//vistaLogin.run();
		main(null);
	}

	public boolean autoGenerar(TipusCella tipusCella, Dificultat dificultat) {
		return domini.autoGenerar(tipusCella, dificultat);
	}

	public void jugarHidatoGenerat() {
		domini.jugarHidatoGenerat();
	}

	public int[][] getMatriuHidatoDePartida() {
		return domini.getMatriuHidatoDePartida();
	}

	public Vector<Integer> getNombresPerDefecte() {
		return domini.getNombresPerDefecte();
	}

	public Vector<Integer> getPossiblesMoviments() {
		return domini.getPossiblesMoviments();
	}

}
