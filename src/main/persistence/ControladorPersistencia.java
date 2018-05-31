package main.persistence;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.io.PrintStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;
import main.domain.com.hidato.Hidato;
import main.domain.com.hidato.HidatoIO;
import main.domain.com.hidato.Posicio;
import main.domain.com.hidato.Ranking;

import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;
import main.domain.com.hidato.Usuari;

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

    public void importarHidato(int[][] matriuHidato, TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, String nomHidato) throws IOException {
        IOHidato.importarHidatoCreat(matriuHidato, tipusCella, tipusAdjacencia, nomHidato);
    }

    public void carregarHidatoFitxer(String file) throws Exception {
        IOHidato.carregarHidatoFitxer(file);
    }

    public void carregarHidatoImportat(String nomHidato) throws Exception {
        IOHidato.carregarHidatoImportat(nomHidato);
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

    public void guardarPartida(Date dataIni, int temps, int status, int puntuacio, TipusCella cella, TipusAdjacencia tipusAdj, int[][] matriu, int[][] matriuOriginal, Vector<Integer> nombresDonats, Vector<Integer> nombresEscrits, String nomUsuari) {
        IOPartida.guardarPartida(dataIni, temps, status, puntuacio, cella, tipusAdj, matriu, matriuOriginal, nombresDonats, nombresEscrits, nomUsuari);
    }

    public boolean hiHaPartida(String usuari) {
        return IOPartida.hiHaPartida(usuari);
    }

    public void carregarPartida(String usuari) throws ParseException {
        IOPartida.carregarPartida(usuari);
    }

    public String[] nomHidatosImportats() {
        return IOHidato.nomHidatosImportats();
    }

    public Date getDataIniPartida() {
        return IOPartida.getDataIni();
    }

    public int getTempsPartida() {
        return IOPartida.getTemps();
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


    public String[] getHidatos() {
        return null;
    }

    public String[] getAllHidatoFileNames() {
        return IOHidato.nomHidatosImportats();
    }

    public void saveScoreDB(int dif, int score, String username) {
        IORanking.saveScoreDB(dif, score, username);
    }

    public String[] getRankingEasy() {
        return IORanking.getRankingEasy();
    }

    public String[] getRankingInter() {
        return IORanking.getRankingInter();
    }

    public String[] getRankingHard() {
        return IORanking.getRankingHard();
    }

    public void loadRanking() {
        IORanking.readRanking();
    }

    public Ranking getRanking() {
        return IORanking.getRanking();
    }

    public String[] getFilterByUsername(String username, int level) {
        return IORanking.getFilterByUsername(username, level);
    }

    public void deteleUserRanking(String nom) {
        IORanking.deteleUserRanking(nom);
    }

    public boolean existsUser(String nom) {
        return IORanking.existsUser(nom);
    }

    public String[] getFilterByDate(String date, int level) {
        return IORanking.getFilterByDate(date, level);
    }

    public boolean existsDate(String date) {
        return IORanking.existsDate(date);
    }

    public boolean loginUsuari(String username, String password) throws IOException {
        return IOUsuari.loginUsuari(username, password);
    }

    public boolean afegirUsuari(String username, String password) throws IOException {
        return IOUsuari.afegirUsuari(username, password);
    }

    public boolean editUseranme(String currentUsername, String newUsername) {
        return IOUsuari.editUseranme(currentUsername, newUsername);
    }

    public boolean changePass(String currentPass, String newPass) throws IOException {
        return IOUsuari.changePass(currentPass, newPass);
    }

    public boolean deleteUer(String pass) {
        System.out.println("estic a Persistencia");
        return IOUsuari.deleteUer(pass);
    }

    public String getUsername() {
        return IOUsuari.getUsername();

    }
    public Usuari getUser() {
        return IOUsuari.getUser();
    }

    public String getPassword() {
        return IOUsuari.getPassword();
    }
}
