package main.domain.com.hidato;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javafx.util.converter.LocalDateTimeStringConverter;

public class Contador {

    private String tempsActual;
    private boolean acabat;
    private long horaInici; //nanosegons
    private long horaFi;	//nanosegons

    public Contador() {
        acabat = false;
    }

    public void iniciar() {
        horaInici = System.nanoTime();
    }
    
    public void detener() {
    	horaFi = System.nanoTime();
        acabat = true;        
    }

    public int getSegons() {
        return (int) Math.ceil((double)getNanosegons()/1000000000);
    }
    
    public int getMilisegons() {
    	return (int) Math.ceil((double)getNanosegons()/1000000);
    }
    
    public long getNanosegons() {
    	if (acabat) return (horaFi - horaInici);
    	long temps = System.nanoTime() - horaInici;
    	return temps;
    }
    
    public String getTempsActual() {
        return tempsActual;
    }
    
    public boolean acabat() {
        return acabat;
    }

}
