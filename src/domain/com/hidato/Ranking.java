package com.hidato;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Ranking {
	private List<Posicio> llistaPosicions = new ArrayList<Posicio>();
	
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
	
	public void delete_by_date(LocalDate date) {
		int i = 0;
		while (i < llistaPosicions.size()) {
			if (llistaPosicions.get(i).getDate().equals(date)) {
				System.out.println(llistaPosicions.get(i).getDate());
				llistaPosicions.remove(i);
			}
			i++;
		}
	}
	
	public void print() {
		for (int i = 0; i < llistaPosicions.size(); i++) {
			llistaPosicions.get(i).print();
		}
	}

	
}
