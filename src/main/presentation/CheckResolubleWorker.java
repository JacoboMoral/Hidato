package main.presentation;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class CheckResolubleWorker extends SwingWorker<Boolean, Void>{

	private ControladorPresentacio controller = ControladorPresentacio.getInstance();
	private ControladorCreateHidato creacio;
	private VistaLoading loading;
	private TipusCella tipusCella;
	private TipusAdjacencia tipusAdjacencia;
	private int[][] matriuCreacio;

	public CheckResolubleWorker(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matriuCreacio, ControladorCreateHidato creacio) {
		this.tipusCella = tipusCella;
		this.tipusAdjacencia = tipusAdjacencia;
		this.matriuCreacio = matriuCreacio;
		this.creacio = creacio;
		loading = new VistaLoading();
		loading.setVisible(true);
		loading.setAlwaysOnTop(true);
	}
	
	
	@Override
	protected Boolean doInBackground() throws Exception {
		return controller.esResoluble(tipusCella, tipusAdjacencia, matriuCreacio);
	}

	@Override
	protected void done() {
		loading.dispose();
		try {
			creacio.setResoluble(get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
