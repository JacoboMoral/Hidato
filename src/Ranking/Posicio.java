package Ranking;

import java.time.LocalDate;

public class Posicio {

    private String nickname;
    private int puntuacio;
    private LocalDate Date;

    public Posicio() {
    }

    public Posicio(String nomJugador, int punts, LocalDate date) {
        this.nickname = nomJugador;
        this.puntuacio = punts;
        this.Date = date;
    }

    public String getNickname() {
        return nickname;

    }

    public int getPuntacio() {
        return puntuacio;
    }

    public LocalDate getDate() {
        return Date;
    }

}
