package main.presentation;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.domain.com.hidato.ControladorDomini;
import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.HidatoIO;
import main.domain.com.hidato.Hidato;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class ControladorPresentacio {

    private static ControladorPresentacio instance = null;
    private static final ControladorDomini domini = ControladorDomini.getInstance();
    private static final ControladorPartida controladorPartida = ControladorPartida.getInstance();
    private VistaPartida v;
    
    static JPanel panelPartida; //JPanel vs PanelPartida??? hi ha cap diferencia?'


    private ControladorPresentacio() {
    }

    public static ControladorPresentacio getInstance() {
        if (instance == null) instance = new ControladorPresentacio(); 
    	return instance;
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
        Inici inici = new Inici();
		inici.run();
	}

	public boolean autoGenerar(TipusCella tipusCella, Dificultat dificultat) {
		return domini.autoGenerar(tipusCella, dificultat);
	}
	
	public boolean autoGenerar(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, Dificultat dificultat) {
		return domini.autoGenerar(tipusCella, tipusAdjacencia, dificultat);
	}
	
	public boolean autoGenerar(Dificultat dificultat) {
		return domini.autoGenerar(dificultat);
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

	public void reset() {
		domini.resetMatriuEnPartida();
	}

	public void guardarPartida() {
		domini.guardarPartida();		
	}

	public boolean sobreesciure() {
		int input = JOptionPane.showOptionDialog(null, "Ja hi ha una partida guardada. La vols sobreescriure?", "Ja hi ha una partida guardada",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

        if (input == JOptionPane.OK_OPTION) {
            return true;
        } else {
            return false;
        }
    }

    public void partidaGuardada() {

        JOptionPane.showMessageDialog(null, "La seva partida s'ha guardat correctament");

    }

    public String[] getHidatos() {
        return null;
        //return domini.getHidatos();
    }

    public int[][] getMatriu(String nomHidato) throws Exception {
        return domini.getMatiu(nomHidato);
    }

    public TipusAdjacencia getTipusAdjacencia(String nomHidato) throws Exception {
        return domini.getTipusAdjacencia(nomHidato);
    }

    public TipusCella getTipusCella(String nomHidato) throws Exception {
        return domini.getTipusCella(nomHidato);
    }

    public String[] getAllHidatoNames() {
        return domini.getAllHidatoNames();
    }

	public void mostraPartidaGuardada() {
		
		JOptionPane.showMessageDialog(null, "La seva partida s'ha guardat correctament");		
		
	}
	
	public boolean hiHaPartidaGuardada() {
		return domini.hiHaPartidaGuardada();
	}

	public void cargarPartidaGuardada(CtrlVista cv, VistaMenuPrincipal vistaAnterior) {
		if (hiHaPartidaGuardada()) {
			domini.carregarPartida("aaa");
			TipusCella tipusCella = domini.getTipusCellaPartida();
			int[][] matriuHidato = domini.getMatriuHidatoDePartida();
			JPanel hidatoPanel = controladorPartida.partidaCarregada(tipusCella, matriuHidato);
			
			v = new VistaPartida(cv,hidatoPanel);
	        v.setVisible(true);
	        vistaAnterior.dispose();
			
		}
        else JOptionPane.showMessageDialog(null, "Actualment no disposes de cap partida en curs");
	}

	public void guardarHidatoCreat(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matriuCreacio, String nomHidato) {
		if (!domini.esResoluble(tipusCella, tipusAdjacencia, matriuCreacio)) JOptionPane.showMessageDialog(null, "L'hidato proposat no es resoluble");
		else {
			try {
				domini.guardarHidato(tipusCella, tipusAdjacencia, matriuCreacio, nomHidato);
				JOptionPane.showMessageDialog(null, "S'ha guardat el teu hidato amb el nom '" + nomHidato + "'.");
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Hi ha hagut un error al guardar l'hidato: " + e.getMessage());
			}
		}
	}

}
