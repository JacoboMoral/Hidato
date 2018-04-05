import java.util.ArrayList;


import java.util.Objects;
import java.util.Scanner;

public class Hidato {

    private ArrayList<ArrayList<Integer>> tauler = new ArrayList<ArrayList<Integer>>();
    private int nombreFiles;
    private int nombreColumnes;
    private TipusCella tipusCella;
    private TipusAdjacencia tipusAdjacencia;

    public Hidato(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, ArrayList<ArrayList<Integer>> tauler){
    		this.tauler = tauler;
    		this.tipusAdjacencia = tipusAdjacencia;
    		this.tipusCella = tipusCella;
    		nombreFiles = tauler.size();
    		nombreColumnes = tauler.get(0).size();
    }


    public void getNombreFiles(){
        System.out.print(nombreFiles);

    }

    public void getNombreColumnes(){
        System.out.print(nombreColumnes);

    }
}
