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
    
    public void importarHidato(String nomHidato) throws IOException {
        IOHidato.importarHidatoCreat(nomHidato);
    }

    public void carregarHidatoFitxer(String file) throws Exception {
        IOHidato.carregarHidatoFitxer(file);
    }
    
    public void esborrarPartidaGuardada(String usuari) {
    	IOPartida.esborrarPartidaGuardad(usuari);
    }

    public void carregarHidatoImportat(String nomHidato) throws IOException {
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
    
    public void carregarPartida(String usuari){
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
        return IOPartida.getNombresEscrits();
    }


    public String[] getHidatos() {
        return null;
    }

    public String[] getAllHidatoFileNames() {
        return IOHidato.nomHidatosImportats();
    }

    public void saveScoreDB(Ranking ranking, int dif, int score, String username) {
        IORanking.saveScoreDB(ranking, dif, score, username);
    }

    public String[] getRankingEasy(Ranking r) {
        return IORanking.getRankingEasy(r);
    }

    public String[] getRankingInter(Ranking r) {
        return IORanking.getRankingInter(r);
    }

    public String[] getRankingHard(Ranking r) {
        return IORanking.getRankingHard(r);
    }

    public Ranking loadRanking() {
        return IORanking.readRanking();
    }


    public String[] getFilterByUsername(Ranking r, String username, int level) {
        return IORanking.getFilterByUsername(r, username, level);
    }

    public void deteleUserRanking(Ranking r, String nom) {
        IORanking.deteleUserRanking(r, nom);
    }

    public boolean existsUser(Ranking r, String nom) {
        return IORanking.existsUser(r, nom);
    }

    public String[] getFilterByDate(Ranking r, String date, int level) {
        return IORanking.getFilterByDate(r, date, level);
    }

    public boolean existsDate(Ranking r, String date) {
        return IORanking.existsDate(r, date);
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
