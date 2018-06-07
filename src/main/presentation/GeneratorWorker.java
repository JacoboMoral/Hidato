package main.presentation;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class GeneratorWorker extends SwingWorker<int[][], Void>{

	private ControladorPresentacio controller = ControladorPresentacio.getInstance();
	private VistaLoading loading;
	
	private TipusCella tipusCella = null; 
	private TipusAdjacencia tipusAdjacencia = null;
	private Dificultat dificultat = null;
	
	int altura = -1;
	int amplada = -1;
	int forats = -1;
	
	public GeneratorWorker(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int altura, int amplada, int forats) {
		this.tipusCella = tipusCella;
		this.tipusAdjacencia = tipusAdjacencia;
		this.altura = altura;
		this.amplada = amplada;
		this.forats = forats;
		loading = new VistaLoading();
		loading.setVisible(true);
		loading.setAlwaysOnTop(true);
	}
	
	public GeneratorWorker(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, Dificultat dificultat) {
		this.tipusCella = tipusCella;
		this.tipusAdjacencia = tipusAdjacencia;
		this.dificultat = dificultat;
		loading = new VistaLoading();
		loading.setVisible(true);
		loading.setAlwaysOnTop(true);
	}
	
	
	@Override
	protected int[][] doInBackground() throws Exception {
		if (dificultat != null) {
			if (controller.autoGenerar(tipusCella, tipusAdjacencia, dificultat)) {
		        controller.jugarHidatoGenerat();
		        return controller.getMatriuHidatoDePartida();
			}
		}
		else {
			if (controller.autoGenerar(tipusCella, tipusAdjacencia, altura, amplada, forats)) {
		        controller.jugarHidatoGenerat();
		        return controller.getMatriuHidatoDePartida();
			}
		}
		return null;
	}

	@Override
	protected void done() {
		loading.dispose();
		try {
			controller.setMatriuGenerada(get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
