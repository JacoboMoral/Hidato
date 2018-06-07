package main.domain.com.hidato;

import java.util.Comparator;
import java.util.Scanner;

import main.persistence.HidatoWriterReader;

import java.util.ArrayList;

//classe que utilitzavem per provar el programa en general. No te cap tipus de formatlitat ni correctesa
public class InteraccioTerminal {

    private ControladorDomini controladorDomini;
    String status = "start";

    public static class CustomCompare implements Comparator<Posicio> {

        @Override
        public int compare(Posicio p1, Posicio p2) {
            return Integer.compare(p1.getScore(), p2.getScore());
        }
    }

    public void start() {
        controladorDomini = new ControladorDomini();
        System.out.println("Benvinguts");
        interactuar(readLine());
    }

    public void interactuar(String req) {
        if (req.equalsIgnoreCase("partida") && status.equals("start")) {
            partida();
            status = "partida";
            interactuar(readLine());
        } else if (req.equalsIgnoreCase("auto") && status.equals("partida")) {
            autogenerar();
        } else if (req.equalsIgnoreCase("importar") && status.equals("partida")) {
            importar();
        } else if (req.equalsIgnoreCase("moviment") && status.equals("jugant")) {
            infoMoviment();
            moviment();
        } else if (req.equalsIgnoreCase("moviment") && status.equals("movimentFet")) {
            moviment();
        } else if (req.equalsIgnoreCase("solucio") && status.equals("jugant")) {
            solucio();
        } else if (req.equalsIgnoreCase("yes") && status.equals("generat")) {
            partidaGenerada();
        } else if (req.equalsIgnoreCase("no") && status.equals("generat")) {
            System.out.println("\n\n Vols saber la solucio del hidato?");
            noPartidaGenerada();
        } else if (req.equalsIgnoreCase("exit") || req.equals("sortir") || req.equals("surt")) {
            System.out.println("Sortint del programa, esperem que torni aviat ..............................................................");
        } else {
            interactuar(readLine());
        }
    }

    private void noPartidaGenerada() {
        System.out.println("\n\n Respon [yes] o [no] \n\n");
        String resposta = readLine();
        if (resposta.equalsIgnoreCase("yes")) {
            HidatoWriterReader.writeHidatoMatrixToOutput(controladorDomini.solucionarHidatoGenerat());
        } else if (resposta.equalsIgnoreCase("no")); else {
            noPartidaGenerada();
        }
    }

    private void partidaGenerada() {
        controladorDomini.jugarHidatoGenerat();
        status = "jugant";
        System.out.println("\n\n Acabas de comencar una nova partida \n\n");
        interactuar(readLine());
    }

    private void solucio() {
        if (status.equals("jugant") || status.equals("movimentFet")) {
            System.out.println("\n\n La solucio del teu hidato es la seguent: \n\n");
            HidatoWriterReader.writeHidatoMatrixToOutput(controladorDomini.solucionarHidatoPartida());
        } else {
            System.out.println("No es pot donar la solucio");
        }
        interactuar(readLine());
    }

    private void infoMoviment() {
        System.out.println("\nFes un moviment, el format sera: [i j v], on:");
        System.out.println("    i = posicio i (comencant per 1) de on es vol colocar el numero");
        System.out.println("    j = posicio j (comencant per 1) de on es vol colocar el numero");
        System.out.println("    v = nombre que es vol colocar al hidato \n");
    }

    private void moviment() {
        int[] numbers = readNumbers(3);
        boolean estatMoviment = controladorDomini.ferMoviment(numbers[0] - 1, numbers[1] - 1, numbers[2], true); //peta amb 1 1 32, ja ho mirare
        if (estatMoviment) {
            System.out.println("\n\n Moviment valid, el hidato queda en el seguent estat:\n\n");
            HidatoWriterReader.writeHidatoMatrixToOutput(controladorDomini.getMatriuHidatoDePartida());
            System.out.println("\nPots fer un altre moviment si ho dessitges\n");
            status = "movimentFet";
            interactuar(readLine());
        } else {
            System.out.println("Moviment no valid, intenta-ho de nou");
            status = "movimentFet";
            interactuar("moviment");
        }
    }

    private void autogenerar() {
        System.out.println("\nEscriu de quin tipus vols l'hidato [Quadrat | Triangle | Hexagon]");
        String cella = readLine();
        TipusCella tc = stringToTipusCella(cella);
        while (tc == null) {
            System.out.println("Escriu be el tipus de hidato");
            cella = readLine();
            tc = stringToTipusCella(cella);
        }

        System.out.println("\nEscriu de quin tipus de adjacencia [Costats | Ambdos (costats i angles)]");
        String adjacencia = readLine();
        TipusAdjacencia ta = stringToTipusAdjacencia(adjacencia);
        while (stringToTipusAdjacencia(adjacencia) == null) {
            System.out.println("Escriu be el tipus d'adjacencia");
            adjacencia = readLine();
            ta = stringToTipusAdjacencia(adjacencia);

        }

        while (tipusNoCompatible(tc, ta)) {
            System.out.println("El tipus d'adjacencia escollit no es compatible amb el tipus de cella, escriu-ho un altre cop");
            adjacencia = readLine();
            ta = stringToTipusAdjacencia(adjacencia);
        }

        System.out.println("\nEscriu el tamany [X] x [Y], exemple: [10 12]");
        String tamanyString = readLine();
        String[] tamanysString = tamanyString.split("\\s+");
        int tamanyi, tamanyj;
        if (tamanysString.length == 1) {
            tamanyi = tamanyj = Integer.parseInt(tamanysString[0]);
        } else {
            tamanyi = Integer.parseInt(tamanysString[0]);
            tamanyj = Integer.parseInt(tamanysString[1]);
        }

        while (tamanyi <= 0 || tamanyj <= 0) {
            System.out.println("Escriu un tamany més gran que 0");
            tamanyString = readLine();
            tamanysString = tamanyString.split("\\s+");
            tamanyi = Integer.parseInt(tamanysString[0]);
            tamanyj = Integer.parseInt(tamanysString[1]);
        }

        System.out.println("\nEscriu el nombre de forats inaccessibles");
        String celesBuidesString = readLine();
        int forats = Integer.parseInt(celesBuidesString);
        while (forats > (tamanyi * tamanyj) / 2) {
            System.out.println("El numero de forats ha de ser mes petit que el nombre total de cel�les entre dos");
            celesBuidesString = readLine();
            forats = Integer.parseInt(celesBuidesString);
        }

        if (controladorDomini.autoGenerar(tc, ta, forats, tamanyi, tamanyj)) {
            System.out.println("Aquest es l'hidato que s'ha generat");
            HidatoWriterReader.writeHidatoMatrixToOutput(controladorDomini.getMatriuHidatoGenerat());
            System.out.println("Vols comen�ar una nova partida amb aquest?\n [yes] \n [no]\n\n");
            //FALTA DECIDIR YES/NO
            status = "generat";
            interactuar(readLine());

        } else {
            System.out.println("No s'ha pogut generar un hidato amb les condicions donades");
        }

    }

    private Dificultat stringToDificultat(String dificultat) {
        if (dificultat.equalsIgnoreCase("facil")) {
            return Dificultat.FACIL;
        }
        if (dificultat.equalsIgnoreCase("mig")) {
            return Dificultat.MIG;
        }
        if (dificultat.equalsIgnoreCase("dificil")) {
            return Dificultat.DIFICIL;
        }
        return null;
    }

    private void importar() {
        System.out.println("\nEscriu el teu hidato per pantalla seguint el format estandar\n\n");
        ArrayList<ArrayList<Integer>> entradaHidato = HidatoWriterReader.readHidatoFromInputClipboard();
        int[][] matriuHidato = extreuMatriuHidato(entradaHidato);
        HidatoWriterReader.writeHidatoMatrixToOutput(matriuHidato);
        TipusCella tipusCella = extreuTipusCella(entradaHidato);
        TipusAdjacencia tipusAdjacencia = extreuTipusAdjacencia(entradaHidato);

        if (tipusNoCompatible(tipusCella, tipusAdjacencia)) {
            System.out.println("Tipus de cella i tipus de adjacencia no son compatibles, torna a importar el hidato sencer");
            interactuar("importar");
        } else {
            if (controladorDomini.jugarHidatoImportat(tipusCella, tipusAdjacencia, matriuHidato)) {
                System.out.println("\n\nHidato importat i validad correctament. El teu hidato es el seguent: \n");
                HidatoWriterReader.writeHidatoMatrixToOutput(controladorDomini.getMatriuHidatoDePartida());
                status = "jugant";
                interactuar(readLine());
            } else {
                System.out.println("\n\nEl hidato importat no es vàlid i per tant no es pot resoldre. Si us plau, escolleix un altre");
                interactuar("importar");
            }
        }
    }

    private void partida() {
        System.out.println("Has seleccionat [partida], si us plau, escull entre una de les seguents opcions:");
        System.out.println("* [carregar] Jugar a una partida anteriorment guardada");
        System.out.println("* [importar] Jugar a una partida amb un hidato importat");
        System.out.println("* [auto] Jugar a una partida amb un hidato autogenerat\n");
    }

    private boolean tipusNoCompatible(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia) {
        return ((tipusCella == TipusCella.HEXAGON && tipusAdjacencia == TipusAdjacencia.COSTATSIANGLES)
                || tipusCella == TipusCella.TRIANGLE && tipusAdjacencia == TipusAdjacencia.COSTATSIANGLES);
    }

    private String readLine() {
        Scanner input = new Scanner(System.in);
        String req = input.nextLine();
        return req;
    }

    private int[] readNumbers(int n) {

        Scanner input = new Scanner(System.in);
        int[] req = new int[3];
        for (int i = 0; i < n; ++i) {
            req[i] = input.nextInt();
        }
        input.nextLine();
        return req;
    }

    private int[][] extreuMatriuHidato(ArrayList<ArrayList<Integer>> matriu) {
        int[][] matriuHidato = new int[matriu.size() - 1][matriu.get(1).size()];
        for (int i = 0; i < matriuHidato.length; ++i) {
            for (int j = 0; j < matriuHidato[1].length; ++j) {
                matriuHidato[i][j] = matriu.get(i + 1).get(j);
            }
        }
        return matriuHidato;
    }

    private TipusAdjacencia extreuTipusAdjacencia(ArrayList<ArrayList<Integer>> matriu) {
        if (matriu.get(0).get(1) == 1) {
            return TipusAdjacencia.COSTATS;
        }
        return TipusAdjacencia.COSTATSIANGLES;
    }

    private TipusCella extreuTipusCella(ArrayList<ArrayList<Integer>> matriu) {
        int aux = matriu.get(0).get(0);
        if (aux == 4) {
            return TipusCella.QUADRAT;
        }
        if (aux == 3) {
            return TipusCella.TRIANGLE;
        }
        return TipusCella.HEXAGON;
    }

    private TipusCella stringToTipusCella(String tc) {
        if (tc.equalsIgnoreCase("Quadrat")) {
            return TipusCella.QUADRAT;
        }
        if (tc.equalsIgnoreCase("Triangle")) {
            return TipusCella.TRIANGLE;
        }
        if (tc.equalsIgnoreCase("Hexagon")) {
            return TipusCella.HEXAGON;
        }
        return null;
    }

    private TipusAdjacencia stringToTipusAdjacencia(String ta) {
        if (ta.equalsIgnoreCase("Costats")) {
            return TipusAdjacencia.COSTATS;
        }
        if (ta.equalsIgnoreCase("Ambdos")) {
            return TipusAdjacencia.COSTATSIANGLES;
        }
        return null;
    }

}
