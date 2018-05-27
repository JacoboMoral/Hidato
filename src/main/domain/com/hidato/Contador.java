package main.domain.com.hidato;

import java.util.Timer;
import java.util.TimerTask;

public class Contador {
	private int segons;
	private Timer cronometro;
	
	
	private class Incrementador extends TimerTask {
		
		public void run() {
			segons++;
		}
		
	}
	
	
	public Contador() {
		segons = 0;
	}
	
	
	public void iniciar() {
		cronometro = new Timer();
		cronometro.schedule(new Incrementador(), segons, 1000);
	}
	
	public void detener() {
		cronometro.cancel();
	}
	
	public int getSegons() {
		return segons;
	}

}
