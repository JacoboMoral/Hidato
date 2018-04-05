
import java.util.Scanner;

public class Main {
    public static void main(String[] args){



        Scanner reader = new Scanner(System.in);  // Reading from System.in
        boolean exit = false;
        while (!exit){

            String n = reader.next();
            if (n.equals("exit")) exit = true;
            if (n.equals("hidato")){
                Hidato hidato = new Hidato();
                //hidato.hidatoWriterToOutput();
            }
        }
        reader.close();
    }
}
