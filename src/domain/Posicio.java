
public class Posicio {
	private String nickname;
	private int puntuacio;
	private int Date;
	
	public Posicio() {}
	
	public Posicio(String nomJugador, int punts, int Date) {
		this.nickname = nomJugador;
		this.puntuacio = punts;
		this.Date = Date;
	}
	
	public String getNickname() {
		return nickname;
		
	}
	public int getpuntacio() {
		return puntuacio;
	}
	public int getDate() {
		return Date;
		
	}
	public void print() {
		System.out.println("Nickname: " + this.nickname + " Puntuacio: " + this.puntuacio + " Temps: " + this.Date);
	}
}
