package main.domain.com.hidato;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import javafx.util.converter.LocalDateTimeStringConverter;

public class Contador {

    private int segons;
    private Timer cronometro;
    private String tempsActual;
    private boolean acabat;

    private class Incrementador extends TimerTask {

        public void run() {
            segons++;
            //Get current date time
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
            tempsActual = now.format(formatter);
            //System.out.println("After : " + tempsActual);
        }
    }

    public Contador() {
        segons = 0;
        acabat = false;
    }

    public void iniciar() {
        cronometro = new Timer();
        cronometro.schedule(new Incrementador(), 0, 1000);
    }

    public void detener() {
        acabat = true;
        cronometro.cancel();
    }

    public int getSegons() {
        return segons;
    }
    
    public String getTempsActual() {
        return tempsActual;
    }
    
    public boolean acabat() {
        return acabat;
    }

}
