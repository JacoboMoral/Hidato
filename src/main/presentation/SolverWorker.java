package main.presentation;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class SolverWorker extends SwingWorker<int[][], Boolean>{

	private ControladorPresentacio controller = ControladorPresentacio.getInstance();
	private VistaLoading loading;

	public SolverWorker() {
		loading = new VistaLoading();
		loading.setVisible(true);
		loading.setAlwaysOnTop(true);
	}
	
	
	@Override
	protected int[][] doInBackground() throws Exception {
		int[][] matriuSolucio = controller.solucionarPartida();
		return matriuSolucio;
	}

	@Override
	protected void done() {
		loading.dispose();
		try {
			controller.setMatriuResolta(get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
