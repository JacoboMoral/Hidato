import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import main.presentation.ControladorPresentacio;

public class main {

	public static void main(String[] args) throws ParseException {
		ControladorPresentacio.getInstance().launchLogin();
	}
}
