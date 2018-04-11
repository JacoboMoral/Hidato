package com.hidato;

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
		cronometro = new Timer();
	}
	
	
	public void iniciar() {
		cronometro.schedule(new Incrementador(), segons, 1000);
	}
	
	public void detener() {
		cronometro.cancel();
	}
	
	public int getSegons() {
		return segons;
	}

}
