import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Vector;

import main.*;
import main.domain.com.hidato.Hidato;
import main.domain.com.hidato.HidatoIO;
import main.domain.com.hidato.HidatoQuadrat;
import main.domain.com.hidato.Partida;
import main.domain.com.hidato.TipusAdjacencia;
import main.domain.com.hidato.TipusCella;
import main.persistence.ControladorPersistencia;

public class main2 {
	
	private static ControladorPersistencia persistencia = ControladorPersistencia.getInstance();

	private static int[][] matriu = new int[][] {
		{1,-1,-1},
		{2,11,-1},
		{3,0,0},
		{0,-1,8},
		{5,0,0}
	};

	public static void main(String[] args) throws Exception {
        inici();
	}

	private static void inici() throws Exception {
		
		/*Vector<Integer> v = new Vector<Integer>(4);
	    v.add(1);
		v.add(2);
		v.add(3);
		v.add(4);
		
		persistencia.guardarPartida(1, 150, TipusCella.HEXAGON, TipusAdjacencia.COSTATS, new int[][] {
			{1,2,3,4,5},
			{6,7,8,9,10},
			{11,12,13,14,15},
			{16,17,18,19,20},
			{21,22,23,24,25}
		}, new int[][] {
			{1,2,3,4,5},
			{6,7,8,9,10},
			{11,12,13,14,15},
			{16,17,18,19,20},
			{21,22,23,24,666666}
		}, v, v, "asdsad"); 
		persistencia.carregarPartida("asdsad");
		HidatoIO.writeHidatoMatrixToOutput(persistencia.getMatriu());
		HidatoIO.writeHidatoMatrixToOutput(persistencia.getMatriuOriginal());
		System.out.println(persistencia.getTipusCella());
		System.out.println(persistencia.getTipusAdjacencia());
		System.out.println(persistencia.getStatus());
		System.out.println(persistencia.getTipusCella());
		System.out.println(persistencia.getNombresDonats());*/
		
		persistencia.carregarHidatoFitxer("hola.txt");
		System.out.println(persistencia.getTipusCellaHidato());
		System.out.println(persistencia.getTipusAdjacenciaHidato());
		HidatoIO.writeHidatoMatrixToOutput(persistencia.getMatriuHidato());
		

	}

}
