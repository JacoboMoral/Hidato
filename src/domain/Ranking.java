import java.util.ArrayList;

public class Ranking {
	private ArrayList<Posicio> llistaPosicions = new ArrayList<Posicio>();
	
	public void insertar_posicio(Posicio pos) {
		llistaPosicions.add(pos);
	}
	
	public void delete_by_nickname(String nom) {
		boolean trobat = false;
		int i = 0;
		while (i < llistaPosicions.size() && !trobat) {
			if (llistaPosicions.get(i).getNickname().equals(nom)) {
				System.out.println(llistaPosicions.get(i).getNickname());
				llistaPosicions.remove(i);
				trobat = true;
			}
			i++;
		}
		if (!trobat) System.out.println("No trobat");
	}
	
	public void delete_by_position(int index) {
		llistaPosicions.remove(index);
	}
	
	public void print() {
		for (int i = 0; i < llistaPosicions.size(); i++) {
			llistaPosicions.get(i).print();
		}
	}
	
	
}
