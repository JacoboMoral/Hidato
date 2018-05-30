package main.domain.com.hidato;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

//"static" class
public final class HidatoIO {

    public static ArrayList<ArrayList<Integer>> readHidatoFromInputClipboard() {

        Scanner reader = new Scanner(System.in);
        String line = reader.nextLine();
        String[] values = line.split(",");

        int nombreFiles = Integer.parseInt(values[2]);
        int nombreColumnes = Integer.parseInt(values[3]);

        ArrayList<ArrayList<Integer>> hidato = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> auxLine = new ArrayList<Integer>();

        if (values[0].equals("Q")) {
            auxLine.add(4);
        } else if (values[0].equals("T")) {
            auxLine.add(3);
        } else {
            auxLine.add(6);
        }

        if (values[1].equals("C")) {
            auxLine.add(1);
        } else {
            auxLine.add(2);
        }

        auxLine.add(nombreFiles);
        auxLine.add(nombreColumnes);
        hidato.add(auxLine);

        for (int i = 0; i < nombreFiles; ++i) {
            line = reader.nextLine();
            values = line.split(",");
            auxLine = new ArrayList<Integer>();
            for (int j = 0; j < nombreColumnes; ++j) {
                if (values[j].equals("#")) {
                    auxLine.add(-2);
                } else if (values[j].equals("*")) {
                    auxLine.add(-1);
                } else if (values[j].equals("?")) {
                    auxLine.add(0);
                } else {
                    auxLine.add(Integer.parseInt(values[j]));
                }
            }
            hidato.add(auxLine);
        }
        return hidato;
    }

    public static int[][] readHidatoFromInput1x1() {
        System.out.println("De quina mida ho vols?");
        int[] tamanys = null;
        while (tamanys == null || tamanys.length != 2) {
            System.out.println("Escriu l'altura (i) i despres l'amplada (j), aixi: [5 7]");
            tamanys = getNumeros();
        }
        int tamanyi = tamanys[0];
        int tamanyj = tamanys[1];
        int[][] matriuHidato = new int[tamanyi][tamanyj];
        System.out.println("Hi ha forats?, posa el numero de forats, 0 si no n'hi ha");
        int numForats = -1;
        while (numForats == -1 || numForats > (tamanyi * tamanyj - 1)) {
            if (numForats > (tamanyi * tamanyj - 1)) {
                System.out.println("No pot tenir forats a totes les caselles");
            }
            numForats = getNumero();
        }
        for (int i = 0; i < numForats; ++i) {
            System.out.println("Donam la coordenada i,j del forat numero " + (i + 1));
            int[] coords = null;
            while (coords == null || coords.length != 2) {
                System.out.println("Escriu la coordenada i, despres la coordenada j, aixi: [0 2]");
                coords = getNumeros();
            }
            if (matriuHidato[coords[0]][coords[1]] == 0) {
                matriuHidato[coords[0]][coords[1]] = -1;
                System.out.println("La matriu queda aixi per ara:");
                HidatoIO.writeHidatoMatrixToOutput(matriuHidato);
            } else {
                System.out.println("No pots posar un forat aqui, ja hi havia un");
                --i;
            }
        }

        System.out.println("Ara hauras d'entrar els numeros un a un");
        int numCaselles = tamanyi * tamanyj - numForats;
        for (int i = 0; i < numCaselles; ++i) {
            int[] coords = null;
            System.out.println("Donam la coordenada i,j de la seguent casella " + (i + 1));
            while (coords == null || coords.length != 3) {
                System.out.println("Escriu la coordenada i, despres la coordenada j, i despres el valor aixi: [0 2 14]");
                coords = getNumeros();
                if (coords[0] >= tamanyi || coords[1] >= tamanyj) {
                    coords = null;
                    System.out.println("No pots posar un valor fora de la matriu");
                }
            }
            if (matriuHidato[coords[0]][coords[1]] != 0) {
                System.out.println("No pots posar-ho en aquesta posicio, ja hi havia un numero o forat");
                --i;
            } else {
                matriuHidato[coords[0]][coords[1]] = coords[2];
            }
        }
        return matriuHidato;
    }

    public static void writeHidatoMatrixToOutput(int[][] matrix) {
        System.out.println();
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] > 9) {
                    System.out.print(matrix[i][j]);
                } else if (matrix[i][j] > 0) {
                    System.out.print(" " + matrix[i][j]);
                } else if (matrix[i][j] == 0) {
                    System.out.print("__");
                } else if (matrix[i][j] == -1) {
                    System.out.print("**");
                } else {
                    System.out.print("##");
                }
                if (j != matrix[0].length - 1) {
                    System.out.print("  ");
                }
            }
            System.out.println();
            System.out.println();
        }
    }

    //per generar jocs de prova
    public static void writeHidatoMatrixToOutputFormat(TipusCella tipusCella, TipusAdjacencia tipusAdjacencia, int[][] matrix) {
        System.out.println();
        String primeraLinea = "";
        if (tipusCella == TipusCella.QUADRAT) {
            primeraLinea += "Q,";
        } else if (tipusCella == TipusCella.TRIANGLE) {
            primeraLinea += "T,";
        } else {
            primeraLinea += "H,";
        }
        if (tipusAdjacencia == TipusAdjacencia.COSTATS) {
            primeraLinea += "C,";
        } else {
            primeraLinea += "CA,";
        }
        primeraLinea += matrix.length + "," + matrix[0].length;
        System.out.println(primeraLinea);
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (j < matrix[0].length - 1) {
                    if (matrix[i][j] == -1) {
                        System.out.print("*,");
                    } else {
                        System.out.print(matrix[i][j] + ",");
                    }
                } else {
                    if (matrix[i][j] == -1) {
                        System.out.println("*");
                    } else if (matrix[i][j] == -2) {
                        System.out.println("#");
                    } else {
                        System.out.println(matrix[i][j]);
                    }
                }

            }
        }
    }

    private static String readLine() {
        Scanner input = new Scanner(System.in);
        String req = input.nextLine();
        return req;
    }

    private static int getRequest() {
        String req = readLine();
        if (isNumber(req)) {
            return Integer.parseInt(req);
        } else if (req.equalsIgnoreCase("exit")) {
            return -1;
        } else {
            return 0;
        }
    }

    private static int getNumero() {
        String req = readLine();
        if (isNumber(req)) {
            return Integer.parseInt(req);
        } else {
            return -1;
        }
    }

    private static int[] getNumeros() {
        String req = readLine();
        String[] values = req.split(" ");
        int[] nums = new int[values.length];
        for (int i = 0; i < values.length; ++i) {
            if (isNumber(values[i])) {
                nums[i] = Integer.parseInt(values[i]);
            } else {
                return null;
            }
        }
        return nums;
    }

    private static boolean isNumber(String s) {
        boolean validNumber = false;
        try {
            Integer.parseInt(s);
            //si arriba fins aqui, es un numero
            validNumber = true;
        } catch (NumberFormatException e) {
            //si entra aqui, alhesores ha saltat l'excepcio de que no es pot convertir en numero
        }
        return validNumber;
    }
}
