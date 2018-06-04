package main.presentation;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.SwingWorker;

import main.domain.com.hidato.ControladorDomini;
import main.domain.com.hidato.Dificultat;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class ImportWorker extends SwingWorker<Boolean, Void>{

	private ControladorPresentacio controller = ControladorPresentacio.getInstance();
	private VistaLoading loading;
	
	public ImportWorker(String ruta) {
		loading = new VistaLoading();
		loading.setVisible(true);
		loading.setAlwaysOnTop(true);
	}
	
	@Override
	protected Boolean doInBackground() throws Exception {
		return ControladorDomini.getInstance().comprovarHidatotxtResoluble();
	}

	@Override
	protected void done() {
		loading.dispose();
		try {
			controller.setHidatoGeneratFromTxtResoluble(get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}
