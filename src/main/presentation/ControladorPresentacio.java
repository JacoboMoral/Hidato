package main.presentation;

import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
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
import main.domain.com.hidato.Posicio;
import main.domain.com.hidato.Ranking;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class ControladorPresentacio {

    private static ControladorPresentacio instance = null;
    private static final ControladorDomini domini = ControladorDomini.getInstance();
    private static final ControladorPartida controladorPartida = ControladorPartida.getInstance();
    private VistaPartida v;

    private ControladorPresentacio() {
    }

    public static ControladorPresentacio getInstance() {
        if (instance == null) {
            instance = new ControladorPresentacio();
        }
        return instance;
    }

    public void launchPartidaScreen() {

    }

    public boolean ferMoviment(int i, int j, int value, boolean ajuda) {
        return domini.ferMoviment(i, j, value, ajuda);
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

    public boolean autoGenerar(int altura, int amplada, int forats) {
        return domini.autoGenerar(altura, amplada, forats);
    }

    public boolean autoGenerar(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int altura, int amplada, int forats) {
        return domini.autoGenerar(tipusCella, tipusAdjacencia, altura, amplada, forats);
    }

    public boolean autoGenerar(TipusCella tipusCella, int altura, int amplada, int forats) {
        return domini.autoGenerar(tipusCella, altura, amplada, forats);
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
        return domini.getMatriu(nomHidato);
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

	public boolean esResoluble(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matriuCreacio) {
		return domini.esResoluble(tipusCella, tipusAdjacencia, matriuCreacio);
	}

	public void guardarHidatoCreat(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matriuCreacio, String nomHidato) {
		try {
			domini.guardarHidato(tipusCella, tipusAdjacencia, matriuCreacio, nomHidato);
			JOptionPane.showMessageDialog(null, "S'ha guardat el teu hidato amb el nom '" + nomHidato + "'.");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Hi ha hagut un error al guardar l'hidato: " + e.getMessage());
		 	}
	}

	public boolean hiHaPartidaGuardada() {
		return domini.hiHaPartidaGuardada();
	}

	public boolean cargarPartidaGuardada() {
		if (hiHaPartidaGuardada()) {
			domini.carregarPartida();
			TipusCella tipusCella = domini.getTipusCellaPartida();
			int[][] matriuHidato = domini.getMatriuHidatoDePartida();
			JPanel hidatoPanel = controladorPartida.partidaCarregada(tipusCella, matriuHidato);

			v = new VistaPartida(hidatoPanel);
	        v.setVisible(true);
	        return true;
		}
        else JOptionPane.showMessageDialog(null, "Actualment no disposes de cap partida en curs");
		return false;
	}

	public void jugarPartidaImportada(String nomHidato) throws IOException {
		domini.carregarPartida(nomHidato);
		TipusCella tipusCella = domini.getTipusCellaPartida();
		int[][] matriuHidato = domini.getMatriuHidatoDePartida();
		JPanel hidatoPanel = controladorPartida.partidaCarregada(tipusCella, matriuHidato);
		VistaPartida v = new VistaPartida(hidatoPanel);
		v.setVisible(true);
	}

	public void saveScore(Dificultat dificultat, String username, int score) {
        domini.saveScore(dificultat, score, username);
    }

    public ArrayList<Posicio> getRankingEasy() {
        return domini.getRankingEasy();
    }

    public ArrayList<Posicio> getRankingInter() {
        return domini.getRankingInter();
    }

    public ArrayList<Posicio> getRankingHard() {
        return domini.getRankingHard();
    }

    public Ranking loadRanking() {
        return domini.loadRanking();
    }

    public ArrayList<Posicio> getFilterByUsername(String username, int level) {
        return domini.getFilterByUsername(username, level);
    }

    public void deleteUserRanking(String nom) {
        domini.deteleUserRanking(nom);
    }

    public boolean existsUser(String nom) {
        return domini.existsUser(nom);
    }

    public ArrayList<Posicio> getFilterByDate(String date, int level) {
        return domini.getFilterByDate(date, level);
    }

    public boolean existsDate(String date) {
        return domini.existsDate(date);
    }

    public boolean loginUsuari(String username, String password) throws IOException {
        if (domini.loginUsuari(username, password)) {
            //login success
        } else {
            //login fault
            return false;
        }
        return true;
    }

    public boolean afegirUsuari(String username, String password) throws IOException {
        return domini.afegirUsuari(username, password);
    }

    public boolean editUseranme(String currentUsername, String newUsername) {
        return domini.editUseranme(currentUsername, newUsername);
    }

    public boolean changePass(String currentPass, String newPass) throws IOException {
        return domini.changePass(currentPass, newPass);
    }

    public boolean deleteUser(String pass) {
        return domini.deleteUser(pass);
    }

    public String getUsername() {
        return domini.getUsername();
    }

    public String getPassword() {
        return domini.getPassword();
    }

	public void importarHidatotxt(String ruta) throws Exception {
		if (domini.comprovarHidatotxt(ruta)) {
			JOptionPane.showMessageDialog(null, "Format correcte, ara es revisara que sigui resoluble");
        	new ImportWorker(ruta).execute();
		}
		else JOptionPane.showMessageDialog(null, "Format no valid");
	}

	public void setHidatoGeneratFromTxtResoluble(Boolean resoluble) {
		if(resoluble) {
			String hidatoName = JOptionPane.showInputDialog("", "Entra el nom que li vols posar a l'hidato");
			if(hidatoName != null) {
				try {
					domini.guardarHidatotxt(hidatoName);
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null, "Hi ha hagut un problema a l'hora de guardar el teu hidato");
				}
				JOptionPane.showMessageDialog(null, "Hidato guardat amb el nom: " + hidatoName);
			}
		}
		else JOptionPane.showMessageDialog(null, "Hidato proposat no es resoluble");

	}

	public TipusCella getTipusCellaPartida() {
		return domini.getTipusCellaPartida();
	}

	public int[][] solucionarPartida() {
		return domini.solucionarPartida();
	}

	public long getTempsSolucionarPartida() {
		return domini.getTempsPartida();
	}

	public int getPuntuacioPartida() {
		return domini.getPuntuacioPartida();
	}

    public int getRankingEasySize() {
        return domini.getRankingEasySize();
    }

    public int getRankingInterSize() {
        return domini.getRankingInterSize();
    }

    public int getRankingHardSize() {
        return domini.getRankingHardSize();
    }

    void getUpdate() {
        domini.getUpdate();
    }

    public TipusAdjacencia getTipusAdjacenciaPartida() {
        return domini.getAdjacenciaPartida();
    }

    public Dificultat getDificultatPartida() {
        return domini.getDificultatPartida();
    }
}
