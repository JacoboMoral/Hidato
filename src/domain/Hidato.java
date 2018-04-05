import java.util.ArrayList;


import java.util.Objects;
import java.util.Scanner;

public class Hidato {

    private Tauler tauler;
    private TipusCella tipusCella;
    private TipusAdjacencia tipusAdjacencia;

    public Hidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, ArrayList<ArrayList<String>> tauler){
    		//this.tauler = tauler;
    		this.tipusAdjacencia = tipusAdjacencia;
    		this.tipusCella = tipusCella;
    		//tauler = new Tauler(tauler);
    }
    
    public void addTauler(ArrayList<ArrayList<String>> tauler) {
    		this.tauler = new Tauler (tauler);
    }


    public int getNombreFiles(){
        return tauler.getNombreFiles();

    }

    public int getNombreColumnes(){
        return tauler.getNombreColumnes();

    }
}