import java.util.ArrayList;


import java.util.Objects;
import java.util.Scanner;

public class Hidato {

    private ArrayList<String> tauler = new ArrayList<String>();
    private int nombreFiles;
    private int nombreColumnes;
    private TipusCella tipusCella;
    private TipusAdjacencia tipusAdjacencia;

    public Hidato(){

    }


    public void getNombreFiles(){
        System.out.print(nombreFiles);

    }

    public void getNombreColumnes(){
        System.out.print(nombreColumnes);

    }
}
