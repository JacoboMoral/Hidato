package main.presentation;

import java.util.Vector;

import javax.swing.JPanel;

import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public abstract class ControladorHidatoGrafic {

	protected final ControladorPresentacio controller = ControladorPresentacio.getInstance();
    protected Dificultat dificultat = Dificultat.FACIL;
    protected Cella cella;
	
    
	protected Cella tipusCellaToCella(TipusCella tipusCella) {
    	if (tipusCella == TipusCella.QUADRAT) return new CellaQuadrat();
    	if (tipusCella == TipusCella.TRIANGLE) return new CellaTriangle();
    	if (tipusCella == TipusCella.HEXAGON) return new CellaHexagon();
    	return null;
    }


	public JPanel createHidato(TipusCella hexagon, TipusAdjacencia costats, int i, int j) {
		return null;
	}


	public Vector<Integer> getNombresPerDefecte() {
		// TODO Auto-generated method stub
		return null;
	}


	public boolean ferMoviment(int y, int x, int proximMoviment) {
		// TODO Auto-generated method stub
		return false;
	}


	public boolean desferMoviment(int i, int j) {
		// TODO Auto-generated method stub
		return false;
	}


	public int[][] getMatriuHidato() {
		// TODO Auto-generated method stub
		return null;
	}


	public abstract Vector<Integer> getPossiblesMoviments();


	public void updateSeguentMoviment(String string) {
		// TODO Auto-generated method stub
		
	}


	public void setAlmoadilla() {
	}


	public void setNumero() {
	}


	public void setAsterisc() {	
	}
}
