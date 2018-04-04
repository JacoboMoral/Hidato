import java.util.Scanner;
import java.util.Vector;

public class Hidato {

    private Vector<Vector<String>>  tauler = new Vector<Vector<String>>();
    private TipusAdjacencia tipusAdjacencia;
    private TipusCella tipusCella;
    private int nombreFiles;
    private int nombreColumnes;

    public Hidato(){

    }

    public void hidatoReaderFromInput(){
        Scanner reader = new Scanner(System.in);
        String line = reader.nextLine();
        String[] values = line .split(",");

        if (values[0] == "Q") tipusCella = TipusCella.QUADRAT;
        else if (values[0] == "T") tipusCella = TipusCella.TRIANGLE;
        else tipusCella = TipusCella.HEXAGON;

        if (values[1] == "C") tipusAdjacencia = tipusAdjacencia.COSTATS;
        else if (values[1] == "V") tipusAdjacencia = TipusAdjacencia.VERTEXS;
        else tipusAdjacencia = TipusAdjacencia.VERTEXS;

        nombreFiles = Integer.parseInt(values[2]);
        nombreColumnes = Integer.parseInt(values[3]);


        for (int i = 0; i < line.length(); ++i){

        }
    }

    public void hidatoWriterToOutput(){
        //System.out.print(line);
    }

    public void getFiles(){
        System.out.print(nombreFiles);

    }

    public void getColumnes(){
        System.out.print(nombreColumnes);

    }
}
