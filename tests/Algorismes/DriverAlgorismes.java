import java.util.Scanner;


public class DriverAlgorismes {
	public void testConstructor() {
		
	}
	
	
    public static void main(String[] args) throws Exception{
		System.out.println("Aquest es el driver de algorismes, indica quina funcio vols probar");
		//llistaTests();
		
		
	}
	
	public void llistaTests() {
		System.out.println("1: Constructor");
		System.out.println("2: Modificar hidato");
		System.out.println("3: Solucionar");
		System.out.println("4: Solucionador");
		System.out.println("5: tractarMatriuSolucio");
		System.out.println("6: getMatriuSolucio");
		System.out.println("7: obtenirDificultat");
		System.out.println("8: getGiven");
		System.out.println("9: generarComplet");
		System.out.println("10: dinsLimits");
		System.out.println("11: generarHidato");
		System.out.println("12: emplenarForats");
		System.out.println("13: extreureNombres");
		System.out.println("14: generarMatriuCompleta");
	}
	
	private String readLine() {		
		Scanner input = new Scanner(System.in);
		String req = input.nextLine();
		return req;
	}
	
	private int getRequest() {
		String req = readLine();
		if (StringUtils.isNumeric(req)) return 1;
	}
}
