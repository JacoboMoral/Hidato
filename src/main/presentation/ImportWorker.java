package main.presentation;

import java.util.concurrent.ExecutionException;
import javax.swing.SwingWorker;

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
		return controller.comprovarHidatotxtResoluble();
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
