package main.domain.com.hidato;

import java.time.LocalDate;

public class Posicio {

    private String username;
    private int puntuacio;
    private LocalDate Date;

    public Posicio(String nomJugador, int punts, LocalDate date) {
        this.username = nomJugador;
        this.puntuacio = punts;
        this.Date = date;
    }

    public String getUsername() {
        return username;
    }

    public int getScore() {
        return puntuacio;
    }

    public LocalDate getDate() {
        return Date;
    }

}
