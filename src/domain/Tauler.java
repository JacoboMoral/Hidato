import java.util.ArrayList;

public class Tauler {
	
	private ArrayList<ArrayList<String>> tauler;
	private int nombreFiles;
	private int nombreColumnes;
	
	
    public Tauler(ArrayList<ArrayList<String>> tauler) {
    		this.tauler = tauler;
    		nombreFiles = tauler.size();
    		nombreColumnes = tauler.get(0).size();
    }

	private ArrayList<String> taulell = new ArrayList<String>();


	public int getNombreFiles() {
		return nombreFiles;
	}


	public int getNombreColumnes() {
		return nombreColumnes;
	}
    
}