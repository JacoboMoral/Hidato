package main.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import main.domain.com.hidato.HidatoIO;
import main.domain.com.hidato.Posicio;
import main.domain.com.hidato.Ranking;

import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;

public class ControladorPersistencia {
    
    
    

    private static ControladorPersistencia instance = null;

    public static ControladorPersistencia getInstance() {
        if (instance == null) {
            instance = new ControladorPersistencia();
        }
        return instance;
    }

    public void importarHidato(String sourceFileName, String destinationFileName) throws IOException {
        IOHidato.importarHidatoDeFitxer(sourceFileName, destinationFileName);
    }

    public void importarHidato(int[][] matriuHidato, TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, String destinationFileName) throws IOException {
        IOHidato.importarHidatoCreat(matriuHidato, TipusCella.QUADRAT, TipusAdjacencia.COSTATSIANGLES, destinationFileName);
    }

    public void carregarHidatoFitxer(String file) throws Exception {
        IOHidato.carregarHidatoFitxer(file);
    }

    public int[][] getMatriuHidato() {
        return IOHidato.getMatriu();
    }

    public TipusCella getTipusCellaHidato() {
        return IOHidato.getTipusCella();
    }

    public TipusAdjacencia getTipusAdjacenciaHidato() {
        return IOHidato.getTipusAdjacencia();
    }

    public void guardarPartida(int status, int puntuacio, TipusCella cella, TipusAdjacencia tipusAdj, int[][] matriu, int[][] matriuOriginal, Vector<Integer> nombresDonats, Vector<Integer> nombresEscrits, String nomUsuari) {
        IOPartida.guardarPartida(status, puntuacio, cella, tipusAdj, matriu, matriuOriginal, nombresDonats, nombresEscrits, nomUsuari);
    }

    public void carregarPartida(String usuari) {
        IOPartida.carregarPartida(usuari);
    }

    public Vector<String> nomHidatos() {
        return IOHidato.nomHidatos();
    }

    public int[][] getMatriuPartida() {
        return IOPartida.getMatriu();
    }

    public int[][] getMatriuOriginalPartida() {
        return IOPartida.getMatriuOriginal();
    }

    public TipusAdjacencia getTipusAdjacenciaPartida() {
        return IOPartida.getTipusAdjcacencia();
    }

    public int getStatusPartida() {
        return IOPartida.getStatus();
    }

    public int getPuntuacioPartida() {
        return IOPartida.getPuntuacio();
    }

    public TipusCella getTipusCellaPartida() {
        return IOPartida.getTipusCella();
    }

    public Vector<Integer> getNombresDonatsPartida() {
        return IOPartida.getNombresDonats();
    }

    public Vector<Integer> getNombresEscritsPartida() {
        return IOPartida.getNombresDonats();
    }
    
    /*---------------------------------------------------------------------------------------------------*/

    public boolean usernameExists(String username) {
        return IOUsuari.usernameExists(username);
    }
    
    public boolean changeUsername(String currentUsername, String newUsername) {
        return IOUsuari.changeUsername(currentUsername, newUsername);
    }
    
    public boolean deleteUser(String username) {
        return IOUsuari.deleteUser(username);
    }
    
    public boolean changePassword(String currentUsername, String newPassword) throws IOException {
        return IOUsuari.changePassword(currentUsername, newPassword);
    }
    
    public static void saveRanking(Ranking r) {
        IORanking.saveRanking(r);
    }
    
    public static Ranking readRanking() {
        return IORanking.readRanking();
    }
}
    