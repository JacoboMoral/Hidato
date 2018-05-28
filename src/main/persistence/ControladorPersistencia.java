package main.persistence;

import java.io.IOException;
import java.util.Vector;

import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class ControladorPersistencia {

	private static ControladorPersistencia instance = null;	
	
    public static ControladorPersistencia getInstance() {
        if (instance == null)
        	instance = new ControladorPersistencia();
        return instance;
    }
    
    public void importarHidato(String sourceFileName, String destinationFileName) throws IOException {
    	IOHidato.importarHidatoDeFitxer(sourceFileName, destinationFileName);
    }
    
    public void importarHidato(int[][] matriuHidato, TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, String destinationFileName) throws IOException {
    	IOHidato.importarHidatoCreat(matriuHidato, TipusCella.QUADRAT, TipusAdjacencia.COSTATSIANGLES, destinationFileName);
    }

	public void carregarHidatoFitxer(String file) throws Exception {
		IOHidato.carregarHidatoFitxer(file);
	}
	
	public int[][] getMatriuHidato(){
		return IOHidato.getMatriu();
	}
	
	public TipusCella getTipusCellaHidato() {
		return IOHidato.getTipusCella();
	}
	
	public TipusAdjacencia getTipusAdjacenciaHidato() {
		return IOHidato.getTipusAdjacencia();
	}

    public void guardarPartida(int status, int puntuacio, TipusCella cella, TipusAdjacencia tipusAdj, int[][] matriu, int[][] matriuOriginal, Vector<Integer> nombresDonats, Vector<Integer> nombresEscrits, String nomUsuari) {
    	IOPartida.guardarPartida(status, puntuacio, cella, tipusAdj, matriu, matriuOriginal, nombresDonats, nombresEscrits, nomUsuari);
    }
    
    public void carregarPartida(String usuari) {
    	IOPartida.carregarPartida(usuari);
    }
    
    public Vector<String> nomHidatos(){
    	return IOHidato.nomHidatos();
    }

	public int[][] getMatriuPartida() {
		return IOPartida.getMatriu();
	}

	public int[][] getMatriuOriginalPartida() {
		return IOPartida.getMatriuOriginal();
	}
	
	public TipusAdjacencia getTipusAdjacenciaPartida() {
		return IOPartida.getTipusAdjcacencia();
	}
	
	public int getStatusPartida() {
		return IOPartida.getStatus();
	}
	
	public int getPuntuacioPartida() {
		return IOPartida.getPuntuacio();
	}
	
	public TipusCella getTipusCellaPartida() {
		return IOPartida.getTipusCella();
	}
	
	public Vector<Integer> getNombresDonatsPartida(){
		return IOPartida.getNombresDonats();
	}
	
	public Vector<Integer> getNombresEscritsPartida(){
		return IOPartida.getNombresDonats();
	}

    
}