package main.domain.com.hidato;

import java.io.IOException;
import java.util.Date;
import java.util.Random;
import java.util.Vector;

import main.persistence.ControladorPersistencia;
import main.presentation.ControladorPresentacio;

public class ControladorDomini {

    private static ControladorDomini instance = null;
    private ControladorPresentacio presentacio = ControladorPresentacio.getInstance();
    private Partida partidaEnCurs = null;
    private Hidato hidatoGenerat = null;
    private ControladorPersistencia controladorPersistence = ControladorPersistencia.getInstance();
    private Usuari currentUser;
    private Ranking ranking;
    
    public static ControladorDomini getInstance() {
        if (instance == null) {
            instance = new ControladorDomini();
        }
        return instance;
    }

    public boolean jugarHidatoImportat(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matriuHidato) {
        partidaEnCurs = new Partida(HidatoFactory.createHidato(tipusCella, tipusAdjacencia, matriuHidato), currentUser);
        if (!partidaEnCurs.esSolucionable()) {
            partidaEnCurs = null;
            return false;
        } else {
            return true;
        }
    }

    public void jugarHidatoGenerat() {
        if (hidatoGenerat != null) {
            partidaEnCurs = new Partida(hidatoGenerat, currentUser);
            partidaEnCurs.esSolucionable();
        }
    }

    public boolean autoGenerar(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int tamanyi, int tamanyj, int forats) {
        hidatoGenerat = HidatoFactory.createHidato(tipusCella, tipusAdjacencia); //es crea hidato sense matriu
        boolean generat = hidatoGenerat.autogenerar(tamanyi, tamanyj, forats);
        if (generat) {
            return true;
        } else {
            hidatoGenerat = null;
            return false;
        }
    }

    public boolean autoGenerar(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, Dificultat dificultat) {
        hidatoGenerat = HidatoFactory.createHidato(tipusCella, tipusAdjacencia); //es crea hidato sense matriu
        boolean generat = hidatoGenerat.autogenerar(dificultat);
        if (generat) {
            return true;
        } else {
            hidatoGenerat = null;
            return false;
        }
    }

    public boolean autoGenerar(Dificultat dificultat) {
        TipusCella tipusCella = getRandomTipusCella();
        TipusAdjacencia tipusAdjacencia = getRandomTipusAdjacencia();
        hidatoGenerat = HidatoFactory.createHidato(tipusCella, tipusAdjacencia); //es crea hidato sense matriu
        boolean generat = hidatoGenerat.autogenerar(dificultat);
        if (generat) {
            return true;
        } else {
            hidatoGenerat = null;
            return false;
        }
    }

    public boolean autoGenerar(TipusCella tipusCella, Dificultat dificultat) {
        if (tipusCella == TipusCella.QUADRAT) {
            TipusAdjacencia tipusAdjacencia = getRandomTipusAdjacencia();
            hidatoGenerat = HidatoFactory.createHidato(tipusCella, tipusAdjacencia); //es crea hidato sense matriu
        } else {
            hidatoGenerat = HidatoFactory.createHidato(tipusCella, TipusAdjacencia.COSTATS); //es crea hidato sense matriu
        }
        boolean generat = hidatoGenerat.autogenerar(dificultat);
        if (generat) {
            return true;
        } else {
            hidatoGenerat = null;
            return false;
        }
    }

    public int[][] getMatriuHidatoOriginalDePartida() {
        return partidaEnCurs.getHidatoOriginal();
    }

    public int[][] getMatriuHidatoDePartida() {
        return partidaEnCurs.getHidato();
    }

    public int[][] solucionarHidatoPartida() {
        return partidaEnCurs.getSolucio();
    }

    public int[][] solucionarHidatoGenerat() {
        if (hidatoGenerat == null) {
            return null;
        }
        return hidatoGenerat.getSolucio();
    }

    public int[][] getMatriuHidatoGenerat() {
        if (hidatoGenerat == null) {
            return null;
        }
        return hidatoGenerat.getMatriu();
    }

    public Vector<Integer> getNombresPerDefecte() {
        return partidaEnCurs.getNombresPerDefecte();
    }

    public Vector<Integer> getPossiblesMoviments() { //Nombres que hi caben a la matriu - nombresPerDefecte - nombresEscrits
        return partidaEnCurs.getPossiblesMoviments();
    }

    public boolean ferMoviment(int i, int j, int value) {
        if (partidaEnCurs.ferJugada(i, j, value)) {
            return true;
        }
        return false;
    }

    public boolean desferMoviment(int i, int j) {
        if (partidaEnCurs.esborrarNombre(i, j)) {
            return true;
        }
        return false;
    }

    public void guardarPartida() {
        if (partidaEnCurs != null) {

            boolean guardar = false;

            if (!controladorPersistence.hiHaPartida(partidaEnCurs.getNomUsuari())) {
                guardar = true;
            } else {
                guardar = presentacio.sobreesciure();
            }

            if (guardar) {

                int status = partidaEnCurs.status();
                int puntuacio = partidaEnCurs.getPuntuacio();
                TipusAdjacencia tipusAdj = partidaEnCurs.getTipusAdjacencia();
                int[][] matriu = partidaEnCurs.getHidato();
                int[][] matriuOriginal = partidaEnCurs.getHidatoOriginal();
                Vector<Integer> nombresDonats = partidaEnCurs.getNombresPerDefecte();
                Vector<Integer> nombresEscrits = partidaEnCurs.getNombresEscrits();
                String nomUsuari = partidaEnCurs.getNomUsuari();
                TipusCella cella = partidaEnCurs.getTipusCella();
                Date dataIni = partidaEnCurs.getDataInici();
                int temps = partidaEnCurs.getTemps();
                controladorPersistence.guardarPartida(dataIni, temps, status, puntuacio, cella, tipusAdj, matriu, matriuOriginal, nombresDonats, nombresEscrits, nomUsuari);

                presentacio.partidaGuardada();
            }

        }
        // status = 0; puntuacio = 0; TipusAdjacencia tipusAdjacencia, int[][] matriu, int[][] matriuOriginal Vector<Integer> nombresEscrits, Vector<Integer> nombresDonats
    }

    public boolean enPartida() {
        return (partidaEnCurs != null);
    }

    public boolean partidaCompletada() {
        return partidaEnCurs.completatHidato();
    }

    public void demanarPista() {
    }

    public boolean esPotSolucionar() {
        return partidaEnCurs.esSolucionable();
    }

    private TipusCella getRandomTipusCella() {
        Random random = new Random();
        int tc = random.nextInt(3);
        if (tc == 0) {
            return TipusCella.QUADRAT;
        }
        if (tc == 1) {
            return TipusCella.TRIANGLE;
        }
        return TipusCella.HEXAGON;
    }

    private TipusAdjacencia getRandomTipusAdjacencia() {
        Random random = new Random();
        int ta = random.nextInt(2);
        if (ta == 0) {
            return TipusAdjacencia.COSTATS;
        }
        return TipusAdjacencia.COSTATSIANGLES;
    }

    public void finalitzarPartida() {
        //presentacio.finalitzarPartida();

        //guardar en la base de dades la partida en la carpeta: user/partides/finalitzades/idPartida
    }

    public void resetMatriuEnPartida() {
        if (partidaEnCurs != null) {
            partidaEnCurs.reset();
        }
    }

    public String[] getHidatos() throws Exception {
        controladorPersistence.carregarHidatoFitxer("hidato1");
        int[][] matriu = controladorPersistence.getMatriuHidato();
        
        
        
        return null;
    }

    public int[][] getMatiu(String nomHidato) throws Exception {
        controladorPersistence.carregarHidatoImportat(nomHidato);
        return controladorPersistence.getMatriuHidato();
    }

    public TipusAdjacencia getTipusAdjacencia(String nomHidato) throws Exception {
        controladorPersistence.carregarHidatoImportat(nomHidato);
        return controladorPersistence.getTipusAdjacenciaHidato();
    }

    public TipusCella getTipusCella(String nomHidato) throws Exception {
        controladorPersistence.carregarHidatoImportat(nomHidato);
        return controladorPersistence.getTipusCellaHidato();
    }

    public String[] getAllHidatoNames() {
        return controladorPersistence.getAllHidatoFileNames();
    }
    
    /*-----------------------------RANKING------------------------------*/

    public void saveScore(Ranking ranking, int dif, int score, String username) {
        controladorPersistence.saveScoreDB(ranking, dif, score, username);
    }

    public String[] getRankingEasy(Ranking r) {
        return controladorPersistence.getRankingEasy(r);
    }    

    public String[] getRankingInter(Ranking r) {
        return controladorPersistence.getRankingInter(r);
    }

    public String[] getRankingHard(Ranking r) {
        return controladorPersistence.getRankingHard(r);
    }

    public Ranking loadRanking() {
        return controladorPersistence.loadRanking();
    }

    public Ranking getRanking() {
        //return controladorPersistence.getRanking();
        
        return ranking;
    }

    public String[] getFilterByUsername(Ranking r, String username, int level) {
        return controladorPersistence.getFilterByUsername(r, username, level);
    }

    public void deteleUserRanking(Ranking r, String nom) {
       controladorPersistence.deteleUserRanking(r, nom);
    }

    public boolean existsUser(Ranking r, String nom) {
        return controladorPersistence.existsUser(r, nom);
    }

    public String[] getFilterByDate(Ranking r, String date, int level) {
        return controladorPersistence.getFilterByDate(r,date, level);
    }

    public boolean existsDate(Ranking r, String date) {
        return controladorPersistence.existsDate(r, date);
    }

    /*-----------------------------USER------------------------------*/

    
    public boolean loginUsuari(String username, String password) throws IOException {
        //return controladorPersistence.loginUsuari(username, password);
        if (controladorPersistence.loginUsuari(username, password)) {
            currentUser = new Usuari(username, password);
        }
        else return false;
        return true;
    }

    public boolean afegirUsuari(String username, String password) throws IOException {
        return controladorPersistence.afegirUsuari(username, password);
    }

    public boolean editUseranme(String currentUsername, String newUsername) {
        //return controladorPersistence.editUseranme(currentUsername, newUsername);
        if (controladorPersistence.editUseranme(currentUsername, newUsername)) {
            currentUser.setUsername(newUsername);
        }
        else return false;
        return true;
    }

    public boolean changePass(String currentPass, String newPass) throws IOException {
        //return controladorPersistence.changePass(currentPass, newPass);
        if (controladorPersistence.changePass(currentPass, newPass)) {
            currentUser.setPassword(newPass);
        }
        else return false;
        return true;
    }

    public boolean deleteUser(String pass) {
        currentUser = null;
        return controladorPersistence.deleteUer(pass);
    }

    public String getUsername() {
        return currentUser.getUsername();
    }

    public Usuari getUser() {
        return currentUser;
    }

    public String getPassword() {
        return currentUser.getPassword();
    }
    

}
