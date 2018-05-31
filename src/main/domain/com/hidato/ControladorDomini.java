package main.domain.com.hidato;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Random;
import java.util.Vector;

import main.persistence.ControladorPersistencia;
import main.presentation.ControladorPresentacio;

public class ControladorDomini {

    private static ControladorDomini instance = null;
    private ControladorPresentacio presentacio = ControladorPresentacio.getInstance();
  	private ControladorPersistencia controladorPersistencia = ControladorPersistencia.getInstance();
    private Partida partidaEnCurs = null;
    private Hidato hidatoGenerat = null;
    private Usuari currentUser;
    private Ranking ranking = Ranking.getInstance();

  public static ControladorDomini getInstance() {
		if (instance == null) instance = new ControladorDomini();
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
		if (generat) return true;
		else{
			hidatoGenerat = null;
			return false;
		}
	}

	public boolean autoGenerar(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, Dificultat dificultat) {
		hidatoGenerat = HidatoFactory.createHidato(tipusCella, tipusAdjacencia); //es crea hidato sense matriu
		boolean generat = hidatoGenerat.autogenerar(dificultat);
		if (generat) return true;
		else{
			hidatoGenerat = null;
			return false;
		}
	}

	public boolean autoGenerar(Dificultat dificultat) {
		TipusCella tipusCella = getRandomTipusCella();
		TipusAdjacencia tipusAdjacencia = getRandomTipusAdjacencia();
		hidatoGenerat = HidatoFactory.createHidato(tipusCella, tipusAdjacencia); //es crea hidato sense matriu
		boolean generat = hidatoGenerat.autogenerar(dificultat);
		if (generat) return true;
		else{
			hidatoGenerat = null;
			return false;
		}
	}

	public boolean autoGenerar(TipusCella tipusCella, Dificultat dificultat) {
		if (tipusCella == TipusCella.QUADRAT) {
			TipusAdjacencia tipusAdjacencia = getRandomTipusAdjacencia();
			hidatoGenerat = HidatoFactory.createHidato(tipusCella, tipusAdjacencia); //es crea hidato sense matriu
		}
		else {
			hidatoGenerat = HidatoFactory.createHidato(tipusCella, TipusAdjacencia.COSTATS); //es crea hidato sense matriu
		}
		boolean generat = hidatoGenerat.autogenerar(dificultat);
		if (generat) return true;
		else{
			hidatoGenerat = null;
			return false;
		}
	}

	public int[][] getMatriuHidatoOriginalDePartida(){
		return partidaEnCurs.getHidatoOriginal();
	}

	public int[][] getMatriuHidatoDePartida() {
		return partidaEnCurs.getHidato();
	}

	public int[][] solucionarHidatoPartida() {
		return partidaEnCurs.getSolucio();
	}

	public int[][] solucionarHidatoGenerat() {
		if (hidatoGenerat == null) return null;
		return hidatoGenerat.getSolucio();
	}

	public int[][] getMatriuHidatoGenerat(){
		if (hidatoGenerat == null) return null;
		return hidatoGenerat.getMatriu();
	}

	public Vector<Integer> getNombresPerDefecte(){
		return partidaEnCurs.getNombresPerDefecte();
	}

	public Vector<Integer> getPossiblesMoviments() { //Nombres que hi caben a la matriu - nombresPerDefecte - nombresEscrits
		return partidaEnCurs.getPossiblesMoviments();
	}

	public boolean ferMoviment(int i, int j, int value) {
		if (partidaEnCurs.ferJugada(i, j, value)) return true;
		return false;
	}

	public boolean desferMoviment(int i, int j) {
		if (partidaEnCurs.esborrarNombre(i, j)) return true;
		return false;
	}

	public void guardarPartida() {
		if(partidaEnCurs != null) {
			
			boolean guardar = false;
			
			if(!controladorPersistencia.hiHaPartida(partidaEnCurs.getNomUsuari())) guardar = true;
			
			else guardar = presentacio.sobreesciure();
				
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
				controladorPersistencia.guardarPartida(dataIni, temps, status, puntuacio, cella, tipusAdj, matriu, matriuOriginal, nombresDonats, nombresEscrits, nomUsuari);	

				presentacio.mostraPartidaGuardada();
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
    	controladorPersistencia.carregarHidatoFitxer("hidato1");
        int[][] matriu = controladorPersistencia.getMatriuHidato();
        return null;
    }

    public int[][] getMatiu(String nomHidato) throws Exception {
    	controladorPersistencia.carregarHidatoImportat(nomHidato);
        return controladorPersistencia.getMatriuHidato();
    }

    public TipusAdjacencia getTipusAdjacencia(String nomHidato) throws Exception {
    	controladorPersistencia.carregarHidatoImportat(nomHidato);
        return controladorPersistencia.getTipusAdjacenciaHidato();
    }

    public TipusCella getTipusCella(String nomHidato) throws Exception {
    	controladorPersistencia.carregarHidatoImportat(nomHidato);
        return controladorPersistencia.getTipusCellaHidato();
    }

	public boolean hiHaPartidaGuardada() {
		return controladorPersistencia.hiHaPartida(currentUser.getUsername());
	}
	
	public TipusCella getTipusCellaPartida() {
		return partidaEnCurs.getTipusCella();
	}

	public void carregarPartida(){
		controladorPersistencia.carregarPartida(currentUser.getUsername());
				
		Hidato hidato = HidatoFactory.carregarHidato(controladorPersistencia.getTipusCellaPartida(),
				controladorPersistencia.getTipusAdjacenciaPartida(),
				controladorPersistencia.getMatriuOriginalPartida(),
				controladorPersistencia.getMatriuPartida(),
				controladorPersistencia.getNombresDonatsPartida(),
				controladorPersistencia.getNombresEscritsPartida()
				);

		partidaEnCurs = new Partida(hidato, currentUser);
		partidaEnCurs.setStatus(controladorPersistencia.getStatusPartida());
		partidaEnCurs.setPuntuacio(controladorPersistencia.getPuntuacioPartida());
		partidaEnCurs.setDataInici(controladorPersistencia.getDataIniPartida());
		partidaEnCurs.setTemps(controladorPersistencia.getTempsPartida());
		
		
		/*System.out.println(partidaEnCurs.getNomUsuari());
		System.out.println(partidaEnCurs.getPuntuacio());
		System.out.println(partidaEnCurs.getTemps());
		System.out.println(partidaEnCurs.getDataInici());
		System.out.println(partidaEnCurs.getNombresEscrits());
		System.out.println(partidaEnCurs.getNombresPerDefecte());
		System.out.println(partidaEnCurs.getTipusAdjacencia());
		System.out.println(partidaEnCurs.getTipusCella());
		HidatoIO.writeHidatoMatrixToOutput(partidaEnCurs.getHidato());
		HidatoIO.writeHidatoMatrixToOutput(partidaEnCurs.getHidatoOriginal());*/

		System.out.println(partidaEnCurs.getNombresEscrits());
		System.out.println(partidaEnCurs.getNombresPerDefecte());

		
	}

    public String[] getAllHidatoNames() {
        return controladorPersistencia.getAllHidatoFileNames();
    }
  
  public void guardarHidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matriuHidato, String nomHidato) throws IOException { //es un hidato resoluble
		controladorPersistencia.importarHidato(matriuHidato, tipusCella, tipusAdjacencia, nomHidato);
	}

	public boolean esResoluble(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matriuCreacio) {
		Hidato hidatoPerComprovar = HidatoFactory.createHidato(tipusCella, tipusAdjacencia, matriuCreacio);
		return hidatoPerComprovar.teSolucio();
	}
    
    /*-----------------------------RANKING------------------------------*/

    public void saveScore(int dif, int score, String username) {
        controladorPersistencia.saveScoreDB(ranking, dif, score, username);
    }

    public String[] getRankingEasy() {
        return controladorPersistencia.getRankingEasy(ranking);
    }    

    public String[] getRankingInter() {
        return controladorPersistencia.getRankingInter(ranking);
    }

    public String[] getRankingHard() {
        return controladorPersistencia.getRankingHard(ranking);
    }

    public Ranking loadRanking() {
        return controladorPersistencia.loadRanking();
    }

    public Ranking getRanking() {
        //return controladorPersistencia.getRanking();
        
        return ranking;
    }

    public String[] getFilterByUsername(String username, int level) {
        return controladorPersistencia.getFilterByUsername(ranking, username, level);
    }

    public void deteleUserRanking(String nom) {
       controladorPersistencia.deteleUserRanking(ranking, nom);
    }

    public boolean existsUser(String nom) {
        return controladorPersistencia.existsUser(ranking, nom);
    }

    public String[] getFilterByDate(String date, int level) {
        return controladorPersistencia.getFilterByDate(ranking, date, level);
    }

    public boolean existsDate(String date) {
        return controladorPersistencia.existsDate(ranking, date);
    }

    /*-----------------------------USER------------------------------*/

    
    public boolean loginUsuari(String username, String password) throws IOException {
        //return controladorPersistencia.loginUsuari(username, password);
        if (controladorPersistencia.loginUsuari(username, password)) {
            currentUser = new Usuari(username, password);
        }
        else return false;
        return true;
    }

    public boolean afegirUsuari(String username, String password) throws IOException {
        return controladorPersistencia.afegirUsuari(username, password);
    }

    public boolean editUseranme(String currentUsername, String newUsername) {
        //return controladorPersistencia.editUseranme(currentUsername, newUsername);
        if (controladorPersistencia.editUseranme(currentUsername, newUsername)) {
            currentUser.setUsername(newUsername);
        }
        else return false;
        return true;
    }

    public boolean changePass(String currentPass, String newPass) throws IOException {
        //return controladorPersistencia.changePass(currentPass, newPass);
        if (controladorPersistencia.changePass(currentPass, newPass)) {
            currentUser.setPassword(newPass);
        }
        else return false;
        return true;
    }

    public boolean deleteUser(String pass) {
        currentUser = null;
        return controladorPersistencia.deleteUer(pass);
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

	public boolean comprovarHidatotxt(String ruta) throws Exception {
		controladorPersistencia.carregarHidatoFitxer(ruta);
		if(controladorPersistencia.getTipusCellaHidato() == null) return false;
		if(controladorPersistencia.getTipusAdjacenciaHidato() == null) return false;
		if(controladorPersistencia.getMatriuHidato() == null) return false;
		return true;
	}
	
	
	public void guardarHidatotxt(String nom) throws IOException {
		controladorPersistencia.importarHidato(nom);
	}

	public boolean comprovarHidatotxtResoluble() {
		return esResoluble(controladorPersistencia.getTipusCellaHidato(), controladorPersistencia.getTipusAdjacenciaHidato(), controladorPersistencia.getMatriuHidato());
	}

}
