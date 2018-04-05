import java.util.ArrayList;


import java.util.Objects;
import java.util.Scanner;

public class Hidato {

    private TipusCella tipusCella;
    private TipusAdjacencia tipusAdjacencia;
    private ArrayList<ArrayList<Casella>> matriuCaselles;
    private int nombreFiles;
    private int nombreColumnes;
    

    public Hidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, ArrayList<ArrayList<String>> matriu){
    		this.tipusAdjacencia = tipusAdjacencia;
    		this.tipusCella = tipusCella;
    		nombreFiles = matriu.size();
    		nombreColumnes = matriu.get(0).size();
    		for (int i = 0; i < nombreFiles; ++i) {
    			for (int j = 0; j < nombreColumnes; ++j) {
    				Casella c = new Casella(); 
    				if (matriu.get(i).get(j) == "#");

    			}
    		}
    		
    }
    


    public int getNombreFiles(){
        return nombreFiles;

    }

    public int getNombreColumnes(){
        return nombreColumnes;

    }
}