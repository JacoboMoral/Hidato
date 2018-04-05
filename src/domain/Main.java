
import java.util.Scanner;

public class Main {
    public static void main(String[] args){



        Scanner reader = new Scanner(System.in);  // Reading from System.in
        boolean exit = false;
        while (!exit){

            String n = reader.next();
            if (n.equals("exit")) exit = true;
            if (n.equals("hidato")){
            		System.out.println("Hidato seleccionat");
                HidatoIO hidatoIO = new HidatoIO();
                hidatoIO.hidatoReaderFromInput();
                hidatoIO.hidatoWriterToOutput();
                //Hidato hidato = new Hidato(hidatoIO.get
            }
        }
        reader.close();
    }
}
